package emailapp;
import java.util.*;

public class EmailApp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        String f_name = s.next();
        System.out.println("Enter your family name: ");
        String l_name = s.next();

        // creating an object using these details using class instantiation
        Email em1 = new Email(f_name, l_name);
        int choice = -1;

        do{
            System.out.println("\n*********\nPlease choose:\n1 Show info \n2 Change password \n3 Change mailbox capacity \n4 Set alternate email \n5 Store data \n6 Read data \n 7 Exit");
            choice = s.nextInt();
            switch (choice) {
                case 1: em1.getInfo();
                break;
                case 2: em1.change_Password();
                break;
                case 3: em1.set_mail_capacity();
                break;
                case 4: em1.alternative_email();
                break;
                case 5: em1.storeFile();
                break;
                case 6: em1.read_file();
                break;
                case 7:
                    System.out.println("Thank you for using JBrEmailSystems.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice!=7);

    }
}
