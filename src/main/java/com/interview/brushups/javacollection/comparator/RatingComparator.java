package com.interview.brushups.javacollection.comparator;

import java.util.Comparator;

/**
 * If we want to sort an object with different or with the custom fields, we can use Comparator interface
 * ~~ Comparable - compareTo() method - comparison between this and the Model object | Model class implements the overridden compareTo Method()
 * ~~ Comparator - compare() method - comparison between two Model object | Model class implements the overridden compare Method()
 */
public class RatingComparator implements Comparator<Movie> {

    /**
     *
     * Once we implement Comparator<Clazz>Model</Clazz> we must override compare() method.
     * Return a positive, 0 or a negative integer as to denote the equality.
     */
    @Override
    public int compare(Movie m1, Movie m2) {
        return m1.getYear()-m2.getYear();
    }
}
