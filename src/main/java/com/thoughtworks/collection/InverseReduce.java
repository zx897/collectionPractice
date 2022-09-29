package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InverseReduce {

    private Random random;

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        int givnNumber = random.nextInt(3);
        int leftNumber = number;
        ArrayList<Integer> divideResult = new ArrayList<>();
        if (leftNumber > givnNumber) {
            while ((leftNumber - givnNumber) > 0) {
                leftNumber -= givnNumber;
                divideResult.add(leftNumber);
            }
        } else divideResult.add(leftNumber);


        return divideResult;
    }
}
