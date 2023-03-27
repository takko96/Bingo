import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
//        ImageIcon img = new ImageIcon("src/img/bingo_bg.png");
//
//        JPanel jPanel = new JPanel() {
//            @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                Graphics2D graphics2D = (Graphics2D) g;
//
//                graphics2D.drawImage(img.getImage(),0,0, null);
//            }
//        };

       // frame.setContentPane(jPanel);

        frame.setSize(1027, 616);
        //frame.setIconImage(img.getImage());

        Karte karte = new Karte();
        frame.add(karte);

//       تصنع button و ترسم عليها اي شكل 2D و نعطوها خصائص جديدة زي ما نبوا
//        JFrame frame = new JFrame();
//
//        frame.add(new JButton(){
//            @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                Graphics2D graphics2D = (Graphics2D) g;
//
//                graphics2D.setColor(Color.CYAN);
//                graphics2D.fillOval(0, 0, getWidth(), getHeight());
//            }
//        });
        frame.setVisible(true);
    }
}