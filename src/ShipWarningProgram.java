import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ShipWarningProgram {

    public static void main(String[] args) {
        Handling handling = new Handling();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                handling.savePositionFileToQueue();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (Handling.count==0){
                    handling.getDataFromQueue();
                }
            }
        });

        t2.start();
    }

}

