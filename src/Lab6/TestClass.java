package Lab6;

import java.util.Arrays;
import java.util.ArrayList;

public class TestClass {
    public static void main(String[] args) {
        People.printHello();
        People p = new People();
        p.getName();


        People[] peoples = new People[5]; // размер не меняется
        peoples[0] = p;
        ArrayList<People> arrayListPeople = new ArrayList<People>(); // динамический размер

        People student = new Student("Ivan","Ivanov", 20);
        arrayListPeople.add(student);

        for (People people:arrayListPeople){
            if(people instanceof Student){
                System.out.println(people);
            }
        }


        arrayListPeople.remove(p);
        arrayListPeople.clear();
        arrayListPeople.isEmpty();
        arrayListPeople.add(student);
        int [] arr = new int[5];
        Arrays.fill(arr,1);

    }
}
// static - не зависит от объекты класса, поведение всегда будет одинаковым
// no static  - вызов производится через объекты класса, имеете доступ к полям объекта
