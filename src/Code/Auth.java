package Code;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Auth {

    static Account client1 = new Account("VVPendless");  //создание объекта
    static Account admin = new Account("G0O0D0");  //создание объекта
    private static String status = "гость";
    private static String name;
    private static String referral = "нет";
    public static String login;

    public static void enter(){
        Scanner scan = new Scanner(System.in);
        //System.out.println("Статусы:" + "1. Гость" + "2. Клиент" + "3. Администратор");
        while (true){
            System.out.print("Введите логин: ");
            String log = scan.nextLine();
            switch (log){
                case "VVPendless":
                    if (client1.checkPass() == true) { //проверяет совпадает ли пароль из файла
                        status = "клиент";
                        name = "Нателла";
                        login = "VVPendless";
                        System.out.print("\nЗдравствуйте " + name + "!");
                        Registratura.registratura();
                    }
                    else {
                        System.out.println("Ошибка");
                    }
                    break;
                case "G0O0D0":
                    if (admin.checkPass() == true) {
                        status = "администратор";
                        name = "Ричард";
                        login = "G0O0D0";
                        System.out.print("\nЗдравствуйте "  + name + "!");
                        Registratura.registratura();
                    }
                    else {
                        System.out.println("Ошибка");
                    }
                    break;
                case "0":
                    Registratura.registratura();
                    break;
                default:
                    System.out.println("Такого логина нет. Для выхода наберите 0.");
                    continue; //цикл продолжается
            }
            break; //выходит из цикла
        }
    }
    public static String getStatus(){
        return status;
    } //показывает статус
    public static String getName(){
        return name;
    } //показывает имя
    public static String checkReferral(){
        StringBuilder t = new StringBuilder(""); //StringBuilder используется для экономии памяти
        try
        {
            System.out.println(login);
            FileReader r = new FileReader(login+"Referral.txt"); //читает файл с направлением к врачу
            int i;
            while ((i=r.read())!=-1){
                t.append((char) i);
                referral = String.valueOf(t);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return referral;
    }
    public static void setReferral(String newReferral){
        try (FileWriter writer = new FileWriter(login+"Referral.txt", false)) { //записывает направление в файл
            String text = newReferral;
            writer.write(text);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
