package com.interview.brushups.jdk;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JDK8StreamTimeAPI {

    public static void main(String[] args) {

        //4. Stream APIs

        // create a list of string
        List<Integer> listOfCharacter = Arrays.asList(90, 60, 20, 10, 25, 60);

        //Create a sequential stream of String by calling the stream() method
        Stream<Integer> characterStream = listOfCharacter.stream();

        //Create a parallel stream of String by calling the parallelStream() method
        Stream<Integer> characterParallelStream = listOfCharacter.parallelStream();

        // call out the forEach() method in the stream
        characterStream.forEach(x -> System.out.print(x + " "));
        System.out.println("<-- Sequential Stream of characterStream ");

        //using lambda with Stream API, filter example
        Stream<Integer> numberGreater20 = characterParallelStream.filter(p -> p > 20);

        /**
         *  using lambda in forEach
         *  Note : If we perform forEach Operation on Stream.
         *  We can't perform another operation such as collect() or forEach again
         */

//        numberGreater20.forEach(p -> System.out.print(p+" "));
//        System.out.println("<-- Filter and parallel Stream of characterStream ");

        List<Integer> filteredList = numberGreater20.collect(Collectors.toList());
        for (Integer number : filteredList) {
            System.out.print(number + " ");
        }

        //4. Date and Time API - java.time.*
        System.out.println("Java Date and Time\n");

        /**
         * Java has introduced a new Date and Time API since Java 8.
         * The java.time package contains Java 8 Date and Time classes.
         */
        LocalDate date = LocalDate.now();
        LocalDate yesterday = date.minusDays(1);
        LocalDate tomorrow = yesterday.plusDays(2);
        System.out.println("Today's date: " + date);
        System.out.println("Yesterday's date: " + yesterday);
        System.out.println("Tomorrow's date: " + tomorrow);
    }
}
