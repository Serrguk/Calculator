import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorEngine implements ActionListener {
    Calculator parent; //ссылка на окно калькулятора
    char selectedAction = ' '; //переменная для арифметических действий
    double currentResult = 0; //переменная, где будет храниться результат действий


    //Конструктор сохраняет ссылку на окно калькулятора
    //в переменной экземпляра класса
    CalculatorEngine(Calculator parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Получаем источник действия(нажатия на кнопку)
        JButton clickedButton = (JButton) e.getSource();
        String displayFieldText = parent.displayField.getText();

        double displayValue = 0;


        //Получаем значение из дисплея калькулятора, если он не пустой
        if (!"".equals(displayFieldText)) {
            displayValue = Double.parseDouble(displayFieldText);
        }
        Object src = e.getSource();
        /*
        Для каждой кнопки арифметического действия -
        запомнить его, сохранить текущее число в переменной
        currentResult и очистить дисплей для ввода нового числа
         */

        if (src == parent.buttonPlus) {
            selectedAction = '+';
            currentResult = displayValue;
            parent.displayField.setText("");
        } else if (src == parent.buttonMinus) {
            selectedAction = '-';
            currentResult = displayValue;
            parent.displayField.setText("");
        } else if (src == parent.buttonDivided) {
            selectedAction = '/';
            currentResult = displayValue;
            parent.displayField.setText("");
        } else if (src == parent.buttonMultiply) {
            selectedAction = '*';
            currentResult = displayValue;
            parent.displayField.setText("");
        } else if (src == parent.buttonEquals) {
            /*
            Если нажата кнопка "=" - совершить арифметическое действие,
            в зависимости от selectedAction, обновить переменную
            currentResult и вернуть результат на дисплей
             */
            if (selectedAction == '+') {
                currentResult += displayValue;
                parent.displayField.setText("" + currentResult);
            } else if (selectedAction == '-') {
                currentResult -= displayValue;
                parent.displayField.setText("" + currentResult);
            } else if (selectedAction == '/') {
                currentResult /= displayValue;
                parent.displayField.setText("" + currentResult);
            } else if (selectedAction == '*') {
                currentResult *= displayValue;
                parent.displayField.setText("" + currentResult);
            } else {
                //Для всех цифровых кнопок - присоединить надпись
                //на кнопке к надписи на дисплее
                String clickedButtonLabel = clickedButton.getText();
                parent.displayField.setText(displayFieldText + clickedButtonLabel);
            }
        }
    }
}
