package Test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Test3 {
    public static void main(String[] args) {
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

        JButton jtb1 = new JButton("click");
        jtb1.setBounds(200,200,100,50);
        jtb1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("傻狗去死吧");
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("修勾勾");
            }
        });
        jFrame.getContentPane().add(jtb1);
        jFrame.setVisible(true);
    }
}
