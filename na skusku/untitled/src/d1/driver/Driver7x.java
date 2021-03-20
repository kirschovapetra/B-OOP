/*
 * Created on Aug 16, 2005
 * Accenture Manila Delivery Center
 * Technology Managed Services
 * Makati Stock Exchange Bldg
 * Makati City, Philippines
 */
package d1.driver;


import d1.cardgame.Card;
import d1.cardgame.SimpleDeck;

public class Driver7x extends BaseDriver{

    private SimpleDeck deck;
    private Card[] cards;
       
    public void initialize() {
    	
        deck = new SimpleDeck();
        cards = deck.cards;
    }


    public void start() {
        System.out.print("Removing " + cards[2]);
        compare.compare(cards[2], deck.getCard(cards[2]));
        System.out.print("Checking current count count ");
        compare.compare( 4, deck.getCurrentCount());
        System.out.print("Putting " + cards[2]);
        compare.compare(true, deck.put(cards[2]));
        System.out.print("Getting nonexistent cards ");
        compare.compare( null,  deck.getCard(cards[5]));
        
        System.out.println("Dealing all cards randomly ");
        System.out.print("Checking current count count ");
        compare.compare(5, deck.getCurrentCount());
        int count=0;
        Card temp[] = new Card[deck.getCurrentCount()];
        
        for(int i = 0; i <temp.length; i++){
            temp[i] = deck.getCard();
            System.out.println(temp[i]);
            if(temp[i]  != cards[i]){
                count++;
            }
        }
        
        if(count >= 2){
            compare.pass("Cards were dealt randomly ");
        }else{
            compare.fail("Dealing cards randomly ", "Cards must be dealt randomly");
        }
        
        System.out.println("Adding a null cards ");
        try{
            deck.put(null);
            compare.fail("IllegalArgumentException expected ", "No exception thrown");
        }catch(Exception ex){
            System.out.print("Tried to insert in an invalid index ");
            compare.compare(IllegalArgumentException.class.getName(), ex.getClass().getName());
        }

        System.out.print("Checking cards count ");
        compare.compare(0, deck.getCurrentCount());
        System.out.print("Getting from an empty deck ");
        compare.compare(null, deck.getCard());
        
        
        

    }
    
    public static void main(String[] args) {

        Driver7x driver = new Driver7x();
        driver.initialize();
        driver.start();
        driver.printScore();
       
    }


}
