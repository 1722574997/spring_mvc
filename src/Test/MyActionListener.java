package Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyActionListener {
    public static void main(String[] args) {
        String code = "";

        JFrame jFrame = new JFrame();
        jFrame.setSize(608,680);
        //设置标题
        jFrame.setTitle("骂狗 v1.0");
        //设置置顶
        jFrame.setAlwaysOnTop(true);
        //设置界面居中
        jFrame.setLocationRelativeTo(null);
        //设置游戏的关闭模式
        jFrame.setDefaultCloseOperation(3);
        //取消默认的居中方式,只有取消了才能按照XY轴的方式添加图片
        jFrame.setLayout(null);



        JTextField jtf1 = new JTextField();
        jtf1.setBounds(100,100,200,30);
        jtf1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                Object o = e.getKeyChar();

                System.out.println(code);
            }
        });

        jFrame.getContentPane().add(jtf1);

        jFrame.setVisible(true);

    }
}
