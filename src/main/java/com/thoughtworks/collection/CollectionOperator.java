package com.thoughtworks.collection;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {

        List<Integer> listByInterval = new ArrayList<>();
        if (left > right) {
            int temp = left;
            left = right;
            right = temp;
            IntStream
                .range(left, right + 1)
                .forEach(listByInterval::add);
            Collections.reverse(listByInterval);


        }
        else{
            IntStream
                .range(left, right + 1)
                .forEach(listByInterval::add);}
        return listByInterval;

    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> evenListByIntervals = new ArrayList<>();
        if (left > right) {
            int temp = left;
            left = right;
            right = temp;

            IntStream
                    .range(left, right + 1)
                    .filter(i -> i % 2 == 0)
                    .forEach(evenListByIntervals::add);

            Collections.reverse(evenListByIntervals);

        } else {
            IntStream
                    .range(left, right + 1)
                    .filter(i -> i % 2 == 0)
                    .forEach(evenListByIntervals::add);
        }
        return evenListByIntervals;
    }

    public List<Integer> popEvenElments(int[] array) {

        List<Integer> listByInterval = new ArrayList<>();
        Arrays
                .stream(array)
                .filter(i -> i % 2 == 0)
                .forEach(listByInterval::add);
        return listByInterval;

    }

    public int popLastElment(int[] array) {
        return Arrays
                .stream(array)
                .reduce((first, second) -> second)
//                .getAsInt()
                .orElse(0);


    }


    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        IntStream stream = Arrays.stream(secondArray);
        List<Integer> secondArrayList = stream.boxed().collect(Collectors.toList());

        return Arrays.stream(firstArray).filter(secondArrayList::contains).boxed().collect(Collectors.toList());

    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> firstArrayList = Arrays.asList(firstArray);
        List<Integer> secondArrayList = Arrays.asList(secondArray);
        List<Integer> resultElement = new ArrayList<>();
        List<Integer> unCommonElement = secondArrayList.stream().filter(item -> !firstArrayList.contains(item)).collect(Collectors.toList());
        resultElement.addAll(firstArrayList);
        resultElement.addAll(unCommonElement);
        return resultElement;
    }
}
