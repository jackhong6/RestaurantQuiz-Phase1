package ca.ubc.cs.cpsc210.quiz.yelp.tests;


import ca.ubc.cs.cpsc210.quiz.model.Category;
import ca.ubc.cs.cpsc210.quiz.model.City;
import ca.ubc.cs.cpsc210.quiz.model.Neighbourhood;
import ca.ubc.cs.cpsc210.quiz.model.Restaurant;
import ca.ubc.cs.cpsc210.quiz.yelp.YelpDataParser;
import org.json.JSONException;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class YelpDataParserTest {
    private static final String FILEPATH = "./testdata/yelp-restaurants-multiple.json";
    private static StringBuilder jsonResponse;
    private static List<Restaurant> restaurants;

    @BeforeClass
    public static void runBefore() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(FILEPATH));
            jsonResponse = new StringBuilder();
            String str;
            while ((str = in.readLine()) != null) {
                jsonResponse.append(str);
            }
            in.close();
            parseRestaurants();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseRestaurants() {
        try {
            restaurants = YelpDataParser.parseRestaurantData(jsonResponse.toString(), "Vancouver");
        } catch (JSONException e) {
            e.printStackTrace();
            fail("Basic parsing failed");
        }
    }

    @Test
    public void testNumRestaurants() {
        assertEquals(10, restaurants.size());
    }

    @Test
    public void testFirstRestaurantInfo() {
        Restaurant r = restaurants.get(0);
        List<Category> categories = r.getCategories();

        assertEquals("1509 W 12th Avenue", r.getAddress());
        assertEquals("heirloom-vegetarian-vancouver", r.getId());
        assertEquals("V6J 2E1", r.getPostalCode());
        assertEquals(new Neighbourhood("Fairview Slopes", new City("Vancouver","BC","CA")), r.getGeographicalArea());
        assertEquals("Heirloom Vegetarian", r.getName());
        assertEquals(3,categories.size());
    }

    @Test
    public void testFifthRestaurantInfo() {
        Restaurant r = restaurants.get(4);
        List<Category> categories = r.getCategories();

        assertEquals("2549 Cambie Street", r.getAddress());
        assertEquals("la-taqueria-pinche-taco-shop-vancouver", r.getId());
        assertEquals("V5Z 3V6", r.getPostalCode());
        assertEquals(new Neighbourhood("Fairview Slopes", new City("Vancouver","BC","CA")), r.getGeographicalArea());
        assertEquals("La Taqueria Pinche Taco Shop", r.getName());
        assertEquals(1,categories.size());
    }

    @Test
    public void testLastRestaurantInfo() {
        Restaurant r = restaurants.get(9);
        List<Category> categories = r.getCategories();

        assertEquals("4127 Main Street", r.getAddress());
        assertEquals("hawkers-delight-deli-vancouver", r.getId());
        assertEquals("V5V 3P6", r.getPostalCode());
        assertEquals(new Neighbourhood("Riley Park", new City("Vancouver","BC","CA")), r.getGeographicalArea());
        assertEquals("Hawkers Delight Deli", r.getName());
        assertEquals(2,categories.size());
    }


}
