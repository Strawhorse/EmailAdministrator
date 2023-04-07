
/*
 1. Create a public github repository for a NetBeans project (any project)
2. Along with the main branch, create two other branches
3. Make at least 3 commits to each branch
4. Submit the link to the GitHub Repository to Moodle
John Bracken
sba22328
This is an email administrator app that I wrote a little while ago that would be good to use.
Creates a user account for new employees at a company
Can even save the login details locally
 */


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
            System.out.println("\n*********\nPlease choose:\n1 Show info \n2 Change password \n3 Change mailbox capacity \n4 Set alternate email \n5 Store data \n6 Read data \n7 Exit");
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
                    System.out.println("This is the second commit to the main branch");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice!=7);

    }
}
