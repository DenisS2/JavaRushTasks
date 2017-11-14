package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * Created by Shurik on 27.03.2017.
 */
public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();;


    public static void main(String[] args) {
        //OrderManager orderManager= new OrderManager();
        //Tablet tablet = new Tablet(5);
        Cook cook1 = new Cook("Amigo");
        cook1.setQueue(orderQueue);
        Cook cook2 = new Cook("Chuck");
        cook2.setQueue(orderQueue);

        //StatisticManager.getInstance().register(cook1);
        //StatisticManager.getInstance().register(cook2);


        Waiter waiter = new Waiter();

        cook1.run();
        cook2.run();

        List<Tablet> tablets = new ArrayList<Tablet>();
        for(int i=0; i<5; i++) {
            Tablet tablet = new Tablet(i+1);
            tablet.setQueue(orderQueue);
            //tablet.addObserver(orderManager);
            //tablet.addObserver(cook2);
            tablets.add(tablet);
        }


        Thread task = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        task.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException nothing) {

        }
        task.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();

        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
