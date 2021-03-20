package d1.cardgame;

import d1.datastore.ArrayStore;

import java.util.Random;

public abstract class CardDeck {
    private ArrayStore deck;
    public CardDeck(){
        initializeDeck();
    }
    protected abstract void initializeDeck();

    public Card getCard(){
        int index = new Random().nextInt(getCurrentCount()-1);
        return (Card) deck.remove(index);
    }
    public boolean getCard(Card card){
        return deck.remove(card);
    }
    public boolean put(Card card){
        return deck.add(card);
    }
    public int getCurrentCount(){return deck.getCount();}
}

