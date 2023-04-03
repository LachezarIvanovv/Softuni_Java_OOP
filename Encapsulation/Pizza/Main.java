package Encapsulation.Pizza;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaData = scanner.nextLine().split(" ");
        String pizzaType = pizzaData[1];
        int numberOfToppings = Integer.parseInt(pizzaData[2]);

        String[] doughData = scanner.nextLine().split(" ");
        String flourType = doughData[1];
        String backingTechnique = doughData[2];
        double doughWeight = Double.parseDouble(doughData[3]);

        try {
            Pizza pizza = new Pizza(pizzaType, numberOfToppings);
            Dough dough = new Dough(flourType, backingTechnique, doughWeight);
            pizza.setDough(dough);

            String toppingData = scanner.nextLine();

            while (!"END".equals(toppingData)){
                String[] toppingInfo = toppingData.split(" ");
                String toppingType = toppingInfo[1];
                double toppingWeight = Double.parseDouble(toppingInfo[2]);
                Topping topping = new Topping(toppingType, toppingWeight);

                pizza.addTopping(topping);

                toppingData = scanner.nextLine();
            }
            System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
