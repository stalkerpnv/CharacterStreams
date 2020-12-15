/*
import java.io.*;
import java.util.Scanner;

class Student implements Serializable {
    String name;
    String lastname;
    double age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }
}

public class ExampleSer {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Scanner sc = new Scanner(System.in);
        FileOutputStream fos = null;
        ObjectOutputStream oos =null;
        File f;
        try {
            f = new File("Student");
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);
            System.out.println("Сколько студентов хотите записать");
            int count = sc.nextInt();
            sc.nextLine();
            Student student;
            //Запись объектов в цикле
            for (int i = 0; i < count; i++) {
                student = new Student();
                System.out.println("Input name");
                student.name = sc.nextLine();
                System.out.println("Input lastname");
                student.lastname = sc.nextLine();
                System.out.println("Input age");
                student.age = sc.nextInt();
                sc.nextLine();
                oos.writeObject(student);
            }

            //Чтение из файла
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream oin = new ObjectInputStream(fis);
            for (int i = 0; i < count; i++) {
                student = (Student) oin.readObject();
                if(student.age<20){

                }
                System.out.println(student);
            }
        }
        catch (IOException ie){
            ie.printStackTrace();
        }
        finally {
            oos.flush();
            oos.close();
            fos.flush();
            fos.close();
        }

    }
}
*/
