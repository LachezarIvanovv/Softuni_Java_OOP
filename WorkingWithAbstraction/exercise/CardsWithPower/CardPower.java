package oop.WorkingWithAbstraction.exercise.CardsWithPower;

public enum CardPower {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int cardPowerRank;

    CardPower(int cardPowerRank){
        this.cardPowerRank = cardPowerRank;
    }

    public int getCardPowerRank(){
        return cardPowerRank;
    }
}
