package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Flaten {

    Integer[][] array;

    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        List<Integer> formToOneDimesionalList = new ArrayList<>();
        for (Integer[] integers : this.array) {
            Collections.addAll(formToOneDimesionalList, integers);
        }
        return formToOneDimesionalList;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        List<Integer> transformToUnrepeatedOneDimesional = new ArrayList<>();
        List<Integer> formToOneDimesionalList = transformToOneDimesional();
        for (Integer integer : formToOneDimesionalList) {
            if (!transformToUnrepeatedOneDimesional.contains(integer)) {
                transformToUnrepeatedOneDimesional.add(integer);
            }
        }
        return transformToUnrepeatedOneDimesional;
    }
}
