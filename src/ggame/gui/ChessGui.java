package ggame.gui;

import chesspresso.move.Move;
import com.googlecode.jctree.NodeNotFoundException;
import ggame.GGame;
import gposition.GCoups;
import gposition.GPosition;
import gposition.generateur.ICodage;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import static gtools.GTools.*;
import start.GStart;

public class ChessGui extends javax.swing.JFrame implements ICodage {

    private static final long serialVersionUID = 1L;
    private final GGame ggame;
    private final ImageIcon roi_blanc;
    private int[] etats;
    private final ImageIcon roi_noir;
    private final ImageIcon pion_blanc;
    private final ImageIcon pion_noir;
    private final ImageIcon tour_blanc;
    private final ImageIcon tour_noir;
    private final ImageIcon cavalier_blanc;
    private final ImageIcon cavalier_noir;
    private final ImageIcon fou_blanc;
    private final ImageIcon fou_noir;
    private final ImageIcon dame_blanc;
    private final ImageIcon dame_noir;
    private final ImageIcon vide;
    private GPosition gp;
    private final Border bord_1_clic = new LineBorder(Color.BLUE, 12);
    private final Border bord_0_clic = new LineBorder(Color.LIGHT_GRAY, 12);
    private boolean first_case = true;
    private JButton jB_first_case;
    private JButton jB_second_case;
    private int caseO;
    private int caseX;
    private int num_coups;
    private boolean backORforward;
    private int num;

    public ChessGui(GGame ggame) {
        this.ggame = ggame;
        initComponents();
        roi_blanc = new ImageIcon("D:\\Documents\\NetbeansProjects\\chess\\imagepiece\\roi_blanc.png");
        roi_noir = new ImageIcon("D:\\Documents\\NetbeansProjects\\chess\\imagepiece\\roi_noir.png");
        pion_blanc = new ImageIcon("D:\\Documents\\NetbeansProjects\\chess\\imagepiece\\pion_blanc.png");
        pion_noir = new ImageIcon("D:\\Documents\\NetbeansProjects\\chess\\imagepiece\\pion_noir.png");
        tour_blanc = new ImageIcon("D:\\Documents\\NetbeansProjects\\chess\\imagepiece\\tour_blanc.png");
        tour_noir = new ImageIcon("D:\\Documents\\NetbeansProjects\\chess\\imagepiece\\tour_noir.png");
        cavalier_blanc = new ImageIcon("D:\\Documents\\NetbeansProjects\\chess\\imagepiece\\cavalier_blanc.png");
        cavalier_noir = new ImageIcon("D:\\Documents\\NetbeansProjects\\chess\\imagepiece\\cavalier_noir.png");
        fou_blanc = new ImageIcon("D:\\Documents\\NetbeansProjects\\chess\\imagepiece\\fou_blanc.png");
        fou_noir = new ImageIcon("D:\\Documents\\NetbeansProjects\\chess\\imagepiece\\fou_noir.png");
        dame_blanc = new ImageIcon("D:\\Documents\\NetbeansProjects\\chess\\imagepiece\\dame_blanc.png");
        dame_noir = new ImageIcon("D:\\Documents\\NetbeansProjects\\chess\\imagepiece\\dame_noir.png");
        vide = new ImageIcon("D:\\Documents\\NetbeansProjects\\chess\\imagepiece\\vide.png");
        setVisible(true);
    }

    protected int typeDePiece(int caseO) {
        return (etats[caseO] < 0) ? -etats[caseO] : etats[caseO];
    }

    protected int couleurPiece(int caseO) {
        return (etats[caseO] < 0) ? BLANC : NOIR;
    }

    protected boolean estVide(int caseX) {
        return etats[caseX] == VIDE;
    }

    public final void setGuiPosition(GPosition gp) {
        this.gp = gp;
        if (!backORforward) {
            ArrayList<String> diff = getTest(gp).getDiffStringList();
            coups_GACLE.setText(GCoups.getString(ggame.getGcoups()) + '\n' + Move.getString(ggame.getCoupsCP()) + '\n'
                    + "Coups ChessPresso:" + "\n"
                    + toStringListCPCoups(gp.getCPCoups()) + '\n'
                    + "Coups GCLE:" + "\n" + toStringListGCoups(gp.getCoupsValides()) + "\n" + "Diff:" + "\n" + diff + "\n");
        } else {
            backORforward = !backORforward;
            coups_GACLE.setText("");
        }
        Icon[] cboard = new ImageIcon[144];
        etats = gp.getEtats();
        for (int _case : CASES) {
            int couleur = couleurPiece(_case);
            int indice = INDICECASES[_case] + 1;
            switch (typeDePiece(_case)) {
                case PION:
                    cboard[indice] = couleur == BLANC ? pion_blanc : pion_noir;
                    break;
                case TOUR:
                    cboard[indice] = couleur == BLANC ? tour_blanc : tour_noir;
                    break;
                case CAVALIER:
                    cboard[indice] = couleur == BLANC ? cavalier_blanc : cavalier_noir;
                    break;
                case FOU:
                    cboard[indice] = couleur == BLANC ? fou_blanc : fou_noir;
                    break;
                case DAME:
                    cboard[indice] = couleur == BLANC ? dame_blanc : dame_noir;
                    break;
                case ROI:
                    cboard[indice] = couleur == BLANC ? roi_blanc : roi_noir;
                    break;
                case VIDE:
                    cboard[indice] = vide;
                    break;

            }

        }

        jButton1.setIcon(cboard[1]);
        jButton2.setIcon(cboard[2]);
        jButton3.setIcon(cboard[3]);
        jButton4.setIcon(cboard[4]);
        jButton5.setIcon(cboard[5]);
        jButton6.setIcon(cboard[6]);
        jButton7.setIcon(cboard[7]);
        jButton8.setIcon(cboard[8]);
        jButton9.setIcon(cboard[9]);
        jButton10.setIcon(cboard[10]);
        jButton11.setIcon(cboard[11]);
        jButton12.setIcon(cboard[12]);
        jButton13.setIcon(cboard[13]);
        jButton14.setIcon(cboard[14]);
        jButton15.setIcon(cboard[15]);
        jButton16.setIcon(cboard[16]);
        jButton17.setIcon(cboard[17]);
        jButton18.setIcon(cboard[18]);
        jButton19.setIcon(cboard[19]);
        jButton20.setIcon(cboard[20]);
        jButton21.setIcon(cboard[21]);
        jButton22.setIcon(cboard[22]);
        jButton23.setIcon(cboard[23]);
        jButton24.setIcon(cboard[24]);
        jButton25.setIcon(cboard[25]);
        jButton26.setIcon(cboard[26]);
        jButton27.setIcon(cboard[27]);
        jButton28.setIcon(cboard[28]);
        jButton29.setIcon(cboard[29]);
        jButton30.setIcon(cboard[30]);
        jButton31.setIcon(cboard[31]);
        jButton32.setIcon(cboard[32]);
        jButton33.setIcon(cboard[33]);
        jButton34.setIcon(cboard[34]);
        jButton35.setIcon(cboard[35]);
        jButton36.setIcon(cboard[36]);
        jButton37.setIcon(cboard[37]);
        jButton38.setIcon(cboard[38]);
        jButton39.setIcon(cboard[39]);
        jButton40.setIcon(cboard[40]);
        jButton41.setIcon(cboard[41]);
        jButton42.setIcon(cboard[42]);
        jButton43.setIcon(cboard[43]);
        jButton44.setIcon(cboard[44]);
        jButton45.setIcon(cboard[45]);
        jButton46.setIcon(cboard[46]);
        jButton47.setIcon(cboard[47]);
        jButton48.setIcon(cboard[48]);
        jButton49.setIcon(cboard[49]);
        jButton50.setIcon(cboard[50]);
        jButton51.setIcon(cboard[51]);
        jButton52.setIcon(cboard[52]);
        jButton53.setIcon(cboard[53]);
        jButton54.setIcon(cboard[54]);
        jButton55.setIcon(cboard[55]);
        jButton56.setIcon(cboard[56]);
        jButton57.setIcon(cboard[57]);
        jButton58.setIcon(cboard[58]);
        jButton59.setIcon(cboard[59]);
        jButton60.setIcon(cboard[60]);
        jButton61.setIcon(cboard[61]);
        jButton62.setIcon(cboard[62]);
        jButton63.setIcon(cboard[63]);
        jButton64.setIcon(cboard[64]);
// ---------------------------------------------------
        Color[] lboard = new Color[65];
        for (int k = 1; k < 65; k++) {
            lboard[k] = Color.LIGHT_GRAY;
        }
        jButton1.setBackground(lboard[1]);
        jButton2.setBackground(lboard[2]);
        jButton3.setBackground(lboard[3]);
        jButton4.setBackground(lboard[4]);
        jButton5.setBackground(lboard[5]);
        jButton6.setBackground(lboard[6]);
        jButton7.setBackground(lboard[7]);
        jButton8.setBackground(lboard[8]);
        jButton9.setBackground(lboard[9]);
        jButton10.setBackground(lboard[10]);
        jButton11.setBackground(lboard[11]);
        jButton12.setBackground(lboard[12]);
        jButton13.setBackground(lboard[13]);
        jButton14.setBackground(lboard[14]);
        jButton15.setBackground(lboard[15]);
        jButton16.setBackground(lboard[16]);
        jButton17.setBackground(lboard[17]);
        jButton18.setBackground(lboard[18]);
        jButton19.setBackground(lboard[19]);
        jButton20.setBackground(lboard[20]);
        jButton21.setBackground(lboard[21]);
        jButton22.setBackground(lboard[22]);
        jButton23.setBackground(lboard[23]);
        jButton24.setBackground(lboard[24]);
        jButton25.setBackground(lboard[25]);
        jButton26.setBackground(lboard[26]);
        jButton27.setBackground(lboard[27]);
        jButton28.setBackground(lboard[28]);
        jButton29.setBackground(lboard[29]);
        jButton30.setBackground(lboard[30]);
        jButton31.setBackground(lboard[31]);
        jButton32.setBackground(lboard[32]);
        jButton33.setBackground(lboard[33]);
        jButton34.setBackground(lboard[34]);
        jButton35.setBackground(lboard[35]);
        jButton36.setBackground(lboard[36]);
        jButton37.setBackground(lboard[37]);
        jButton38.setBackground(lboard[38]);
        jButton39.setBackground(lboard[39]);
        jButton40.setBackground(lboard[40]);
        jButton41.setBackground(lboard[41]);
        jButton42.setBackground(lboard[42]);
        jButton43.setBackground(lboard[43]);
        jButton44.setBackground(lboard[44]);
        jButton45.setBackground(lboard[45]);
        jButton46.setBackground(lboard[46]);
        jButton47.setBackground(lboard[47]);
        jButton48.setBackground(lboard[48]);
        jButton49.setBackground(lboard[49]);
        jButton50.setBackground(lboard[50]);
        jButton51.setBackground(lboard[51]);
        jButton52.setBackground(lboard[52]);
        jButton53.setBackground(lboard[53]);
        jButton54.setBackground(lboard[54]);
        jButton55.setBackground(lboard[55]);
        jButton56.setBackground(lboard[56]);
        jButton57.setBackground(lboard[57]);
        jButton58.setBackground(lboard[58]);
        jButton59.setBackground(lboard[59]);
        jButton60.setBackground(lboard[60]);
        jButton61.setBackground(lboard[61]);
        jButton62.setBackground(lboard[62]);
        jButton63.setBackground(lboard[63]);
        jButton64.setBackground(lboard[64]);
    }

    public void play(int caseO, int caseX) {
        caseO = CASES[caseO - 1];
        caseX = CASES[caseX - 1];
        boolean isvalidmove = ggame.play_human(caseO, caseX);
        if (!isvalidmove) {
            System.out.println("not a valid move");
            setGuiPosition(gp);//réafficher position
        } else {
            System.out.println("is a valid move");
            gp = ggame.getG_position();
            setGuiPosition(gp);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ChessPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jButton57 = new javax.swing.JButton();
        jButton58 = new javax.swing.JButton();
        jButton59 = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        jButton61 = new javax.swing.JButton();
        jButton62 = new javax.swing.JButton();
        jButton63 = new javax.swing.JButton();
        jButton64 = new javax.swing.JButton();
        ChessCde = new javax.swing.JPanel();
        playButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        coups_GACLE = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();
        forwardButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        ChessPanel.setPreferredSize(new java.awt.Dimension(512, 512));
        ChessPanel.setLayout(new java.awt.GridLayout(8, 8));

        jButton1.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        ChessPanel.add(jButton1);

        jButton2.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        ChessPanel.add(jButton2);

        jButton3.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton3);

        jButton4.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton4);

        jButton5.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        ChessPanel.add(jButton5);

        jButton6.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton6);

        jButton7.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton7);

        jButton8.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton8);

        jButton9.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });
        ChessPanel.add(jButton9);

        jButton10.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton10);

        jButton11.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton11);

        jButton12.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton12MouseClicked(evt);
            }
        });
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton12);

        jButton13.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton13MouseClicked(evt);
            }
        });
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton13);

        jButton14.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton14MouseClicked(evt);
            }
        });
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton14);

        jButton15.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton15MouseClicked(evt);
            }
        });
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton15);

        jButton16.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton16MouseClicked(evt);
            }
        });
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton16);

        jButton17.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton17MouseClicked(evt);
            }
        });
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton17);

        jButton18.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton18MouseClicked(evt);
            }
        });
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton18);

        jButton19.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton19MouseClicked(evt);
            }
        });
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton19);

        jButton20.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton20MouseClicked(evt);
            }
        });
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton20);

        jButton21.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton21MouseClicked(evt);
            }
        });
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton21);

        jButton22.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton22MouseClicked(evt);
            }
        });
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton22);

        jButton23.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton23MouseClicked(evt);
            }
        });
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton23);

        jButton24.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton24MouseClicked(evt);
            }
        });
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton24);

        jButton25.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton25MouseClicked(evt);
            }
        });
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton25);

        jButton26.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton26MouseClicked(evt);
            }
        });
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton26);

        jButton27.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton27MouseClicked(evt);
            }
        });
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton27);

        jButton28.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton28MouseClicked(evt);
            }
        });
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton28);

        jButton29.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton29MouseClicked(evt);
            }
        });
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton29);

        jButton30.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton30MouseClicked(evt);
            }
        });
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton30);

        jButton31.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton31MouseClicked(evt);
            }
        });
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton31);

        jButton32.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton32MouseClicked(evt);
            }
        });
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton32);

        jButton33.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton33MouseClicked(evt);
            }
        });
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton33);

        jButton34.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton34MouseClicked(evt);
            }
        });
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton34);

        jButton35.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton35MouseClicked(evt);
            }
        });
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton35);

        jButton36.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton36MouseClicked(evt);
            }
        });
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton36);

        jButton37.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton37MouseClicked(evt);
            }
        });
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton37);

        jButton38.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton38MouseClicked(evt);
            }
        });
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton38);

        jButton39.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton39MouseClicked(evt);
            }
        });
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton39);

        jButton40.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton40MouseClicked(evt);
            }
        });
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton40);

        jButton41.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton41MouseClicked(evt);
            }
        });
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton41);

        jButton42.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton42MouseClicked(evt);
            }
        });
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton42);

        jButton43.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton43MouseClicked(evt);
            }
        });
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton43);

        jButton44.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton44MouseClicked(evt);
            }
        });
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton44);

        jButton45.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton45MouseClicked(evt);
            }
        });
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton45);

        jButton46.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton46MouseClicked(evt);
            }
        });
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton46);

        jButton47.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton47MouseClicked(evt);
            }
        });
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton47);

        jButton48.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton48MouseClicked(evt);
            }
        });
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton48);

        jButton49.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton49MouseClicked(evt);
            }
        });
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton49);

        jButton50.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton50MouseClicked(evt);
            }
        });
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton50);

        jButton51.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton51MouseClicked(evt);
            }
        });
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton51);

        jButton52.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton52MouseClicked(evt);
            }
        });
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton52);

        jButton53.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton53MouseClicked(evt);
            }
        });
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton53);

        jButton54.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton54MouseClicked(evt);
            }
        });
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton54);

        jButton55.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton55MouseClicked(evt);
            }
        });
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton55);

        jButton56.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton56MouseClicked(evt);
            }
        });
        jButton56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton56);

        jButton57.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton57MouseClicked(evt);
            }
        });
        jButton57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton57);

        jButton58.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton58.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton58MouseClicked(evt);
            }
        });
        jButton58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton58);

        jButton59.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton59MouseClicked(evt);
            }
        });
        jButton59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton59);

        jButton60.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton60.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton60MouseClicked(evt);
            }
        });
        jButton60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton60);

        jButton61.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton61MouseClicked(evt);
            }
        });
        jButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton61);

        jButton62.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton62MouseClicked(evt);
            }
        });
        jButton62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton62);

        jButton63.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton63MouseClicked(evt);
            }
        });
        jButton63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton63);

        jButton64.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton64.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton64MouseClicked(evt);
            }
        });
        jButton64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ChessPanel.add(jButton64);

        playButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        playButton.setText("PLAY");
        playButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playButtonMouseClicked(evt);
            }
        });

        resetButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        resetButton.setText("new game and frame");
        resetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetButtonMouseClicked(evt);
            }
        });

        coups_GACLE.setColumns(20);
        coups_GACLE.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        coups_GACLE.setRows(5);
        jScrollPane1.setViewportView(coups_GACLE);

        backButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        backButton.setText("< ---");
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        forwardButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        forwardButton.setText("-- >>");
        forwardButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forwardButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ChessCdeLayout = new javax.swing.GroupLayout(ChessCde);
        ChessCde.setLayout(ChessCdeLayout);
        ChessCdeLayout.setHorizontalGroup(
            ChessCdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChessCdeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ChessCdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playButton, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                    .addComponent(resetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(ChessCdeLayout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(forwardButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ChessCdeLayout.setVerticalGroup(
            ChessCdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChessCdeLayout.createSequentialGroup()
                .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ChessCdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(forwardButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ChessPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChessCde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ChessPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ChessCde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

        if (first_case) {
            first_case = false;
            caseO = 1;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 1;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 2;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 2;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 4;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 4;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked

        if (first_case) {
            first_case = false;
            caseO = 3;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 3;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 5;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 5;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 6;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 6;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 7;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 7;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 8;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 8;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton8MouseClicked

    private void playButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playButtonMouseClicked
        if (!ggame.isMode_auto()) {
            if (caseO != 0 && caseX != 0) {
                play(caseO, caseX);
            }
        } else {
            try {
                num = 0;
                ggame.setG_position(gp);
                ggame.play_auto();
            } catch (NodeNotFoundException ex) {
                Logger.getLogger(ChessGui.class.getName()).log(Level.SEVERE, null, ex);
            }
            setGuiPosition(gp);
        }
    }//GEN-LAST:event_playButtonMouseClicked

    private void jButton21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton21MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 21;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 21;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton21MouseClicked

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 9;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 9;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 10;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 10;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton10MouseClicked

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 11;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 11;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton11MouseClicked

    private void jButton12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 12;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 12;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton12MouseClicked

    private void jButton13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 13;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 13;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton13MouseClicked

    private void jButton14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 14;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 14;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton14MouseClicked

    private void jButton15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 15;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 15;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton15MouseClicked

    private void jButton16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 16;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 16;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton16MouseClicked

    private void jButton17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton17MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 17;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 17;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton17MouseClicked

    private void jButton18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 18;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 18;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton18MouseClicked

    private void jButton19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton19MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 19;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 19;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton19MouseClicked

    private void jButton20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton20MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 20;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 20;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton20MouseClicked

    private void jButton22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton22MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 22;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 22;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton22MouseClicked

    private void jButton23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton23MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 23;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 23;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton23MouseClicked

    private void jButton24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton24MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 24;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 24;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton24MouseClicked

    private void jButton25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton25MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 25;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 25;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton25MouseClicked

    private void jButton26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton26MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 26;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 26;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton26MouseClicked

    private void jButton27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton27MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 27;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 27;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton27MouseClicked

    private void jButton30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton30MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 30;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 30;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton30MouseClicked

    private void jButton31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton31MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 31;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 31;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton31MouseClicked

    private void jButton32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton32MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 32;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 32;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton32MouseClicked

    private void jButton33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton33MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 33;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 33;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton33MouseClicked

    private void jButton34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton34MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 34;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 34;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton34MouseClicked

    private void jButton35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton35MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 35;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 35;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton35MouseClicked

    private void jButton38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton38MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 38;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 38;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton38MouseClicked

    private void jButton39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton39MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 39;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 39;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton39MouseClicked

    private void jButton40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton40MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 40;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 40;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton40MouseClicked

    private void jButton41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton41MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 41;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 41;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton41MouseClicked

    private void jButton42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton42MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 42;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 42;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton42MouseClicked

    private void jButton43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton43MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 43;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 43;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton43MouseClicked

    private void jButton44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton44MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 44;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 44;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton44MouseClicked

    private void jButton45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton45MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 45;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 45;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton45MouseClicked

    private void jButton46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton46MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 46;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 46;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton46MouseClicked

    private void jButton47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton47MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 47;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 47;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton47MouseClicked

    private void jButton48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton48MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 48;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 48;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton48MouseClicked

    private void jButton49MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton49MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 49;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 49;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton49MouseClicked

    private void jButton50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton50MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 50;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 50;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton50MouseClicked

    private void jButton51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton51MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 51;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 51;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton51MouseClicked

    private void jButton52MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton52MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 52;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 52;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton52MouseClicked

    private void jButton53MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton53MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 53;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 53;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton53MouseClicked

    private void jButton54MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton54MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 54;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 54;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton54MouseClicked

    private void jButton55MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton55MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 55;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 55;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton55MouseClicked

    private void jButton56MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton56MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 56;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 56;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton56MouseClicked

    private void jButton57MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton57MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 57;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 57;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton57MouseClicked

    private void jButton58MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton58MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 58;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 58;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton58MouseClicked

    private void jButton59MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton59MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 59;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 59;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton59MouseClicked

    private void jButton60MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton60MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 60;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 60;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton60MouseClicked

    private void jButton61MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton61MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 61;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 61;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton61MouseClicked

    private void jButton62MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton62MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 62;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 62;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton62MouseClicked

    private void jButton63MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton63MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 63;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 63;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton63MouseClicked

    private void jButton64MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton64MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 64;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 64;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton64MouseClicked

    private void resetButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetButtonMouseClicked
        try {
            GStart.start();

        } catch (NodeNotFoundException ex) {
            Logger.getLogger(ChessGui.class.getName()).log(Level.SEVERE, null, ex);
        }

//        try {
//            ggame.play_computer();
//            gp = ggame.getG_position();
//            setGuiPosition(gp);
//            // choix du coups IA
//        } catch (NodeNotFoundException ex) {
//            Logger.getLogger(ChessGui.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_resetButtonMouseClicked

    private void jButton28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton28MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 28;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 28;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton28MouseClicked

    private void jButton29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton29MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 29;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 29;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton29MouseClicked

    private void jButton36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton36MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 36;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 36;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);
        }
    }//GEN-LAST:event_jButton36MouseClicked

    private void jButton37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton37MouseClicked
        if (first_case) {
            first_case = false;
            caseO = 37;
            jB_first_case = (JButton) evt.getComponent();
            jB_first_case.setBorder(bord_1_clic);

        } else {
            first_case = true;
            caseX = 37;
            jB_second_case = (JButton) evt.getComponent();
            jB_second_case.setIcon(jB_first_case.getIcon());
            jB_first_case.setBorder(bord_0_clic);
            jB_first_case.setIcon(vide);

        }
    }//GEN-LAST:event_jButton37MouseClicked

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed

    }//GEN-LAST:event_backButtonActionPerformed

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        ArrayList<GPosition> part = ggame.getPartie();
        gp = ggame.getG_position();
        num_coups = gp.getNum_coups();
        backORforward = true;
        num++;
        GPosition pos = part.get(num_coups - num);
//        System.out.println(pos.print());
        setGuiPosition(pos);

    }//GEN-LAST:event_backButtonMouseClicked

    private void forwardButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forwardButtonMouseClicked
        ArrayList<GPosition> part = ggame.getPartie();
        gp = ggame.getG_position();
        num_coups = gp.getNum_coups();
        backORforward = true;
        GPosition pos = part.get(num_coups);
//        System.out.println(pos.print());
        setGuiPosition(pos);
    }//GEN-LAST:event_forwardButtonMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ChessCde;
    private javax.swing.JPanel ChessPanel;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton backButton;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JTextArea coups_GACLE;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton forwardButton;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JButton playButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

}
