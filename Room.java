
package xyzproject2;

public class Room {
    
    private String name, description;
    private String[] exits;
    
    private Artifact artifact;
    
    public Room(String name, String description, String[] exits, Artifact artifact){
        this.name = name;
        this.description = description;
        this.exits = exits;
        this.artifact = artifact;
    }
    
    public String getExits(){ //goes through arraylist to see all available exits
        String listE ="The exits are";
        int i = 0;
        
        while(i<exits.length){
            if(exits[i].contains("sw")){
                listE += " south west,";
            }
            else if(exits[i].contains("nw")){
                listE += " north west,";
            }
            else if(exits[i].contains("se")){
                listE += " south east,";
            }
            else if(exits[i].contains("ne")){
                listE += " north east,";
            }
            else if(exits[i].contains("e")){
                listE += " east,";
            }
            else if(exits[i].contains("n")){
                listE += " north,";
            }
            else if(exits[i].contains("s")){
                listE += " south,";
            }
            else if(exits[i].contains("w")){
                listE += " west,";
            }
            i++;
        }
        
        listE = listE.substring(0,listE.length()-1);
        
        return listE+".";
    }
    
    public String getName(){ //returns room name
        return name;
    }
    
    public String getDescription(){ //returns room description
        return description;
    }
    
    public String look(){ //returns look of the room
        String look = "";
        if(getArtifact() == null)
            look = getName()+"\n"+getDescription()+"\n"+getExits()+"\n"+"There is no artifact here";
        else
            look = getName()+"\n"+getDescription()+"\n"+getExits()+"\n"+"There is "+getArtifact().getName()+" here.";
        return look;
    }
    
    public Artifact getArtifact(){ //returns artifact
        return artifact;
    }
    
    public boolean isValidExit (String requestedExit){ //checks to see if the move inputed is correct
        int i =0;
        while(i<exits.length){
            if(exits[i].contains(requestedExit))
                return true;
            else
                i++;
        }
        return false;
    }
    
    //used for the new take option
    public void setArtifact(Artifact artifact){
        this.artifact = artifact;
    }
}
