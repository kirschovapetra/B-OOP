/*
 * Created on Aug 11, 2005
 * Accenture Manila Delivery Center
 * Technology Managed Services
 * Makati Stock Exchange Bldg
 * Makati City, Philippines
 */
package d1.driver;


import d1.datastore.ArrayStore;
import d1.profile.PlayerProfile;

public class Driver4x extends BaseDriver{

    PlayerProfile data[];
    
    public void initialize() {
        data = new PlayerProfile[5];
        
        
        data[0] = new PlayerProfile("Stupendous Man", PlayerProfile.MALE);
        data[0].setBirthDate(1977, 9, 13);
        data[1] = new PlayerProfile("The Homemaker", PlayerProfile.FEMALE);
        data[1].setBirthDate(1981, 8, 11);
        data[2] = new PlayerProfile("Captain Obvious", PlayerProfile.MALE);
        data[2].setBirthDate(1980, 5, 19);
        data[3] = new PlayerProfile("The Procrastinator", PlayerProfile.MALE);
        data[3].setBirthDate(1, 1, 1);
        data[4] = new PlayerProfile("The Amazing Narcoleptic", PlayerProfile.MALE);
        data[4].setBirthDate(9999, 12, 31);
    
        
    }

    public void start() {
        ArrayStore store = new ArrayStore(4);
	    compare.printMessage("Store of 4 created. Calling store.getSize()");
	    compare.compare(4, store.getSize());
	    compare.printMessage("Adding " + data[0].getName());
        compare.compare(true, store.add(data[0]));
	    compare.printMessage("Adding " + data[1].getName());
	    compare.compare(true, store.add(data[1]));
	    compare.printMessage("Adding " + data[2].getName());
	    compare.compare(true, store.add(data[2]));
	    compare.printMessage("Adding " + data[3].getName());
	    compare.compare(true, store.add(data[3]));
	    compare.printMessage("Adding " + data[4].getName());
	    compare.compare(false, store.add(data[4]));
	    compare.printMessage("Finding " + data[2].getName());
	    compare.compare(2, store.find(data[2]));
	    compare.printMessage("Removing " + data[2].getName());
	    compare.compare(true, store.remove(data[2]));
	    compare.printMessage("Inserting in index 1 " + data[4].getName());
	    compare.compare(true, store.insert(data[4], 1));
	    compare.printMessage("Removing first object");
	    compare.compare(data[0].getName(), ((PlayerProfile)store.remove(0)).getName());
	    compare.printMessage("Removing last object");
	    compare.compare(data[3].getName(), ((PlayerProfile)store.remove(2)).getName());
	    compare.printMessage("Adding object already present: " + data[4].getName());
	    compare.compare(true, store.add(data[4]));
	    compare.printMessage("Checking first index");
	    compare.compare(data[4].getName(),  ((PlayerProfile)store.check(0)).getName());
	    compare.printMessage("Checking object count ");
	    compare.compare(3, store.getCount());
        
	    compare.printMessage("Null entering store ");
        try{
            store.add(null);
            compare.fail("java.lang.IllegalArgumentException", "No exception thrown");
        }catch(Exception ex){
            compare.compare(IllegalArgumentException.class.getName(), ex.getClass().getName());
        }
        
        compare.printMessage("Removing a null");
        try{
            store.remove(null);
            compare.fail("java.lang.IllegalArgumentException", "No exception thrown");
        }catch(Exception ex){
            compare.compare(IllegalArgumentException.class.getName(), ex.getClass().getName());
        }
        
        compare.printMessage("Removing using an invalid index");
        try{
            store.remove(-1);
            compare.fail("java.lang.ArrayIndexOutOfBoundsException", "No exception thrown");
        }catch(Exception ex){
            compare.compare(ArrayIndexOutOfBoundsException.class.getName(), ex.getClass().getName());
        }
        
        compare.printMessage("Inserting a null");
        try{
            store.insert(null, 0);
            compare.fail("java.lang.IllegalArgumentException", "No exception thrown");
        }catch(Exception ex){
            compare.compare(IllegalArgumentException.class.getName(), ex.getClass().getName());
        }
        
        compare.printMessage("Inserting in an invalid index");
        try{
            store.insert(data[0], -1);
            compare.fail("java.lang.IllegalArgumentException", "No exception thrown");
        }catch(Exception ex){
            compare.compare(IllegalArgumentException.class.getName(), ex.getClass().getName());
        }
        
        
    }
    
    public static void main4(String arg[]){
        
        Driver4x driver = new Driver4x();
        driver.initialize();
        driver.start();
        driver.printScore();
    }

}
