package edu.ahs.robotics.java;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ArrayListManipulationTest {

    @Test
    public void testRemoveLargestInteger() {
        ArrayList<Integer> myArrayList = new ArrayList<Integer>();
        //myArrayList.add(-1);
        //myArrayList.add(-1);
        //myArrayList.add(-1);
        //myArrayList.add(-9);
        //myArrayList.add(-3);
        // myArrayList.add(-15);

        ArrayList<Integer> expectedReturnedArrayList = new ArrayList<Integer>();

        /*expectedReturnedArrayList.add(-3);
        expectedReturnedArrayList.add(-2);
        expectedReturnedArrayList.add(-9);
        expectedReturnedArrayList.add(-3);
        //expectedReturnedArrayList.add(-15);*/

        ArrayList<Integer> actualReturnedArrayList = ArrayListManipulation.removeLargestInteger(myArrayList);

        assertEquals(expectedReturnedArrayList, actualReturnedArrayList);
    }
}