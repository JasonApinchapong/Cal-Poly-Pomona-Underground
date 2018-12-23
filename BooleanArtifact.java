
package xyzproject2;

public class BooleanArtifact extends Artifact {
    
    boolean state;
    
    private String name, description, onDescription, touchOnDescription, touchOffDescription;
     
    public BooleanArtifact(String name, String description, String onDescription, String touchOnDescription, String touchOffDescription){
        super(name,description);
        this.state = false;
        this.onDescription = onDescription;
        this.touchOnDescription = touchOnDescription;
        this.touchOffDescription = touchOffDescription;
    }
    
    public String getOnDescription(){ //returns onDescription
        return onDescription;
    }
    
    public String getTouchOffDescription(){ //returns touchOffDescription
        return touchOffDescription;
    }
    
    public String getTouchOnDescription(){ //returns touchOnDescription
        return touchOnDescription;
    }
    
    public String examine(){ //boolean examine
        if(!state)
            return getDescription();
        return getOnDescription();
    }
    
    public  String touch(){ //boolean touch chanegs state
        if(!state){
            state = true;
            return getTouchOnDescription();
        }
        else{
            state = false;
            return getTouchOffDescription();
        }
    }
    
}
