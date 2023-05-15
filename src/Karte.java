import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Timer;


public class Karte extends JPanel{


    private final ImageIcon img;

    ArrayList<Integer> ausgezogneZahlen;
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

    //java util timer klasse
            //timer einen Task geben alle x skunden und widerholbar.
            //wenn Bingo gefunden ist und auf Bingo gedrückt ist wird die Schleife abgebruchen und das Spiel beendet


        }




        int[] seconds = {0};

        Timer timer = new Timer();
        ArrayList<Integer> zufaelligeBINGO = erzeugeZufaelligeBINGO();
        JLabel numbers = new JLabel();
        numbers.setBackground(Color.WHITE);
        numbers.setOpaque(true);
        numbers.setSize(70,70);
        numbers.setFont(new Font("Times New Roman", Font.BOLD, 50));
        numbers.setBorder(BorderFactory.createLineBorder(Color.PINK, 5));
        add(numbers, BorderLayout.WEST);

        TimerTask task = new TimerTask() {

            private int MAX_SECONDS = 100;

            @Override
            public void run() {
                if (seconds[0] <= MAX_SECONDS) {
                    System.out.println("Seconds = " + seconds[0]++);

                    int number = zufaelligeBINGO.remove(0);
                    ausgezogneZahlen.add(number); //für später Zum Vergleichen
                    numbers.setText(number + "");
                    numbers.repaint();


                } else {
                    // stop the timer
                    cancel();
                }
            }
        };

        timer.schedule(task, 0, 5000);



        JButton bingo = new JButton("BINGO!");
        add(bingo, BorderLayout.SOUTH);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameOver == true){
                    //überprüfe ob bingo ist vorhanden!

                }
            }
        };
        bingo.addActionListener(actionListener);



        setVisible(true);
    }


    /*_________________________________________________________________________________*/

    //Methode um überprüfen ob ein Bingo vorhanden sind damit gameOver auf True eingesetzt

    public boolean istBingo(){

        /*geht alle Knöpfe durch und wenn es einen mit BG-Farbe findet schmeist es in Liste, dann checkt ob unter oder neben oder diagonal unter
        ihn einen neuen findet, wenn nicht bricht die schleife ab.
         */


        return false;
    }



    /*______________________________________________________________*/

    //حنديروا ليستا فيها كل الارقام من الـ 75 و تعبوها بـ for-loop و بعدين نطلعوا منها الارقام بـshuffle و تستمر لعند تكمل كل اللعبة تنتهي
    //Methode um Zahlen zufällig auszuziehen
    private static ArrayList<Integer> erzeugeZufaelligeBINGO(){

        ArrayList<Integer> result = new ArrayList<>();
        for (int i=1; i<76; i++){
            result.add(i);
        }
        Collections.shuffle(result);
        return result;
    }

    /*_________________________________________________________________________________*/

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
            ActionListener listener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    knopf.setBackground(Color.CYAN);
                    knopf.setOpaque(true);
                }
            };
            knopf.addActionListener(listener);

            //wenn gedrückt bg auf rot dann dies nutzen um später zu überprüfen ob es rot oder nicht und dann mit der ausgezogene zahlen zu vergleichen
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



}