import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.util.Scanner;
import org.json.JSONObject;

// Clasa pentru preluarea vremii
class WeatherInfo {
    private String apiKey;
    private String city;
    private double temp;
    private String condition;
    private String localTimeStr;

    public WeatherInfo(String apiKey, String city) {
        this.apiKey = apiKey;
        this.city = city;
    }

    public boolean fetchWeather() {
        try {
            String cityEncoded = URLEncoder.encode(city, StandardCharsets.UTF_8);
            String urlString = "http://api.weatherapi.com/v1/current.json?key="
                    + apiKey + "&q=" + cityEncoded + "&aqi=no";

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject json = new JSONObject(response.toString());
            temp = json.getJSONObject("current").getDouble("temp_c");
            condition = json.getJSONObject("current").getJSONObject("condition").getString("text");
            localTimeStr = json.getJSONObject("location").getString("localtime");

            return true; // succes
        } catch (Exception e) {
            System.out.println("Eroare la preluarea vremii: " + e.getMessage());
            return false;
        }
    }

    public double getTemp() { return temp; }
    public String getCondition() { return condition; }
    public String getLocalTimeStr() { return localTimeStr; }
}

// Clasa pentru decizia asupra timpului
class TimeChecker {
    private int hour;
    private int minute;

    public TimeChecker(String localTimeStr) {
        if (localTimeStr != null && localTimeStr.contains(" ")) {
            String[] parts = localTimeStr.split(" ");
            if (parts.length > 1) {
                String[] hm = parts[1].split(":");
                hour = Integer.parseInt(hm[0]);
                minute = Integer.parseInt(hm[1]);
            } else {
                fallback();
            }
        } else {
            fallback();
        }
    }

    private void fallback() {
        LocalTime now = LocalTime.now();
        hour = now.getHour();
        minute = now.getMinute();
    }

    public int getHour() { return hour; }
    public int getMinute() { return minute; }

    public boolean isNight() { return hour >= 21 || hour < 6; }
    public boolean isMorning() { return hour >= 6 && hour < 9; }
    public boolean isAfternoon() { return hour >= 9 && hour < 17; }
    public boolean isEvening() { return hour >= 17 && hour < 21; }
}

// Clasa principală
public class Orar2 {
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

        // decizie conditioner
        boolean hot = temp > 25;
        if (hot && !timeChecker.isNight()) {
            System.out.println("Conditioner on - " + temp + "°C");
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


