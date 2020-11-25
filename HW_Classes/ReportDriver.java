import java.util.Scanner;
import java.util.*;
/**
 * The ReportDriver class contains the main method where you are asked to input the Race times.
 * This method also contains a test method where you can test the values of your first race.
 * Alex Lai
 * Tuesday, November 26 2019
 */
public class ReportDriver
{
    public static void main (String[] args){
        Race myRace = new Race();
        RaceReport myRaceReport = new RaceReport();
        Scanner keyboard = new Scanner (System.in);
        System.out.println("Enter the race times (in seconds):");
        String raceTimes = keyboard.nextLine();
        double[] nums = myRace.readInTimes(raceTimes);
        double[] sortedNums = myRace.sortTimesAscending(nums);
        myRace.findFastestTimes(sortedNums);
        myRace.findDuplicates(sortedNums);
        myRaceReport.writeReport(myRace.firstPlace, myRace.secondPlace, myRace.thirdPlace, myRace.firstPlaceCount, myRace.secondPlaceCount, myRace.thirdPlaceCount);
        /**
        For the testing method, you can only test the numbers you've inputted for the FIRST race. For the second race, you can't test the variables there.
         */
        //testVariables(sortedNums, myRace.firstPlace, myRace.secondPlace, myRace.thirdPlace, myRace.firstPlaceCount, myRace.secondPlaceCount, myRace.thirdPlaceCount);
        System.out.println();
        System.out.println("Enter another race? (y/n): ");
        while(keyboard.nextLine().equals("y")){
            Race myRace2 = new Race();
            RaceReport myRaceReport2 = new RaceReport();
            System.out.println("Enter the race times (in seconds):");
            String raceTimes2 = keyboard.nextLine();
            double[] nums2 = myRace.readInTimes(raceTimes2);
            double[] sortedNums2 = myRace.sortTimesAscending(nums2);
            myRace2.findFastestTimes(sortedNums2);
            myRace2.findDuplicates(sortedNums2);
            myRaceReport.writeReport(myRace2.firstPlace, myRace2.secondPlace, myRace2.thirdPlace, myRace2.firstPlaceCount, myRace2.secondPlaceCount, myRace2.thirdPlaceCount);
            System.out.println("\n"+
                "\n");
            System.out.println("Enter another race? (y/n): ");
        }
        System.exit(0);
    }

    /**
     * The testVariables method will print out the sorted array, 1st to 3rd place values, and 1st to 3rd place count.
     * @param sortedNums - array of sorted race times 
     * @param firstPlace - racer who scored the fastest
     * @param secondPlace - racer who scored the second fastest, can be a duplicate
     * @param thirdPlace - racer who scored the third fastest, can be a duplicate
     * @param firstPlaceCount - final incremented value counting first place value repeats
     * @param secondPlaceCount - final incremented value counting second place value repeats
     * @param thirdPlaceCount) - final incremented value counting third place value repeats
     */
    public static void testVariables(double[] sortedNums, double firstPlace, double secondPlace, double thirdPlace, int firstPlaceCount, int secondPlaceCount, int thirdPlaceCount){
        System.out.println("You ran the test variables method...");
        System.out.println("Sorted Array (least to greatest): " +Arrays.toString(sortedNums)+
            "\nFirst Place: "+ firstPlace +
            "\nSecond Place: "+ secondPlace +
            "\nThird Place: "+ thirdPlace +
            "\nFirst Place Count (how many times the first place number occured: "+ firstPlaceCount +
            "\nSecond Place Count (how many times the second place number occured: "+ secondPlaceCount +
            "\nThird Place Count (how many times the third place number occured: "+ thirdPlaceCount);

    }
}
 