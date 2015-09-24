package ca.ubc.cs.cpsc210.quiz.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a name having a name, province/state code and country code
 */
public class City implements GeoArea{
    private String cityName;
    private String province;
    private String countryCode;

    // Constructor initializes all fields.
    // Throws IllegalArgumentException if length of province or country code != 2
    public City(String cityName, String province, String countryCode) throws IllegalArgumentException {
        if (province.length() != 2 || countryCode.length() != 2) throw new IllegalArgumentException();

        this.cityName = cityName;
        this.province = province;
        this.countryCode = countryCode;
    }

    // Returns a string consisting of the form "city, province, country" (e.g. "Vancouver, BC, CA")
    @Override
    public String getCityString() {
        return cityName + ", " + province + ", " + countryCode;
    }

    // Produces an array of strings that contains only the string produced by getCityString
    @Override
    public List<String> getAllGeoStrings() {
        List<String> geoStrings = new ArrayList<String>();
        geoStrings.add(getCityString());
        return geoStrings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City) && !(o instanceof Neighbourhood)) return false;

        if (o instanceof Neighbourhood) {
            City nbhdCity = ((Neighbourhood) o).getCity();
            return this.equals(nbhdCity);
        }

        City city = (City) o;

        if (!cityName.equals(city.cityName)) return false;
        if (!countryCode.equals(city.countryCode)) return false;
        if (!province.equals(city.province)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cityName.hashCode();
        result = 31 * result + province.hashCode();
        result = 31 * result + countryCode.hashCode();
        return result;
    }
}
