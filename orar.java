public class orar {
    public static void main(String[] args) {
        boolean goodwether = true;
        int time = 8;
        boolean isNight = time > 22 || time < 6;
if (isNight) System.out.println("Go to sleep");
if (!isNight && goodwether) System.out.println("Go outside");
if (!isNight && !goodwether) System.out.println("Read a book");
        }}