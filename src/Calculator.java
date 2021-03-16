import javax.swing.*;
import java.awt.*;

public class Calculator {
    // В полях класса объявляем все компоненты калькулятора
    JPanel windowsContent;
    JTextField displayField;
    JButton[] numButtons = new JButton[10];

    JButton buttonPlus;
    JButton buttonMinus;
    JButton buttonDivided;
    JButton buttonMultiply;
    JButton buttonPoint;
    JButton buttonEquals;

    JPanel p1;
    JPanel p2;

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
        for (int i = 0; i < numButtons.length; i++) {
            String s = String.valueOf(i);
            numButtons[i] = new JButton(s);
        }

        buttonPlus = new JButton("+");
        buttonMinus = new JButton("-");
        buttonDivided = new JButton("/");
        buttonMultiply = new JButton("*");
        buttonPoint = new JButton(".");
        buttonEquals = new JButton("=");

        //Создаём панель с GridLayout (панель сеткой) размером 4х3,
        // которая содержит 12 кнопок -
        //10 кнопок с цифрами и кнопки с точкой и знаком равно.
        p1 = new JPanel();
        GridLayout gl = new GridLayout(4, 3, 5, 5);
        p1.setLayout(gl);

        p2 = new JPanel();
        GridLayout g2 = new GridLayout(4, 1, 5, 5);
        p2.setLayout(g2);

        //Добавляем кнопки на панель pl.

        for (JButton numButton : numButtons) {
            p1.add(numButton);
        }
        p1.add(buttonPoint);
        p1.add(buttonEquals);

        p2.add(buttonPlus);
        p2.add(buttonMinus);
        p2.add(buttonMultiply);
        p2.add(buttonDivided);

        //Помещаем панель p1 в центральную область окна, а p2 - в восточную.
        windowsContent.add("Center", p1);
        windowsContent.add("East", p2);

        // Создаём фрейм(в параметрах пишем название) и задаём его основную панель.
        JFrame frame = new JFrame("It's fucking plus-minus");
        frame.setContentPane(windowsContent);

        //Делаем размер окна достаточным, чтобы вместить все элементы.
        frame.pack();

        //Делаем окно видимым.
        frame.setVisible(true);

        CalculatorEngine calcEngine = new CalculatorEngine(this);

        numButtons[0].addActionListener(calcEngine);
        numButtons[1].addActionListener(calcEngine);
        numButtons[2].addActionListener(calcEngine);
        numButtons[3].addActionListener(calcEngine);
        numButtons[4].addActionListener(calcEngine);
        numButtons[5].addActionListener(calcEngine);
        numButtons[6].addActionListener(calcEngine);
        numButtons[7].addActionListener(calcEngine);
        numButtons[8].addActionListener(calcEngine);
        numButtons[9].addActionListener(calcEngine);

        buttonPoint.addActionListener(calcEngine);
        buttonEquals.addActionListener(calcEngine);
        buttonPlus.addActionListener(calcEngine);
        buttonMinus.addActionListener(calcEngine);
        buttonMultiply.addActionListener(calcEngine);
        buttonDivided.addActionListener(calcEngine);
    }
}
