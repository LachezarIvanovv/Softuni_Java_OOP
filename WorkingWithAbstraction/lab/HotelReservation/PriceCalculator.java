package oop.WorkingWithAbstraction.lab.HotelReservation;

public class PriceCalculator {
    private double price;
    private int days;
    private Season season;
    private Discount discount;

    public PriceCalculator(double price, int days, Season season, Discount discount) {
        this.price = price;
        this.days = days;
        this.season = season;
        this.discount = discount;
    }

    public double totalPrice() {
        return price * days * season.getValue() * discount.getValue();
    }
}
