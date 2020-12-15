import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class RandomAccessFileW {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Сколько работников хотите записать в файл");
        int count = sc.nextInt();
        sc.nextLine();
        RandomAccessFile rf = null;
        RandomAccessFile rfOut = null;
        try {
            File f = new File("Workers");
            if (f.exists()) f.delete();
            f.createNewFile();
            rf = new RandomAccessFile(f, "rw");
            String name, lastname;
            int age;
            rf.seek(0);
            for (int i = 0; i < count; i++) {
                System.out.println("Введите имя");
                name = sc.nextLine();
                rf.writeUTF(name);
                for (int j = 0; j <20 -name.length() ; j++) rf.writeByte(1);

                System.out.println("Введите фамилию");
                lastname =sc.nextLine();
                rf.writeUTF(lastname);
                for (int j = 0; j <20 -lastname.length() ; j++) rf.writeByte(1);

                System.out.println("Введите возраст");
                age =sc.nextInt();
                rf.writeInt(age);
                sc.nextLine();
            }

            File fOut = new File("outWorkers");
            if(fOut.exists()) fOut.delete();
            fOut.createNewFile();
            rfOut = new RandomAccessFile(fOut,"rw");
            rfOut.seek(0);

            String namer, lastnamer;
            int ager;
            int workerOver30 = 0;
            rf.seek(0);
            for (int i = 0; i < count; i++) {
                namer =rf.readUTF();
                for (int j = 0; j <20 -namer.length() ; j++) rf.readByte();

                lastnamer =rf.readUTF();
                for (int j = 0; j <20 -lastnamer.length() ; j++) rf.readByte();

                ager = rf.readInt();
                if(ager>30){
                    rfOut.writeUTF(namer);
                    for (int j = 0; j <20 -namer.length() ; j++) rfOut.writeByte(1);
                    rfOut.writeUTF(lastnamer);
                    for (int j = 0; j <20 -lastnamer.length() ; j++) rfOut.writeByte(1);
                    rfOut.writeInt(ager);
                    workerOver30++;
                }
            //    System.out.println("name " + namer + " lastname " + lastnamer + " age " + ager);
            }

            if(workerOver30!=0) {
                rfOut.seek(0);
                for (int i = 0; i < workerOver30; i++) {
                    namer = rfOut.readUTF();
                    for (int j = 0; j < 20 - namer.length(); j++) rfOut.readByte();

                    lastnamer = rfOut.readUTF();
                    for (int j = 0; j < 20 - lastnamer.length(); j++) rfOut.readByte();

                    ager = rfOut.readInt();
                    System.out.println("name " + namer + " lastname " + lastnamer + " age " + ager);
                }
            }
            else{
                System.out.println("Нет работников в возрасте более 30 лет");
            }

        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            rf.close();
            rfOut.close();
        }
    }
}
