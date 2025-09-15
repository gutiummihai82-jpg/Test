import java.util.Scanner;

public class Skidka {


    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        System.out.println("Type your name: ");
        String name = console.nextLine();


        System.out.println("Type your Money: ");
        double sum = console.nextDouble();


        System.out.println("Type your Age: ");
        int age = console.nextInt();

        double discount = 0.0;

        if (age>=60)
            {
                System.out.println("Congratulations " + name + "!");
                discount = 0.2 * sum;
                System.out.println("Because you are " + age + " years old! You get a discount of 20%!");
                System.out.printf("Final price = $%.2f%n", sum - discount);
            }
        else
            {
                System.out.println("Sorry, no discounts for you! :(");
            }
        console.close();
    }
}
