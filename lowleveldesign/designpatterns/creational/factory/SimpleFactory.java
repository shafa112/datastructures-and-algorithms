package designpatterns.creational.factory;

/**
 * A simple factory uses a single method to create instances of different classes
 * based on input parameters.
 * It is not a part of the Gang of Four design patterns but is a common variant.
 *
 * PS: Its simple and easy to write but, it does violate open/close principle
 */

/*

// Product interface
interface Animal {
    void makeSound();
}

// Concrete Product classes
class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
}

class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}

// Simple Factory class
class AnimalFactory {
    public static Animal createAnimal(String type) {
        if (type.equalsIgnoreCase("dog")) {
            return new Dog();
        } else if (type.equalsIgnoreCase("cat")) {
            return new Cat();
        }
        throw new IllegalArgumentException("Unknown animal type: " + type);
    }
}

//Usage
public class SimpleFactory {

    public static void main(String[] args) {
        Animal dog = AnimalFactory.createAnimal("dog");
        dog.makeSound(); // Outputs: Woof

        Animal cat = AnimalFactory.createAnimal("cat");
        cat.makeSound(); // Outputs: Meow
    }
}


 */

