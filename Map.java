
package xyzproject2;

import java.util.*;

public class Map {
    
    private Room[][] rooms;
    
    //to keep track of location of player
    private int xLocation;
    private int yLocation;
    private Artifact[] artifacts = new Artifact[14];
    
    private String exits[];
    
    public Map(){
        
        rooms = new Room[4][4];
        
        //creates location to start
        xLocation = 0;
        yLocation = 3;
        
        Artifact lamp = new ProgressiveArtifact("Lamp","A dusty reading lamp that is off.",
            "The lamp emits a dim glow.","The lamp has a pleasant light.");
        rooms[0][0] = new Room("Library","Sunlight is streaming in through the glass windows",
            exits = new String[] {"s", "e"},lamp);
        artifacts[0] = lamp;
        
        Artifact caiman = new Artifact("caiman","The caiman watches you closely and you treat him with respect");
        rooms[0][1] = new Room("BioTrek","You see over 200 rainforest species of plants in this greenhouse and" +
            " appreciate the complexity of nature.",exits = new String[] {"w", "e"},caiman);
        artifacts[1] = caiman;
        
        Artifact icecream = new Artifact("Ice Cream","You see a container of Dr. Bob’s ice cream. The best ice cream "+
            "On the planet. You can’t wait to try some.");
        rooms[0][2] = new Room("Farm Store","An amazing collection of produce from the campus is arranged in "+
            "brightly lit display cases.",exits = new String[] {"w", "e","sw"},icecream);
        artifacts[2] = icecream;
        
        Artifact gate = new BooleanArtifact("gate","Raises for people living in the village","The gate is up you can enter.",
                "You use your gate key that your friend gave you and it goes up.","It beeps again and nothing happens, you should probaly enter.");
        rooms[0][3] = new Room("Village","Housing for students who don't want to live at the suites.",exits = new String[] {"w"},gate);
        artifacts[3] = gate;
        
        Artifact exam = new Artifact("exam","CIS 3090 Final Exam... The rest appears unreadable due to " +
            "a lack of printer toner.");
        rooms[1][0] = new Room("ClassRoom","You see an old table covered with papers near the front of the room.",exits = new String[] {"n","e"},exam);
        artifacts[4] = exam;
        
        Artifact gazebo = new Artifact("gazebo","The small plaque on the structure reads: Enjoy the garden");
        rooms[1][1] = new Room("Rose Garden","You are standing in the middle of a beautiful rose garden.",exits = new String[] {"ne","e","w"},gazebo);
        artifacts[5] = gazebo;
       
        Artifact slidingdoors = new Artifact("Sliding Doors","The doors slide if you get close to it like magic.");
        rooms[1][2] = new Room("College of Business Administration","The most modern building at this campus",exits = new String[] {"w","e","s"},slidingdoors);
        artifacts[6] = slidingdoors;
        
        Artifact car = new Artifact("car","Look a car.");
        rooms[1][3] = new Room("Old Structure","The 6 story parking structure that never has room.",exits = new String[] {"w"},car);
        artifacts[7] = car;
        
        Artifact picture = new Artifact("picture","The picture bears an inscription that reads: W. K. Kellogg." +
            "He appears to be holding a box of Corn Flakes.");
        rooms[2][0] = new Room("Kellog Mansion","This is the former home of William Kellogg,",exits = new String[] {"e","s"},picture);
        artifacts[8] = picture;
        
        Artifact lunch = new Artifact("lunch","The lunch appears to be a hamburger, French fries, and some kind of soda.");
        rooms[2][1] = new Room("Los Olivos","The aroma of hamburgers and pizza wafts through the " +
            "air.",exits = new String[] {"e","w","s"},lunch);
        artifacts[9] = lunch;
        
        Artifact duck = new Artifact("duck","Duck goes quack.");
        rooms[2][2] = new Room("Duck Pond","They really should clean up this pond.",exits = new String[] {"e","w","n"},duck);
        artifacts[10] = duck;
        
        rooms[2][3] = new Room("Dorms","Housing for the freshmen that is really old man.",exits = new String[] {"w"},null);
        
        Artifact paper = new BooleanArtifact("paper","The paper appears blank.","The paper reads: Welcome to the Great Cal Poly Underground",
        "The paper begins to glow…","The writing fades.");
        rooms[3][0] = new Room("Box Canyon","This looks like the Voorhis Ecological Reserve. A cavernous opening in the canyon wall" +
            "lies just ahead of you.",exits = new String[] {"n"},paper);
        artifacts[11] = paper;
        
        Artifact hammock = new ProgressiveArtifact("Hammock","The hammock on a tree looks pretty cool.","You hop on the hammock to chill.",
                "You fall off the hammock and hurt yourself.");
        rooms[3][1] = new Room("University Quad","There is a lot of grass and stuff.",exits = new String[] {"ne","n","e"},hammock);
        artifacts[12] = hammock;
        
        Artifact horsestatue = new BooleanArtifact("Horse Statue","There is a cool bronze horse statue.","I read the sign and its a bronco of course."
            ,"I go up to read the sign","The horse gets up and leaves.");
        rooms[3][2] = new Room("Suites","Probably the cleaner housing on this campus",exits = new String[] {"w","e"},horsestatue);
        artifacts[13] = horsestatue;
        
        /*
        Artifact  = new Artifact();
        rooms[3][3] = new Room();
        */
    }
    
    public int getX(){
        // System.out.println(xLocation); debug
        return xLocation;
    }
    
    public int getY(){
        // System.out.println(yLocation); debug
        return yLocation;
    }
    
    //return location of the player in the room
    public Room location(){
        return rooms[getY()][getX()];
    }
    
    public void move(String move){
        boolean valid = false;
        do{
            if(move.contains("w") && rooms[yLocation][xLocation].isValidExit(move)){
                xLocation -= 1;
                valid = true;
            }
            else if(move.contains("nw") && rooms[yLocation][xLocation].isValidExit(move)){
                xLocation -=1;
                yLocation -=1;
                valid = true;
            }
            else if(move.contains("n") && rooms[yLocation][xLocation].isValidExit(move)){
                yLocation -=1;
                valid = true;
            }
            else if(move.contains("ne") && rooms[yLocation][xLocation].isValidExit(move)){
                xLocation +=1;
                yLocation -=1;
                valid = true;
            }
            else if(move.contains("e") && rooms[yLocation][xLocation].isValidExit(move)){
                xLocation +=1;
                valid = true;
            }
            else if(move.contains("se") && rooms[yLocation][xLocation].isValidExit(move)){
                xLocation +=1;
                yLocation +=1;
                valid = true;
            }
            else if(move.contains("s") && rooms[yLocation][xLocation].isValidExit(move)){
                yLocation +=1;
                valid = true;
            }
            else if(move.contains("sw") && rooms[yLocation][xLocation].isValidExit(move)){
                xLocation -=1;
                yLocation +=1;
                valid = true;
            }
        }while(!valid);
       
        System.out.println("You have entered the "+rooms[yLocation][xLocation].getName()+
                "\n"+rooms[yLocation][xLocation].getDescription()+
                "\n"+rooms[yLocation][xLocation].getExits());
        
    }
    
    public void startTour(){ //prints out beginning dialog
        System.out.println("Welcome to the great Cal Poly Pomona Underground!\n");
        System.out.println("You have entered a box canyon.\n" +
            "This looks like the Voorhis Ecological Reserve.\n" +
            "A cavernous opening in the canyon wall lies just ahead of you.\n" +
            "There is an opening to the north.");
    }
    
    public boolean quit(){ //quit command
        boolean correctInput = false;
        String input = "";
        do{
            Scanner in = new Scanner(System. in);
            System.out.print("Do you wish to leave the Underground(Y/N)?> ");
            input = in.nextLine();
            input = input.toLowerCase();
            if(input.equals("y")||input.equals("n"))
                correctInput = true;
        }while(!correctInput);
        if(input.equals("y")){
            System.out.println("Thanks for visiting the Great Cal Poly Pomona Underground");
            return true;
        }
        else
            System.out.println("Continue on enjoying the tour!.");
        return false;
        }
    
    public void help(){//help command
        System.out.println("List of commands:\n"+
                "look\n"+
                "examine\n"+
                "touch\n"+
                "n,nw,w,sw,s,se,e,ne to move in direction\n"+
                "quit"+
                "take"+
                "drop"+
                "save"+
                "restore"+
                "exit");
    }
    
    public Room getRoom(int y, int x){
        return rooms[y][x];
    }
    
    //FOR RELOADING THE GAME
    public void setXLocation(int num){
        xLocation = num;
    }
    public void setYLocation(int num){
        yLocation = num;
    }
    
    public Artifact getArtifactName(String name){
        for (int i =0; i<artifacts.length ; i++) {
            if(artifacts[i].getName().equals(name))
                return artifacts[i];
        }
        return null;
    }
    
    public void reset(){
        for (int y=0;y<4;y++){ 
            for (int x=0;x<4;x++){
                if(getRoom(y,x)!=null)
                    getRoom(y,x).setArtifact(null);
                //System.out.print(";P"); TEST
            }
        }
    }
    
}
