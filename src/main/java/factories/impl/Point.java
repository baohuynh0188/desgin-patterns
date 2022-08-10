package factories.impl;

//enum CoordinateSystem {
//    CARTESIAN,
//    POLAR
//}

public class Point {
    private double x;
    private double y;

//    private Point(double a, double b, CoordinateSystem coordinateSystem) {
//        switch (coordinateSystem) {
//            case CARTESIAN:
//                this.x = a;
//                this.y = b;
//                break;
//            case POLAR:
//                this.x = a * Math.cos(b);
//                this.y = a * Math.sin(b);
//                break;
//        }
//    }

     protected Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

//    public static Point newCartesianPoint(double x, double y) {
//        return new Point(x, y);
//    }
//
//    public static Point newPolarPoint(double rho, double theta) {
//        return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
//    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
