
package Employee;

public enum EmployeeType {
    full,part;

    @Override
    public String toString() {
        if (this==full) {
            return "Full Time";
        }
        
        else{
        return "Part Time" ;
        }
    } 
    





}
