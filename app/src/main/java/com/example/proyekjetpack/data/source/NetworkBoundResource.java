package com.example.proyekjetpack.data.source;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.example.proyekjetpack.data.source.remote.ApiResponse;
import com.example.proyekjetpack.utils.AppExecutors;
import com.example.proyekjetpack.vo.Resource;

public abstract class NetworkBoundResource<ResultType, RequestType> {

    private MediatorLiveData<Resource<ResultType>> result = new MediatorLiveData<>();

    private AppExecutors mExecutors;

    protected void onFetchFailed(){

    }

    protected abstract LiveData<ResultType> loadFromDB();

    protected abstract Boolean sholudFetch(ResultType data);

    protected abstract LiveData<ApiResponse<RequestType>> createCall();

    protected abstract void saveCallResult(RequestType data);

    public NetworkBoundResource(AppExecutors appExecutors){
        this.mExecutors = appExecutors;
        result.setValue(Resource.loading(null));

        LiveData<ResultType> dbSource = loadFromDB();

        result.addSource(dbSource, data -> {
            result.removeSource(dbSource);
            if (sholudFetch(data)){
                fetchFromNetwork(dbSource);
            }else {
                result.addSource(dbSource, newdata -> result.setValue(Resource.success(newdata)));
            }
        });
    }

    private void fetchFromNetwork(LiveData<ResultType> dbSource) {
        LiveData<ApiResponse<RequestType>> apiResponse = createCall();

        result.addSource(dbSource, newData ->
                result.setValue(Resource.loading(newData))
        );

        result.addSource(apiResponse, response -> {

            result.removeSource(apiResponse);
            result.removeSource(dbSource);

            switch (response.status){
                case SUCCESS:
                    mExecutors.diskIO().execute(() -> {

                        saveCallResult(response.body);

                        mExecutors.mainThread().execute(() -> {

                            result.addSource(loadFromDB(),
                                    newData -> result.setValue(Resource.success(newData)));
                        });
                    });
                    break;

                case EMPTY:
                    mExecutors.mainThread().execute(() -> {
                        result.addSource(loadFromDB(),
                                newData -> result.setValue(Resource.success(newData)));
                    });
                    break;

                case ERROR:
                    onFetchFailed();
                    result.addSource(dbSource, newData ->
                            result.setValue(Resource.error(response.message, newData)));
                    break;
            }
        });
    }

    public LiveData<Resource<ResultType>> asLiveData(){
        return result;
    }
}
