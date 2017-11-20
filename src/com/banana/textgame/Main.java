package com.banana.textgame;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    String[] доступныеЯзыки = {"Java", "Python", "C", "Ada", "JavaScript"};
    Scanner keyboard = new Scanner (System.in);
    User пользователь = new User();


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

        Scanner клавиатура = new Scanner (System.in);
        String[] варианты = {"Привет! Как тебя зовут?", "Привет, твое имя?", "Как дела? Твое имя? "};
        int числоОт0До2 = (int) (Math.random() * варианты.length );
        System.out.println(варианты [числоОт0До2 ]);
        String имя = клавиатура.nextLine();
        System.out.println("Привет," + имя);
        System.out.println("Сколько тебе лет?");
        int возраст = Integer.parseInt(клавиатура.nextLine());
        System.out.println("Вoзраст:" + возраст);

    }

    /*
     * Метод вызывается каждый игровый день.
     * Единственный параметр: dayNumber - номер текущего игрового дня.
     */

    void onNewDay(int dayNumber) {
        System.out.println("День " + dayNumber);
        String smiles = "";
        for (int i = 1; i<= пользователь.mood; i = i + 1) {
            smiles = smiles + "☺";
        }
        System.out.println(" Ваше настроение:" + smiles + ".");
        напечатайИзученныеЯзыки();
        System.out.println("Компании, в которых вы работаете:" + пользователь.компании + ".");

        System.out.println("Что будешь делать?");
        String action = keyboard.nextLine ();
        switch (action) {
            case "кость":
                броситьКость();
                break;
            case"работа":
                найтиРаботу();
                break;
            case "код":
                код();
                break;
            case "увольнение":
                уволиться();
                break;
            case"скакалка":
                System.out.println ("Вы попрыгали на скакалке.");
                пользователь.mood = пользователь.mood + 2;
                break;
            case "кушать":
                скушатьПельмешки();
                break;
            case "изучить":
                изучитьЯзык();
                break;
            default:
                System.out.println("Ошибка.");

        }

    }


    /*
     * Метод вызывается по завершению игры.
     */
    void onFinish() {
        System.out.println ("Вы набрали:" + 87 + "очков");
    }
    void изучитьЯзык() {
        System.out.println("Какой язык?");
        String выбранныйЯзык = keyboard.nextLine();

        for (int i = 0; i < доступныеЯзыки.length; i++) {
            if (доступныеЯзыки[i].equals(выбранныйЯзык)) {
                пользователь.изученныеЯзыки[i] = true;
                пользователь.заработок -= 5;
                пользователь.mood -= 1;
            }
        }
    }
    void напечатайИзученныеЯзыки () {
        for (int i = 0; i < пользователь.изученныеЯзыки.length; i++) {
            if (пользователь.изученныеЯзыки[i] == true) {
                System.out.println("-" + доступныеЯзыки[i]);
            }
        }
    }
    void скушатьПельмешки() {
        boolean данныеВеденныВерно = false;
        while (данныеВеденныВерно == false) {
            System.out.println("Сколько вы хотите съесть?");
            String строка = keyboard.nextLine();
            try {
                int количествоПельмешек = Integer.parseInt(строка);
                скушатьПельмешки(количествоПельмешек);
                данныеВеденныВерно = true;
            } catch (Exception e) {
                System.out.println("Ошибка парсинга.");
            }
        }
    }
    void скушатьПельмешки(int количествоПельмешек) {
        пользователь.заработок = пользователь.заработок - 5 * количествоПельмешек;
        пользователь.mood = + 5 * количествоПельмешек;
    }

//    int очки;
//    int финальныеОчки {
//       int очки = заработок * 2 + mood * 10;
//    }
//
//     if (изученныеЯзыки[i] == true) {
//          очки = очки + 15;
//    }
//   return очки;

    void найтиРаботу(){
        System.out.println("В какой компании вы будите работать?");
        String компания = keyboard.nextLine();
        пользователь.компании.add(компания);
    }

    void уволиться () {
     System.out.println("Из какой компании вы хотите уволиться?");
     String компания = keyboard.nextLine();
        пользователь.компании.remove(компания);
     System.out.println("Компании, в которых вы работаете:" + пользователь.компании + ".");
    }

    void код () {
        System.out.println("Ваш код на сегодня:");
        String код = keyboard.nextLine();
        пользователь.заработок = пользователь.заработок + код.length();
        пользователь.mood = пользователь.mood - 1;
    }

    void броситьКость (){
        int число1 = (int) (Math.random() * 6 + 1);
        int число2 = (int) (Math.random() * 6 + 1);
        System.out.println("Выпали числа:" + число1 + " и " + число2 + ".");
        пользователь.заработок -= 2;
        if ( Math.max(число1, число2) % 2 == 0){
            System.out.println("Вы выиграли!");
            пользователь.заработок += 5;
        }
    }


}
