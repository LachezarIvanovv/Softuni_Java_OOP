package Polymorphism.lab.Shapes;

public abstract class Shape {

    private Double perimeter;
    private Double area;

    protected abstract double calculatePerimeter();

    protected abstract double calculateArea();

    protected void setPerimeter(Double perimeter){
        this.perimeter = perimeter;
    }

    protected void setArea(Double area){
        this.area = area;
    }

    public Double getPerimeter() {
        return perimeter;
    }

    public Double getArea(){
        return area;
    }
}
