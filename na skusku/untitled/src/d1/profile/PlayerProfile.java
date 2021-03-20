/*
 * Created on Jul 26, 2005
 * Accenture Manila Delivery Center
 * Technology Managed Services
 * Makati Stock Exchange Bldg
 * Makati City, Philippines
 */
package d1.profile;

import java.util.Calendar;

/**
 * PlayerProfile encapsulates basic user information 
 * 
 * @author eugene.p.lozada
 */
public class PlayerProfile {

    //Player's name
    private String name;
    //Player's birthdate
    private Calendar birthDate;
    //Player's age
    private int age;
    //Player's gender
    private char gender;
    //Player's appliation generated profile ID. This is used by the application instance, and is not desiged
    //to serve as a primary key for database storage
    private int profileID;
   
    //Used to generate an ID
    private static int profileCtr;
    
    
    public static final char MALE='M';
    public static final char FEMALE ='F';
    
        
    /**
     * Creates a new PlayerProfile with attributes specified
     * 
     * @param name the name of the player
     * @param gender specifies the gender of the player.   This is either MALE or FEMALE 
     * @param birthDate birthdate of the Player
     */
    public PlayerProfile(String name,char gender, Calendar birthDate){
        setName(name);
        setBirthDate(birthDate);
        setGender(gender);
        profileID = profileCtr;
        profileCtr++;
    }
    
    
    /**
     * Create a new PlayerProfile with the attributes specified and using the current date as the birthdate
     * 
     * @param name the name of the player
     * @param gender the gender of the player.  This is either MALE or FEMALE
     */
    public PlayerProfile(String name, char gender){
        this(name, gender, Calendar.getInstance());
    }
    
    
    /**
     * Sets the name of the player
     * 
     * @param name sets the name to this variable
     */
    public void setName(String name){
       
        if(name == null){
            throw new IllegalArgumentException("profile.method.argument.invalid");
        }
        this.name = name;
    }
    
    
    /**
     * Sets the birthdate of the player
     * 
     * @param birthDate sets the birthdate to this variable. This cannot later than the current date
     */
    public void setBirthDate(Calendar birthDate){
        
        
        Calendar now =Calendar.getInstance();
        
        if(birthDate == null || birthDate.after(now)){
            throw new IllegalArgumentException("profile.method.argument.invalid");
        }
        
        this.birthDate = birthDate;
        
        age = computeAge(now);
        
    }
    
    
    /**
     * Sets the birthdate of the player.  The resulting date cannot be later than the current date
     * 
     * @param year year of birth
     * @param month month of birth
     * @param date date of birth
     */
    public void setBirthDate(int year, int month, int date){
        
        birthDate.set(year, month-1, date);
        age = computeAge(Calendar.getInstance());
    }
    
    
    
    /**
     * Sets the gender of the player
     * 
     * @param gender Either MALE of FEMALE
     */
    public void setGender(char gender){
        	
        if(gender != MALE && gender != FEMALE)
            	throw new IllegalArgumentException("method.argument.invalid");
        else
            this.gender = gender;
    }
      
    
    /** 
     * Returns the player's age in years
     * 
     * @return the player's age in years
     */
    public int getAge(){
        return age;
    }
    
    /**
     * Returns the player's gender
     * 
     * @return either MALE or FEMALE
     */
    public char getGender(){
        return gender;
    }
    
    /**
     * Returns the player's birthdate as a Calendar
     * 
     * @return the player's birthdate
     */
    public Calendar getBirthDate(){
        return birthDate;
    }
    
    
    /**
     * Return's the player's name
     * 
     * @return the player's name
     */
    public String getName(){
        
        return name;
    }
    
    /**
     * Returns the player's application ID.  This ID should not be used as the primary key for a databse or for any
     * persistent storage
     * 
     * @return the player's ID
     */
    public int getID(){
        
        return profileID;
    }
    
    
    /**
     * Private helper method that computes the difference in years between the player's birthdate and the date specified
     * 

     * @return the difference in years
     */
    private int computeAge(Calendar now){
        
        //The following variables give you the current year/month/date and the actual birth year/month/date
        //for the age that you must compute
        
        //HINT: Note that Calendar considers JANUARY as 0 and DECEMBER as 11
        int currentMonth = now.get(Calendar.MONTH);						//current month
        int birthDateMonth = birthDate.get(Calendar.MONTH); 			//month of birth
        int currentYear = now.get(Calendar.YEAR); 						//current year
        int birthDateYear= birthDate.get(Calendar.YEAR);				//year of birth
        int currentDayOfMonth = now.get(Calendar.DAY_OF_MONTH);			//current day of month
        int birthDayOfMonth =  birthDate.get(Calendar.DAY_OF_MONTH);	//date of birth
        
        
        int tempAge=-1;
        
        //TODO Activity 1.0
        //Compute the age in years, based on the values of the variables given above and assign
        //it to the variable 'tempAge'. You may declare additional local variables if necessary, but
        //you are not allowed to use pre-built APIs to accomplish the activity.
        

        //start solution 1.0
        tempAge = currentYear-birthDateYear;
        if (currentMonth<birthDateMonth ||
                (currentMonth==birthDateMonth && currentDayOfMonth<birthDayOfMonth)){
            tempAge--;
        }

         
        // end solution 1.0
        return tempAge;
    }
    
    public String toString(){
        return this.getName() + "/" + this.getID();
    }
}