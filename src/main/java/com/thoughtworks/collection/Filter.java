package com.thoughtworks.collection;


import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) {
     this.array = array;
    }

    public List<Integer> filterEven() {
        List<Integer> filterEvenList =  this.array
                .stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
        return filterEvenList;
    }

    public List<Integer> filterMultipleOfThree() {
        List<Integer> filterMultipleOfThree = this.array
                .stream()
                .filter(number -> number % 3 == 0)
                .collect(Collectors.toList());
        return filterMultipleOfThree;
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> result = firstList.stream().filter(number -> secondList.contains(number)).collect(Collectors.toList());
        return result;
    }

    public List<Integer> getDifferentElements() {
        List<Integer> differentElements = this.array
                .stream()
                .distinct()
                .collect(Collectors.toList());
        return differentElements;
    }
}

