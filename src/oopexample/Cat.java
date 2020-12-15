package oopexample;

public class Cat extends Animal {
    Cat(String name, String color, int age) {
        super(name, color, age);
    }

    public void swim(){
        System.out.println("swim");
    }
}
