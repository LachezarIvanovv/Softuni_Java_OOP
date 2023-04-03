package Inheritance.lab.StackOfStrings;

public class Main {
    public static void main(String[] args) {

        StackOfStrings stack = new StackOfStrings();

        for (int i = 0; i < 10; i++) {
            stack.push("number: " + i);
        }

        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
