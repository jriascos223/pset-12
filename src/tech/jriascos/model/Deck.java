package tech.jriascos.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck extends ArrayList<Card> {

    public int getValue() {
        int totalValue = 0;
        int aces = 0;
        for (Card c : this) {
            switch (c.getValue()){
                    case TWO: totalValue += 2; break;
                    case THREE: totalValue += 3; break;
                    case FOUR: totalValue += 4; break;
                    case FIVE: totalValue += 5; break;
                    case SIX: totalValue += 6; break;
                    case SEVEN: totalValue += 7; break;
                    case EIGHT: totalValue += 8; break;
                    case NINE: totalValue += 9; break;
                    case TEN: totalValue += 10; break;
                    case JACK: totalValue += 10; break;
                    case QUEEN: totalValue += 10; break;
                    case KING: totalValue += 10; break;
                    case ACE: aces += 1; break;
            }
            
        }

        for(int i = 0; i < aces; i++) {
            if (totalValue > 10) {
                totalValue += 1;
            }else {
                totalValue += 11;
            }
        }
        return totalValue;
    }

    public void createFullDeck() {
        for(Suit cardSuit : Suit.values()){
			for(Value cardValue : Value.values()){
				this.add(new Card(cardSuit,cardValue));
			}
		}
    }

    public void addCard(Card addCard) {
        this.add(addCard);
    }

    public void draw(Deck sourceDeck){
		this.add(sourceDeck.get(0));
		sourceDeck.remove(0);
	}

    public void shuffle(){
        ArrayList<Card> tmpDeck = new ArrayList<Card>();
        Random random = new Random();
        int randomCardIndex = 0;
        int originalSize = this.size();
        for(int i = 0; i < originalSize; i++) {
            randomCardIndex = random.nextInt((this.size()-1 - 0) + 1) + 0;
            tmpDeck.add(this.get(randomCardIndex));
        }
        Collections.copy(this, tmpDeck);
    }

    public String toString(){
		String cardListOutput = "";
		for(Card c : this){
			cardListOutput += "\n" + c.toString();
		}
		return cardListOutput;
    }
    
    public void emptyDeck(Deck destinationDeck) {
        int size = this.size();
        for (int i = 0; i < size; i++) {
            destinationDeck.addCard(this.get(i));
        }
        for (int i = 0; i < size; i++) {
            this.remove(0);
        }
    }
    
}