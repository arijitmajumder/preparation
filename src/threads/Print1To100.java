package threads;

import java.util.ArrayList;
import java.util.List;

public class Print1To100 {

    public int currentTaskValue = 1;

    public static void main(String[] args) {
        Print1To100 monitor = new Print1To100();
        List<ModThread> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            ModThread modThread = new ModThread(i, monitor);
            list.add(modThread);
        }
        for (ModThread a : list) {
            a.start();
        }
    }

}

class ModThread extends Thread {
    private int modValue;
    private Print1To100 monitor;

    public ModThread(int modValue, Print1To100 monitor) {
        this.modValue = modValue;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        synchronized (monitor) {
            try {
                while (true) {
                    while (monitor.currentTaskValue % 10 != modValue) {
                        monitor.wait();
                    }

                    if (monitor.currentTaskValue == 101) {
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + " : "
                            + monitor.currentTaskValue + " ,");
                    monitor.currentTaskValue = monitor.currentTaskValue + 1;
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}