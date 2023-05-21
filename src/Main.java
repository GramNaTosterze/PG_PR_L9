public class Main {
    //klasyka zadanie
    static boolean[] sharedSource;
    public static final int MAX_NUMBER = 100000;
    public static final int NUMBER_OF_THREADS = 3;

    public static void main(String[] args) {
        sharedSource = new boolean[MAX_NUMBER];

        for (int i = 0; i < NUMBER_OF_THREADS; i++)
            new Thread(new DispNumTask(sharedSource)).start();
    }

}