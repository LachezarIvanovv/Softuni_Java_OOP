package oop.WorkingWithAbstraction.exercise.TrafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> colors = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(String::valueOf)
                .collect(Collectors.toList());

        List<TrafficLight> trafficLights = new ArrayList<>();

        for (String color : colors) {
            Color currentColor = Color.valueOf(color);
            TrafficLight currentTrafficLight = new TrafficLight(currentColor);
            trafficLights.add(currentTrafficLight);
        }

        int n = Integer.parseInt(scanner.nextLine());

        while (n > 0){
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.changeColor();
                System.out.print(trafficLight.getCurrentColor() + " ");
            }
            System.out.println();
            n--;
        }
    }
}
