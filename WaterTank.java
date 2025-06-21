import java.util.concurrent.atomic.AtomicInteger;

public class WaterTank {
    static AtomicInteger level = new AtomicInteger(50);
    static final int MAX = 100;
    static volatile boolean running = true;

    public static void main(String[] args) {
        new Inlet().start();
        new Outlet().start();
        new Monitor().start();

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
        }

        running = false;
        System.out.println("System stopped.");
    }
}

class Inlet extends Thread {
    public void run() {
        while (WaterTank.running) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            
            if (WaterTank.level.get() < WaterTank.MAX) {
                System.out.println("Water added: " + WaterTank.level.incrementAndGet());
            } else {
                System.out.println("Tank full.");
            }
        }
    }
}

class Outlet extends Thread {
    public void run() {
        while (WaterTank.running) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {}

            if (WaterTank.level.get() > 0) {
                System.out.println("Water removed: " + WaterTank.level.decrementAndGet());
            } else {
                System.out.println("Tank empty.");
            }
        }
    }
}

class Monitor extends Thread {
    public void run() {
        while (WaterTank.running) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {}
            System.out.println("Current level: " + WaterTank.level.get());
        }
    }
}
