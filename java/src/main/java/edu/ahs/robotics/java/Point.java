package edu.ahs.robotics.java;

public class Point {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    public double distanceFromOrigin(){
        double distance = Math.sqrt(x*x+y*y);

        return distance;
    }
    public String getQuadrant(){
        if(x > 0 && y > 0){
            return "Quadrant 1";
        } else if(x < 0 && y > 0){
            return "Quadrant 2";
        } else if(x < 0 && y <0){
            return "Quadrant 3";
        } else if (x > 0 && y < 0){
            return "Quadrant 4";
        } else {
            return "Axes";
        }
    }

    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }
    public double distanceToPoint(Point other){
        double deltaA = x - other.getX();
        double deltaB = y - other.getY();

        double distanceToPoint = Math.sqrt(deltaA*deltaA+deltaB*deltaB);
        return distanceToPoint;
    }
    public Point closestPoint(Point [] pointsArray){
        Point closestPoint = pointsArray[0];
        for(int i = 1; i < pointsArray.length; i++){
            if(this.distanceToPoint(pointsArray[i]) < this.distanceToPoint(closestPoint)){
                closestPoint = pointsArray[i];
            }
        }
        return closestPoint;
    }
    public static double distanceBetweenTwoPoints(Point a, Point b){
        double distanceX = a.getX() - b.getX();
        double distanceY = a.getY() - b.getY();

        double distanceBetweenTwoPoint = Math.sqrt(distanceX*distanceX+distanceY*distanceY);
        return distanceBetweenTwoPoint;
    }
    public static Point midPoint(Point a, Point b){
        double distanceX = a.getX() - b.getX();
        double distanceY = a.getY() - b.getY();

        double distanceBetweenTwoPointForMidPoint = Math.sqrt(distanceX*distanceX+distanceY*distanceY);
        double midPointLength = distanceBetweenTwoPointForMidPoint / 2;
        Point midPoint = new Point(a.getX() + midPointLength, a.getY() + midPointLength);

        return midPoint;
    }
}
