package com.thoughtworks.collection;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        {
            this.array = array;
        }
    }


    public List<Integer> transformToOneDimesional() {
        List<Integer> collect = Arrays.stream(this.array).flatMap(Arrays::stream).collect(Collectors.toList());
        return collect;

    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        List<Integer> collect = Arrays.stream(this.array).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        return collect;
    }
}
