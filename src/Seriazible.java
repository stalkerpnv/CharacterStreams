import java.io.*;
import java.util.Scanner;

class Worker implements Serializable {
    String name;
    String lastname;
    int age;

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Seriazible {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fin = null;
        ObjectInputStream oin = null;


        FileOutputStream fos2 = null;
        ObjectOutputStream oos2 = null;
        FileInputStream fin2 = null;
        ObjectInputStream oin2 = null;
        try {
            File f = new File("workers.txt");
            if (f.exists()) f.delete();
            f.createNewFile();
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);
            System.out.println("Сколько работников хотите записать в файл");
            Scanner sc = new Scanner(System.in);
            int count = sc.nextInt();
            sc.nextLine();
            Worker worker;
            for (int i = 0; i < count; i++) {
                worker= new Worker();
                System.out.println("Введите имя");
                worker.name = sc.nextLine();
                System.out.println("Введите фамилию");
                worker.lastname = sc.nextLine();
                System.out.println("Введите возраст");
                worker.age = sc.nextInt();
                sc.nextLine();
                oos.writeObject(worker);
            }

            System.out.println("Информация о работниках записанная в файл");

            fin = new FileInputStream(f);
            oin = new ObjectInputStream(fin);

            File fOut = new File("workersOut");
            if (fOut.exists()) fOut.delete();
            fOut.createNewFile();
            fos2 = new FileOutputStream(fOut);
            oos2 = new ObjectOutputStream(fos2);

            fin2 = new FileInputStream(fOut);
            oin2 = new ObjectInputStream(fin2);
            int workersOver30 = 0;
            for (int i = 0; i < count; i++) {
                worker = (Worker) oin.readObject();
                if (worker.age > 30) {
                    oos2.writeObject(worker);
                    workersOver30++;
                }
            }
            System.out.println("Сотрудники старше 30 лет");
            if (workersOver30 != 0) {
                for (int i = 0; i < workersOver30; i++) {
                    System.out.println((Worker) oin2.readObject());
                }
            } else {
                System.out.println("Нету сотрудников старше 30 лет");
            }

        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (ClassNotFoundException cne) {
            cne.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            oos2.flush();
            oos2.close();
            fos2.flush();
            fos2.close();
            oin2.close();
            fin2.close();
            oos.flush();
            oos.close();
            fos.flush();
            fos.close();
            oin.close();
            fin.close();
        }
    }
}
