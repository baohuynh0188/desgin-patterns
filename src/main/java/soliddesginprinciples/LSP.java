package soliddesginprinciples;

class Rectangle {
    protected int width;
    protected int height;

    public Rectangle() {
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "solid_desgin_principles.Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    public int getArea() {
        return this.width * this.height;
    }

    public boolean isSquare() {
        return this.height == this.width;
    }
}

class Square extends Rectangle {
    public Square() {
        super();
    }

    public Square(int size) {
        super.width = size;
        super.height = size;
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setWidth(height);
        super.setHeight(height);
    }
}

class RectangleFactory {
    public static Rectangle newRectangle(int width, int height) {
        return new Rectangle(width, height);
    }

    public static Rectangle newSquare(int side) {
        return new Rectangle(side, side);
    }
}

public class LSP {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(2, 3);
        useIt(rectangle);

        Rectangle square = new Square();
        square.setWidth(5);
        useIt(square);
    }

    static void useIt(Rectangle rectangle) {
        int width = rectangle.getWidth();
        rectangle.setHeight(10);
        // area = width * 10
        System.out.println("Expected area of " + (width * 10) + ", got " + rectangle.getArea());
    }
}
