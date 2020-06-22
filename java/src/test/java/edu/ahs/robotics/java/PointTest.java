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
}