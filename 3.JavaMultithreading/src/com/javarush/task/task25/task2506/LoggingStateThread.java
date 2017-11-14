package com.javarush.task.task25.task2506;

/**
 * Created by User on 11.06.2017.
 */
public class LoggingStateThread extends Thread {

    private Thread target;
    private State state;

    public LoggingStateThread(Thread target) {
        this.target = target;
        //this.setDaemon(true);
        state=this.target.getState();
        //System.out.println(state.toString());
    }

    @Override
    public void run() {
        System.out.println(state.toString());
       while (state!= State.TERMINATED) {
            State state1=target.getState();
            if (state!=state1) {
                state=state1;
                System.out.println(state);
            }
       }
        this.interrupt();
    }
}
