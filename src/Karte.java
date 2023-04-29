import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collector;

public class Karte extends JPanel{


    private final ImageIcon img;
    private boolean gameOver = false;

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

        while(gameOver){

            //حنديروا ليستا فيها كل الارقام من الـ 75 و تعبوها بـ for-loop و بعدين نطلعوا منها الارقام بـshuffle و تستمر لعند تكمل كل اللعبة تنتهي

        }



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
        //strg + shift + m = تصنعلنا ميثودا
        JPanel b = createPanel(1);
        JPanel i = createPanel(16);
        JPanel n = createPanel(31);
        JPanel g = createPanel(46);
        JPanel o = createPanel(61);
        container.add(b);
        container.add(i);
        container.add(n);
        container.add(g);
        container.add(o);
        return container;
    }

    private static JPanel createPanel(int min) {
        JPanel b = new JPanel();
        //b.setBorder(new LineBorder(Color.BLACK, 4));
        b.setOpaque(false);
        b.setLayout(new GridLayout(5, 1));
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> zufaelligeZahlen = erzeugeZufaelligeZahlen(min);
        for (int i = 0; i <= 4; i++) {
            int number = zufaelligeZahlen.remove(0);
            list.add(number);
            JButton knopf = new JButton(number + "");
            b.add(knopf);
        }
        return b;
    }


    //Um Zahlen auf den Buttons zufällig zu schreiben
    private static ArrayList<Integer> erzeugeZufaelligeZahlen(int basisWert){
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0; i<15; i++){
            result.add(basisWert + i);
        }
        Collections.shuffle(result);
        return result;
    }


    //um Zahlen für B-Spalte auszuziehen
    private static ArrayList<Integer> erzeugeZufaelligeB(){

        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0; i<15; i++){
            result.add(Integer.valueOf("B" + i));
        }
        Collections.shuffle(result);
        return result;
    }

    //um Zahlen für I-Spalte auszuziehen
    private static ArrayList<Integer> erzeugeZufaelligeI(){

        ArrayList<Integer> result = new ArrayList<>();
        for (int i=16; i<31; i++){
            result.add(Integer.valueOf("I" + i));
        }
        Collections.shuffle(result);
        return result;
    }

}