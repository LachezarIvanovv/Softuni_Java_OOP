package Polymorphism.lab.Shapes;

public class Rectangle extends Shape {

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width){
        this.height = height;
        this.width = width;
        super.setArea(this.calculateArea());
        super.setPerimeter(this.calculatePerimeter());
    }



    @Override
    protected double calculatePerimeter() {
        return 2 * (height + width);
    }

    @Override
    protected double calculateArea() {
        return height * width;
    }

    public final Double getHeight(){
        return height;
    }

    public final Double getWidth(){
        return width;
    }
}
