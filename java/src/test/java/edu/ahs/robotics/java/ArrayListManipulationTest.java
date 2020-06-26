package edu.ahs.robotics.java;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ArrayListManipulationTest {

    @Test
    public void testRemoveLargestInteger() {
        ArrayList<Integer> myArrayList = new ArrayList<Integer>();
        myArrayList.add(4);
        myArrayList.add(1);
        myArrayList.add(-5);
        myArrayList.add(12);
        myArrayList.add(13);
        myArrayList.add(15);

        ArrayList<Integer> expectedReturnedArrayList = new ArrayList<Integer>();

        expectedReturnedArrayList.add(-5);
        expectedReturnedArrayList.add(1);
        expectedReturnedArrayList.add(4);
        expectedReturnedArrayList.add(12);
        expectedReturnedArrayList.add(13);

        ArrayList<Integer> actualReturnedArrayList = new ArrayList<Integer>(ArrayListManipulation.removeLargestInteger(myArrayList));

        assertEquals(expectedReturnedArrayList, actualReturnedArrayList);
    }
}