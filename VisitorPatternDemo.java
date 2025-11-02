// Visitor interface
interface AnimalVisitor {
    void visit(Dog dog);
    void visit(Cat cat);
}

// the Animal interface
interface Animal {
    void accept(AnimalVisitor visitor);
}

// concrete Animal classes
class Dog implements Animal {
    private String name;
    
    public Dog(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public void accept(AnimalVisitor visitor) {
        visitor.visit(this);
    }
}

class Cat implements Animal {
    private String name;
    
    public Cat(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public void accept(AnimalVisitor visitor) {
        visitor.visit(this);
    }
}

// Create concrete Visitor classes (different operations)
class SoundVisitor implements AnimalVisitor {
    @Override
    public void visit(Dog dog) {
        System.out.println(dog.getName() + " says: Woof!");
    }
    
    @Override
    public void visit(Cat cat) {
        System.out.println(cat.getName() + " says: Meow!");
    }
}

class FeedingVisitor implements AnimalVisitor {
    @Override
    public void visit(Dog dog) {
        System.out.println("Feeding " + dog.getName() + " with dog food");
    }
    
    @Override
    public void visit(Cat cat) {
        System.out.println("Feeding " + cat.getName() + " with cat food");
    }
}

// Demo
public class VisitorPatternDemo {
    public static void main(String[] args) {
        Animal dog = new Dog("Buddy");
        Animal cat = new Cat("Whiskers");
        
        System.out.println("=== Making Sounds ===");
        AnimalVisitor soundVisitor = new SoundVisitor();
        dog.accept(soundVisitor);
        cat.accept(soundVisitor);
        
        System.out.println("\n=== Feeding Animals ===");
        AnimalVisitor feedingVisitor = new FeedingVisitor();
        dog.accept(feedingVisitor);
        cat.accept(feedingVisitor);
    }
}