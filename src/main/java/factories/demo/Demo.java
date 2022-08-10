package factories.demo;

import factories.impl.Point;
import factories.impl.PointFactory;

public class Demo {
    public static void main(String[] args) {
        Point point = PointFactory.newCartesianPoint(2, 3);
        System.out.println("newCartesianPoint " + point.getX());

        Point point2 = PointFactory.newPolarPoint(2, 3);
        System.out.println("newPolarPoint " + point2.getX());
    }
}
