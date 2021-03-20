/*
 * Created on Aug 6, 2005
 * Accenture Manila Delivery Center
 * Technology Managed Services
 * Makati Stock Exchange Bldg
 * Makati City, Philippines
 */
package d1.driver;

/**
 * Compare is a utility class intended for the JDS Driver classes.  It is used to compare expected 
 * and actual results and track the number of results that match for scoring purposes.
 * 
 * @author eugene.p.lozada
 *
 */
public class Compare {
    
    private int total;
    private int score;
    
    public static final String ERROR="ERROR";
    public static final String CHECK="CHECK";    
    
    public int getScore(){
        return score;
    }
    
    public int getCurrentTotal(){
        return total;
    }
    
    public int getPercentage(){
       
        return (int) (100.0 / total * score);
    }
  
    public boolean sameObjects(String message, Object arg1, Object arg2){
        
        total++;
        System.out.println(message);
        if(arg1 == arg2){
            score++;
            System.out.println("Objects are the same..." + CHECK);
            System.out.println();
            return true;
        }
        else{
            System.out.println("Objects are different..." + ERROR);
            System.out.println();
            return false;
        }
    }
        
    
    public void printMessage(String message) {
        System.out.println("Test #" + (total+1) + ": " + message);
    }
    
    public boolean compare(Object expected, Object actual){
        
        total++;
        boolean result = false;;
        System.out.print("Expected Result=" + expected + " | " + "Actual Result=" + actual + "...");
        
        
        try{
	        result = expected.equals(actual);
	        if(result){
	            score++;
	        }
        }
        catch(NullPointerException e){
            if(expected != actual){
                System.out.println(ERROR);
                System.out.println();
                return false;
            }
            else{
                score++;
                System.out.println(CHECK);
                System.out.println();
                return true;
            }
        }
        System.out.println(result  ? CHECK : ERROR);
        System.out.println();
        return result;
        

    }
    
    public boolean compare(int expected, int actual){
      
        return compare(new Integer(expected), new Integer(actual));
    }

    public boolean compare(char expected, char actual){
        
          return compare(new Character(expected), new Character(actual));
    }
    
    public boolean compare(double expected, double actual){
        
          return compare(new Double(expected), new Double(actual));
    }
    
    public boolean compare(boolean expected, boolean actual){
        
          return compare(new Boolean(expected), new Boolean(actual));
    }
    
   	public void fail(String expectedResult, String actualResult){
   	    total++;
        System.out.println("Expected Result=" + expectedResult + " | " + "Actual Result=" + actualResult + "..." + ERROR);
        System.out.println();
   	}
    
    public void pass(String message){
        total++;
        score++;
        System.out.println(CHECK);
        System.out.println();
    }
    
    public String toString(){
        
        return getCurrentTotal() + "/" + getScore() + "=" + getPercentage();
    }
    
    
}
