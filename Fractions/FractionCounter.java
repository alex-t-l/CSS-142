
public class FractionCounter {
    private int counter = 0;
    private Fraction fraction;

    public FractionCounter(Fraction theFraction) {
        this.fraction = theFraction;
    }

    public boolean compareAndIncrement(Fraction f) {	
        if(this.fraction.equals(f)) {
            this.counter++;
            return true;
        }
        else {
            return false;
        }
    }

    public String toString() {
        return this.fraction +" has a count of " + this.counter;
    }
}
