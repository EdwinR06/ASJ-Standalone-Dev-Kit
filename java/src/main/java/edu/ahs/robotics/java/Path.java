package edu.ahs.robotics.java;

import java.util.ArrayList;
import java.util.List;

public class Path {
    /**
     *@param rawPoints Array of X,Y points.  Duplicate points are discarded
    *                  A path must have at least 2 non-identical points
     */
    private ArrayList<WayPoint> pathWayPoints = new ArrayList<>();
    List<WayPoint> wayPoints;

    public Path(Point[] rawPoints){

        if(rawPoints.length < 2){
            throw new IllegalArgumentException("Tried to create a path with too few points.");
        }

        wayPoints = new ArrayList<>();


        WayPoint firstWayPoint = new WayPoint(rawPoints[0], 0, 0, 0);
        pathWayPoints.add(firstWayPoint);
        for (int i = 1; i < rawPoints.length; i++){
            if (!rawPoints[i].equals(rawPoints[i-1])){
               pathWayPoints.add(new WayPoint(rawPoints[i], rawPoints[i].getX()-rawPoints[i-1].getX(), rawPoints[i].getY()-rawPoints[i-1].getY(), rawPoints[i].distanceToPoint(rawPoints[i-1])) );
            }
        }
    }

    public ArrayList<WayPoint> getWayPoints(){
        return pathWayPoints;
    }



    /**
     * @return total distance of the path
     */
    public double totalDistance(Point[] pointsForDistance){

        double totalDistanceBetweenTwoWayPoints = Point.distanceBetweenTwoPoints(pointsForDistance[0], pointsForDistance[1]);

        return totalDistanceBetweenTwoWayPoints;
    }





    /**
     * @return a point at the supplied distance along the path from the supplied current position
     * Note that the point will usually be interpolated between the points that originally defined the Path
     */
      public Path.WayPoint targetPoint(Point current, double distance) {
          boolean isCurrentPointAWayPoint;

          for(int i = 0; i < pathWayPoints.size(); i++){
            if(current.equals(pathWayPoints.get(i))){
                isCurrentPointAWayPoint = true;
            } else {
                isCurrentPointAWayPoint = false;
            }
          }


          if(isCurrentPointAWayPoint = true){
              for(int i = 0; i < pathWayPoints.size(); i++){
                if(current.equals(pathWayPoints.get(i))){
                    LineSegment pathSegment = new LineSegment(current, pathWayPoints.get(i).point);

                    Point newTargetPointFromCurrentWayPoint = pathSegment.interpolate(distance);
                }
              }
          } else {


              Point newTargetPointFromCurrentPoint;
          }


          WayPoint targetWayPoint = new WayPoint(new Point(0,0), 0, 0, 0);
          return targetWayPoint;
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

        /**
         * Calculates the projection of the vector Vcurrent leading from the supplied current
         * point to this WayPoint onto the vector Vpath leading from the previous point on the path
         * to this WayPoint.  If the return value is positive, it means that the WayPoint is
         * farther along the path from the current point.  If the return value is negative, it means
         * that the WayPoint is before the current point.  The magnitude of the value tells the
         * distance along the path.  The value is computed as the dot product between Vcurrent and
         * Vpath, normalized by the length of vPath
         * @param current The source point to compare to the WayPoint
         */
        private double componentAlongPath(Point current) {
            double deltaXFromCurrent = point.x - current.x;
            double deltaYFromCurrent = point.y - current.y;

            double dp = deltaXFromCurrent * deltaXFromPrevious + deltaYFromCurrent * deltaYFromPrevious;
            return dp / distanceFromPrevious;
        }
    }
}
