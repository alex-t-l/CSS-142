import java.util.Scanner;
import java.lang.Math;
/**
 * This class contains the methods that will compute the values, and sort the users input. It also counts the duplicates.
 *
 * Alex Lai
 * Tuesday, November 26 2019
 */
public class Race
{
    /**
     * Public nums array, the user's input ends up being sorted.
    firstPlace to thirdPlace are the values of the racer's standings.
     */
    public double[] nums; 
    public double firstPlace = 0;
    public double secondPlace = 0;
    public double thirdPlace = 0;
    /**
     * firstPlaceCount to thirdPlaceCount counts the amount of times a duplicate appears. 
     */
    public int firstPlaceCount = 0;
    public int secondPlaceCount = 0;
    public int thirdPlaceCount = 0;
    /**
     * The readInTimes method will assign the String of numbers the user typed into an array of numbers. 
     * For example, user inputs "3 5 1 1", it returns [3, 5, 1, 1]
     * @param raceTimes - the String of numbers the user inputs, all in one line separated by spaces.
     * @return - the array of numbers in the order the user typed it in.
     */
    public double[] readInTimes(String raceTimes){ 
        String[] input = raceTimes.split(" ");
        double[] nums = new double [input.length]; //Easily takes the input[]'s length after it is split.
        for(int i = 0; i < input.length; i++){
            nums[i]=Double.parseDouble(input[i]); //parseDouble() will parse String into double.
        }  
        return nums;
    }

    /**
     * The sortTimesAscending method will sort the inputted numbers into an orderly format of ascending order. 
     * For example, user inputs "3, 5, 1, 1", it returns [1, 1, 3, 5]
     * @param nums - array of the user's race times, assumingly not sorted yet.
     * @return - the array sorted from least to greatest in ascending order.
     */
    public double[] sortTimesAscending(double nums[]){ //Sorts the numbers from least to greatest.
        for(int i = 0; i < nums.length-1 ; i++){
            for(int j = 0; j < nums.length-i-1; j++){
                if(nums[j] > nums[j+1]){
                    double temp = nums[j];
                    nums[j] = nums[j+1];  
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }

    /**
     * The findFastestTimes method will assign the first three numbers of the sorted array to 1st to 3rd place.
     * For example, the array [1, 5, 10], 1st place: 1.0 | 2nd place: 5.0 | 3rd place: 10.0
     * @param nums - the array of raceTimes, assumingly already sorted once this runs.
     */
    public void findFastestTimes (double nums[]){ 
        firstPlace = nums[0]; 
        secondPlace = nums[1];
        thirdPlace = nums [2];
    }

    /**
     * The findDuplicates method will increment the ints firstPlace, secondPlace, and thirdPlace.
     * For example, the array [1, 1, 1, 2, 2, 3, 3, 3, 5, 10, 999], firstPlaceCount is 3, secondPlaceCount is 2, thirdPlaceCount is 3.
     * @param nums - the array of raceTimes, assumingly already sorted once this runs.
     */
    public void findDuplicates(double nums[]){
        for (int i = 0; i < nums.length; i++){
            if(nums[0] == nums[1]){
                if(nums[i] == firstPlace){
                    firstPlaceCount++;
                }
            }
            else if (nums[1]!=nums[0]){
                if(nums[1] == nums[i]){
                    secondPlaceCount++;
                }
            }
            if(nums[2] != nums[0] && nums[2] != nums[1]){
                if(nums[2] == nums[i]){
                    thirdPlaceCount++;
                }
            }
        }
    }
}

