/*
 * Created on Aug 16, 2005
 * Accenture Manila Delivery Center
 * Technology Managed Services
 * Makati Stock Exchange Bldg
 * Makati City, Philippines
 */
package d1.driver;

import d1.profile.PlayerList;
import d1.profile.PlayerProfile;

public class Driver6x extends BaseDriver {

    private PlayerProfile data[];
   
    public void initialize() {
        
        data = new PlayerProfile[6];
        
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
        
       compare.printMessage("Creating a player list of 4 players");
       PlayerList list = new PlayerList(4);
       compare.compare(4, list.getMaxPlayerCount());
       compare.printMessage("Checking current player count");
       compare.compare(0, list.getPlayerCount());

       compare.printMessage("Adding " + data[0].getName());
       compare.compare(true, list.addPlayer(data[0]));
       compare.printMessage("Adding " + data[1].getName());
       compare.compare(true, list.addPlayer(data[1]));
       compare.printMessage("Adding " + data[2].getName());
       compare.compare(true, list.addPlayer(data[2]));
       compare.printMessage("Adding " + data[3].getName());
       compare.compare(true, list.addPlayer(data[3]));
       compare.printMessage("Adding " + data[4].getName());
       compare.compare(false, list.addPlayer(data[4]));
       
       compare.printMessage("Adding a null");
       try{
           list.addPlayer(null);
           compare.fail("java.lang.IllegalArgumentException", "No exception thrown");
       }catch(Exception ex){
           compare.compare(IllegalArgumentException.class.getName(), ex.getClass().getName());
       }
       
       compare.printMessage("Finding using ID:" +data[2].getID());
       compare.compare(data[2].toString(), list.findPlayer(data[2].getID()).toString());
       compare.printMessage("Adding existing record: " + data[2].getName());
       compare.compare(false, list.addPlayer(data[2]));
       compare.printMessage("Finding using ID:" + 9999);
       compare.compare(null, list.findPlayer(9999));
       compare.printMessage("Finding using profile:" + data[4].getName());
       compare.compare(null, list.findPlayer(data[4]));
       compare.printMessage("Finding using profile:" + data[3].getName());
       compare.compare(data[3].getName(), list.findPlayer(data[3]).getName());
       compare.printMessage("Finding using name: " + data[0].getName());
       compare.compare(data[0], list.findPlayer(data[0].getName())[0]);
       compare.printMessage("Finding using name: " + data[4].getName());
       compare.compare(0, list.findPlayer(data[4].getName()).length);
             
       compare.printMessage("Removing by ID" + data[1].getID());
       compare.compare(data[1], list.removePlayer(data[1].getID()));
       compare.printMessage("Removing by ID" + 9999);
       compare.compare(null, list.removePlayer(9999));
     
       PlayerProfile temp[] = list.getAll();
       compare.printMessage("Checking array length");
       compare.compare(3, temp.length);
       compare.printMessage("Checking index 0");
       compare.compare(data[0].getName(), temp[0].getName());
       compare.printMessage("Checking index 1");
       compare.compare(data[2].getName(), temp[1].getName());
       compare.printMessage("Checking index 2");
       compare.compare(data[3].getName(), temp[2].getName());
    }

    
    public static void main6(String[] args) {

        Driver6x driver = new Driver6x();
        driver.initialize();
        driver.start();
        driver.printScore();
        

    }

}
