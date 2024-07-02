package com.functionalprogramming.funcprog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@Slf4j
@RequestMapping(path = "/myfuncprog")
public class StreamController {

    @GetMapping(path = "streams")
    public String performStreamOperations() {

        //Creating a Stream from a fixed number of integers
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7);
        stream.forEach(System.out::println);

        //Creating Stream from an String array
        Stream<String> stream1 = Stream.of(new String[]{"Viv", "Sonu", "Miraya"});
        stream1.forEach(System.out::println);

        //Creating stream from a List
        List<String> list = new ArrayList<>();

        list = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        list.reversed().forEach(System.out::println);

        Stream<String> stream2 = list.stream();
        stream2.forEach(System.out::println);

        Stream<String> stream3 = list.stream();
        List<String> list4 = stream3.filter(s -> s.startsWith("R")).toList();
        list4.forEach(System.out::println);

        Stream<String> stream5 = Stream.empty();
        System.out.println(stream5.count());

        Stream<String> stream6 = Stream.empty();
        stream6.forEach(System.out::println);

        Stream<String> stream7 = list.stream();
        System.out.println(stream7.anyMatch(s->s.startsWith("F")));

        List<Product> products = Arrays.asList(
                new Product("Laptop", 1000.00, Arrays.asList("Electronics", "Computers")),
                new Product("Shirt", 20.00, Arrays.asList("Clothes", "Apparels")),
                new Product("Phone", 500.00, Arrays.asList("Media", "Communication"))
        );

        List<Object> abc = products.stream().flatMap(s-> s.getCategory().stream()).collect(Collectors.toList());


        System.out.println(abc);


        return "abc";
    }
}
