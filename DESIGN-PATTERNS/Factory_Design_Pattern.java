interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle...");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing Rectangle...");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Drawing Square...");
    }
}

class ShapeFactory {
    public static Shape getShape(String type) {
        if (type.equalsIgnoreCase("Circle")) {
            return new Circle();
        }
        if (type.equalsIgnoreCase("Rectangle")) {
            return new Rectangle();
        }
        if (type.equalsIgnoreCase("Square")) {
            return new Square();
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Shape s = ShapeFactory.getShape("Circle");
        s.draw();
    }
}