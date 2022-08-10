package programming.oop.inheritance;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        animal1.setName("Poppy");
        animal1.setAge(2);
        animal1.speak();
        System.out.println(((Dog) animal1).normal);

        Animal animal2 = new Cat();
        animal2.setName("Sau");
        animal2.setAge(4);
//        animal2.speak();

        List<Animal> animalList = new ArrayList<>();
        animalList.add(animal1);
        animalList.add(animal2);
        for (Animal animal: animalList) {
            if (animal instanceof Cat) {
                animal.speak();
            }
        }
    }
}
