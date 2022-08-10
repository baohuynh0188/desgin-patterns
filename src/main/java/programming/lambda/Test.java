package programming.lambda;

public class Test {
    public static void main(String[] args) {

        // Lambda 1
        Customer customer = (name) -> "Full name: " + name;
        System.out.println(customer.printName("Bao"));

        // Lambda 2
        Student student = (name, age) -> "Name: " + name + " - " + "Age: " + age;

        System.out.println(student.showInformation("Bao", 23));

        // Lambda 3
        Student student1 = (name, age) -> show(name, age);
        System.out.println(student.showInformation("Sang", 22));

        int a = 'A';
        System.out.println(a);

    }

    private static String show(String name, int age) {
        return "Name: " + name + " - " + "Age: " + age;
    }
}
