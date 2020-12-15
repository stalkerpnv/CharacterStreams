package oopexample;

public abstract class Animal {
    protected String name;
    protected String color;
    protected int age;
    private int a;

    Animal(String name, String color,int age){
        this.name = name;
        this.color =color;
        this.age = age;
    }
    public void voice(){
        System.out.println("voice");
    }
}
