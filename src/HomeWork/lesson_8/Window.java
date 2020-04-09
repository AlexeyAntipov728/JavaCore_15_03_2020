package HomeWork.lesson_8;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public ImageIcon imageX = new ImageIcon("src/HomeWork/lesson_8/X.jpg");
    private ImageIcon imageO = new ImageIcon("src/HomeWork/lesson_8/О.jpg");
    private ImageIcon imageEmpty = new ImageIcon("src/HomeWork/lesson_8/Empty.jpg");
    public int cnt = 0;

    public Window() {

        setTitle("Крестини - Нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 340);
        setLocation(700, 300);

        JPanel panelInfo = new JPanel(new BorderLayout(40, 300));
        JLabel score = new JLabel("Score: " + cnt);
        add(score, BorderLayout.NORTH);
        add(panelInfo);

        JPanel panel = new JPanel(new GridLayout(3, 3));
        JButton[][] buttons = new JButton[3][3];
        System.out.println(imageX);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                buttons[i][j] = new JButton();
                buttons[i][j].setIcon(imageEmpty);
                JButton copy = buttons[i][j];

                copy.addActionListener(action -> {
                    copy.setIcon(imageX);

                    copy.setEnabled(false);

                    copy.setDisabledIcon(imageX);
                        if(isEmpty(buttons)){
                            System.out.println("Ничья");
                        }
                        if(isVictory(buttons)) {
                            System.out.println("WIN WIN WIN WIN");


                            JFrame alert = new JFrame("Победил Х");
                            alert.setLocation(500, 400);
                            alert.setSize(300, 100);
                            JPanel alertPanel = new JPanel(new FlowLayout());
                            JButton newGame = new JButton("Новая игра");
                            newGame.addActionListener(a -> {
                                this.dispose();
                                new Window();
                                cnt++;
                                alert.dispose();
                            });
                            JButton close = new JButton("Закрыть");
                            close.addActionListener(a -> {
                                dispose();
                                alert.dispose();
                            });
                            alertPanel.add(newGame);
                            alertPanel.add(close);
                            alert.add(alertPanel);
                            alert.setResizable(false);
                            alert.setVisible(true);
                        }
                    movePC(buttons);
                });
                panel.add(buttons[i][j]);
            }
        }
        add(panel);
        setVisible(true);
    }


    private boolean isEmpty(@NotNull JButton [][] buttons) {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                if (buttons[i][j].isEnabled())
                return false;
            }
        }
        return true;
    }


    public boolean isVictory(JButton [][] buttons) {

        // Счетчик комбинаций по строке
        int countRow = 0;
        // Счетчик комбинаций по столбцу
        int countColumn = 0;
        // Счетчик комбинаций по первой диагонали
        int countDiagonal1 = 0;
        // Счетчик комбинаций по второй диагонали
        int countDiagonal2 = 0;
        // Проверка по строкам и столбцам
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                if (buttons[i][j].getIcon() == imageX) countRow++;
                if (buttons[j][i].getIcon() == imageX) countColumn++;
            }
            if (countRow == 3 || countColumn == 3) {
                return true;
            }
            countRow = 0;
            countColumn = 0;
        }
        // Проверка по первой диагонали
        for (int i = 0, j = 0; i < buttons.length; i++) {
            if (buttons[i][j].getIcon() == imageX) countDiagonal1++;
            j++;
        }
        if (countDiagonal1 == 3) {
            return true;
        }
        // Проверка по второй диагонали
        for (int i = 0, j = 2; i < buttons.length; i++) {
            if (buttons[i][j].getIcon() == imageX) countDiagonal2++;
            j--;
        }
        if (countDiagonal2 == 3) {
            return true;
        }
        return false;

    }

    private void movePC(JButton[][] buttons) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].isEnabled()) {
                    buttons[i][j].setIcon(imageO);
                    buttons[i][j].setEnabled(false);
                    buttons[i][j].setDisabledIcon(imageO);

                    cnt++;
                    return;
                }
            }
        }
    }

}
