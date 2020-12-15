public class Student extends People{
    int nZk;
    Student(){
        super();
    }
    Student(String newName, int newAge, int newHeight, int nZk){
        super(newName,newAge,newHeight);
        this.nZk = nZk;
    }
    public void learn(){
        System.out.println(name + " learn");
    }
}
