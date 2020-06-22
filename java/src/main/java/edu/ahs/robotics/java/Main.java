package edu.ahs.robotics.java;

public class Main {
    public static void main(String[] args) {
        Point a = new Point(1,2);
        System.out.println(a.getX());
        System.out.println(a.distanceFromOrigin());
        System.out.println(a.getQuadrant());
    }
}