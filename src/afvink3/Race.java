package afvink3;
/**
 * Race class
 * Class Race maakt gebruik van de class Paard
 * 
 * @author Martijn van der Bruggen
 * @version alpha - aanroep van cruciale methodes ontbreekt
 * (c) 2009 Hogeschool van Arnhem en Nijmegen
 * 
 * Note: deze code is bewust niet op alle punten generiek
 * dit om nog onbekende constructies te vermijden.
 *
 * Updates
 * 2010: verduidelijking van opdrachten in de code MvdB
 * 2011: verbetering leesbaarheid code MvdB
 * 2012: verbetering layout code en aanpassing commentaar MvdB
 * 2013: commentaar aangepast aan nieuwe opdracht MvdB
 * 
 *************************************************
 * Afvinkopdracht: werken met methodes en objecten
 *************************************************
 * Opdrachten zitten verwerkt in de code
 * 1) Declaratie constante
 * 2) Declaratie van Paard (niet instantiering)
 * 3) Declareer een button
 * 4) Zet breedte en hoogte van het frame
 * 5) Teken een finish streep
 * 6) Creatie van 4 paarden
 * 7) Pauzeer
 * 8) Teken 4 paarden
 * 9) Plaats tekst op de button
 * 10) Start de race, methode aanroep
 *
 *
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Race extends JFrame implements ActionListener {

    /** declaratie van variabelen */
    int lengte=250;
    
    private Paard h1;
    private Paard h2;
    private Paard h3;
    private Paard h4; 
    private Paard h5;
    
    private JButton button; 
    private JPanel panel;

    /** Applicatie - main functie voor runnen applicatie
     * @param args */
    public static void main(String[] args) {
        Race frame = new Race();
        /* (4) Geef het frame een breedte van 400 en hoogte van 140 */
        frame.createGUI();
        frame.setVisible(true);
        frame.setSize (400,200);
    }

    /** Loop de race
     */
    private void startRace(Graphics g) {
        panel.setBackground(Color.white);
        /** Tekenen van de finish streep */ 
        
        g.setColor(Color.red);
        g.fillRect(lengte, 0, 3, 100);
        
      
        Paard h1 = new Paard ("Magic", Color.pink);
        Paard h2 = new Paard ("Estevana", Color.magenta);
        Paard h3 = new Paard ("Koe", Color.BLUE); 
        Paard h4 = new Paard ("Match", Color.cyan);
        Paard h5 = new Paard ("Amika", Color.green);
        
        /** Loop tot een paard over de finish is*/
        while (h1.getAfstand() < lengte
                && h2.getAfstand() < lengte
                && h3.getAfstand() < lengte
                && h4.getAfstand() < lengte
                && h5.getAfstand() < lengte){
            h1.run();
            h2.run();
            h3.run();
            h4.run();
            h5.run();

            
            pauzeer (100);
            
            tekenPaard(g, h1);
            tekenPaard(g, h2);
            tekenPaard(g, h3);
            tekenPaard(g, h4);
            tekenPaard(g, h5);
        
        /** Kijk welk paard gewonnen heeft
         */
        if (h1.getAfstand() > lengte) {
            JOptionPane.showMessageDialog(null, h1.getNaam() + " gewonnen!");
        }
        if (h2.getAfstand() > lengte) {
            JOptionPane.showMessageDialog(null, h2.getNaam() + " gewonnen!");
        }
        if (h3.getAfstand() > lengte) {
            JOptionPane.showMessageDialog(null, h3.getNaam() + " gewonnen!");
        }
        if (h4.getAfstand() > lengte) {
            JOptionPane.showMessageDialog(null, h4.getNaam() + " gewonnen!");
        }  
        if (h5.getAfstand() > lengte) {
            JOptionPane.showMessageDialog(null, h5.getNaam() + " gewonnen!");
        }
    }
 }
    /** Creatie van de GUI*/
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 150));
        panel.setBackground(Color.white);
        window.add(panel);
      
        button = new JButton("Run!");
        window.add(button);
        button.addActionListener(this);
    }

    /** Teken het paard */
    private void tekenPaard(Graphics g, Paard h) {
        g.setColor(h.getKleur());
        g.fillRect(10, 20 * h.getPaardNummer(), h.getAfstand(), 5);
    }

    /** Actie indien de button geklikt is*/
    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        /* (10) Roep hier de methode startrace aan met de juiste parameterisering */
        startRace (paper);
    }

    /** Pauzeer gedurende x millisecondes*/
    public void pauzeer(int msec) {
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            System.out.println("Pauze interruptie");
        }
    }
    
    
}

