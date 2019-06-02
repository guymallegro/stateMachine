import java.util.Scanner;

public class Main {
    static Context context;

    public static void main(String[] args) {
        System.out.println("Hello user, by default the machine is turned on and not connected to the internet.\n" +
                "Here are the supported commands:\n" +
                "1. turnOn\n" +
                "2. turnOff\n" +
                "3. internetOn\n" +
                "4. internetOff\n" +
                "5. fileRequest\n" +
                "6. setSpace (After typing 'setSpace' type '0' or '1')\n" +
                "7. downloadAborted\n" +
                "8. downloadError\n" +
                "9. errorFixed\n" +
                "10. movieOn\n" +
                "11. restartMovie\n" +
                "12. holdMovie\n" +
                "13. movieOff\n" +
                "14. resume\n");
        context = new Context();
        Thread inputThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    String input = scanner.nextLine();
                    input(input);
                }
            }
        });
        inputThread.start();

        Thread timeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        context.increaseTime();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        timeThread.start();
    }

    public static void input(String input) {
        switch (input) {
            case "turnOn":
                if (!context.isOn) {
                    System.out.println("Exit turnOff state");
                    System.out.println("Enter turnOn state");
                    context.isOn = true;
                }
                break;
            case "turnOff":
                if (context.isOn) {
                    System.out.println("Exit turnOn state");
                    System.out.println("Enter turnOff state");
                    context.isOn = false;
                }
                break;
            case "internetOn":
                if (context.isOn)
                    context.setInternetOn();
                break;
            case "internetOff":
                if (context.isOn)
                    context.setInternetOff();
                break;
            case "fileRequest":
                if (context.isOn)
                    context.fileRequest();
                break;
            case "setSpace":
                if (context.isOn) {
                    Scanner scanner = new Scanner(System.in);
                    String number = scanner.nextLine();
                    int space = Integer.valueOf(number);
                    if (space == 0)
                        context.isEnoughSpace = false;
                    else
                        context.isEnoughSpace = true;
                }
                break;
            case "downloadAborted":
                if (context.isOn)
                    context.downloadAbort();
                break;
            case "downloadError":
                if (context.isOn)
                    context.downloadError();
                break;
            case "errorFixed":
                if (context.isOn)
                    context.downloadFixed();
                break;
            case "movieOn":
                if (context.isOn)
                    context.movieOn();
                break;
            case "restartMovie":
                if (context.isOn)
                    context.restartMovie();
                break;
            case "holdMovie":
                if (context.isOn)
                    context.pauseMovie();
                break;
            case "movieOff":
                if (context.isOn)
                    context.movieOff();
                break;
            case "resume":
                if (context.isOn)
                    context.resumeMovie();
                break;
        }
    }
}
