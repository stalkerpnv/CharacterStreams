import java.util.ArrayList;

public class TestClassPeople {
    public boolean check(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) return true;
        return false;
    }

    public static void main(String[] args) {
        People people;
        people = new People();
        System.out.println(people.name);
        System.out.println(people.age);
        People peopleTwo = new People("Ivan", 25, 180);
        System.out.println(peopleTwo.name);
        System.out.println(peopleTwo.age);
        System.out.println(peopleTwo.height);
        People peopleThree = new People("Vitalii", 30);
        peopleThree.walk();
        Student student = new Student();
        Student studentTwo = new Student("Mark", 19, 175, 100232);
        System.out.println(student.name);
        studentTwo.voice();
        studentTwo.learn();
        int[] arr = new int[5];
        ArrayList<People> arrayList = new ArrayList<People>();
        arrayList.add(people);
        arrayList.add(peopleTwo);
        arrayList.add(student);

    }
}
