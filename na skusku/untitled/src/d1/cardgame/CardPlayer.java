package d1.cardgame;

import d1.datastore.ArrayStore;
import d1.profile.PlayerProfile;

import java.util.Calendar;

public class CardPlayer extends PlayerProfile {
    private int maxCardCount;
    private ArrayStore cards;

    public CardPlayer(String name, char gender, Calendar birthDate, int maxCardCount) {
        super(name, gender, birthDate);
        this.maxCardCount = maxCardCount;
        cards = new ArrayStore();
    }

    public CardPlayer(String name, char gender, int maxCardCount) {
        super(name, gender);
        this.maxCardCount = maxCardCount;
        cards = new ArrayStore();
    }
    public boolean addCard(Card card){
       return cards.add(card);
    }
    public boolean removeCard(Card card){
        return cards.remove(card);
    }
    public Card removeCard(int index){
        Card card = getCard(index);
        removeCard(card);
        return card;
    }

    public boolean isFull(){
        return cards.isFull();
    }
    public Card getCard(int index){
        return (Card) cards.check(index);
    }
    public int getCardIndex(Card card){
       return cards.find(card);
    }
    public int getCardCount(){return cards.getCount();}
    public int getMaxCardCount(){return maxCardCount;}

}
