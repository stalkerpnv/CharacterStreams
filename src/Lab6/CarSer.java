package Lab6;

import java.io.*;
import java.util.Scanner;

class Car implements Serializable {
    String model;
    String color;
    int year;

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                '}';
    }
}

public class CarSer {
    public static void main(String[] args) throws IOException{
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fin = null;
        ObjectInputStream oin = null;

        try {
            File f = new File("Our.txt");
            if (f.exists()) f.delete();
            f.createNewFile();
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);
            Scanner sc = new Scanner(System.in);
            System.out.println("Сколько машин хотите записать");
            int count = sc.nextInt();
            sc.nextLine();
            Car car;
            for (int i = 0; i < count; i++) {
                car = new Car();
                System.out.println("Введите модель");
                car.model = sc.nextLine();
                System.out.println("Введите цвет");
                car.color = sc.nextLine();
                System.out.println("Введите год");
                car.year = sc.nextInt();
                sc.nextLine();
                oos.writeObject(car);
            }

            fin = new FileInputStream(f);
            oin = new ObjectInputStream(fin);
            for (int i = 0; i < count; i++){
                car = (Car)oin.readObject();
                if(car.year>2009){

                }
                System.out.println(car);
            }
        }catch (IOException | ClassNotFoundException ie){
            ie.printStackTrace();
        }
        finally {
            oos.flush();
            oos.close();
            fos.close();
            oin.close();
            fin.close();

        }
    }
}