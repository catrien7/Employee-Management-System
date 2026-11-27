
package Employee;

public enum Position {
    Full_Stack_Developer,Technical_consultant,Ai_Engineer ,DevOps,UX_Designer;
    
    @Override
    public String toString() {
        if (this==Full_Stack_Developer) {return "Full Stack Developer";}
        if(this==Technical_consultant){return "Technical consultant";}
        if(this==Ai_Engineer){return "Ai Engineer";}
        if(this==DevOps){return "DevOps";}
        else{
            return "UX Designer";
        }
        
       
    } 



}
