package com.interview.brushups.javacollection.comparator;

public class Movie implements Comparable<Movie>{

    private int id;
    private int year;
    private int rating;
    private String name;

    public Movie(int id, int year, int rating, String name) {
        this.id = id;
        this.year = year;
        this.rating = rating;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", year=" + year +
                ", rating=" + rating +
                ", name='" + name + '\'' +
                '}';
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Movie o) {
        return this.id-o.getId();
    }
}
