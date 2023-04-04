package Polymorphism.lab.Shapes;

public class Circle extends Shape{

    private Double radius;

    public Circle(Double radius){
        this.radius = radius;
        super.setArea(this.calculateArea());
        super.setPerimeter(this.calculatePerimeter());
    }

    @Override
    protected double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    protected double calculateArea() {
        return Math.PI * radius * radius;
    }

    public final Double getRadius(){
        return radius;
    }
}
