package sf;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName : SyncTest
 * @Description :
 * @Author :
 * @Date: 2020-08-26 10:31
 */
public class SyncTest extends ArrayList {

    public SyncTest() {
        System.out.println("1");
    }

    private volatile int i = 10;

    private final Object lock = new Object();

    public synchronized void syncMath() {

        i++;
    }

    public void syncToTo() {
        List<Integer> lis = new ArrayList<>();
        lis.add(1);
        lis.forEach(e -> {
        });
        synchronized (lock) {
            for (int j = 0; j < 50; j++) {
                System.out.println(2);
            }
            i++;
            synchronized (lock) {
                i++;
                lis.stream().map(String::valueOf).forEach(System.out::println);
            }
        }
    }

    public static void main(String[] args) {
        int x = 0;
        long l =0; // Boolean  double float
        byte b = 0;
        short s = 0;
        // 枚举是可以的
        switch (TimeUnit.SECONDS){

        }

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 1000; i++) {
//                        if (i==5)
//                            throw new IllegalArgumentException();
                        TimeUnit.SECONDS.sleep(5);
                        System.out.println(i);
                    }
                } catch (IllegalArgumentException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, TimeUnit.SECONDS.toMillis(3));

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("scheduledExecutorService");
            int i = 9 / 0;
        }, 0, 3, TimeUnit.SECONDS);
    }

}
