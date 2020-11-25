import java.util.Scanner;
import java.util.*;

/**
 * Description of this class here
 */

public class Lab5 {
    public static void main(String[] args)  {
        System.out.println("      Welcome to Lab5!"
            +"\nEnter 1 to check how long it takes to get rich on a magic dollar coin."
            +"\nEnter 2 to calculate e^x for any real x."
            +"\nEnter 3 to enter palindrome words."
            +"\nEnter 4 to re-print the menu."
            +"\nEnter 0 to exit.");

        run();
    }

    public static void run (){
        Scanner sc = new Scanner(System.in); 
        System.out.println("What is your choice?");
        int input = sc.nextInt();
        

        switch (input){
            case 0:
            System.out.println("Thanks for participating. Goodbye.");
            System.exit(0);
            break;
            case 1:
            getRichQuick(); 
            run();
            break;
            case 2:
            System.out.println("Please input a number for x, we will calculate e^x.");
            Scanner ex= new Scanner(System.in);
            double x= ex.nextDouble();
            double taylorResult = eTaylor(x);
            eTaylor(taylorResult);
            System.out.println(taylorResult);
            run();
            break;
            case 3:
            palindromeCheck(); 
            run();
            break;
            case 4:
            System.out.println("Enter 1 to check how long it takes to get rich on a magic dollar coin."
                +"\nEnter 2 to calculate e^x for any real x."
                +"\nEnter 3 to enter palindrome words."
                +"\nEnter 4 to re-print the menu."
                +"\nEnter 0 to exit.");
            run();
            break;
        }

        System.out.println("Thanks for participating. Goodbye.");
        System.exit(0);
    }

    // Part 1
    public static void getRichQuick() {
        // Declare your variables here and implement your logic
        double money = 1;
        System.out.println("Day 1: $1");
        double gethalf;
        while (money <= 1000000){
            for (int day = 2; money<=1000000 ;day++ ){
                double total=money;
                gethalf=total*0.5;
                money=money+gethalf;
                double output= total+ gethalf+ 1;
                money++;
                System.out.println("Day "+day+ ": "+total +" + (" + "$1 + "+ gethalf+") = $"+money);

            }
        }
    }
    // Part 2 
    public static double eTaylor(double x) {
        double taylorNumber = 0.0;

        // Your logic goes here 
        taylorNumber=1;
        int i=2;

        while (eTaylorHelper(x,i) >= 10e-16){
            taylorNumber += eTaylorHelper(x,i);
            i++;
        } 

        return taylorNumber;
    }         

    public static double eTaylorHelper(double x, int n){
        double squareValue = n;
        for(int i=1; i<n; i++){
            squareValue *= x;
        }
        double factorial = 1;
        for(int j=1; j<=n; j++){
            factorial *= j;
        } 
        return squareValue / factorial;
    }

    // Part 3
    /**
     * This program reads words, identifies, counts and writes all the palindromes and the total
     * palindrome count.
     * 
     * // hint 1: Using keybord.next() will only return what comes before a space.
    // hint 2: Using keybord.nextLine() automatically reads the entire current line.
     */
    public static void palindromeCheck(){

        String someWord = " "; // Stores words read from user input
        int count = 0;   
        int words=0;
        // keeps track of Palindrome words only (define algorithm to count # of palindrome word 

        System.out.println(" Enter some words separated by white space");    // Ask for user input
        // declare your Scanner object here
        Scanner keyboard = new Scanner(System.in);
        someWord= keyboard.nextLine();
        Scanner anotherScanner = new Scanner(someWord);
        //for each word user enters

        while (anotherScanner.hasNext()){
            String scanWord = anotherScanner.next();          // store each word in a string variable and then do your operations             
            boolean palindrome = isPalindrome(scanWord);

            if (isPalindrome(scanWord) == true){
                count++;
            }
            words++;

        }
        System.out.println("There are  " + count + " palindromes out of " + words+ " words provided by user.");

    }

    public static boolean isPalindrome (String someWord){

        for(int i = 0; i <someWord.length(); i++){
            int backwards = someWord.length()-1;
            backwards -= i;
            if (someWord.charAt(i)==someWord.charAt(backwards)){
                continue;}
            else if (someWord.charAt(i)!=someWord.charAt(backwards)){
                return false;}
        }
        return true;
    }

}

