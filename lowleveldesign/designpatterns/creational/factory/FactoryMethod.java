package designpatterns.creational.factory;

/**
 * it delegates the responsibility of instantiating a class to a subclass.
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

// Creator abstract class
abstract class AnimalFactory {
    public abstract Animal createAnimal();

    public void makeAnimalSound() {
        Animal animal = createAnimal();
        animal.makeSound();
    }
}

// Concrete Creator classes
class DogFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}

class CatFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}

// Usage
public class FactoryMethod {
    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        dogFactory.makeAnimalSound(); // Outputs: Woof

        AnimalFactory catFactory = new CatFactory();
        catFactory.makeAnimalSound(); // Outputs: Meow
    }
}

*/
