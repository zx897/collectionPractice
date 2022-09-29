package com.thoughtworks.collection;


import java.util.ArrayList;
import java.util.List;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) {
     this.array = array;
    }

    private boolean isEven(int number){
        return (number & 1) == 0;
    }

    public List<Integer> filterEven(){
        List<Integer> filterEvenList = new ArrayList<>();
        for(Integer anArrayList : this.array){
            if(isEven(anArrayList)){
                filterEvenList.add(anArrayList);
            }
        }
        return filterEvenList;
    }

    public List<Integer> filterMultipleOfThree() {
        List<Integer> filterMultipleOfThreeList = new ArrayList<>();
        for(Integer anArrayList : this.array){
            if(anArrayList % 3 == 0){
                filterMultipleOfThreeList.add(anArrayList);
            }
        }
        return filterMultipleOfThreeList;
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        ArrayList<Integer> commonElementsList = new ArrayList<>();
        for(Integer number : secondList){
            if(firstList.contains(number)){
                commonElementsList.add(number);
            }
        }
        return commonElementsList;
    }

    public List<Integer> getDifferentElements() {
        ArrayList<Integer> commonElementsList = new ArrayList<>();
        for(Integer number : this.array){
            if(!commonElementsList.contains(number)){
                commonElementsList.add(number);
            }
        }
        return commonElementsList;
    }
}