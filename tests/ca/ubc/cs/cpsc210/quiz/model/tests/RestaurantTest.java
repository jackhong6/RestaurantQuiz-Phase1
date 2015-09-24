package ca.ubc.cs.cpsc210.quiz.model.tests;

import ca.ubc.cs.cpsc210.quiz.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RestaurantTest {

    private Restaurant restaurant;
    private City city;
    private List<Category> categories;
    private GeoArea geoArea;

    @Before
    public void setUp() {
        city = new City("Paris", "IF", "FR");
        categories = new ArrayList<Category>();
        geoArea = new Neighbourhood("Arkham", city);
        restaurant = new Restaurant("Jack's Awesome Restaurant",categories,"JAR","123 Java Street", "V79 8D9", geoArea);
    }

    @Test
    public void testEquals() {
        City city2 = new City("Paris", "IF", "FR");
        List<Category> categories2 = new ArrayList<Category>();
        GeoArea geoArea2 = new Neighbourhood("Arkham", city2);
        Restaurant restaurant2 = new Restaurant("Jack's Awesome Restaurant",categories2,"JAR","123 Java Street", "V79 8D9", geoArea2);
        assertTrue(restaurant.equals(restaurant2));

        City Gotham = new City("Gotham", "NY", "US");
        List<Category> categories3 = new ArrayList<Category>();
        GeoArea arkham = new Neighbourhood("Arkham City", Gotham);
        Restaurant gothamPizzas = new Restaurant("Gotham's Pizzas",categories3,"JAR","123 Java Street", "V79 8D9", arkham);
        assertFalse(restaurant.equals(gothamPizzas));

    }

    @Test
    public void testToString() {
        City Gotham = new City("Gotham", "NY", "US");
        List<Category> categories3 = new ArrayList<Category>();
        GeoArea arkham = new Neighbourhood("Arkham City", Gotham);
        Restaurant batmanEatsHere = new Restaurant("Batman Eats Here!",categories3,"batmanissuperdupercool","123 Java Street",null, arkham);
        assertFalse(restaurant.equals(batmanEatsHere));

        String restaurantString = batmanEatsHere.toString();
        assertEquals("Batman Eats Here!, Arkham, Gotham, NY, US",restaurantString);

    }
}