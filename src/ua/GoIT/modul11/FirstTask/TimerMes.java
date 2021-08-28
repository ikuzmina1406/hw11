package ua.GoIT.modul11.FirstTask;


public class TimerMes implements Runnable{
    private final int period;
    private String mes;
    private Thread t = new Thread(this);

    TimerMes(int period, String mes){
        this.period = period;
        this.mes = mes;
        t.start();
    }

    @Override
    public void run() {
        try {
            while (true)
                synchronized (Message.class) {
                    Message.class.wait();
                    if (Message.count % period == 0)
                        Message.sendMessage(mes);
                }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}