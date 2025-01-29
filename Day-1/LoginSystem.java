import java.util.Scanner;
import java.util.HashMap;

class LoginSystem {
    public static void main(String[] args) {

        boolean isRunning = true;
        HashMap <String, String> hm = new HashMap<>();

        while (isRunning) {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Options: ");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Logout");
            System.out.println("4. Exit Application");

            System.out.print("Choose an option: ");
            int n = sc.nextInt();
            
            switch (n) {
                case 1:
                    System.out.println("Enter user name: ");
                    String userName = sc.next();
                    System.out.println("Enter password: ");
                    String password = sc.next();
                    hm.put(userName, password);
                    System.out.println();
                    System.out.println("User registered successfully\n");
                    break;
                case 2:
                    System.out.println("Enter user name: ");
                    String name = sc.next();
                    System.out.println("Enter password: ");
                    String pass = sc.next();
                    if(hm.containsKey(name) && hm.containsValue(pass)) {
                        System.out.println();
                        System.out.println("Login successful!\n");
                    } else {
                        System.out.println("Invalid credentials!");
                        break;
                    }
                case 3:
                    System.out.println("press 0 to logout");
                    int out = sc.nextInt();
                    if (out == 0) {
                        System.out.println("You have Logged out.\n");
                        break;
                    } else {
                        System.out.println("Invalid prompt 1!\n");
                        System.out.println("press 0 to logout");
                        while (out != 0) {
                            out = sc.nextInt();
                            if(out == 0) {
                                System.out.println("You have Logged out.\n");
                                break;
                            } else {
                                System.out.println("Invalid prompt 2!\n");
                            }
                        }
                        break;
                    }
                case 4:
                    System.out.println();
                    System.out.println("Exiting application...");
                    isRunning = false;
                    break;
                default:
                    System.out.println();
                    System.out.println("Choose a valid option!\n");
                    break;
            }
        }
    }
}
