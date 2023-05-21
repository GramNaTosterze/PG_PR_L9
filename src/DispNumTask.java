import java.lang.Math;
import java.util.Arrays;
import java.util.Random;

public class DispNumTask implements Runnable {
    private boolean[] sharedSource;
    public DispNumTask(boolean[] _sharedSource) {
        sharedSource = _sharedSource;
    }

    @Override
    public void run() {
        while (true) {
            int num = new Random().nextInt(Main.MAX_NUMBER);
            synchronized (sharedSource) {
                if (!sharedSource[num]) {
                    System.out.printf("Thread: %d - %d\n", Thread.currentThread().getId(), num);
                    sharedSource[num] = true;
                } else
                    System.out.printf("Thread: %d - Konflikt: %d\n", Thread.currentThread().getId(), num);
                if (End())
                    break;
            }


        }
    }
    public boolean End() {
        for (boolean bool : sharedSource) {
            if (!bool)
                return false;
        }
        return true;
    }
}
