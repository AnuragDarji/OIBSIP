import java.util.Scanner;
import java.util.HashMap;

class OnlineExam {
    HashMap<String, Integer> d = new HashMap<String, Integer>();
    Scanner input = new Scanner(System.in);

    public void login() {
        System.out.println("\n================= Welcome to ONLINE EXAM SYSTEM ==============");
        System.out.print("Enter User Id: ");
        String userID = input.nextLine();
        System.out.print("Enter Password: ");
        int password = input.nextInt();
        d.put("Admin", 123);

        if (d.containsKey(userID) && d.get(userID) == password) {
            System.out.println("You are successfully logged in");
            main();
        } else {
            System.out.println("Invalid! Please Check...");
            login();
        }
    }

    public void main() {
        System.out.println("\n1.Update\n2.Start test\n3. Logout");
        System.out.print("Enter your choice: ");
        int op = input.nextInt();
        switch (op) {
            case 1:
                d = update();
                main();
                break;
            case 2:
                solve();
                main();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Choice!");
        }
    }

    public HashMap<String, Integer> update() {
        System.out.println("\n--------- Update --------");
        System.out.print("Enter Username: ");

        Scanner input = new Scanner(System.in);
        String id = input.nextLine();

        if (d.containsKey(id)) {
            System.out.print("Enter New Password: ");
            int newpd = input.nextInt();
            d.replace(id, newpd);
            System.out.println("Profile Update Success!");
        } else {
            System.out.println("User does not exist...");
            System.out.println("Profile Update Failed");
        }
        return d;
    }

    public void solve() {
        long start = System.currentTimeMillis();
        long terminate = start + 60 * 1000;
        long score = 0;
        int c = 0, w = 0;
        char ans;
        System.out.println("\n---------- Starting The Test -----------");
        System.out.println("You have 1 Minute to answer each question. Select the options wisely...");
        System.out.println("All the very best!!");

        while (System.currentTimeMillis() < terminate) {
            System.out.println("\nQ1. Which of the following is NOT a programming language?");
            System.out.println("a.Lotus\nb.C++\nc.Fortran\nd.Java");
            System.out.print("Answer: ");
            ans = input.next().charAt(0);
            if (ans == 'a') {
                c += 1;
            } else {
                w -= 1;
            }

            System.out.println("\nQ2.Which of these interface handle sequences?");
            System.out.println("a.Comparator\nb.List\nc.Collection\nd.Set");
            System.out.print("Answer: ");
            ans = input.next().charAt(0);
            if (ans == 'b') {
                c += 1;
            } else {
                w -= 1;
            }

            System.out.println("\nQ3.Which programming paradigm emphasizes on writing code that is easy to read and maintain?");
            System.out.println(
                    "a.Procedural programming\nb.Functional programming\nc.Object-oriented programming\nd.Structured programming");
            System.out.print("Answer: ");
            ans = input.next().charAt(0);
            if (ans == 'c') {
                c += 1;
            } else {
                w -= 1;
            }

            System.out.println("\nQ4.Which of the following interface must contain a unique element?");
            System.out.println("a.Set\nb.Collection\nc.List\nd.Array");
            System.out.print("Answer: ");
            ans = input.next().charAt(0);
            if (ans == 'a') {
                c += 1;
            } else {
                w -= 1;
            }

            System.out.println("\nQ5.Which of the following does not compile?");
            System.out.println(
                    "a.int num = 999;\nb.int num = 9_9_9;\nc.int num = _9_99\nd.None of above;they all compile");
            System.out.print("Answer: ");
            ans = input.next().charAt(0);
            if (ans == 'c') {
                c += 1;
            } else {
                w -= 1;
            }
            break;
        }

        System.out.println("Test Completed!");
        score = ((c * 5) + w);
        System.out.println("Number of correct answers: " + c);
        System.out.println("Congratulations!! Your score is " + score + ".");
    }

    public static void main(String[] args) {
        OnlineExam e = new OnlineExam();
        e.login();
    }
}