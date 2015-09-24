package ca.ubc.cs.cpsc210.quiz.model.tests;

import ca.ubc.cs.cpsc210.quiz.model.Leg;
import ca.ubc.cs.cpsc210.quiz.model.Route;
import org.junit.Test;

import static org.junit.Assert.*;

public class RouteTest {

    @Test
    public void testGetDistance() {
        Route route = new Route();
        assertEquals(0, route.getDistance());
        assertEquals(0, route.getLegs().size());

        Leg leg1 = new Leg();
        leg1.setDistance(5);

        Leg leg2 = new Leg();
        leg2.setDistance(343);

        Leg leg3 = new Leg();
        leg3.setDistance(7);

        route.addLeg(leg1);
        route.addLeg(leg2);
        route.addLeg(leg3);

        assertEquals(355, route.getDistance());
        assertEquals(3, route.getLegs().size());
    }
}