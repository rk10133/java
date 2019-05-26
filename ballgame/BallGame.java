import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame {
    Image ball = Toolkit.getDefaultToolkit().getImage("img/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("img/desk.jpg");

    double x = 100;
    double y = 100;

    double degree = 3.14 / 3;

    public void paint(Graphics g) {
        g.drawImage(desk, 0, 0, null);
        g.drawImage(ball, (int) x, (int) y, null);

        x = x + 10 * Math.cos(degree);
        y = y + 10 * Math.sin(degree);

        // 判断小球是否超过下边||上边
        // 下边 窗口宽度 - 边框宽度 - 小球宽度
        // 上边 边框宽度 + 标题栏宽度
        if (y > 500 - 40 - 30 || y < 40 + 40) {
            degree = -degree;
        }

        // 判断小球是否超过左边||右边
        // 左边 边框宽度
        // 右边 窗口宽度 - 边框宽度 - 小球宽度
        if (x < 40 || x > 856 - 40 - 30) {
            degree = 3.14 - degree;
        }
    }

    // 窗口加载
    void launchFrame() {
        // 窗口的宽和高
        setSize(856, 500);
        // 窗口左上角的坐标
        setLocation(300, 300);
        setVisible(true);

        // 窗口每秒重画25次
        while (true) {
            repaint();
            try {
                Thread.sleep(40);// 40ms 1000ms / 40ms = 25次
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("ballgame");
        BallGame game = new BallGame();
        game.launchFrame();
    }
}
