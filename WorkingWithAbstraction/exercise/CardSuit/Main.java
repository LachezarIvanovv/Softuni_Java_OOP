package oop.WorkingWithAbstraction.exercise.CardSuit;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Card Suits:");

        Arrays.stream(CardType.values())
                .forEach(cardType -> System.out.printf("Ordinal value: %d; Name value: %s%n", cardType.ordinal(), cardType.name()));
    }
}
