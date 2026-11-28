package Validation;

import HashMap.*;

public abstract class DepNameValidation {

    // Validates a new department name:
    // 1. Must pass basic non-blank name validation.
    // 2. Must not already exist in DepHashMap after normalization.
    public static Boolean isValid(String name){
        
        if(!NameValidation.validateName(name)) return false;

        String normalized = Normalization.normalize(name);

        // Return false if a department with this normalized name already exists.
        return !DepHashMap.doesExistByKey(normalized);
        

    }
    
    
}
