package Java01_初级;

import javax.swing.*;
import java.awt.event.*;


public class 恶搞玩笑 extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final int w = 400,h=400;
    //imagePath为图片的路径
    public static String imagePath = "D:\\Item\\joke\\src\\3.png";


    public 恶搞玩笑(String name) {
        setTitle(name);											//设置窗口标题
        setSize(w, h);										//设置窗口大小
        setLocationRelativeTo(null);							//设置窗口位置居中
        setResizable(false);									//设置窗口大小不可改变
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {					//给窗口叉号（关闭）增加监听事件
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null,"关闭窗口也改变不了刘瑞华是小猪猪的事实");
            }
        });
        TrickPeopleView trickPeopleView = new TrickPeopleView();//创建面板对象
        add(trickPeopleView);									//将面板添加到窗口上
        setVisible(true);										//设置窗口可见
    }

    /**
     * 功能:内部类，自定义面板及相应组件的添加
     */
    public class TrickPeopleView extends JLayeredPane {

        private static final long serialVersionUID = 1L;

        private boolean flag = false;
        private int count = 1;

        public TrickPeopleView() {
            setSize(w, h);
            setFocusable(true);
            setDoubleBuffered(true);
            //添加label标签
            JLabel label = new JLabel();
            Icon icon = new ImageIcon(imagePath);
            label.setIcon(icon);
            label.setSize(w,h);
            label.setLocation(0, 0);
            add(label, new Integer(0));
            //添加两个按钮
            JButton YES = new JButton("是的");
            YES.setBounds(80, 160, 60, 30);
            YES.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            JButton NO = new JButton("不是");
            NO.setBounds(240, 160, 60, 30);
            NO.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    if (count%5 != 0) {
                        YES.setLocation(80, 160);
                        NO.setLocation(240, 160);
                        repaint();
                        if (flag) {
                            flag = false;
                            NO.setLocation(240, 160);
                            repaint();
                            count++;
                        }else {
                            flag = true;
                            NO.setLocation(240, 100);
                            repaint();
                        }
                    }else {
                        count = 1;
                        YES.setLocation(240, 160);
                        NO.setLocation(80, 160);
                        repaint();
                        flag = true;
                    }
                }
            });
            add(YES, new Integer(1));
            add(NO, new Integer(1));
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new 恶搞玩笑("这里提问");
    }
}


