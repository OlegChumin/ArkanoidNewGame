package StructureOfGame;

import javax.swing.*;
import java.awt.*;

public class ClassArkanoid extends JPanel {
    // поля и константы


    public ClassArkanoid() {
        setLayout(null); // нет слоев
        setVisible(true);
        setBackground(Color.BLACK);
    }

    ClassBall ball = new ClassBall(this); // передаем объект ball -> в нашу игру arkanoidGame см.
    // конструктор класса ClassBall public ClassBall(ClassArkanoid arkanoidGame) {this.arkanoidGame = arkanoidGame;}
    ClassBar bar = new ClassBar(this); // добавить правильный конструктор в класс ClassBar
    ClassBricks bricks = new ClassBricks(this); // добавить правильный конструктор в класс ClassBar
    ClassRewards rewards = new ClassRewards(this); // добавить правильный конструктор в класс ClassBar
    ClassLevels levels = new ClassLevels(this); //добавить правильный конструктор в класс ClassBar
    ClassListener listener = new ClassListener(this); // добавить правильный конструктор в класс ClassBar

    public static void main(String[] args) {
        JFrame frame = new JFrame("Arkanoid Game");
        ClassArkanoid arkanoidGame = new ClassArkanoid(); // создаем объект Игру arkanoidGame
        frame.getContentPane().add(arkanoidGame); // добавляем игру в наше окно frame
        frame.setSize(500, 400); // создаем окно с размерами в пикселах
        frame.setVisible(true); // переключаем флаг на видимость true
        frame.setLocationRelativeTo(null); // центрируем окно
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // отрабатываем закрытие окна
        frame.setResizable(false); // запрещаем изменять размер окна
    }

    @Override // аннотация которая контролирует если мы попытаемся изменить сигнатуру методы
    public void paint(Graphics g) { // сигнатуру переопределяемого Override метода менять нельзя
        super.paint(g); // вызов метода родительского класса JPanel библиотеки SWING
        Graphics2D graphics2D = (Graphics2D) g; // сделать Override paint метода SWING во классах игры
        // ClassBar, ClassBall, ClassRewards, ClassBricks, ClassText
//        float graphics1D = 10.45F;
//        int graphics2DInt = (int) graphics1D;// значение будет 10 (дробная часть будет осечена) downCasting
    }
}
