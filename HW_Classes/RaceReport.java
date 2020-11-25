/**
 * RaceReport contains the writeReport method which prints out the results.
 * Alex Lai
 * Tuesday, November 26 2019
 */
public class RaceReport
{
    /**
     * The writeReport method will print out the top three finishers of the race, and it there are duplicates: the program will output DUPLICATES that finished in the same position.
     * However, for DUPLICATES, if there are to sets of duplicates for example (1st place: 1, 1, 1|2nd place: 2, 2, 2 | 3rd Place: 3, 3, 3, 3)- the program will only output the
     * highest ranked duplicates.... So for our example it will output "Three racers shared first place." If you were to give it a bunch of the same number like (1, 1, 1, 1, 1),
     * the program will say that "5 users shared first place." Also works for second and third place.... vice versa. 
     * 
     * @param firstPlace - racer who scored the fastest
     * @param secondPlace - racer who scored the second fastest, can be a duplicate
     * @param thirdPlace - racer who scored the third fastest, can be a duplicate
     * @param firstPlaceCount - final incremented value counting first place value repeats
     * @param secondPlaceCount - final incremented value counting second place value repeats
     * @param thirdPlaceCount) - final incremented value counting third place value repeats
     */
    public void writeReport(double firstPlace, double secondPlace, double thirdPlace, int firstPlaceCount, int secondPlaceCount, int thirdPlaceCount){
        String sharedPosition = "";
        if(firstPlaceCount > 3){  
            sharedPosition = firstPlaceCount + " racers shared first place.";
        }
        else if (firstPlaceCount == 2){
            sharedPosition = "Two racers shared first place.";
        }     
        else if (firstPlaceCount == 3){
            sharedPosition = "Three racers shared first place.";
        }
        if(secondPlaceCount > 3){
            sharedPosition += secondPlaceCount + " racers shared second place.";
        }
        else if (secondPlaceCount == 2){
            sharedPosition = "Two racers shared second place.";
        }     
        else if (secondPlaceCount == 3){
            sharedPosition = "Three racers shared second place.";
        }
        if(thirdPlaceCount > 3){
            sharedPosition += thirdPlaceCount + " racers shared third place.";
        }
        else if (thirdPlaceCount == 2){
            sharedPosition = "Two racers shared third place.";
        }     
        else if (thirdPlaceCount == 3){
            sharedPosition = "Three racers shared third place.";
        }

        System.out.println("First place (time in seconds): " + firstPlace +
            "\nSecond place (time in seconds): " + secondPlace +
            "\nThird place (time in seconds): " + thirdPlace +
            "\n"+
            "\n"+ sharedPosition);

    }
}
