package com.banana.textgame;

import java.util.Scanner;

public class Main {

    /*
     * Главный метод. ?????
     */
    public static void main(String[] args) {
        // вызывает метод start()
        new Main().start();
    }

    /*
     * Метод с логикой игры.
     */
    private void start() {
        onStart();
        for (int i = 1; i <= 5; ++i) {
            onNewDay(i);
        }
        onFinish();
    }

    /*
     * Метод вызывается один раз при старте игры.
     */
    void onStart() {
      System.out.println("Привет.");
        Scanner клавиатура = new Scanner (System.in);
        System.out.println("Сколько тебе лет?");
        int возраст = Integer.parseInt(клавиатура.nextLine());
        System.out.println("Вoзраст:" + возраст);
        System.out.println("Как тебя зовут?");
        String имя = клавиатура.nextLine();

    }

    /*
     * Метод вызывается каждый игровый день.
     * Единственный параметр: dayNumber - номер текущего игрового дня.
     */
    void onNewDay(int dayNumber) {
        System.out.println("День" + dayNumber);
    }

    /*
     * Метод вызывается по завершению игры.
     */
    void onFinish() {
        System.out.println("Пока.");
    }

}