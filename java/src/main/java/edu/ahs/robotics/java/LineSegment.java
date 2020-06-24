package edu.ahs.robotics.java;

public class LineSegment {
    private Point point1;
    private Point point2;

    public LineSegment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }
    // The Point[] below means that the method will return an array of points.
    public Point[] subDivide(int subSegments) {
        //Find the deltas of the two x coordinates of the line segment end points.
        double deltaX = point2.getX() - point1.getX();
        //Find the deltas of the two y coordinates of the line segment end points.
        double deltaY = point2.getY() - point1.getY();

        //Find the x step for each segment.
        double xStep = deltaX / subSegments;
        //Find the y step for each segment.
        double yStep = deltaY / subSegments;
        Point[] subDividedPoints = new Point[subSegments - 1];
        for(int i = 1; i < subSegments; i++){
            subDividedPoints[i-1] = new Point (point1.getX() + xStep * i, point1.getY() + yStep * i);
        }
        return subDividedPoints;

    }
    private double length() {
        //This is the value for x2-x1
        double a = point2.getX() - point1.getX();
        //This is the value for y2-y1
        double b = point2.getY() - point1.getY();

        double length = Math.sqrt(a*a+b*b);
        return length;
    }
    public Point interpolate(double distanceFromFirstPoint){
       // double distanceX = point2.getX() - point1.getX();
       // double distanceY = point2.getY() - point1.getY();

        // double distanceFromTwoEndPoints = Math.sqrt(distanceX*distanceX+distanceY*distanceY);

        Point interpolate = new Point(point1.getX() + distanceFromFirstPoint, point1.getY() + distanceFromFirstPoint);
        return interpolate;
    }
}

