package edu.ahs.robotics.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void distanceFromOrigin() {
        assertEquals(5,new Point(3,4).distanceFromOrigin(),.00001);

        assertEquals(13,new Point(5,-12).distanceFromOrigin(),.00001);
        assertEquals(25,new Point(-7,24).distanceFromOrigin(),.00001);
        assertEquals(Math.sqrt(2),new Point(-1,-1).distanceFromOrigin(),.00001);
    }

    @Test
    public void getQuadrant() {
        assertEquals("Quadrant 1",new Point(16,4).getQuadrant());
        assertEquals("Quadrant 2",new Point(-49,6).getQuadrant());
        assertEquals("Quadrant 3",new Point(-1,-3).getQuadrant());
        assertEquals("Quadrant 4",new Point(12,-3.2215).getQuadrant());

        assertEquals("Axes",new Point(0,-7).getQuadrant());
        assertEquals("Axes",new Point(12,0).getQuadrant());
        assertEquals("Axes",new Point(0,0).getQuadrant());

    }

    @Test
    public void distanceToPoint() {
        Point a = new Point(1,1);
        Point b = new Point(4, 5);

        assertEquals(5, a.distanceToPoint(b), 0.00001);
    }
    @Test
    public void closestPoint(){
        Point[] points = new Point[]{new Point(4,3), new Point(5,4), new Point(7, 5)};
        Point a = new Point(-1, 4);
        Point closestPointToA = a.closestPoint(points);

        assertEquals(4, closestPointToA.getX(), 0.00001);
        assertEquals(3, closestPointToA.getY(), 0.0001);
    }

    @Test
    public void distanceBetweenTwoPoints() {
        Point a = new Point (3, 6);
        Point b = new Point (0,2);
        double distanceBetweenPoints = Point.distanceBetweenTwoPoints(a, b);

        assertEquals(5, distanceBetweenPoints, 0.00001);
    }

    @Test
    public void midPoint() {
        Point a = new Point (3, 4);
        Point b = new Point (6, 8);

        Point midPointActual = Point.midPoint(a, b);

        assertEquals(5.5, midPointActual.getX(), 0.000001);
        assertEquals(6.5, midPointActual.getY(), 0.000001);
    }
}