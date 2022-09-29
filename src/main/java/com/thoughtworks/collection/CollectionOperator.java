package com.thoughtworks.collection;


import java.util.*;
import java.util.stream.Collectors;

public class CollectionOperator {
    private boolean isEven(int number) {
        return (number & 1) == 0;
    }

    private List<Integer> getListByOrderedInterval(int left, int right) {
        List<Integer> listByOrderedInterval = new ArrayList<>();
        for (int i = left; i < right + 1; i++) {
            listByOrderedInterval.add(i);
        }
        return listByOrderedInterval;
    }

    public List<Integer> getListByInterval(int left, int right) {
        if (left < right) return getListByOrderedInterval(left, right);
        else {
            List<Integer> listByInterval = getListByOrderedInterval(right,left);
            Collections.reverse(listByInterval);
            return listByInterval;
        }
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        ArrayList<Integer> evenListByIntervals = new ArrayList<>();
        List<Integer> listByInterval;
        if (left < right) {
            listByInterval = getListByInterval(left, right);
        } else {
            listByInterval = getListByInterval(right, left);
            Collections.reverse(listByInterval);
        }
        for (Integer numberByInterval : listByInterval) {
            if (isEven(numberByInterval)) {
                evenListByIntervals.add(numberByInterval);
            }
        }
        return evenListByIntervals;
    }

    public List<Integer> popEvenElments(int[] array) {
        List<Integer> evenElments = new ArrayList<>();
        List<Integer> arrayList = Arrays.stream(array).boxed().collect(Collectors.toList());
        for (Integer anArrayList : arrayList) {
            if (isEven(anArrayList)) {
                evenElments.add(anArrayList);
            }
        }
        return evenElments;
    }

    public int popLastElment(int[] array) {
        List<Integer> arrayList = Arrays.stream(array).boxed().collect(Collectors.toList());
        return arrayList.get(array.length - 1);
    }


    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        ArrayList<Integer> commonElementList = new ArrayList<>();
        List<Integer> firstArrayList = Arrays.stream(firstArray).boxed().collect(Collectors.toList());
        List<Integer> secondArrayList = Arrays.stream(secondArray).boxed().collect(Collectors.toList());
        for (Integer firstArrayNumber : firstArrayList) {
            for (Integer secondArrayNumber : secondArrayList) {
                if (Objects.equals(firstArrayNumber, secondArrayNumber)) {
                    commonElementList.add(firstArrayNumber);
                }
            }
        }
        return commonElementList;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> uncommonElement = new ArrayList<>(List.of(firstArray));
        for (Integer integer : secondArray) {
            if (!uncommonElement.contains(integer)) {
                uncommonElement.add(integer);
            }
        }
        return uncommonElement;
    }

}
