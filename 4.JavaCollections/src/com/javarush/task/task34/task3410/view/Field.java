package com.javarush.task.task34.task3410.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;

import com.javarush.task.task34.task3410.controller.EventListener;
import com.javarush.task.task34.task3410.model.*;
import com.javarush.task.task34.task3410.model.Box;

import static java.awt.event.KeyEvent.*;


public class Field extends JPanel {

    private View view;
    private EventListener eventListener;

    public Field(View view) {
        this.view = view;
        KeyHandler keyHandler=new KeyHandler();
        addKeyListener(keyHandler);
        setFocusable(true);
    }

    public void setEventListener(EventListener eventListener){
        this.eventListener = eventListener;
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 300, 300);
        Set<GameObject> gameObjectSet = view.getGameObjects().getAll();

        for (GameObject gameObject : gameObjectSet) {
            gameObject.draw(g);
        }
    }

    public class KeyHandler extends KeyAdapter {

        public void keyPressed(KeyEvent e){
            switch (e.getKeyCode()){
                case VK_LEFT:eventListener.move(Direction.LEFT);
                    break;
                case VK_RIGHT:eventListener.move(Direction.RIGHT);
                    break;
                case VK_UP:eventListener.move(Direction.UP);
                    break;
                case VK_DOWN:eventListener.move(Direction.DOWN);
                    break;
                case VK_R:eventListener.restart();
                    break;
            }
        }
    }
}
