import java.util.Scanner;
import java.util.*;
import java.io.*;
/**
 * The TransitSystem class reads the file of transit lines and creates the array of Transit stations. It also checks
 * if a route exists, and prints the route.
 *
 * Alex Lai
 * Wednesday, November 27 2019
 */
public class TransitSystem
{
    /**
     * startStation and endStation are the user's input of their starting station and their wanted destination.
     * name is the file name. We pass in "data" since our file is named "data.txt."
     * arrayOfLines is an array of the object type Line, inside each line is an array of transits (type String.)
     * lineName is the String that will be later used to grab the name of the Line.
     */

    private String startStation;
    private String endStation;
    private String name;
    private Line[] arrayOfLines; //LINE OBJECT ARRAY
    private String lineName;
    public TransitSystem(String fileName, String startStation, String endStation){
        this.name = fileName+".txt";
        this.startStation = startStation;
        this.endStation = endStation;
    }

    /**
     * readLines will reads the Lines, and transit systems one by one and creates the Line objects/array of Transit Strings.
     */

    public void readLines(){
        Scanner countLines = null;
        try{
            countLines = new Scanner (new FileInputStream(this.name));
        }
        catch(FileNotFoundException e){
            System.out.println("File not found. Please try again.");
            System.exit(0);
        }
        int count = 0; //num of lines in data.txt
        while(countLines.hasNextLine()) {
            count++;
            countLines.nextLine(); //Moves the scanner to the next Line.
        }
        countLines.close();
        arrayOfLines = new Line[count/2];
        //I created a new scanner because the purpose of the first one is just to read the Lines.
        Scanner fileReader = null;
        try{
            fileReader = new Scanner (new FileInputStream(this.name));
        }
        catch(FileNotFoundException e){
            System.out.println("File not found. Please try again.");
            System.exit(0);
        }
        int index = 0; 
        while(fileReader.hasNext()){
            String name = fileReader.next();
            int numOfStations = fileReader.nextInt(); //Will be used to create the array of size : # of stations.
            fileReader.nextLine();
            String allStations = fileReader.nextLine(); //Will grab all the transit lines and store it inside one String.
            arrayOfLines[index] = new Line(numOfStations, name); //new Line object. Has a number of Stations and a name. 
            String[] station = allStations.split(",");
            for(String n: station){
                arrayOfLines[index].addStation(n); //Will add stations one by one. For each loop takes care of increments.
            }
            index++;
        } 
        fileReader.close();

    }

    /**
     * The hasRoute method will check if it is possible to get from startStation to endStation. 
     * hasRoute is only used to check if you can get from start to end in the same Line. It won't check for transfers.
     * 
     */
    public boolean hasRoute(){
        for(int i = 0; i < arrayOfLines.length; i++){
            if(arrayOfLines[i].hasStation(startStation) && arrayOfLines[i].hasStation(endStation)){
                lineName = arrayOfLines[i].getName();
                return true;
            }

        } return false;
    }

    /**
     * The printRoute method will print the output of the destination, there are three possible scenarios,
     * and the printRoute method is capable of printing any of these three:
     * 1) The startStation and endStation are in the same Line.
     * 2) You can transfer one to another Station to get to your desired destination, you can only transfer once, and in the forward direction.
     * 3) Invalid input, or you want to get somewhere but you'd have to go backwards on the Line,or transfer twice, which is not assumed to be possible.
     */
    public void printRoute(){
        if(hasRoute()){ //If you can get from startStation to endStation on the same line, you can take this line.
            System.out.print("Take the "+ lineName + " Line from "+startStation+ " to "+endStation);
        }
        else if(!hasRoute()){
            //In place for the name of the lines.
            String startingLine = "";
            String endLineName = "";
            //In place for name of Transfer station.
            String transfer="";

            int startingIndex = 0;
            int endingIndex=  0;
            //We'll change the array size later.
            String[] startLine = new String[0];
            String[] endLine = new String[0];

            for(int i = 0; i < arrayOfLines.length; i++){ // For all lines, check for start station
                if(arrayOfLines[i].hasStation(startStation)){ //If it has startStation, then true.
                    startingLine = arrayOfLines[i].getName(); //Uses the getter in Line to get the name of the line.
                    startLine = new String[arrayOfLines[i].getStations().length]; //Grabs the line that contains the starting station.
                    startLine = arrayOfLines[i].getStations(); //Gets all the stations using a getter in Line, puts into the startLine array.
                    startingIndex = i; //Keeps track of the position on the line where our starting station is, just in case since we can't go backwards.
                }
                if(arrayOfLines[i].hasStation(endStation)){ //Same thing except for end station.
                    endLineName = arrayOfLines[i].getName();
                    endLine = new String[arrayOfLines[i].getStations().length];
                    endLine = arrayOfLines[i].getStations();
                    endingIndex = i;
                }
                transfer = arrayOfLines[i].findTransfer(startLine, endLine); //Returns the station where you transfer to.
            }
            if(arrayOfLines[endingIndex].findEndLine(endStation, transfer, arrayOfLines[endingIndex].getStations())){
                System.out.println("Take the "+startingLine+" Line from "+startStation+", transfer to the "+endLineName+" Line at "+transfer+", and continue to "+endStation);

            }
            else{ //If all else fails... we'll assume there's no route.
                System.out.println("There is no route between stations "+startStation+" and "+endStation);

            }
        }
    }
}
