package com.interview.brushups.javacollection.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Caller {

    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        Movie movie1 = new Movie(5, 2010, 2, "Die Another Day");
        Movie movie2 = new Movie(6, 2002, 5, "Harry Potter");
        Movie movie3 = new Movie(2, 2015, 3, "Dracula");
        Movie movie4 = new Movie(3, 2006, 5, "Double Dragon");
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        System.out.println(movies);
        Collections.sort(movies, (m1,m2)-> m2.rating - m1.rating);
        //Collections.sort(movies);
        System.out.println(movies);
    }
}
