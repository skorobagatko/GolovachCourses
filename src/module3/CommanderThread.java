package module3;

public class CommanderThread extends Thread {

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread threadA = new Thread(new PrintBuilder("A     .", 100));
                Thread threadB = new Thread(new PrintBuilder(".     B", 99));
                Thread threadC = new Thread(new PrintBuilder("C", 100));
                threadA.start();
                threadB.start();

                threadA.join();
                threadB.join();

                System.out.println("-------");
                threadC.start();

                threadC.join();

                System.out.println("-------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
