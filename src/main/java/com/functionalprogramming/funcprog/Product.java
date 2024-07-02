package com.functionalprogramming.funcprog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@Slf4j
@Data
@RequiredArgsConstructor
public class Product {

    @NonNull
    String name;

    @Override
    public String toString() {
        return "Product{" +
                "Product name='" + name + '\'' +
                ", price of the item=" + price +
                '}';
    }

    @NonNull
    Double price;
@NonNull
    List<String> category;


}
