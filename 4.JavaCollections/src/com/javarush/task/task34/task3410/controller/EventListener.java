package com.javarush.task.task34.task3410.controller;

import com.javarush.task.task34.task3410.model.Direction;

public interface EventListener {

    public void move(Direction direction);// – передвинуть объект в определенном направлении.
    public void restart();// – начать заново текущий уровень.
    public void startNextLevel();// – начать следующий уровень.
    public void levelCompleted(int level);// – уровень с номером level завершён.
}
