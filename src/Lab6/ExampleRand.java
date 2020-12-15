package Lab6;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ExampleRand {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Сколько студентов хотите записать");
        int count = sc.nextInt();
        sc.nextLine();
        try {
            File f = new File("Students.txt");
            if(f.exists()) f.delete();
            f.createNewFile();
            RandomAccessFile rf = new RandomAccessFile(f, "rw");
            String name, lastname;
            int age;
            rf.seek(0);
            for (int i = 0; i < count; i++) {
                System.out.println("Введите имя");
                name = sc.nextLine();
                rf.writeUTF(name);
                for (int j = 0; j < 20 - name.length(); j++) rf.writeByte(1);

                System.out.println("Введите фамилию");
                lastname = sc.nextLine();
                rf.writeUTF(lastname);
                for (int j = 0; j < 20 - lastname.length(); j++) rf.writeByte(1);

                System.out.println("Введите возраст");
                age =sc.nextInt();
                sc.nextLine();
                rf.writeInt(age);
            }
            System.out.println(rf.length());


            rf = new RandomAccessFile(f,"r");
            String namer, lastnamer;
            int ager;
            rf.seek(0);
            for (int i = 0; i < count; i++) {
                namer=rf.readUTF();
                for (int j = 0; j < 20 - namer.length(); j++) rf.readByte();
                lastnamer =rf.readUTF();
                for (int j = 0; j < 20 - lastnamer.length(); j++) rf.readByte();
                ager = rf.readInt();
                System.out.println("name " + namer + " lastname "+ lastnamer + " age " + ager);
            }
            for (int i = 0; i < count; i++) {
                rf.seek(0 + i*48);
                namer=rf.readUTF();
                rf.seek(20 + i*48);
                lastnamer =rf.readUTF();
                rf.seek(40 + i*48);
                ager = rf.readInt();
                System.out.println("name " + namer + " lastname "+ lastnamer + " age " + ager);
            }
rf.close();
        }
        catch(IOException ie){
            ie.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
