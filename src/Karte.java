import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Karte extends JPanel{


    private final ImageIcon img;

    public Karte(){

        setBorder(BorderFactory.createLineBorder(Color.RED, 4));

        //Basis der Karte wo alle Komponenten rain kommen werden.

        img = new ImageIcon("src/img/bingo_bg.png");

        setLayout(new BorderLayout());


        //Bingo Title-Behalter
        JPanel titleContainer = getjPanel();
        titleContainer.setOpaque(false);
        add(titleContainer, BorderLayout.NORTH);


        add(getBINGO(), BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

        graphics2D.drawImage(img.getImage(),0,0, null);
    }
    private static JPanel getjPanel() {
        JPanel titleContainer = new JPanel();
        titleContainer.setLayout(new FlowLayout(1, 80, 5));
        JLabel b = new JLabel("B");
        JLabel i = new JLabel("I");
        JLabel n = new JLabel("N");
        JLabel g = new JLabel("G");
        JLabel o = new JLabel("O");
        b.setFont(new Font("Times New Roman", Font.BOLD, 48));
        i.setFont(new Font("Times New Roman", Font.BOLD, 48));
        n.setFont(new Font("Times New Roman", Font.BOLD, 48));
        g.setFont(new Font("Times New Roman", Font.BOLD, 48));
        o.setFont(new Font("Times New Roman", Font.BOLD, 48));
        titleContainer.add(b);
        titleContainer.add(i);
        titleContainer.add(n);
        titleContainer.add(g);
        titleContainer.add(o);

        return titleContainer;
    }
    private static JPanel getBINGO() {
        JPanel container = new JPanel(new GridLayout(1,5 ));
        container.setOpaque(false);
        container.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));

        JPanel b = createPanel(Color.CYAN);
        JPanel i = createPanel(Color.RED);
        JPanel n = createPanel(Color.BLACK);
        JPanel g = createPanel(Color.YELLOW);
        JPanel o = createPanel(Color.PINK);
        container.add(b);
        container.add(i);
        container.add(n);
        container.add(g);
        container.add(o);
        return container;
    }

    private static JPanel createPanel(Color farbe) {
        JPanel b = new JPanel();
        //b.setBorder(new LineBorder(Color.BLACK, 4));
        b.setOpaque(false);
        b.setLayout(new GridLayout(5, 1));
        for (int i = 0; i <= 4; i++) {
            b.add(new JButton() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D graphics2D = (Graphics2D) g;

                    graphics2D.setColor(farbe);
                    graphics2D.fillOval(0, 0, getWidth(), getHeight());
                }

            });
        }
        return b;
    }

}