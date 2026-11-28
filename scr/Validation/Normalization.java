package Validation;

public class Normalization {

// Trims leading/trailing whitespace and converts to lowercase so comparisons
    // and lookups are case-insensitive and unaffected by extra spaces.
    static public  String normalize(String name) {
        if (name == null) {
            return null;
        }
        return name.trim().toLowerCase();
    }
}
