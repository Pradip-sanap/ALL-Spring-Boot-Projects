package com.security;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class Shortcuts {
    private void error(){
        HashMap<Integer, String> str = new HashMap<>();
        Predicate<String> pred = s -> s.contains("ab");

        String[] stringArray = {"sdf","asdfa","erew"};

        Arrays.sort(stringArray, String::compareToIgnoreCase);












    }
}
