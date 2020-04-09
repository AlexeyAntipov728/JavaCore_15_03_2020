package HomeWork.lesson_8;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public static int cnt = 0;
    public ImageIcon imageX = new ImageIcon("src/HomeWork/lesson_8/X.jpg");
    private ImageIcon imageO = new ImageIcon("src/HomeWork/lesson_8/О.jpg");
    private ImageIcon imageEmpty = new ImageIcon("src/HomeWork/lesson_8/Empty.jpg");

    public Window() {

        setTitle("Крестики - Нолики");
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
                    if (isEmpty(buttons)) {
//                        System.out.println("Ничья");

                        JFrame alert = new JFrame("Ничья");
                        alert.setLocation(700, 400);
                        alert.setSize(300, 100);
                        JPanel alertPanel = new JPanel(new FlowLayout());
                        JButton newGame = new JButton("Новая игра");
                        newGame.addActionListener(a -> {
                            this.dispose();
                            new Window();
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

                    if (isVictory(buttons, imageX)) {
//                        System.out.println("WIN WIN WIN WIN");
                        cnt++;
                        for (int k = 0; k < buttons.length; k++) {
                            for (int l = 0; l < buttons.length; l++) {
                                buttons[k][l].setEnabled(false);
                            }
                        }
//                        System.out.println("Побед" + cnt);

                        JFrame alert = new JFrame("Победил Х");
                        alert.setLocation(700, 400);
                        alert.setSize(300, 100);
                        JPanel alertPanel = new JPanel(new FlowLayout());
                        JButton newGame = new JButton("Новая игра");
                        newGame.addActionListener(a -> {
                            this.dispose();
                            new Window();
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

                    if (isVictory(buttons, imageO)) {
//                        System.out.println("Sad");
                        for (int k = 0; k < buttons.length; k++) {
                            for (int l = 0; l < buttons.length; l++) {
                                buttons[k][l].setEnabled(false);
                            }
                        }

                        JFrame alert = new JFrame("Победил O");

                        alert.setLocation(700, 400);
                        alert.setSize(300, 100);
                        JPanel alertPanel = new JPanel(new FlowLayout());
                        JButton newGame = new JButton("Новая игра");
                        newGame.addActionListener(a -> {
                            this.dispose();
                            new Window();
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

                    if (isEmpty(buttons)) {
//                        System.out.println("Ничья");
                    }
                    if (isVictory(buttons, imageX)) {
//                        System.out.println("WIN WIN WIN WIN");

                        for (int k = 0; k < buttons.length; k++) {
                            for (int l = 0; l < buttons.length; l++) {
                                buttons[k][l].setEnabled(false);
                            }
                        }
//                        System.out.println("Побед" + cnt);

                        JFrame alert = new JFrame("Победил Х");
                        alert.setLocation(700, 400);
                        alert.setSize(300, 100);
                        JPanel alertPanel = new JPanel(new FlowLayout());
                        JButton newGame = new JButton("Новая игра");
                        newGame.addActionListener(a -> {
                            this.dispose();
                            new Window();
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

                    if (isVictory(buttons, imageO)) {
//                        System.out.println("Sad");
                        for (int k = 0; k < buttons.length; k++) {
                            for (int l = 0; l < buttons.length; l++) {
                                buttons[k][l].setEnabled(false);
                            }
                        }

                        JFrame alert = new JFrame("Победил O");
                        alert.setLocation(500, 400);
                        alert.setSize(300, 100);
                        JPanel alertPanel = new JPanel(new FlowLayout());
                        JButton newGame = new JButton("Новая игра");
                        newGame.addActionListener(a -> {
                            this.dispose();
                            new Window();
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

                });
                panel.add(buttons[i][j]);
            }
        }
        add(panel);
        setVisible(true);
    }

    private boolean isEmpty(@NotNull JButton[][] buttons) {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                if (buttons[i][j].isEnabled())
                    return false;
            }
        }
        return true;
    }

    private void movePC(JButton[][] buttons) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].isEnabled()) {
                    buttons[i][j].setIcon(imageO);
                    buttons[i][j].setEnabled(false);
                    buttons[i][j].setDisabledIcon(imageO);
                    return;
                }
            }
        }
    }

    private boolean isVictory(@NotNull JButton[][] buttons, ImageIcon imageX) {
        //Проверка линий по диагоналям
        boolean rightDiagonal, leftDiagonal;
        rightDiagonal = true;
        leftDiagonal = true;
        for (int i = 0; i < buttons.length; i++) {
            rightDiagonal &= (buttons[i][i].getIcon() == imageX);
            leftDiagonal &= (buttons[buttons.length - i - 1][i].getIcon() == imageX);
        }

        if (rightDiagonal || leftDiagonal)
            return true;
        //Проверка столбцов и строк
        boolean columns, lines;
        for (int col = 0; col < buttons.length; col++) {
            columns = true;
            lines = true;
            for (int lin = 0; lin < buttons.length; lin++) {
                columns &= (buttons[col][lin].getIcon() == imageX);
                lines &= (buttons[lin][col].getIcon() == imageX);
            }
            if (columns || lines)
                return true;
        }
        return false;
    }

}
