import java.io.*;
import java.util.*;
public class ObjectList {
    private FractionCounter[] listOfFractions;
    private Fraction[] fract;
    private int num = 0; //number of index?
    public ObjectList(int lines) {
        listOfFractions = new FractionCounter[lines];
        fract = new Fraction [lines];
    }

    public void add(Object next) {
        listOfFractions[num] = (FractionCounter) next;
        num++;
        System.out.println(Arrays.toString(fract));
    }

    
    public int length() {
        return listOfFractions.length;
    }

    public String toString() {
        return this.toString();
    }

    public Object get(int index) {
        return listOfFractions[index];
    }
    
    public FractionCounter[] getFC (){
        return listOfFractions;
    }

    public static void main(String[] args) {
        Scanner countLines = null;
        try {
            countLines = new Scanner (new FileInputStream("fractions.txt"));
        }
        catch(FileNotFoundException e) {
            System.out.println("Fatal error, file not found. Please move it to the proper spot.");
            System.exit(0);
        }
        int lines = 0;
        while(countLines.hasNextLine()){
            countLines.nextLine();
            lines++;
        }
        countLines.close();
        Scanner fileReader = null;
        try {
            fileReader = new Scanner (new FileInputStream("fractions.txt"));
        }
        catch(FileNotFoundException e) {
            System.out.println("Fatal error, file not found. Please move it to the proper spot.");
            System.exit(0);
        }
        ObjectList list;
        ObjectList ol = new ObjectList(lines);
        while(fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            String[] nums = new String [2];
            nums = line.split("/");
            Fraction f = new Fraction (Integer.parseInt(nums[0]),Integer.parseInt(nums[1]));
           
            FractionCounter fc = new FractionCounter(f);
           for(int i = 0 ; i < ol.length(); i++){ 
           fc.compareAndIncrement();
        }
            ol.add(fc);

        }
    }
}
