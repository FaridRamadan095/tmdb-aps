package com.example.proyekjetpack.utils;

import com.example.proyekjetpack.data.MovieEntity;
import com.example.proyekjetpack.data.TvEntity;

import java.util.ArrayList;

public class DataTmdb {

    public static ArrayList<MovieEntity> generateMovieData(){
        ArrayList<MovieEntity> movie = new ArrayList<>();


        movie.add(new MovieEntity("m1",
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "2018-4-27",
                "8.3",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                "Comedy, Crime, Drama",
                null));

        movie.add(new MovieEntity("m2",
                "The Old Man & the Gun",
                "The true story of Forrest Tucker, from his audacious escape from San Quentin at the age of 70 to an unprecedented string of heists that confounded authorities and enchanted the public. Wrapped up in the pursuit are a detective, who becomes captivated with Forrest’s commitment to his craft, and a woman, who loves him in spite of his chosen profession.",
                "2018-9-28",
                "6.3",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/a4BfxRK8dBgbQqbRxPs8kmLd8LG.jpg",
                "Adventure, Action, Fantasy",
                null));

        movie.add(new MovieEntity("m3",
                "Spider-Man: Into the Spider-Verse",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "2018-12-14",
                "8.4",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/iiZZdoQBEYBv6id8su7ImL0oCbD.jpg",
                "Adventure, Action, Science Fiction",
                null));

        movie.add(new MovieEntity("m4",
                "Black Panther",
                "King T'Challa returns home from America to the reclusive, technologically advanced African nation of Wakanda to serve as his country's new leader. However, T'Challa soon finds that he is challenged for the throne by factions within his own country as well as without. Using powers reserved to Wakandan kings, T'Challa assumes the Black Panther mantel to join with girlfriend Nakia, the queen-mother, his princess-kid sister, members of the Dora Milaje (the Wakandan 'special forces') and an American secret agent, to prevent Wakanda from being dragged into a world war.",
                "2018-1-29",
                "7.4",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/uxzzxijgPIY7slzFvMotPv8wjKA.jpg",
                "Adventure, Action, Fantasy, Science Fiction",
                null));

        movie.add(new MovieEntity("m5",
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "2018-10-30",
                "8.3",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                "Drama, Music",
                null));

        movie.add(new MovieEntity("m6",
                "Jurassic World: Fallen Kingdom",
                "Three years after the demise of Jurassic World, a volcanic eruption threatens the remaining dinosaurs on the isla Nublar, so Claire Dearing, the former park manager, recruits Owen Grady to help prevent the extinction of the dinosaurs once again.",
                "201864-22",
                "6.9",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/c9XxwwhPHdaImA2f1WEfEsbhaFB.jpg",
                "Adventure, Fantasy, Family",
                null));

        movie.add(new MovieEntity("m7",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "2018-4-27",
                "8.3",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                "Adventure, Action, Fantasy",
                null));

        movie.add(new MovieEntity("m8",
                "Venom",
                "Investigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote. Soon, he must rely on his newfound powers to protect the world from a shadowy organization looking for a symbiote of their own.",
                "2018-10-5",
                "6.6",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/2uNW4WbgBXL25BAbXGLnLqX71Sw.jpg",
                "Science Fiction, Action",
                null));

        movie.add(new MovieEntity("m9",
                "The Meg",
                "A deep sea submersible pilot revisits his past fears in the Mariana Trench, and accidentally unleashes the seventy foot ancestor of the Great White Shark believed to be extinct.",
                "2018-6-30",
                "5.9",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xqECHNvzbDL5I3iiOVUkVPJMSbc.jpg",
                "Action, Science Fiction, Horror",
                null));

        movie.add(new MovieEntity("m10",
                "Mission: Impossible - Fallout",
                "When an IMF mission ends badly, the world is faced with dire consequences. As Ethan Hunt takes it upon himself to fulfill his original briefing, the CIA begin to question his loyalty and his motives. The IMF team find themselves in a race against time, hunted by assassins while trying to prevent a global catastrophe.",
                "2018-7-27",
                "7.3",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/AkJQpZp9WoNdj7pLYSj1L0RcMMN.jpg",
                "Adventure, Action",
                null));

        return movie;

    }



    public static ArrayList<TvEntity> generateTvData(){

        ArrayList<TvEntity> tv = new ArrayList<>();

        tv.add(new TvEntity("t1",
                "Batwoman",
                "Armed with a great passion for social justice and with a great facility to always say what she thinks, Kate Kane is known in the streets of Gotham as Batwoman, a lesbian highly trained to fight crime that resurfaces in the city. However, before becoming a savior, she must fight the demons that prevent her from being the symbol of the hope of a corrupt city.",
                "2019-10-6",
                "7.0",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/jnaimWkIVSD9IInmZPyLYarSvvc.jpg",
                "Action & Adventure, Sci-Fi",
                null));

        tv.add(new TvEntity("t2",
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "2012-10-10",
                "5.8",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/mo0FP1GxOFZT4UDde7RFDz5APXF.jpg",
                "Crime, Drama, Mystery",
                null));
        tv.add(new TvEntity("t3",
                "Fear the Walking Dead",
                "What did the world look like as it was transforming into the horrifying apocalypse depicted in \"The Walking Dead\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.",
                "2015-8-23",
                "6.3",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lZMb3R3e5vqukPbeDMeyYGf2ZNG.jpg",
                "Drama, Horror",
                null));

        tv.add(new TvEntity("t4",
                "My Hero Academia",
                "In a world where eighty percent of the population has some kind of super-powered Quirk, Izuku was unlucky enough to be born completely normal. But that won’t stop him from enrolling in a prestigious hero academy. Now, he’ll get his first taste of brutal rivalry from other schools as he braves the cutthroat, no-holds-barred provisional license exam.",
                "2068-4-3",
                "7.9",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/47h1ReX6SSqwiTaz3kCC14f0vzt.jpg",
                "Animation, Comedy, Action",
                null));

        tv.add(new TvEntity("t5",
                "Food Wars!: Shokugeki no Soma",
                "Yukihira Souma's dream is to become a full-time chef in his father's restaurant and surpass his father's culinary skill. But just as Yukihira graduates from middle schools his father, Yukihira Jouichirou, closes down the restaurant to cook in Europe. Although downtrodden, Souma's fighting spirit is rekindled by a challenge from Jouichirou which is to survive in an elite culinary school where only 10% of the students graduate. Can Souma survive?",
                "2015-4-4",
                "8.1",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/c1HESLx4JaBW0rsKO3yljuMGCMf.jpg",
                "Animation, Comedy",
                null));

        tv.add(new TvEntity("t6",
                "Supernatural",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way. ",
                "2005-9-13",
                "7.3",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/3iFm6Kz7iYoFaEcj4fLyZHAmTQA.jpg",
                "Drama, Mystery",
                null));

        tv.add(new TvEntity("t7",
                "Rivedale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "2017-1-26",
                "7.1",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/4X7o1ssOEvp4BFLim1AZmPNcYbU.jpg",
                "Science Fiction, Action",
                null));

        tv.add(new TvEntity("t8",
                "South Park",
                "Follows the misadventures of four irreverent grade-schoolers in the quiet, dysfunctional town of South Park, Colorado.",
                "1997-8-13",
                "7.8",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/v9zc0cZpy5aPSfAy6Tgb6I1zWgV.jpg",
                "Comedy, Animation",
                null));

        tv.add(new TvEntity("t9",
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "2005-3-27",
                "6.4",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/jnsvc7gCKocXnrTXF6p03cICTWb.jpg",
                "Drama",
                null));

        tv.add(new TvEntity("t10",
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "1999-1-31",
                "6.6",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gBGUL1UTUNmdRQT8gA1LUV4yg39.jpg",
                "Animation, Comedy",
                null));

        return tv;
    }
}