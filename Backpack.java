
package xyzproject2;


import java.util.*;

public class Backpack {
    
    
    final int LIMIT = 3;
    private LinkedList<Artifact> bag;
    
    public Backpack(){
        bag = new LinkedList<Artifact>();
    }
    
    public boolean setArtifact(Artifact artifact){
        if(bag.size() < LIMIT && artifact != null){
            System.out.println("You picked up "+artifact.getName());
            bag.add(artifact);
            return true;
        }
        else if ( artifact == null)
            System.out.println("There is no artifact to pick up.");
        else
            System.out.println("Your bag is full.");
        
        return false;
    }
    
    public Artifact getArtifact(int index){
        if(index > LIMIT){
            return null;
        }
        return bag.get(index);
    }
    
    public Artifact removeArtifact(int index)
    {
        if(index > LIMIT){
            return null;
        }
        return bag.remove(index);
    }
    
    public int bSize(){
        return bag.size();
    }
    
    public String inventory()
    {
        String items= "";
        if(bag.size() == 0){
            return "You are carrying nothing";
        }
        else{
            for(int i = 0; i<bag.size(); i++){
                items += bag.get(i).getName();
                if(i<bag.size()-1)
                    items += "\n";
            }
            return items;
        }
    }
    
    //resets backpack
    public void reset(){
        bag.clear();
    }
    
    //setartifact with no display message
    public void setArtifact(Artifact artifact,boolean reset){
        if(reset){
            bag.add(artifact);
        }
    }
    
}
