package com.thoughtworks.collection;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {

        List<Integer> listByInterval = new ArrayList<>();
        if (left > right) {
            int temp = left;
            left = right;
            right = temp;
        }
        IntStream
                .range(left, right + 1)
                .forEach(number -> listByInterval.add(Integer.valueOf(number)));
        if (left > right) {
            Collections.reverse(listByInterval);
        }
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

        }
        else{
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
            .forEach(student -> listByInterval.add(student));
        return listByInterval;

    }

    public int popLastElment(int[] array) {
        return Arrays
                .stream(array)
                .reduce((first, second) -> second)
                .getAsInt();
        }


    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
//        List<Integer> secondArrayList = Stream.of(secondArray).boxed().collect(Collectors.toList());

        IntStream stream = Arrays.stream(secondArray);
        List<Integer> secondArrayList= stream.boxed().collect(Collectors.toList());

        return Arrays.stream(firstArray).filter(item -> secondArrayList.contains(item)).boxed().collect(Collectors.toList());

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
