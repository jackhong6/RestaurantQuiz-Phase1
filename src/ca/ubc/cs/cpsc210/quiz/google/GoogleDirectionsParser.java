package ca.ubc.cs.cpsc210.quiz.google;

import ca.ubc.cs.cpsc210.quiz.model.LatLng;
import ca.ubc.cs.cpsc210.quiz.model.Leg;
import ca.ubc.cs.cpsc210.quiz.model.Route;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Parser for response from Google Directions API.
 */
public class GoogleDirectionsParser {

    public GoogleDirectionsParser(){}

    // Parse route from Google Directions API response
    public static Route parseRoute(String response) throws JSONException {

        Route route = new Route();

        JSONObject directions = new JSONObject(response);
        JSONArray routes = directions.getJSONArray("routes");
        JSONObject jRoute = routes.getJSONObject(0);
        JSONArray legs = jRoute.getJSONArray("legs");

        for (int i = 0; i < legs.length(); i++) {
            JSONObject jLeg = legs.getJSONObject(i);
            JSONArray steps = jLeg.getJSONArray("steps");

            int distance = 0;
            List<LatLng> latLngs = new ArrayList<LatLng>();
            for (int j = 0; j < steps.length(); j++) {
                JSONObject step = steps.getJSONObject(j);

                JSONObject jDistance = step.getJSONObject("distance");
                distance += jDistance.getInt("value");

                JSONObject polyline = step.getJSONObject("polyline");
                String polyCode = polyline.getString("points");
                latLngs.addAll(PolylineDecoder.decodePoly(polyCode));


            }

            Leg leg = new Leg();
            leg.setDistance(distance);
            leg.addAllPoints(latLngs);

            route.addLeg(leg);
        }

        return route;

    }
}
