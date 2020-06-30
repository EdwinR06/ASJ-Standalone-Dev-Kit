package edu.ahs.robotics.java;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListManipulation {

    public boolean lookForString(){
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("hel");
        myList.add("edwin");
        boolean lookForString = false;
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i) == "hello") {
            lookForString = true;
            }
        }
        return lookForString;
    }



   public double biggestNumber(){
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
       return biggestNumber;
   }



    public static ArrayList<Integer> removeLargestInteger(ArrayList <Integer> other) {
        if(other.size() == 0){
            throw new IllegalArgumentException("Must have at least one element.");
        }
        ArrayList<Integer> retVal = new ArrayList<>();
        //int largest = Integer.MIN_VALUE;
        int largest = other.get(0);
        for (int i = 0; i < other.size(); i++) {
            if (other.get(i) > largest) {
                largest = other.get(i);
            }
        }

        for (int i = 0; i < other.size(); i++) {
            if (other.get(i) < largest) {
                retVal.add(other.get(i));
            }
        }

        return retVal;
    }


}
