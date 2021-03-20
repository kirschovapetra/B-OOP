/*
 * Created on Aug 4, 2005
 * Accenture Manila Delivery Center
 * Technology Managed Services
 * Makati Stock Exchange Bldg
 * Makati City, Philippines
 */
package d1.driver;

import java.text.DateFormat;
import java.util.Calendar;


import d1.profile.PlayerProfile;


/**
 * Driver class for Activity 1.0
 * 
 * @author eugene.p.lozada
 *
 */
public class Driver1_0 extends BaseDriver{
    
    private PlayerProfile data[];
    
    public void initialize(){
        
        data = new PlayerProfile[4];
        data[0] = new PlayerProfile("Eugene", PlayerProfile.MALE);
        data[0].setBirthDate(1977, 9, 13);
        data[1] = new PlayerProfile("Nadja", PlayerProfile.FEMALE);
        data[1].setBirthDate(1981, 8, 11);
        data[2] = new PlayerProfile("Toby", PlayerProfile.MALE);
        data[2].setBirthDate(1980, 5, 19);
        data[3] = new PlayerProfile("The NOW", PlayerProfile.MALE);
        data[3].setBirthDate(Calendar.getInstance());
    }
    
    public void start(){
        
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        Calendar now = Calendar.getInstance();
        System.out.println("Date now is " + df.format(now.getTime())+ "\n");
        
        for(int i = 0; i < data.length; i++){
            compare.printMessage(data[i].getName() + "'s birthdate=" + df.format(data[i].getBirthDate().getTime()));     
            compare.compare(computeAge(now, data[i].getBirthDate()), data[i].getAge());
        }
    }
    
    public static void main1_0(String arg[]){
        
        
        Driver1_0 driver = new Driver1_0();
        driver.initialize();
       	driver.start();
       	driver.printScore();	
    }
    
    /**
     * @param now
     * @return
     */
    private int computeAge(Calendar now, Calendar birthDate){
        
        int currentMonth = now.get(Calendar.MONTH);						//current month
        int birthDateMonth = birthDate.get(Calendar.MONTH); 			//month of birth
        int currentYear = now.get(Calendar.YEAR); 						//current year
        int birthDateYear= birthDate.get(Calendar.YEAR);				//year of birth
        int currentDayOfMonth = now.get(Calendar.DAY_OF_MONTH);			//current day of month
        int birthDayOfMonth =  birthDate.get(Calendar.DAY_OF_MONTH);	//date of birth
        
        
        int tempAge;
        
      
        
        tempAge = currentYear - birthDateYear;
        if(currentMonth< birthDateMonth){
            tempAge--;
        }
        else if (currentMonth ==  birthDateMonth){
            if(currentDayOfMonth < birthDayOfMonth){
                tempAge --;
            }
        }
        
 
        return tempAge;
    }

}
