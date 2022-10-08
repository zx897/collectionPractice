package com.thoughtworks.collection;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Add {
    private boolean isEven(int number) {
        return ((number & 1) == 0);
    }

    private List<Integer> getIntegerList(int leftBorder, int rightBorder){
        ArrayList<Integer> integerList = new ArrayList<>();
        for (int i = leftBorder + 1; i < rightBorder; i++) {
            integerList.add(i);
            }
        return integerList;
    }

    public int getSumOfEvens(int leftBorder, int rightBorder) {
        List<Integer> integerList = getIntegerList(leftBorder,rightBorder);
        if(leftBorder > rightBorder){
            int temp = leftBorder;
            leftBorder = rightBorder;
            rightBorder = temp;
        }
        return (int) IntStream
                .range(leftBorder, rightBorder+1)
                .filter(number->isEven(number))
                .summaryStatistics()
                .getSum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        List<Integer> integerList = getIntegerList(leftBorder,rightBorder);
        if(leftBorder > rightBorder){
            int temp = leftBorder;
            leftBorder = rightBorder;
            rightBorder = temp;
        }
        return (int) IntStream
                .range(leftBorder, rightBorder+1)
                .filter(number->!isEven(number))
                .summaryStatistics()
                .getSum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return (int) arrayList
                .stream()
                .map(number -> number * 3 + 2)
                .mapToInt((x) -> x)
                .summaryStatistics()
                .getSum();

    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        List<Integer> tripleOfOddAndAddTwo = new ArrayList<>();
          arrayList
                .stream()
                .forEach(number -> tripleOfOddAndAddTwo.add(isEven(number) ? number : (number * 3 + 2)));
        return tripleOfOddAndAddTwo;

    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return (int) arrayList
                .stream()
                .filter(number ->!isEven(number))
                .map(number -> number * 3 + 5)
                .mapToInt((x) -> x)
                .summaryStatistics()
                .getSum();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> arrayListEven = arrayList
                .stream()
                .filter(i -> i % 2 != 0)
                .collect(Collectors.toList());
        int count = (int)arrayList
                .stream()
                .filter(i -> i % 2 != 0)
                .mapToInt((x) -> x)
                .summaryStatistics()
                .getCount();
        return (count / 2 == 0) ? (double)(arrayListEven.get(count / 2) + arrayListEven.get((count / 2) + 1))/2 : (double)(arrayListEven.get((count -1) / 2));
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList
                .stream()
                .filter(i -> i % 2 == 0)
                .mapToInt((x) -> x)
                .summaryStatistics()
                .getAverage();
    }


    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {

        return IntStream
                .range(0, arrayList.size())
                .filter(i -> i % 2 == 0)
                .filter(i -> i == specialElment.intValue())
                .findAny()
                .isPresent();


    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList
                .stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> joinedByEvenAndOdd = new ArrayList<Integer>();
        List<Integer> collectEven = arrayList
                .stream()
                .filter(n -> n % 2 == 0)
                .sorted()
                .collect(Collectors.toList());
        List<Integer> collectOdd = arrayList
                .stream()
                .filter(n -> n % 2 != 0)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        joinedByEvenAndOdd.addAll(collectEven);
        joinedByEvenAndOdd.addAll(collectOdd);
        return joinedByEvenAndOdd;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        ArrayList<Integer> processedList = new ArrayList<>();
        for(int i = 0; i < arrayList.size() - 1; i++){
            processedList.add((arrayList.get(i)+ arrayList.get(i+1)) * 3);
        }
        return processedList;
    }
}
