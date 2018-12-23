
package xyzproject2;

public class ProgressiveArtifact extends Artifact {
    
    int intState;
    
    private String name, description, lowDescription, highDescription;
     
    public ProgressiveArtifact(String name, String description, String lowDescription, String highDescription){
        super(name,description);
        this.intState = 0;
        this.lowDescription = lowDescription;
        this.highDescription = highDescription;
    }
    
    public String examine(){ //progressive examine
        if(intState == 0){
            return getDescription();
        }
        else if(intState == 1){
            return lowDescription;
        }
        else{
            return highDescription;
        }
    }
    
    public String touch(){ //progressive touch changes state
        if(intState == 0){
            intState = 1;
            return lowDescription;
        }
        else if(intState == 1){
            intState = 2;
            return highDescription;
        }
        else{
            intState = 0;
            return getDescription();
        }
    }
    
    
}
