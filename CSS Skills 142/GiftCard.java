/**
 * GiftCard.java
 * CSS142
 * 
 * Skeleton file for a basic giftcard class; useful to set, report, and
 * manage deductions
 */

public class GiftCard {
    //todo: class-level instance variables go here
    public double currentBalance;
    public GiftCard(double num) //constructers dont need type
    {
        currentBalance = num;
    }
    
    public GiftCard(){
        currentBalance = 0;
    }

    // Constructor

    //an example method that needs instance data to be declared first
    public void resetToZero(){
        currentBalance = 0;
        System.out.println("resetter to zero: " + currentBalance + "\n");
    }

    public void setBalance(double num){
        currentBalance = num;
    }

    public void deduct(double num){   
        if (num >= currentBalance){
            System.out.println("Cannot deduct, gift card would be negative or $0.");
        }
        else{
        currentBalance-= num;
    }
    }

    public void report(){
        System.out.print(" "+currentBalance);
    }

    public static void main(String[] args) {
        GiftCard card1 = new GiftCard();

        card1.setBalance(50);

        System.out.print("card1 value is :");
        card1.report();
        System.out.println();

        GiftCard card2 = new GiftCard();

        card2.setBalance(100);
         System.out.println();
        System.out.print("card2 value is :");
        card2.report();
         System.out.println();

        card2.deduct(101);
         System.out.println();
        System.out.println(" After deducting $101, card2's new balance is :");
        card2.report();

        card1.deduct(12.50);
         System.out.println();
        System.out.println(" After deducting $12.50, card1's new balance is :");
         System.out.println();
        card1.report();
        
        
        card1.resetToZero();
        card1.report();
         System.out.println();
        card2.resetToZero();
         System.out.println();
        card2.report();

        // User defined constructor
        GiftCard card3 = new GiftCard(5000.00);
        System.out.println("\nSetting the new balance to 7500.99 ");
        card3.setBalance(7500.99);
    }


}
