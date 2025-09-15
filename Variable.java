public class Variable {

    public static void main(String[] args) {
        int days = 10000;
        int years = days / 365;
        int months = (days - (years * 365)) / 30;
        int leftdays = days - (years * 365) - (months * 30);
        System.out.println("Days: " + days);
        System.out.println("Years: " + years);
        System.out.println("Months: " + months);
        System.out.println("Leftdays: " + leftdays);

    }
}
