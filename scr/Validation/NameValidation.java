package Validation;

abstract public class NameValidation {

    // Ensures the name is non-null and not blank (contains more than just spaces).
    static public Boolean validateName(String name) {
        if (name == null) {
            return false;
        }
        for (char c : name.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return !name.trim().isEmpty();
    }
}