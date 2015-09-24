
package ca.ubc.cs.cpsc210.quiz.model.tests;


import ca.ubc.cs.cpsc210.quiz.model.City;
import ca.ubc.cs.cpsc210.quiz.model.Neighbourhood;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;



public class CityTest {

    City testCity;

    @Test
    public void testConstructor(){
        try{
            testCity = new City("Vancouver", "BC", "CA");
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not have been thrown");
        }

    }

    @Test
    public void testConstructorIllegalProvcince(){
        try {
            testCity = new City("Paris", "", "FR");
            fail("IllegalArgumentException should have been thrown");
        } catch (IllegalArgumentException e){
            // test should pass
        }
        try {
            testCity = new City("Paris", "123A", "FR");
            fail("IllegalArgumentException should have been thrown");
        } catch (IllegalArgumentException e){
            // test should pass
        }
        try {
            testCity = new City("Paris", "1", "FR");
            fail("IllegalArgumentException should have been thrown");
        } catch (IllegalArgumentException e){
            // test should pass
        }

    }

    @Test
    public void testGetGeographicalString() {
        City city = new City("Vancouver", "BC", "CA");
        assertEquals("Vancouver, BC, CA", city.getCityString());
    }

    @Test
    public void testGetAllGeoStrings() {
        City city = new City("Vancouver", "BC", "CA");
        List<String> geoStrings = city.getAllGeoStrings();

        assertEquals(1, geoStrings.size());
        assertEquals("Vancouver, BC, CA", geoStrings.get(0));
    }

    @Test
    public void testEquals(){
        City city1 = new City("Vancouver","BC","CA");
        City city2 = new City("Vancouver","BC","CA");

        City city3 = new City("Richmond","BC","CA");
        City city4 = new City("Vancouver","ON","CA");
        City city5 = new City("Vancouver","BC","US");
        City city6 = new City("La-ville-du-bois","ES","FR");
        Neighbourhood neighbourhood = new Neighbourhood("myNeighbourhood",city1);

        assertTrue(city1.equals(city1));
        assertTrue(city1.equals(city2));
        assertTrue(city1.equals(neighbourhood));

        assertFalse(city1.equals(city3));
        assertFalse(city1.equals(city4));
        assertFalse(city1.equals(city5));
        assertFalse(city1.equals(city6));


    }

}
