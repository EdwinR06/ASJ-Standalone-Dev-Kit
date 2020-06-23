package edu.ahs.robotics.java;

public class Main {
    public static void main(String[] args) {
        Point a = new Point(1,2);
        System.out.println(a.getX());
        System.out.println(a.distanceToPoint(new Point (4, 6)));
        System.out.println(a.getQuadrant());
        System.out.println(a.closestPoint());
    }
}