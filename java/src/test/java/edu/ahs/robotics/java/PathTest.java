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

        for(int i = 0; i < expected.size(); i++){
            if(i == 0){
                assertEquals(0, path.getWayPoints().get(i).deltaXFromPrevious, 0.00001);
                assertEquals(0, path.getWayPoints().get(i).deltaYFromPrevious, 0.000001);
                assertEquals(0, path.getWayPoints().get(i).distanceFromPrevious, 0.000001);
            } else {
                assertEquals(expected.get(i).getX()-expected.get(i-1).getX(), path.getWayPoints().get(i).deltaXFromPrevious, 0.00001);
                assertEquals(expected.get(i).getY()-expected.get(i-1).getY(), path.getWayPoints().get(i).deltaYFromPrevious, 0.00001);
                assertEquals(Point.distanceBetweenTwoPoints(expected.get(i), expected.get(i-1)), path.getWayPoints().get(i).distanceFromPrevious, 0.00001);
            }
        }

    }

    @Test
    public void totalDistance() {
       Point[] points = new Point[] {new Point(3,4)};
       Path path = new Path(points);

        assertEquals(5, path.totalDistance(points), 0.00001);



        Point[] points2 = new Point[] {new Point(0,0), new Point(24,10)};
        Path path2 = new Path(points2);

        assertEquals(26, path2.totalDistance(points2), 0.00001);



        Point[] points3 = new Point[] {new Point(0,0), new Point(1,1.73205080757)};
        Path path3 = new Path(points3);

        assertEquals(2, path3.totalDistance(points3), 0.00001);



        Point[] points4 = new Point[] {new Point(0,0), new Point(0,0)};
        Path path4 = new Path(points4);

        assertEquals(0, path4.totalDistance(points4), 0.00001);

    }

    @Test
    public void testIllegalArgumentException() {
        try{
            Point[] points = new Point[] {new Point(2,5), new Point(4,4)};
            Path path = new Path(points);
            fail("Expected Illegal Argument Exception");
        } catch (IllegalArgumentException e){
            // What we wanted
        }
    }

    @Test
    public void testTargetPoint() {
        Point current = new Point(3,4);
        Point[] points = new Point[] {new Point(3,4), new Point(5,5), new Point(6, 6), new Point(9,10)};
        Path path = new Path(points);

        Point expected = new Point(9,10);

        WayPoint actual = path.targetPoint(current, 10);
        Point actualPoint = actual.point;

        assertEquals(actualPoint, actualPoint);




    }
}