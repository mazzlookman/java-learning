package com.tutorial.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableApp {
    public static void main(String[] args) {

        List<String> one = Collections.singletonList("satu");
        List<String> empty = Collections.emptyList();

        List<String> muttable = new ArrayList<>();
        muttable.add("Bella");
        muttable.add("Rizky");
        muttable.add("Kharisma");

        //List<String> immutable = Collections.unmodifiableList(muttable);

        List<String> elements = List.of("Hai","Apa","Kabar");
        elements.add("Budi");

    }
}
