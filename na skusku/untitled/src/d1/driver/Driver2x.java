/*
 * Created on Aug 8, 2005
 * Accenture Manila Delivery Center
 * Technology Managed Services
 * Makati Stock Exchange Bldg
 * Makati City, Philippines
 */
package d1.driver;

import java.util.Calendar;


import d1.datastore.ArrayStack;
import d1.profile.PlayerProfile;


/**
 * Driver class for Activity 2.0
 * 
 * @author eugene.p.lozada
 *
 */
public class Driver2x extends BaseDriver{

    private PlayerProfile data[];
    
    public void initialize() {
        
        data = new PlayerProfile[4];
        data[0] = new PlayerProfile("Eugene", PlayerProfile.MALE);
        data[0].setBirthDate(1977, 9, 13);
        data[1] = new PlayerProfile("Nadja", PlayerProfile.FEMALE);
        data[1].setBirthDate(1981, 8, 11);
        data[2] = new PlayerProfile("Toby", PlayerProfile.MALE);
        data[2].setBirthDate(1980, 5, 19);
        data[3] = new PlayerProfile("The OW", PlayerProfile.MALE);
        data[3].setBirthDate(Calendar.getInstance());
   
        
    }

    public void start() {
        
        ArrayStack stack = new ArrayStack(3);
        
        compare.printMessage("Stack of 3 created.  Calling Stack.getSize()");
        compare.compare(3,stack.getSize());
        compare.printMessage("Calling Stack.isFull()");
        compare.compare(false, stack.isFull());
        compare.printMessage(data[0].getName() + " entering stack");
        compare.compare(true, stack.push(data[0]));
        compare.printMessage(data[1].getName() + " entering stack");
        compare.compare(true, stack.push(data[1]));
        compare.printMessage(data[2].getName() + " entering stack");
        compare.compare(true, stack.push(data[2]));
        compare.printMessage(data[3].getName() + " entering stack");
        compare.compare(false, stack.push(data[3])); 
        compare.printMessage("Calling Stack.getCount()");
        compare.compare(3, stack.getCount());
        compare.printMessage("Calling Stack.isFull()");
        compare.compare(true, stack.isFull());
        compare.printMessage("Calling Stack.peek()");
        compare.compare(data[2].getName(), ((PlayerProfile)stack.peek()).getName());
        compare.printMessage("Calling Stack.pop()");
        compare.compare("Toby", ((PlayerProfile)stack.pop()).getName());
        compare.printMessage("Calling Stack.peek()");
        compare.compare("Nadja", ((PlayerProfile)stack.peek()).getName());
        compare.printMessage("Calling Stack.pop()");
        compare.compare("Nadja", ((PlayerProfile)stack.pop()).getName());
        compare.printMessage("Calling Stack.pop()");
        compare.compare("Eugene", ((PlayerProfile)stack.pop()).getName());
        compare.printMessage("Calling Stack.pop()");
        compare.compare(null, stack.pop());
        compare.printMessage("Calling Stack.hasNext()");
        compare.compare(null, stack.peek());
        compare.printMessage("Calling Stack.getCount()");
        compare.compare(0, stack.getCount());
    }
    
    public static void main2(String arg[]){
	    
	    Driver2x driver = new Driver2x();
	    driver.initialize();
	    driver.start();
	    driver.printScore();
	}
    
    

}
