/*
 * Created on Aug 6, 2005
 * Accenture Manila Delivery Center
 * Technology Managed Services
 * Makati Stock Exchange Bldg
 * Makati City, Philippines
 */
package d1.driver;

/**
 * 
 * This class is the parent class of Drivers for JDS activities 
 * 
 * @author eugene.p.lozada
 *
 */
public abstract class BaseDriver {
    
    protected final Compare compare;
    
    public abstract void initialize();
    public abstract void start();
    
    public BaseDriver(){
        compare = new Compare();
    }
    
    public void printScore(){
        
        System.out.println("Score is " + compare.getScore() + "/" + compare.getCurrentTotal() + "=" + compare.getPercentage());
    }
}
