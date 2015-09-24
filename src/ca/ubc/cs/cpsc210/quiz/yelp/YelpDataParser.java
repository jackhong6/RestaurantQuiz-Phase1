package ca.ubc.cs.cpsc210.quiz.yelp;

import ca.ubc.cs.cpsc210.quiz.model.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Parser for JSON data returned by Yelp.
 */
public class YelpDataParser {

    public YelpDataParser(){}

  /*  Parses a JSONObject received in response to a Yelp search for restaurants,
    filtered by city name and produces corresponding list of restaurants that are not closed.
    If the yelpCityFilter is null, "Vancouver" is used as the city filter.*/
    public static List<Restaurant> parseRestaurantData(String response, String yelpCityFilter)
            throws JSONException{

        List<Restaurant> restaurants = new ArrayList<Restaurant>();
        if (yelpCityFilter == null) yelpCityFilter = "Vancouver";

        JSONObject data = new JSONObject(response);
        JSONArray businesses = data.getJSONArray("businesses");

        for (int i = 0; i < businesses.length(); i++){
            JSONObject business = businesses.getJSONObject(i);
            boolean isClosed = business.getBoolean("is_closed");

            JSONObject location = business.getJSONObject("location");
            String cityName = location.getString("city");
            String province = location.getString("state_code");
            String countryCode = location.getString("country_code");
            City city = new City(cityName,province,countryCode);

            if (!isClosed && cityName.equals(yelpCityFilter)) {
                String name = business.getString("name");
                String id = business.getString("id");

                List<Category> categories = new ArrayList<Category>();
                JSONArray jCategories = business.getJSONArray("categories");
                for (int j = 0; j < jCategories.length(); j++){
                    JSONArray jCategoriesString = jCategories.getJSONArray(j);
                    String categoryName = jCategoriesString.getString(0);
                    String categoryAlias = jCategoriesString.getString(1);
                    categories.add(new Category(categoryName,categoryAlias));

                }

                JSONArray addresses = location.getJSONArray("address");
                String address = addresses.getString(0);

                String postalCode;
                try{
                    postalCode = location.getString("postal_code");
                }catch (JSONException e){
                    postalCode = null;
                }

                GeoArea geoArea;
                try {
                    JSONArray neighborhoods = location.getJSONArray("neighborhoods");
                    if (neighborhoods.length() != 0) {
                        String neighborhoodName = neighborhoods.getString(0);
                        geoArea = new Neighbourhood(neighborhoodName, city);
                    } else {
                        geoArea = city;
                    }
                } catch (JSONException e) {
                    geoArea = city;
                }

                Restaurant restaurant = new Restaurant(name,categories,id,address,postalCode,geoArea);
                restaurants.add(restaurant);


            }
        }


        return restaurants;
    }

}
