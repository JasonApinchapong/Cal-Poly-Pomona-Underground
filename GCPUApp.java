
package xyzproject2;//THEY ALL SAY PROJJECT 2 BUT IIT IS PROJECT3

import java.util.*;
import java.io.*;

public class GCPUApp {

    
    public static void main (String[] args){
        boolean quit = false;
        Scanner in = new Scanner(System. in);
        String input = "";
        String savedFile = "";
        
        //creates new game
        Map map = new Map();
        map.startTour();
        
        //Creates new backpack
        Backpack bag = new Backpack();
        
        //game loop
        do{
            System.out.print("\n>");
            input = in.nextLine();
            input = input.toLowerCase();
            
            if(input.equals("look")){ //when look command is entered
                String look = map.location().look();
                System.out.println(look);
            }
            else if(input.equals("examine")){ //examine command
                String examine = map.location().getArtifact().examine();
                System.out.println(examine);
            }
            else if(input.equals("touch")){ //touch command
                String touch = map.location().getArtifact().touch();
                System.out.println(touch);
            }
            else if(map.location().isValidExit(input)){ //move comand
                map.move(input);
            }
            else if(!map.location().isValidExit(input) && input.length()==1){
                System.out.println("You can't go that way.");
            }
            else if(input.equals("help")){ //help command
                map.help();
            }
            else if(input.equals("quit")){ //quit command
                quit = map.quit();
            }
            else if(input.equals("take")){
                if(bag.setArtifact(map.location().getArtifact())){
                    map.location().setArtifact(null);
                }
            }
            else if(input.equals("drop")){
                 if(map.location().getArtifact() == null && bag.bSize() != 0){
                        System.out.println("You dropped " + bag.getArtifact(0).getName());
                        map.location().setArtifact(bag.removeArtifact(0));
                    }
                        
                else if(map.location().getArtifact() != null && bag.bSize() != 0){
                        Artifact temp;
                        temp = map.location().getArtifact();
                        map.location().setArtifact(null);
                        map.location().setArtifact(bag.removeArtifact(0));
                        bag.setArtifact(temp,true);
                        System.out.println("You dropped the " + map.location().getArtifact().getName());
                        System.out.println("You picked up the " + temp.getName());
                    }
                else
                        System.out.println("You have nothing in your backpack to drop");
            }
            else if(input.equals("inventory")){
                String inv = bag.inventory();
                System.out.println(inv);
            }
            else if(input.equals("save")){
                System.out.println("Enter Directory for saved file (EX: C:\\Users\\OneDrive\\Desktop\\javatest\\(enter save file name here).txt): ");
                String fileName = in.nextLine();
                
                File file = new File(fileName);
                boolean overWrite = false;
                        
                if(file.exists()){
                    System.out.println("File name already Exists, Do you want to Overwrite it? (Y/N)");

                    String saveInput = in.nextLine();
                    if(saveInput.equalsIgnoreCase("Y")){
                        overWrite = true;
                    }
                    else if (saveInput.equalsIgnoreCase("N")){
                        overWrite = false;
                    }
                }
                if(!file.exists()){
                    overWrite = true;
                }
                if(overWrite == true){
                    try{
                        FileWriter fw = new FileWriter(file);
                        BufferedWriter buffer = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(buffer);
                        
                        pw.println("StartLocation" + "=" + map.getY() + "," + map.getX());

                        for(int y=0; y<4; y++){
                            for(int x=0; x<4; x++){
                                if(map.getRoom(y,x) != null){
                                    if (map.getRoom(y,x).getArtifact() != null){
                                        pw.println("Artifact" + "=" + map.getRoom(y,x).getArtifact().getName() + "," + y + "," + x);
                                    }
                                }
                            }
                        }
                        for(int i = 0; i < bag.bSize(); i++){
                            if(bag.getArtifact(i) instanceof BooleanArtifact){
                                BooleanArtifact temp = (BooleanArtifact)bag.getArtifact(i);
                                pw.println("Inventory" + "=" + bag.getArtifact(i).getName());
                                pw.println("Boolean State" + "=" + temp.getName() + "," + temp.state);
                                pw.println("");
                            }
                            if(bag.getArtifact(i) instanceof ProgressiveArtifact){
                                ProgressiveArtifact temp = (ProgressiveArtifact)bag.getArtifact(i);
                                pw.println("Inventory" + "=" + bag.getArtifact(i).getName());
                                pw.println("Progressive Artifact State" + "=" + temp.getName() + "," + temp.intState);
                                pw.println("");
                            }
                            else if(bag.getArtifact(i) instanceof BooleanArtifact != true 
                                        && bag.getArtifact(i) instanceof ProgressiveArtifact != true){
                                pw.println("Inventory" + "=" + bag.getArtifact(i).getName());
                            }
                        }
                        for(int y=0; y<4; y++){
                            for(int x=0; x<4; x++) {
                                if(map.getRoom(y,x) != null){
                                    if(map.getRoom(y,x).getArtifact() != null){
                                        if(map.getRoom(y,x).getArtifact() instanceof BooleanArtifact == true){
                                            BooleanArtifact temp = (BooleanArtifact)map.getRoom(y,x).getArtifact();
                                            if(temp.state == true){
                                                String state = "on";
                                                pw.println("Boolean Artifact State" + "=" + temp.getName() + "," + state);
                                            }
                                            else if(temp.state == false){
                                                String state = "off";
                                                pw.println("Boolean Artifact State" + "=" + temp.getName() + "," + state);
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        for(int y=0; y<4; y++){
                            for(int x=0; x<4; x++){
                                if(map.getRoom(y,x) != null){
                                    if(map.getRoom(y,x).getArtifact() != null){
                                        if(map.getRoom(y,x).getArtifact() instanceof ProgressiveArtifact == true){
                                            ProgressiveArtifact temp = (ProgressiveArtifact)map.getRoom(y,x).getArtifact();
                                            if(temp.intState == 0){
                                                String state = "on";
                                                pw.println("Progressive Artifact State" + "=" + temp.getName() + "," + state);
                                            }
                                            else if(temp.intState == 1){
                                                String state = "low";
                                                pw.println("Progressive Artifact State" + "=" + temp.getName() + "," + state);
                                            }
                                            else if(temp.intState == 2){
                                                String state = "high";
                                                pw.println("Progressive Artifact State" + "=" + temp.getName() + "," + state);
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        buffer.close();      			
                        System.out.println("Save Complete!");
                    }catch(Exception e){
                        System.out.println("The directory is Incorrect");
                    }
                }
                else{
                    System.out.println("File was not Saved");
                }
            }
            else if(input.equals("restore")){
                try{
                System.out.println("Enter file name directory to restore game (EX: C:\\Users\\OneDrive\\Desktop\\javatest\\(enter save file name here).txt):");
                String fileName = in.nextLine();
                
                        
                File file = new File(fileName);
                boolean exit=false;
                while(!file.exists()){
                    System.out.println("The file entered does not exists. Please enter a valid saved File or \"exit\" to exit restore");
                    fileName = in.nextLine();
                    file = new File(fileName);
                    if(savedFile.equalsIgnoreCase("exit"))
                        break;
                    
                }
                if(savedFile.equalsIgnoreCase("exit")){
                    System.out.println("You have exited restore, no file restored");
                    System.out.println("");
                    System.out.println("You are currently at the " + map.location().getName());
                }
                FileReader reader = new FileReader(file);
                
                BufferedReader buffer = new BufferedReader(reader);
                //resets everything
                map.reset();
                bag.reset();
                
                String fileInput;
                while((fileInput = buffer.readLine()) != null){
                    String[] data = fileInput.split("=|,");
                    String key = data[0];
                    if(key.equals("StartLocation")){
                        //System.out.print("hello"); TEST
                        map.setYLocation(Integer.parseInt(data[1]));
                        map.setXLocation(Integer.parseInt(data[2]));
                        //System.out.println(Integer.parseInt(data[1])); TEST
                        //System.out.println(Integer.parseInt(data[2])); TEST
                    }
                    else if(key.equals("Artifact")){
                        //System.out.println("tehe"); TEST
                        String name = data[1].toLowerCase();
                        int artifactRow = Integer.parseInt(data[2]);
                        int artifactCol = Integer.parseInt(data[3]);
                        
                        for (int y=0;y<4;y++){ 
                            for (int x=0;x<4;x++){ 
                                map.getRoom(artifactRow,artifactCol).setArtifact(map.getArtifactName(name));
                                //System.out.println("XD"); TEST
                            }
                        }
                    }
                    else if(key.equals("Inventory")){
                        String name = data[1].toLowerCase();
                        bag.setArtifact(map.getArtifactName(name),true);
                    }
                    //tem.out.println("UwU"); TEST
                }
                reader.close();
                buffer.close();
            
                System.out.println("Restore Complete!");
                System.out.println("Welcome back!");
                System.out.println("\nYou are currently at:");
                System.out.println(map.location().look());
                System.out.println("\nAnd your current inventory is:");
                System.out.println(bag.inventory());
                }catch(Exception e){
                    //System.out.println(e); DOESNT PRINT UNLESS ACTUALLY RESTORED
                }
            }
            else{
                System.out.println("I dont understand "+input+".");
            }
        } while(!quit);
    }

}

