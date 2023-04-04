package oop.WorkingWithAbstraction.lab.HotelReservation;

import java.util.Locale;

public enum Season {
    AUTUMN(1),
    SPRING(2),
    WINTER(3),
    SUMMER(4);

    private int value;

    Season(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static Season parse(String token) {
        return Season.valueOf(token.toUpperCase());
    }


    //•	1 during Autumn
//•	2 during Spring
//•	3 during Winter
//•	4 during Summer
}
