package InterfacesAndAbstraction.lab.CarShop;

public interface Car {

     int TIRES = 4;

//+getModel(): String
//+getColor(): String
//+getHorsePower(): Integer
//+countryProduced(): String

    String getModel();
    String getColor();
    Integer getHorsePower();
    String countryProduced();
}
