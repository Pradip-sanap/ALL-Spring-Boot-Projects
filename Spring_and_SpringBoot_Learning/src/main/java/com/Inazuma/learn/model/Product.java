package com.Inazuma.learn.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component()
@Data
public class Product {
    int pid;
    String pname;
    boolean inStock;
    double price;
    List<String> productIngredients;
    Map<String, String> otherDetails;

}
