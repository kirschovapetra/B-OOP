/*
 * Created on Aug 7, 2005
 * Accenture Manila Delivery Center
 * Technology Managed Services
 * Makati Stock Exchange Bldg
 * Makati City, Philippines
 */
package d1.driver;

import java.text.DateFormat;

import d1.profile.PlayerProfile;
import d1.profile.Zodiac;


/**
 * Driver class for Activity 1.1
 * 
 * @author eugene.p.lozada
 */
public class Driver1_1 extends BaseDriver{

    private PlayerProfile data[];
    
    public void initialize() {
        
        data = new PlayerProfile[12];
        data[0] = new PlayerProfile("Shy Guy", PlayerProfile.MALE);
        data[0].setBirthDate(1977, 9, 13);
        data[1] = new PlayerProfile("Hear Me Roar", PlayerProfile.MALE);
        data[1].setBirthDate(1981, 8, 11);
        data[2] = new PlayerProfile("Strong Like Bull", PlayerProfile.MALE);
        data[2].setBirthDate(1980, 5, 19);
        data[3] = new PlayerProfile("Ramboy", PlayerProfile.MALE);
        data[3].setBirthDate(1923, 4, 1);
        data[4] = new PlayerProfile("Twins Basil", PlayerProfile.FEMALE);
        data[4].setBirthDate(1982, 5, 21);
        data[5] = new PlayerProfile("Crabby Patty Cake", PlayerProfile.FEMALE);
        data[5].setBirthDate(1642, 7,20);
        data[6] = new PlayerProfile("I'm not fat, I'm big boned", PlayerProfile.MALE);
        data[6].setBirthDate(1776, 9, 26);
        data[7] = new PlayerProfile("It's my nature",PlayerProfile.MALE);
        data[7].setBirthDate(1021, 11, 21);
        data[8] = new PlayerProfile("Legolas",PlayerProfile.FEMALE);
        data[8].setBirthDate(1, 12, 1);
        data[9] = new PlayerProfile("High on a hill",PlayerProfile.MALE);
        data[9].setBirthDate(100, 1, 1);
        data[10] = new PlayerProfile("Waterboy",PlayerProfile.MALE);
        data[10].setBirthDate(100, 2, 14);
        data[11] = new PlayerProfile("Here fishy fishy fishy",PlayerProfile.MALE);
        data[11].setBirthDate(100, 2, 24);

    }
    
    

    public void start() {
        
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        
        compare.printMessage("Birthdate=" + df.format(data[0].getBirthDate().getTime())); 
        compare.compare(Zodiac.VIRGO, Zodiac.getZodiacSign(data[0].getBirthDate()));
        compare.printMessage("Birthdate=" + df.format(data[1].getBirthDate().getTime())); 
        compare.compare(Zodiac.LEO, Zodiac.getZodiacSign(data[1].getBirthDate()));
        compare.printMessage("Birthdate=" + df.format(data[2].getBirthDate().getTime())); 
        compare.compare(Zodiac.TAURUS, Zodiac.getZodiacSign(data[2].getBirthDate()));
        compare.printMessage("Birthdate=" + df.format(data[3].getBirthDate().getTime())); 
        compare.compare(Zodiac.ARIES, Zodiac.getZodiacSign(data[3].getBirthDate()));
        compare.printMessage("Birthdate=" + df.format(data[4].getBirthDate().getTime())); 
        compare.compare(Zodiac.GEMINI, Zodiac.getZodiacSign(data[4].getBirthDate()));  
        compare.printMessage("Birthdate=" + df.format(data[5].getBirthDate().getTime())); 
        compare.compare(Zodiac.CANCER, Zodiac.getZodiacSign(data[5].getBirthDate()));
        compare.printMessage("Birthdate=" + df.format(data[6].getBirthDate().getTime())); 
        compare.compare(Zodiac.LIBRA, Zodiac.getZodiacSign(data[6].getBirthDate()));
        compare.printMessage("Birthdate=" + df.format(data[7].getBirthDate().getTime())); 
        compare.compare(Zodiac.SCORPIO, Zodiac.getZodiacSign(data[7].getBirthDate()));
        compare.printMessage("Birthdate=" + df.format(data[8].getBirthDate().getTime())); 
        compare.compare(Zodiac.SAGITTARIUS, Zodiac.getZodiacSign(data[8].getBirthDate()));
        compare.printMessage("Birthdate=" + df.format(data[9].getBirthDate().getTime())); 
        compare.compare(Zodiac.CAPRICORN, Zodiac.getZodiacSign(data[9].getBirthDate()));
        compare.printMessage("Birthdate=" + df.format(data[10].getBirthDate().getTime())); 
        compare.compare(Zodiac.AQUARIUS, Zodiac.getZodiacSign(data[10].getBirthDate()));
        compare.printMessage("Birthdate=" + df.format(data[11].getBirthDate().getTime())); 
        compare.compare(Zodiac.PISCES, Zodiac.getZodiacSign(data[11].getBirthDate()));
    }
    
    public static void main1_1(String arg[]){
        
        Driver1_1 driver = new Driver1_1();
        driver.initialize();
       	driver.start();
       	driver.printScore();	
    }

    
}
