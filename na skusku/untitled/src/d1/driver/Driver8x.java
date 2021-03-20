/*
 * Created on Aug 17, 2005
 * Accenture Manila Delivery Center
 * Technology Managed Services
 * Makati Stock Exchange Bldg
 * Makati City, Philippines
 */
package d1.driver;

public class Driver8x extends BaseDriver{

    //PlayingCard card[];
    
    public void initialize(){
        ///card = new PlayingCard[4];
    }
    
    public void start(){
        /*
        card[0] = PlayingCard.getCard(PlayingCard.ACE, PlayingCard.SPADES);
        compare.printMessage("Ace of Spades created");
        compare.compare("Ace of Spades", card[0].toString());
        card[1] = PlayingCard.getCard(PlayingCard.TWO, PlayingCard.HEARTS);
        compare.printMessage("Two of Hearts created");
        compare.compare("Two of Hearts", card[1].toString());
        card[2] = PlayingCard.getCard(PlayingCard.FOUR, PlayingCard.DIAMONDS);
        compare.printMessage("Four of Diamonds created");
        compare.compare("Four of Diamonds", card[2].toString());
        card[3] = PlayingCard.getCard(PlayingCard.JACK, PlayingCard.CLUBS);
        compare.printMessage("Jack of Clubs created");
        compare.compare("Jack of Clubs", card[3].toString());
        
        compare.printMessage("Retrieving" + card[0] + " again, checking if same object");
        compare.compare(true, card[0] == PlayingCard.getCard(PlayingCard.ACE, PlayingCard.SPADES)); 
        
        compare.printMessage("Retrieving" + card[1] + " again, checking if same object");
        compare.compare(true, card[1] == PlayingCard.getCard(PlayingCard.TWO, PlayingCard.HEARTS)); 
    
        
        compare.printMessage("Retrieving" + card[2] + " again, checking if same object");
        compare.compare(true, card[2] == PlayingCard.getCard(PlayingCard.FOUR, PlayingCard.DIAMONDS)); 
    
        
        compare.printMessage("Retrieving" + card[3] + " again, checking if same object");
        compare.compare(true, card[3] == PlayingCard.getCard(PlayingCard.JACK, PlayingCard.CLUBS)); 
    
        compare.printMessage("Checking the equals() method using two similar cards");
        compare.compare(true, card[0].equals(PlayingCard.getCard(PlayingCard.ACE, PlayingCard.SPADES)));
        compare.printMessage("Checking the equals() method using two different cards");
        compare.compare(false, card[3].equals(card[2]));
    
        compare.printMessage("Creating card with an invalid rank");
        try{
            PlayingCard.getCard(PlayingCard.CLUBS, PlayingCard.CLUBS) ;
            compare.fail("IllegalArgumentException expected", "No exception thrown");
        }catch(Exception ex){
            compare.compare(IllegalArgumentException.class.getName(), ex.getClass().getName());
        }
        
        compare.printMessage("Creating card with an invalid suit");
        try{
            PlayingCard.getCard(PlayingCard.ACE, PlayingCard.ACE);
            compare.fail("IllegalArgumentException expected", "No exception thrown");
        }catch(Exception ex){
            compare.compare(IllegalArgumentException.class.getName(), ex.getClass().getName());
        }
    */
    }
    
    
    public static void main8(String[] args) {

        Driver8x driver = new Driver8x();
        driver.initialize();
        driver.start();
        driver.printScore();

    }

}
