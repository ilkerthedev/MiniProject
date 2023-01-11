package loginPage;

import java.util.Scanner;

/*

Project: Bir siteye üye olma ve giriş yapma sayfası tasarlayınız.

         menü: kullanıcıya işlem seçimi için menü gösterilir.

         üye olma(register): kullanıcıdan ad-soyad, kullanıcı adı, email ve şifre bilgileri alınız.
                             kullanıcı adı, email ve şifre birer listede tutulur.
                             aynı kullanıcı adı veya email kabul edilmez.

         giriş(login): kullanıcı adı/email ve şifre girilir.
                       kullanıcı adı veya email bulunamazsa kayıtlı değil, üye olun uyarısı verilir.
                       kullanıcı adı/email ile aynı indekste kayıtlı şifre doğrulanırsa siteye giriş yapılır.

         email validation: boşluk içermemeli
                         : @ içermeli
                         : gmail.com,hotmail.com veya yahoo.com ile bitmeli.
                         : mailin kullanıcı adı kısmında(@ den önce) sadece büyük-küçük harf,rakam yada -._ sembolleri olabilir.

         password validation: boşluk içermemeli
                            : en az 6 karakter olmalı
                            : en az bir tane küçük harf içermeli
                            : en az bir tane büyük harf içermeli
                            : en az bir tane rakam içermeli
                            : en az bir tane sembol içermeli
 */
public class LoginPageApp {
    public static void main(String[] args) {
        start();
    }

    public static void start(){
        Scanner inp = new Scanner(System.in);
        UserService service = new UserService();
        int select;
        do{
            showMenu();
            select = inp.nextInt();
            switch (select){
                case 1:
                    service.register();
                    System.out.println(service.usernames);
                    System.out.println(service.emails);
                    System.out.println(service.passwords);
                    break;
                case 2:
                    service.login();
                    break;
                case 0:
                    System.out.println("Have a good day...");
                    break;
                default:
                    System.out.println("The selection is incorrect please try again...");
            }

        }while (select!=0);
    }

    public static void showMenu() {
        System.out.println("===TECHPRO EDUCATION===");
        System.out.println("1-Register");
        System.out.println("2-Login");
        System.out.println("0-Quit");
        System.out.println("Your selection:");
    }

}
