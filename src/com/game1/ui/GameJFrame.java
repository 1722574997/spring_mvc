package com.game1.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    //创建一个二维数组
    //管理数据，加载图片时根据二维数组进行打乱
    int[][] arr = new int[4][4];

    //此数据用于记录胜利状态的数据
    int[][] win = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };

    //记录空白方块的位置
    int x = 0;
    int y = 0;

    //记录步数
    int step = 0;

    //文件路径
    String path = "D:\\Java\\Puzzle_Game\\image\\image\\animal\\animal3\\";

    //创建菜单栏目下的具体对象
    JMenuItem replayItem = new JMenuItem("重新开始");
    //JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");

    JMenuItem publicItem = new JMenuItem("公众号");

    JMenuItem animal = new JMenuItem("动物");
    JMenuItem sport = new JMenuItem("运动");
    JMenuItem girl = new JMenuItem("美女");
    public GameJFrame(){


        InitJFrame();

        InitJMenuBar();

        //初始化数据（打乱图片）
        InitData();

        //初始化图片
        InitImage();

        //设置界面可视化
        this.setVisible(true);
    }

    private void InitData() {
        //创建一个含有16个元素的一维数组，要求打乱顺序后存入一个二维数组
        int[] tempArr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        //定义随机变量
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }


        for (int i = 0; i < tempArr.length; i++) {
            if(tempArr[i] == 0){
                this.x = i / 4;
                this.y = i % 4;
            }
            arr[i/4][i%4] = tempArr[i];

        }

    }

    //初始化图片
    private void InitImage() {
        //清空所有图片:
        this.getContentPane().removeAll();

        //判断是否胜利
        if(victory()){
            ImageIcon vic = new ImageIcon("D:\\Java\\Puzzle_Game\\image\\image\\win.png");
            JLabel winLabel = new JLabel(vic);
            winLabel.setBounds(203,283,197,73);
            this.getContentPane().add(winLabel);
        }

        //添加步数:
        JLabel stepCount = new JLabel("step:" + step);
        stepCount.setBounds(50,30,130,40);
        this.getContentPane().add(stepCount);

        for(int i = 0; i < 4; i++){
            for(int j = 0 ;j < 4;j++){
                //创建一个图片容器
                //用一个Jlabel管理icon:
                int num = arr[i][j];
                JLabel jLabel = new JLabel(new ImageIcon(path + num + ".jpg"));
                //修改图片的位置:
                jLabel.setBounds(105 * j + 83 ,105 * i + 134,105,105);
                //添加边框:
                jLabel.setBorder(new BevelBorder(0));
                //将JLable添加到JFrame下:
                this.getContentPane().add(jLabel);
            }
        }
        //创建背景图片
        ImageIcon bac = new ImageIcon("D:\\Java\\Puzzle_Game\\image\\image\\background.png");
        JLabel background = new JLabel(bac);
        background.setBounds(40,40,508,560);
        this.getContentPane().add(background);

        //清屏
        this.getContentPane().repaint();
    }

    private void InitJMenuBar() {
        //创建菜单
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单栏目
        JMenu functionMenu = new JMenu("功能");
        JMenu aboutMenu = new JMenu("关于我们");
        JMenu chooseMenu = new JMenu("图片选择");


        functionMenu.add(replayItem);
        //functionMenu.add(reLoginItem);
        functionMenu.add(closeItem);

        aboutMenu.add(publicItem);

        chooseMenu.add(animal);
        chooseMenu.add(girl);
        chooseMenu.add(sport);

        functionMenu.add(chooseMenu);

        replayItem.addActionListener(this);
        //reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        publicItem.addActionListener(this);
        animal.addActionListener(this);
        girl.addActionListener(this);
        sport.addActionListener(this);

        jMenuBar.add(functionMenu);
        jMenuBar.add(aboutMenu);

        //给整个界面设置菜单：
        this.setJMenuBar(jMenuBar);
    }

    private void InitJFrame() {
        this.setSize(608,680);
        //设置标题
        this.setTitle("拼图单机版 v1.0");
        //设置置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置游戏的关闭模式
        this.setDefaultCloseOperation(3);
        //取消默认的居中方式,只有取消了才能按照XY轴的方式添加图片
        this.setLayout(null);

        //给界面添加键盘监听:
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //按住不松时执行的代码
    @Override
    public void keyPressed(KeyEvent e) {
        if(victory()){
            return;
        }
        int code = e.getKeyCode();
        if(code == 65){
            //把界面中的图片全部删除
            this.getContentPane().removeAll();

            //添加完整图片
            ImageIcon img = new ImageIcon(path + "all.jpg");
            JLabel jb = new JLabel(img);
            jb.setBounds(83,134,420,420);
            this.getContentPane().add(jb);

            //添加背景图片a
            ImageIcon img2 = new ImageIcon("D:\\Java\\Puzzle_Game\\image\\image\\background.png");
            JLabel back = new JLabel(img2);
            back.setBounds(40,40,508,560);
            this.getContentPane().add(back);
            //刷新界面
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(victory()){
            return;
        }
        //添加上下左右的按键判断
        //上:38,下:40,左:37,右:39
        int code = e.getKeyCode();
        //System.out.println(code);
        if(code == 37){
            //System.out.println("向左移动");
            if(y == 3){
                return;
            }
            arr[x][y] = arr[x][y+1];
            arr[x][y+1] = 0;
            y++;
            step++;
            this.InitImage();

        }else if(code == 38){
            //System.out.println("向上移动");
            if(x == 3){
                return;
            }
            arr[x][y] = arr[x + 1][y];
            arr[x + 1][y] = 0;
            x++;
            step++;
            this.InitImage();

        }else if(code == 39){
            //System.out.println("向右移动");
            if(y == 0){
                return;
            }
            arr[x][y] = arr[x][y - 1];
            arr[x][y - 1] = 0;
            y--;
            step++;
            this.InitImage();

        }else if(code == 40){
            //System.out.println("向下移动");
            if(x == 0){
                return;
            }
            arr[x][y] = arr[x - 1][y];
            arr[x - 1][y] = 0;
            x--;
            step++;
            this.InitImage();

        }else if(code == 65){
            InitImage();
        }else if(code == 87){
            arr = new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
            InitImage();
        }
    }

    public boolean victory(){
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0;j < arr[i].length;j++){
                if(arr[i][j] != win[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == replayItem){
            System.out.println("重新游戏");

            //步数清零:
            step = 0;
            //再次打乱图片:1.打乱数组;2.初始化图片
            InitData();
            InitImage();

        }else if(obj == closeItem){
            System.out.println("关闭游戏");
            System.exit(0);
        }else if(obj == publicItem){
            System.out.println("公众号");

            JDialog jDialog = new JDialog();
            ImageIcon img = new ImageIcon("D:\\Java\\Puzzle_Game\\image\\image\\about.png");
            JLabel jLabel = new JLabel(img);
            jLabel.setBounds(0,0,258,258);
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(344,344);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            //弹框不关闭则无法进行后续操作:
            jDialog.setModal(true);
            jDialog.setVisible(true);
        }else if(obj == animal){
            System.out.println("动物");
            Random r = new Random();
            int ran = r.nextInt(8);
            while(ran == 0){
                ran = r.nextInt(8);
            }
            path = "D:\\Java\\Puzzle_Game\\image\\image\\animal\\animal" + ran + "\\";
            InitData();
            InitImage();

        }else if(obj == girl){
            System.out.println("美女");
            Random r = new Random();
            int ran = r.nextInt(13);
            while(ran == 0){
                ran = r.nextInt(13);
            }
            path = "D:\\Java\\Puzzle_Game\\image\\image\\girl\\girl" + ran + "\\";
            InitData();
            InitImage();
        }else if(obj == sport){
            System.out.println("运动");
            Random r = new Random();
            int ran = r.nextInt(10);
            while(ran == 0){
                ran = r.nextInt(10);
            }
            path = "D:\\Java\\Puzzle_Game\\image\\image\\sport\\sport" + ran + "\\";
            InitData();
            InitImage();
        }
    }
}
