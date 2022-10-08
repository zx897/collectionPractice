package com.thoughtworks.collection;


import java.util.List;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        int maxNumber = this.arrayList.stream().mapToInt(Integer::intValue).max().getAsInt();
        return maxNumber;
    }

    public double getMinimum() {
        int minNumber  = this.arrayList.stream().mapToInt(Integer::intValue).min().getAsInt();
        return minNumber;
    }

    public double getAverage() {
        double averageNumber = this.arrayList.stream().mapToInt((x) -> x).summaryStatistics().getAverage();
        return averageNumber;
    }

    public double getMedian() {
        int length = this.arrayList.size();
        if ((length & 1) == 1) {
            return this.arrayList.get(((length + 1) / 2 - 1));
        }
        return (float) (this.arrayList.get(length / 2 - 1) + this.arrayList.get(length / 2)) / 2;
    }

    public double getOrderedMedian() {

        return this.getMedian();
    }

    public int getFirstEven() {
        int firstEven = this.arrayList.stream().filter(x -> x%2 == 0).findFirst().get();
        return firstEven;
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
