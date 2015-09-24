package ca.ubc.cs.cpsc210.quiz.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a neighbourhood having a name in a city
 */
public class Neighbourhood implements GeoArea {
    private String neighborhoodName;
    private City city;

    // Constructor initializes all fields
    public Neighbourhood(String neighborhoodName, City city){
        this.neighborhoodName = neighborhoodName;
        this.city = city;
    }


    /**
     * Two neighbourhoods are equal if they have the same city
     * When o is a City, this neighbourhood is equal to it, if it has the same city.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Neighbourhood) && !(o instanceof City)) return false;

        if (o instanceof City) return city.equals(o);

        City nbhdCity = ((Neighbourhood) o).getCity();

        return city.equals(nbhdCity);

    }

    @Override
    public int hashCode() {
        int result = neighborhoodName.hashCode();
        result = 31 * result + city.hashCode();
        return result;
    }

    public City getCity(){return city;}

    @Override
    public String getCityString() {
        return city.getCityString();
    }


    // TODO
    // Returns list of strings that describe the neighbourhood
    /*
        Returns list of strings that can be used to describe the neighbourhood,
        starting with just the first word in neighbourhoodName, then first plus second
        E.g. if Neighborhood name is 'Fancy Slopes Drive', this method will produce:
        first -> Fancy, City, Prov, Country Code
        second -> Fancy Slopes, City, Prov, Country Code
        third -> Fancy Slopes Drive, City, Prov Country Code
     */
    @Override
    public List<String> getAllGeoStrings() {
        String[] parsedName = neighborhoodName.split("[ ]");

        // Initiates the accumulator string with the first item in the parsedName array
        // and initiates a list of descriptors with the first item
        String accumulator = parsedName[0];
        LinkedList<String> descriptors = new LinkedList<String>();
        descriptors.add(accumulator);
        for (int i = 1; i < parsedName.length; i++) {
            accumulator = accumulator + " " + parsedName[i];
            descriptors.add(accumulator);
        }
        LinkedList<String> fullDescriptors = new LinkedList<String>();
        for (String descriptor : descriptors) {
            descriptor = descriptor + ", " + city.getCityString();
            fullDescriptors.add(descriptor);

        }
        return fullDescriptors;
    }
}
