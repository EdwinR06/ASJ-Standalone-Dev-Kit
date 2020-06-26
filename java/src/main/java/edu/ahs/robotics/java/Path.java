package edu.ahs.robotics.java;

import java.util.ArrayList;
import java.util.List;

public class Path {
    /**
     *@param rawPoints Array of X,Y points.  Duplicate points are discarded
    *                  A path must have at least 2 non-identical points
     */
    private ArrayList<WayPoint> pathWayPoints = new ArrayList<>();

    public Path(WayPoint[] rawPoints){
        for (int i = 0; i < rawPoints.length; i++){
            if (rawPoints[i] == rawPoints[i+1]){
               pathWayPoints.add(rawPoints[i+1]);
            } else {
                pathWayPoints.add(rawPoints[i]);
            }
        }
    }

    public List<WayPoint> getWayPoints(){
        return pathWayPoints;
    }



    /**
     * @return total distance of the path
     */
    public double totalDistance(){
        return 0.0;
    }



    /**
     * @return a point at the supplied distance along the path from the supplied current position
     * Note that the point will usually be interpolated between the points that originally defined the Path
     */
    public Path.WayPoint targetPoint(Point current, double distance) {
        return new WayPoint(new Point(0,0));
    }

    public static class WayPoint {
        public Point point;
        private double deltaXFromPrevious;
        private double deltaYFromPrevious;
        private double distanceFromPrevious;

        public WayPoint(Point point, double deltaXFromPrevious, double deltaYFromPrevious, double distanceFromPrevious) {
            this.point = point;
            this.deltaXFromPrevious = deltaXFromPrevious;
            this.deltaYFromPrevious = deltaYFromPrevious;
            this.distanceFromPrevious = distanceFromPrevious;
        }
    }


    /**
     * Calculates the projection in the direction of the path from the current point to the
     * supplied WayPoint
     * @param current The source point
     * @param wayPoint A point on the path
     * @return The dot product between vectors normalized by the length of the path segment leading to wayPoint
     */
    private double componentAlongPath(Point current, WayPoint wayPoint) {
        double deltaXToWayPoint = wayPoint.point.x - current.x;
        double deltaYToWayPoint = wayPoint.point.y - current.y;

        double dp = deltaXToWayPoint * wayPoint.deltaXFromPrevious + deltaYToWayPoint * wayPoint.deltaYFromPrevious;
        return dp / wayPoint.distanceFromPrevious;
    }

}
