package programming.oop.inheritance;

public class Cat extends Animal {

    int normal = 20;

    @Override
    public void speak() {
        System.out.println("Cat speak meow meow");
    }
}
