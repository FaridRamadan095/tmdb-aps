# tmdb-apps
Aplikasi ini bisa berjalan online dan offline, untuk penyimpanan local menggunakan room
terdapat juga unit testing dan instrumental testing

unit testing:

  -MovieViewModelTest
    -Memuat Movies
     -Memastikan data movie sesuai dengan yang diharapkan

  -TvViewModelTest
    -Memuat Tv
     -Memastikan data tv sesuai dengan yang diharapkan

  -DetailViewModelTest
    -Memuat Detail Movie
     -Memastikan data movie sesuai dengan yang diharapkan

  -DetailViewTvTest
    -Memuat Detail Tv
     -Memastikan data tv sesuai dengan yang diharapkan

  -FavoriteMovieViewModel
    -Memuat favorite movie
     -Memastikan data movie sesuai dengan yang diharapkan

  -FavoriteTvViewModel
    -Memuat favorite tv
     -Memastikan data tv sesuai dengan yang diharapkan
     
Instrumental Testing :

  -MovieFragmentTest:
    -memuat movies:
    -membuka halaman MovieFragment
    -memastikan RecyclerView dalam keadaan tampil
    -memastikan jumlah item RecyclerView sesuai dengan yang diharapkan

  -TvFragmentTest:
    -memuat tv:
    -membuka halaman TvFragmentTest
    -memastikan RecyclerView dalam keadaan tampil
    -memastikan jumlah item RecyclerView sesuai dengan yang diharapkan

  -DetailMovieActivityTest:
    -memuat movies:
    -membuka halaman DetailMovieActivity;
    -memastikan Texview untuk titlemovie sudah tampil
    -memastikan value dari titlemovie sesuai dengan yang diharapkan
    -memastikan Texview untuk overviewmovie sudah tampil
    -memastikan value dari overviewmovie sesuai dengan yang diharapkan
    -memastikan Texview untuk genremovie sudah tampil
    -memastikan value dari genremovie sesuai dengan yang diharapkan
    -memastikan Texview untuk releasemovie sudah tampil
    -memastikan value dari releasemovie sesuai dengan yang diharapkan
    -memastikan ImageView untuk imgbackmovie sudah tampil
    -memberi aksi klik pada imgbackmovie

  -DetailTvActivityTest:
    -memuat tv:
    -membuka halaman DetailTvActivity
    -memastikan Texview untuk titletv sudah tampil
    -memastikan value dari titletv sesuai dengan yang diharapkan
    -memastikan Texview untuk overviewtv sudah tampil
    -memastikan value dari overviewtv sesuai dengan yang diharapkan
    -memastikan Texview untuk genretv sudah tampil
    -memastikan value dari genretv sesuai dengan yang diharapkan
    -memastikan Texview untuk releasetv sudah tampil
    -memastikan value dari releasetv sesuai dengan yang diharapkan
    -memastikan ImageView untuk imgbacktv sudah tampil
    -memberi aksi klik pada imgbacktv 

  -ProyekJetpackTest:
   -Berpindah ke DetailMovieActivity:
    -membuka halaman HomeActivity
    -memastikan RecyclerView sudah tampil
    -memberi aksi klik di item pertama RecyclerView
    -memastikan TextView untuk titlemovie sudah tampil
    -memastikan value dari titlemovie sesuai dengan yang diharapkan

   -Berpindah ke DetailTvActivity:
    -membuka halaman HomeActivity
    -memastikan Navigation untuk actiontv sudah tampil
    -memberi aski klik pada Navigation actiontv
    -berpindah ke FragmentTv
    -memastikan RecyclerView sudah tampil
    -memberi aksi klik di item pertama RecyclerView
    -memastikan TextView untuk titletv sudah tampil
    -memastikan value dari titletv sesuai dengan yang diharapkan
