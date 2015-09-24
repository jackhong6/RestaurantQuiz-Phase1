package ca.ubc.cs.cpsc210.quiz.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a leg that has an arbitrary number of points and a distance.  Part of a route.
 *
 * @author jackhong
 */
public class Leg {
    private List<LatLng> points;
    private int distance;

    // Constructor initializes Leg with empty list of points
    // and zero distance.
    public Leg(){
        points = new ArrayList<LatLng>();
        distance = 0;
    }

    // Add a point (a LatLng object) to points
    public void addPoint(LatLng pt){points.add(pt);}

    // Add a list of points to points
    public void addAllPoints(List<LatLng> pts){points.addAll(pts);}

    // Gets all points on this leg
    public List<LatLng> getPoints(){return points;}

    // Set the distance for this leg in meters
    public void setDistance(int distance){this.distance = distance;}

    // Gets the distance of the leg in meters
    public int getDistance(){return distance;}




}
