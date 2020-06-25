package edu.ahs.robotics.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class LineSegmentTest {

    @Test
    public void testSubDivide() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(3, 3);
        LineSegment lineSegment = new LineSegment(point1, point2);

        //This calls the subDivide method on lineSegment with the argument of three subSegments and stores these points in the point array pointsActual.
        Point[] pointsActual = lineSegment.subDivide(3);

        Point[] pointsExpected = new Point[2];
        pointsExpected[0]=new Point(1, 1);
        pointsExpected[1]=new Point(2, 2);
        //This loop just tests both returned points against the expected point.
        for (int i = 0; i < pointsActual.length; i++){
            assertEquals(pointsExpected[i].getX(),pointsActual[i].getX(),0.000001);
            assertEquals(pointsExpected[i].getY(),pointsActual[i].getY(),0.000001);

        }
    }

    @Test
    public void interpolate() {
        LineSegment ls = new LineSegment(new Point (2,2), new Point (5,6));

        //This creates a point for the actual value returned by calling the interpolate method on ls, a line segment.
        Point interpolateActual = ls.interpolate(5);
        Point interpolateExpected = new Point (5,6);

        assertEquals(interpolateExpected.getX(), interpolateActual.getX(), 0.00001);
        assertEquals(interpolateExpected.getY(), interpolateActual.getY(), 0.00001);
    }
}