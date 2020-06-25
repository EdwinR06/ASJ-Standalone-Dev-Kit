package edu.ahs.robotics.java;

import java.util.ArrayList;

public class ArrayListManipulation {

    ArrayList<String> myList = new ArrayList<String>();
        myList.add("hel");
        myList.add("edwin");
    boolean lookForString = false;
        for (int i = 0; i < myList.size(); i++) {
        if (myList.get(i) == "hello") {
            lookForString = true;
        }
    }



    ArrayList<Integer> myArrayList = new ArrayList<Integer>();
        myArrayList.add(13);
        myArrayList.add(1);
        myArrayList.add(4);
        myArrayList.add(15);
        myArrayList.add(12);
        myArrayList.add(-5);
    double biggestNumber = 0.0;
        for (int i = 0; i < myArrayList.size(); i++) {
        if (myArrayList.get(i) > biggestNumber) {
            biggestNumber = myArrayList.get(i);
        }
    }


    public ArrayList<Integer> removeLargestInteger(ArrayList <Integer> other) {

        ArrayList<Integer> myFinalArray = new ArrayList<>();
        int biggestNumberTwo = 0;
        for (int i = 0; i < other.size(); i++) {
            if (myArrayList.get(i) > biggestNumberTwo) {
                myFinalArray.add(biggestNumberTwo);
                biggestNumberTwo = myArrayList.get(i);
            } else {
                myFinalArray.add(myArrayList.get(i));
            }
        }
        return myFinalArray;
    }


}
