package programming.oop.polymorphism;

public class Overloading {
    public static void main(String[] args) {
        System.out.println(calcFeetAndInchesToCentimeters(8, 4));
        System.out.println(calcFeetAndInchesToCentimeters(157));

    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        if (validateGreaterThenEqual(feet) && validateInches(inches)) {
            return feet * 30.48 + inches * 2.54;
        }
        return -1;
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {
        if (validateGreaterThenEqual(inches)) {
            double feet = (int) inches / 12;
            double remainingInches = (int) inches % 12;
            return calcFeetAndInchesToCentimeters(feet, remainingInches);
        }
        return -1;
    }

    public static boolean validateGreaterThenEqual(double feet) {
        return feet >= 0;
    }

    public static boolean validateInches(double inches) {
        return inches >= 0 && inches <= 12;
    }
}

