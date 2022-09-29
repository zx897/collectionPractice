package com.thoughtworks.collection;


import java.util.*;

public class Add {
    private boolean isEven(int number) {
        return (number & 1) == 0;
    }

    public int getSumOfEvens(int leftBorder, int rightBorder) {
        if (leftBorder < rightBorder) return getSumOfOrderEvens(leftBorder, rightBorder);
        else return getSumOfOrderEvens(rightBorder, leftBorder);
    }

    private int getSumOfOrderEvens(int leftBorder, int rightBorder) {
        int sumOfEvens = 0;
        for (int i = leftBorder; i < rightBorder + 1; i++) {
            if (isEven(i)) {
                sumOfEvens += i;
            }
        }
        return sumOfEvens;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        if (leftBorder < rightBorder) return getSumOfOrderOdds(leftBorder, rightBorder);
        else return getSumOfOrderOdds(rightBorder, leftBorder);
    }

    private int getSumOfOrderOdds(int leftBorder, int rightBorder) {
        int sumOfOdds = 0;
        for (int i = leftBorder; i < rightBorder + 1; i++) {
            if (!isEven(i)) {
                sumOfOdds += i;
            }
        }
        return sumOfOdds;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        int sumTripleAndAddTwo = 0;
        for (Integer anArrayList : arrayList) {
            sumTripleAndAddTwo += anArrayList * 3 + 2;
        }
        return sumTripleAndAddTwo;
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        List<Integer> tripleOfOddAndAddTwo = new ArrayList<>();
        for (Integer anArrayList : arrayList) {
            if (!isEven(anArrayList)) {
                tripleOfOddAndAddTwo.add(anArrayList * 3 + 2);
            } else tripleOfOddAndAddTwo.add(anArrayList);
        }
        return tripleOfOddAndAddTwo;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        int sumOfProcessedOdds = 0;
        for (Integer anArrayList : arrayList) {
            if (!isEven(anArrayList)) {
                sumOfProcessedOdds += anArrayList * 3 + 5;
            }
        }
        return sumOfProcessedOdds;
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> evenList = getEvenList(arrayList);
        int eventSize = evenList.size();
        if (isEven(eventSize)) {
            return (double) (evenList.get(eventSize / 2) + evenList.get(eventSize / 2 - 1)) / 2;
        }
        return evenList.get((eventSize - 1) / 2);
    }

    private List<Integer> getEvenList(List<Integer> arrayList) {
        List<Integer> evenList = new ArrayList<>();
        for (Integer anArrayList : arrayList) {
            if (isEven(anArrayList)) {
                evenList.add(anArrayList);
            }
        }
        return evenList;
    }

    private List<Integer> getOddList(List<Integer> arrayList) {
        List<Integer> oddList = new ArrayList<>();
        for (Integer anArrayList : arrayList) {
            if (!isEven(anArrayList)) {
                oddList.add(anArrayList);
            }
        }
        return oddList;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        List<Integer> evenList = getEvenList(arrayList);
        int sumOfEvens = 0;
        for (Integer anArrayList : arrayList) {
            if (isEven(anArrayList)) {
                sumOfEvens += anArrayList;
            }
        }
        return (double)sumOfEvens / evenList.size();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        for (Integer anArray : arrayList) {
            if (Objects.equals(anArray, specialElment)) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        List<Integer> evenList = getEvenList(arrayList);
        Set<Integer> set = new HashSet<>(evenList);
        return new ArrayList<>(set);
    }



    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> sortByEvenAndOddList = new ArrayList<>();
        for (int i = 0; i < arrayList.size() - 1; i++) {
            sortByEvenAndOddList.add((arrayList.get(i) + arrayList.get(i + 1)) * 3);
        }
        return sortByEvenAndOddList;
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evenList;
        List<Integer> oddList;
        evenList = getEvenList(arrayList);
        oddList = getOddList(arrayList);
        List<Integer> processedList = new ArrayList<>(evenList);
        Collections.reverse(oddList);
        processedList.addAll(oddList);
        return processedList;
    }
}
