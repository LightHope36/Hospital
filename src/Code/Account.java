package Code;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Account implements Cloneable {
    static Scanner scan = new Scanner(System.in);
    //static ArrayList <String> Names = new ArrayList<>();
    private String login;
    private String password;


    public Account(String login){ //конструктор
        this.login = login;
        try{
            FileInputStream r = new FileInputStream(login + ".txt");
            int i;
            StringBuilder t = new StringBuilder("");
            while ((i=r.read())!=-1){ //читает пароль из файла посимвольно
                t.append((char) i);
            }
            password = String.valueOf(t);
        } catch (IOException e){
            e.getMessage();
        }
    }

    public boolean checkPass(){ //провераяет введённый пароль
        boolean flag = false;
        while (true){
            System.out.print("Введите пароль: ");
            String pas = scan.nextLine();
            if (pas.equals(password)){
                flag = true;
                break;
            }
            else if (pas == "0"){
                Registratura.registratura();
                break;
            }
            else {
                System.out.println("Пароль введён неверно.");
            }
        }
        return flag;
    }

    public Account clone() throws CloneNotSupportedException{
        return (Account) super.clone();
    }

    /*public void setLogin(String login){
        if (login.isEmpty()) {
            System.out.println("Вы ввели пустой логин.");
        } else {
            this.login = login;
        }
    }*/

}
