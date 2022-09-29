package com.thoughtworks.collection;


import java.util.List;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        int maximumNumber = 0;
        for (Integer integer : arrayList) {
            if (integer > maximumNumber) {
                maximumNumber = integer;
            }
        }
        return maximumNumber;
    }

    public double getMinimum() {
        int minimumNumber = arrayList.get(0);
        for (Integer integer : arrayList) {
            if (integer < minimumNumber) {
                minimumNumber = integer;
            }
        }
        return minimumNumber;
    }


    public double getAverage() {
        int sumNumber = 0;
        for (Integer integer : arrayList) {
            sumNumber += integer;
        }
        return (double)sumNumber/arrayList.size();
        }

    public double getMedian() {
        int length = this.arrayList.size();
        if (isOdd(length)) {
            return this.arrayList.get(((length + 1) / 2 - 1));
        }
        return (float) (this.arrayList.get(length / 2 - 1) + this.arrayList.get(length / 2)) / 2;
    }

    private static boolean isOdd(int length) {
        return (length & 1) == 1;
    }

    public double getOrderedMedian() {
        return this.getMedian();
    }

    public int getFirstEven() {
        for (Integer element : this.arrayList) {
            if ((element & 1) == 0) {
                return element;
            }
        }
        return 0;
    }

    public int getIndexOfFirstEven() {
        for (int i = 0; i < this.arrayList.size() - 1; i++) {
            if ((this.arrayList.get(i) & 1) == 0) {
                return i;
            }
        }
        return 0;
    }

    public boolean isEqual(List<Integer> arrayList) {
        return this.arrayList.equals(arrayList);
    }

    public int getLastOdd() {
        int temp = this.arrayList.get(0);
        for (Integer integer : this.arrayList) {
            if ((integer & 1) == 1) {
                temp = integer;
            }
        }
        return temp;
    }

    public int getIndexOfLastOdd() {
        int index = 0;
        for (int i = 0; i < this.arrayList.size(); i++) {
            if ((this.arrayList.get(i) & 1) == 1) {
                index = i;
            }
        }
        return index;
    }
}