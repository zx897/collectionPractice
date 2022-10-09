package com.thoughtworks.collection;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Flaten {

    Integer[][] array;

    public Flaten(Integer[][] array) {
        {
            this.array = array;
        }
    }


    public List<Integer> transformToOneDimesional() {
        return Arrays.stream(this.array).flatMap(Arrays::stream).collect(Collectors.toList());

    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        return Arrays.stream(this.array).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
    }
}
