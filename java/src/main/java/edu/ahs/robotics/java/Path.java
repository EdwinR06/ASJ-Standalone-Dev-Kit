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
            if(current.equals(pathWayPoints.get(i).point)){
                isCurrentPointAWayPoint = true;
            } else {
                isCurrentPointAWayPoint = false;
            }
          }
          WayPoint newTargetPointFromCurrentPoint = new WayPoint(new Point(0,0), 0, 0, 0);
          WayPoint newTargetWayPointFromCurrentWayPoint;
          WayPoint newTargetFartherAlongPath = new WayPoint(new Point(0,0),0,0,0);
          // WayPoint
          if(isCurrentPointAWayPoint = true){
              for(int i = 0; i < pathWayPoints.size(); i++){
                if(current.equals(pathWayPoints.get(i).point)){

                    LineSegment pathSegment = new LineSegment(current, pathWayPoints.get(i+1).point);

                    if(distance > pathSegment.length){

                        double nextLineSegmentDistance = -1 * (pathSegment.length - distance);

                        Point partialInterpolationToTargetPoint = new Point(pathWayPoints.get(i+1).point.getX(), pathWayPoints.get(i+1).point.getY());

                        pathSegment = new LineSegment(partialInterpolationToTargetPoint, pathWayPoints.get(i+2).point);

                        boolean whatI = false;

                        while(nextLineSegmentDistance > pathSegment.length){

                            nextLineSegmentDistance = -1 * (pathSegment.length - distance);

                            partialInterpolationToTargetPoint = new Point(pathWayPoints.get(i+2).point.getX(), pathWayPoints.get(i+2).point.getY());

                            pathSegment = new LineSegment(partialInterpolationToTargetPoint, pathWayPoints.get(i+3).point);

                            
                        }

                        Point targetPointFromPreviousWayPoint = pathSegment.interpolate(nextLineSegmentDistance);

                        if(whatI = true){
                            newTargetFartherAlongPath = new WayPoint(targetPointFromPreviousWayPoint, pathWayPoints.get(i+3).point.getX() - partialInterpolationToTargetPoint.getX(), pathWayPoints.get(i+3).point.getY() - partialInterpolationToTargetPoint.getY(), nextLineSegmentDistance);

                        } else {
                            newTargetFartherAlongPath = new WayPoint(targetPointFromPreviousWayPoint, pathWayPoints.get(i+3).point.getX() - partialInterpolationToTargetPoint.getX(), pathWayPoints.get(i+3).point.getY() - partialInterpolationToTargetPoint.getY(), nextLineSegmentDistance);
                        }

                    } else {

                        Point newTargetPointFromCurrentWayPoint = pathSegment.interpolate(distance);

                        newTargetWayPointFromCurrentWayPoint = new WayPoint(newTargetPointFromCurrentWayPoint,pathWayPoints.get(i+1).point.getX() - current.x,pathWayPoints.get(i+1).point.getY() - current.y, distance);
                    }
                }
              }
          } else {
              Point currentClosestWayPoint = current.closestWayPoint(pathWayPoints);

              newTargetPointFromCurrentPoint = new WayPoint(new Point(0,0),0, 0, 0);
          }

          if(isCurrentPointAWayPoint = true){
              WayPoint targetWayPoint = newTargetFartherAlongPath;
              return targetWayPoint;
          } else {
              WayPoint targetWayPoint = newTargetPointFromCurrentPoint;
              return  targetWayPoint;
          }





     }




    public static class WayPoint {
        public Point point;
        public double deltaXFromPrevious;
        public double deltaYFromPrevious;
        public double distanceFromPrevious;

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
