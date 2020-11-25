public class Fraction {
    private int n; //'n' stands for numerator
    private int d; //'d' stands for denominator
    public Fraction() {  //The default no-argument constructor
    }

    public Fraction(int num, int den) {
        this.n = num;
        this.d = den;
        this.findGCD();
    }

    public void findGCD() {
        int n1= this.n;
        if(n1 < 0) {
            n1 /= -1;
        }
        int n2 = this.d;
        if(n2 < 0) {
            n2 /= -1;
        }
        while (n1 != n2) {
            if(n1 > n2) {
                n1 -= n2;
            }
            else {
                n2 -= n1;
            }
        }
        this.n /= n2;
        this.d /= n2;
    }

    public boolean equals(Object o) {
        if(o == null) { 
            return false;
        }
        if(!(o instanceof Fraction)) { //if "o" is not a fraction, return false, instance of checks for that.
            return false;
        }
        Fraction that = (Fraction)o;
        double thisDouble = (double)getNumerator()/(double)getDenominator(); //gets double value of this fraction
        double thatDouble = (double)that.getNumerator()/(double)that.getDenominator(); //other double value fraction
        return thisDouble == thatDouble;
    }

    public int getNumerator() {
        return this.n;
    }

    public void setNumerator(int num) {
        this.n = num;
    }

    public int getDenominator() {
        return this.d;
    }

    public void setDenominator(int den) {
        this.d = den;
    }

    public String toString() {
        return getNumerator()+"/"+getDenominator();
    }

    public static void main(String[] args) {
    }
}
