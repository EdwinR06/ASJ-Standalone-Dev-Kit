package edu.ahs.robotics.java;

public class Main {
    public static void main(String[] args) {
        Point a = new Point(3,4);
        Point b = new Point(6, 8);

        Point p1 = new Point(0,0);
        Point p2 = new Point(4,5);
        LineSegment ls = new LineSegment(p1, p2);

        System.out.println(a.getX());
        System.out.println(a.distanceToPoint(new Point (4, 6)));
        System.out.println(a.getQuadrant());
        System.out.println(a.closestPoint(new Point[]{new Point(3,3), new Point(5,4), new Point(7, 5)}));
        System.out.println(a.distanceBetweenTwoPoints(a, b));
        System.out.println(Point.midPoint(a, b));
        System.out.println(ls.interpolate(2));
    }
}