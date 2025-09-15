import java.time.LocalTime;

public class TimeChecker1 {
    private int hour;
    private int minute;

    public TimeChecker1(String localTimeStr) {
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
