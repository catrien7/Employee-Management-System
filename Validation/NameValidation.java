package Validation;

abstract public class NameValidation {
    static public Boolean validateName(String name){
        return !name.trim().isEmpty();
    }
}