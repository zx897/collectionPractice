package com.thoughtworks.collection;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        List<Integer> tripleList = this.array
                .stream()
                .map(number -> number * 3)
                .collect(Collectors.toList());
        return tripleList;
    }
    public List<String> mapLetter() {
        List<String> mapLetterList = this.array
                .stream()
                .map(i -> this.letterList.get(i - 1))
                .collect(Collectors.toList());
        return mapLetterList;
    }

    public List<String> mapLetters() {
            List<String> mapLetterList = new ArrayList<>();
            for (Integer integer : this.array) {
                String resultString = "";
                int multiNumber;
                int cycleNumber = integer - 1;
                if (cycleNumber >= 26) {
                    multiNumber = cycleNumber / 26 - 1;
                    resultString += this.letterList.get(multiNumber);
                }
                resultString += this.letterList.get(cycleNumber % 26);
                mapLetterList.add(resultString);
            }
            return mapLetterList;
    }

    public List<Integer> sortFromBig() {
            for (int i = 0; i < this.array.size() - 1; i++) {// ---》for循环选取第一个数
                for (int j = 0; j < this.array.size() - 1 - i; j++) {// 原数组中，取出第一个数之后，相邻的另外一个数
                    if (this.array.get(j) < this.array.get(j + 1)) {
                        Integer temp = this.array.get(j);
                        this.array.set(j, this.array.get(j + 1));
                        this.array.set(j + 1, temp);
                    }
                }

            }
            return this.array;
    }

    public List<Integer> sortFromSmall() {
        for (int i = 0; i < this.array.size() - 1; i++) {// ---》for循环选取第一个数
            for (int j = 0; j < this.array.size() - 1 - i; j++) {// 原数组中，取出第一个数之后，相邻的另外一个数
                if (this.array.get(j) > this.array.get(j + 1)) {
                    Integer temp = this.array.get(j);
                    this.array.set(j, this.array.get(j + 1));
                    this.array.set(j + 1, temp);
                }
            }

        }
        return this.array;
    }
}



