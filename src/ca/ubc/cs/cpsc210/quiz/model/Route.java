package ca.ubc.cs.cpsc210.quiz.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a route having a list of legs and a distance.
 *
 * @author jackhong
 */
public class Route {
    private List<Leg> legs;
    private int distance;

    // Constructor initializes Route with
    // empty list of legs and zero distance.
    public Route() {
        legs = new ArrayList<Leg>();
        distance = 0;
    }

    // Adds a leg to this route
    public void addLeg(Leg leg){legs.add(leg);}

    // Returns the list of legs on this route
    public List<Leg> getLegs(){return legs;}

    // Returns the total distance for this route by
    // summing the distances of the legs
    public int getDistance(){
        distance = 0;
        for (Leg leg : legs) {
            distance += leg.getDistance();
        }
        return distance;
    }

}
