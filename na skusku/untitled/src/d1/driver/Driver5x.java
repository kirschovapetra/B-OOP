/*
 * Created on Aug 16, 2005
 * Accenture Manila Delivery Center
 * Technology Managed Services
 * Makati Stock Exchange Bldg
 * Makati City, Philippines
 */
package d1.driver;


import d1.cardgame.Card;
import d1.cardgame.CardException;
import d1.cardgame.CardPlayer;
import d1.profile.PlayerProfile;

public class Driver5x extends BaseDriver{

    private SimpleCard card[];
   
    private class SimpleCard implements Card {
        
        protected int cardAttribute;
        
        public Object getCardAttribute(int attribute) throws CardException {
           // local variable attribute is irrelevant
            return "Card" + cardAttribute;
        }
        
    }
    
    
    public void initialize() {
                
        card = new SimpleCard[6];
        for(int i =0; i < card.length; i++){
            card[i] = new SimpleCard();
            card[i].cardAttribute = i;
        }
        
        
    }
    
    public void start() {
        
        CardPlayer player = new CardPlayer("Stupendous Man", PlayerProfile.MALE, 5);
        player.setBirthDate(1977, 9, 13);

        compare.printMessage("Creating Stupendous man with an empty 5 card hand");
        compare.compare("Stupendous Man", player.getName());
        compare.printMessage("Checking card hand count");
        compare.compare(0, player.getCardCount());
        compare.printMessage("Checking maxmimum number of cards");
        compare.compare(5, player.getMaxCardCount());
        
        for(int i =0; i < 5; i++){
            try{
                compare.printMessage("Adding " + card[i].getCardAttribute(0));
                player.addCard(card[i]);
                compare.pass("Adding " + card[i].getCardAttribute(0));
            }
            catch(Exception ex){
                compare.fail("No exceptions expected", ex.getClass().getName());
            }
        }
        
        compare.printMessage("Checking card hand count");
        compare.compare(5, player.getCardCount());
        compare.printMessage("Adding a card to a full hand");
        compare.compare(false, player.addCard(card[5]));
  
        
        
        try{
        	compare.printMessage("Adding null object as card");
        	player.addCard(null);
            compare.fail("Exception expected", "No exception thrown");
        }
        catch(Exception ex){
            compare.pass("Exception thrown when adding a null card");
        }
        
        compare.printMessage("Checking if full");
        compare.compare(true, player.isFull());
        compare.printMessage("Checking 3rd card");
        compare.compare("Card"+card[2].cardAttribute, "Card"+((SimpleCard)player.getCard(2)).cardAttribute);
        compare.printMessage("Removing 3rd card");
        compare.compare("Card"+card[2].cardAttribute, "Card"+((SimpleCard)player.removeCard(2)).cardAttribute);
        
        
        compare.printMessage("Removing a card that is not in hand");
        compare.compare(false, player.removeCard(card[2]));
        
        
        compare.printMessage("Getting card count");
        compare.compare(4, player.getCardCount());
        compare.printMessage("Checking if full");
        compare.compare(false, player.isFull());
    }

    public static void main5(String arg[]){
        
        Driver5x driver = new Driver5x();
        driver.initialize();
        driver.start();
        driver.printScore();
    }


}
