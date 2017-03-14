/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.net.*;


/**
 *
 * @author aweso
 */
public class MainFrame extends javax.swing.JFrame {

    //  Directory of files
    //String directory = "C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\Activity6_Bautista\\project-master\\src\\Resources\\";
    
   // String directory = "C:\\Users\\aweso\\OneDrive\\Documents\\NetBeansProjects\\JavaProject\\src\\Resources\\";
    //  Anne, dito mo ilagay yung directory mo dun sa may null.
    //  Tas icomment out mo yung sakin.
//
    //======================================================
    String url = "192.168.1.100";
    String player = "";
    int goNoGo = 0;
    public String inputFromOpponent = null;
    public String outputToOpponent = null;
    
    // Importing the pictures for each pieces
    ImageIcon pawnb = new ImageIcon(getClass().getClassLoader().getResource("Resources/pawn-b.png"));
    ImageIcon pawnw = new ImageIcon(getClass().getClassLoader().getResource("Resources/pawn-w.png"));
    ImageIcon queenb = new ImageIcon(getClass().getClassLoader().getResource("Resources/queen-b.png"));
    ImageIcon queenw = new ImageIcon(getClass().getClassLoader().getResource("Resources/queen-w.png"));
    ImageIcon kingb = new ImageIcon(getClass().getClassLoader().getResource("Resources/king-b.png"));
    ImageIcon kingw = new ImageIcon(getClass().getClassLoader().getResource("Resources/king-w.png"));
    ImageIcon bishopb = new ImageIcon(getClass().getClassLoader().getResource("Resources/bishop-b.png"));
    ImageIcon bishopw = new ImageIcon(getClass().getClassLoader().getResource("Resources/bishop-w.png"));
    ImageIcon knightb = new ImageIcon(getClass().getClassLoader().getResource("Resources/horse-b.png"));
    ImageIcon knightw = new ImageIcon(getClass().getClassLoader().getResource("Resources/horse-w.png"));
    ImageIcon rookb = new ImageIcon(getClass().getClassLoader().getResource("Resources/rook-b.png"));
    ImageIcon rookw = new ImageIcon(getClass().getClassLoader().getResource("Resources/rook-w.png"));
    //======================================================
    
    //   Trace of which piece will be move
    String bufferpiece = null;
    String bufferloc = null;
    //======================================================
    
    //  Graphics for each scenario
    Border orig = BorderFactory.createLineBorder(Color.black, 2);       // Default border
    Border checked = BorderFactory.createLineBorder(Color.red, 3);      // Border when checked
    Border movement = BorderFactory.createLineBorder(Color.yellow, 3);  // Available destination
    Cursor handcur = new Cursor(HAND_CURSOR);
    Cursor origcur = new Cursor(DEFAULT_CURSOR);
    //======================================================
    
    // Creating the object for each piece
    PawnPiece p1w = new PawnPiece("white","A2");
    PawnPiece p2w = new PawnPiece("white","B2");
    PawnPiece p3w = new PawnPiece("white","C2");
    PawnPiece p4w = new PawnPiece("white","D2");
    PawnPiece p5w = new PawnPiece("white","E2");
    PawnPiece p6w = new PawnPiece("white","F2");
    PawnPiece p7w = new PawnPiece("white","G2");
    PawnPiece p8w = new PawnPiece("white","H2");
    
    PawnPiece p1b = new PawnPiece("black","A7");
    PawnPiece p2b = new PawnPiece("black","B7");
    PawnPiece p3b = new PawnPiece("black","C7");
    PawnPiece p4b = new PawnPiece("black","D7");
    PawnPiece p5b = new PawnPiece("black","E7");
    PawnPiece p6b = new PawnPiece("black","F7");
    PawnPiece p7b = new PawnPiece("black","G7");
    PawnPiece p8b = new PawnPiece("black","H7");
    
    RookPiece r1w = new RookPiece("white", "A1");
    RookPiece r2w = new RookPiece("white", "H1");
    RookPiece r1b = new RookPiece("black", "A8");
    RookPiece r2b = new RookPiece("black", "H8");
    
    KnightPiece h1w = new KnightPiece("white", "B1");
    KnightPiece h2w = new KnightPiece("white", "G1");
    KnightPiece h1b = new KnightPiece("black", "B8");
    KnightPiece h2b = new KnightPiece("black", "G8");
    
    BishopPiece b1w = new BishopPiece("white", "C1");
    BishopPiece b2w = new BishopPiece("white", "F1");
    BishopPiece b1b = new BishopPiece("black", "C8");
    BishopPiece b2b = new BishopPiece("black", "F8");
    
    //QueenPiece q1w = new QueenPiece("white", "D1");
    //QueenPiece q1b = new QueenPiece("black", "D8");
    
    //KingPiece k1w = new KingPiece("white", "E1");
    //KingPiece k1b = new KingPiece("black", "E8");
    
    //======================================================
    
    //  Array for possible destinations of a piece
    ArrayList<String> possiblem = new ArrayList<>();
    //======================================================
    
    //  Table of array to check if a piece is in place
    String[][] piecesAlive = new String[8][8];
    //======================================================
    
    //  Populating the board at the start of the game
    public void refreshBoard()
    {
        lblA1.setIcon(rookw);
        lblB1.setIcon(knightw);
        lblC1.setIcon(bishopw);
        lblD1.setIcon(queenw);
        lblE1.setIcon(kingw);
        lblF1.setIcon(bishopw);
        lblG1.setIcon(knightw);
        lblH1.setIcon(rookw);
        
        lblA2.setIcon(pawnw);
        lblB2.setIcon(pawnw);
        lblC2.setIcon(pawnw);
        lblD2.setIcon(pawnw);
        lblE2.setIcon(pawnw);
        lblF2.setIcon(pawnw);
        lblG2.setIcon(pawnw);
        lblH2.setIcon(pawnw);

        lblA8.setIcon(rookb);
        lblB8.setIcon(knightb);
        lblC8.setIcon(bishopb);
        lblD8.setIcon(queenb);
        lblE8.setIcon(kingb);
        lblF8.setIcon(bishopb);
        lblG8.setIcon(knightb);
        lblH8.setIcon(rookb);
        
        lblA7.setIcon(pawnb);
        lblB7.setIcon(pawnb);
        lblC7.setIcon(pawnb);
        lblD7.setIcon(pawnb);
        lblE7.setIcon(pawnb);
        lblF7.setIcon(pawnb);
        lblG7.setIcon(pawnb);
        lblH7.setIcon(pawnb);
        
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                piecesAlive[j][i] = "";
            }
        }
        
        piecesAlive[0][0] = "r1w";
        piecesAlive[1][0] = "h1w";
        piecesAlive[2][0] = "b1w";
        piecesAlive[3][0] = "q1w";
        piecesAlive[4][0] = "k1w";
        piecesAlive[5][0] = "b2w";
        piecesAlive[6][0] = "h2w";
        piecesAlive[7][0] = "r2w";
        
        piecesAlive[0][1] = "p1w";
        piecesAlive[1][1] = "p2w";
        piecesAlive[2][1] = "p3w";
        piecesAlive[3][1] = "p4w";
        piecesAlive[4][1] = "p5w";
        piecesAlive[5][1] = "p6w";
        piecesAlive[6][1] = "p7w";
        piecesAlive[7][1] = "p8w";
        
        piecesAlive[0][7] = "r1b";
        piecesAlive[1][7] = "h1b";
        piecesAlive[2][7] = "b1b";
        piecesAlive[3][7] = "q1b";
        piecesAlive[4][7] = "k1b";
        piecesAlive[5][7] = "b2b";
        piecesAlive[6][7] = "h2b";
        piecesAlive[7][7] = "r2b";
        
        piecesAlive[0][6] = "p1b";
        piecesAlive[1][6] = "p2b";
        piecesAlive[2][6] = "p3b";
        piecesAlive[3][6] = "p4b";
        piecesAlive[4][6] = "p5b";
        piecesAlive[5][6] = "p6b";
        piecesAlive[6][6] = "p7b";
        piecesAlive[7][6] = "p8b";
        
    }
    //======================================================
    
    //  Possible destinations of a piece to place in the array 
    public void possiblemoves(ArrayList<String> possiblem)
    {
        char test = bufferpiece.charAt(2);
        
        if(test == 'w')
        {
            for(String s : possiblem)
            {
                if(s.equals("A1") && (piecesAlive[0][0].equals("") || piecesAlive[0][0].charAt(2) == 'b'))
                {
                    A1.setBorder(movement);
                    A1.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("A2") && piecesAlive[0][1].equals(""))
                {
                    A2.setBorder(movement);
                    A2.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("A3") && piecesAlive[0][2].equals(""))
                {
                    A3.setBorder(movement);
                    A3.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("A4") && piecesAlive[0][3].equals(""))
                {
                    A4.setBorder(movement);
                    A4.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("A5") && piecesAlive[0][4].equals(""))
                {
                    A5.setBorder(movement);
                    A5.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("A6") && piecesAlive[0][5].equals(""))
                {
                    A6.setBorder(movement);
                    A6.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("A7") && piecesAlive[0][6].equals(""))
                {
                    A7.setBorder(movement);
                    A7.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("A8") && piecesAlive[0][7].equals(""))
                {
                    A8.setBorder(movement);
                    A8.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("B1") && piecesAlive[1][0].equals(""))
                {
                    B1.setBorder(movement);
                    B1.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("B2") && piecesAlive[1][1].equals(""))
                {
                    B2.setBorder(movement);
                    B2.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("B3") && piecesAlive[1][2].equals(""))
                {
                    B3.setBorder(movement);
                    B3.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("B4") && piecesAlive[1][3].equals(""))
                {
                    B4.setBorder(movement);
                    B4.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("B5") && piecesAlive[1][4].equals(""))
                {
                    B5.setBorder(movement);
                    B5.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("B6") && piecesAlive[1][5].equals(""))
                {
                    B6.setBorder(movement);
                    B6.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("B7") && piecesAlive[1][6].equals(""))
                {
                    B7.setBorder(movement);
                    B7.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("B8") && piecesAlive[1][7].equals(""))
                {
                    B8.setBorder(movement);
                    B8.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("C1") && piecesAlive[2][0].equals(""))
                {
                    C1.setBorder(movement);
                    C1.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("C2") && piecesAlive[2][1].equals(""))
                {
                    C2.setBorder(movement);
                    C2.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("C3") && piecesAlive[2][2].equals(""))
                {
                    C3.setBorder(movement);
                    C3.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("C4") && piecesAlive[2][3].equals(""))
                {
                    C4.setBorder(movement);
                    C4.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("C5") && piecesAlive[2][4].equals(""))
                {
                    C5.setBorder(movement);
                    C5.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("C6") && piecesAlive[2][5].equals(""))
                {
                    C6.setBorder(movement);
                    C6.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("C7") && piecesAlive[2][6].equals(""))
                {
                    C7.setBorder(movement);
                    C7.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("C8") && piecesAlive[2][7].equals(""))
                {
                    C8.setBorder(movement);
                    C8.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("D1") && piecesAlive[3][0].equals(""))
                {
                    D1.setBorder(movement);
                    D1.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("D2") && piecesAlive[3][1].equals(""))
                {
                    D2.setBorder(movement);
                    D2.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("D3") && piecesAlive[3][2].equals(""))
                {
                    D3.setBorder(movement);
                    D3.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("D4") && piecesAlive[3][3].equals(""))
                {
                    D4.setBorder(movement);
                    D4.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("D5") && piecesAlive[3][4].equals(""))
                {
                    D5.setBorder(movement);
                    D5.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("D6") && piecesAlive[3][5].equals(""))
                {
                    D6.setBorder(movement);
                    D6.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("D7") && piecesAlive[3][6].equals(""))
                {
                    D7.setBorder(movement);
                    D7.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("D8") && piecesAlive[3][7].equals(""))
                {
                    D8.setBorder(movement);
                    D8.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("E1") && piecesAlive[4][0].equals(""))
                {
                    E1.setBorder(movement);
                    E1.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("E2") && piecesAlive[4][1].equals(""))
                {
                    E2.setBorder(movement);
                    E2.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("E3") && piecesAlive[4][2].equals(""))
                {
                    E3.setBorder(movement);
                    E3.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("E4") && piecesAlive[4][3].equals(""))
                {
                    E4.setBorder(movement);
                    E4.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("E5") && piecesAlive[4][4].equals(""))
                {
                    E5.setBorder(movement);
                    E5.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("E6") && piecesAlive[4][5].equals(""))
                {
                    E6.setBorder(movement);
                    E6.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("E7") && piecesAlive[4][6].equals(""))
                {
                    E7.setBorder(movement);
                    E7.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("E8") && piecesAlive[4][7].equals(""))
                {
                    E8.setBorder(movement);
                    E8.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("F1") && piecesAlive[5][0].equals(""))
                {
                    F1.setBorder(movement);
                    F1.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("F2") && piecesAlive[5][1].equals(""))
                {
                    F2.setBorder(movement);
                    F2.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("F3") && (piecesAlive[5][2].equals("") || piecesAlive[5][2].charAt(2) == 'b'))
                {
                    F3.setBorder(movement);
                    F3.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("F4") && piecesAlive[5][3].equals(""))
                {
                    F4.setBorder(movement);
                    F4.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("F5") && piecesAlive[5][4].equals(""))
                {
                    F5.setBorder(movement);
                    F5.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("F6") && piecesAlive[5][5].equals(""))
                {
                    F6.setBorder(movement);
                    F6.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("F7") && piecesAlive[5][6].equals(""))
                {
                    F7.setBorder(movement);
                    F7.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("F8") && piecesAlive[5][7].equals(""))
                {
                    F8.setBorder(movement);
                    F8.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("G1") && piecesAlive[6][0].equals(""))
                {
                    G1.setBorder(movement);
                    G1.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("G2") && piecesAlive[6][1].equals(""))
                {
                    G2.setBorder(movement);
                    G2.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("G3") && piecesAlive[6][2].equals(""))
                {
                    G3.setBorder(movement);
                    G3.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("G4") && piecesAlive[6][3].equals(""))
                {
                    G4.setBorder(movement);
                    G4.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("G5") && piecesAlive[6][4].equals(""))
                {
                    G5.setBorder(movement);
                    G5.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("G6") && piecesAlive[6][5].equals(""))
                {
                    G6.setBorder(movement);
                    G6.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("G7") && piecesAlive[6][6].equals(""))
                {
                    G7.setBorder(movement);
                    G7.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("G8") && piecesAlive[6][7].equals(""))
                {
                    G8.setBorder(movement);
                    G8.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("H1") && piecesAlive[7][0].equals(""))
                {
                    H1.setBorder(movement);
                    H1.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("H2") && piecesAlive[7][1].equals(""))
                {
                    H2.setBorder(movement);
                    H2.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("H3") && piecesAlive[7][2].equals(""))
                {
                    H3.setBorder(movement);
                    H3.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("H4") && piecesAlive[7][3].equals(""))
                {
                    H4.setBorder(movement);
                    H4.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("H5") && piecesAlive[7][4].equals(""))
                {
                    H5.setBorder(movement);
                    H5.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("H6") && piecesAlive[7][5].equals(""))
                {
                    H6.setBorder(movement);
                    H6.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("H7") && piecesAlive[7][6].equals(""))
                {
                    H7.setBorder(movement);
                    H7.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("H8") && piecesAlive[7][7].equals(""))
                {
                    H8.setBorder(movement);
                    H8.setCursor(new Cursor(HAND_CURSOR));
                }
            }
        }
        else if(test ==  'b')
        {
            for(String s : possiblem)
            {
                if(s.equals("A1") && (piecesAlive[0][0].equals("") || piecesAlive[0][0].charAt(2) == 'w'))
                {
                    A1.setBorder(movement);
                    A1.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("A2") && piecesAlive[0][1].equals(""))
                {
                    A2.setBorder(movement);
                    A2.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("A3") && piecesAlive[0][2].equals(""))
                {
                    A3.setBorder(movement);
                    A3.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("A4") && piecesAlive[0][3].equals(""))
                {
                    A4.setBorder(movement);
                    A4.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("A5") && piecesAlive[0][4].equals(""))
                {
                    A5.setBorder(movement);
                    A5.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("A6") && piecesAlive[0][5].equals(""))
                {
                    A6.setBorder(movement);
                    A6.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("A7") && piecesAlive[0][6].equals(""))
                {
                    A7.setBorder(movement);
                    A7.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("A8") && piecesAlive[0][7].equals(""))
                {
                    A8.setBorder(movement);
                    A8.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("B1") && piecesAlive[1][0].equals(""))
                {
                    B1.setBorder(movement);
                    B1.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("B2") && piecesAlive[1][1].equals(""))
                {
                    B2.setBorder(movement);
                    B2.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("B3") && piecesAlive[1][2].equals(""))
                {
                    B3.setBorder(movement);
                    B3.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("B4") && piecesAlive[1][3].equals(""))
                {
                    B4.setBorder(movement);
                    B4.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("B5") && piecesAlive[1][4].equals(""))
                {
                    B5.setBorder(movement);
                    B5.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("B6") && piecesAlive[1][5].equals(""))
                {
                    B6.setBorder(movement);
                    B6.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("B7") && piecesAlive[1][6].equals(""))
                {
                    B7.setBorder(movement);
                    B7.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("B8") && piecesAlive[1][7].equals(""))
                {
                    B8.setBorder(movement);
                    B8.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("C1") && piecesAlive[2][0].equals(""))
                {
                    C1.setBorder(movement);
                    C1.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("C2") && piecesAlive[2][1].equals(""))
                {
                    C2.setBorder(movement);
                    C2.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("C3") && piecesAlive[2][2].equals(""))
                {
                    C3.setBorder(movement);
                    C3.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("C4") && piecesAlive[2][3].equals(""))
                {
                    C4.setBorder(movement);
                    C4.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("C5") && piecesAlive[2][4].equals(""))
                {
                    C5.setBorder(movement);
                    C5.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("C6") && piecesAlive[2][5].equals(""))
                {
                    C6.setBorder(movement);
                    C6.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("C7") && piecesAlive[2][6].equals(""))
                {
                    C7.setBorder(movement);
                    C7.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("C8") && piecesAlive[2][7].equals(""))
                {
                    C8.setBorder(movement);
                    C8.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("D1") && piecesAlive[3][0].equals(""))
                {
                    D1.setBorder(movement);
                    D1.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("D2") && piecesAlive[3][1].equals(""))
                {
                    D2.setBorder(movement);
                    D2.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("D3") && piecesAlive[3][2].equals(""))
                {
                    D3.setBorder(movement);
                    D3.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("D4") && piecesAlive[3][3].equals(""))
                {
                    D4.setBorder(movement);
                    D4.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("D5") && piecesAlive[3][4].equals(""))
                {
                    D5.setBorder(movement);
                    D5.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("D6") && piecesAlive[3][5].equals(""))
                {
                    D6.setBorder(movement);
                    D6.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("D7") && piecesAlive[3][6].equals(""))
                {
                    D7.setBorder(movement);
                    D7.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("D8") && piecesAlive[3][7].equals(""))
                {
                    D8.setBorder(movement);
                    D8.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("E1") && piecesAlive[4][0].equals(""))
                {
                    E1.setBorder(movement);
                    E1.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("E2") && piecesAlive[4][1].equals(""))
                {
                    E2.setBorder(movement);
                    E2.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("E3") && piecesAlive[4][2].equals(""))
                {
                    E3.setBorder(movement);
                    E3.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("E4") && piecesAlive[4][3].equals(""))
                {
                    E4.setBorder(movement);
                    E4.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("E5") && piecesAlive[4][4].equals(""))
                {
                    E5.setBorder(movement);
                    E5.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("E6") && piecesAlive[4][5].equals(""))
                {
                    E6.setBorder(movement);
                    E6.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("E7") && piecesAlive[4][6].equals(""))
                {
                    E7.setBorder(movement);
                    E7.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("E8") && piecesAlive[4][7].equals(""))
                {
                    E8.setBorder(movement);
                    E8.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("F1") && piecesAlive[5][0].equals(""))
                {
                    F1.setBorder(movement);
                    F1.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("F2") && piecesAlive[5][1].equals(""))
                {
                    F2.setBorder(movement);
                    F2.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("F3") && piecesAlive[5][2].equals(""))
                {
                    F3.setBorder(movement);
                    F3.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("F4") && piecesAlive[5][3].equals(""))
                {
                    F4.setBorder(movement);
                    F4.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("F5") && piecesAlive[5][4].equals(""))
                {
                    F5.setBorder(movement);
                    F5.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("F6") && piecesAlive[5][5].equals(""))
                {
                    F6.setBorder(movement);
                    F6.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("F7") && piecesAlive[5][6].equals(""))
                {
                    F7.setBorder(movement);
                    F7.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("F8") && piecesAlive[5][7].equals(""))
                {
                    F8.setBorder(movement);
                    F8.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("G1") && piecesAlive[6][0].equals(""))
                {
                    G1.setBorder(movement);
                    G1.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("G2") && piecesAlive[6][1].equals(""))
                {
                    G2.setBorder(movement);
                    G2.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("G3") && piecesAlive[6][2].equals(""))
                {
                    G3.setBorder(movement);
                    G3.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("G4") && piecesAlive[6][3].equals(""))
                {
                    G4.setBorder(movement);
                    G4.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("G5") && piecesAlive[6][4].equals(""))
                {
                    G5.setBorder(movement);
                    G5.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("G6") && piecesAlive[6][5].equals(""))
                {
                    G6.setBorder(movement);
                    G6.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("G7") && piecesAlive[6][6].equals(""))
                {
                    G7.setBorder(movement);
                    G7.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("G8") && piecesAlive[6][7].equals(""))
                {
                    G8.setBorder(movement);
                    G8.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("H1") && piecesAlive[7][0].equals(""))
                {
                    H1.setBorder(movement);
                    H1.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("H2") && piecesAlive[7][1].equals(""))
                {
                    H2.setBorder(movement);
                    H2.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("H3") && piecesAlive[7][2].equals(""))
                {
                    H3.setBorder(movement);
                    H3.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("H4") && piecesAlive[7][3].equals(""))
                {
                    H4.setBorder(movement);
                    H4.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("H5") && piecesAlive[7][4].equals(""))
                {
                    H5.setBorder(movement);
                    H5.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("H6") && piecesAlive[7][5].equals(""))
                {
                    H6.setBorder(movement);
                    H6.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("H7") && piecesAlive[7][6].equals(""))
                {
                    H7.setBorder(movement);
                    H7.setCursor(new Cursor(HAND_CURSOR));
                }
                if(s.equals("H8") && piecesAlive[7][7].equals(""))
                {
                    H8.setBorder(movement);
                    H8.setCursor(new Cursor(HAND_CURSOR));
                }
            }
        }
    }
    //======================================================
    
    //  To refresh and delete the trace of piece that been moved
    public void refreshHistory()
    {
        possiblem.clear();
        
        bufferpiece = "";
        bufferloc = "";
        
        A1.setBorder(orig);
        A2.setBorder(orig);
        A3.setBorder(orig);
        A4.setBorder(orig);
        A5.setBorder(orig);
        A6.setBorder(orig);
        A7.setBorder(orig);
        A8.setBorder(orig);

        B1.setBorder(orig);
        B2.setBorder(orig);
        B3.setBorder(orig);
        B4.setBorder(orig);
        B5.setBorder(orig);
        B6.setBorder(orig);
        B7.setBorder(orig);
        B8.setBorder(orig);
       
        C1.setBorder(orig);
        C2.setBorder(orig);
        C3.setBorder(orig);
        C4.setBorder(orig);
        C5.setBorder(orig);
        C6.setBorder(orig);
        C7.setBorder(orig);
        C8.setBorder(orig);
        
        D1.setBorder(orig);
        D2.setBorder(orig);
        D3.setBorder(orig);
        D4.setBorder(orig);
        D5.setBorder(orig);
        D6.setBorder(orig);
        D7.setBorder(orig);
        D8.setBorder(orig);
        
        E1.setBorder(orig);
        E2.setBorder(orig);
        E3.setBorder(orig);
        E4.setBorder(orig);
        E5.setBorder(orig);
        E6.setBorder(orig);
        E7.setBorder(orig);
        E8.setBorder(orig);
        
        F1.setBorder(orig);
        F2.setBorder(orig);
        F3.setBorder(orig);
        F4.setBorder(orig);
        F5.setBorder(orig);
        F6.setBorder(orig);
        F7.setBorder(orig);
        F8.setBorder(orig);
        
        G1.setBorder(orig);
        G2.setBorder(orig);
        G3.setBorder(orig);
        G4.setBorder(orig);
        G5.setBorder(orig);
        G6.setBorder(orig);
        G7.setBorder(orig);
        G8.setBorder(orig);
        
        H1.setBorder(orig);
        H2.setBorder(orig);
        H3.setBorder(orig);
        H4.setBorder(orig);
        H5.setBorder(orig);
        H6.setBorder(orig);
        H7.setBorder(orig);
        H8.setBorder(orig);
        
        ///////////////////////////
        A1.setCursor(origcur);
        A2.setCursor(origcur);
        A3.setCursor(origcur);
        A4.setCursor(origcur);
        A5.setCursor(origcur);
        A6.setCursor(origcur);
        A7.setCursor(origcur);
        A8.setCursor(origcur);

        B1.setCursor(origcur);
        B2.setCursor(origcur);
        B3.setCursor(origcur);
        B4.setCursor(origcur);
        B5.setCursor(origcur);
        B6.setCursor(origcur);
        B7.setCursor(origcur);
        B8.setCursor(origcur);
       
        C1.setCursor(origcur);
        C2.setCursor(origcur);
        C3.setCursor(origcur);
        C4.setCursor(origcur);
        C5.setCursor(origcur);
        C6.setCursor(origcur);
        C7.setCursor(origcur);
        C8.setCursor(origcur);
        
        D1.setCursor(origcur);
        D2.setCursor(origcur);
        D3.setCursor(origcur);
        D4.setCursor(origcur);
        D5.setCursor(origcur);
        D6.setCursor(origcur);
        D7.setCursor(origcur);
        D8.setCursor(origcur);
        
        E1.setCursor(origcur);
        E2.setCursor(origcur);
        E3.setCursor(origcur);
        E4.setCursor(origcur);
        E5.setCursor(origcur);
        E6.setCursor(origcur);
        E7.setCursor(origcur);
        E8.setCursor(origcur);
        
        F1.setCursor(origcur);
        F2.setCursor(origcur);
        F3.setCursor(origcur);
        F4.setCursor(origcur);
        F5.setCursor(origcur);
        F6.setCursor(origcur);
        F7.setCursor(origcur);
        F8.setCursor(origcur);
        
        G1.setCursor(origcur);
        G2.setCursor(origcur);
        G3.setCursor(origcur);
        G4.setCursor(origcur);
        G5.setCursor(origcur);
        G6.setCursor(origcur);
        G7.setCursor(origcur);
        G8.setCursor(origcur);
        
        H1.setCursor(origcur);
        H2.setCursor(origcur);
        H3.setCursor(origcur);
        H4.setCursor(origcur);
        H5.setCursor(origcur);
        H6.setCursor(origcur);
        H7.setCursor(origcur);
        H8.setCursor(origcur);
    }
    //======================================================
    
    //  To know the indicated piece and possible moves
    public void premovePiece(String pieceToMove, JLabel initial)
    {
        refreshHistory();
        possiblem.clear();
        
        switch(pieceToMove)
        {
            case "p1w" : 
                {
                    bufferpiece = pieceToMove;
                    bufferloc = initial.getName();

                    possiblem = p1w.movementW();

                    possiblemoves(possiblem);

                    break;
                }
            case "p2w" : 
                {
                    bufferpiece = pieceToMove;
                    bufferloc = initial.getName();

                    possiblem = p2w.movementW();

                    possiblemoves(possiblem);

                    break;
                }
            case "p3w" : 
                {
                    bufferpiece = pieceToMove;
                    bufferloc = initial.getName();

                    possiblem = p3w.movementW();

                    possiblemoves(possiblem);
                    break;
                }
            case "p4w" : 
                    {
                bufferpiece = pieceToMove;
                bufferloc = initial.getName();

                possiblem = p4w.movementW();

                possiblemoves(possiblem);
                break;
                    }
            case "p5w" : 
            {
                bufferpiece = pieceToMove;
                bufferloc = initial.getName();

                possiblem = p5w.movementW();

                possiblemoves(possiblem);
                break;
            }
            case "p6w" : 
            {
                bufferpiece = pieceToMove;
                bufferloc = initial.getName();

                possiblem = p6w.movementW();

                possiblemoves(possiblem);
                break;
            }
            case "p7w" : 
            {
                bufferpiece = pieceToMove;
                bufferloc = initial.getName();

                possiblem = p7w.movementW();

                possiblemoves(possiblem);
                break;
            }
            case "p8w" : 
            {
                bufferpiece = pieceToMove;
                bufferloc = initial.getName();

                possiblem = p8w.movementW();

                possiblemoves(possiblem);
                break;
            }
            case "p1b" : 
                    {
                        bufferpiece = pieceToMove;
                        bufferloc = initial.getName();
                        
                        possiblem = p1b.movementB();
                        
                        possiblemoves(possiblem);
                        
                        break;
                    }
            case "p2b" : 
                    {
                        bufferpiece = pieceToMove;
                        bufferloc = initial.getName();
                        
                        possiblem = p2b.movementB();
                        
                        possiblemoves(possiblem);
                        
                        break;
                    }
            case "p3b" : 
                    {
                        bufferpiece = pieceToMove;
                        bufferloc = initial.getName();
                        
                        possiblem = p3b.movementB();
                        
                        possiblemoves(possiblem);
                        break;
                    }
            case "p4b" : 
                    {
                bufferpiece = pieceToMove;
                bufferloc = initial.getName();

                possiblem = p4b.movementB();

                possiblemoves(possiblem);
                break;
                    }
            case "p5b" : 
            {
                bufferpiece = pieceToMove;
                bufferloc = initial.getName();

                possiblem = p5b.movementB();

                possiblemoves(possiblem);
                break;
            }
            case "p6b" : 
            {
                bufferpiece = pieceToMove;
                bufferloc = initial.getName();

                possiblem = p6b.movementB();

                possiblemoves(possiblem);
                break;
            }
            case "p7b" : 
            {
                bufferpiece = pieceToMove;
                bufferloc = initial.getName();

                possiblem = p7b.movementB();

                possiblemoves(possiblem);
                break;
            }
            case "p8b" : 
            {
                bufferpiece = pieceToMove;
                bufferloc = initial.getName();

                possiblem = p8b.movementB();

                possiblemoves(possiblem);
                break;
            }
            case "r1b" : 
            {
                bufferpiece = pieceToMove;
                bufferloc = initial.getName();

                possiblem = r1b.movement();

                possiblemoves(possiblem);
                break;
            }
            case "h1b" : 
            {
                bufferpiece = pieceToMove;
                bufferloc = initial.getName();

                possiblem = h1b.movement();

                possiblemoves(possiblem);
                break;
            }
            case "b1b" : 
            {
                bufferpiece = pieceToMove;
                bufferloc = initial.getName();

                possiblem = b1b.movement();

                possiblemoves(possiblem);
                break;
            }
            case "q1b" : 
            {
                bufferpiece = pieceToMove;
                bufferloc = initial.getName();

//                possiblem = q1b.movement();

                possiblemoves(possiblem);
                break;
            }
            case "k1b" : 
            {
                bufferpiece = pieceToMove;
                bufferloc = initial.getName();

                //possiblem = k1b.movement();

                possiblemoves(possiblem);
                break;
            }
            case "b2b" : 
            {
                bufferpiece = pieceToMove;
                bufferloc = initial.getName();

                possiblem = b2b.movement();

                possiblemoves(possiblem);
                break;
            }
            case "h2b" : 
            {
                bufferpiece = pieceToMove;
                bufferloc = initial.getName();

                possiblem = h2b.movement();

                possiblemoves(possiblem);
                break;
            }
            case "r2b" : 
            {
                bufferpiece = pieceToMove;
                bufferloc = initial.getName();

                possiblem = r2b.movement();

                possiblemoves(possiblem);
                break;
            }
            case "r1w" : 
            {
                bufferpiece = pieceToMove;
                bufferloc = initial.getName();

                possiblem = r1w.movement();

                possiblemoves(possiblem);
                
                if(bufferloc.equals("A1"))
                {
                    if(piecesAlive[0][3].equals(""))
                    {
                    } else {
                        A5.setBorder(orig);
                        A6.setBorder(orig);
                    }
                }
                break;
            }
            case "h1w" : 
            {
                bufferpiece = pieceToMove;
                bufferloc = initial.getName();

                possiblem = h1w.movement();

                possiblemoves(possiblem);
                break;
            }
            case "b1w" : 
            {
                bufferpiece = pieceToMove;
                bufferloc = initial.getName();

                possiblem = b1w.movement();

                possiblemoves(possiblem);
                break;
            }
            case "q1w" : 
            {
                bufferpiece = pieceToMove;
                bufferloc = initial.getName();

                //possiblem = q1w.movementW();

                possiblemoves(possiblem);
                break;
            }
            case "k1w" : 
            {
                bufferpiece = pieceToMove;
                bufferloc = initial.getName();

                //possiblem = k1w.movementW();

                possiblemoves(possiblem);
                break;
            }
            case "b2w" : 
            {
                bufferpiece = pieceToMove;
                bufferloc = initial.getName();

                possiblem = b2w.movement();

                possiblemoves(possiblem);
                break;
            }
            case "h2w" : 
            {
                bufferpiece = pieceToMove;
                bufferloc = initial.getName();

                possiblem = h2w.movement();

                possiblemoves(possiblem);
                break;
            }
            case "r2w" : 
            {
                bufferpiece = pieceToMove;
                bufferloc = initial.getName();

                possiblem = r2w.movement();

                possiblemoves(possiblem);
                
                
                break;
            }
            
        }
        
        outputToOpponent = "move," + bufferpiece + "," + bufferloc;
        
    }
    //======================================================
    
    //  To remove the piece in the two-dimensional array record
    public void removePiecesAlive()
    {
        String buff = bufferloc;
        
        switch(buff)
        {
            case "A1" : 
            {
                piecesAlive[0][0] = "";
                lblA1.setIcon(null);
                break;
            }
            case "A2" : 
            {
                piecesAlive[0][1] = "";
                lblA2.setIcon(null);
                break;
            }
            case "A3" : 
            {
                piecesAlive[0][2] = "";
                lblA3.setIcon(null);
                break;
            }
            case "A4" : 
            {
                piecesAlive[0][3] = "";
                lblA4.setIcon(null);
                break;
            }
            case "A5" : 
            {
                piecesAlive[0][4] = "";
                lblA5.setIcon(null);
                break;
            }
            case "A6" : 
            {
                piecesAlive[0][5] = "";
                lblA6.setIcon(null);
                break;
            }
            case "A7" : 
            {
                piecesAlive[0][6] = "";
                lblA7.setIcon(null);
                break;
            }
            case "A8" : 
            {
                piecesAlive[0][7] = "";
                lblA8.setIcon(null);
                break;
            }
            
            case "B1" : 
            {
                piecesAlive[1][0] = "";
                lblB1.setIcon(null);
                break;
            }
            case "B2" : 
            {
                piecesAlive[1][1] = "";
                lblB2.setIcon(null);
                break;
            }
            case "B3" : 
            {
                piecesAlive[1][2] = "";
                lblB3.setIcon(null);
                break;
            }
            case "B4" : 
            {
                piecesAlive[1][3] = "";
                lblB4.setIcon(null);
                break;
            }
            case "B5" : 
            {
                piecesAlive[1][4] = "";
                lblB5.setIcon(null);
                break;
            }
            case "B6" : 
            {
                piecesAlive[1][5] = "";
                lblB6.setIcon(null);
                break;
            }
            case "B7" : 
            {
                piecesAlive[1][6] = "";
                lblB7.setIcon(null);
                break;
            }
            case "B8" : 
            {
                piecesAlive[1][7] = "";
                lblB8.setIcon(null);
                break;
            }
            
            case "C1" : 
            {
                piecesAlive[2][0] = "";
                lblC1.setIcon(null);
                break;
            }
            case "C2" : 
            {
                piecesAlive[2][1] = "";
                lblC2.setIcon(null);
                break;
            }
            case "C3" : 
            {
                piecesAlive[2][2] = "";
                lblC3.setIcon(null);
                break;
            }
            case "C4" : 
            {
                piecesAlive[2][3] = "";
                lblC4.setIcon(null);
                break;
            }
            case "C5" : 
            {
                piecesAlive[2][4] = "";
                lblC5.setIcon(null);
                break;
            }
            case "C6" : 
            {
                piecesAlive[2][5] = "";
                lblC6.setIcon(null);
                break;
            }
            case "C7" : 
            {
                piecesAlive[2][6] = "";
                lblC7.setIcon(null);
                break;
            }
            case "C8" : 
            {
                piecesAlive[2][7] = "";
                lblC8.setIcon(null);
                break;
            }
            
            case "D1" : 
            {
                piecesAlive[3][0] = "";
                lblD1.setIcon(null);
                break;
            }
            case "D2" : 
            {
                piecesAlive[3][1] = "";
                lblD2.setIcon(null);
                break;
            }
            case "D3" : 
            {
                piecesAlive[3][2] = "";
                lblD3.setIcon(null);
                break;
            }
            case "D4" : 
            {
                piecesAlive[3][3] = "";
                lblD4.setIcon(null);
                break;
            }
            case "D5" : 
            {
                piecesAlive[3][4] = "";
                lblD5.setIcon(null);
                break;
            }
            case "D6" : 
            {
                piecesAlive[3][5] = "";
                lblD6.setIcon(null);
                break;
            }
            case "D7" : 
            {
                piecesAlive[3][6] = "";
                lblD7.setIcon(null);
                break;
            }
            case "D8" : 
            {
                piecesAlive[3][7] = "";
                lblD8.setIcon(null);
                break;
            }
            
            case "E1" : 
            {
                piecesAlive[4][0] = "";
                lblE1.setIcon(null);
                break;
            }
            case "E2" : 
            {
                piecesAlive[4][1] = "";
                lblE2.setIcon(null);
                break;
            }
            case "E3" : 
            {
                piecesAlive[4][2] = "";
                lblE3.setIcon(null);
                break;
            }
            case "E4" : 
            {
                piecesAlive[4][3] = "";
                lblE4.setIcon(null);
                break;
            }
            case "E5" : 
            {
                piecesAlive[4][4] = "";
                lblE5.setIcon(null);
                break;
            }
            case "E6" : 
            {
                piecesAlive[4][5] = "";
                lblE6.setIcon(null);
                break;
            }
            case "E7" : 
            {
                piecesAlive[4][6] = "";
                lblE7.setIcon(null);
                break;
            }
            case "E8" : 
            {
                piecesAlive[4][7] = "";
                lblE8.setIcon(null);
                break;
            }
            
            case "F1" : 
            {
                piecesAlive[5][0] = "";
                lblF1.setIcon(null);
                break;
            }
            case "F2" : 
            {
                piecesAlive[5][1] = "";
                lblF2.setIcon(null);
                break;
            }
            case "F3" : 
            {
                piecesAlive[5][2] = "";
                lblF3.setIcon(null);
                break;
            }
            case "F4" : 
            {
                piecesAlive[5][3] = "";
                lblF4.setIcon(null);
                break;
            }
            case "F5" : 
            {
                piecesAlive[5][4] = "";
                lblF5.setIcon(null);
                break;
            }
            case "F6" : 
            {
                piecesAlive[5][5] = "";
                lblF6.setIcon(null);
                break;
            }
            case "F7" : 
            {
                piecesAlive[5][6] = "";
                lblF7.setIcon(null);
                break;
            }
            case "F8" : 
            {
                piecesAlive[5][7] = "";
                lblF8.setIcon(null);
                break;
            }
            
            case "G1" : 
            {
                piecesAlive[6][0] = "";
                lblG1.setIcon(null);
                break;
            }
            case "G2" : 
            {
                piecesAlive[6][1] = "";
                lblG2.setIcon(null);
                break;
            }
            case "G3" : 
            {
                piecesAlive[6][2] = "";
                lblG3.setIcon(null);
                break;
            }
            case "G4" : 
            {
                piecesAlive[6][3] = "";
                lblG4.setIcon(null);
                break;
            }
            case "G5" : 
            {
                piecesAlive[6][4] = "";
                lblG5.setIcon(null);
                break;
            }
            case "G6" : 
            {
                piecesAlive[6][5] = "";
                lblG6.setIcon(null);
                break;
            }
            case "G7" : 
            {
                piecesAlive[6][6] = "";
                lblG7.setIcon(null);
                break;
            }
            case "G8" : 
            {
                piecesAlive[6][7] = "";
                lblG8.setIcon(null);
                break;
            }
            
            case "H1" : 
            {
                piecesAlive[7][0] = "";
                lblH1.setIcon(null);
                break;
            }
            case "H2" : 
            {
                piecesAlive[7][1] = "";
                lblH2.setIcon(null);
                break;
            }
            case "H3" : 
            {
                piecesAlive[7][2] = "";
                lblH3.setIcon(null);
                break;
            }
            case "H4" : 
            {
                piecesAlive[7][3] = "";
                lblH4.setIcon(null);
                break;
            }
            case "H5" : 
            {
                piecesAlive[7][4] = "";
                lblH5.setIcon(null);
                break;
            }
            case "H6" : 
            {
                piecesAlive[7][5] = "";
                lblH6.setIcon(null);
                break;
            }
            case "H7" : 
            {
                piecesAlive[7][6] = "";
                lblH7.setIcon(null);
                break;
            }
            case "H8" : 
            {
                piecesAlive[7][7] = "";
                lblH8.setIcon(null);
                break;
            }
        }
    }
    
    //  To set a knight
    public void setterOfPieceKnight(String name, String destination, ImageIcon pieceToSet, KnightPiece piece)
    {
        
        switch(destination)
        {
            case "A1" : 
            {   
                piecesAlive[0][0] = name;
                removePiecesAlive();
                lblA1.setIcon(pieceToSet);
                piece.location = "A1";

                refreshHistory();
            }break;
            case "A2" : 
            {   
                piecesAlive[0][1] = name;
                removePiecesAlive();
                lblA2.setIcon(pieceToSet);
                piece.location = "A2";

                refreshHistory();
            }break;
            case "A3" : 
            {   
                piecesAlive[0][2] = name;
                removePiecesAlive();
                lblA3.setIcon(pieceToSet);
                piece.location = "A3";

                refreshHistory();
            }break;
            case "A4" : 
            {   
                piecesAlive[0][3] = name;
                removePiecesAlive();
                lblA4.setIcon(pieceToSet);
                piece.location = "A4";

                refreshHistory();
            }break;
            case "A5" : 
            {   
                piecesAlive[0][4] = name;
                removePiecesAlive();
                lblA5.setIcon(pieceToSet);
                piece.location = "A5";

                refreshHistory();
            }break;
            case "A6" : 
            {   
                piecesAlive[0][5] = name;
                removePiecesAlive();
                lblA6.setIcon(pieceToSet);
                piece.location = "A6";

                refreshHistory();
            }break;
            case "A7" : 
            {   
                piecesAlive[0][6] = name;
                removePiecesAlive();
                lblA7.setIcon(pieceToSet);
                piece.location = "A7";

                refreshHistory();
            }break;
            case "A8" : 
            {   
                piecesAlive[0][7] = name;
                removePiecesAlive();
                lblA8.setIcon(pieceToSet);
                piece.location = "A8";

                refreshHistory();
            }break;
            case "B1" : 
            {   
                piecesAlive[1][0] = name;
                removePiecesAlive();
                lblB1.setIcon(pieceToSet);
                piece.location = "B1";

                refreshHistory();
            }break;
            case "B2" : 
            {   
                piecesAlive[1][1] = name;
                removePiecesAlive();
                lblB2.setIcon(pieceToSet);
                piece.location = "B2";

                refreshHistory();
            }break;
            case "B3" : 
            {   
                piecesAlive[1][2] = name;
                removePiecesAlive();
                lblB3.setIcon(pieceToSet);
                piece.location = "B3";

                refreshHistory();
            }break;
            case "B4" : 
            {   
                piecesAlive[1][3] = name;
                removePiecesAlive();
                lblB4.setIcon(pieceToSet);
                piece.location = "B4";

                refreshHistory();
            }break;
            case "B5" : 
            {   
                piecesAlive[1][4] = name;
                removePiecesAlive();
                lblB5.setIcon(pieceToSet);
                piece.location = "B5";

                refreshHistory();
            }break;
            case "B6" : 
            {   
                piecesAlive[1][5] = name;
                removePiecesAlive();
                lblB6.setIcon(pieceToSet);
                piece.location = "B6";

                refreshHistory();
            }break;
            case "B7" : 
            {   
                piecesAlive[1][6] = name;
                removePiecesAlive();
                lblB7.setIcon(pieceToSet);
                piece.location = "B7";

                refreshHistory();
            }break;
            case "B8" : 
            {   
                piecesAlive[1][7] = name;
                removePiecesAlive();
                lblB8.setIcon(pieceToSet);
                piece.location = "B8";

                refreshHistory();
            }break;
            case "C1" : 
            {   
                piecesAlive[2][0] = name;
                removePiecesAlive();
                lblC1.setIcon(pieceToSet);
                piece.location = "C1";

                refreshHistory();
            }break;
            case "C2" : 
            {   
                piecesAlive[2][1] = name;
                removePiecesAlive();
                lblC2.setIcon(pieceToSet);
                piece.location = "C2";

                refreshHistory();
            }break;
            case "C3" : 
            {   
                piecesAlive[2][2] = name;
                removePiecesAlive();
                lblC3.setIcon(pieceToSet);
                piece.location = "C3";

                refreshHistory();
            }break;
            case "C4" : 
            {   
                piecesAlive[2][3] = name;
                removePiecesAlive();
                lblC4.setIcon(pieceToSet);
                piece.location = "C4";

                refreshHistory();
            }break;
            case "C5" : 
            {   
                piecesAlive[2][4] = name;
                removePiecesAlive();
                lblC5.setIcon(pieceToSet);
                piece.location = "C5";

                refreshHistory();
            }break;
            case "C6" : 
            {   
                piecesAlive[2][5] = name;
                removePiecesAlive();
                lblC6.setIcon(pieceToSet);
                piece.location = "C6";

                refreshHistory();
            }break;
            case "C7" : 
            {   
                piecesAlive[2][6] = name;
                removePiecesAlive();
                lblC7.setIcon(pieceToSet);
                piece.location = "C7";

                refreshHistory();
            }break;
            case "C8" : 
            {   
                piecesAlive[2][7] = name;
                removePiecesAlive();
                lblC8.setIcon(pieceToSet);
                piece.location = "C8";

                refreshHistory();
            }break;
            case "D1" : 
            {   
                piecesAlive[3][0] = name;
                removePiecesAlive();
                lblD1.setIcon(pieceToSet);
                piece.location = "D1";

                refreshHistory();
            }break;
            case "D2" : 
            {   
                piecesAlive[3][1] = name;
                removePiecesAlive();
                lblD2.setIcon(pieceToSet);
                piece.location = "D2";

                refreshHistory();
            }break;
            case "D3" : 
            {   
                piecesAlive[3][2] = name;
                removePiecesAlive();
                lblD3.setIcon(pieceToSet);
                piece.location = "D3";

                refreshHistory();
            }break;
            case "D4" : 
            {   
                piecesAlive[3][3] = name;
                removePiecesAlive();
                lblD4.setIcon(pieceToSet);
                piece.location = "D4";

                refreshHistory();
            }break;
            case "D5" : 
            {   
                piecesAlive[3][4] = name;
                removePiecesAlive();
                lblD5.setIcon(pieceToSet);
                piece.location = "D5";

                refreshHistory();
            }break;
            case "D6" : 
            {   
                piecesAlive[3][5] = name;
                removePiecesAlive();
                lblD6.setIcon(pieceToSet);
                piece.location = "D6";

                refreshHistory();
            }break;
            case "D7" : 
            {   
                piecesAlive[3][6] = name;
                removePiecesAlive();
                lblD7.setIcon(pieceToSet);
                piece.location = "D7";

                refreshHistory();
            }break;
            case "D8" : 
            {   
                piecesAlive[3][7] = name;
                removePiecesAlive();
                lblD8.setIcon(pieceToSet);
                piece.location = "D8";

                refreshHistory();
            }break;
            case "E1" : 
            {   
                piecesAlive[4][0] = name;
                removePiecesAlive();
                lblE1.setIcon(pieceToSet);
                piece.location = "E1";

                refreshHistory();
            }break;
            case "E2" : 
            {   
                piecesAlive[4][1] = name;
                removePiecesAlive();
                lblE2.setIcon(pieceToSet);
                piece.location = "E2";

                refreshHistory();
            }break;
            case "E3" : 
            {   
                piecesAlive[4][2] = name;
                removePiecesAlive();
                lblE3.setIcon(pieceToSet);
                piece.location = "E3";

                refreshHistory();
            }break;
            case "E4" : 
            {   
                piecesAlive[4][3] = name;
                removePiecesAlive();
                lblE4.setIcon(pieceToSet);
                piece.location = "E4";

                refreshHistory();
            }break;
            case "E5" : 
            {   
                piecesAlive[4][4] = name;
                removePiecesAlive();
                lblE5.setIcon(pieceToSet);
                piece.location = "E5";

                refreshHistory();
            }break;
            case "E6" : 
            {   
                piecesAlive[4][5] = name;
                removePiecesAlive();
                lblE6.setIcon(pieceToSet);
                piece.location = "E6";

                refreshHistory();
            }break;
            case "E7" : 
            {   
                piecesAlive[4][6] = name;
                removePiecesAlive();
                lblE7.setIcon(pieceToSet);
                piece.location = "E7";

                refreshHistory();
            }break;
            case "E8" : 
            {   
                piecesAlive[4][7] = name;
                removePiecesAlive();
                lblE8.setIcon(pieceToSet);
                piece.location = "E8";

                refreshHistory();
            }break;
            case "F1" : 
            {   
                piecesAlive[5][0] = name;
                removePiecesAlive();
                lblF1.setIcon(pieceToSet);
                piece.location = "F1";

                refreshHistory();
            }break;
            case "F2" : 
            {   
                piecesAlive[5][1] = name;
                removePiecesAlive();
                lblF2.setIcon(pieceToSet);
                piece.location = "F2";

                refreshHistory();
            }break;
            case "F3" : 
            {   
                piecesAlive[5][2] = name;
                removePiecesAlive();
                lblF3.setIcon(pieceToSet);
                piece.location = "F3";

                refreshHistory();
            }break;
            case "F4" : 
            {   
                piecesAlive[5][3] = name;
                removePiecesAlive();
                lblF4.setIcon(pieceToSet);
                piece.location = "F4";

                refreshHistory();
            }break;
            case "F5" : 
            {   
                piecesAlive[5][4] = name;
                removePiecesAlive();
                lblF5.setIcon(pieceToSet);
                piece.location = "F5";

                refreshHistory();
            }break;
            case "F6" : 
            {   
                piecesAlive[5][5] = name;
                removePiecesAlive();
                lblF6.setIcon(pieceToSet);
                piece.location = "F6";

                refreshHistory();
            }break;
            case "F7" : 
            {   
                piecesAlive[5][6] = name;
                removePiecesAlive();
                lblF7.setIcon(pieceToSet);
                piece.location = "F7";

                refreshHistory();
            }break;
            case "F8" : 
            {   
                piecesAlive[5][7] = name;
                removePiecesAlive();
                lblF8.setIcon(pieceToSet);
                piece.location = "F8";

                refreshHistory();
            }break;
            case "G1" : 
            {   
                piecesAlive[6][0] = name;
                removePiecesAlive();
                lblG1.setIcon(pieceToSet);
                piece.location = "G1";

                refreshHistory();
            }break;
            case "G2" : 
            {   
                piecesAlive[6][1] = name;
                removePiecesAlive();
                lblG2.setIcon(pieceToSet);
                piece.location = "G2";

                refreshHistory();
            }break;
            case "G3" : 
            {   
                piecesAlive[6][2] = name;
                removePiecesAlive();
                lblG3.setIcon(pieceToSet);
                piece.location = "G3";

                refreshHistory();
            }break;
            case "G4" : 
            {   
                piecesAlive[6][3] = name;
                removePiecesAlive();
                lblG4.setIcon(pieceToSet);
                piece.location = "G4";

                refreshHistory();
            }break;
            case "G5" : 
            {   
                piecesAlive[6][4] = name;
                removePiecesAlive();
                lblG5.setIcon(pieceToSet);
                piece.location = "G5";

                refreshHistory();
            }break;
            case "G6" : 
            {   
                piecesAlive[6][5] = name;
                removePiecesAlive();
                lblG6.setIcon(pieceToSet);
                piece.location = "G6";

                refreshHistory();
            }break;
            case "G7" : 
            {   
                piecesAlive[6][6] = name;
                removePiecesAlive();
                lblG7.setIcon(pieceToSet);
                piece.location = "G7";

                refreshHistory();
            }break;
            case "G8" : 
            {   
                piecesAlive[6][7] = name;
                removePiecesAlive();
                lblG8.setIcon(pieceToSet);
                piece.location = "G8";

                refreshHistory();
            }break;
            case "H1" : 
            {   
                piecesAlive[7][0] = name;
                removePiecesAlive();
                lblH1.setIcon(pieceToSet);
                piece.location = "H1";

                refreshHistory();
            }break;
            case "H2" : 
            {   
                piecesAlive[7][1] = name;
                removePiecesAlive();
                lblH2.setIcon(pieceToSet);
                piece.location = "H2";

                refreshHistory();
            }break;
            case "H3" : 
            {   
                piecesAlive[7][2] = name;
                removePiecesAlive();
                lblH3.setIcon(pieceToSet);
                piece.location = "H3";

                refreshHistory();
            }break;
            case "H4" : 
            {   
                piecesAlive[7][3] = name;
                removePiecesAlive();
                lblH4.setIcon(pieceToSet);
                piece.location = "H4";

                refreshHistory();
            }break;
            case "H5" : 
            {   
                piecesAlive[7][4] = name;
                removePiecesAlive();
                lblH5.setIcon(pieceToSet);
                piece.location = "H5";

                refreshHistory();
            }break;
            case "H6" : 
            {   
                piecesAlive[7][5] = name;
                removePiecesAlive();
                lblH6.setIcon(pieceToSet);
                piece.location = "H6";

                refreshHistory();
            }break;
            case "H7" : 
            {   
                piecesAlive[7][6] = name;
                removePiecesAlive();
                lblH7.setIcon(pieceToSet);
                piece.location = "H7";

                refreshHistory();
            }break;
            case "H8" : 
            {   
                piecesAlive[7][7] = name;
                removePiecesAlive();
                lblH8.setIcon(pieceToSet);
                piece.location = "H8";

                refreshHistory();
            }break;

        }
    }
    //======================================================
    
    //  To set a bishop
    public void setterOfPieceBishop(String name, String destination, ImageIcon pieceToSet, BishopPiece piece)
    {
        
        switch(destination)
        {
            case "A1" : 
            {   
                piecesAlive[0][0] = name;
                removePiecesAlive();
                lblA1.setIcon(pieceToSet);
                piece.location = "A1";

                refreshHistory();
            }break;
            case "A2" : 
            {   
                piecesAlive[0][1] = name;
                removePiecesAlive();
                lblA2.setIcon(pieceToSet);
                piece.location = "A2";

                refreshHistory();
            }break;
            case "A3" : 
            {   
                piecesAlive[0][2] = name;
                removePiecesAlive();
                lblA3.setIcon(pieceToSet);
                piece.location = "A3";

                refreshHistory();
            }break;
            case "A4" : 
            {   
                piecesAlive[0][3] = name;
                removePiecesAlive();
                lblA4.setIcon(pieceToSet);
                piece.location = "A4";

                refreshHistory();
            }break;
            case "A5" : 
            {   
                piecesAlive[0][4] = name;
                removePiecesAlive();
                lblA5.setIcon(pieceToSet);
                piece.location = "A5";

                refreshHistory();
            }break;
            case "A6" : 
            {   
                piecesAlive[0][5] = name;
                removePiecesAlive();
                lblA6.setIcon(pieceToSet);
                piece.location = "A6";

                refreshHistory();
            }break;
            case "A7" : 
            {   
                piecesAlive[0][6] = name;
                removePiecesAlive();
                lblA7.setIcon(pieceToSet);
                piece.location = "A7";

                refreshHistory();
            }break;
            case "A8" : 
            {   
                piecesAlive[0][7] = name;
                removePiecesAlive();
                lblA8.setIcon(pieceToSet);
                piece.location = "A8";

                refreshHistory();
            }break;
            case "B1" : 
            {   
                piecesAlive[1][0] = name;
                removePiecesAlive();
                lblB1.setIcon(pieceToSet);
                piece.location = "B1";

                refreshHistory();
            }break;
            case "B2" : 
            {   
                piecesAlive[1][1] = name;
                removePiecesAlive();
                lblB2.setIcon(pieceToSet);
                piece.location = "B2";

                refreshHistory();
            }break;
            case "B3" : 
            {   
                piecesAlive[1][2] = name;
                removePiecesAlive();
                lblB3.setIcon(pieceToSet);
                piece.location = "B3";

                refreshHistory();
            }break;
            case "B4" : 
            {   
                piecesAlive[1][3] = name;
                removePiecesAlive();
                lblB4.setIcon(pieceToSet);
                piece.location = "B4";

                refreshHistory();
            }break;
            case "B5" : 
            {   
                piecesAlive[1][4] = name;
                removePiecesAlive();
                lblB5.setIcon(pieceToSet);
                piece.location = "B5";

                refreshHistory();
            }break;
            case "B6" : 
            {   
                piecesAlive[1][5] = name;
                removePiecesAlive();
                lblB6.setIcon(pieceToSet);
                piece.location = "B6";

                refreshHistory();
            }break;
            case "B7" : 
            {   
                piecesAlive[1][6] = name;
                removePiecesAlive();
                lblB7.setIcon(pieceToSet);
                piece.location = "B7";

                refreshHistory();
            }break;
            case "B8" : 
            {   
                piecesAlive[1][7] = name;
                removePiecesAlive();
                lblB8.setIcon(pieceToSet);
                piece.location = "B8";

                refreshHistory();
            }break;
            case "C1" : 
            {   
                piecesAlive[2][0] = name;
                removePiecesAlive();
                lblC1.setIcon(pieceToSet);
                piece.location = "C1";

                refreshHistory();
            }break;
            case "C2" : 
            {   
                piecesAlive[2][1] = name;
                removePiecesAlive();
                lblC2.setIcon(pieceToSet);
                piece.location = "C2";

                refreshHistory();
            }break;
            case "C3" : 
            {   
                piecesAlive[2][2] = name;
                removePiecesAlive();
                lblC3.setIcon(pieceToSet);
                piece.location = "C3";

                refreshHistory();
            }break;
            case "C4" : 
            {   
                piecesAlive[2][3] = name;
                removePiecesAlive();
                lblC4.setIcon(pieceToSet);
                piece.location = "C4";

                refreshHistory();
            }break;
            case "C5" : 
            {   
                piecesAlive[2][4] = name;
                removePiecesAlive();
                lblC5.setIcon(pieceToSet);
                piece.location = "C5";

                refreshHistory();
            }break;
            case "C6" : 
            {   
                piecesAlive[2][5] = name;
                removePiecesAlive();
                lblC6.setIcon(pieceToSet);
                piece.location = "C6";

                refreshHistory();
            }break;
            case "C7" : 
            {   
                piecesAlive[2][6] = name;
                removePiecesAlive();
                lblC7.setIcon(pieceToSet);
                piece.location = "C7";

                refreshHistory();
            }break;
            case "C8" : 
            {   
                piecesAlive[2][7] = name;
                removePiecesAlive();
                lblC8.setIcon(pieceToSet);
                piece.location = "C8";

                refreshHistory();
            }break;
            case "D1" : 
            {   
                piecesAlive[3][0] = name;
                removePiecesAlive();
                lblD1.setIcon(pieceToSet);
                piece.location = "D1";

                refreshHistory();
            }break;
            case "D2" : 
            {   
                piecesAlive[3][1] = name;
                removePiecesAlive();
                lblD2.setIcon(pieceToSet);
                piece.location = "D2";

                refreshHistory();
            }break;
            case "D3" : 
            {   
                piecesAlive[3][2] = name;
                removePiecesAlive();
                lblD3.setIcon(pieceToSet);
                piece.location = "D3";

                refreshHistory();
            }break;
            case "D4" : 
            {   
                piecesAlive[3][3] = name;
                removePiecesAlive();
                lblD4.setIcon(pieceToSet);
                piece.location = "D4";

                refreshHistory();
            }break;
            case "D5" : 
            {   
                piecesAlive[3][4] = name;
                removePiecesAlive();
                lblD5.setIcon(pieceToSet);
                piece.location = "D5";

                refreshHistory();
            }break;
            case "D6" : 
            {   
                piecesAlive[3][5] = name;
                removePiecesAlive();
                lblD6.setIcon(pieceToSet);
                piece.location = "D6";

                refreshHistory();
            }break;
            case "D7" : 
            {   
                piecesAlive[3][6] = name;
                removePiecesAlive();
                lblD7.setIcon(pieceToSet);
                piece.location = "D7";

                refreshHistory();
            }break;
            case "D8" : 
            {   
                piecesAlive[3][7] = name;
                removePiecesAlive();
                lblD8.setIcon(pieceToSet);
                piece.location = "D8";

                refreshHistory();
            }break;
            case "E1" : 
            {   
                piecesAlive[4][0] = name;
                removePiecesAlive();
                lblE1.setIcon(pieceToSet);
                piece.location = "E1";

                refreshHistory();
            }break;
            case "E2" : 
            {   
                piecesAlive[4][1] = name;
                removePiecesAlive();
                lblE2.setIcon(pieceToSet);
                piece.location = "E2";

                refreshHistory();
            }break;
            case "E3" : 
            {   
                piecesAlive[4][2] = name;
                removePiecesAlive();
                lblE3.setIcon(pieceToSet);
                piece.location = "E3";

                refreshHistory();
            }break;
            case "E4" : 
            {   
                piecesAlive[4][3] = name;
                removePiecesAlive();
                lblE4.setIcon(pieceToSet);
                piece.location = "E4";

                refreshHistory();
            }break;
            case "E5" : 
            {   
                piecesAlive[4][4] = name;
                removePiecesAlive();
                lblE5.setIcon(pieceToSet);
                piece.location = "E5";

                refreshHistory();
            }break;
            case "E6" : 
            {   
                piecesAlive[4][5] = name;
                removePiecesAlive();
                lblE6.setIcon(pieceToSet);
                piece.location = "E6";

                refreshHistory();
            }break;
            case "E7" : 
            {   
                piecesAlive[4][6] = name;
                removePiecesAlive();
                lblE7.setIcon(pieceToSet);
                piece.location = "E7";

                refreshHistory();
            }break;
            case "E8" : 
            {   
                piecesAlive[4][7] = name;
                removePiecesAlive();
                lblE8.setIcon(pieceToSet);
                piece.location = "E8";

                refreshHistory();
            }break;
            case "F1" : 
            {   
                piecesAlive[5][0] = name;
                removePiecesAlive();
                lblF1.setIcon(pieceToSet);
                piece.location = "F1";

                refreshHistory();
            }break;
            case "F2" : 
            {   
                piecesAlive[5][1] = name;
                removePiecesAlive();
                lblF2.setIcon(pieceToSet);
                piece.location = "F2";

                refreshHistory();
            }break;
            case "F3" : 
            {   
                piecesAlive[5][2] = name;
                removePiecesAlive();
                lblF3.setIcon(pieceToSet);
                piece.location = "F3";

                refreshHistory();
            }break;
            case "F4" : 
            {   
                piecesAlive[5][3] = name;
                removePiecesAlive();
                lblF4.setIcon(pieceToSet);
                piece.location = "F4";

                refreshHistory();
            }break;
            case "F5" : 
            {   
                piecesAlive[5][4] = name;
                removePiecesAlive();
                lblF5.setIcon(pieceToSet);
                piece.location = "F5";

                refreshHistory();
            }break;
            case "F6" : 
            {   
                piecesAlive[5][5] = name;
                removePiecesAlive();
                lblF6.setIcon(pieceToSet);
                piece.location = "F6";

                refreshHistory();
            }break;
            case "F7" : 
            {   
                piecesAlive[5][6] = name;
                removePiecesAlive();
                lblF7.setIcon(pieceToSet);
                piece.location = "F7";

                refreshHistory();
            }break;
            case "F8" : 
            {   
                piecesAlive[5][7] = name;
                removePiecesAlive();
                lblF8.setIcon(pieceToSet);
                piece.location = "F8";

                refreshHistory();
            }break;
            case "G1" : 
            {   
                piecesAlive[6][0] = name;
                removePiecesAlive();
                lblG1.setIcon(pieceToSet);
                piece.location = "G1";

                refreshHistory();
            }break;
            case "G2" : 
            {   
                piecesAlive[6][1] = name;
                removePiecesAlive();
                lblG2.setIcon(pieceToSet);
                piece.location = "G2";

                refreshHistory();
            }break;
            case "G3" : 
            {   
                piecesAlive[6][2] = name;
                removePiecesAlive();
                lblG3.setIcon(pieceToSet);
                piece.location = "G3";

                refreshHistory();
            }break;
            case "G4" : 
            {   
                piecesAlive[6][3] = name;
                removePiecesAlive();
                lblG4.setIcon(pieceToSet);
                piece.location = "G4";

                refreshHistory();
            }break;
            case "G5" : 
            {   
                piecesAlive[6][4] = name;
                removePiecesAlive();
                lblG5.setIcon(pieceToSet);
                piece.location = "G5";

                refreshHistory();
            }break;
            case "G6" : 
            {   
                piecesAlive[6][5] = name;
                removePiecesAlive();
                lblG6.setIcon(pieceToSet);
                piece.location = "G6";

                refreshHistory();
            }break;
            case "G7" : 
            {   
                piecesAlive[6][6] = name;
                removePiecesAlive();
                lblG7.setIcon(pieceToSet);
                piece.location = "G7";

                refreshHistory();
            }break;
            case "G8" : 
            {   
                piecesAlive[6][7] = name;
                removePiecesAlive();
                lblG8.setIcon(pieceToSet);
                piece.location = "G8";

                refreshHistory();
            }break;
            case "H1" : 
            {   
                piecesAlive[7][0] = name;
                removePiecesAlive();
                lblH1.setIcon(pieceToSet);
                piece.location = "H1";

                refreshHistory();
            }break;
            case "H2" : 
            {   
                piecesAlive[7][1] = name;
                removePiecesAlive();
                lblH2.setIcon(pieceToSet);
                piece.location = "H2";

                refreshHistory();
            }break;
            case "H3" : 
            {   
                piecesAlive[7][2] = name;
                removePiecesAlive();
                lblH3.setIcon(pieceToSet);
                piece.location = "H3";

                refreshHistory();
            }break;
            case "H4" : 
            {   
                piecesAlive[7][3] = name;
                removePiecesAlive();
                lblH4.setIcon(pieceToSet);
                piece.location = "H4";

                refreshHistory();
            }break;
            case "H5" : 
            {   
                piecesAlive[7][4] = name;
                removePiecesAlive();
                lblH5.setIcon(pieceToSet);
                piece.location = "H5";

                refreshHistory();
            }break;
            case "H6" : 
            {   
                piecesAlive[7][5] = name;
                removePiecesAlive();
                lblH6.setIcon(pieceToSet);
                piece.location = "H6";

                refreshHistory();
            }break;
            case "H7" : 
            {   
                piecesAlive[7][6] = name;
                removePiecesAlive();
                lblH7.setIcon(pieceToSet);
                piece.location = "H7";

                refreshHistory();
            }break;
            case "H8" : 
            {   
                piecesAlive[7][7] = name;
                removePiecesAlive();
                lblH8.setIcon(pieceToSet);
                piece.location = "H8";

                refreshHistory();
            }break;

        }
    }
    //======================================================
    
    //  To set a rook
    public void setterOfPieceRook(String name, String destination, ImageIcon pieceToSet, RookPiece piece)
    {
        
        switch(destination)
        {
            case "A1" : 
            {   
                piecesAlive[0][0] = name;
                removePiecesAlive();
                lblA1.setIcon(pieceToSet);
                piece.location = "A1";

                refreshHistory();
            }break;
            case "A2" : 
            {   
                piecesAlive[0][1] = name;
                removePiecesAlive();
                lblA2.setIcon(pieceToSet);
                piece.location = "A2";

                refreshHistory();
            }break;
            case "A3" : 
            {   
                piecesAlive[0][2] = name;
                removePiecesAlive();
                lblA3.setIcon(pieceToSet);
                piece.location = "A3";

                refreshHistory();
            }break;
            case "A4" : 
            {   
                piecesAlive[0][3] = name;
                removePiecesAlive();
                lblA4.setIcon(pieceToSet);
                piece.location = "A4";

                refreshHistory();
            }break;
            case "A5" : 
            {   
                piecesAlive[0][4] = name;
                removePiecesAlive();
                lblA5.setIcon(pieceToSet);
                piece.location = "A5";

                refreshHistory();
            }break;
            case "A6" : 
            {   
                piecesAlive[0][5] = name;
                removePiecesAlive();
                lblA6.setIcon(pieceToSet);
                piece.location = "A6";

                refreshHistory();
            }break;
            case "A7" : 
            {   
                piecesAlive[0][6] = name;
                removePiecesAlive();
                lblA7.setIcon(pieceToSet);
                piece.location = "A7";

                refreshHistory();
            }break;
            case "A8" : 
            {   
                piecesAlive[0][7] = name;
                removePiecesAlive();
                lblA8.setIcon(pieceToSet);
                piece.location = "A8";

                refreshHistory();
            }break;
            case "B1" : 
            {   
                piecesAlive[1][0] = name;
                removePiecesAlive();
                lblB1.setIcon(pieceToSet);
                piece.location = "B1";

                refreshHistory();
            }break;
            case "B2" : 
            {   
                piecesAlive[1][1] = name;
                removePiecesAlive();
                lblB2.setIcon(pieceToSet);
                piece.location = "B2";

                refreshHistory();
            }break;
            case "B3" : 
            {   
                piecesAlive[1][2] = name;
                removePiecesAlive();
                lblB3.setIcon(pieceToSet);
                piece.location = "B3";

                refreshHistory();
            }break;
            case "B4" : 
            {   
                piecesAlive[1][3] = name;
                removePiecesAlive();
                lblB4.setIcon(pieceToSet);
                piece.location = "B4";

                refreshHistory();
            }break;
            case "B5" : 
            {   
                piecesAlive[1][4] = name;
                removePiecesAlive();
                lblB5.setIcon(pieceToSet);
                piece.location = "B5";

                refreshHistory();
            }break;
            case "B6" : 
            {   
                piecesAlive[1][5] = name;
                removePiecesAlive();
                lblB6.setIcon(pieceToSet);
                piece.location = "B6";

                refreshHistory();
            }break;
            case "B7" : 
            {   
                piecesAlive[1][6] = name;
                removePiecesAlive();
                lblB7.setIcon(pieceToSet);
                piece.location = "B7";

                refreshHistory();
            }break;
            case "B8" : 
            {   
                piecesAlive[1][7] = name;
                removePiecesAlive();
                lblB8.setIcon(pieceToSet);
                piece.location = "B8";

                refreshHistory();
            }break;
            case "C1" : 
            {   
                piecesAlive[2][0] = name;
                removePiecesAlive();
                lblC1.setIcon(pieceToSet);
                piece.location = "C1";

                refreshHistory();
            }break;
            case "C2" : 
            {   
                piecesAlive[2][1] = name;
                removePiecesAlive();
                lblC2.setIcon(pieceToSet);
                piece.location = "C2";

                refreshHistory();
            }break;
            case "C3" : 
            {   
                piecesAlive[2][2] = name;
                removePiecesAlive();
                lblC3.setIcon(pieceToSet);
                piece.location = "C3";

                refreshHistory();
            }break;
            case "C4" : 
            {   
                piecesAlive[2][3] = name;
                removePiecesAlive();
                lblC4.setIcon(pieceToSet);
                piece.location = "C4";

                refreshHistory();
            }break;
            case "C5" : 
            {   
                piecesAlive[2][4] = name;
                removePiecesAlive();
                lblC5.setIcon(pieceToSet);
                piece.location = "C5";

                refreshHistory();
            }break;
            case "C6" : 
            {   
                piecesAlive[2][5] = name;
                removePiecesAlive();
                lblC6.setIcon(pieceToSet);
                piece.location = "C6";

                refreshHistory();
            }break;
            case "C7" : 
            {   
                piecesAlive[2][6] = name;
                removePiecesAlive();
                lblC7.setIcon(pieceToSet);
                piece.location = "C7";

                refreshHistory();
            }break;
            case "C8" : 
            {   
                piecesAlive[2][7] = name;
                removePiecesAlive();
                lblC8.setIcon(pieceToSet);
                piece.location = "C8";

                refreshHistory();
            }break;
            case "D1" : 
            {   
                piecesAlive[3][0] = name;
                removePiecesAlive();
                lblD1.setIcon(pieceToSet);
                piece.location = "D1";

                refreshHistory();
            }break;
            case "D2" : 
            {   
                piecesAlive[3][1] = name;
                removePiecesAlive();
                lblD2.setIcon(pieceToSet);
                piece.location = "D2";

                refreshHistory();
            }break;
            case "D3" : 
            {   
                piecesAlive[3][2] = name;
                removePiecesAlive();
                lblD3.setIcon(pieceToSet);
                piece.location = "D3";

                refreshHistory();
            }break;
            case "D4" : 
            {   
                piecesAlive[3][3] = name;
                removePiecesAlive();
                lblD4.setIcon(pieceToSet);
                piece.location = "D4";

                refreshHistory();
            }break;
            case "D5" : 
            {   
                piecesAlive[3][4] = name;
                removePiecesAlive();
                lblD5.setIcon(pieceToSet);
                piece.location = "D5";

                refreshHistory();
            }break;
            case "D6" : 
            {   
                piecesAlive[3][5] = name;
                removePiecesAlive();
                lblD6.setIcon(pieceToSet);
                piece.location = "D6";

                refreshHistory();
            }break;
            case "D7" : 
            {   
                piecesAlive[3][6] = name;
                removePiecesAlive();
                lblD7.setIcon(pieceToSet);
                piece.location = "D7";

                refreshHistory();
            }break;
            case "D8" : 
            {   
                piecesAlive[3][7] = name;
                removePiecesAlive();
                lblD8.setIcon(pieceToSet);
                piece.location = "D8";

                refreshHistory();
            }break;
            case "E1" : 
            {   
                piecesAlive[4][0] = name;
                removePiecesAlive();
                lblE1.setIcon(pieceToSet);
                piece.location = "E1";

                refreshHistory();
            }break;
            case "E2" : 
            {   
                piecesAlive[4][1] = name;
                removePiecesAlive();
                lblE2.setIcon(pieceToSet);
                piece.location = "E2";

                refreshHistory();
            }break;
            case "E3" : 
            {   
                piecesAlive[4][2] = name;
                removePiecesAlive();
                lblE3.setIcon(pieceToSet);
                piece.location = "E3";

                refreshHistory();
            }break;
            case "E4" : 
            {   
                piecesAlive[4][3] = name;
                removePiecesAlive();
                lblE4.setIcon(pieceToSet);
                piece.location = "E4";

                refreshHistory();
            }break;
            case "E5" : 
            {   
                piecesAlive[4][4] = name;
                removePiecesAlive();
                lblE5.setIcon(pieceToSet);
                piece.location = "E5";

                refreshHistory();
            }break;
            case "E6" : 
            {   
                piecesAlive[4][5] = name;
                removePiecesAlive();
                lblE6.setIcon(pieceToSet);
                piece.location = "E6";

                refreshHistory();
            }break;
            case "E7" : 
            {   
                piecesAlive[4][6] = name;
                removePiecesAlive();
                lblE7.setIcon(pieceToSet);
                piece.location = "E7";

                refreshHistory();
            }break;
            case "E8" : 
            {   
                piecesAlive[4][7] = name;
                removePiecesAlive();
                lblE8.setIcon(pieceToSet);
                piece.location = "E8";

                refreshHistory();
            }break;
            case "F1" : 
            {   
                piecesAlive[5][0] = name;
                removePiecesAlive();
                lblF1.setIcon(pieceToSet);
                piece.location = "F1";

                refreshHistory();
            }break;
            case "F2" : 
            {   
                piecesAlive[5][1] = name;
                removePiecesAlive();
                lblF2.setIcon(pieceToSet);
                piece.location = "F2";

                refreshHistory();
            }break;
            case "F3" : 
            {   
                piecesAlive[5][2] = name;
                removePiecesAlive();
                lblF3.setIcon(pieceToSet);
                piece.location = "F3";

                refreshHistory();
            }break;
            case "F4" : 
            {   
                piecesAlive[5][3] = name;
                removePiecesAlive();
                lblF4.setIcon(pieceToSet);
                piece.location = "F4";

                refreshHistory();
            }break;
            case "F5" : 
            {   
                piecesAlive[5][4] = name;
                removePiecesAlive();
                lblF5.setIcon(pieceToSet);
                piece.location = "F5";

                refreshHistory();
            }break;
            case "F6" : 
            {   
                piecesAlive[5][5] = name;
                removePiecesAlive();
                lblF6.setIcon(pieceToSet);
                piece.location = "F6";

                refreshHistory();
            }break;
            case "F7" : 
            {   
                piecesAlive[5][6] = name;
                removePiecesAlive();
                lblF7.setIcon(pieceToSet);
                piece.location = "F7";

                refreshHistory();
            }break;
            case "F8" : 
            {   
                piecesAlive[5][7] = name;
                removePiecesAlive();
                lblF8.setIcon(pieceToSet);
                piece.location = "F8";

                refreshHistory();
            }break;
            case "G1" : 
            {   
                piecesAlive[6][0] = name;
                removePiecesAlive();
                lblG1.setIcon(pieceToSet);
                piece.location = "G1";

                refreshHistory();
            }break;
            case "G2" : 
            {   
                piecesAlive[6][1] = name;
                removePiecesAlive();
                lblG2.setIcon(pieceToSet);
                piece.location = "G2";

                refreshHistory();
            }break;
            case "G3" : 
            {   
                piecesAlive[6][2] = name;
                removePiecesAlive();
                lblG3.setIcon(pieceToSet);
                piece.location = "G3";

                refreshHistory();
            }break;
            case "G4" : 
            {   
                piecesAlive[6][3] = name;
                removePiecesAlive();
                lblG4.setIcon(pieceToSet);
                piece.location = "G4";

                refreshHistory();
            }break;
            case "G5" : 
            {   
                piecesAlive[6][4] = name;
                removePiecesAlive();
                lblG5.setIcon(pieceToSet);
                piece.location = "G5";

                refreshHistory();
            }break;
            case "G6" : 
            {   
                piecesAlive[6][5] = name;
                removePiecesAlive();
                lblG6.setIcon(pieceToSet);
                piece.location = "G6";

                refreshHistory();
            }break;
            case "G7" : 
            {   
                piecesAlive[6][6] = name;
                removePiecesAlive();
                lblG7.setIcon(pieceToSet);
                piece.location = "G7";

                refreshHistory();
            }break;
            case "G8" : 
            {   
                piecesAlive[6][7] = name;
                removePiecesAlive();
                lblG8.setIcon(pieceToSet);
                piece.location = "G8";

                refreshHistory();
            }break;
            case "H1" : 
            {   
                piecesAlive[7][0] = name;
                removePiecesAlive();
                lblH1.setIcon(pieceToSet);
                piece.location = "H1";

                refreshHistory();
            }break;
            case "H2" : 
            {   
                piecesAlive[7][1] = name;
                removePiecesAlive();
                lblH2.setIcon(pieceToSet);
                piece.location = "H2";

                refreshHistory();
            }break;
            case "H3" : 
            {   
                piecesAlive[7][2] = name;
                removePiecesAlive();
                lblH3.setIcon(pieceToSet);
                piece.location = "H3";

                refreshHistory();
            }break;
            case "H4" : 
            {   
                piecesAlive[7][3] = name;
                removePiecesAlive();
                lblH4.setIcon(pieceToSet);
                piece.location = "H4";

                refreshHistory();
            }break;
            case "H5" : 
            {   
                piecesAlive[7][4] = name;
                removePiecesAlive();
                lblH5.setIcon(pieceToSet);
                piece.location = "H5";

                refreshHistory();
            }break;
            case "H6" : 
            {   
                piecesAlive[7][5] = name;
                removePiecesAlive();
                lblH6.setIcon(pieceToSet);
                piece.location = "H6";

                refreshHistory();
            }break;
            case "H7" : 
            {   
                piecesAlive[7][6] = name;
                removePiecesAlive();
                lblH7.setIcon(pieceToSet);
                piece.location = "H7";

                refreshHistory();
            }break;
            case "H8" : 
            {   
                piecesAlive[7][7] = name;
                removePiecesAlive();
                lblH8.setIcon(pieceToSet);
                piece.location = "H8";

                refreshHistory();
            }break;

        }
    }
    //======================================================
    
    //  To move the indicated piece to an indicated position
    public void postmovePiece(String buffer, JPanel destination)
    {
        switch(buffer)
        {
            case "p1w" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "A3" : 
                        {   
                            piecesAlive[0][2] = "p1w";
                            piecesAlive[0][1] = "";

                            lblA2.setIcon(null);
                            lblA3.setIcon(pawnw);
                            p1w.location = "A3";

                            refreshHistory();
                        }break;
                        case "A4" : 
                        {   
                            if(p1w.moves == 1)
                            {   
                                piecesAlive[0][3] = "p1w";
                                piecesAlive[0][1] = "";

                                lblA2.setIcon(null);
                                lblA4.setIcon(pawnw);
                                p1w.location = "A4";

                                refreshHistory();
                            }
                            else if(p1w.moves >= 2)
                            {   
                                piecesAlive[0][3] = "p1w";
                                piecesAlive[0][2] = "";

                                lblA3.setIcon(null);
                                lblA4.setIcon(pawnw);
                                p1w.location = "A4";

                                refreshHistory();
                            }
                        }break;  
                        case "A5" : 
                        {   
                            piecesAlive[0][4] = "p1w";
                            piecesAlive[0][3] = "";

                            lblA4.setIcon(null);
                            lblA5.setIcon(pawnw);
                            p1w.location = "A5";

                            refreshHistory();
                        }break;
                        case "A6" : 
                        {   
                            piecesAlive[0][5] = "p1w";
                            piecesAlive[0][4] = "";

                            lblA5.setIcon(null);
                            lblA6.setIcon(pawnw);
                            p1w.location = "A6";

                            refreshHistory();
                        }break;
                        case "A7" : 
                        {   
                            piecesAlive[0][6] = "p1w";
                            piecesAlive[0][5] = "";

                            lblA6.setIcon(null);
                            lblA7.setIcon(pawnw);
                            p1w.location = "A7";

                            refreshHistory();
                        }break;
                        case "A8" : 
                        {   
                            piecesAlive[0][7] = "p1w";
                            piecesAlive[0][6] = "";

                            lblA7.setIcon(null);
                            lblA8.setIcon(pawnw);
                            p1w.location = "A8";

                            refreshHistory();
                        }break;
                    }
                }
            }
            case "p2w" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "B3" : 
                                {   
                                    System.out.println("hey");
                                    piecesAlive[1][2] = "p2w";
                                    piecesAlive[1][1] = "";

                                    lblB2.setIcon(null);
                                    lblB3.setIcon(pawnw);
                                    p2w.location = "B3";

                                    refreshHistory();
                                }break;
                        case "B4" : 
                                {   
                                    if(p2w.moves == 1)
                                    {   
                                        piecesAlive[1][3] = "p2w";
                                        piecesAlive[1][1] = "";

                                        lblB2.setIcon(null);
                                        lblB4.setIcon(pawnw);
                                        p2w.location = "B4";

                                        refreshHistory();
                                    }
                                    else if(p2w.moves >= 2)
                                    {   
                                        piecesAlive[1][3] = "p2w";
                                        piecesAlive[1][2] = "";

                                        lblB3.setIcon(null);
                                        lblB4.setIcon(pawnw);
                                        p2w.location = "B4";

                                        refreshHistory();
                                    }
                                }break;  
                        case "B5" : 
                                {   
                                    piecesAlive[1][4] = "p2w";
                                    piecesAlive[1][3] = "";

                                    lblB4.setIcon(null);
                                    lblB5.setIcon(pawnw);
                                    p2w.location = "B5";

                                    refreshHistory();
                                }break;
                        case "B6" : 
                                {   
                                    piecesAlive[1][5] = "p2w";
                                    piecesAlive[1][4] = "";

                                    lblB5.setIcon(null);
                                    lblB6.setIcon(pawnw);
                                    p2w.location = "B6";

                                    refreshHistory();
                                }break;
                        case "B7" : 
                                {   
                                    piecesAlive[1][6] = "p2w";
                                    piecesAlive[1][5] = "";

                                    lblB6.setIcon(null);
                                    lblB7.setIcon(pawnw);
                                    p2w.location = "B7";

                                    refreshHistory();
                                }break;
                        case "B8" : 
                        {   
                            piecesAlive[1][7] = "p2w";
                            piecesAlive[1][6] = "";

                            lblB7.setIcon(null);
                            lblB8.setIcon(pawnw);
                            p2w.location = "B8";

                            refreshHistory();
                        }break;
                    }
                }
            }      
            case "p3w" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "C3" : 
                        {   
                            piecesAlive[2][2] = "p3w";
                            piecesAlive[2][1] = "";

                            lblC2.setIcon(null);
                            lblC3.setIcon(pawnw);
                            p3w.location = "C3";

                            refreshHistory();
                        }break;
                        case "C4" : 
                        {   
                            if(p3w.moves == 1)
                            {   
                                piecesAlive[2][3] = "p3w";
                                piecesAlive[2][1] = "";

                                lblC2.setIcon(null);
                                lblC4.setIcon(pawnw);
                                p3w.location = "C4";

                                refreshHistory();
                            }
                            else if(p3w.moves >= 2)
                            {   
                                piecesAlive[2][3] = "p3w";
                                piecesAlive[2][2] = "";

                                lblC3.setIcon(null);
                                lblC4.setIcon(pawnw);
                                p3w.location = "C4";

                                refreshHistory();
                            }
                        }break;  
                        case "C5" : 
                        {   
                            piecesAlive[2][4] = "p3w";
                            piecesAlive[2][3] = "";

                            lblC4.setIcon(null);
                            lblC5.setIcon(pawnw);
                            p3w.location = "C5";

                            refreshHistory();
                        }break;
                        case "C6" : 
                        {   
                            piecesAlive[2][5] = "p3w";
                            piecesAlive[2][4] = "";

                            lblC5.setIcon(null);
                            lblC6.setIcon(pawnw);
                            p3w.location = "C6";

                            refreshHistory();
                        }break;
                        case "C7" : 
                        {   
                            piecesAlive[2][6] = "p3w";
                            piecesAlive[2][5] = "";

                            lblC6.setIcon(null);
                            lblC7.setIcon(pawnw);
                            p3w.location = "C7";

                            refreshHistory();
                        }break;
                        case "C8" : 
                        {   
                            piecesAlive[2][7] = "p3w";
                            piecesAlive[2][6] = "";

                            lblC7.setIcon(null);
                            lblC8.setIcon(pawnw);
                            p3w.location = "C8";

                            refreshHistory();
                        }break;
                    }
                }
            }
            case "p4w" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "D3" : 
                        {   
                            piecesAlive[3][2] = "p4w";
                            piecesAlive[3][1] = "";

                            lblD2.setIcon(null);
                            lblD3.setIcon(pawnw);
                            p4w.location = "D3";

                            refreshHistory();
                        }break;
                        case "D4" : 
                        {   
                            if(p4w.moves == 1)
                            {   
                                piecesAlive[3][3] = "p4w";
                                piecesAlive[3][1] = "";

                                lblD2.setIcon(null);
                                lblD4.setIcon(pawnw);
                                p4w.location = "D4";

                                refreshHistory();
                            }
                            else if(p4w.moves >= 2)
                            {   
                                piecesAlive[3][3] = "p4w";
                                piecesAlive[3][2] = "";

                                lblD3.setIcon(null);
                                lblD4.setIcon(pawnw);
                                p4w.location = "D4";

                                refreshHistory();
                            }
                        }break;  
                        case "D5" : 
                        {   
                            piecesAlive[3][4] = "p4w";
                            piecesAlive[3][3] = "";

                            lblD4.setIcon(null);
                            lblD5.setIcon(pawnw);
                            p4w.location = "D5";

                            refreshHistory();
                        }break;
                        case "D6" : 
                        {   
                            piecesAlive[3][5] = "p4w";
                            piecesAlive[3][4] = "";

                            lblD5.setIcon(null);
                            lblD6.setIcon(pawnw);
                            p4w.location = "D6";

                            refreshHistory();
                        }break;
                        case "D7" : 
                        {   
                            piecesAlive[3][6] = "p4w";
                            piecesAlive[3][5] = "";

                            lblD6.setIcon(null);
                            lblD7.setIcon(pawnw);
                            p4w.location = "D7";

                            refreshHistory();
                        }break;
                        case "D8" : 
                        {   
                            piecesAlive[3][7] = "p4w";
                            piecesAlive[3][6] = "";

                            lblD7.setIcon(null);
                            lblD8.setIcon(pawnw);
                            p4w.location = "D8";

                            refreshHistory();
                        }break;
                    }
                }
            }
            case "p5w" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "E3" : 
                        {   
                            piecesAlive[4][2] = "p5w";
                            piecesAlive[4][1] = "";

                            lblE2.setIcon(null);
                            lblE3.setIcon(pawnw);
                            p5w.location = "E3";

                            refreshHistory();
                        }break;
                        case "E4" : 
                        {   
                            if(p5w.moves == 1)
                            {   
                                piecesAlive[4][3] = "p5w";
                                piecesAlive[4][1] = "";

                                lblE2.setIcon(null);
                                lblE4.setIcon(pawnw);
                                p5w.location = "E4";

                                refreshHistory();
                            }
                            else if(p5w.moves >= 2)
                            {   
                                piecesAlive[4][3] = "p5w";
                                piecesAlive[4][2] = "";

                                lblE3.setIcon(null);
                                lblE4.setIcon(pawnw);
                                p5w.location = "E4";

                                refreshHistory();
                            }
                        }break;  
                        case "E5" : 
                        {   
                            piecesAlive[4][4] = "p5w";
                            piecesAlive[4][3] = "";

                            lblE4.setIcon(null);
                            lblE5.setIcon(pawnw);
                            p5w.location = "E5";

                            refreshHistory();
                        }break;
                        case "E6" : 
                        {   
                            piecesAlive[4][5] = "p5w";
                            piecesAlive[4][4] = "";

                            lblE5.setIcon(null);
                            lblE6.setIcon(pawnw);
                            p5w.location = "E6";

                            refreshHistory();
                        }break;
                        case "E7" : 
                        {   
                            piecesAlive[4][6] = "p5w";
                            piecesAlive[4][5] = "";

                            lblE6.setIcon(null);
                            lblE7.setIcon(pawnw);
                            p5w.location = "E7";

                            refreshHistory();
                        }break;
                        case "E8" : 
                        {   
                            piecesAlive[4][7] = "p5w";
                            piecesAlive[4][6] = "";

                            lblE7.setIcon(null);
                            lblE8.setIcon(pawnw);
                            p5w.location = "E8";

                            refreshHistory();
                        }break;
                    }
                }
            }
            case "p6w" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "F3" : 
                        {   
                            piecesAlive[5][2] = "p6w";
                            piecesAlive[5][1] = "";

                            lblF2.setIcon(null);
                            lblF3.setIcon(pawnw);
                            p6w.location = "F3";

                            refreshHistory();
                        }break;
                        case "F4" : 
                        {   
                            if(p6w.moves == 1)
                            {   
                                piecesAlive[5][3] = "p6w";
                                piecesAlive[5][1] = "";

                                lblF2.setIcon(null);
                                lblF4.setIcon(pawnw);
                                p6w.location = "F4";

                                refreshHistory();
                            }
                            else if(p6w.moves >= 2)
                            {   
                                piecesAlive[5][3] = "p6w";
                                piecesAlive[5][2] = "";

                                lblF3.setIcon(null);
                                lblF4.setIcon(pawnw);
                                p6w.location = "F4";

                                refreshHistory();
                            }
                        }break;  
                        case "F5" : 
                        {   
                            piecesAlive[5][4] = "p6w";
                            piecesAlive[5][3] = "";

                            lblF4.setIcon(null);
                            lblF5.setIcon(pawnw);
                            p6w.location = "F5";

                            refreshHistory();
                        }break;
                        case "F6" : 
                        {   
                            piecesAlive[5][5] = "p6w";
                            piecesAlive[5][4] = "";

                            lblF5.setIcon(null);
                            lblF6.setIcon(pawnw);
                            p6w.location = "F6";

                            refreshHistory();
                        }break;
                        case "F7" : 
                        {   
                            piecesAlive[5][6] = "p6w";
                            piecesAlive[5][5] = "";

                            lblF6.setIcon(null);
                            lblF7.setIcon(pawnw);
                            p6w.location = "F7";

                            refreshHistory();
                        }break;
                        case "F8" : 
                        {   
                            piecesAlive[5][7] = "p6w";
                            piecesAlive[5][6] = "";

                            lblF7.setIcon(null);
                            lblF8.setIcon(pawnw);
                            p6w.location = "F8";

                            refreshHistory();
                        }break;
                    }
                }
            }
            case "p7w" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "G3" : 
                        {   
                            piecesAlive[6][2] = "p7w";
                            piecesAlive[6][1] = "";

                            lblG2.setIcon(null);
                            lblG3.setIcon(pawnw);
                            p7w.location = "G3";

                            refreshHistory();
                        }break;
                        case "G4" : 
                        {   
                            if(p7w.moves == 1)
                            {   
                                piecesAlive[6][3] = "p7w";
                                piecesAlive[6][1] = "";

                                lblG2.setIcon(null);
                                lblG4.setIcon(pawnw);
                                p7w.location = "G4";

                                refreshHistory();
                            }
                            else if(p7w.moves >= 2)
                            {   
                                piecesAlive[6][3] = "p7w";
                                piecesAlive[6][2] = "";

                                lblG3.setIcon(null);
                                lblG4.setIcon(pawnw);
                                p7w.location = "G4";

                                refreshHistory();
                            }
                        }break;  
                        case "G5" : 
                        {   
                            piecesAlive[6][4] = "p7w";
                            piecesAlive[6][3] = "";

                            lblG4.setIcon(null);
                            lblG5.setIcon(pawnw);
                            p7w.location = "G5";

                            refreshHistory();
                        }break;
                        case "G6" : 
                        {   
                            piecesAlive[6][5] = "p7w";
                            piecesAlive[6][4] = "";

                            lblG5.setIcon(null);
                            lblG6.setIcon(pawnw);
                            p7w.location = "G6";

                            refreshHistory();
                        }break;
                        case "G7" : 
                        {   
                            piecesAlive[6][6] = "p7w";
                            piecesAlive[6][5] = "";

                            lblG6.setIcon(null);
                            lblG7.setIcon(pawnw);
                            p7w.location = "G7";

                            refreshHistory();
                        }break;
                        case "G8" : 
                        {   
                            piecesAlive[6][7] = "p7w";
                            piecesAlive[6][6] = "";

                            lblG7.setIcon(null);
                            lblG8.setIcon(pawnw);
                            p7w.location = "G8";

                            refreshHistory();
                        }break;
                    }
                }
            }
            case "p8w" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "H3" : 
                        {   
                            piecesAlive[7][2] = "p8w";
                            piecesAlive[7][1] = "";

                            lblH2.setIcon(null);
                            lblH3.setIcon(pawnw);
                            p8w.location = "H3";

                            refreshHistory();
                        }break;
                        case "H4" : 
                        {   
                            if(p8w.moves == 1)
                            {   
                                piecesAlive[7][3] = "p8w";
                                piecesAlive[7][1] = "";

                                lblH2.setIcon(null);
                                lblH4.setIcon(pawnw);
                                p8w.location = "H4";

                                refreshHistory();
                            }
                            else if(p8w.moves >= 2)
                            {   
                                piecesAlive[7][3] = "p8w";
                                piecesAlive[7][2] = "";

                                lblH3.setIcon(null);
                                lblH4.setIcon(pawnw);
                                p8w.location = "H4";

                                refreshHistory();
                            }
                        }break;  
                        case "H5" : 
                        {   
                            piecesAlive[7][4] = "p8w";
                            piecesAlive[7][3] = "";

                            lblH4.setIcon(null);
                            lblH5.setIcon(pawnw);
                            p8w.location = "H5";

                            refreshHistory();
                        }break;
                        case "H6" : 
                        {   
                            piecesAlive[7][5] = "p8w";
                            piecesAlive[7][4] = "";

                            lblH5.setIcon(null);
                            lblH6.setIcon(pawnw);
                            p8w.location = "H6";

                            refreshHistory();
                        }break;
                        case "H7" : 
                        {   
                            piecesAlive[7][6] = "p8w";
                            piecesAlive[7][5] = "";

                            lblH6.setIcon(null);
                            lblH7.setIcon(pawnw);
                            p8w.location = "H7";

                            refreshHistory();
                        }break;
                        case "H8" : 
                        {   
                            piecesAlive[7][7] = "p8w";
                            piecesAlive[7][6] = "";

                            lblH7.setIcon(null);
                            lblH8.setIcon(pawnw);
                            p8w.location = "H8";

                            refreshHistory();
                        }break;
                    }
                }
            }
            /////////////////////////////
            case "p1b" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "A6" : 
                        {   
                            piecesAlive[0][5] = "p1b";
                            piecesAlive[0][6] = "";

                            lblA7.setIcon(null);
                            lblA6.setIcon(pawnb);
                            p1b.location = "A6";

                            refreshHistory();
                        }break;
                        case "A5" : 
                        {   
                            if(p1b.moves == 1)
                            {   
                                piecesAlive[0][4] = "p1b";
                                piecesAlive[0][6] = "";

                                lblA7.setIcon(null);
                                lblA5.setIcon(pawnb);
                                p1b.location = "A5";

                                refreshHistory();
                            }
                            else if(p1b.moves >= 2)
                            {   
                                piecesAlive[0][4] = "p1b";
                                piecesAlive[0][5] = "";

                                lblA6.setIcon(null);
                                lblA5.setIcon(pawnb);
                                p1b.location = "A5";

                                refreshHistory();
                            }
                        }break;  
                        case "A4" : 
                        {   
                            piecesAlive[0][3] = "p1b";
                            piecesAlive[0][4] = "";

                            lblA5.setIcon(null);
                            lblA4.setIcon(pawnb);
                            p1b.location = "A4";

                            refreshHistory();
                        }break;
                        case "A3" : 
                        {   
                            piecesAlive[0][2] = "p1b";
                            piecesAlive[0][3] = "";

                            lblA4.setIcon(null);
                            lblA3.setIcon(pawnb);
                            p1b.location = "A3";

                            refreshHistory();
                        }break;
                        case "A2" : 
                        {   
                            piecesAlive[0][1] = "p1b";
                            piecesAlive[0][2] = "";

                            lblA3.setIcon(null);
                            lblA2.setIcon(pawnb);
                            p1b.location = "A2";

                            refreshHistory();
                        }break;
                        case "A1" : 
                        {   
                            piecesAlive[0][0] = "p1b";
                            piecesAlive[0][1] = "";

                            lblA2.setIcon(null);
                            lblA1.setIcon(pawnb);
                            p1b.location = "A1";

                            refreshHistory();
                        }break;
                    }
                }
            }
            case "p2b" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "B6" : 
                        {   
                            piecesAlive[1][5] = "p2b";
                            piecesAlive[1][6] = "";

                            lblB7.setIcon(null);
                            lblB6.setIcon(pawnb);
                            p2b.location = "B6";

                            refreshHistory();
                        }break;
                        case "B5" : 
                        {   
                            if(p2b.moves == 1)
                            {   
                                piecesAlive[1][4] = "p2b";
                                piecesAlive[1][6] = "";

                                lblB7.setIcon(null);
                                lblB5.setIcon(pawnb);
                                p2b.location = "B5";

                                refreshHistory();
                            }
                            else if(p2b.moves >= 2)
                            {   
                                piecesAlive[1][4] = "p2b";
                                piecesAlive[1][5] = "";

                                lblB6.setIcon(null);
                                lblB5.setIcon(pawnb);
                                p2b.location = "B5";

                                refreshHistory();
                            }
                        }break;  
                        case "B4" : 
                        {   
                            piecesAlive[1][3] = "p2b";
                            piecesAlive[1][4] = "";

                            lblB5.setIcon(null);
                            lblB4.setIcon(pawnb);
                            p2b.location = "B4";

                            refreshHistory();
                        }break;
                        case "B3" : 
                        {   
                            piecesAlive[1][2] = "p2b";
                            piecesAlive[1][3] = "";

                            lblB4.setIcon(null);
                            lblB3.setIcon(pawnb);
                            p2b.location = "B3";

                            refreshHistory();
                        }break;
                        case "B2" : 
                        {   
                            piecesAlive[1][1] = "p2b";
                            piecesAlive[1][2] = "";

                            lblB3.setIcon(null);
                            lblB2.setIcon(pawnb);
                            p2b.location = "B2";

                            refreshHistory();
                        }break;
                        case "B1" : 
                        {   
                            piecesAlive[1][0] = "p2b";
                            piecesAlive[1][1] = "";

                            lblB2.setIcon(null);
                            lblB1.setIcon(pawnb);
                            p2b.location = "B1";

                            refreshHistory();
                        }break;
                    }
                }
                
            }
            case "p3b" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "C6" : 
                        {   
                            piecesAlive[2][5] = "p3b";
                            piecesAlive[2][6] = "";

                            lblC7.setIcon(null);
                            lblC6.setIcon(pawnb);
                            p3b.location = "C6";

                            refreshHistory();
                        }break;
                        case "C5" : 
                        {   
                            if(p3b.moves == 1)
                            {   
                                piecesAlive[2][4] = "p3b";
                                piecesAlive[2][6] = "";

                                lblC7.setIcon(null);
                                lblC5.setIcon(pawnb);
                                p3b.location = "C5";

                                refreshHistory();
                            }
                            else if(p3b.moves >= 2)
                            {   
                                piecesAlive[2][4] = "p3b";
                                piecesAlive[2][5] = "";

                                lblC6.setIcon(null);
                                lblC5.setIcon(pawnb);
                                p3b.location = "C5";

                                refreshHistory();
                            }
                        }break;  
                        case "C4" : 
                        {   
                            piecesAlive[2][3] = "p3b";
                            piecesAlive[2][4] = "";

                            lblC5.setIcon(null);
                            lblC4.setIcon(pawnb);
                            p3b.location = "C4";

                            refreshHistory();
                        }break;
                        case "C3" : 
                        {   
                            piecesAlive[2][2] = "p3b";
                            piecesAlive[2][3] = "";

                            lblC4.setIcon(null);
                            lblC3.setIcon(pawnb);
                            p3b.location = "C3";

                            refreshHistory();
                        }break;
                        case "C2" : 
                        {   
                            piecesAlive[2][1] = "p3b";
                            piecesAlive[2][2] = "";

                            lblC3.setIcon(null);
                            lblC2.setIcon(pawnb);
                            p3b.location = "C2";

                            refreshHistory();
                        }break;
                        case "C1" : 
                        {   
                            piecesAlive[2][0] = "p3b";
                            piecesAlive[2][1] = "";

                            lblC2.setIcon(null);
                            lblC1.setIcon(pawnb);
                            p3b.location = "C1";

                            refreshHistory();
                        }break;
                    }
                }
                
            }
            case "p4b" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "D6" : 
                        {   
                            piecesAlive[3][5] = "p4b";
                            piecesAlive[3][6] = "";

                            lblD7.setIcon(null);
                            lblD6.setIcon(pawnb);
                            p4b.location = "D6";

                            refreshHistory();
                        }break;
                        case "D5" : 
                        {   
                            if(p4b.moves == 1)
                            {   
                                piecesAlive[3][4] = "p4b";
                                piecesAlive[3][6] = "";

                                lblD7.setIcon(null);
                                lblD5.setIcon(pawnb);
                                p4b.location = "D5";

                                refreshHistory();
                            }
                            else if(p4b.moves >= 2)
                            {   
                                piecesAlive[3][4] = "p4b";
                                piecesAlive[3][5] = "";

                                lblD6.setIcon(null);
                                lblD5.setIcon(pawnb);
                                p4b.location = "D5";

                                refreshHistory();
                            }
                        }break;  
                        case "D4" : 
                        {   
                            piecesAlive[3][3] = "p4b";
                            piecesAlive[3][4] = "";

                            lblD5.setIcon(null);
                            lblD4.setIcon(pawnb);
                            p4b.location = "D4";

                            refreshHistory();
                        }break;
                        case "D3" : 
                        {   
                            piecesAlive[3][2] = "p4b";
                            piecesAlive[3][3] = "";

                            lblD4.setIcon(null);
                            lblD3.setIcon(pawnb);
                            p4b.location = "D3";

                            refreshHistory();
                        }break;
                        case "D2" : 
                        {   
                            piecesAlive[3][1] = "p4b";
                            piecesAlive[3][2] = "";

                            lblD3.setIcon(null);
                            lblD2.setIcon(pawnb);
                            p4b.location = "D2";

                            refreshHistory();
                        }break;
                        case "D1" : 
                        {   
                            piecesAlive[3][0] = "p4b";
                            piecesAlive[3][1] = "";

                            lblD2.setIcon(null);
                            lblD1.setIcon(pawnb);
                            p4b.location = "D1";

                            refreshHistory();
                        }break;
                    }
                }
            }
            case "p5b" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "E6" : 
                        {   
                            piecesAlive[4][5] = "p5b";
                            piecesAlive[4][6] = "";

                            lblE7.setIcon(null);
                            lblE6.setIcon(pawnb);
                            p5b.location = "E6";

                            refreshHistory();
                        }break;
                        case "E5" : 
                        {   
                            if(p5b.moves == 1)
                            {   
                                piecesAlive[4][4] = "p5b";
                                piecesAlive[4][6] = "";

                                lblE7.setIcon(null);
                                lblE5.setIcon(pawnb);
                                p5b.location = "E5";

                                refreshHistory();
                            }
                            else if(p5b.moves >= 2)
                            {   
                                piecesAlive[4][4] = "p5b";
                                piecesAlive[4][5] = "";

                                lblE6.setIcon(null);
                                lblE5.setIcon(pawnb);
                                p5b.location = "E5";

                                refreshHistory();
                            }
                        }break;  
                        case "E4" : 
                        {   
                            piecesAlive[4][3] = "p5b";
                            piecesAlive[4][4] = "";

                            lblE5.setIcon(null);
                            lblE4.setIcon(pawnb);
                            p5b.location = "E4";

                            refreshHistory();
                        }break;
                        case "E3" : 
                        {   
                            piecesAlive[4][2] = "p5b";
                            piecesAlive[4][3] = "";

                            lblE4.setIcon(null);
                            lblE3.setIcon(pawnb);
                            p5b.location = "E3";

                            refreshHistory();
                        }break;
                        case "E2" : 
                        {   
                            piecesAlive[4][1] = "p5b";
                            piecesAlive[4][2] = "";

                            lblE3.setIcon(null);
                            lblE2.setIcon(pawnb);
                            p5b.location = "E2";

                            refreshHistory();
                        }break;
                        case "E1" : 
                        {   
                            piecesAlive[4][0] = "p5b";
                            piecesAlive[4][1] = "";

                            lblE2.setIcon(null);
                            lblE1.setIcon(pawnb);
                            p5b.location = "E1";

                            refreshHistory();
                        }break;
                    }
                }
            }
            case "p6b" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "F6" : 
                        {   
                            piecesAlive[5][5] = "p6b";
                            piecesAlive[5][6] = "";

                            lblF7.setIcon(null);
                            lblF6.setIcon(pawnb);
                            p6b.location = "F6";

                            refreshHistory();
                        }break;
                        case "F5" : 
                        {   
                            if(p6b.moves == 1)
                            {   
                                piecesAlive[5][4] = "p6b";
                                piecesAlive[5][6] = "";

                                lblF7.setIcon(null);
                                lblF5.setIcon(pawnb);
                                p6b.location = "F5";

                                refreshHistory();
                            }
                            else if(p6b.moves >= 2)
                            {   
                                piecesAlive[5][4] = "p6b";
                                piecesAlive[5][5] = "";

                                lblF6.setIcon(null);
                                lblF5.setIcon(pawnb);
                                p6b.location = "F5";

                                refreshHistory();
                            }
                        }break;  
                        case "F4" : 
                        {   
                            piecesAlive[5][3] = "p6b";
                            piecesAlive[5][4] = "";

                            lblF5.setIcon(null);
                            lblF4.setIcon(pawnb);
                            p6b.location = "F4";

                            refreshHistory();
                        }break;
                        case "F3" : 
                        {   
                            piecesAlive[5][2] = "p6b";
                            piecesAlive[5][3] = "";

                            lblF4.setIcon(null);
                            lblF3.setIcon(pawnb);
                            p6b.location = "F3";

                            refreshHistory();
                        }break;
                        case "F2" : 
                        {   
                            piecesAlive[5][1] = "p6b";
                            piecesAlive[5][2] = "";

                            lblF3.setIcon(null);
                            lblF2.setIcon(pawnb);
                            p6b.location = "F2";

                            refreshHistory();
                        }break;
                        case "F1" : 
                        {   
                            piecesAlive[5][0] = "p6b";
                            piecesAlive[5][1] = "";

                            lblF2.setIcon(null);
                            lblF1.setIcon(pawnb);
                            p6b.location = "F1";

                            refreshHistory();
                        }break;
                    }
                }
            }
            case "p7b" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "G6" : 
                        {   
                            piecesAlive[6][5] = "p7b";
                            piecesAlive[6][6] = "";

                            lblG7.setIcon(null);
                            lblG6.setIcon(pawnb);
                            p7b.location = "G6";

                            refreshHistory();
                        }break;
                        case "G5" : 
                        {   
                            if(p7b.moves == 1)
                            {   
                                piecesAlive[6][4] = "p7b";
                                piecesAlive[6][6] = "";

                                lblG7.setIcon(null);
                                lblG5.setIcon(pawnb);
                                p7b.location = "G5";

                                refreshHistory();
                            }
                            else if(p7b.moves >= 2)
                            {   
                                piecesAlive[6][4] = "p7b";
                                piecesAlive[6][5] = "";

                                lblG6.setIcon(null);
                                lblG5.setIcon(pawnb);
                                p7b.location = "G5";

                                refreshHistory();
                            }
                        }break;  
                        case "G4" : 
                        {   
                            piecesAlive[6][3] = "p7b";
                            piecesAlive[6][4] = "";

                            lblG5.setIcon(null);
                            lblG4.setIcon(pawnb);
                            p7b.location = "G4";

                            refreshHistory();
                        }break;
                        case "G3" : 
                        {   
                            piecesAlive[6][2] = "p7b";
                            piecesAlive[6][3] = "";

                            lblG4.setIcon(null);
                            lblG3.setIcon(pawnb);
                            p7b.location = "G3";

                            refreshHistory();
                        }break;
                        case "G2" : 
                        {   
                            piecesAlive[6][1] = "p7b";
                            piecesAlive[6][2] = "";

                            lblG3.setIcon(null);
                            lblG2.setIcon(pawnb);
                            p7b.location = "G2";

                            refreshHistory();
                        }break;
                        case "G1" : 
                        {   
                            piecesAlive[6][0] = "p7b";
                            piecesAlive[6][1] = "";

                            lblG2.setIcon(null);
                            lblG1.setIcon(pawnb);
                            p7b.location = "G1";

                            refreshHistory();
                        }break;
                    }
                }
            }
            case "p8b" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "H6" : 
                        {   
                            piecesAlive[7][5] = "p8b";
                            piecesAlive[7][6] = "";

                            lblH7.setIcon(null);
                            lblH6.setIcon(pawnb);
                            p8b.location = "H7";

                            refreshHistory();
                        }break;
                        case "H5" : 
                        {   
                            if(p8b.moves == 1)
                            {   
                                piecesAlive[7][4] = "p8b";
                                piecesAlive[7][6] = "";

                                lblH7.setIcon(null);
                                lblH5.setIcon(pawnb);
                                p8b.location = "H5";

                                refreshHistory();
                            }
                            else if(p8b.moves >= 2)
                            {   
                                piecesAlive[7][4] = "p8b";
                                piecesAlive[7][5] = "";

                                lblH6.setIcon(null);
                                lblH5.setIcon(pawnb);
                                p8b.location = "H5";

                                refreshHistory();
                            }
                        }break;  
                        case "H4" : 
                        {   
                            piecesAlive[7][3] = "p8b";
                            piecesAlive[7][4] = "";

                            lblH5.setIcon(null);
                            lblH4.setIcon(pawnb);
                            p8b.location = "H4";

                            refreshHistory();
                        }break;
                        case "H3" : 
                        {   
                            piecesAlive[7][2] = "p8b";
                            piecesAlive[7][3] = "";

                            lblH4.setIcon(null);
                            lblH3.setIcon(pawnb);
                            p8b.location = "H3";

                            refreshHistory();
                        }break;
                        case "H2" : 
                        {   
                            piecesAlive[7][1] = "p8b";
                            piecesAlive[7][2] = "";

                            lblH3.setIcon(null);
                            lblH2.setIcon(pawnb);
                            p8b.location = "H2";

                            refreshHistory();
                        }break;
                        case "H1" : 
                        {   
                            piecesAlive[7][0] = "p8b";
                            piecesAlive[7][1] = "";

                            lblH2.setIcon(null);
                            lblH1.setIcon(pawnb);
                            p8b.location = "H1";

                            refreshHistory();
                        }break;
                    }
                }
            }
            case "h1w" : 
            {
                if(destination.getBorder() == movement)
                {
                    setterOfPieceKnight("h1w", destination.getName(), knightw, h1w);
                }
            }
            case "h2w" : 
            {
                if(destination.getBorder() == movement)
                {
                    setterOfPieceKnight("h2w", destination.getName(), knightw, h2w);
                }
            }
            case "h1b" : 
            {
                if(destination.getBorder() == movement)
                {
                    setterOfPieceKnight("h1b", destination.getName(), knightb, h1b);
                }
            }
            case "h2b" : 
            {
                if(destination.getBorder() == movement)
                {
                    setterOfPieceKnight("h1b", destination.getName(), knightb, h1b);
                }
            }
            case "b1w" : 
            {
                if(destination.getBorder() == movement)
                {
                    setterOfPieceBishop("b1w", destination.getName(), bishopw, b1w);
                }
            }
            case "b2w" : 
            {
                if(destination.getBorder() == movement)
                {
                    setterOfPieceBishop("b2w", destination.getName(), bishopw, b2w);
                }
            }
            case "b1b" : 
            {
                if(destination.getBorder() == movement)
                {
                    setterOfPieceBishop("b1b", destination.getName(), bishopb, b1b);
                }
            }
            case "b2b" : 
            {
                if(destination.getBorder() == movement)
                {
                    setterOfPieceBishop("b2b", destination.getName(), bishopb, b2b);
                }
            }
            case "r1w" : 
            {
                if(destination.getBorder() == movement)
                {
                    setterOfPieceRook("r1w", destination.getName(), rookw, r1w);
                }
            }
            case "r2w" : 
            {
                if(destination.getBorder() == movement)
                {
                    setterOfPieceRook("r2w", destination.getName(), rookw, r2w);
                }
            }
            case "r1b" : 
            {
                if(destination.getBorder() == movement)
                {
                    setterOfPieceRook("r1b", destination.getName(), rookb, r1b);
                }
            }
            case "r2b" : 
            {
                
                
                if(destination.getBorder() == movement)
                {
                    setterOfPieceRook("r2b", destination.getName(), rookb, r2b);
                }
            }
        }
        
        outputToOpponent += "," + destination.getName();
        
        goNoGo = 1;
    }
    //======================================================
    
    //  To move the indicated piece to an indicated position
    public void postmovePiece1(String buffer, JPanel destination)
    {
        switch(buffer)
        {
            case "p1w" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "A3" : 
                        {   
                            piecesAlive[0][2] = "p1w";
                            piecesAlive[0][1] = "";

                            lblA2.setIcon(null);
                            lblA3.setIcon(pawnw);
                            p1w.location = "A3";

                            refreshHistory();
                        }break;
                        case "A4" : 
                        {   
                            if(p1w.moves == 1)
                            {   
                                piecesAlive[0][3] = "p1w";
                                piecesAlive[0][1] = "";

                                lblA2.setIcon(null);
                                lblA4.setIcon(pawnw);
                                p1w.location = "A4";

                                refreshHistory();
                            }
                            else if(p1w.moves >= 2)
                            {   
                                piecesAlive[0][3] = "p1w";
                                piecesAlive[0][2] = "";

                                lblA3.setIcon(null);
                                lblA4.setIcon(pawnw);
                                p1w.location = "A4";

                                refreshHistory();
                            }
                        }break;  
                        case "A5" : 
                        {   
                            piecesAlive[0][4] = "p1w";
                            piecesAlive[0][3] = "";

                            lblA4.setIcon(null);
                            lblA5.setIcon(pawnw);
                            p1w.location = "A5";

                            refreshHistory();
                        }break;
                        case "A6" : 
                        {   
                            piecesAlive[0][5] = "p1w";
                            piecesAlive[0][4] = "";

                            lblA5.setIcon(null);
                            lblA6.setIcon(pawnw);
                            p1w.location = "A6";

                            refreshHistory();
                        }break;
                        case "A7" : 
                        {   
                            piecesAlive[0][6] = "p1w";
                            piecesAlive[0][5] = "";

                            lblA6.setIcon(null);
                            lblA7.setIcon(pawnw);
                            p1w.location = "A7";

                            refreshHistory();
                        }break;
                        case "A8" : 
                        {   
                            piecesAlive[0][7] = "p1w";
                            piecesAlive[0][6] = "";

                            lblA7.setIcon(null);
                            lblA8.setIcon(pawnw);
                            p1w.location = "A8";

                            refreshHistory();
                        }break;
                    }
                }
            }
            case "p2w" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "B3" : 
                                {   
                                    System.out.println("hey");
                                    piecesAlive[1][2] = "p2w";
                                    piecesAlive[1][1] = "";

                                    lblB2.setIcon(null);
                                    lblB3.setIcon(pawnw);
                                    p2w.location = "B3";

                                    refreshHistory();
                                }break;
                        case "B4" : 
                                {   
                                    if(p2w.moves == 1)
                                    {   
                                        piecesAlive[1][3] = "p2w";
                                        piecesAlive[1][1] = "";

                                        lblB2.setIcon(null);
                                        lblB4.setIcon(pawnw);
                                        p2w.location = "B4";

                                        refreshHistory();
                                    }
                                    else if(p2w.moves >= 2)
                                    {   
                                        piecesAlive[1][3] = "p2w";
                                        piecesAlive[1][2] = "";

                                        lblB3.setIcon(null);
                                        lblB4.setIcon(pawnw);
                                        p2w.location = "B4";

                                        refreshHistory();
                                    }
                                }break;  
                        case "B5" : 
                                {   
                                    piecesAlive[1][4] = "p2w";
                                    piecesAlive[1][3] = "";

                                    lblB4.setIcon(null);
                                    lblB5.setIcon(pawnw);
                                    p2w.location = "B5";

                                    refreshHistory();
                                }break;
                        case "B6" : 
                                {   
                                    piecesAlive[1][5] = "p2w";
                                    piecesAlive[1][4] = "";

                                    lblB5.setIcon(null);
                                    lblB6.setIcon(pawnw);
                                    p2w.location = "B6";

                                    refreshHistory();
                                }break;
                        case "B7" : 
                                {   
                                    piecesAlive[1][6] = "p2w";
                                    piecesAlive[1][5] = "";

                                    lblB6.setIcon(null);
                                    lblB7.setIcon(pawnw);
                                    p2w.location = "B7";

                                    refreshHistory();
                                }break;
                        case "B8" : 
                        {   
                            piecesAlive[1][7] = "p2w";
                            piecesAlive[1][6] = "";

                            lblB7.setIcon(null);
                            lblB8.setIcon(pawnw);
                            p2w.location = "B8";

                            refreshHistory();
                        }break;
                    }
                }
            }      
            case "p3w" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "C3" : 
                        {   
                            piecesAlive[2][2] = "p3w";
                            piecesAlive[2][1] = "";

                            lblC2.setIcon(null);
                            lblC3.setIcon(pawnw);
                            p3w.location = "C3";

                            refreshHistory();
                        }break;
                        case "C4" : 
                        {   
                            if(p3w.moves == 1)
                            {   
                                piecesAlive[2][3] = "p3w";
                                piecesAlive[2][1] = "";

                                lblC2.setIcon(null);
                                lblC4.setIcon(pawnw);
                                p3w.location = "C4";

                                refreshHistory();
                            }
                            else if(p3w.moves >= 2)
                            {   
                                piecesAlive[2][3] = "p3w";
                                piecesAlive[2][2] = "";

                                lblC3.setIcon(null);
                                lblC4.setIcon(pawnw);
                                p3w.location = "C4";

                                refreshHistory();
                            }
                        }break;  
                        case "C5" : 
                        {   
                            piecesAlive[2][4] = "p3w";
                            piecesAlive[2][3] = "";

                            lblC4.setIcon(null);
                            lblC5.setIcon(pawnw);
                            p3w.location = "C5";

                            refreshHistory();
                        }break;
                        case "C6" : 
                        {   
                            piecesAlive[2][5] = "p3w";
                            piecesAlive[2][4] = "";

                            lblC5.setIcon(null);
                            lblC6.setIcon(pawnw);
                            p3w.location = "C6";

                            refreshHistory();
                        }break;
                        case "C7" : 
                        {   
                            piecesAlive[2][6] = "p3w";
                            piecesAlive[2][5] = "";

                            lblC6.setIcon(null);
                            lblC7.setIcon(pawnw);
                            p3w.location = "C7";

                            refreshHistory();
                        }break;
                        case "C8" : 
                        {   
                            piecesAlive[2][7] = "p3w";
                            piecesAlive[2][6] = "";

                            lblC7.setIcon(null);
                            lblC8.setIcon(pawnw);
                            p3w.location = "C8";

                            refreshHistory();
                        }break;
                    }
                }
            }
            case "p4w" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "D3" : 
                        {   
                            piecesAlive[3][2] = "p4w";
                            piecesAlive[3][1] = "";

                            lblD2.setIcon(null);
                            lblD3.setIcon(pawnw);
                            p4w.location = "D3";

                            refreshHistory();
                        }break;
                        case "D4" : 
                        {   
                            if(p4w.moves == 1)
                            {   
                                piecesAlive[3][3] = "p4w";
                                piecesAlive[3][1] = "";

                                lblD2.setIcon(null);
                                lblD4.setIcon(pawnw);
                                p4w.location = "D4";

                                refreshHistory();
                            }
                            else if(p4w.moves >= 2)
                            {   
                                piecesAlive[3][3] = "p4w";
                                piecesAlive[3][2] = "";

                                lblD3.setIcon(null);
                                lblD4.setIcon(pawnw);
                                p4w.location = "D4";

                                refreshHistory();
                            }
                        }break;  
                        case "D5" : 
                        {   
                            piecesAlive[3][4] = "p4w";
                            piecesAlive[3][3] = "";

                            lblD4.setIcon(null);
                            lblD5.setIcon(pawnw);
                            p4w.location = "D5";

                            refreshHistory();
                        }break;
                        case "D6" : 
                        {   
                            piecesAlive[3][5] = "p4w";
                            piecesAlive[3][4] = "";

                            lblD5.setIcon(null);
                            lblD6.setIcon(pawnw);
                            p4w.location = "D6";

                            refreshHistory();
                        }break;
                        case "D7" : 
                        {   
                            piecesAlive[3][6] = "p4w";
                            piecesAlive[3][5] = "";

                            lblD6.setIcon(null);
                            lblD7.setIcon(pawnw);
                            p4w.location = "D7";

                            refreshHistory();
                        }break;
                        case "D8" : 
                        {   
                            piecesAlive[3][7] = "p4w";
                            piecesAlive[3][6] = "";

                            lblD7.setIcon(null);
                            lblD8.setIcon(pawnw);
                            p4w.location = "D8";

                            refreshHistory();
                        }break;
                    }
                }
            }
            case "p5w" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "E3" : 
                        {   
                            piecesAlive[4][2] = "p5w";
                            piecesAlive[4][1] = "";

                            lblE2.setIcon(null);
                            lblE3.setIcon(pawnw);
                            p5w.location = "E3";

                            refreshHistory();
                        }break;
                        case "E4" : 
                        {   
                            if(p5w.moves == 1)
                            {   
                                piecesAlive[4][3] = "p5w";
                                piecesAlive[4][1] = "";

                                lblE2.setIcon(null);
                                lblE4.setIcon(pawnw);
                                p5w.location = "E4";

                                refreshHistory();
                            }
                            else if(p5w.moves >= 2)
                            {   
                                piecesAlive[4][3] = "p5w";
                                piecesAlive[4][2] = "";

                                lblE3.setIcon(null);
                                lblE4.setIcon(pawnw);
                                p5w.location = "E4";

                                refreshHistory();
                            }
                        }break;  
                        case "E5" : 
                        {   
                            piecesAlive[4][4] = "p5w";
                            piecesAlive[4][3] = "";

                            lblE4.setIcon(null);
                            lblE5.setIcon(pawnw);
                            p5w.location = "E5";

                            refreshHistory();
                        }break;
                        case "E6" : 
                        {   
                            piecesAlive[4][5] = "p5w";
                            piecesAlive[4][4] = "";

                            lblE5.setIcon(null);
                            lblE6.setIcon(pawnw);
                            p5w.location = "E6";

                            refreshHistory();
                        }break;
                        case "E7" : 
                        {   
                            piecesAlive[4][6] = "p5w";
                            piecesAlive[4][5] = "";

                            lblE6.setIcon(null);
                            lblE7.setIcon(pawnw);
                            p5w.location = "E7";

                            refreshHistory();
                        }break;
                        case "E8" : 
                        {   
                            piecesAlive[4][7] = "p5w";
                            piecesAlive[4][6] = "";

                            lblE7.setIcon(null);
                            lblE8.setIcon(pawnw);
                            p5w.location = "E8";

                            refreshHistory();
                        }break;
                    }
                }
            }
            case "p6w" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "F3" : 
                        {   
                            piecesAlive[5][2] = "p6w";
                            piecesAlive[5][1] = "";

                            lblF2.setIcon(null);
                            lblF3.setIcon(pawnw);
                            p6w.location = "F3";

                            refreshHistory();
                        }break;
                        case "F4" : 
                        {   
                            if(p6w.moves == 1)
                            {   
                                piecesAlive[5][3] = "p6w";
                                piecesAlive[5][1] = "";

                                lblF2.setIcon(null);
                                lblF4.setIcon(pawnw);
                                p6w.location = "F4";

                                refreshHistory();
                            }
                            else if(p6w.moves >= 2)
                            {   
                                piecesAlive[5][3] = "p6w";
                                piecesAlive[5][2] = "";

                                lblF3.setIcon(null);
                                lblF4.setIcon(pawnw);
                                p6w.location = "F4";

                                refreshHistory();
                            }
                        }break;  
                        case "F5" : 
                        {   
                            piecesAlive[5][4] = "p6w";
                            piecesAlive[5][3] = "";

                            lblF4.setIcon(null);
                            lblF5.setIcon(pawnw);
                            p6w.location = "F5";

                            refreshHistory();
                        }break;
                        case "F6" : 
                        {   
                            piecesAlive[5][5] = "p6w";
                            piecesAlive[5][4] = "";

                            lblF5.setIcon(null);
                            lblF6.setIcon(pawnw);
                            p6w.location = "F6";

                            refreshHistory();
                        }break;
                        case "F7" : 
                        {   
                            piecesAlive[5][6] = "p6w";
                            piecesAlive[5][5] = "";

                            lblF6.setIcon(null);
                            lblF7.setIcon(pawnw);
                            p6w.location = "F7";

                            refreshHistory();
                        }break;
                        case "F8" : 
                        {   
                            piecesAlive[5][7] = "p6w";
                            piecesAlive[5][6] = "";

                            lblF7.setIcon(null);
                            lblF8.setIcon(pawnw);
                            p6w.location = "F8";

                            refreshHistory();
                        }break;
                    }
                }
            }
            case "p7w" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "G3" : 
                        {   
                            piecesAlive[6][2] = "p7w";
                            piecesAlive[6][1] = "";

                            lblG2.setIcon(null);
                            lblG3.setIcon(pawnw);
                            p7w.location = "G3";

                            refreshHistory();
                        }break;
                        case "G4" : 
                        {   
                            if(p7w.moves == 1)
                            {   
                                piecesAlive[6][3] = "p7w";
                                piecesAlive[6][1] = "";

                                lblG2.setIcon(null);
                                lblG4.setIcon(pawnw);
                                p7w.location = "G4";

                                refreshHistory();
                            }
                            else if(p7w.moves >= 2)
                            {   
                                piecesAlive[6][3] = "p7w";
                                piecesAlive[6][2] = "";

                                lblG3.setIcon(null);
                                lblG4.setIcon(pawnw);
                                p7w.location = "G4";

                                refreshHistory();
                            }
                        }break;  
                        case "G5" : 
                        {   
                            piecesAlive[6][4] = "p7w";
                            piecesAlive[6][3] = "";

                            lblG4.setIcon(null);
                            lblG5.setIcon(pawnw);
                            p7w.location = "G5";

                            refreshHistory();
                        }break;
                        case "G6" : 
                        {   
                            piecesAlive[6][5] = "p7w";
                            piecesAlive[6][4] = "";

                            lblG5.setIcon(null);
                            lblG6.setIcon(pawnw);
                            p7w.location = "G6";

                            refreshHistory();
                        }break;
                        case "G7" : 
                        {   
                            piecesAlive[6][6] = "p7w";
                            piecesAlive[6][5] = "";

                            lblG6.setIcon(null);
                            lblG7.setIcon(pawnw);
                            p7w.location = "G7";

                            refreshHistory();
                        }break;
                        case "G8" : 
                        {   
                            piecesAlive[6][7] = "p7w";
                            piecesAlive[6][6] = "";

                            lblG7.setIcon(null);
                            lblG8.setIcon(pawnw);
                            p7w.location = "G8";

                            refreshHistory();
                        }break;
                    }
                }
            }
            case "p8w" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "H3" : 
                        {   
                            piecesAlive[7][2] = "p8w";
                            piecesAlive[7][1] = "";

                            lblH2.setIcon(null);
                            lblH3.setIcon(pawnw);
                            p8w.location = "H3";

                            refreshHistory();
                        }break;
                        case "H4" : 
                        {   
                            if(p8w.moves == 1)
                            {   
                                piecesAlive[7][3] = "p8w";
                                piecesAlive[7][1] = "";

                                lblH2.setIcon(null);
                                lblH4.setIcon(pawnw);
                                p8w.location = "H4";

                                refreshHistory();
                            }
                            else if(p8w.moves >= 2)
                            {   
                                piecesAlive[7][3] = "p8w";
                                piecesAlive[7][2] = "";

                                lblH3.setIcon(null);
                                lblH4.setIcon(pawnw);
                                p8w.location = "H4";

                                refreshHistory();
                            }
                        }break;  
                        case "H5" : 
                        {   
                            piecesAlive[7][4] = "p8w";
                            piecesAlive[7][3] = "";

                            lblH4.setIcon(null);
                            lblH5.setIcon(pawnw);
                            p8w.location = "H5";

                            refreshHistory();
                        }break;
                        case "H6" : 
                        {   
                            piecesAlive[7][5] = "p8w";
                            piecesAlive[7][4] = "";

                            lblH5.setIcon(null);
                            lblH6.setIcon(pawnw);
                            p8w.location = "H6";

                            refreshHistory();
                        }break;
                        case "H7" : 
                        {   
                            piecesAlive[7][6] = "p8w";
                            piecesAlive[7][5] = "";

                            lblH6.setIcon(null);
                            lblH7.setIcon(pawnw);
                            p8w.location = "H7";

                            refreshHistory();
                        }break;
                        case "H8" : 
                        {   
                            piecesAlive[7][7] = "p8w";
                            piecesAlive[7][6] = "";

                            lblH7.setIcon(null);
                            lblH8.setIcon(pawnw);
                            p8w.location = "H8";

                            refreshHistory();
                        }break;
                    }
                }
            }
            /////////////////////////////
            case "p1b" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "A6" : 
                        {   
                            piecesAlive[0][5] = "p1b";
                            piecesAlive[0][6] = "";

                            lblA7.setIcon(null);
                            lblA6.setIcon(pawnb);
                            p1b.location = "A6";

                            refreshHistory();
                        }break;
                        case "A5" : 
                        {   
                            if(p1b.moves == 1)
                            {   
                                piecesAlive[0][4] = "p1b";
                                piecesAlive[0][6] = "";

                                lblA7.setIcon(null);
                                lblA5.setIcon(pawnb);
                                p1b.location = "A5";

                                refreshHistory();
                            }
                            else if(p1b.moves >= 2)
                            {   
                                piecesAlive[0][4] = "p1b";
                                piecesAlive[0][5] = "";

                                lblA6.setIcon(null);
                                lblA5.setIcon(pawnb);
                                p1b.location = "A5";

                                refreshHistory();
                            }
                        }break;  
                        case "A4" : 
                        {   
                            piecesAlive[0][3] = "p1b";
                            piecesAlive[0][4] = "";

                            lblA5.setIcon(null);
                            lblA4.setIcon(pawnb);
                            p1b.location = "A4";

                            refreshHistory();
                        }break;
                        case "A3" : 
                        {   
                            piecesAlive[0][2] = "p1b";
                            piecesAlive[0][3] = "";

                            lblA4.setIcon(null);
                            lblA3.setIcon(pawnb);
                            p1b.location = "A3";

                            refreshHistory();
                        }break;
                        case "A2" : 
                        {   
                            piecesAlive[0][1] = "p1b";
                            piecesAlive[0][2] = "";

                            lblA3.setIcon(null);
                            lblA2.setIcon(pawnb);
                            p1b.location = "A2";

                            refreshHistory();
                        }break;
                        case "A1" : 
                        {   
                            piecesAlive[0][0] = "p1b";
                            piecesAlive[0][1] = "";

                            lblA2.setIcon(null);
                            lblA1.setIcon(pawnb);
                            p1b.location = "A1";

                            refreshHistory();
                        }break;
                    }
                }
            }
            case "p2b" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "B6" : 
                        {   
                            piecesAlive[1][5] = "p2b";
                            piecesAlive[1][6] = "";

                            lblB7.setIcon(null);
                            lblB6.setIcon(pawnb);
                            p2b.location = "B6";

                            refreshHistory();
                        }break;
                        case "B5" : 
                        {   
                            if(p2b.moves == 1)
                            {   
                                piecesAlive[1][4] = "p2b";
                                piecesAlive[1][6] = "";

                                lblB7.setIcon(null);
                                lblB5.setIcon(pawnb);
                                p2b.location = "B5";

                                refreshHistory();
                            }
                            else if(p2b.moves >= 2)
                            {   
                                piecesAlive[1][4] = "p2b";
                                piecesAlive[1][5] = "";

                                lblB6.setIcon(null);
                                lblB5.setIcon(pawnb);
                                p2b.location = "B5";

                                refreshHistory();
                            }
                        }break;  
                        case "B4" : 
                        {   
                            piecesAlive[1][3] = "p2b";
                            piecesAlive[1][4] = "";

                            lblB5.setIcon(null);
                            lblB4.setIcon(pawnb);
                            p2b.location = "B4";

                            refreshHistory();
                        }break;
                        case "B3" : 
                        {   
                            piecesAlive[1][2] = "p2b";
                            piecesAlive[1][3] = "";

                            lblB4.setIcon(null);
                            lblB3.setIcon(pawnb);
                            p2b.location = "B3";

                            refreshHistory();
                        }break;
                        case "B2" : 
                        {   
                            piecesAlive[1][1] = "p2b";
                            piecesAlive[1][2] = "";

                            lblB3.setIcon(null);
                            lblB2.setIcon(pawnb);
                            p2b.location = "B2";

                            refreshHistory();
                        }break;
                        case "B1" : 
                        {   
                            piecesAlive[1][0] = "p2b";
                            piecesAlive[1][1] = "";

                            lblB2.setIcon(null);
                            lblB1.setIcon(pawnb);
                            p2b.location = "B1";

                            refreshHistory();
                        }break;
                    }
                }
                
            }
            case "p3b" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "C6" : 
                        {   
                            piecesAlive[2][5] = "p3b";
                            piecesAlive[2][6] = "";

                            lblC7.setIcon(null);
                            lblC6.setIcon(pawnb);
                            p3b.location = "C6";

                            refreshHistory();
                        }break;
                        case "C5" : 
                        {   
                            if(p3b.moves == 1)
                            {   
                                piecesAlive[2][4] = "p3b";
                                piecesAlive[2][6] = "";

                                lblC7.setIcon(null);
                                lblC5.setIcon(pawnb);
                                p3b.location = "C5";

                                refreshHistory();
                            }
                            else if(p3b.moves >= 2)
                            {   
                                piecesAlive[2][4] = "p3b";
                                piecesAlive[2][5] = "";

                                lblC6.setIcon(null);
                                lblC5.setIcon(pawnb);
                                p3b.location = "C5";

                                refreshHistory();
                            }
                        }break;  
                        case "C4" : 
                        {   
                            piecesAlive[2][3] = "p3b";
                            piecesAlive[2][4] = "";

                            lblC5.setIcon(null);
                            lblC4.setIcon(pawnb);
                            p3b.location = "C4";

                            refreshHistory();
                        }break;
                        case "C3" : 
                        {   
                            piecesAlive[2][2] = "p3b";
                            piecesAlive[2][3] = "";

                            lblC4.setIcon(null);
                            lblC3.setIcon(pawnb);
                            p3b.location = "C3";

                            refreshHistory();
                        }break;
                        case "C2" : 
                        {   
                            piecesAlive[2][1] = "p3b";
                            piecesAlive[2][2] = "";

                            lblC3.setIcon(null);
                            lblC2.setIcon(pawnb);
                            p3b.location = "C2";

                            refreshHistory();
                        }break;
                        case "C1" : 
                        {   
                            piecesAlive[2][0] = "p3b";
                            piecesAlive[2][1] = "";

                            lblC2.setIcon(null);
                            lblC1.setIcon(pawnb);
                            p3b.location = "C1";

                            refreshHistory();
                        }break;
                    }
                }
                
            }
            case "p4b" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "D6" : 
                        {   
                            piecesAlive[3][5] = "p4b";
                            piecesAlive[3][6] = "";

                            lblD7.setIcon(null);
                            lblD6.setIcon(pawnb);
                            p4b.location = "D6";

                            refreshHistory();
                        }break;
                        case "D5" : 
                        {   
                            if(p4b.moves == 1)
                            {   
                                piecesAlive[3][4] = "p4b";
                                piecesAlive[3][6] = "";

                                lblD7.setIcon(null);
                                lblD5.setIcon(pawnb);
                                p4b.location = "D5";

                                refreshHistory();
                            }
                            else if(p4b.moves >= 2)
                            {   
                                piecesAlive[3][4] = "p4b";
                                piecesAlive[3][5] = "";

                                lblD6.setIcon(null);
                                lblD5.setIcon(pawnb);
                                p4b.location = "D5";

                                refreshHistory();
                            }
                        }break;  
                        case "D4" : 
                        {   
                            piecesAlive[3][3] = "p4b";
                            piecesAlive[3][4] = "";

                            lblD5.setIcon(null);
                            lblD4.setIcon(pawnb);
                            p4b.location = "D4";

                            refreshHistory();
                        }break;
                        case "D3" : 
                        {   
                            piecesAlive[3][2] = "p4b";
                            piecesAlive[3][3] = "";

                            lblD4.setIcon(null);
                            lblD3.setIcon(pawnb);
                            p4b.location = "D3";

                            refreshHistory();
                        }break;
                        case "D2" : 
                        {   
                            piecesAlive[3][1] = "p4b";
                            piecesAlive[3][2] = "";

                            lblD3.setIcon(null);
                            lblD2.setIcon(pawnb);
                            p4b.location = "D2";

                            refreshHistory();
                        }break;
                        case "D1" : 
                        {   
                            piecesAlive[3][0] = "p4b";
                            piecesAlive[3][1] = "";

                            lblD2.setIcon(null);
                            lblD1.setIcon(pawnb);
                            p4b.location = "D1";

                            refreshHistory();
                        }break;
                    }
                }
            }
            case "p5b" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "E6" : 
                        {   
                            piecesAlive[4][5] = "p5b";
                            piecesAlive[4][6] = "";

                            lblE7.setIcon(null);
                            lblE6.setIcon(pawnb);
                            p5b.location = "E6";

                            refreshHistory();
                        }break;
                        case "E5" : 
                        {   
                            if(p5b.moves == 1)
                            {   
                                piecesAlive[4][4] = "p5b";
                                piecesAlive[4][6] = "";

                                lblE7.setIcon(null);
                                lblE5.setIcon(pawnb);
                                p5b.location = "E5";

                                refreshHistory();
                            }
                            else if(p5b.moves >= 2)
                            {   
                                piecesAlive[4][4] = "p5b";
                                piecesAlive[4][5] = "";

                                lblE6.setIcon(null);
                                lblE5.setIcon(pawnb);
                                p5b.location = "E5";

                                refreshHistory();
                            }
                        }break;  
                        case "E4" : 
                        {   
                            piecesAlive[4][3] = "p5b";
                            piecesAlive[4][4] = "";

                            lblE5.setIcon(null);
                            lblE4.setIcon(pawnb);
                            p5b.location = "E4";

                            refreshHistory();
                        }break;
                        case "E3" : 
                        {   
                            piecesAlive[4][2] = "p5b";
                            piecesAlive[4][3] = "";

                            lblE4.setIcon(null);
                            lblE3.setIcon(pawnb);
                            p5b.location = "E3";

                            refreshHistory();
                        }break;
                        case "E2" : 
                        {   
                            piecesAlive[4][1] = "p5b";
                            piecesAlive[4][2] = "";

                            lblE3.setIcon(null);
                            lblE2.setIcon(pawnb);
                            p5b.location = "E2";

                            refreshHistory();
                        }break;
                        case "E1" : 
                        {   
                            piecesAlive[4][0] = "p5b";
                            piecesAlive[4][1] = "";

                            lblE2.setIcon(null);
                            lblE1.setIcon(pawnb);
                            p5b.location = "E1";

                            refreshHistory();
                        }break;
                    }
                }
            }
            case "p6b" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "F6" : 
                        {   
                            piecesAlive[5][5] = "p6b";
                            piecesAlive[5][6] = "";

                            lblF7.setIcon(null);
                            lblF6.setIcon(pawnb);
                            p6b.location = "F6";

                            refreshHistory();
                        }break;
                        case "F5" : 
                        {   
                            if(p6b.moves == 1)
                            {   
                                piecesAlive[5][4] = "p6b";
                                piecesAlive[5][6] = "";

                                lblF7.setIcon(null);
                                lblF5.setIcon(pawnb);
                                p6b.location = "F5";

                                refreshHistory();
                            }
                            else if(p6b.moves >= 2)
                            {   
                                piecesAlive[5][4] = "p6b";
                                piecesAlive[5][5] = "";

                                lblF6.setIcon(null);
                                lblF5.setIcon(pawnb);
                                p6b.location = "F5";

                                refreshHistory();
                            }
                        }break;  
                        case "F4" : 
                        {   
                            piecesAlive[5][3] = "p6b";
                            piecesAlive[5][4] = "";

                            lblF5.setIcon(null);
                            lblF4.setIcon(pawnb);
                            p6b.location = "F4";

                            refreshHistory();
                        }break;
                        case "F3" : 
                        {   
                            piecesAlive[5][2] = "p6b";
                            piecesAlive[5][3] = "";

                            lblF4.setIcon(null);
                            lblF3.setIcon(pawnb);
                            p6b.location = "F3";

                            refreshHistory();
                        }break;
                        case "F2" : 
                        {   
                            piecesAlive[5][1] = "p6b";
                            piecesAlive[5][2] = "";

                            lblF3.setIcon(null);
                            lblF2.setIcon(pawnb);
                            p6b.location = "F2";

                            refreshHistory();
                        }break;
                        case "F1" : 
                        {   
                            piecesAlive[5][0] = "p6b";
                            piecesAlive[5][1] = "";

                            lblF2.setIcon(null);
                            lblF1.setIcon(pawnb);
                            p6b.location = "F1";

                            refreshHistory();
                        }break;
                    }
                }
            }
            case "p7b" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "G6" : 
                        {   
                            piecesAlive[6][5] = "p7b";
                            piecesAlive[6][6] = "";

                            lblG7.setIcon(null);
                            lblG6.setIcon(pawnb);
                            p7b.location = "G6";

                            refreshHistory();
                        }break;
                        case "G5" : 
                        {   
                            if(p7b.moves == 1)
                            {   
                                piecesAlive[6][4] = "p7b";
                                piecesAlive[6][6] = "";

                                lblG7.setIcon(null);
                                lblG5.setIcon(pawnb);
                                p7b.location = "G5";

                                refreshHistory();
                            }
                            else if(p7b.moves >= 2)
                            {   
                                piecesAlive[6][4] = "p7b";
                                piecesAlive[6][5] = "";

                                lblG6.setIcon(null);
                                lblG5.setIcon(pawnb);
                                p7b.location = "G5";

                                refreshHistory();
                            }
                        }break;  
                        case "G4" : 
                        {   
                            piecesAlive[6][3] = "p7b";
                            piecesAlive[6][4] = "";

                            lblG5.setIcon(null);
                            lblG4.setIcon(pawnb);
                            p7b.location = "G4";

                            refreshHistory();
                        }break;
                        case "G3" : 
                        {   
                            piecesAlive[6][2] = "p7b";
                            piecesAlive[6][3] = "";

                            lblG4.setIcon(null);
                            lblG3.setIcon(pawnb);
                            p7b.location = "G3";

                            refreshHistory();
                        }break;
                        case "G2" : 
                        {   
                            piecesAlive[6][1] = "p7b";
                            piecesAlive[6][2] = "";

                            lblG3.setIcon(null);
                            lblG2.setIcon(pawnb);
                            p7b.location = "G2";

                            refreshHistory();
                        }break;
                        case "G1" : 
                        {   
                            piecesAlive[6][0] = "p7b";
                            piecesAlive[6][1] = "";

                            lblG2.setIcon(null);
                            lblG1.setIcon(pawnb);
                            p7b.location = "G1";

                            refreshHistory();
                        }break;
                    }
                }
            }
            case "p8b" : 
            {
                if(destination.getBorder() == movement)
                {
                    switch(destination.getName())
                    {
                        case "H6" : 
                        {   
                            piecesAlive[7][5] = "p8b";
                            piecesAlive[7][6] = "";

                            lblH7.setIcon(null);
                            lblH6.setIcon(pawnb);
                            p8b.location = "H7";

                            refreshHistory();
                        }break;
                        case "H5" : 
                        {   
                            if(p8b.moves == 1)
                            {   
                                piecesAlive[7][4] = "p8b";
                                piecesAlive[7][6] = "";

                                lblH7.setIcon(null);
                                lblH5.setIcon(pawnb);
                                p8b.location = "H5";

                                refreshHistory();
                            }
                            else if(p8b.moves >= 2)
                            {   
                                piecesAlive[7][4] = "p8b";
                                piecesAlive[7][5] = "";

                                lblH6.setIcon(null);
                                lblH5.setIcon(pawnb);
                                p8b.location = "H5";

                                refreshHistory();
                            }
                        }break;  
                        case "H4" : 
                        {   
                            piecesAlive[7][3] = "p8b";
                            piecesAlive[7][4] = "";

                            lblH5.setIcon(null);
                            lblH4.setIcon(pawnb);
                            p8b.location = "H4";

                            refreshHistory();
                        }break;
                        case "H3" : 
                        {   
                            piecesAlive[7][2] = "p8b";
                            piecesAlive[7][3] = "";

                            lblH4.setIcon(null);
                            lblH3.setIcon(pawnb);
                            p8b.location = "H3";

                            refreshHistory();
                        }break;
                        case "H2" : 
                        {   
                            piecesAlive[7][1] = "p8b";
                            piecesAlive[7][2] = "";

                            lblH3.setIcon(null);
                            lblH2.setIcon(pawnb);
                            p8b.location = "H2";

                            refreshHistory();
                        }break;
                        case "H1" : 
                        {   
                            piecesAlive[7][0] = "p8b";
                            piecesAlive[7][1] = "";

                            lblH2.setIcon(null);
                            lblH1.setIcon(pawnb);
                            p8b.location = "H1";

                            refreshHistory();
                        }break;
                    }
                }
            }
            case "h1w" : 
            {
                if(destination.getBorder() == movement)
                {
                    setterOfPieceKnight("h1w", destination.getName(), knightw, h1w);
                }
            }
            case "h2w" : 
            {
                if(destination.getBorder() == movement)
                {
                    setterOfPieceKnight("h2w", destination.getName(), knightw, h2w);
                }
            }
            case "h1b" : 
            {
                if(destination.getBorder() == movement)
                {
                    setterOfPieceKnight("h1b", destination.getName(), knightb, h1b);
                }
            }
            case "h2b" : 
            {
                if(destination.getBorder() == movement)
                {
                    setterOfPieceKnight("h1b", destination.getName(), knightb, h1b);
                }
            }
            case "b1w" : 
            {
                if(destination.getBorder() == movement)
                {
                    setterOfPieceBishop("b1w", destination.getName(), bishopw, b1w);
                }
            }
            case "b2w" : 
            {
                if(destination.getBorder() == movement)
                {
                    setterOfPieceBishop("b2w", destination.getName(), bishopw, b2w);
                }
            }
            case "b1b" : 
            {
                if(destination.getBorder() == movement)
                {
                    setterOfPieceBishop("b1b", destination.getName(), bishopb, b1b);
                }
            }
            case "b2b" : 
            {
                if(destination.getBorder() == movement)
                {
                    setterOfPieceBishop("b2b", destination.getName(), bishopb, b2b);
                }
            }
            case "r1w" : 
            {
                if(destination.getBorder() == movement)
                {
                    setterOfPieceRook("r1w", destination.getName(), rookw, r1w);
                }
            }
            case "r2w" : 
            {
                if(destination.getBorder() == movement)
                {
                    setterOfPieceRook("r2w", destination.getName(), rookw, r2w);
                }
            }
            case "r1b" : 
            {
                if(destination.getBorder() == movement)
                {
                    setterOfPieceRook("r1b", destination.getName(), rookb, r1b);
                }
            }
            case "r2b" : 
            {
                if(destination.getBorder() == movement)
                {
                    setterOfPieceRook("r2b", destination.getName(), rookb, r2b);
                }
            }
        }
        
        outputToOpponent += "," + destination.getName();
    }
    //======================================================
    
    
    public class Server implements Runnable{

    ServerSocket serversocket;
    BufferedReader br1, br2;
    PrintWriter pr1;
    Socket socket;
    Thread t1, t2;
    String in="",out="";
    String[] input;

    public Server() {
        try {
            t1 = new Thread(this);
            t2 = new Thread(this);
            serversocket = new ServerSocket(5000);
            System.out.println("Server is waiting. . . . ");
            socket = serversocket.accept();
            System.out.println("Client connected with Ip " +        socket.getInetAddress().getHostAddress());
            t1.start();
            t2.start();

        } 
        catch (Exception e) 
        {
            
        }
     }

     public void run() {
        try {
            if (Thread.currentThread() == t1) {
                do {
                    br1 = new BufferedReader(new InputStreamReader(System.in));
                    pr1 = new PrintWriter(socket.getOutputStream(), true);
                    
                    if(goNoGo == 1)
                    {
                        pr1.println(outputToOpponent);
                        goNoGo = 0;
                    }
                } while (!in.equals("END"));
            } else {
                do {
                    br2 = new BufferedReader(new   InputStreamReader(socket.getInputStream()));
                    
                    out = br2.readLine();
                    String[] input;
                    if(!out.equals(null))
                    {
                        inputFromOpponent = out;
                        
                        input = inputFromOpponent.split(",");
                        if(input[0].equals("chat"))
                        {
                            if(player.equals("player2"))
                            {
                                jTextArea1.append("\nPlayer 2 : " + input[1]);
                            }
                            else if(player.equals("player1"))
                            {
                                jTextArea1.append("\nPlayer 1 : " + input[1]);
                            }
                        }
                        else if(input[0].equals("move"))
                        {
                            switch(input[2])
                            { 
                                case "A1" : premovePiece(input[1], lblA1); break;
                                case "A2" : premovePiece(input[1], lblA2); break;
                                case "A3" : premovePiece(input[1], lblA3); break;
                                case "A4" : premovePiece(input[1], lblA4); break;
                                case "A5" : premovePiece(input[1], lblA5); break;
                                case "A6" : premovePiece(input[1], lblA6); break;
                                case "A7" : premovePiece(input[1], lblA7); break;
                                case "A8" : premovePiece(input[1], lblA8); break;

                                case "B1" : premovePiece(input[1], lblB1); break;
                                case "B2" : premovePiece(input[1], lblB2); break;
                                case "B3" : premovePiece(input[1], lblB3); break;
                                case "B4" : premovePiece(input[1], lblB4); break;
                                case "B5" : premovePiece(input[1], lblB5); break;
                                case "B6" : premovePiece(input[1], lblB6); break;
                                case "B7" : premovePiece(input[1], lblB7); break;
                                case "B8" : premovePiece(input[1], lblB8); break;
                                case "C1" : premovePiece(input[1], lblC1); break;
                                case "C2" : premovePiece(input[1], lblC2); break;
                                case "C3" : premovePiece(input[1], lblC3); break;
                                case "C4" : premovePiece(input[1], lblC4); break;
                                case "C5" : premovePiece(input[1], lblC5); break;
                                case "C6" : premovePiece(input[1], lblC6); break;
                                case "C7" : premovePiece(input[1], lblC7); break;
                                case "C8" : premovePiece(input[1], lblC8); break;

                                case "D1" : premovePiece(input[1], lblD1); break;
                                case "D2" : premovePiece(input[1], lblD2); break;
                                case "D3" : premovePiece(input[1], lblD3); break;
                                case "D4" : premovePiece(input[1], lblD4); break;
                                case "D5" : premovePiece(input[1], lblD5); break;
                                case "D6" : premovePiece(input[1], lblD6); break;
                                case "D7" : premovePiece(input[1], lblD7); break;
                                case "D8" : premovePiece(input[1], lblD8); break;

                                case "E1" : premovePiece(input[1], lblE1); break;
                                case "E2" : premovePiece(input[1], lblE2); break;
                                case "E3" : premovePiece(input[1], lblE3); break;
                                case "E4" : premovePiece(input[1], lblE4); break;
                                case "E5" : premovePiece(input[1], lblE5); break;
                                case "E6" : premovePiece(input[1], lblE6); break;
                                case "E7" : premovePiece(input[1], lblE7); break;
                                case "E8" : premovePiece(input[1], lblE8); break;

                                case "F1" : premovePiece(input[1], lblF1); break;
                                case "F2" : premovePiece(input[1], lblF2); break;
                                case "F3" : premovePiece(input[1], lblF3); break;
                                case "F4" : premovePiece(input[1], lblF4); break;
                                case "F5" : premovePiece(input[1], lblF5); break;
                                case "F6" : premovePiece(input[1], lblF6); break;
                                case "F7" : premovePiece(input[1], lblF7); break;
                                case "F8" : premovePiece(input[1], lblF8); break;
                                
                                case "G1" : premovePiece(input[1], lblG1); break;
                                case "G2" : premovePiece(input[1], lblG2); break;
                                case "G3" : premovePiece(input[1], lblG3); break;
                                case "G4" : premovePiece(input[1], lblG4); break;
                                case "G5" : premovePiece(input[1], lblG5); break;
                                case "G6" : premovePiece(input[1], lblG6); break;
                                case "G7" : premovePiece(input[1], lblG7); break;
                                case "G8" : premovePiece(input[1], lblG8); break;
                                
                                case "H1" : premovePiece(input[1], lblH1); break;
                                case "H2" : premovePiece(input[1], lblH2); break;
                                case "H3" : premovePiece(input[1], lblH3); break;
                                case "H4" : premovePiece(input[1], lblH4); break;
                                case "H5" : premovePiece(input[1], lblH5); break;
                                case "H6" : premovePiece(input[1], lblH6); break;
                                case "H7" : premovePiece(input[1], lblH7); break;
                                case "H8" : premovePiece(input[1], lblH8); break;
                            }

                            switch(input[3])
                            {
                                case "A1" : postmovePiece1(input[1], A1); break;
                                case "A2" : postmovePiece1(input[1], A2); break;
                                case "A3" : postmovePiece1(input[1], A3); break;
                                case "A4" : postmovePiece1(input[1], A4); break;
                                case "A5" : postmovePiece1(input[1], A5); break;
                                case "A6" : postmovePiece1(input[1], A6); break;
                                case "A7" : postmovePiece1(input[1], A7); break;
                                case "A8" : postmovePiece1(input[1], A8); break;

                                case "B1" : postmovePiece1(input[1], B1); break;
                                case "B2" : postmovePiece1(input[1], B2); break;
                                case "B3" : postmovePiece1(input[1], B3); break;
                                case "B4" : postmovePiece1(input[1], B4); break;
                                case "B5" : postmovePiece1(input[1], B5); break;
                                case "B6" : postmovePiece1(input[1], B6); break;
                                case "B7" : postmovePiece1(input[1], B7); break;
                                case "B8" : postmovePiece1(input[1], B8); break;

                                case "C1" : postmovePiece1(input[1], C1); break;
                                case "C2" : postmovePiece1(input[1], C2); break;
                                case "C3" : postmovePiece1(input[1], C3); break;
                                case "C4" : postmovePiece1(input[1], C4); break;
                                case "C5" : postmovePiece1(input[1], C5); break;
                                case "C6" : postmovePiece1(input[1], C6); break;
                                case "C7" : postmovePiece1(input[1], C7); break;
                                case "C8" : postmovePiece1(input[1], C8); break;

                                case "D1" : postmovePiece1(input[1], D1); break;
                                case "D2" : postmovePiece1(input[1], D2); break;
                                case "D3" : postmovePiece1(input[1], D3); break;
                                case "D4" : postmovePiece1(input[1], D4); break;
                                case "D5" : postmovePiece1(input[1], D5); break;
                                case "D6" : postmovePiece1(input[1], D6); break;
                                case "D7" : postmovePiece1(input[1], D7); break;
                                case "D8" : postmovePiece1(input[1], D8); break;

                                case "E1" : postmovePiece1(input[1], E1); break;
                                case "E2" : postmovePiece1(input[1], E2); break;
                                case "E3" : postmovePiece1(input[1], E3); break;
                                case "E4" : postmovePiece1(input[1], E4); break;
                                case "E5" : postmovePiece1(input[1], E5); break;
                                case "E6" : postmovePiece1(input[1], E6); break;
                                case "E7" : postmovePiece1(input[1], E7); break;
                                case "E8" : postmovePiece1(input[1], E8); break;

                                case "F1" : postmovePiece1(input[1], F1); break;
                                case "F2" : postmovePiece1(input[1], F2); break;
                                case "F3" : postmovePiece1(input[1], F3); break;
                                case "F4" : postmovePiece1(input[1], F4); break;
                                case "F5" : postmovePiece1(input[1], F5); break;
                                case "F6" : postmovePiece1(input[1], F6); break;
                                case "F7" : postmovePiece1(input[1], F7); break;
                                case "F8" : postmovePiece1(input[1], F8); break;

                                case "G1" : postmovePiece1(input[1], G1); break;
                                case "G2" : postmovePiece1(input[1], G2); break;
                                case "G3" : postmovePiece1(input[1], G3); break;
                                case "G4" : postmovePiece1(input[1], G4); break;
                                case "G5" : postmovePiece1(input[1], G5); break;
                                case "G6" : postmovePiece1(input[1], G6); break;
                                case "G7" : postmovePiece1(input[1], G7); break;
                                case "G8" : postmovePiece1(input[1], G8); break;

                                case "H1" : postmovePiece1(input[1], H1); break;
                                case "H2" : postmovePiece1(input[1], H2); break;
                                case "H3" : postmovePiece1(input[1], H3); break;
                                case "H4" : postmovePiece1(input[1], H4); break;
                                case "H5" : postmovePiece1(input[1], H5); break;
                                case "H6" : postmovePiece1(input[1], H6); break;
                                case "H7" : postmovePiece1(input[1], H7); break;
                                case "H8" : postmovePiece1(input[1], H8); break;

                            }
                        }
                    }
                    
                } while (!out.equals("END"));
            }
        } catch (Exception e) {
        }
        }
    }
    
    public class Client implements Runnable {

    BufferedReader br1, br2;
    PrintWriter pr1;
    Socket socket;
    Thread t1, t2;
    String in = "", out = "";

    public Client() {
        try {
            t1 = new Thread(this);
            t2 = new Thread(this);
            socket = new Socket(url, 5000);
            t1.start();
            t2.start();

        } catch (Exception e) {
        }
    }

    public void run() {

        try {
            if (Thread.currentThread() == t2) {
                do {
                    br1 = new BufferedReader(new InputStreamReader(System.in));
                    pr1 = new PrintWriter(socket.getOutputStream(), true);
                    if(goNoGo == 1)
                    {
                        pr1.println(outputToOpponent);
                        goNoGo = 0;
                    }
                } while (!in.equals("END"));
            } else {
                do {
                    br2 = new BufferedReader(new   InputStreamReader(socket.getInputStream()));
                    out = br2.readLine();
                    String[] input;
                    if(!out.equals(null))
                    {
                        inputFromOpponent = out;
                        
                        input = inputFromOpponent.split(",");
                        
                        if(input[0].equals("chat"))
                        {
                            if(player.equals("player2"))
                            {
                                jTextArea1.append("\nPlayer 2 : " + input[1]);
                            }
                            else if(player.equals("player1"))
                            {
                                jTextArea1.append("\nPlayer 1 : " + input[1]);
                            }
                        }
                        else if(input[0].equals("move"))
                        {
                            switch(input[2])
                            { 
                                case "A1" : premovePiece(input[1], lblA1); break;
                                case "A2" : premovePiece(input[1], lblA2); break;
                                case "A3" : premovePiece(input[1], lblA3); break;
                                case "A4" : premovePiece(input[1], lblA4); break;
                                case "A5" : premovePiece(input[1], lblA5); break;
                                case "A6" : premovePiece(input[1], lblA6); break;
                                case "A7" : premovePiece(input[1], lblA7); break;
                                case "A8" : premovePiece(input[1], lblA8); break;

                                case "B1" : premovePiece(input[1], lblB1); break;
                                case "B2" : premovePiece(input[1], lblB2); break;
                                case "B3" : premovePiece(input[1], lblB3); break;
                                case "B4" : premovePiece(input[1], lblB4); break;
                                case "B5" : premovePiece(input[1], lblB5); break;
                                case "B6" : premovePiece(input[1], lblB6); break;
                                case "B7" : premovePiece(input[1], lblB7); break;
                                case "B8" : premovePiece(input[1], lblB8); break;
                                case "C1" : premovePiece(input[1], lblC1); break;
                                case "C2" : premovePiece(input[1], lblC2); break;
                                case "C3" : premovePiece(input[1], lblC3); break;
                                case "C4" : premovePiece(input[1], lblC4); break;
                                case "C5" : premovePiece(input[1], lblC5); break;
                                case "C6" : premovePiece(input[1], lblC6); break;
                                case "C7" : premovePiece(input[1], lblC7); break;
                                case "C8" : premovePiece(input[1], lblC8); break;

                                case "D1" : premovePiece(input[1], lblD1); break;
                                case "D2" : premovePiece(input[1], lblD2); break;
                                case "D3" : premovePiece(input[1], lblD3); break;
                                case "D4" : premovePiece(input[1], lblD4); break;
                                case "D5" : premovePiece(input[1], lblD5); break;
                                case "D6" : premovePiece(input[1], lblD6); break;
                                case "D7" : premovePiece(input[1], lblD7); break;
                                case "D8" : premovePiece(input[1], lblD8); break;

                                case "E1" : premovePiece(input[1], lblE1); break;
                                case "E2" : premovePiece(input[1], lblE2); break;
                                case "E3" : premovePiece(input[1], lblE3); break;
                                case "E4" : premovePiece(input[1], lblE4); break;
                                case "E5" : premovePiece(input[1], lblE5); break;
                                case "E6" : premovePiece(input[1], lblE6); break;
                                case "E7" : premovePiece(input[1], lblE7); break;
                                case "E8" : premovePiece(input[1], lblE8); break;

                                case "F1" : premovePiece(input[1], lblF1); break;
                                case "F2" : premovePiece(input[1], lblF2); break;
                                case "F3" : premovePiece(input[1], lblF3); break;
                                case "F4" : premovePiece(input[1], lblF4); break;
                                case "F5" : premovePiece(input[1], lblF5); break;
                                case "F6" : premovePiece(input[1], lblF6); break;
                                case "F7" : premovePiece(input[1], lblF7); break;
                                case "F8" : premovePiece(input[1], lblF8); break;
                                
                                case "G1" : premovePiece(input[1], lblG1); break;
                                case "G2" : premovePiece(input[1], lblG2); break;
                                case "G3" : premovePiece(input[1], lblG3); break;
                                case "G4" : premovePiece(input[1], lblG4); break;
                                case "G5" : premovePiece(input[1], lblG5); break;
                                case "G6" : premovePiece(input[1], lblG6); break;
                                case "G7" : premovePiece(input[1], lblG7); break;
                                case "G8" : premovePiece(input[1], lblG8); break;
                                
                                case "H1" : premovePiece(input[1], lblH1); break;
                                case "H2" : premovePiece(input[1], lblH2); break;
                                case "H3" : premovePiece(input[1], lblH3); break;
                                case "H4" : premovePiece(input[1], lblH4); break;
                                case "H5" : premovePiece(input[1], lblH5); break;
                                case "H6" : premovePiece(input[1], lblH6); break;
                                case "H7" : premovePiece(input[1], lblH7); break;
                                case "H8" : premovePiece(input[1], lblH8); break;
                            }

                            switch(input[3])
                            {
                                case "A1" : postmovePiece1(input[1], A1); break;
                                case "A2" : postmovePiece1(input[1], A2); break;
                                case "A3" : postmovePiece1(input[1], A3); break;
                                case "A4" : postmovePiece1(input[1], A4); break;
                                case "A5" : postmovePiece1(input[1], A5); break;
                                case "A6" : postmovePiece1(input[1], A6); break;
                                case "A7" : postmovePiece1(input[1], A7); break;
                                case "A8" : postmovePiece1(input[1], A8); break;

                                case "B1" : postmovePiece1(input[1], B1); break;
                                case "B2" : postmovePiece1(input[1], B2); break;
                                case "B3" : postmovePiece1(input[1], B3); break;
                                case "B4" : postmovePiece1(input[1], B4); break;
                                case "B5" : postmovePiece1(input[1], B5); break;
                                case "B6" : postmovePiece1(input[1], B6); break;
                                case "B7" : postmovePiece1(input[1], B7); break;
                                case "B8" : postmovePiece1(input[1], B8); break;

                                case "C1" : postmovePiece1(input[1], C1); break;
                                case "C2" : postmovePiece1(input[1], C2); break;
                                case "C3" : postmovePiece1(input[1], C3); break;
                                case "C4" : postmovePiece1(input[1], C4); break;
                                case "C5" : postmovePiece1(input[1], C5); break;
                                case "C6" : postmovePiece1(input[1], C6); break;
                                case "C7" : postmovePiece1(input[1], C7); break;
                                case "C8" : postmovePiece1(input[1], C8); break;

                                case "D1" : postmovePiece1(input[1], D1); break;
                                case "D2" : postmovePiece1(input[1], D2); break;
                                case "D3" : postmovePiece1(input[1], D3); break;
                                case "D4" : postmovePiece1(input[1], D4); break;
                                case "D5" : postmovePiece1(input[1], D5); break;
                                case "D6" : postmovePiece1(input[1], D6); break;
                                case "D7" : postmovePiece1(input[1], D7); break;
                                case "D8" : postmovePiece1(input[1], D8); break;

                                case "E1" : postmovePiece1(input[1], E1); break;
                                case "E2" : postmovePiece1(input[1], E2); break;
                                case "E3" : postmovePiece1(input[1], E3); break;
                                case "E4" : postmovePiece1(input[1], E4); break;
                                case "E5" : postmovePiece1(input[1], E5); break;
                                case "E6" : postmovePiece1(input[1], E6); break;
                                case "E7" : postmovePiece1(input[1], E7); break;
                                case "E8" : postmovePiece1(input[1], E8); break;

                                case "F1" : postmovePiece1(input[1], F1); break;
                                case "F2" : postmovePiece1(input[1], F2); break;
                                case "F3" : postmovePiece1(input[1], F3); break;
                                case "F4" : postmovePiece1(input[1], F4); break;
                                case "F5" : postmovePiece1(input[1], F5); break;
                                case "F6" : postmovePiece1(input[1], F6); break;
                                case "F7" : postmovePiece1(input[1], F7); break;
                                case "F8" : postmovePiece1(input[1], F8); break;

                                case "G1" : postmovePiece1(input[1], G1); break;
                                case "G2" : postmovePiece1(input[1], G2); break;
                                case "G3" : postmovePiece1(input[1], G3); break;
                                case "G4" : postmovePiece1(input[1], G4); break;
                                case "G5" : postmovePiece1(input[1], G5); break;
                                case "G6" : postmovePiece1(input[1], G6); break;
                                case "G7" : postmovePiece1(input[1], G7); break;
                                case "G8" : postmovePiece1(input[1], G8); break;

                                case "H1" : postmovePiece1(input[1], H1); break;
                                case "H2" : postmovePiece1(input[1], H2); break;
                                case "H3" : postmovePiece1(input[1], H3); break;
                                case "H4" : postmovePiece1(input[1], H4); break;
                                case "H5" : postmovePiece1(input[1], H5); break;
                                case "H6" : postmovePiece1(input[1], H6); break;
                                case "H7" : postmovePiece1(input[1], H7); break;
                                case "H8" : postmovePiece1(input[1], H8); break;

                            }
                        }
                     
                    }
                } while (!out.equals("END"));
            }
        } catch (Exception e) {
        }

     }
    }

    /**
     * Creates new form MainFrame
     */
    public MainFrame(String player) {
        initComponents();
        
        refreshBoard();
//        
//        this.player = player;
//        if ("player1".equals(player)){
//            new Server();
//        }else if("player2".equals(player)){
//            new Client();
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        A8 = new javax.swing.JPanel();
        lblA8 = new javax.swing.JLabel();
        B8 = new javax.swing.JPanel();
        lblB8 = new javax.swing.JLabel();
        C8 = new javax.swing.JPanel();
        lblC8 = new javax.swing.JLabel();
        D8 = new javax.swing.JPanel();
        lblD8 = new javax.swing.JLabel();
        E8 = new javax.swing.JPanel();
        lblE8 = new javax.swing.JLabel();
        F8 = new javax.swing.JPanel();
        lblF8 = new javax.swing.JLabel();
        G8 = new javax.swing.JPanel();
        lblG8 = new javax.swing.JLabel();
        H8 = new javax.swing.JPanel();
        lblH8 = new javax.swing.JLabel();
        A7 = new javax.swing.JPanel();
        lblA7 = new javax.swing.JLabel();
        B7 = new javax.swing.JPanel();
        lblB7 = new javax.swing.JLabel();
        C7 = new javax.swing.JPanel();
        lblC7 = new javax.swing.JLabel();
        D7 = new javax.swing.JPanel();
        lblD7 = new javax.swing.JLabel();
        E7 = new javax.swing.JPanel();
        lblE7 = new javax.swing.JLabel();
        F7 = new javax.swing.JPanel();
        lblF7 = new javax.swing.JLabel();
        G7 = new javax.swing.JPanel();
        lblG7 = new javax.swing.JLabel();
        H7 = new javax.swing.JPanel();
        lblH7 = new javax.swing.JLabel();
        A6 = new javax.swing.JPanel();
        lblA6 = new javax.swing.JLabel();
        B6 = new javax.swing.JPanel();
        lblB6 = new javax.swing.JLabel();
        C6 = new javax.swing.JPanel();
        lblC6 = new javax.swing.JLabel();
        D6 = new javax.swing.JPanel();
        lblD6 = new javax.swing.JLabel();
        E6 = new javax.swing.JPanel();
        lblE6 = new javax.swing.JLabel();
        F6 = new javax.swing.JPanel();
        lblF6 = new javax.swing.JLabel();
        G6 = new javax.swing.JPanel();
        lblG6 = new javax.swing.JLabel();
        H6 = new javax.swing.JPanel();
        lblH6 = new javax.swing.JLabel();
        A5 = new javax.swing.JPanel();
        lblA5 = new javax.swing.JLabel();
        B5 = new javax.swing.JPanel();
        lblB5 = new javax.swing.JLabel();
        C5 = new javax.swing.JPanel();
        lblC5 = new javax.swing.JLabel();
        D5 = new javax.swing.JPanel();
        lblD5 = new javax.swing.JLabel();
        E5 = new javax.swing.JPanel();
        lblE5 = new javax.swing.JLabel();
        F5 = new javax.swing.JPanel();
        lblF5 = new javax.swing.JLabel();
        G5 = new javax.swing.JPanel();
        lblG5 = new javax.swing.JLabel();
        H5 = new javax.swing.JPanel();
        lblH5 = new javax.swing.JLabel();
        A4 = new javax.swing.JPanel();
        lblA4 = new javax.swing.JLabel();
        B4 = new javax.swing.JPanel();
        lblB4 = new javax.swing.JLabel();
        C4 = new javax.swing.JPanel();
        lblC4 = new javax.swing.JLabel();
        D4 = new javax.swing.JPanel();
        lblD4 = new javax.swing.JLabel();
        E4 = new javax.swing.JPanel();
        lblE4 = new javax.swing.JLabel();
        F4 = new javax.swing.JPanel();
        lblF4 = new javax.swing.JLabel();
        G4 = new javax.swing.JPanel();
        lblG4 = new javax.swing.JLabel();
        H4 = new javax.swing.JPanel();
        lblH4 = new javax.swing.JLabel();
        A3 = new javax.swing.JPanel();
        lblA3 = new javax.swing.JLabel();
        B3 = new javax.swing.JPanel();
        lblB3 = new javax.swing.JLabel();
        C3 = new javax.swing.JPanel();
        lblC3 = new javax.swing.JLabel();
        D3 = new javax.swing.JPanel();
        lblD3 = new javax.swing.JLabel();
        E3 = new javax.swing.JPanel();
        lblE3 = new javax.swing.JLabel();
        F3 = new javax.swing.JPanel();
        lblF3 = new javax.swing.JLabel();
        G3 = new javax.swing.JPanel();
        lblG3 = new javax.swing.JLabel();
        H3 = new javax.swing.JPanel();
        lblH3 = new javax.swing.JLabel();
        A2 = new javax.swing.JPanel();
        lblA2 = new javax.swing.JLabel();
        B2 = new javax.swing.JPanel();
        lblB2 = new javax.swing.JLabel();
        C2 = new javax.swing.JPanel();
        lblC2 = new javax.swing.JLabel();
        D2 = new javax.swing.JPanel();
        lblD2 = new javax.swing.JLabel();
        E2 = new javax.swing.JPanel();
        lblE2 = new javax.swing.JLabel();
        F2 = new javax.swing.JPanel();
        lblF2 = new javax.swing.JLabel();
        G2 = new javax.swing.JPanel();
        lblG2 = new javax.swing.JLabel();
        H2 = new javax.swing.JPanel();
        lblH2 = new javax.swing.JLabel();
        A1 = new javax.swing.JPanel();
        lblA1 = new javax.swing.JLabel();
        B1 = new javax.swing.JPanel();
        lblB1 = new javax.swing.JLabel();
        C1 = new javax.swing.JPanel();
        lblC1 = new javax.swing.JLabel();
        D1 = new javax.swing.JPanel();
        lblD1 = new javax.swing.JLabel();
        E1 = new javax.swing.JPanel();
        lblE1 = new javax.swing.JLabel();
        F1 = new javax.swing.JPanel();
        lblF1 = new javax.swing.JLabel();
        G1 = new javax.swing.JPanel();
        lblG1 = new javax.swing.JLabel();
        H1 = new javax.swing.JPanel();
        lblH1 = new javax.swing.JLabel();
        jPanelSide = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField2 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chess");
        setResizable(false);

        A8.setBackground(new java.awt.Color(238, 191, 120));
        A8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        A8.setMinimumSize(new java.awt.Dimension(100, 75));
        A8.setName("A8"); // NOI18N
        A8.setPreferredSize(new java.awt.Dimension(100, 100));
        A8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A8MouseClicked(evt);
            }
        });
        A8.setLayout(new java.awt.GridBagLayout());

        lblA8.setName("A8"); // NOI18N
        lblA8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblA8MouseClicked(evt);
            }
        });
        A8.add(lblA8, new java.awt.GridBagConstraints());

        B8.setBackground(new java.awt.Color(170, 102, 26));
        B8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        B8.setMinimumSize(new java.awt.Dimension(100, 100));
        B8.setName("B8"); // NOI18N
        B8.setPreferredSize(new java.awt.Dimension(100, 100));
        B8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B8MouseClicked(evt);
            }
        });
        B8.setLayout(new java.awt.GridBagLayout());

        lblB8.setName("B8"); // NOI18N
        lblB8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblB8MouseClicked(evt);
            }
        });
        B8.add(lblB8, new java.awt.GridBagConstraints());

        C8.setBackground(new java.awt.Color(238, 191, 120));
        C8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        C8.setName("C8"); // NOI18N
        C8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C8MouseClicked(evt);
            }
        });
        C8.setLayout(new java.awt.GridBagLayout());

        lblC8.setName("C8"); // NOI18N
        lblC8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblC8MouseClicked(evt);
            }
        });
        C8.add(lblC8, new java.awt.GridBagConstraints());

        D8.setBackground(new java.awt.Color(170, 102, 26));
        D8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        D8.setName("D8"); // NOI18N
        D8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D8MouseClicked(evt);
            }
        });
        D8.setLayout(new java.awt.GridBagLayout());

        lblD8.setName("D8"); // NOI18N
        lblD8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblD8MouseClicked(evt);
            }
        });
        D8.add(lblD8, new java.awt.GridBagConstraints());

        E8.setBackground(new java.awt.Color(238, 191, 120));
        E8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        E8.setName("E8"); // NOI18N
        E8.setRequestFocusEnabled(false);
        E8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E8MouseClicked(evt);
            }
        });
        E8.setLayout(new java.awt.GridBagLayout());

        lblE8.setName("E8"); // NOI18N
        lblE8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblE8MouseClicked(evt);
            }
        });
        E8.add(lblE8, new java.awt.GridBagConstraints());

        F8.setBackground(new java.awt.Color(170, 102, 26));
        F8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        F8.setName("F8"); // NOI18N
        F8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F8MouseClicked(evt);
            }
        });
        F8.setLayout(new java.awt.GridBagLayout());

        lblF8.setName("F8"); // NOI18N
        lblF8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblF8MouseClicked(evt);
            }
        });
        F8.add(lblF8, new java.awt.GridBagConstraints());

        G8.setBackground(new java.awt.Color(238, 191, 120));
        G8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        G8.setName("G8"); // NOI18N
        G8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                G8MouseClicked(evt);
            }
        });
        G8.setLayout(new java.awt.GridBagLayout());

        lblG8.setName("G8"); // NOI18N
        lblG8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblG8MouseClicked(evt);
            }
        });
        G8.add(lblG8, new java.awt.GridBagConstraints());

        H8.setBackground(new java.awt.Color(170, 102, 26));
        H8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        H8.setName("H8"); // NOI18N
        H8.setPreferredSize(new java.awt.Dimension(75, 100));
        H8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                H8MouseClicked(evt);
            }
        });
        H8.setLayout(new java.awt.GridBagLayout());

        lblH8.setName("H8"); // NOI18N
        lblH8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblH8MouseClicked(evt);
            }
        });
        H8.add(lblH8, new java.awt.GridBagConstraints());

        A7.setBackground(new java.awt.Color(170, 102, 26));
        A7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        A7.setName("A7"); // NOI18N
        A7.setPreferredSize(new java.awt.Dimension(100, 100));
        A7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A7MouseClicked(evt);
            }
        });
        A7.setLayout(new java.awt.GridBagLayout());

        lblA7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblA7.setName("A7"); // NOI18N
        lblA7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblA7MouseClicked(evt);
            }
        });
        A7.add(lblA7, new java.awt.GridBagConstraints());

        B7.setBackground(new java.awt.Color(238, 191, 120));
        B7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        B7.setName("B7"); // NOI18N
        B7.setPreferredSize(new java.awt.Dimension(100, 100));
        B7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B7MouseClicked(evt);
            }
        });
        B7.setLayout(new java.awt.GridBagLayout());

        lblB7.setName("B7"); // NOI18N
        lblB7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblB7MouseClicked(evt);
            }
        });
        B7.add(lblB7, new java.awt.GridBagConstraints());

        C7.setBackground(new java.awt.Color(170, 102, 26));
        C7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        C7.setName("C7"); // NOI18N
        C7.setPreferredSize(new java.awt.Dimension(100, 100));
        C7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C7MouseClicked(evt);
            }
        });
        C7.setLayout(new java.awt.GridBagLayout());

        lblC7.setName("C7"); // NOI18N
        lblC7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblC7MouseClicked(evt);
            }
        });
        C7.add(lblC7, new java.awt.GridBagConstraints());

        D7.setBackground(new java.awt.Color(238, 191, 120));
        D7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        D7.setName("D7"); // NOI18N
        D7.setPreferredSize(new java.awt.Dimension(100, 100));
        D7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D7MouseClicked(evt);
            }
        });
        D7.setLayout(new java.awt.GridBagLayout());

        lblD7.setName("D7"); // NOI18N
        lblD7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblD7MouseClicked(evt);
            }
        });
        D7.add(lblD7, new java.awt.GridBagConstraints());

        E7.setBackground(new java.awt.Color(170, 102, 26));
        E7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        E7.setName("E7"); // NOI18N
        E7.setPreferredSize(new java.awt.Dimension(100, 100));
        E7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E7MouseClicked(evt);
            }
        });
        E7.setLayout(new java.awt.GridBagLayout());

        lblE7.setName("E7"); // NOI18N
        lblE7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblE7MouseClicked(evt);
            }
        });
        E7.add(lblE7, new java.awt.GridBagConstraints());

        F7.setBackground(new java.awt.Color(238, 191, 120));
        F7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        F7.setName("F7"); // NOI18N
        F7.setPreferredSize(new java.awt.Dimension(100, 100));
        F7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F7MouseClicked(evt);
            }
        });
        F7.setLayout(new java.awt.GridBagLayout());

        lblF7.setName("F7"); // NOI18N
        lblF7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblF7MouseClicked(evt);
            }
        });
        F7.add(lblF7, new java.awt.GridBagConstraints());

        G7.setBackground(new java.awt.Color(170, 102, 26));
        G7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        G7.setName("G7"); // NOI18N
        G7.setPreferredSize(new java.awt.Dimension(100, 100));
        G7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                G7MouseClicked(evt);
            }
        });
        G7.setLayout(new java.awt.GridBagLayout());

        lblG7.setName("G7"); // NOI18N
        lblG7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblG7MouseClicked(evt);
            }
        });
        G7.add(lblG7, new java.awt.GridBagConstraints());

        H7.setBackground(new java.awt.Color(238, 191, 120));
        H7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        H7.setName("H7"); // NOI18N
        H7.setPreferredSize(new java.awt.Dimension(100, 100));
        H7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                H7MouseClicked(evt);
            }
        });
        H7.setLayout(new java.awt.GridBagLayout());

        lblH7.setName("H7"); // NOI18N
        lblH7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblH7MouseClicked(evt);
            }
        });
        H7.add(lblH7, new java.awt.GridBagConstraints());

        A6.setBackground(new java.awt.Color(238, 191, 120));
        A6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        A6.setMaximumSize(new java.awt.Dimension(100, 100));
        A6.setMinimumSize(new java.awt.Dimension(100, 100));
        A6.setName("A6"); // NOI18N
        A6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A6MouseClicked(evt);
            }
        });
        A6.setLayout(new java.awt.GridBagLayout());

        lblA6.setName("A6"); // NOI18N
        lblA6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblA6MouseClicked(evt);
            }
        });
        A6.add(lblA6, new java.awt.GridBagConstraints());

        B6.setBackground(new java.awt.Color(170, 102, 26));
        B6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        B6.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        B6.setName("B6"); // NOI18N
        B6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B6MouseClicked(evt);
            }
        });
        B6.setLayout(new java.awt.GridBagLayout());

        lblB6.setName("B6"); // NOI18N
        lblB6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblB6MouseClicked(evt);
            }
        });
        B6.add(lblB6, new java.awt.GridBagConstraints());

        C6.setBackground(new java.awt.Color(238, 191, 120));
        C6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        C6.setName("C6"); // NOI18N
        C6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C6MouseClicked(evt);
            }
        });
        C6.setLayout(new java.awt.GridBagLayout());

        lblC6.setName("C6"); // NOI18N
        lblC6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblC6MouseClicked(evt);
            }
        });
        C6.add(lblC6, new java.awt.GridBagConstraints());

        D6.setBackground(new java.awt.Color(170, 102, 26));
        D6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        D6.setName("D6"); // NOI18N
        D6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D6MouseClicked(evt);
            }
        });
        D6.setLayout(new java.awt.GridBagLayout());

        lblD6.setName("D6"); // NOI18N
        lblD6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblD6MouseClicked(evt);
            }
        });
        D6.add(lblD6, new java.awt.GridBagConstraints());

        E6.setBackground(new java.awt.Color(238, 191, 120));
        E6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        E6.setName("E6"); // NOI18N
        E6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E6MouseClicked(evt);
            }
        });
        E6.setLayout(new java.awt.GridBagLayout());

        lblE6.setName("E6"); // NOI18N
        lblE6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblE6MouseClicked(evt);
            }
        });
        E6.add(lblE6, new java.awt.GridBagConstraints());

        F6.setBackground(new java.awt.Color(170, 102, 26));
        F6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        F6.setName("F6"); // NOI18N
        F6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F6MouseClicked(evt);
            }
        });
        F6.setLayout(new java.awt.GridBagLayout());

        lblF6.setName("F6"); // NOI18N
        lblF6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblF6MouseClicked(evt);
            }
        });
        F6.add(lblF6, new java.awt.GridBagConstraints());

        G6.setBackground(new java.awt.Color(238, 191, 120));
        G6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        G6.setName("G6"); // NOI18N
        G6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                G6MouseClicked(evt);
            }
        });
        G6.setLayout(new java.awt.GridBagLayout());

        lblG6.setName("G6"); // NOI18N
        lblG6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblG6MouseClicked(evt);
            }
        });
        G6.add(lblG6, new java.awt.GridBagConstraints());

        H6.setBackground(new java.awt.Color(170, 102, 26));
        H6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        H6.setName("H6"); // NOI18N
        H6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                H6MouseClicked(evt);
            }
        });
        H6.setLayout(new java.awt.GridBagLayout());

        lblH6.setName("H6"); // NOI18N
        lblH6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblH6MouseClicked(evt);
            }
        });
        H6.add(lblH6, new java.awt.GridBagConstraints());

        A5.setBackground(new java.awt.Color(170, 102, 26));
        A5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        A5.setMaximumSize(new java.awt.Dimension(100, 100));
        A5.setMinimumSize(new java.awt.Dimension(100, 100));
        A5.setName("A5"); // NOI18N
        A5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A5MouseClicked(evt);
            }
        });
        A5.setLayout(new java.awt.GridBagLayout());

        lblA5.setName("A5"); // NOI18N
        lblA5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblA5MouseClicked(evt);
            }
        });
        A5.add(lblA5, new java.awt.GridBagConstraints());

        B5.setBackground(new java.awt.Color(238, 191, 120));
        B5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        B5.setName("B5"); // NOI18N
        B5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B5MouseClicked(evt);
            }
        });
        B5.setLayout(new java.awt.GridBagLayout());

        lblB5.setName("B5"); // NOI18N
        lblB5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblB5MouseClicked(evt);
            }
        });
        B5.add(lblB5, new java.awt.GridBagConstraints());

        C5.setBackground(new java.awt.Color(170, 102, 26));
        C5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        C5.setMaximumSize(new java.awt.Dimension(100, 100));
        C5.setMinimumSize(new java.awt.Dimension(100, 100));
        C5.setName("C5"); // NOI18N
        C5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C5MouseClicked(evt);
            }
        });
        C5.setLayout(new java.awt.GridBagLayout());

        lblC5.setName("C5"); // NOI18N
        lblC5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblC5MouseClicked(evt);
            }
        });
        C5.add(lblC5, new java.awt.GridBagConstraints());

        D5.setBackground(new java.awt.Color(238, 191, 120));
        D5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        D5.setMaximumSize(new java.awt.Dimension(100, 100));
        D5.setMinimumSize(new java.awt.Dimension(100, 100));
        D5.setName("D5"); // NOI18N
        D5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D5MouseClicked(evt);
            }
        });
        D5.setLayout(new java.awt.GridBagLayout());

        lblD5.setName("D5"); // NOI18N
        lblD5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblD5MouseClicked(evt);
            }
        });
        D5.add(lblD5, new java.awt.GridBagConstraints());

        E5.setBackground(new java.awt.Color(170, 102, 26));
        E5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        E5.setMaximumSize(new java.awt.Dimension(100, 100));
        E5.setMinimumSize(new java.awt.Dimension(100, 100));
        E5.setName("E5"); // NOI18N
        E5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E5MouseClicked(evt);
            }
        });
        E5.setLayout(new java.awt.GridBagLayout());

        lblE5.setName("E5"); // NOI18N
        lblE5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblE5MouseClicked(evt);
            }
        });
        E5.add(lblE5, new java.awt.GridBagConstraints());

        F5.setBackground(new java.awt.Color(238, 191, 120));
        F5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        F5.setMaximumSize(new java.awt.Dimension(100, 100));
        F5.setMinimumSize(new java.awt.Dimension(100, 100));
        F5.setName("F5"); // NOI18N
        F5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F5MouseClicked(evt);
            }
        });
        F5.setLayout(new java.awt.GridBagLayout());

        lblF5.setName("F5"); // NOI18N
        lblF5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblF5MouseClicked(evt);
            }
        });
        F5.add(lblF5, new java.awt.GridBagConstraints());

        G5.setBackground(new java.awt.Color(170, 102, 26));
        G5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        G5.setMaximumSize(new java.awt.Dimension(100, 100));
        G5.setMinimumSize(new java.awt.Dimension(100, 100));
        G5.setName("G5"); // NOI18N
        G5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                G5MouseClicked(evt);
            }
        });
        G5.setLayout(new java.awt.GridBagLayout());

        lblG5.setName("G5"); // NOI18N
        lblG5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblG5MouseClicked(evt);
            }
        });
        G5.add(lblG5, new java.awt.GridBagConstraints());

        H5.setBackground(new java.awt.Color(238, 191, 120));
        H5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        H5.setMaximumSize(new java.awt.Dimension(100, 100));
        H5.setMinimumSize(new java.awt.Dimension(100, 100));
        H5.setName("H5"); // NOI18N
        H5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                H5MouseClicked(evt);
            }
        });
        H5.setLayout(new java.awt.GridBagLayout());

        lblH5.setName("H5"); // NOI18N
        lblH5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblH5MouseClicked(evt);
            }
        });
        H5.add(lblH5, new java.awt.GridBagConstraints());

        A4.setBackground(new java.awt.Color(238, 191, 120));
        A4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        A4.setMaximumSize(new java.awt.Dimension(100, 100));
        A4.setMinimumSize(new java.awt.Dimension(100, 100));
        A4.setName("A4"); // NOI18N
        A4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A4MouseClicked(evt);
            }
        });
        A4.setLayout(new java.awt.GridBagLayout());

        lblA4.setName("A4"); // NOI18N
        lblA4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblA4MouseClicked(evt);
            }
        });
        A4.add(lblA4, new java.awt.GridBagConstraints());

        B4.setBackground(new java.awt.Color(170, 102, 26));
        B4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        B4.setMaximumSize(new java.awt.Dimension(100, 100));
        B4.setMinimumSize(new java.awt.Dimension(100, 100));
        B4.setName("B4"); // NOI18N
        B4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B4MouseClicked(evt);
            }
        });
        B4.setLayout(new java.awt.GridBagLayout());

        lblB4.setName("B4"); // NOI18N
        lblB4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblB4MouseClicked(evt);
            }
        });
        B4.add(lblB4, new java.awt.GridBagConstraints());

        C4.setBackground(new java.awt.Color(238, 191, 120));
        C4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        C4.setMaximumSize(new java.awt.Dimension(100, 100));
        C4.setMinimumSize(new java.awt.Dimension(100, 100));
        C4.setName("C4"); // NOI18N
        C4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C4MouseClicked(evt);
            }
        });
        C4.setLayout(new java.awt.GridBagLayout());

        lblC4.setName("C4"); // NOI18N
        lblC4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblC4MouseClicked(evt);
            }
        });
        C4.add(lblC4, new java.awt.GridBagConstraints());

        D4.setBackground(new java.awt.Color(170, 102, 26));
        D4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        D4.setMaximumSize(new java.awt.Dimension(100, 100));
        D4.setMinimumSize(new java.awt.Dimension(100, 100));
        D4.setName("D4"); // NOI18N
        D4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D4MouseClicked(evt);
            }
        });
        D4.setLayout(new java.awt.GridBagLayout());

        lblD4.setName("D4"); // NOI18N
        lblD4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblD4MouseClicked(evt);
            }
        });
        D4.add(lblD4, new java.awt.GridBagConstraints());

        E4.setBackground(new java.awt.Color(238, 191, 120));
        E4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        E4.setMaximumSize(new java.awt.Dimension(100, 100));
        E4.setMinimumSize(new java.awt.Dimension(100, 100));
        E4.setName("E4"); // NOI18N
        E4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E4MouseClicked(evt);
            }
        });
        E4.setLayout(new java.awt.GridBagLayout());

        lblE4.setName("E4"); // NOI18N
        lblE4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblE4MouseClicked(evt);
            }
        });
        E4.add(lblE4, new java.awt.GridBagConstraints());

        F4.setBackground(new java.awt.Color(170, 102, 26));
        F4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        F4.setMaximumSize(new java.awt.Dimension(100, 100));
        F4.setMinimumSize(new java.awt.Dimension(100, 100));
        F4.setName("F4"); // NOI18N
        F4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F4MouseClicked(evt);
            }
        });
        F4.setLayout(new java.awt.GridBagLayout());

        lblF4.setName("F4"); // NOI18N
        lblF4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblF4MouseClicked(evt);
            }
        });
        F4.add(lblF4, new java.awt.GridBagConstraints());

        G4.setBackground(new java.awt.Color(238, 191, 120));
        G4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        G4.setMaximumSize(new java.awt.Dimension(100, 100));
        G4.setMinimumSize(new java.awt.Dimension(100, 100));
        G4.setName("G4"); // NOI18N
        G4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                G4MouseClicked(evt);
            }
        });
        G4.setLayout(new java.awt.GridBagLayout());

        lblG4.setName("G4"); // NOI18N
        lblG4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblG4MouseClicked(evt);
            }
        });
        G4.add(lblG4, new java.awt.GridBagConstraints());

        H4.setBackground(new java.awt.Color(170, 102, 26));
        H4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        H4.setMaximumSize(new java.awt.Dimension(100, 100));
        H4.setMinimumSize(new java.awt.Dimension(100, 100));
        H4.setName("H4"); // NOI18N
        H4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                H4MouseClicked(evt);
            }
        });
        H4.setLayout(new java.awt.GridBagLayout());

        lblH4.setName("H4"); // NOI18N
        lblH4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblH4MouseClicked(evt);
            }
        });
        H4.add(lblH4, new java.awt.GridBagConstraints());

        A3.setBackground(new java.awt.Color(170, 102, 26));
        A3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        A3.setName("A3"); // NOI18N
        A3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A3MouseClicked(evt);
            }
        });
        A3.setLayout(new java.awt.GridBagLayout());

        lblA3.setName("A3"); // NOI18N
        lblA3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblA3MouseClicked(evt);
            }
        });
        A3.add(lblA3, new java.awt.GridBagConstraints());

        B3.setBackground(new java.awt.Color(238, 191, 120));
        B3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        B3.setName("B3"); // NOI18N
        B3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B3MouseClicked(evt);
            }
        });
        B3.setLayout(new java.awt.GridBagLayout());

        lblB3.setName("B3"); // NOI18N
        lblB3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblB3MouseClicked(evt);
            }
        });
        B3.add(lblB3, new java.awt.GridBagConstraints());

        C3.setBackground(new java.awt.Color(170, 102, 26));
        C3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        C3.setMaximumSize(new java.awt.Dimension(100, 100));
        C3.setName("C3"); // NOI18N
        C3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C3MouseClicked(evt);
            }
        });
        C3.setLayout(new java.awt.GridBagLayout());

        lblC3.setName("C3"); // NOI18N
        lblC3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblC3MouseClicked(evt);
            }
        });
        C3.add(lblC3, new java.awt.GridBagConstraints());

        D3.setBackground(new java.awt.Color(238, 191, 120));
        D3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        D3.setMaximumSize(new java.awt.Dimension(100, 100));
        D3.setName("D3"); // NOI18N
        D3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D3MouseClicked(evt);
            }
        });
        D3.setLayout(new java.awt.GridBagLayout());

        lblD3.setName("D3"); // NOI18N
        lblD3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblD3MouseClicked(evt);
            }
        });
        D3.add(lblD3, new java.awt.GridBagConstraints());

        E3.setBackground(new java.awt.Color(170, 102, 26));
        E3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        E3.setName("E3"); // NOI18N
        E3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E3MouseClicked(evt);
            }
        });
        E3.setLayout(new java.awt.GridBagLayout());

        lblE3.setName("E3"); // NOI18N
        lblE3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblE3MouseClicked(evt);
            }
        });
        E3.add(lblE3, new java.awt.GridBagConstraints());

        F3.setBackground(new java.awt.Color(238, 191, 120));
        F3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        F3.setMaximumSize(new java.awt.Dimension(100, 100));
        F3.setMinimumSize(new java.awt.Dimension(100, 100));
        F3.setName("F3"); // NOI18N
        F3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F3MouseClicked(evt);
            }
        });
        F3.setLayout(new java.awt.GridBagLayout());

        lblF3.setName("F3"); // NOI18N
        lblF3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblF3MouseClicked(evt);
            }
        });
        F3.add(lblF3, new java.awt.GridBagConstraints());

        G3.setBackground(new java.awt.Color(170, 102, 26));
        G3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        G3.setMaximumSize(new java.awt.Dimension(100, 100));
        G3.setMinimumSize(new java.awt.Dimension(100, 100));
        G3.setName("G3"); // NOI18N
        G3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                G3MouseClicked(evt);
            }
        });
        G3.setLayout(new java.awt.GridBagLayout());

        lblG3.setName("G3"); // NOI18N
        lblG3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblG3MouseClicked(evt);
            }
        });
        G3.add(lblG3, new java.awt.GridBagConstraints());

        H3.setBackground(new java.awt.Color(238, 191, 120));
        H3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        H3.setMaximumSize(new java.awt.Dimension(100, 100));
        H3.setMinimumSize(new java.awt.Dimension(100, 100));
        H3.setName("H3"); // NOI18N
        H3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                H3MouseClicked(evt);
            }
        });
        H3.setLayout(new java.awt.GridBagLayout());

        lblH3.setName("H3"); // NOI18N
        lblH3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblH3MouseClicked(evt);
            }
        });
        H3.add(lblH3, new java.awt.GridBagConstraints());

        A2.setBackground(new java.awt.Color(238, 191, 120));
        A2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        A2.setName("A2"); // NOI18N
        A2.setPreferredSize(new java.awt.Dimension(100, 100));
        A2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A2MouseClicked(evt);
            }
        });
        A2.setLayout(new java.awt.GridBagLayout());

        lblA2.setName("A2"); // NOI18N
        lblA2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblA2MouseClicked(evt);
            }
        });
        A2.add(lblA2, new java.awt.GridBagConstraints());

        B2.setBackground(new java.awt.Color(170, 102, 26));
        B2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        B2.setName("B2"); // NOI18N
        B2.setPreferredSize(new java.awt.Dimension(100, 100));
        B2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B2MouseClicked(evt);
            }
        });
        B2.setLayout(new java.awt.GridBagLayout());

        lblB2.setName("B2"); // NOI18N
        lblB2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblB2MouseClicked(evt);
            }
        });
        B2.add(lblB2, new java.awt.GridBagConstraints());

        C2.setBackground(new java.awt.Color(238, 191, 120));
        C2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        C2.setName("C2"); // NOI18N
        C2.setPreferredSize(new java.awt.Dimension(100, 100));
        C2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C2MouseClicked(evt);
            }
        });
        C2.setLayout(new java.awt.GridBagLayout());

        lblC2.setName("C2"); // NOI18N
        lblC2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblC2MouseClicked(evt);
            }
        });
        C2.add(lblC2, new java.awt.GridBagConstraints());

        D2.setBackground(new java.awt.Color(170, 102, 26));
        D2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        D2.setMinimumSize(new java.awt.Dimension(100, 100));
        D2.setName("D2"); // NOI18N
        D2.setPreferredSize(new java.awt.Dimension(100, 100));
        D2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D2MouseClicked(evt);
            }
        });
        D2.setLayout(new java.awt.GridBagLayout());

        lblD2.setName("D2"); // NOI18N
        lblD2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblD2MouseClicked(evt);
            }
        });
        D2.add(lblD2, new java.awt.GridBagConstraints());

        E2.setBackground(new java.awt.Color(238, 191, 120));
        E2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        E2.setMinimumSize(new java.awt.Dimension(100, 100));
        E2.setName("E2"); // NOI18N
        E2.setPreferredSize(new java.awt.Dimension(100, 100));
        E2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E2MouseClicked(evt);
            }
        });
        E2.setLayout(new java.awt.GridBagLayout());

        lblE2.setName("E2"); // NOI18N
        lblE2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblE2MouseClicked(evt);
            }
        });
        E2.add(lblE2, new java.awt.GridBagConstraints());

        F2.setBackground(new java.awt.Color(170, 102, 26));
        F2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        F2.setName("F2"); // NOI18N
        F2.setPreferredSize(new java.awt.Dimension(100, 100));
        F2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F2MouseClicked(evt);
            }
        });
        F2.setLayout(new java.awt.GridBagLayout());

        lblF2.setName("F2"); // NOI18N
        lblF2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblF2MouseClicked(evt);
            }
        });
        F2.add(lblF2, new java.awt.GridBagConstraints());

        G2.setBackground(new java.awt.Color(238, 191, 120));
        G2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        G2.setName("G2"); // NOI18N
        G2.setPreferredSize(new java.awt.Dimension(100, 100));
        G2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                G2MouseClicked(evt);
            }
        });
        G2.setLayout(new java.awt.GridBagLayout());

        lblG2.setName("G2"); // NOI18N
        lblG2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblG2MouseClicked(evt);
            }
        });
        G2.add(lblG2, new java.awt.GridBagConstraints());

        H2.setBackground(new java.awt.Color(170, 102, 26));
        H2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        H2.setName("H2"); // NOI18N
        H2.setPreferredSize(new java.awt.Dimension(100, 100));
        H2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                H2MouseClicked(evt);
            }
        });
        H2.setLayout(new java.awt.GridBagLayout());

        lblH2.setName("H2"); // NOI18N
        lblH2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblH2MouseClicked(evt);
            }
        });
        H2.add(lblH2, new java.awt.GridBagConstraints());

        A1.setBackground(new java.awt.Color(170, 102, 26));
        A1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        A1.setName("A1"); // NOI18N
        A1.setPreferredSize(new java.awt.Dimension(100, 100));
        A1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A1MouseClicked(evt);
            }
        });
        A1.setLayout(new java.awt.GridBagLayout());

        lblA1.setName("A1"); // NOI18N
        lblA1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblA1MouseClicked(evt);
            }
        });
        A1.add(lblA1, new java.awt.GridBagConstraints());

        B1.setBackground(new java.awt.Color(238, 191, 120));
        B1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        B1.setName("B1"); // NOI18N
        B1.setPreferredSize(new java.awt.Dimension(100, 100));
        B1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B1MouseClicked(evt);
            }
        });
        B1.setLayout(new java.awt.GridBagLayout());

        lblB1.setName("B1"); // NOI18N
        lblB1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblB1MouseClicked(evt);
            }
        });
        B1.add(lblB1, new java.awt.GridBagConstraints());

        C1.setBackground(new java.awt.Color(170, 102, 26));
        C1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        C1.setName("C1"); // NOI18N
        C1.setPreferredSize(new java.awt.Dimension(100, 100));
        C1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C1MouseClicked(evt);
            }
        });
        C1.setLayout(new java.awt.GridBagLayout());

        lblC1.setName("C1"); // NOI18N
        lblC1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblC1MouseClicked(evt);
            }
        });
        C1.add(lblC1, new java.awt.GridBagConstraints());

        D1.setBackground(new java.awt.Color(238, 191, 120));
        D1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        D1.setName("D1"); // NOI18N
        D1.setPreferredSize(new java.awt.Dimension(100, 100));
        D1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D1MouseClicked(evt);
            }
        });
        D1.setLayout(new java.awt.GridBagLayout());

        lblD1.setName("D1"); // NOI18N
        lblD1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblD1MouseClicked(evt);
            }
        });
        D1.add(lblD1, new java.awt.GridBagConstraints());

        E1.setBackground(new java.awt.Color(170, 102, 26));
        E1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        E1.setName("E1"); // NOI18N
        E1.setPreferredSize(new java.awt.Dimension(100, 100));
        E1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E1MouseClicked(evt);
            }
        });
        E1.setLayout(new java.awt.GridBagLayout());

        lblE1.setName("E1"); // NOI18N
        lblE1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblE1MouseClicked(evt);
            }
        });
        E1.add(lblE1, new java.awt.GridBagConstraints());

        F1.setBackground(new java.awt.Color(238, 191, 120));
        F1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        F1.setName("F1"); // NOI18N
        F1.setPreferredSize(new java.awt.Dimension(100, 100));
        F1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F1MouseClicked(evt);
            }
        });
        F1.setLayout(new java.awt.GridBagLayout());

        lblF1.setName("F1"); // NOI18N
        lblF1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblF1MouseClicked(evt);
            }
        });
        F1.add(lblF1, new java.awt.GridBagConstraints());

        G1.setBackground(new java.awt.Color(170, 102, 26));
        G1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        G1.setName("G1"); // NOI18N
        G1.setPreferredSize(new java.awt.Dimension(100, 100));
        G1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                G1MouseClicked(evt);
            }
        });
        G1.setLayout(new java.awt.GridBagLayout());

        lblG1.setName("G1"); // NOI18N
        lblG1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblG1MouseClicked(evt);
            }
        });
        G1.add(lblG1, new java.awt.GridBagConstraints());

        H1.setBackground(new java.awt.Color(238, 191, 120));
        H1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        H1.setName("H1"); // NOI18N
        H1.setPreferredSize(new java.awt.Dimension(100, 100));
        H1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                H1MouseClicked(evt);
            }
        });
        H1.setLayout(new java.awt.GridBagLayout());

        lblH1.setName("H1"); // NOI18N
        lblH1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblH1MouseClicked(evt);
            }
        });
        H1.add(lblH1, new java.awt.GridBagConstraints());

        jPanelSide.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Player 2"));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel31.setText("Move:");

        jLabel32.setText("Player");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32))
                .addContainerGap(165, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Player 1"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanelSideLayout = new javax.swing.GroupLayout(jPanelSide);
        jPanelSide.setLayout(jPanelSideLayout);
        jPanelSideLayout.setHorizontalGroup(
            jPanelSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSideLayout.createSequentialGroup()
                .addGroup(jPanelSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelSideLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                            .addComponent(jTextField2))))
                .addContainerGap())
        );
        jPanelSideLayout.setVerticalGroup(
            jPanelSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSideLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(A3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(A2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(B2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(B3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(C3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(C2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(D2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(E2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(D3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(E3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(F3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(G3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(H3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(A1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(C1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(D1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(E1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(F1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(F2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(G1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(G2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(H2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(H1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(A4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(C4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(D4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(E4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(F4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(G4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(H4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(A6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(A7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(A8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(B7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(B8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(B6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(A5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(C5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(D5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(E5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(F5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(G5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(H5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(C8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(C7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(C6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(D6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(D8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(D7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(E8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(E7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(E6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(F6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(F8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(F7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(G8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(G7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(G6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(H6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(H7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(H8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(6, 6, Short.MAX_VALUE)
                .addComponent(jPanelSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(A8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(F8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(G8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(H8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(A7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(G7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(H7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(A6, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(C6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(G6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(H6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(B6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(D6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(F6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(E6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(A5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(G5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(H5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(B4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(G4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(H4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(E3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(G3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(H3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(A3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(B3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(C3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(D3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(A2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(G2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(H2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(A1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(G1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(H1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void lblA2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblA2MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[0][1], lblA2);
        
    }//GEN-LAST:event_lblA2MouseClicked

    private void lblA3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblA3MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[0][2], lblA3);
    }//GEN-LAST:event_lblA3MouseClicked

    private void lblA4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblA4MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[0][3], lblA4);
    }//GEN-LAST:event_lblA4MouseClicked

    private void lblA5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblA5MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[0][4], lblA5);
    }//GEN-LAST:event_lblA5MouseClicked

    private void lblA6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblA6MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[0][5], lblA6);
    }//GEN-LAST:event_lblA6MouseClicked

    private void lblA7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblA7MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[0][6], lblA7);
    }//GEN-LAST:event_lblA7MouseClicked

    private void A3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A3MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, A3);   
    }//GEN-LAST:event_A3MouseClicked

    private void A4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A4MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, A4);
    }//GEN-LAST:event_A4MouseClicked

    private void A5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A5MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, A5);
    }//GEN-LAST:event_A5MouseClicked

    private void A6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A6MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, A6);
    }//GEN-LAST:event_A6MouseClicked

    private void A7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A7MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, A7);
    }//GEN-LAST:event_A7MouseClicked

    private void A8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A8MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, A8);
    }//GEN-LAST:event_A8MouseClicked

    private void A1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A1MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, A1);
    }//GEN-LAST:event_A1MouseClicked

    private void A2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A2MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, A2);
    }//GEN-LAST:event_A2MouseClicked

    private void B3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B3MouseClicked
        postmovePiece(bufferpiece, B3);
    }//GEN-LAST:event_B3MouseClicked

    private void B4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B4MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, B4);
    }//GEN-LAST:event_B4MouseClicked

    private void B5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B5MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, B5);
    }//GEN-LAST:event_B5MouseClicked

    private void B6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B6MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, B6);
    }//GEN-LAST:event_B6MouseClicked

    private void B7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B7MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, B7);
    }//GEN-LAST:event_B7MouseClicked

    private void C3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C3MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, C3);
    }//GEN-LAST:event_C3MouseClicked

    private void C4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C4MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, C4);
    }//GEN-LAST:event_C4MouseClicked

    private void C5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C5MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, C5);   
    }//GEN-LAST:event_C5MouseClicked

    private void C6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C6MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, C6);   
    }//GEN-LAST:event_C6MouseClicked

    private void C7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C7MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, C7);   
    }//GEN-LAST:event_C7MouseClicked

    private void D3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D3MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, D3);   
    }//GEN-LAST:event_D3MouseClicked

    private void D4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D4MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, D4);   
    }//GEN-LAST:event_D4MouseClicked

    private void D5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D5MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, D5);   
    }//GEN-LAST:event_D5MouseClicked

    private void D6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D6MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, D6);   
    }//GEN-LAST:event_D6MouseClicked

    private void D7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D7MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, D7);   
    }//GEN-LAST:event_D7MouseClicked

    private void E3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E3MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, E3);   
    }//GEN-LAST:event_E3MouseClicked

    private void E4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E4MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, E4);   
    }//GEN-LAST:event_E4MouseClicked

    private void E5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E5MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, E5);   
    }//GEN-LAST:event_E5MouseClicked

    private void E6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E6MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, E6);   
    }//GEN-LAST:event_E6MouseClicked

    private void E7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E7MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, E7);   
    }//GEN-LAST:event_E7MouseClicked

    private void F3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F3MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, F3);   
    }//GEN-LAST:event_F3MouseClicked

    private void F4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F4MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, F4);   
    }//GEN-LAST:event_F4MouseClicked

    private void F5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F5MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, F5);   
    }//GEN-LAST:event_F5MouseClicked

    private void F6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F6MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, F6);   
    }//GEN-LAST:event_F6MouseClicked

    private void F7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F7MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, F7);   
    }//GEN-LAST:event_F7MouseClicked

    private void G2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_G2MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, G2);   
    }//GEN-LAST:event_G2MouseClicked

    private void G3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_G3MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, G3);   
    }//GEN-LAST:event_G3MouseClicked

    private void G4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_G4MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, G4);   
    }//GEN-LAST:event_G4MouseClicked

    private void G5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_G5MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, G5);   
    }//GEN-LAST:event_G5MouseClicked

    private void G6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_G6MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, G6);   
    }//GEN-LAST:event_G6MouseClicked

    private void G7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_G7MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, G7);   
    }//GEN-LAST:event_G7MouseClicked

    private void H3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_H3MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, H3);   
    }//GEN-LAST:event_H3MouseClicked

    private void H4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_H4MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, H4);   
    }//GEN-LAST:event_H4MouseClicked

    private void H5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_H5MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, H5);   
    }//GEN-LAST:event_H5MouseClicked

    private void H6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_H6MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, H6);   
    }//GEN-LAST:event_H6MouseClicked

    private void H7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_H7MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, H7);   
    }//GEN-LAST:event_H7MouseClicked

    private void lblB1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblB1MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[1][0], lblB1);
    }//GEN-LAST:event_lblB1MouseClicked

    private void lblB3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblB3MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[1][2], lblB3);
    }//GEN-LAST:event_lblB3MouseClicked

    private void lblB2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblB2MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[1][1], lblB2);
    }//GEN-LAST:event_lblB2MouseClicked

    private void lblB4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblB4MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[1][3], lblB4);
    }//GEN-LAST:event_lblB4MouseClicked

    private void lblB5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblB5MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[1][4], lblB5);
    }//GEN-LAST:event_lblB5MouseClicked

    private void lblB6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblB6MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[1][5], lblB6);
    }//GEN-LAST:event_lblB6MouseClicked

    private void lblB7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblB7MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[1][6], lblB7);
    }//GEN-LAST:event_lblB7MouseClicked

    private void lblB8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblB8MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[1][7], lblB8);
    }//GEN-LAST:event_lblB8MouseClicked

    private void lblC1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblC1MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[2][0], lblC1);
    }//GEN-LAST:event_lblC1MouseClicked

    private void lblC2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblC2MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[2][1], lblC2);
    }//GEN-LAST:event_lblC2MouseClicked

    private void lblC3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblC3MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[2][2], lblC3);
    }//GEN-LAST:event_lblC3MouseClicked

    private void lblC4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblC4MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[2][3], lblC4);
    }//GEN-LAST:event_lblC4MouseClicked

    private void lblC5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblC5MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[2][4], lblC5);
    }//GEN-LAST:event_lblC5MouseClicked

    private void lblC6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblC6MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[2][5], lblC6);
    }//GEN-LAST:event_lblC6MouseClicked

    private void lblC7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblC7MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[2][6], lblC7);
    }//GEN-LAST:event_lblC7MouseClicked

    private void lblC8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblC8MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[2][7], lblC8);
    }//GEN-LAST:event_lblC8MouseClicked

    private void lblD1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblD1MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[3][0], lblD1);
    }//GEN-LAST:event_lblD1MouseClicked

    private void lblD2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblD2MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[3][1], lblD2);
    }//GEN-LAST:event_lblD2MouseClicked

    private void lblD3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblD3MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[3][2], lblD3);
    }//GEN-LAST:event_lblD3MouseClicked

    private void lblD4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblD4MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[3][3], lblD4);
    }//GEN-LAST:event_lblD4MouseClicked

    private void lblD5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblD5MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[3][4], lblD5);
    }//GEN-LAST:event_lblD5MouseClicked

    private void lblD6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblD6MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[3][5], lblD6);
    }//GEN-LAST:event_lblD6MouseClicked

    private void lblD7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblD7MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[3][6], lblD7);
    }//GEN-LAST:event_lblD7MouseClicked

    private void lblD8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblD8MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[3][7], lblD8);
    }//GEN-LAST:event_lblD8MouseClicked

    private void lblE1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblE1MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[4][0], lblE1);
    }//GEN-LAST:event_lblE1MouseClicked

    private void lblE2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblE2MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[4][1], lblE2);
    }//GEN-LAST:event_lblE2MouseClicked

    private void lblE3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblE3MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[4][2], lblE3);
    }//GEN-LAST:event_lblE3MouseClicked

    private void lblE4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblE4MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[4][3], lblE4);
    }//GEN-LAST:event_lblE4MouseClicked

    private void lblE5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblE5MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[4][4], lblE5);
    }//GEN-LAST:event_lblE5MouseClicked

    private void lblE6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblE6MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[4][5], lblE6);
    }//GEN-LAST:event_lblE6MouseClicked

    private void lblE7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblE7MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[4][6], lblE7);
    }//GEN-LAST:event_lblE7MouseClicked

    private void lblE8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblE8MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[4][7], lblE8);
    }//GEN-LAST:event_lblE8MouseClicked

    private void lblF1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblF1MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[5][0], lblF1);
    }//GEN-LAST:event_lblF1MouseClicked

    private void lblF2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblF2MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[5][1], lblF2);
    }//GEN-LAST:event_lblF2MouseClicked

    private void lblF3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblF3MouseClicked
        // TODO add your handling code here:
        if(!bufferpiece.equals(""))
        {
            if(piecesAlive[5][2].charAt(2) != bufferpiece.charAt(2))
            {
                postmovePiece(bufferpiece, F3);
            }
        }
        else
        {
            premovePiece(piecesAlive[5][2], lblF3);
        }
    }//GEN-LAST:event_lblF3MouseClicked

    private void lblF4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblF4MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[5][3], lblF4);
    }//GEN-LAST:event_lblF4MouseClicked

    private void lblF5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblF5MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[5][4], lblF5);
    }//GEN-LAST:event_lblF5MouseClicked

    private void lblF6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblF6MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[5][5], lblF6);
    }//GEN-LAST:event_lblF6MouseClicked

    private void lblF7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblF7MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[5][6], lblF7);
    }//GEN-LAST:event_lblF7MouseClicked

    private void lblF8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblF8MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[5][7], lblF8);
    }//GEN-LAST:event_lblF8MouseClicked

    private void lblG1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblG1MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[6][0], lblG1);
    }//GEN-LAST:event_lblG1MouseClicked

    private void lblG2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblG2MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[6][1], lblG2);
    }//GEN-LAST:event_lblG2MouseClicked

    private void lblG3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblG3MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[6][2], lblG3);
    }//GEN-LAST:event_lblG3MouseClicked

    private void lblG4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblG4MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[6][3], lblG4);
    }//GEN-LAST:event_lblG4MouseClicked

    private void lblG5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblG5MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[6][4], lblG5);
    }//GEN-LAST:event_lblG5MouseClicked

    private void lblG6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblG6MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[6][5], lblG6);
    }//GEN-LAST:event_lblG6MouseClicked

    private void lblG7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblG7MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[6][6], lblG7);
    }//GEN-LAST:event_lblG7MouseClicked

    private void lblG8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblG8MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[6][7], lblG8);
    }//GEN-LAST:event_lblG8MouseClicked

    private void lblH1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblH1MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[7][0], lblH1);
    }//GEN-LAST:event_lblH1MouseClicked

    private void lblH2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblH2MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[7][1], lblH2);
    }//GEN-LAST:event_lblH2MouseClicked

    private void lblH3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblH3MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[7][2], lblH3);
    }//GEN-LAST:event_lblH3MouseClicked

    private void lblH4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblH4MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[7][3], lblH4);
    }//GEN-LAST:event_lblH4MouseClicked

    private void lblH5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblH5MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[7][4], lblH5);
    }//GEN-LAST:event_lblH5MouseClicked

    private void lblH6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblH6MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[7][5], lblH6);
    }//GEN-LAST:event_lblH6MouseClicked

    private void lblH7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblH7MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[7][6], lblH7);
    }//GEN-LAST:event_lblH7MouseClicked

    private void lblH8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblH8MouseClicked
        // TODO add your handling code here:
        premovePiece(piecesAlive[7][7], lblH8);
    }//GEN-LAST:event_lblH8MouseClicked

    private void B1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B1MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, B1);  
    }//GEN-LAST:event_B1MouseClicked

    private void B2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B2MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, B2);  
    }//GEN-LAST:event_B2MouseClicked

    private void C2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C2MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, C2);  
    }//GEN-LAST:event_C2MouseClicked

    private void D2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D2MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, D2);  
    }//GEN-LAST:event_D2MouseClicked

    private void E2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E2MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, E2);  
    }//GEN-LAST:event_E2MouseClicked

    private void F2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F2MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, F2);  
    }//GEN-LAST:event_F2MouseClicked

    private void H2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_H2MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, H2);  
    }//GEN-LAST:event_H2MouseClicked

    private void C1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C1MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, C1);  
    }//GEN-LAST:event_C1MouseClicked

    private void D1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D1MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, D1);  
    }//GEN-LAST:event_D1MouseClicked

    private void E1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E1MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, E1);  
    }//GEN-LAST:event_E1MouseClicked

    private void F1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F1MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, F1);  
    }//GEN-LAST:event_F1MouseClicked

    private void G1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_G1MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, G1);  
    }//GEN-LAST:event_G1MouseClicked

    private void H1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_H1MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, H1);  
    }//GEN-LAST:event_H1MouseClicked

    private void B8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B8MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, B8);  
    }//GEN-LAST:event_B8MouseClicked

    private void C8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C8MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, C8);  
    }//GEN-LAST:event_C8MouseClicked

    private void D8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D8MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, D8);  
    }//GEN-LAST:event_D8MouseClicked

    private void E8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E8MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, E8);  
    }//GEN-LAST:event_E8MouseClicked

    private void F8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F8MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, F8);  
    }//GEN-LAST:event_F8MouseClicked

    private void G8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_G8MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, G8);  
    }//GEN-LAST:event_G8MouseClicked

    private void H8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_H8MouseClicked
        // TODO add your handling code here:
        postmovePiece(bufferpiece, H8);  
    }//GEN-LAST:event_H8MouseClicked

    private void lblA1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblA1MouseClicked
        premovePiece(piecesAlive[0][0], lblA1);
    }//GEN-LAST:event_lblA1MouseClicked

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            outputToOpponent = "chat," + jTextField2.getText();
            
            jTextArea1.append("\nYou : " + jTextField2.getText());
            jTextField2.setText("");
            goNoGo = 1;
        }
        
    }//GEN-LAST:event_jTextField2KeyReleased

    private void lblA8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblA8MouseClicked
        premovePiece(piecesAlive[0][7], lblA8);
    }//GEN-LAST:event_lblA8MouseClicked
                              
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame("player1").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel A1;
    private javax.swing.JPanel A2;
    private javax.swing.JPanel A3;
    private javax.swing.JPanel A4;
    private javax.swing.JPanel A5;
    private javax.swing.JPanel A6;
    private javax.swing.JPanel A7;
    private javax.swing.JPanel A8;
    private javax.swing.JPanel B1;
    private javax.swing.JPanel B2;
    private javax.swing.JPanel B3;
    private javax.swing.JPanel B4;
    private javax.swing.JPanel B5;
    private javax.swing.JPanel B6;
    private javax.swing.JPanel B7;
    private javax.swing.JPanel B8;
    private javax.swing.JPanel C1;
    private javax.swing.JPanel C2;
    private javax.swing.JPanel C3;
    private javax.swing.JPanel C4;
    private javax.swing.JPanel C5;
    private javax.swing.JPanel C6;
    private javax.swing.JPanel C7;
    private javax.swing.JPanel C8;
    private javax.swing.JPanel D1;
    private javax.swing.JPanel D2;
    private javax.swing.JPanel D3;
    private javax.swing.JPanel D4;
    private javax.swing.JPanel D5;
    private javax.swing.JPanel D6;
    private javax.swing.JPanel D7;
    private javax.swing.JPanel D8;
    private javax.swing.JPanel E1;
    private javax.swing.JPanel E2;
    private javax.swing.JPanel E3;
    private javax.swing.JPanel E4;
    private javax.swing.JPanel E5;
    private javax.swing.JPanel E6;
    private javax.swing.JPanel E7;
    private javax.swing.JPanel E8;
    private javax.swing.JPanel F1;
    private javax.swing.JPanel F2;
    private javax.swing.JPanel F3;
    private javax.swing.JPanel F4;
    private javax.swing.JPanel F5;
    private javax.swing.JPanel F6;
    private javax.swing.JPanel F7;
    private javax.swing.JPanel F8;
    private javax.swing.JPanel G1;
    private javax.swing.JPanel G2;
    private javax.swing.JPanel G3;
    private javax.swing.JPanel G4;
    private javax.swing.JPanel G5;
    private javax.swing.JPanel G6;
    private javax.swing.JPanel G7;
    private javax.swing.JPanel G8;
    private javax.swing.JPanel H1;
    private javax.swing.JPanel H2;
    private javax.swing.JPanel H3;
    private javax.swing.JPanel H4;
    private javax.swing.JPanel H5;
    private javax.swing.JPanel H6;
    private javax.swing.JPanel H7;
    private javax.swing.JPanel H8;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelSide;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblA1;
    private javax.swing.JLabel lblA2;
    private javax.swing.JLabel lblA3;
    private javax.swing.JLabel lblA4;
    private javax.swing.JLabel lblA5;
    private javax.swing.JLabel lblA6;
    private javax.swing.JLabel lblA7;
    private javax.swing.JLabel lblA8;
    private javax.swing.JLabel lblB1;
    private javax.swing.JLabel lblB2;
    private javax.swing.JLabel lblB3;
    private javax.swing.JLabel lblB4;
    private javax.swing.JLabel lblB5;
    private javax.swing.JLabel lblB6;
    private javax.swing.JLabel lblB7;
    private javax.swing.JLabel lblB8;
    private javax.swing.JLabel lblC1;
    private javax.swing.JLabel lblC2;
    private javax.swing.JLabel lblC3;
    private javax.swing.JLabel lblC4;
    private javax.swing.JLabel lblC5;
    private javax.swing.JLabel lblC6;
    private javax.swing.JLabel lblC7;
    private javax.swing.JLabel lblC8;
    private javax.swing.JLabel lblD1;
    private javax.swing.JLabel lblD2;
    private javax.swing.JLabel lblD3;
    private javax.swing.JLabel lblD4;
    private javax.swing.JLabel lblD5;
    private javax.swing.JLabel lblD6;
    private javax.swing.JLabel lblD7;
    private javax.swing.JLabel lblD8;
    private javax.swing.JLabel lblE1;
    private javax.swing.JLabel lblE2;
    private javax.swing.JLabel lblE3;
    private javax.swing.JLabel lblE4;
    private javax.swing.JLabel lblE5;
    private javax.swing.JLabel lblE6;
    private javax.swing.JLabel lblE7;
    private javax.swing.JLabel lblE8;
    private javax.swing.JLabel lblF1;
    private javax.swing.JLabel lblF2;
    private javax.swing.JLabel lblF3;
    private javax.swing.JLabel lblF4;
    private javax.swing.JLabel lblF5;
    private javax.swing.JLabel lblF6;
    private javax.swing.JLabel lblF7;
    private javax.swing.JLabel lblF8;
    private javax.swing.JLabel lblG1;
    private javax.swing.JLabel lblG2;
    private javax.swing.JLabel lblG3;
    private javax.swing.JLabel lblG4;
    private javax.swing.JLabel lblG5;
    private javax.swing.JLabel lblG6;
    private javax.swing.JLabel lblG7;
    private javax.swing.JLabel lblG8;
    private javax.swing.JLabel lblH1;
    private javax.swing.JLabel lblH2;
    private javax.swing.JLabel lblH3;
    private javax.swing.JLabel lblH4;
    private javax.swing.JLabel lblH5;
    private javax.swing.JLabel lblH6;
    private javax.swing.JLabel lblH7;
    private javax.swing.JLabel lblH8;
    // End of variables declaration//GEN-END:variables
}
