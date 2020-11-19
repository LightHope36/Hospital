package Code;

public class Oplata {
    public static void oplata() {
        //int money = Policlinika.getMoney();
        if (Registratura.money != 0){
            System.out.println("Вы оплатили " + Registratura.money + " рублей.");
            Registratura.money = 0;
        }
        else {
            System.out.println("Вам нечего оплачивать.");
        }
        Registratura.registratura();
    }
}
