package javaproject;

import java.util.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sdist
 */
public class PawnPiece {
    
    int moves = 0;
    String location = null;
    String race = null;
    ArrayList<String> possiblem = new ArrayList<>();
    
    public PawnPiece(String race, String loc) 
    {
        this.race = race;
        this.location = loc;
    }
    
    public ArrayList<String> movementW()
    {
        possiblem.clear();
        
        char[] ordinate = {'0','0'};
        
        if(moves == 0)
        {
            switch(location)
            {
                case "A2": {
                            ordinate[1] = '3';
                            possiblem.add("A" + ordinate[1] + "");
                            ordinate[1] = '4';
                            possiblem.add("A" + ordinate[1] + "");
                        
                            break;
                            }
                case "B2": {
                            ordinate[1] = '3';
                            possiblem.add("B" + ordinate[1] + "");
                            ordinate[1] = '4';
                            possiblem.add("B" + ordinate[1] + "");
                        }
                        break;
                case "C2": {
                            ordinate[1] = '3';
                            possiblem.add("C" + ordinate[1] + "");
                            ordinate[1] = '4';
                            possiblem.add("C" + ordinate[1] + "");
                        }
                        break;
                case "D2": {
                            ordinate[1] = '3';
                            possiblem.add("D" + ordinate[1] + "");
                            ordinate[1] = '4';
                            possiblem.add("D" + ordinate[1] + "");
                        }
                        break;
                case "E2": {
                            ordinate[1] = '3';
                            possiblem.add("E" + ordinate[1] + "");
                            ordinate[1] = '4';
                            possiblem.add("E" + ordinate[1] + "");
                        }
                        break;
                case "F2": {
                            ordinate[1] = '3';
                            possiblem.add("F" + ordinate[1] + "");
                            ordinate[1] = '4';
                            possiblem.add("F" + ordinate[1] + "");
                        }
                        break;
                case "G2": {
                            ordinate[1] = '3';
                            possiblem.add("G" + ordinate[1] + "");
                            ordinate[1] = '4';
                            possiblem.add("G" + ordinate[1] + "");
                        }
                        break;
                case "H2": {
                            ordinate[1] = '3';
                            possiblem.add("H" + ordinate[1] + "");
                            ordinate[1] = '4';
                            possiblem.add("H" + ordinate[1] + "");
                        }
                        break;
            }
        }
        else
        {
            switch(location)
            {
                case "A3": {
                            ordinate[1] = '4';
                            possiblem.add("A" + ordinate[1] + "");
                        }
                        break;
                case "A4": {
                            ordinate[1] = '5';
                            possiblem.add("A" + ordinate[1] + "");
                        }
                        break;
                case "A5": {
                            ordinate[1] = '6';
                            possiblem.add("A" + ordinate[1] + "");
                        }
                        break;
                case "A6": {
                            ordinate[1] = '7';
                            possiblem.add("A" + ordinate[1] + "");
                        }
                        break;
                case "A7": {
                            ordinate[1] = '8';
                            possiblem.add("A" + ordinate[1] + "");
                        }
                        break;
                case "B3": {
                            ordinate[1] = '4';
                            possiblem.add("B" + ordinate[1] + "");
                        }
                        break;
                case "B4": {
                            ordinate[1] = '5';
                            possiblem.add("B" + ordinate[1] + "");
                        }
                        break;
                case "B5": {
                            ordinate[1] = '6';
                            possiblem.add("B" + ordinate[1] + "");
                        }
                        break;
                case "B6": {
                            ordinate[1] = '7';
                            possiblem.add("B" + ordinate[1] + "");
                        }
                        break;
                case "B7": {
                            ordinate[1] = '8';
                            possiblem.add("B" + ordinate[1] + "");
                        }
                        break;
                case "C3": {
                            ordinate[1] = '4';
                            possiblem.add("C" + ordinate[1] + "");
                        }
                        break;
                case "C4": {
                            ordinate[1] = '5';
                            possiblem.add("C" + ordinate[1] + "");
                        }
                        break;
                case "C5": {
                            ordinate[1] = '6';
                            possiblem.add("C" + ordinate[1] + "");
                        }
                        break;
                case "C6": {
                            ordinate[1] = '7';
                            possiblem.add("C" + ordinate[1] + "");
                        }
                        break;
                case "C7": {
                            ordinate[1] = '8';
                            possiblem.add("C" + ordinate[1] + "");
                        }
                        break;
                case "D3": {
                            ordinate[1] = '4';
                            possiblem.add("D" + ordinate[1] + "");
                        }
                        break;
                case "D4": {
                            ordinate[1] = '5';
                            possiblem.add("D" + ordinate[1] + "");
                        }
                        break;
                case "D5": {
                            ordinate[1] = '6';
                            possiblem.add("D" + ordinate[1] + "");
                        }
                        break;
                case "D6": {
                            ordinate[1] = '7';
                            possiblem.add("D" + ordinate[1] + "");
                        }
                        break;
                case "D7": {
                            ordinate[1] = '8';
                            possiblem.add("D" + ordinate[1] + "");
                        }
                        break;
                case "E3": {
                            ordinate[1] = '4';
                            possiblem.add("E" + ordinate[1] + "");
                        }
                        break;
                case "E4": {
                            ordinate[1] = '5';
                            possiblem.add("E" + ordinate[1] + "");
                        }
                        break;
                case "E5": {
                            ordinate[1] = '6';
                            possiblem.add("E" + ordinate[1] + "");
                        }
                        break;
                case "E6": {
                            ordinate[1] = '7';
                            possiblem.add("E" + ordinate[1] + "");
                        }
                        break;
                case "E7": {
                            ordinate[1] = '8';
                            possiblem.add("E" + ordinate[1] + "");
                        }
                        break;
                case "F3": {
                            ordinate[1] = '4';
                            possiblem.add("F" + ordinate[1] + "");
                        }
                        break;
                case "F4": {
                            ordinate[1] = '5';
                            possiblem.add("F" + ordinate[1] + "");
                        }
                        break;
                case "F5": {
                            ordinate[1] = '6';
                            possiblem.add("F" + ordinate[1] + "");
                        }
                        break;
                case "F6": {
                            ordinate[1] = '7';
                            possiblem.add("F" + ordinate[1] + "");
                        }
                        break;
                case "F7": {
                            ordinate[1] = '8';
                            possiblem.add("F" + ordinate[1] + "");
                        }
                        break;
                case "G3": {
                            ordinate[1] = '4';
                            possiblem.add("G" + ordinate[1] + "");
                        }
                        break;
                case "G4": {
                            ordinate[1] = '5';
                            possiblem.add("G" + ordinate[1] + "");
                        }
                        break;
                case "G5": {
                            ordinate[1] = '6';
                            possiblem.add("G" + ordinate[1] + "");
                        }
                        break;
                case "G6": {
                            ordinate[1] = '7';
                            possiblem.add("G" + ordinate[1] + "");
                        }
                        break;
                case "G7": {
                            ordinate[1] = '8';
                            possiblem.add("G" + ordinate[1] + "");
                        }
                        break;
                case "H3": {
                            ordinate[1] = '4';
                            possiblem.add("H" + ordinate[1] + "");
                        }
                        break;
                case "H4": {
                            ordinate[1] = '5';
                            possiblem.add("H" + ordinate[1] + "");
                        }
                        break;
                case "H5": {
                            ordinate[1] = '6';
                            possiblem.add("H" + ordinate[1] + "");
                        }
                        break;
                case "H6": {
                            ordinate[1] = '7';
                            possiblem.add("H" + ordinate[1] + "");
                        }
                        break;
                case "H7": {
                            ordinate[1] = '8';
                            possiblem.add("H" + ordinate[1] + "");
                        }
                        break;
            }
        }
        
        moves++;
        
        return possiblem;
        
    }
    
    public ArrayList<String> movementB()
    {
        char[] ordinate = {'0','0'};
        
        if(moves == 0)
        {
            switch(location)
            {
                case "A7": {
                            ordinate[1] = '6';
                            possiblem.add("A" + ordinate[1] + "");
                            ordinate[1] = '5';
                            possiblem.add("A" + ordinate[1] + "");
                        }
                        break;
                case "B7": {
                            ordinate[1] = '6';
                            possiblem.add("B" + ordinate[1] + "");
                            ordinate[1] = '5';
                            possiblem.add("B" + ordinate[1] + "");
                        }
                        break;
                case "C7": {
                            ordinate[1] = '6';
                            possiblem.add("C" + ordinate[1] + "");
                            ordinate[1] = '5';
                            possiblem.add("C" + ordinate[1] + "");
                        }
                        break;
                case "D7": {
                            ordinate[1] = '6';
                            possiblem.add("D" + ordinate[1] + "");
                            ordinate[1] = '5';
                            possiblem.add("D" + ordinate[1] + "");
                        }
                        break;
                case "E7": {
                            ordinate[1] = '6';
                            possiblem.add("E" + ordinate[1] + "");
                            ordinate[1] = '5';
                            possiblem.add("E" + ordinate[1] + "");
                        }
                        break;
                case "F7": {
                            ordinate[1] = '6';
                            possiblem.add("F" + ordinate[1] + "");
                            ordinate[1] = '5';
                            possiblem.add("F" + ordinate[1] + "");
                        }
                        break;
                case "G7": {
                            ordinate[1] = '6';
                            possiblem.add("G" + ordinate[1] + "");
                            ordinate[1] = '5';
                            possiblem.add("G" + ordinate[1] + "");
                        }
                        break;
                case "H7": {
                            ordinate[1] = '6';
                            possiblem.add("H" + ordinate[1] + "");
                            ordinate[1] = '5';
                            possiblem.add("H" + ordinate[1] + "");
                        }
                        break;
            }
        }
        else
        {
            switch(location)
            {
                case "A6": {
                            ordinate[1] = '5';
                            possiblem.add("A" + ordinate[1] + "");
                        }
                        break;
                case "A5": {
                            ordinate[1] = '4';
                            possiblem.add("A" + ordinate[1] + "");
                        }
                        break;
                case "A4": {
                            ordinate[1] = '3';
                            possiblem.add("A" + ordinate[1] + "");
                        }
                        break;
                case "A3": {
                            ordinate[1] = '2';
                            possiblem.add("A" + ordinate[1] + "");
                        }
                        break;
                case "A2": {
                            ordinate[1] = '1';
                            possiblem.add("A" + ordinate[1] + "");
                        }
                        break;
                case "B6": {
                            ordinate[1] = '5';
                            possiblem.add("B" + ordinate[1] + "");
                        }
                        break;
                case "B5": {
                            ordinate[1] = '4';
                            possiblem.add("B" + ordinate[1] + "");
                        }
                        break;
                case "B4": {
                            ordinate[1] = '3';
                            possiblem.add("B" + ordinate[1] + "");
                        }
                        break;
                case "B3": {
                            ordinate[1] = '2';
                            possiblem.add("B" + ordinate[1] + "");
                        }
                        break;
                case "B2": {
                            ordinate[1] = '1';
                            possiblem.add("B" + ordinate[1] + "");
                        }
                        break;
                case "C6": {
                            ordinate[1] = '5';
                            possiblem.add("C" + ordinate[1] + "");
                        }
                        break;
                case "C5": {
                            ordinate[1] = '4';
                            possiblem.add("C" + ordinate[1] + "");
                        }
                        break;
                case "C4": {
                            ordinate[1] = '3';
                            possiblem.add("C" + ordinate[1] + "");
                        }
                        break;
                case "C3": {
                            ordinate[1] = '2';
                            possiblem.add("C" + ordinate[1] + "");
                        }
                        break;
                case "C2": {
                            ordinate[1] = '1';
                            possiblem.add("C" + ordinate[1] + "");
                        }
                        break;
                case "D6": {
                            ordinate[1] = '5';
                            possiblem.add("D" + ordinate[1] + "");
                        }
                        break;
                case "D5": {
                            ordinate[1] = '4';
                            possiblem.add("D" + ordinate[1] + "");
                        }
                        break;
                case "D4": {
                            ordinate[1] = '3';
                            possiblem.add("D" + ordinate[1] + "");
                        }
                        break;
                case "D3": {
                            ordinate[1] = '2';
                            possiblem.add("D" + ordinate[1] + "");
                        }
                        break;
                case "D2": {
                            ordinate[1] = '1';
                            possiblem.add("D" + ordinate[1] + "");
                        }
                        break;
                case "E6": {
                            ordinate[1] = '5';
                            possiblem.add("E" + ordinate[1] + "");
                        }
                        break;
                case "E5": {
                            ordinate[1] = '4';
                            possiblem.add("E" + ordinate[1] + "");
                        }
                        break;
                case "E4": {
                            ordinate[1] = '3';
                            possiblem.add("E" + ordinate[1] + "");
                        }
                        break;
                case "E3": {
                            ordinate[1] = '2';
                            possiblem.add("E" + ordinate[1] + "");
                        }
                        break;
                case "E2": {
                            ordinate[1] = '1';
                            possiblem.add("E" + ordinate[1] + "");
                        }
                        break;
                case "F6": {
                            ordinate[1] = '5';
                            possiblem.add("F" + ordinate[1] + "");
                        }
                        break;
                case "F5": {
                            ordinate[1] = '4';
                            possiblem.add("F" + ordinate[1] + "");
                        }
                        break;
                case "F4": {
                            ordinate[1] = '3';
                            possiblem.add("F" + ordinate[1] + "");
                        }
                        break;
                case "F3": {
                            ordinate[1] = '2';
                            possiblem.add("F" + ordinate[1] + "");
                        }
                        break;
                case "F2": {
                            ordinate[1] = '1';
                            possiblem.add("F" + ordinate[1] + "");
                        }
                        break;
                case "G6": {
                            ordinate[1] = '5';
                            possiblem.add("G" + ordinate[1] + "");
                        }
                        break;
                case "G5": {
                            ordinate[1] = '4';
                            possiblem.add("G" + ordinate[1] + "");
                        }
                        break;
                case "G4": {
                            ordinate[1] = '3';
                            possiblem.add("G" + ordinate[1] + "");
                        }
                        break;
                case "G3": {
                            ordinate[1] = '2';
                            possiblem.add("G" + ordinate[1] + "");
                        }
                        break;
                case "G2": {
                            ordinate[1] = '1';
                            possiblem.add("G" + ordinate[1] + "");
                        }
                        break;
                case "H6": {
                            ordinate[1] = '5';
                            possiblem.add("H" + ordinate[1] + "");
                        }
                        break;
                case "H5": {
                            ordinate[1] = '4';
                            possiblem.add("H" + ordinate[1] + "");
                        }
                        break;
                case "H4": {
                            ordinate[1] = '3';
                            possiblem.add("H" + ordinate[1] + "");
                        }
                        break;
                case "H3": {
                            ordinate[1] = '2';
                            possiblem.add("H" + ordinate[1] + "");
                        }
                        break;
                case "H2": {
                            ordinate[1] = '1';
                            possiblem.add("H" + ordinate[1] + "");
                        }
                        break;
                        
            }
        }
        
        moves++;
        
        return possiblem;
    }
    
    
}
