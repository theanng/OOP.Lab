import java.util.Scanner;
public class InputFromKeyboard {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String strName = scanner.nextLine();
        System.out.println("How old are you?");
        int age = scanner.nextInt();
        System.out.println("How tall are you (m)?");
        double height = scanner.nextDouble();
        System.out.println("Mrs/Mr "+strName+", age "+ age+", height "+height);
    }
}
    

