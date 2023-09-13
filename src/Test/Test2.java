package Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Test2 {
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

        JButton button = new JButton("点击开始骂狗");
        button.setBounds(200,200,200,150);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random r = new Random();
                int index = r.nextInt(3);
                if(index == 1){
                    System.out.println("修勾勾大傻逼QWQ");
                }
                else if(index == 2){
                    System.out.println("修勾勾小傻逼QAQ");
                }
                else{
                    System.out.println("修勾勾嗝屁了QWQ");
                }
            }
        });
        jFrame.getContentPane().add(button);

        jFrame.setVisible(true);
    }
}
