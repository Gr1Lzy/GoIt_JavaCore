package org.example.module12_1;

public class TimerFiveSec {
    static int timer = 0;

    public static void startTimer() {
        Thread timerThread = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(1000);
                    System.out.println(++timer);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread fiveSecThread = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(5000);
                    System.out.println("5 sec");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        timerThread.start();
        fiveSecThread.start();
    }
}
