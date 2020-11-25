import java.util.*;
import java.io.*;
/**
 * The class Line is in charge of the Line object and its contents (such as the arrays.) 
 *
 * Alex Lai
 * Wednesday, November 27 2019
 */
public class Line
{
    /**
     * The lineName stores the line's name. The int lineSize stores the size of the line.
     * The String array allStations stores the transit stations. The int index keeps track of where in the array it is.
     */
    private String lineName;
    private int lineSize;
    private String[] allStations;
    private int index;
    /**
     * For every line object, we have an array of Strings, the size of number of stations.
     * setName will use the setter to set the name, and the constructor will set the size of the array.
     */
    public Line (int size, String name){
        allStations = new String [size];
        setName(name); //setter
        this.lineSize = size; //acts like a setter, but it used inside the constructor for convienience.
    }

    /**
     * This method adds a station to the array inside the Line object. A loop in TransitSystem takes care of the increment.
     * @param station - the Transit station.
     */
    public void addStation(String station){
        allStations[index] = station;
        index++;
    }

    /**
     * The hasStation method returns a boolean
     * @param station - the Transit station.
     */
    public boolean hasStation(String station){
        for(int i = 0; i < allStations.length; i++){
            if(station.equals(allStations[i])){
                return true;
            }
        }
        return false;
    }

    /**
     * getStations is a getter method.
     * @return - the array of Stations in a line.
     */
    public String[] getStations (){
        return this.allStations;
    }

    /**
     * findTransfer finds a station where the user can transfer to. It works in transit with the findEndLine method
     * which comes after this to check the order.
     * @param startLine - array with that contains the starting station.
     * @param endLine - array that contains the destination station.
     * @return - the canidate station that can be transferred to.
     */
    public String findTransfer(String[] startLine, String[] endLine){
        String transfer = "";
        for(int j = 0; j < startLine.length; j++){
            for(int k = 0; k < endLine.length; k++){
                if(startLine[j].equals(endLine[k])){
                    transfer = endLine[k];
                    return endLine[k];
                }
            }
        }
        return transfer;
    }

    /**
     * findEndLine is a method only used when the destination has a transfer to another station. It 
     * makes sure the user can only transfer if they go forward in the lines by comparing the indexes.
     * @param endStation - The destination the user desires.
     * @param transfer - The station that the user has to transfer to if they want to reach their destination.
     * @param endLine - The line that contains the endStation.
     * @return - true if the the user cant transfer to a station in front of them, false if the station they want to transfer to is behind them.
     */
    public boolean findEndLine (String endStation, String transfer, String[] endLine){
        int i = 0;
        int length = endLine.length;
        try{
            while(!transfer.equals(endLine[i])){
                i++;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
        for(int j = i; j < length; j++){
            if(endLine[j].equals(endStation)){
                return true;
            }
        }
        return false;
    }

    /**
     * Getter that retrieves a line name.
     * @return 
     */
    public String getName(){
        return this.lineName;
    }

    /**
     * Setter that sets the line name
     * @param n Name of the line, which comes from the file.
     */
    public void setName(String n){
        this.lineName = n;
    }

}
