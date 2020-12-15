public class People {
    String name; // ссылочных -null
    int age;     //0
    int height;
    People(){
        name = "default";
        age = 20;
        height = 170;
    }
    People(String newName, int newAge){
        name = newName;
        age = newAge;
        height = 170;
    }
    People(String newName, int newAge, int newHeight){
        name = newName;
        age = newAge;
        height = newHeight;
    }
    public void walk(){
        System.out.println( name + " walk");
    }
    public void voice(){
        System.out.println( name + " talk");
    }
}
