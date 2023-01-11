package loginPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    List<String> usernames = new ArrayList<>();

    List<String> emails = new ArrayList<>();

    List<String> passwords = new ArrayList<>();


    public void register() {
        Scanner inp = new Scanner(System.in);
        System.out.println("Please enter your name and surname: ");
        String name = inp.nextLine();

        String username;
        boolean existUsername;
        do {
            System.out.println("Please enter your username: ");
            username = inp.nextLine().trim();
            existUsername = this.usernames.contains(username);
            if (existUsername) {
                System.out.println("Username is already used, please try another username");
            }
        } while (existUsername);

        String email;
        boolean existsEmail;
        boolean isValid;
        do {
            System.out.println("Please enter your email: ");
            email = inp.nextLine().trim();
            isValid = validateEmail(email);
            existsEmail = this.emails.contains(email);
            if (existsEmail) {
                System.out.println("Email is already used, please try another email");
                isValid = false;
            }
        } while (!isValid);

        String password;
        boolean isValidPassw;

        do {
            System.out.println("Please enter your password: ");
            password = inp.nextLine().trim();
            isValidPassw = validatePassword(password);

        } while (!isValidPassw);

        User user = new User(name, username, email, password);

        this.usernames.add(user.username);
        this.emails.add(user.email);
        this.passwords.add(user.password);
        System.out.println("Congratulations!");
        System.out.println("You can login with your username and password");
    }

    public void login() {
        Scanner inp = new Scanner(System.in);
        System.out.println("Please enter your username or email: ");
        String usernameOrEmail = inp.next();

        //Username or email ?
        boolean isUserName = this.usernames.contains(usernameOrEmail);
        boolean isMail = this.emails.contains(usernameOrEmail);

        if (isUserName || isMail) {
            boolean isWrong = true;
            while (isWrong) {
                System.out.println("Please enter your password: ");
                String password = inp.next();
                int index;
                if (isUserName) {
                    index = this.usernames.indexOf(usernameOrEmail);
                } else {
                    index = this.emails.indexOf(usernameOrEmail);
                }

                if (this.passwords.get(index).equals(password)) {
                    System.out.println("You are logged in, welcome!");
                    isWrong = false;
                } else System.out.println("Password is wrong, please try again!");
            }
        } else {
            System.out.println("Registered user not found.");
            System.out.println("If you have registered please try again, if you are not please register!");
        }
    }

    public boolean validateEmail(String email) {
        boolean isValid;
        boolean space = email.contains(" ");
        boolean isContainAt = email.contains("@");
        if (space) {
            System.out.println("Email cannot contain space character!");
            isValid = false;
        } else if (!isContainAt) {
            System.out.println("Email must contain '@' character!");
            isValid = false;
        } else {

            String firstPart = email.split("@")[0];
            String secondPart = email.split("@")[1];

            int notValid = firstPart.replaceAll("[a-zA-Z0-9-._]", "").length();
            boolean checkStart = notValid == 0;

            boolean checkEnd = secondPart.equals("gmail.com") ||
                    secondPart.equals("hotmail.com") ||
                    secondPart.equals("yahoo.com");

            if (!checkStart) {
                System.out.println("Email can only contain uppercase, lowercase, numbers and '.-_' characters !");
            } else if (!checkEnd) {
                System.out.println("Email must end with 'hotmail.com', 'gmail.com' or 'yahoo.com' !");
            }
            isValid = checkEnd && checkStart;
        }
        if (!isValid) {
            System.out.println("Invalid email, please try again!");
        }
        return isValid;
    }

    public boolean validatePassword(String password) {
        boolean isValid;
        String upperCase = password.replaceAll("[^A-Z]", "");
        String lowerCase = password.replaceAll("[^a-z]", "");
        String digit = password.replaceAll("[\\D]", "");
        String symbol = password.replaceAll("[\\P{Punct}]", "");
        boolean space = password.contains(" ");
        boolean lenghtGt6 = password.length() > 5;
        boolean existUpper = upperCase.length() > 0;
        boolean existLower = lowerCase.length() > 0;
        boolean existDigit = digit.length() > 0;
        boolean existsSymbol = symbol.length() > 0;

        if (space) {
            System.out.println("Password cannot contain space character!");
        } else if (!lenghtGt6) {
            System.out.println("Password must be at least 6 characters long!");
        } else if (!existUpper) {
            System.out.println("Password must contain at least one upper case!");
        } else if (!existLower) {
            System.out.println("Password must contain at least one lower case!");
        } else if (!existDigit) {
            System.out.println("Password must contain at least one digit!");
        } else if (!existsSymbol) {
            System.out.println("Password must contain at least one symbol!");
        }


        isValid = !space && lenghtGt6 && existUpper && existLower && existDigit && existsSymbol;
        if (!isValid) {
            System.out.println("Invalid password, please try again!");
        }

        return isValid;
    }

}
