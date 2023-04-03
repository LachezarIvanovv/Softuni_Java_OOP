package oop.Inheritance.exercise.animal;

public class Kitten extends Animal{
    public Kitten(String name, int age) {
        super(name, age, "Female");
    }

    public String produceSound(){
        return "Meow";
    }
}
