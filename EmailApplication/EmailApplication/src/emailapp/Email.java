package emailapp;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Email {

    public Scanner scanner = new Scanner(System.in);

    // private variables only available to this class
    private String fname;
    private String lname;
    private String dept;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alternative_email;

    // constructor to receive the arguments for class instantiation
    public Email(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
        System.out.printf("New employee created: %s %s%n", this.fname, this.lname);

        // assigning other variables to instance
        this.dept = this.setDept();
        this.password = this.generate_password(8);
        this.email = this.generate_email();
    }

    // Generate mail method
    private String generate_email() {
        return this.fname.toLowerCase()+" "+lname.toLowerCase()+"@"+this.dept+".company.com";
    }

    // Asking for department
    private String setDept(){
        System.out.println("Department codes: \n1 for Sales \n2 for Development \n3 for Accounting \n0 None");
        boolean flag = false;
        do{
            System.out.println("Enter department code: ");
            int choice = scanner.nextInt();
            switch(choice) {
                case 1: return "Sales";
                case 2: return "Development";
                case 3: return "Accounting";
                case 0: return "None";
                default:
                    System.out.println("Invalid choice. Please retry.");
            }
        } while (!flag);
        return null;
    }

    // generate random passwords method
    private String generate_password(int length) {
        Random r = new Random();
        String Capital_characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Lowercase_letters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!£$%^&*()-_;:'@#~[]{}";
        String values = Capital_characters+Lowercase_letters+numbers+symbols;

        String password = "";
        for(int i=0; i<length; i++) {
            password = password+values.charAt(r.nextInt(values.length()));
        }
        return password;
    }

    // change password method
    public void change_Password() {
        boolean flag = false;
        do{
            System.out.println("Do you want to change your password? (Y/N) ");
            char choice = scanner.next().charAt(0);
            if(choice == 'Y' || choice == 'y') {
                flag = true;
                System.out.println("Please enter your current password: ");
                String old_password = scanner.next();
                if(old_password.equals(this.password)) {
                    System.out.println("Please enter a new password: ");
                    this.password = scanner.next();
                    System.out.println("Password changed!");
                }
                else {
                    System.out.println("Incorrect password.");
                }
            } else if (choice == 'n' || choice == 'N') {
                flag = true;
                System.out.println("Password change cancel.");
            }
            else {
                System.out.println("Enter a new choice: (Y/N) ");
            }
        } while (!flag);
    }

    //set mailbox capacity
    public void set_mail_capacity() {
        System.out.println("Current inbox capacity = "+this.mailCapacity+"mb");
        System.out.println("Please enter a new mailbox capacity: [1-999]");
        this.mailCapacity = scanner.nextInt();
        System.out.println("Mailbox capacity changed.");
    }

    // set alternative email address
    public void alternative_email(){
        System.out.println("Please enter an alternative contact email address for backup: ");
        this.alternative_email = scanner.next();
        System.out.println("Alternative email address "+this.alternative_email+ " has been added.");
    }

    // display account information (also use a toString)
    public void getInfo() {
        System.out.println("New: "+this.fname+" "+this.lname);
        System.out.println("Department: "+this.dept);
        System.out.println("Email: "+this.email);
        System.out.println("Capacity: "+this.mailCapacity);
        System.out.println("Current password: "+this.password);
        System.out.println("Alternative email address: "+this.alternative_email);
    }

    @Override
    public String toString() {
        return "Email{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", dept='" + dept + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", mailCapacity=" + mailCapacity +
                ", alternative_email='" + alternative_email + '\'' +
                '}';
    }

    public void storeFile() {
        try{
            FileWriter in = new FileWriter("C:\\Users\\User\\Downloads\\info.txt");
            in.write("First name: "+this.fname);
            in.append("\nLast name: " + this.lname);
            in.append("\nEmail: "+this.email);
            in.append("\nPassword: " + this.password);
            in.append("\nCapacity: " + this. mailCapacity);
            in.append("\nAlternative email: " + this.alternative_email + "\n");
            in.close();
            System.out.println("Data stored to " + in);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void read_file() {
        try{
            FileReader f1 = new FileReader("C:\\Users\\User\\Downloads\\info.txt");
            int i;
            while((i=f1.read())!=-1) {
                System.out.print((char)i);
            }
            f1.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
