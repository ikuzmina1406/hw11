package ua.GoIT.modul11.FirstTask;

public class Timer implements Runnable {

    private final int period;
    private Thread t = new Thread(this);

    Timer(int period) {
        this.period = period;
        t.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(period * 1000);
                synchronized (Message.class) {
                    Message.sendMessage(Integer.toString(++Message.count));
                    Message.class.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

