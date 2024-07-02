package com.functionalprogramming.funcprog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class FuncprogApplication {

    public static void main(String[] args) {

        SpringApplication.run(FuncprogApplication.class, args);

        List<Product> products = Arrays.asList(
                new Product("Laptop", 1000.00, Arrays.asList("Electronics", "Computers")),
                new Product("Shirt", 20.00, Arrays.asList("Clothes", "Apparels")),
                new Product("Phone", 500.00, Arrays.asList("Media", "Communication"))
        );

        //Sort the list by name
        products.stream().sorted(Comparator.comparing(p -> p.name)).forEach(System.out::println);

        //Sort by price
        List<Product> product1 = products.stream().sorted(Comparator.comparingDouble(p -> p.price)).collect(Collectors.toList());
        List<Product> product2 = products.stream().sorted(Comparator.comparingDouble(p -> p.price)).toList();

        product1.forEach(System.out::println);

        Stream<Integer> stream
                = Stream.of(2, 17, 5,
                20, 17, 30,
                4, 23, 59, 23);

        System.out.println(findDuplicateItems(stream));
        Stream<Integer> stream1
                = Stream.of(2, 17, 5,
                20, 17, 30,
                4, 23, 59, 23);

        System.out.println(findDuplicates.apply(stream1));

        Stream<Integer> stream2
                = Stream.of(2, 17, 5,
                20, 17, 30,
                4, 23, 59, 23);

        System.out.println(countElement.apply(stream2));

        Stream<Integer> stream3
                = Stream.of(2, 17, 5,
                20, 17, 30,
                4, 23, 59, 23);

        System.out.println(countAnElement.apply(stream3, 23));

        Stream<Integer> stream4
                = Stream.of(2, 17, 5,
                20, 17, 30,
                4, 23, 59, 23);

        System.out.println(sliceOfStream.apply(stream4, 3, 8).toList());


    }

    public static <T> Set<T> findDuplicateItems(Stream<T> stream){

        Set<T> set1 = new HashSet<>();

        return stream.filter(set1::add).collect(Collectors.toSet());

    }

    static Function < Stream<Integer>, Set<Integer>> findDuplicates = (stream)-> {

        Set<Integer> s1 = new HashSet<>();

        return stream.filter(num-> !s1.add(num)).collect(Collectors.toSet());
    };

    static Function <Stream<Integer>, Integer> countElement = (stream)-> Math.toIntExact(stream.filter(num -> num.equals(17)).count());

    static BiFunction <Stream<Integer>, Integer, Long> countAnElement = (stream, n)-> {

        return stream.filter(num-> num == n).count();
    };

    static TriFunction <Stream<Integer>, Integer, Integer, Stream<Integer>> sliceOfStream =
            (stream, n, m)-> {

         return stream.skip(n)
        .limit(m - n);


            };


}
