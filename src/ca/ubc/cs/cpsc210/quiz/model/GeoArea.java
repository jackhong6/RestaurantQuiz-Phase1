package ca.ubc.cs.cpsc210.quiz.model;

import java.util.List;

/**
 * Represents a geographical area.
 */
public interface GeoArea {

    // Gets string that describes this geographical area
    public String getCityString();

    // Returns a list of strings that could be used to describe this area
    public List<String> getAllGeoStrings();
}
