public class Money {

    public static void main(String[] args) {
        System.out.println("What to it with my money?");
        int money = 0;
        System.out.println("Money: " + money);

        if (money == 0) {
            System.out.println("You are a Unemployed go to work!");
        } else if (money >= 20) {
            System.out.println("Buy a Stake");
        } else if (money >= 10) {
            System.out.println("Buy a Pizza");
        } else if (money >= 5) {
            System.out.println("Buy a Burger");
        } else {
            System.out.println("Buy a Sandwich");
        }
    }
}