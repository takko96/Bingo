import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();


        frame.setSize(1027, 616);

        Karte karte = new Karte();
        frame.add(karte);


        frame.setVisible(true);
    }
}