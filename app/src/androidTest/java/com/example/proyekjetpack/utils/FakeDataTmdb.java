package com.example.proyekjetpack.utils;

import com.example.proyekjetpack.data.source.remote.response.GenreModel;
import com.example.proyekjetpack.data.source.remote.response.MovieDetail;
import com.example.proyekjetpack.data.source.remote.response.MovieModel;
import com.example.proyekjetpack.data.source.remote.response.TvShowDetail;
import com.example.proyekjetpack.data.source.remote.response.TvShowModel;

import java.util.ArrayList;

public class FakeDataTmdb {

    public static ArrayList<MovieDetail> generateMovieDetail(){
        ArrayList<MovieDetail> movie = new ArrayList<>();

        ArrayList<GenreModel> genreModels = new ArrayList<>();


        movie.add(new MovieDetail(475557,
                "Joker",
                "8.6",
                "/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg",
                "/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg",
                "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
                "2019-10-02",
                false,
                FakeDataGenre.generateGenreMovie(475557)));

        movie.add(new MovieDetail(420809,
                "Maleficent: Mistress of Evil",
                "7.2",
                "/skvI4rYFrKXS73BJxWGH54Omlvv.jpg",
                "/tBuabjEqxzoUBHfbyNbd8ulgy5j.jpg",
                "Maleficent and her goddaughter Aurora begin to question the complex family ties that bind them as they are pulled in different directions by impending nuptials, unexpected allies, and dark new forces at play.",
                "2019-10-18",
                false,
                FakeDataGenre.generateGenreMovie(420809)));


        movie.add(new MovieDetail(290859,
                "Terminator: Dark Fate",
                "6.7",
                "/vqzNJRH4YyquRiWxCCOH0aXggHI.jpg",
                "/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg",
                "More than two decades have passed since Sarah Connor prevented Judgment Day, changed the future, and re-wrote the fate of the human race. Dani Ramos is living a simple life in Mexico City with her brother and father when a highly advanced and deadly new Terminator – a Rev-9 – travels back through time to hunt and kill her. Dani's survival depends on her joining forces with two warriors: Grace, an enhanced super-soldier from the future, and a battle-hardened Sarah Connor. As the Rev-9 ruthlessly destroys everything and everyone in its path on the hunt for Dani, the three are led to a T-800 from Sarah’s past that may be their last best hope.",
                "2019-11-01",
                false,
                FakeDataGenre.generateGenreMovie(290859)));

        movie.add(new MovieDetail(420818,
                "The Lion King",
                "7.6",
                "/nRXO2SnOA75OsWhNhXstHB8ZmI3.jpg",
                "/2bXbqYdUdNVa8VIWXVfclP2ICtT.jpg",
                "Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.",
                "2019-07-19",
                false,
                FakeDataGenre.generateGenreMovie(420818)));

        movie.add(new MovieDetail(429617,
                "Spider-Man: Far from Home",
                "8.6",
                "/5myQbDzw3l8K9yofUXRJ4UTVgam.jpg",
                "/lcq8dVxeeOqHvvgcte707K0KVx5.jpg",
                "Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent.",
                "2019-07-02",
                false,
                FakeDataGenre.generateGenreMovie(429617)));

        return movie;

    }



    public static ArrayList<TvShowDetail> generateTvDetail(){

        ArrayList<TvShowDetail> tv = new ArrayList<>();

        ArrayList<GenreModel> genreModels = new ArrayList<>();

        tv.add(new TvShowDetail(1412,
                "Arrow",
                "5.8",
                "/dKxkwAJfGuznW8Hu0mhaDJtna0n.jpg",
                "/mo0FP1GxOFZT4UDde7RFDz5APXF.jpg",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "2012-10-10",
                false,
                FakeDataGenre.generateGenreTv(1412)));

        tv.add(new TvShowDetail(62286,
                "Fear the Walking Dead",
                "6.3",
                "/7r4FieFH6Eh6S55hi8c9LOiFENg.jpg",
                "/lZMb3R3e5vqukPbeDMeyYGf2ZNG.jpg",
                "What did the world look like as it was transforming into the horrifying apocalypse depicted in \\\"The Walking Dead\\\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.",
                "2015-08-23",
                false,
                FakeDataGenre.generateGenreTv(62286)));

        tv.add(new TvShowDetail(60735,
                "The Flash",
                "6.7",
                "/jC1KqsFx8ZyqJyQa2Ohi7xgL7XC.jpg",
                "/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "2014-10-07",
                false,
                genreModels));

        tv.add(new TvShowDetail(1622,
                "Supernatural",
                "7.4",
                "/o9OKe3M06QMLOzTl3l6GStYtnE9.jpg",
                "/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way. ",
                "2005-09-13",
                false,
                FakeDataGenre.generateGenreTv(1622)));

        tv.add(new TvShowDetail(69050,
                "Riverdale",
                "7.2",
                "/2IUpoKSP64r6rp2vBo0Fdk8a1UU.jpg",
                "/4X7o1ssOEvp4BFLim1AZmPNcYbU.jpg",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "2017-01-26",
                false,
                FakeDataGenre.generateGenreTv(69050)));

        return tv;
    }
}
