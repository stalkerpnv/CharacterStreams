import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {

        int[] arr =new int[8];
        for (int i = 0; i < arr.length; i++) {
            
        }
        int [] arrTwo = {1,5,2,3,2};

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите a");
        double  a = sc.nextInt();
        System.out.println("Введите b");
        double  b = sc.nextInt();
        sc.nextLine();
        while (true) {
            System.out.println("Введите команду");
            String command = sc.nextLine();
    /*        if (command.equals("exit")) {
                System.out.println("Завершение программы");
                break;
            } else if (command.equals("+")) {

            } else if (command.equals("-")) {
                System.out.println("Результат вычитания " + (a - b));
            } else if (command.equals("*")) {
                System.out.println("Результат умножения " + (a * b));
            } else if (command.equals("/")) {
                System.out.println("Результат деления " + (double) (a / b));
            } else {
                System.out.println("Неизвестная команда");
            }*/

            label:switch (command) {
                case "+": {
                    System.out.println("Результат сложения " + (a + b));
                    break label;
                }
                case "-": {
                    System.out.println("Результат вычитания " + (a - b));
                    break label;
                }
                case "*":{
                    System.out.println("Результат умножения " + (a * b));
                    break label;
                }
                case "/":{
                    System.out.println("Результат деления " + (double) (a / b));
                    break label;
                }
                default:{
                    System.out.println("Завершение программы");
                    break;
                }
            }
        }

    }
}
