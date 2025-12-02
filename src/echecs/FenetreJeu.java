package echecs;

import javax.swing.JFrame;

import java.awt.Dimension;

import javax.swing.JPanel;

import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class FenetreJeu extends JFrame {
    private Echiquier e;        //echiquier
    private JLabel[][] tab;     //tableau de JLabels

    private JPanel panelControle = new JPanel();    // panel du haut
    private JPanel panelGrille = new JPanel();      // panel du bas (grille)
    GridLayout gridLayout1 = new GridLayout();

    private JButton boutonDebuter = new JButton();
    private JTextField champTexte = new JTextField();
    private JButton boutonReset = new JButton();

    private JPanel panelNoir, panelBlanc; // panels qu'on placera les pieces capturées

    public FenetreJeu() {   // constructeur appelle méthode JBInit
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        tab = new JLabel[8][8];   // création du tableau de JLabel
        e = new Echiquier();      // création de l'échiquier

        this.getContentPane().setLayout(null);
        this.setSize(new Dimension(800, 629));
        this.setTitle("Jeu d'Echecs");
        panelControle.setBounds(new Rectangle(5, 10, 550, 45));
        panelControle.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        panelControle.setLayout(null);
        panelGrille.setBounds(new Rectangle(5, 65, 550, 465));
        panelGrille.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        panelGrille.setLayout(gridLayout1);
        gridLayout1.setColumns(8);
        gridLayout1.setRows(8);
        this.getContentPane().add(panelGrille, null);
        panelControle.add(boutonReset, null);
        panelControle.add(champTexte, null);
        panelControle.add(boutonDebuter, null);
        this.getContentPane().add(panelControle, null);
        boutonDebuter.setBounds(new Rectangle(15, 10, 130, 25));
        boutonDebuter.setText("DEBUTER");
        champTexte.setBounds(new Rectangle(160, 10, 215, 25));
        boutonReset.setText("RESET");
        boutonReset.setBounds(new Rectangle(390, 10, 130, 25));

        // les écouteurs (listners)
        GestionnaireEvenement gest = new GestionnaireEvenement();
        boutonDebuter.addMouseListener(gest);
        boutonReset.addMouseListener(gest);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tab[i][j] = new JLabel();    // cr�ation du JLabel
                panelGrille.add(tab[i][j]);  // ajouter au Panel
                tab[i][j].setOpaque(true);
                tab[i][j].setHorizontalAlignment(SwingConstants.CENTER);  // pour que les pieces apparaissent au centre de la case
                tab[i][j].addMouseListener(gest);  // ajouter l'�couteur aux sources

                // 1. attribuer couleur aux JLabels
                if ((i+j) % 2 == 0) {
                    tab[i][j].setBackground(Color.lightGray);
                } else {
                    tab[i][j].setBackground(Color.darkGray);
                }
            }
        }

        //2. deux nouveaux panels pour les pièces capturées
        panelNoir = new JPanel(new FlowLayout());
        panelNoir.setBackground(new Color(5,5,5,160));
        this.getContentPane().add(panelNoir);
        panelNoir.setBounds(new Rectangle(572, 65, 100, 465));
        panelNoir.setBorder(new LineBorder(new Color(0,0, 0), 2, true));

        panelBlanc = new JPanel(new FlowLayout());
        panelBlanc.setBackground(new Color(200,200,200,160));
        this.getContentPane().add(panelBlanc);
        panelBlanc.setBounds(new Rectangle(680, 65, 100, 465));
        panelBlanc.setBorder(new LineBorder(new Color(0,0, 0), 2, true));
    }
    // classe interne privée pour la gestion d'évènements
    private class GestionnaireEvenement extends MouseAdapter {

        Piece pieceTampon;
        ImageIcon iconeTampon;
        int ligneClic;
        int colonneClic;
        Position depart, arrivee;
        Couleur couleurControle = Couleur.BLANC;


        public void mouseReleased(MouseEvent eve) {
            // si on clique sur le bouton débuter
            if (eve.getSource() == boutonDebuter) {
                e.debuter();
                tab[0][0].setIcon(new ImageIcon("Icones\\TN.gif"));
                tab[1][0].setIcon(new ImageIcon("Icones\\CN.gif"));
                tab[2][0].setIcon(new ImageIcon("Icones\\FN.gif"));
                tab[3][0].setIcon(new ImageIcon("Icones\\DN.gif"));
                tab[4][1].setIcon(new ImageIcon("Icones\\RN.gif"));
                tab[5][1].setIcon(new ImageIcon("Icones\\FN.gif"));
                tab[6][1].setIcon(new ImageIcon("Icones\\CN.gif"));
                tab[7][1].setIcon(new ImageIcon("Icones\\TN.gif"));

                tab[0][6].setIcon(new ImageIcon("Icones\\TB.gif"));
                tab[1][6].setIcon(new ImageIcon("Icones\\CB.gif"));
                tab[2][6].setIcon(new ImageIcon("Icones\\FB.gif"));
                tab[3][6].setIcon(new ImageIcon("Icones\\DB.gif"));
                tab[4][7].setIcon(new ImageIcon("Icones\\RB.gif"));
                tab[5][7].setIcon(new ImageIcon("Icones\\FB.gif"));
                tab[6][7].setIcon(new ImageIcon("Icones\\CB.gif"));
                tab[7][7].setIcon(new ImageIcon("Icones\\TN.gif"));





                // 3.quoi faire ?
                // attribuer les icones aux JLabels
                champTexte.setText("C'est aux " + couleurControle.toString().toLowerCase() + "s à jouer ");

            }

            // si on clique sur le bouton reset
            else if (eve.getSource() == boutonReset) {
                System.out.println("Bouton reset");
                //4. votre travail
            } else { // donc on a cliqué sur un JLabel
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (eve.getSource() == tab[i][j]) {
                            ligneClic = i;
                            colonneClic = j;
                            System.out.println("clic (" + i + "," + j + ")");
                        }
                    }
                }
                //5. votre travail

            } // du grand else

        } // de la méthode mouseReleased

    } // de la classe de gestion


    // main pour pouvoir exécuter l'interface graphique
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FenetreJeu frame = new FenetreJeu();
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}