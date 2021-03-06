package edu.ahs.robotics.java;

import org.junit.Test;

import java.util.ArrayList;

import edu.ahs.robotics.java.Path.WayPoint;

import static org.junit.Assert.*;

public class PathTest {

    @Test
    public void testDuplicatesRemoved() {
        Point[] points = new Point[] {new Point(0,0), new Point(3,4), new Point(3,4), new Point(6,8)};
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

        for(int i = 0; i < expected.size(); i++){
            if(i == 0){
                assertEquals(0, path.getWayPoints().get(i).deltaXFromPrevious, 0.00001);
                assertEquals(0, path.getWayPoints().get(i).deltaYFromPrevious, 0.000001);
                assertEquals(0, path.getWayPoints().get(i).distanceFromPrevious, 0.000001);
                assertEquals(0, path.getWayPoints().get(i).distanceFromStart, 0.000001);
            } else {
                assertEquals(expected.get(i).getX()-expected.get(i-1).getX(), path.getWayPoints().get(i).deltaXFromPrevious, 0.00001);
                assertEquals(expected.get(i).getY()-expected.get(i-1).getY(), path.getWayPoints().get(i).deltaYFromPrevious, 0.00001);
                assertEquals(Point.distanceBetweenTwoPoints(expected.get(i), expected.get(i-1)), path.getWayPoints().get(i).distanceFromPrevious, 0.00001);

            }
        }

    }

    @Test
    public void totalDistance() {
       Point[] points = new Point[] {new Point(3,4), new Point(8, 4), new Point(18, 28)};
       Path path = new Path(points);

        assertEquals(31, path.totalDistance(), 0.00001);



        Point[] points2 = new Point[] {new Point(0,0), new Point(24,10), new Point(27, 14)};
        Path path2 = new Path(points2);

        assertEquals(31, path2.totalDistance(), 0.00001);



        Point[] points3 = new Point[] {new Point(-3, -4),new Point(0,0), new Point(1,1.73205080757)};
        Path path3 = new Path(points3);

        assertEquals(7, path3.totalDistance(), 0.00001);



        Point[] points4 = new Point[] {new Point(0,0), new Point(0,0), new Point(0,0)};
        Path path4 = new Path(points4);

        assertEquals(0, path4.totalDistance(), 0.00001);

    }

    @Test
    public void testInvalidArgumentOfPath() {
        try{
            Point[] points = new Point[] {new Point(4,4)};
            Path path = new Path(points);
            fail("Expected Illegal Argument Exception");
        } catch (IllegalArgumentException e){
            // What we wanted
        }
        try {
            Point[] points = new Point[] {new Point(4,4), new Point(4,4)};
            Path path = new Path(points);
            fail("Expected Illegal Argument Exception because of duplicate points");
        } catch (IllegalArgumentException e){
            // This is good
        }
    }

    @Test
    public void testTargetPoint() {
        Point[] points = new Point[] {new Point(0,0), new Point(0,5), new Point(5, 5), new Point(5,7)};
        Path path = new Path(points);
        Point current = new Point(1,3);
        WayPoint actual = path.targetPoint(current, 2);
        assertEquals(new Point(0,5), actual.point);

        current = new Point(0,-1);
        actual = path.targetPoint(current, 2);
        assertEquals(new Point(0,1), actual.point);

        current = new Point(0,-5);
        actual = path.targetPoint(current, 2);
        assertEquals(new Point(0,-3), actual.point);

        current = new Point(4,5);
        actual = path.targetPoint(current, 2);
        assertEquals(new Point(5,6), actual.point);

        current = new Point(5,8);
        actual = path.targetPoint(current, 2);
        assertEquals(new Point(5,7), actual.point);

        current = new Point(0,5);
        actual = path.targetPoint(current, 2);
        assertEquals(new Point(2,5), actual.point);

        current = new Point(0,5);
        actual = path.targetPoint(current, 20);
        assertEquals(new Point(5,7), actual.point);

        current = new Point(4,4);
        actual = path.targetPoint(current, 3);
        assertEquals(new Point(2,5), actual.point);
    }

    @Test
    public void testDistanceFromStart() {
        Point current = new Point(0,0);
        Point[] points = new Point[] {new Point(0,0), new Point(0,5), new Point(5, 5), new Point(5,7)};
        Path path = new Path(points);

        assertEquals(10, path.targetPoint(current, 10).distanceFromStart, 0.0000001);
    }


    @Test
    public void distanceFromEnd() {
        Point current = new Point(0,0);
        Point[] points = new Point[] {new Point(0,0), new Point(0,5), new Point(5, 5), new Point(5,7)};
        Path path = new Path(points);

        assertEquals(2, path.distanceFromEnd(path.targetPoint(current, 10).distanceFromStart), 0.0000001);
    }
}