package Code;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Registratura {

    public static int money = 0;
    static Scanner scan = new Scanner(System.in);

    public static void first() {
        while (true) {
            System.out.print("Где ваша маска?\n" +
                    "1. Надеть маску\n" +
                    "2. Уйти\n" +
                    "Номер: ");
            String act1 = scan.nextLine();
            switch (act1) {
                case "1":
                    System.out.println("\nДобро пожаловать в клинику \"Сдохни или Умри\"!");
                    registratura();
                    break;
                case "2":
                    System.exit(0);
                default:
                    System.out.print("Введите цифру существующего действия. ");
                    continue;
            }
            break;
        }
    }
        public static void registratura() {
        if (Auth.getStatus().equals("администратор")) {
            System.out.println("smth");
        }
        else {
            System.out.print("\nВозможности регистратуры:\n" +
                    "1. Авторизироваться (Сейчас вы " + Auth.getStatus() + ")\n" +
                    "2. Здание поликлиники (в разработке) \n" +
                    "3. Отдиление помощи при COVID-19 (в разработке)\n" +
                    "4. Оплатить услуги\n" +
                    "5. Выйти\n" +
                    "Номер: ");
        }
            while (true) {
                String act2 = scan.nextLine();
                switch (act2) {
                    case "1":
                        Auth.enter();
                        break;
                    case "2":
                         //Policlinika.main();
                        System.out.println("Error 404.");
                        break;
                    case "3":
                        //System.out.println("\nДобро пожаловать в отдиление помощи при COVID-19.\n" + "Чтобы вернуться в регистратуру введите 0.");
                        //Covid.main();
                        System.out.println("Error 404.");
                        break;
                    case "4":
                        Oplata.oplata();
                        break;
                    case "5":
                        if (money != 0) {
                            System.out.println("Сперва вам нужно оплатить услуги в кассе.");
                            registratura();
                        } else {
                            System.out.println("До свидания!");
                            System.exit(0);
                        }
                    default:
                        System.out.print("Введите цифру существующего действия: ");
                        continue;
                }
                break;
            }
        }
}
