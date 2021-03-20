/*
 * Created on Aug 5, 2005
 * Accenture Manila Delivery Center
 * Technology Managed Services
 * Makati Stock Exchange Bldg
 * Makati City, Philippines
 */
package d1.driver;


import d1.datastore.ArrayQueue;
import d1.profile.PlayerProfile;

/**
 * Driver for activity 2.1
 * 
 * @author eugene.p.lozada
 */
public class Driver3x extends BaseDriver{

    	private PlayerProfile data[];
    	
    	
    	public void initialize(){
    	    
    	    data = new PlayerProfile[5];
    	
            data[0] = new PlayerProfile("Eugene", PlayerProfile.MALE);
            data[0].setBirthDate(1977, 9, 13);
            data[1] = new PlayerProfile("Nadja", PlayerProfile.FEMALE);
            data[1].setBirthDate(1981, 8, 11);
            data[2] = new PlayerProfile("Toby", PlayerProfile.MALE);
            data[2].setBirthDate(1980, 5, 19);
            data[3] = new PlayerProfile("Mr. Procrastinator", PlayerProfile.MALE);
            data[3].setBirthDate(1, 1, 1);
            data[4] = new PlayerProfile("Ms. Last In Line", PlayerProfile.MALE);
            data[4].setBirthDate(9999, 12, 31);
    	}
    
    	public void start(){
    	 
    	    ArrayQueue q = new ArrayQueue(3);
    	    compare.printMessage("Queue of 3 created. Calling Queue.getSize()");
    	    compare.compare(3, q.getSize());
    	    compare.printMessage("Calling Queue.isFull()");
    	    compare.compare(false, q.isFull());	
    	    
    	    compare.printMessage(data[0].getName() + " entering queue. ");
    	    compare.compare(true, q.enqueue(data[0]));
    	    compare.printMessage(data[1].getName() + " entering queue. ");
    	    compare.compare(true, q.enqueue(data[1]));
    	    compare.printMessage(data[2].getName() + " entering queue. ");
    	    compare.compare(true, q.enqueue(data[2]));
    	    compare.printMessage(data[3].getName() + " entering queue. ");
    	    compare.compare(false, q.enqueue(data[3]));
    	    compare.printMessage("Calling Queue.isFull()");
    	    compare.compare(true, q.isFull());	
    	    compare.printMessage(data[2].getName() + " entering queue. ");
    	    compare.compare(false, q.enqueue(data[2]));
                   
    	    compare.printMessage("Getting queue count");
    	    compare.compare(3, q.getCount());
    	    
    	    compare.printMessage("Finding " + data[1].getName());
    	    compare.compare(1, q.find(data[1]));
    	    compare.printMessage("Finding " + data[3].getName());
    	    compare.compare(ArrayQueue.NOT_IN_STRUCTURE, q.find(data[3]));
    	    compare.printMessage("Calling Queue.check(2)");
    	    compare.compare(data[2].getName(), ((PlayerProfile)q.check(2)).getName());
            
            
    	    compare.printMessage("Checking next in queue");
    	    compare.compare("Eugene", ((PlayerProfile)q.checkNext()).getName());
    	    compare.printMessage("Getting next in queue");
    	    compare.compare("Eugene", ((PlayerProfile)q.dequeue()).getName());
    	    compare.printMessage("Getting next in queue");
    	    compare.compare("Nadja", ((PlayerProfile)q.dequeue()).getName());
    	    compare.printMessage("Finding " + data[2].getName());
    	    compare.compare(0, q.find(data[2]));
    	    compare.printMessage("Calling Queue.hasNext()");
    	    compare.compare(true, q.hasNext());
    	    
    	    compare.printMessage("Getting queue count");
    	    compare.compare(1, q.getCount());
    	    compare.printMessage("Getting next in queue");
    	    compare.compare("Toby", ((PlayerProfile)q.dequeue()).getName());
    	    compare.printMessage("Getting next in queue");
    	    compare.compare(null, q.dequeue());
    	    compare.printMessage("Calling Queue.hasNext()");
    	    compare.compare(false, q.hasNext());
    	    
    	    compare.printMessage(data[3].getName() + " entering queue. ");
    	    compare.compare(true, q.enqueue(data[3]));
    	    compare.printMessage(data[2].getName() + " entering queue. ");
    	    compare.compare(true, q.enqueue(data[2]));
    	    compare.printMessage(data[1].getName() + " entering queue. ");
    	    compare.compare(true, q.enqueue(data[1]));
    	    compare.printMessage("Getting queue count");
    	    compare.compare(3, q.getCount());
    	    compare.printMessage("Calling Queue.check(2)");
    	    compare.compare(data[1].getName(), ((PlayerProfile)q.check(2)).getName());
        
    	    compare.printMessage("Null entering queue");
            try{
                q.enqueue(null);
                compare.fail("IllegalArgumentException expected", "No exception thrown");
            }catch(Exception ex){
                compare.compare(IllegalArgumentException.class.getName(), ex.getClass().getName());
            }
            
            compare.printMessage("Looking for a null");
            try{
                q.find(null);
                compare.fail("IllegalArgumentException expected", "No exception thrown");
            }catch(Exception ex){
                compare.compare(IllegalArgumentException.class.getName(), ex.getClass().getName());
            }
            
            compare.printMessage("Checking index 100000");
            try{
                q.check(100000);
                compare.fail("IllegalArgumentException expected", "No exception thrown");
            }catch(Exception ex){
                compare.compare(IllegalArgumentException.class.getName(), ex.getClass().getName());
            }
            
            compare.printMessage("Checking negative index");
            try{
                q.check(-1);
                compare.fail("IllegalArgumentException expected", "No exception thrown");
            }catch(Exception ex){
                compare.compare(IllegalArgumentException.class.getName(), ex.getClass().getName());
            }
        }
    	
    	public static void main3(String arg[]){
    	    
    	    Driver3x driver = new Driver3x();
    	    driver.initialize();
    	    driver.start();
    	    driver.printScore();
    	}
}
