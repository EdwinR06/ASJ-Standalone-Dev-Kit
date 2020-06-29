package edu.ahs.robotics.java;

import org.junit.Test;

import java.awt.event.TextEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

import edu.ahs.robotics.java.Path.WayPoint;

import static org.junit.Assert.*;

public class PathTest {

    @Test
    public void testDuplicatesRemoved() {
        Point[] points = new Point[] {new Point(0,0), new Point(3,4), new Point(3,4), new Point(5,5)};
        Path path = new Path(points);

        ArrayList<Point> actual = new ArrayList<>();

        ArrayList<Point> expected = new ArrayList<>();
        expected.add(points[0]);
        expected.add(points[1]);
        expected.add(points[3]);

        ArrayList<WayPoint> actualReturnedWayPoints = path.getWayPoints();


        for (WayPoint w : actualReturnedWayPoints) {
            actual.add(w.point);
        }
        assertEquals(expected, actual);

    }

    @Test
    public void totalDistance() {
        Point[] points = new Point[] {new Point(3,4)};
        Path path = new Path(points);

        assertEquals(5, path.totalDistance(points), 0.00001);



        /* Point[] points2 = new Point[] {new Point(0,0), new Point(24,10)};
        Path path2 = new Path(points);

        assertEquals(26, path.totalDistance(points2), 0.00001);



        Point[] points3 = new Point[] {new Point(0,0), new Point(1,1.73205080757)};
        Path path3 = new Path(points);

        assertEquals(2, path.totalDistance(points3), 0.00001);



        Point[] points4 = new Point[] {new Point(0,0), new Point(0,0)};
        Path path4 = new Path(points);

        assertEquals(0, path.totalDistance(points4), 0.00001); */
    }

    @Test
    public void testIllegalArgumentException() {
        try{
            Point[] points = new Point[] {new Point(2,5), new Point(4, 5)};
            Path path = new Path(points);
            fail("Expected Illegal Argument Exception");
        } catch (IllegalArgumentException e){
            // What we wanted
        }
    }

    @Test
    public void testTargetPoint() {
        Point current = new Point(0,0);
        double distanceToMoveAlongPath = 5;

        Point actual = new Point(0,0);
    }
}