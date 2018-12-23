
package xyzproject2;

public class Artifact {
    
    private String name, description;
    
    public Artifact(String name, String description){
        this.name = name;
        this.description = description;
    }
    
    public String getName(){ //returns artifact name
        return name;
    }
    
    public String getDescription(){ //returns artifact description
        return description;
    }
    
    public String examine(){ //examines artifact
        return getDescription();
    }
    
    public String touch(){ //basic touch function for artifacts
        return "Touching the "+getName()+" doesn't do anything";
    }
}
