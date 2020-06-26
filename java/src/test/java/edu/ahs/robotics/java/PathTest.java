package edu.ahs.robotics.java;

import org.junit.Test;

import java.util.ArrayList;

import edu.ahs.robotics.java.Path.WayPoint;

import static org.junit.Assert.*;

public class PathTest {

    @Test
    public void testDuplicatesRemoved() {
        Point point1 = new Point(0,0);
        Point point2 = new Point(3,4);
        Point point3 = new Point(3,4);
        Point point4 = new Point(5,5);

        WayPoint wayPoint1 = new WayPoint(point1, 0, 0, 0);
        WayPoint wayPoint2 = new WayPoint(point2, 3, 4, 5);
        WayPoint WayPoint3 = new WayPoint(point3, 0,0,0);
        WayPoint wayPoint4 = new WayPoint(point4, 1,1, point4.distanceToPoint(point3));


        ArrayList<WayPoint> expectedReturnedWayPoints = new ArrayList<>();
        expectedReturnedWayPoints.add(wayPoint1);
        expectedReturnedWayPoints.add(wayPoint2);
        expectedReturnedWayPoints.add(wayPoint4);

        ArrayList<WayPoint> actualReturnedWayPoints = new WayPoint();


        assertEquals(expectedReturnedWayPoints, actualReturnedWayPoints);


    }
}