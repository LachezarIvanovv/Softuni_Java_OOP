package oop.WorkingWithAbstraction.exercise.CardsWithPower;

public class Card {
    private CardPower cardPower;
    private CardRank cardRank;

    public Card(CardPower cardPower, CardRank cardRank){
        this.cardPower = cardPower;
        this.cardRank = cardRank;
    }

    public CardRank getCardRank(){
        return cardRank;
    }

    public CardPower getCardPower(){
        return cardPower;
    }

    public int getPower(){
        return cardPower.getCardPowerRank() + cardRank.getCardRankPower();
    }
}
