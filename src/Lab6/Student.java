package Lab6;

public class Student extends People{
    Student(String nameAdd, String lastnameAdd, int ageAdd){
        super(nameAdd, lastnameAdd,ageAdd);
    }
    public void learn(){
        System.out.println("I learn");
    }
}
