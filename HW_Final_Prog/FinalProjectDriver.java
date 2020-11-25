import java.util.Scanner;
import java.util.*;
import java.io.*;
/**
 * The FinalProjectDriver class has the main method which instantiates the TransitSystemClass. 
 * This class uses the other two classes to find and print the route.
 *
 * Alex Lai
 * Wednesday, November 27 2019
 */
public class FinalProjectDriver
{
    /**
     * The main method has a try catch that catches index out of bound errors - these errors indicate an invalid input.
     * Once it catches this "invalid input," it stops the program. This method gives the startStation and endStation 
     * to the Transit System, so it can use it to process the route.
     * 
     * @param args
     */
    public static void main (String[] args){
        boolean runProgram = true; //Just a boolean that keeps the program running, and checking for more input.
        //Note: If you enter the format wrong, or enter something random, it will stop the program. 
        try{
            while(runProgram){
                Scanner keyboard = new Scanner (System.in);
                System.out.println("Enter two stations, separated by a comma, with a space after the comma.");
                String userInput = keyboard.nextLine();
                String[] input = userInput.split(", ");
                TransitSystem transit = new TransitSystem("data", input[0], input[1]);
                transit.readLines();
                transit.hasRoute(); 
                transit.printRoute();
                System.out.println();       
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            //Easy to stop the program. Just type anything without a comma.
            System.out.println("Thank you for using the Transit System. Have a wonderful day.");
            System.exit(0);
        }
    }
}