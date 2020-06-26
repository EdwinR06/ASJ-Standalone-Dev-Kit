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

        ArrayList<Integer> myFinalArray = new ArrayList<>();
        int biggestNumberTwo = 0;
        for (int i = 0; i < other.size(); i++) {
            if (other.get(i) > biggestNumberTwo) {
                if (biggestNumberTwo != 0){
                    myFinalArray.add(biggestNumberTwo);
                }
                biggestNumberTwo = other.get(i);
            } else {
                myFinalArray.add(other.get(i));
            }
        }
        Collections.sort(myFinalArray);
        return myFinalArray;
    }


}
