package potyogosamoba;

/**
 *
 * @author Sándor
 */


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
 
/**
 * @see http://stackoverflow.com/questions/7702697
 */
public class GridButtonPanel {
    private JFrame f;   //main JFrame
    JPanel p;           //grid panel
    JPanel n;           //nav panel
    
    /**/
    TicTac tictac;
    Gui gui;
    public GridButtonPanel(TicTac tictac, Gui gui, int N, int M) {
        this.tictac = tictac;
        this.gui = gui;
        this.N = N;
        this.M = M;
    }
    /**/
    
    public static int N;
    public static int M;
    private final List<JButton> list = new ArrayList<JButton>();

    public JButton getGridButton(int r, int c) {
        int index = r * M  + c;
        return list.get(index);
    }

    private JButton createGridButton(final int row, final int col) {
        final JButton b = new JButton("r" + row + ",c" + col);
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JButton gb = GridButtonPanel.this.getGridButton(row, col);
                System.out.println("r" + row + ",c" + col
                    + " " + (b == gb)
                    + " " + (b.equals(gb)));
                gui.setNewTick(row, col);
                /*if(mine.isThisNeighbor(new coordinate(row,col))){
                    //NEW STEP
                    //b.setFont(new Font("Arial", Font.PLAIN, 40));
                    gui.recolorTableAndAddStep(row,col);
                } else {
                    //WRONG
                    System.err.println("WRONG BUTTON");
                    //JOptionPane.showMessageDialog(null, "Wronq place for a queen!");    //error msg
                }*/
            }
        });
        return b;
    }

    private JPanel createGridPanel() {
        p = new JPanel(new GridLayout(N, M));
        for (int rowIdx = 0; rowIdx < N; ++rowIdx)
            for(int colIdx = 0; colIdx < M; ++colIdx){
                JButton gb = createGridButton(rowIdx, colIdx);
                list.add(gb);
                p.add(gb);
            }
        /*for (int i = 0; i < N * M; i++) {
            int row = i / N;
            int col = i % M;
            JButton gb = createGridButton(row, col);
            list.add(gb);
            p.add(gb);
        }*/
        return p;
    }

    public void display() {
        f = new JFrame("MINE");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        f.add(createNavPanel(), BorderLayout.NORTH);
        f.add(createGridPanel(), BorderLayout.CENTER);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        if(N>M){
            f.setMinimumSize(new Dimension(N*100,N*100));
        }else{
            
        f.setMinimumSize(new Dimension(M*100,M*100));
        }
    }

    /*public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new GridButtonPanel().display();
            }
        });
    }*/

    private JPanel createNavPanel() {
        n = new JPanel(new BorderLayout());
        JButton rBtn = gui.reset();
        JButton pBtn = gui.pouse();
        //JButton bBtn = gui.back();
        JLabel tLabel = gui.timerLabel();
        //JScrollPane oList = gui.optionsList();
        
        n.add(rBtn, BorderLayout.EAST);
        n.add(pBtn, BorderLayout.WEST);
        //n.add(bBtn, BorderLayout.WEST);
        n.add(tLabel, BorderLayout.CENTER);
        //n.add(oList, BorderLayout.WEST);
        
        return n;
    }

    /**
     * Set visible grid panel
     */
    void showGameTable() {
        p.setVisible(true);
    }

    /**
     * Hide grid panel.
     */
    void hideGameTable() {
        p.setVisible(false);
    }
}