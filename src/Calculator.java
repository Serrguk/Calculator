import javax.swing.*;
import java.awt.*;

public class Calculator {
    // В полях класса объявляем все компоненты калькулятора
    JPanel windowsContent;
    JTextField displayField;
    JButton button0;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;
    JButton buttonPoint;
    JButton buttonEquals;

    JPanel pl;

    // В конструкторе инициализируем все поля соответствующими объектами
    // и добавляем на фрейм (окно) с помощью комбинации
    //BorderLayout и GridLayout
    Calculator() {
        // Инициализируем панель...
         windowsContent = new JPanel();

         // ...и создаём для неё схему
        BorderLayout bl = new BorderLayout();
        windowsContent.setLayout(bl);

        //Создаём и отображаем поле
        //И помещаем его в Северную область окна
        displayField = new JTextField(30);
        windowsContent.add("North", displayField);

        //Создаём кнопки, используя конструктор класса JButton,
        // который принимает текст кнопки в качестве аргумента
        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonPoint = new JButton(".");
        buttonEquals = new JButton("=");

        //Создаём панель с GridLayout (панель сеткой) размером 4х3,
        // которая содержит 12 кнопок -
        //10 кнопок с цифрами и кнопки с точкой и знаком равно.
        pl = new JPanel();
        GridLayout gl = new GridLayout(4, 3);
        pl.setLayout(gl);

        //Добавляем кнопки на панель pl.
        pl.add(button0);
        pl.add(button1);
        pl.add(button2);
        pl.add(button3);
        pl.add(button4);
        pl.add(button5);
        pl.add(button6);
        pl.add(button7);
        pl.add(button8);
        pl.add(button9);
        pl.add(buttonPoint);
        pl.add(buttonEquals);

        //Помещаем панель pl в центральную область окна.
        windowsContent.add("Center", pl);

        // Создаём фрейм и задаём его основную панель.
        JFrame frame = new JFrame("It's fucking plus-minus");
        frame.setContentPane(windowsContent);

        //Делаем размер окна достаточным, чтобы вместить все элементы.
        frame.pack();

        //Делаем окно видимым.
        frame.setVisible(true);
    }
}
