package ca.ubc.cs.cpsc210.quiz.model;

/**
 * Stand-in for com.google.android.gms.maps.model.LatLng
 * Represents a position specified with latitude/longitude coords
 *
 * @author jackhong
 */
public class LatLng {
    private double lat;
    private double lng;

    // Constructor initializes lat and lng fields of Latlng object
    public LatLng(double lat, double lng){
        this.lat = lat;
        this.lng = lng;
    }

    // Getter method, returns the latitude
    // EFFECTS: return the lat field
    public double getLat(){
        return lat;
    }

    // Getter method, returns the longitude
    public double getLng(){
        return lng;
    }



}
