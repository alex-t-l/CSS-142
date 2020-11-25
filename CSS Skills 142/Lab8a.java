import java.util.*;
/**
 * Write a description of class Lab8a here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lab8a {
    /**
     * main method for testing the above methods
     */
    public static void main(String[] args) {
        //for exercises 1, 2
        double[] oddSet = {0.5, 3.1415, 7.6, 42, 799.4};
        double[] evenSet = {0.5, 2.2, 3.1415, 7.6, 42, 799.4};
        double[] notSorted = {3.4, 0.01, 8.7, 2.3};

        System.out.println("Exercise 1: ");
        System.out.println(median(oddSet));
        System.out.println(median(evenSet));
        System.out.println();

        System.out.println("Exercise 2: ");
        System.out.println(isSorted(evenSet));
        System.out.println(isSorted(notSorted));
        System.out.println();

        //for exercises 3, 4, 5
        int[] a1 = {3, 8, 5, 6, 5, 8, 9, 2};
        int[] a2 = {5, 15, 4, 6, 7, 3, 9, 11, 9, 3, 12, 13, 14, 9, 5, 3, 13};
        int[] common = new int[a1.length];

        System.out.println("Exercise 3: ");
        findCommon(a1,a2,common);

        System.out.println();
        System.out.println("Exercise 4: ");
        int[] thing= {3, 8, 19, 7};
        System.out.println(rotateRight(thing));

        System.out.println();
        System.out.println("Exercise 5: ");
        int[] b= {3, 5, 2, 1, 92, 38, 3, 14, 5, 73};
        int target= 3;
        System.out.println(count(b,target));

        System.out.println();
        System.out.println("Exercise 6: ");
        int[] c= {18, 7, 4, 24, 11};

    System.out.println(stretch(c));
}

/**
 * Exercise 1:
 * Write a function called median, that takes as parameter a full, sorted
 * array of doubles and returns the median of the list. For a sorted list of
 * odd length, the median is the middle value. For a sorted list of even
 * length, the median is the average of the two middle values. Make an example
 * function call in your main.
 */
public static double median(double [] array) {
int arrayLength= array.length;
if (arrayLength%2==0){
int length = array.length;
double evennum=array[length/2]+array[(length/2)-1];
evennum=evennum/2;

return evennum; 
}
else {
double oddnum=  array[(array.length/2)];
return oddnum;
}
}

/**
 * Exercise 2:
 * Write a function called isSorted that takes an array of doubles as a 
 * parameter and returns true if the list is in sorted (non-decreasing) 
 * order and returns false otherwise.  Make an example function call in 
 * your main.
 * @param array
 * @return
 */
public static boolean isSorted(double[] array) {
boolean sorted = false;
for (int i=0 ; i < array.length-1 ; i++){
if(array[i]<array[i+1]){
sorted = true;
}
else{
sorted = false;
}
}
return sorted;
}

/**
/**
 * Exercise 3:
 * Write a function called findCommon that takes three arrays of positive
 * integers as parameters. The first two array parameters are filled with
 * ints. Fill the third array parameter with all the values that are uniquely
 * in common from the first two arrays and the rest of the array with zeros.
 * For example:
 * 
 * a1[] contains: 3 8 5 6 5 8 9 2
 * 
 * a2[] contains: 5 15 4 6 7 3 9 11 9 3 12 13 14 9 5 3 13
 * 
 * common[] should contain: 3 5 6 9 0 0 0 0
 */
public static void findCommon(int[] a1, int[]a2, int[] common) {
int count=0;
boolean isTheSame = false;
for(int i=0; i < a1.length; i++){
for (int j=0; j<a2.length; j++){
if(a1[i]==a2[j]){
for(int b=0;b < common.length; b++){
if(a1[i]==common[b]){
isTheSame = true;
}
}
if(isTheSame==false){
int num=a2[j];
common[count]=num;
count++;

}
isTheSame=false;
}
}

}
for(int a=count; a<common.length;a++){
common[a]=0;

}
System.out.println(Arrays.toString(common));
}

/**
 * Exercise 4:
 * Write a function called rotateRight that takes an array of integers as 
 * an argument and rotates values in the array one to the right (i.e., one 
 * forward in position), shifting the value at the end of the array to the 
 * front. For example, if the array called list stores [3, 8, 19, 7] before 
 * the function is called, it should store [7, 3, 8, 19] after the function 
 * is called. Another call on rotateRight would leave the list as [19, 7, 3, 8]. 
 * Another call would leave the list as [8, 19, 7, 3] .
 */
public static String rotateRight(int[] array) {
int[] newArray = new int [array.length];
for(int i=1; i<array.length;i++){
int num= array[i-1];
newArray[i]=num; 
}
newArray[0]=array[array.length-1];

return Arrays.toString(newArray);
// your code here
}

/**
 * Exercise 5:
 * Write a function count that takes an array of integers and a target value as 
 * parameters and returns the number of occurrences of the target value in the 
 * array. For example, if an array called list stores the sequence of values 
 * [3, 5, 2, 1, 92, 38, 3, 14, 5, 73] then the following call:
 * int n = count(list, 3);
 * would return 2 because there are 2 occurrences of the value 3 in the list.
 */
public static int count(int[] array, int target) {
int count = 0;
for(int i = 0; i < array.length; i++){
if (array[i]==target){
count++;
}

} 
return count;
}

/**
 * Exercise 6:
 * Write a function called stretch that takes an array of integers as an
 * argument, and returns a new array twice as large as the original that
 * 'replaces' every integer from the original list with a pair of integers,
 * each half the original, and then returns it. If a number in the original
 * list is odd, then the first number in the new pair should be one higher
 * than the second so that the sum equals the original number. For example,
 * suppose a variable called list stores this sequence of values
 * 
 * [18, 7, 4, 24, 11]
 * 
 * The number 18 is stretched into the pair (9, 9), the number 7 is stretched
 * into (4, 3), the number 4 is stretched into (2, 2), the number 24 is
 * stretched into (12, 12) and the number 11 is stretched into (6, 5).
 * Thus,the call:
 * 
 * stretch(list);
 * 
 * should replace list with the following list which is twice the length of
 * the original:
 * 
 * [9, 9, 4, 3, 2, 2, 12, 12, 6, 5]
 */

public static String stretch(int[] array) {
int[] newArray = new int [array.length*2];
int count=0;
for(int i=0; i<array.length;i++){
if(array[i]%2==0){
newArray[count]=array[i]/2;
newArray[count+1]=array[i]/2;
count += 2;
}
else{
newArray[count]=array[i]-array[i]/2;
newArray[count+1]=array[i]/2;
count += 2;
}

}
return Arrays.toString(newArray);
}
}

