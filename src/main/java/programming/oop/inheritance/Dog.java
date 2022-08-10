package programming.oop.inheritance;

public class Dog extends Animal {

    int normal = 30;

    @Override
    public void speak() {
        System.out.println("Dog bark gau gau gau");
    }

    public void like() {
        System.out.println("Dog like sausage");
    }
}
