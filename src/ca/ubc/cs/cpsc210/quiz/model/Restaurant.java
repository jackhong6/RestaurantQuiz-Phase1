package ca.ubc.cs.cpsc210.quiz.model;

import java.util.List;

/**
 * Represents a restaurant having a street address, geographical area, postal code, name, id categories
 * and list of reviews.
 */
public class Restaurant {

    private String name;
    private List<Category> categories;
    private String id;
    private String address;
    private String postalCode;
    private GeoArea geographicalArea;

    // Constructor initializes Restaurant with given name, list of categories, id, address, postal code and geographical area.
    public Restaurant(String name,
                      List<Category> categories,
                      String id,
                      String address,
                      String postalCode,
                      GeoArea geographicalArea) {
        this.name = name;
        this.categories = categories;
        this.id = id;
        this.address = address;
        this.postalCode = postalCode;
        this.geographicalArea = geographicalArea;
    }

    public String getName(){return name;}

    public List<Category> getCategories(){return categories;}

    public String getId(){return id;}

    public String getAddress(){return address;}

    public String getPostalCode(){return postalCode;}

    public GeoArea getGeographicalArea(){return geographicalArea;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant)) return false;

        Restaurant that = (Restaurant) o;

        if (!address.equals(that.address)) return false;
        if (!geographicalArea.equals(that.geographicalArea)) return false;
        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        if (!postalCode.equals(that.postalCode)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + postalCode.hashCode();
        result = 31 * result + geographicalArea.hashCode();
        return result;
    }

    // Produces string representation of restaurant of form:
    // name + first string in geographical areas geostrings + postal code
    // (e.g., "Heirloom Vegetarian, Fairview, Vancouver, BC, V6J 2E1") Postal code omitted if it is null
    @Override
    public String toString(){
        if (postalCode != null)
            return name + ", " + geographicalArea.getAllGeoStrings().get(0) + ", " + postalCode;
        else
            return name + ", " + geographicalArea.getAllGeoStrings().get(0);
    }

}