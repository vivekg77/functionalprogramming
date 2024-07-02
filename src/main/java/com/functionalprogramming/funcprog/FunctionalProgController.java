package com.functionalprogramming.funcprog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/myfuncprog")
public class FunctionalProgController {

    @GetMapping(path = "/message")
    public String printMessage() {
        //Converting an array of Strings in a java.util>List object and assign to it.
        final List<String> friends =
                Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        System.out.println(String.join(", ", friends));
        //map operation Returns a stream consisting of the results of applying the
        // given function to the elements of this stream.
        //Collectors.joining() operation Returns a Collector object that
        // concatenates the input elements into a String, in encounter order.
        String str1 = friends.stream().map(m -> m.toUpperCase()).collect(Collectors.joining(" "));
        String str2 = friends.stream().map(String::toUpperCase).collect(Collectors.joining(" "));


        System.out.println(friends.stream().count());
        System.out.println((long) friends.size());

        String str = String.join(" ", friends);

        Function<String, Predicate<String>> startsWithLetter = letter -> name -> name.startsWith(letter);

        friends.stream().map(String::toUpperCase).filter(startsWithLetter.apply("N")).forEach(s -> System.out.println(s));
        friends.stream().map(String::toUpperCase).filter(startsWithLetter.apply("B")).forEach(System.out::println);

        friends.stream().map(String::toLowerCase).filter(s-> s.startsWith("s")).forEach(System.out::println);
        List<String> newList = friends.stream().map(String::toLowerCase).filter(s-> s.startsWith("s")).toList();
        System.out.println("New List :: " + newList);




        return "Bring the life back on track " + str1;
    }




}
