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
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class YelpDataParserTest2 {
    private static final String FILEPATH = "./testdata/yelp-restaurants-multiple-2.json";
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
            restaurants = YelpDataParser.parseRestaurantData(jsonResponse.toString(),null);
        } catch (JSONException e) {
            e.printStackTrace();
            fail("Basic parsing failed");
        }
    }

    @Test
    public void testNumRestaurants() {
        assertEquals(8, restaurants.size());
    }

    @Test
    public void testFirstRestaurantInfo() {
        Restaurant r = restaurants.get(0);
        List<Category> categories = r.getCategories();

        assertEquals("1480 W 11th Avenue", r.getAddress());
        assertEquals("vijs-restaurant-vancouver", r.getId());
        assertEquals(null, r.getPostalCode());
        assertEquals(new Neighbourhood("Fairview Slopes", new City("Vancouver","BC","CA")), r.getGeographicalArea());
        assertEquals("Vij's Restaurant", r.getName());
        assertEquals(1,categories.size());
    }

    @Test
    public void testSecondRestaurantInfo() {
        Restaurant r = restaurants.get(1);
        List<Category> categories = r.getCategories();

        assertEquals("Granville St and W 10th Ave", r.getAddress());
        assertEquals("fliptop-filipino-fusion-vancouver", r.getId());
        assertEquals("V6H 3G9", r.getPostalCode());
        assertEquals(new Neighbourhood("Fairview Slopes", new City("Vancouver","BC","CA")), r.getGeographicalArea());
        assertEquals("Fliptop Filipino Fusion", r.getName());
        assertEquals(2,categories.size());
    }

    @Test
    public void testLastRestaurantInfo() {
        Restaurant r = restaurants.get(7);
        List<Category> categories = r.getCategories();

        assertEquals("3995 Main Street", r.getAddress());
        assertEquals("the-acorn-vancouver", r.getId());
        assertEquals("V5V 3P3", r.getPostalCode());
        assertEquals(new City("Vancouver","ON","US"), r.getGeographicalArea());
        assertEquals("The Acorn", r.getName());
        assertEquals(3,categories.size());
    }


}
