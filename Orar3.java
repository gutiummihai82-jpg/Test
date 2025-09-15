import java.util.Scanner;

public class Orar3 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introdu numele orașului: ");
            String city = scanner.nextLine();

            String apiKey = "d5d3167c374f46acbf600530250709"; // pune cheia ta WeatherAPI
            WeatherInfo weather = new WeatherInfo(apiKey, city);

            if (!weather.fetchWeather()) {
                System.out.println("Nu am putut prelua datele meteo. Folosim ora locală a calculatorului.");
            }

            TimeChecker timeChecker = new TimeChecker(weather.getLocalTimeStr());
            double temp = weather.getTemp();

            boolean hot = temp > 25;

            // decizie conditioner
            if (hot && !timeChecker.isNight()) {
                System.out.println("\nConditioner on - " + temp + "°C");
            } else if (temp == 25 && timeChecker.isNight()) {
                System.out.println("Conditioner off - Temp: " + temp + "°C");
            } else if (temp == 25 && !timeChecker.isNight()) {
                System.out.println("Conditioner waiting - Temp: " + temp + "°C");
            } else {
                System.out.println("Conditioner off - Temp: " + temp + "°C");
            }

            // afișare timp și mesaj
            System.out.println("Time: " + String.format("%02d", timeChecker.getHour())
                    + ":" + String.format("%02d", timeChecker.getMinute()));

            if (timeChecker.isMorning()) System.out.println("Good Morning!");
            else if (timeChecker.isAfternoon()) System.out.println("Good Afternoon!");
            else if (timeChecker.isEvening()) System.out.println("Good Evening!");
            else if (timeChecker.isNight()) System.out.println("Good Night!");

            System.out.println("Condiția meteo: " + weather.getCondition());
        }
}
