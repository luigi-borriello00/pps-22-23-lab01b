package e2;

import e2.playground.Cell;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class GUI extends JFrame {
    
    private static final long serialVersionUID = -6218820567019985015L;
    private final Map<JButton,Pair<Integer,Integer>> buttons = new HashMap<>();
    private final Logics logics;
    
    public GUI(int size, int numberOfBombs) {
        this.logics = new LogicsImpl(size, numberOfBombs);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100*size, 100*size);
        
        JPanel panel = new JPanel(new GridLayout(size,size));
        this.getContentPane().add(BorderLayout.CENTER,panel);
        
        ActionListener onClick = (e)->{
            final JButton bt = (JButton)e.getSource();
            final Pair<Integer,Integer> pos = buttons.get(bt);
            // call the logic here to tell it that cell at 'pos' has been selected
            Cell targetCell = this.logics.getGrid().getCells().stream()
                    .filter(cell -> cell.getCoordinates().equals(pos))
                    .findFirst().get();
            boolean aMineWasFound = this.logics.getGrid().clickCell(targetCell);;// call the logic here to tell it that cell at 'pos' has been seleced
            if (aMineWasFound) {
                quitGame();
                JOptionPane.showMessageDialog(this, "You lost!!");
            } else {
                drawBoard();            	
            }
            boolean isThereVictory = this.logics.isThereVictory(); // call the logic here to ask if there is victory
            if (isThereVictory){
                quitGame();
                JOptionPane.showMessageDialog(this, "You won!!");
                System.exit(0);
            }
        };

        MouseInputListener onRightClick = new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                final JButton bt = (JButton)e.getSource();
                if (bt.isEnabled()){
                    final Pair<Integer,Integer> pos = buttons.get(bt);
                    // call the logic here to put/remove a flag
                    logics.getGrid().getCells().stream()
                            .filter(cell -> cell.getCoordinates().equals(pos))
                            .findFirst().get().toggleFlag();

                }
                drawBoard(); 
            }
        };
                
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                final JButton jb = new JButton(" ");
                jb.addActionListener(onClick);
                jb.addMouseListener(onRightClick);
                this.buttons.put(jb,new Pair<>(i,j));
                panel.add(jb);
            }
        }
        this.drawBoard();
        this.setVisible(true);
    }
    
    private void quitGame() {
        this.drawBoard();
    	for (var entry: this.buttons.entrySet()) {


            // disable the button
    	}
    }

    private void drawClickedCell(Cell cell, JButton button){
        if(cell.isClicked()){
            button.setEnabled(false);
            this.drawCounterOnCell(cell, button);
        }
    }

    private void drawMineCell(Cell cell, JButton button){
        if(cell.isBomb()){
            button.setText("*");
        }
    }

    private void drawCellWithFlag(Cell cell, JButton button){
        if(cell.hasFlag()){
            button.setText("F");
        }
        else{
            button.setText(" ");
        }
    }

    private void drawCounterOnCell(Cell cell, JButton button){
        if(cell.getCounterOfAdjacentBombs() > 0){
            button.setText(String.valueOf(cell.getCounterOfAdjacentBombs()));
        }
    }


    private void drawBoard() {
        for (var entry: this.buttons.entrySet()) {

            // call the logic here
            Cell entryCell = this.logics.getGrid().getCells().stream()
                    .filter(cell -> cell.getCoordinates().equals(entry.getValue()))
                    .findFirst().get();

            // if this button has a flag, put the flag
            this.drawCellWithFlag(entryCell, entry.getKey());
            this.drawClickedCell(entryCell, entry.getKey());
            // if this button is a mine, draw it "*"
            this.drawMineCell(entryCell, entry.getKey());

    	}
    }

}
