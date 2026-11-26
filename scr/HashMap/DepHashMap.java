package HashMap;

import java.util.HashMap;
import Department.Department;
import Validation.*;

public abstract class DepHashMap  {
    // Global registry of departments keyed by normalized department name.
    private static final HashMap<String, Department> deps = new HashMap<>();

    // Adds a department only if its normalized key is not already present.
    // Returns the existing department if duplicate, or null if newly added.
    public static Department add(String name, Department dep) {
        String normalized= Normalization.normalize(name);
        if (normalized == null || dep == null) {
            return null;
        }
        return deps.putIfAbsent(normalized,dep);
    }

    // Checks whether a department exists by key after normalizing the lookup name.
    public static boolean doesExistByKey(String name) {
        String normalized = Normalization.normalize(name);
        if (normalized == null) {
            return false;
        }
        return deps.containsKey(normalized);

    }


    public static boolean doesExistByValue(Department dep) {
        return deps.containsValue(dep);
    }
    
    // Removes a department by normalized name and returns it (or null if not found).
    public static Department remove(String name) {
        String normalized = Normalization.normalize(name);
        if (normalized == null) {
            return null;
        }
        return deps.remove(normalized);
    }

    // Searches for a department by normalized name and returns it (or null if not found).
    public static Department search(String name) {
        String normalized = Normalization.normalize(name);
        if (normalized == null) {
            return null;
        }
        return deps.get(normalized);
    }
    static public void uploadDepartments(HashMap<String, Department> loadedDepartments){
       deps.putAll(loadedDepartments);
    }

}

    
    

