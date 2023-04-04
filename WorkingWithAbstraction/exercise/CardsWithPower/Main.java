package oop.WorkingWithAbstraction.exercise.CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CardRank cardRank = CardRank.valueOf(scanner.nextLine());
        CardPower cardPower = CardPower.valueOf(scanner.nextLine());

        Card card = new Card(cardPower, cardRank);

        System.out.printf("Card name: %s of %s; Card power: %d", card.getCardRank(), card.getCardPower(), card.getPower());
    }
}
