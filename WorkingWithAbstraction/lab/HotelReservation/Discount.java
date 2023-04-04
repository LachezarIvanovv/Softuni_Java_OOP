package oop.WorkingWithAbstraction.lab.HotelReservation;

public enum Discount {
    VIP(0.80),
    SECOND_VISIT(0.90),
    NONE(1);

    private double value;

    Discount(double value){
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }

    public static Discount parse(String token) {
        switch (token){
            case "VIP":
                return VIP;
            case "SecondVisit":
                return SECOND_VISIT;
            case "None":
                return NONE;
            default:
                throw new IllegalArgumentException("Unknown enum value " + token);
        }
    }

//•	20% for VIP clients - VIP
//•	10% for clients, visiting for a second time - SecondVisit
//•	0% if there is no discount - None
}
