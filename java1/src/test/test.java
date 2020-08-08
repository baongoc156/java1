package test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class MyTask extends TimerTask {
  @Override
  public void run() {
    System.out.println("Run my Task " + new Date());
  }
}

public class test {

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Timer timer = new Timer();
        timer.schedule(myTask, 0, 1000);
    }

}
