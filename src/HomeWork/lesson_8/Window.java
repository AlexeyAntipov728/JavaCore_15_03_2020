package HomeWork.lesson_8;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private ImageIcon imageX = new ImageIcon("src/HomeWork/lesson_8/X.jpg");
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


            for (int i = 0; i < buttons.length; i++) {
                for (int j = 0; j < buttons.length; j++) {
                    buttons[i][j] = new JButton();
                    buttons[i][j].setIcon(imageEmpty);
                    panel.add(buttons[i][j]);

                    JButton copy = buttons[i][j];
                    copy.addActionListener(action -> {
                        copy.setIcon(imageX);
                        copy.setEnabled(false);
                        copy.setDisabledIcon(imageX);

                        movePC(buttons);

                        if (isVictory(buttons, copy)) {
                            cnt++;

                            System.out.println("Победа"); // может хоть в консоль выведет, но нет

                            JFrame alert = new JFrame("Вы победили");
                            alert.setLocation(500, 400);
                            alert.setSize(300, 100);
                            JPanel alertPanel = new JPanel(new FlowLayout());
                            alert.add(alertPanel);
                            alert.setResizable(false);
                            alert.setVisible(true);



                        }

                        if (isEmpty(buttons)) {
                            JFrame alert = new JFrame("Ничья");
                            alert.setLocation(500, 400);
                            alert.setSize(300, 100);

                        }
                });
                panel.add(buttons[i][j]);

                }
            }
            add(panel);
            setVisible(true);





    }

    public void movePC(JButton[][] buttons) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
               JButton pc = buttons[i][j];

                if (pc.isEnabled()) {

                    pc.setIcon(imageO);
                    pc.setEnabled(false);
                    pc.setDisabledIcon(imageO);

                    return;
                }
            }
        }
    }

    private boolean isEmpty(JButton[][] buttons) {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                if (buttons[i][j].isEnabled())
                return false;
            }
        }
        return true;
    }


    public boolean isVictory(@NotNull JButton[][] buttons, JButton copy) {
        //Проверка линий по диагоналям
        boolean rightDiagonal, leftDiagonal;
        rightDiagonal = true;
        leftDiagonal = true;
        for (int i = 0; i < buttons.length; i++) {
            rightDiagonal &= (buttons[i][i] == copy(imageX));
            leftDiagonal &= (buttons[buttons.length - i - 1][i] == copy(imageX));
        }

        if (rightDiagonal || leftDiagonal)
            return true;
        //Проверка столбцов и строк
        boolean columns, lines;
        for (int col = 0; col < buttons.length; col++) {
            columns = true;
            lines = true;
            for (int lin = 0; lin < buttons.length; lin++) {
                columns &= (buttons[col][lin] == copy(imageX));
                lines &= (buttons[lin][col] == copy(imageX));
            }

            if (columns || lines)
                return true;
        }

        return false;
    }

    private JButton copy(ImageIcon imageX) {
        return null;
    }


}
