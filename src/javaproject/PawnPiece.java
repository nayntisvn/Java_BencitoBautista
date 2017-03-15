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
    
    public ArrayList<String> movement()
    {
        possiblem.clear();
        
        char[] ordinate = {'0','0'};
        
        if(race.equals("white"))
        {
            if(moves == 0)
            {
                switch(location)
                {
                    case "A2": {
                                ordinate[1] = '3';
                                possiblem.add("A" + ordinate[1] + "");
                                ordinate[1] = '4';
                                possiblem.add("A" + ordinate[1] + "");
                                possiblem.add("B3");
                                break;
                                }
                    case "B2": {
                                ordinate[1] = '3';
                                possiblem.add("B" + ordinate[1] + "");
                                ordinate[1] = '4';
                                possiblem.add("B" + ordinate[1] + "");
                                possiblem.add("A3");
                                possiblem.add("C3");
                            }
                            break;
                    case "C2": {
                                ordinate[1] = '3';
                                possiblem.add("C" + ordinate[1] + "");
                                ordinate[1] = '4';
                                possiblem.add("C" + ordinate[1] + "");
                                possiblem.add("B3");
                                possiblem.add("D3");
                            }
                            break;
                    case "D2": {
                                ordinate[1] = '3';
                                possiblem.add("D" + ordinate[1] + "");
                                ordinate[1] = '4';
                                possiblem.add("D" + ordinate[1] + "");
                                possiblem.add("C3");
                                possiblem.add("E3");
                            }
                            break;
                    case "E2": {
                                ordinate[1] = '3';
                                possiblem.add("E" + ordinate[1] + "");
                                ordinate[1] = '4';
                                possiblem.add("E" + ordinate[1] + "");
                                possiblem.add("D3");
                                possiblem.add("F3");
                            }
                            break;
                    case "F2": {
                                ordinate[1] = '3';
                                possiblem.add("F" + ordinate[1] + "");
                                ordinate[1] = '4';
                                possiblem.add("F" + ordinate[1] + "");
                                possiblem.add("E3");
                                possiblem.add("G3");
                            }
                            break;
                    case "G2": {
                                ordinate[1] = '3';
                                possiblem.add("G" + ordinate[1] + "");
                                ordinate[1] = '4';
                                possiblem.add("G" + ordinate[1] + "");
                                possiblem.add("F3");
                                possiblem.add("H3");
                            }
                            break;
                    case "H2": {
                                ordinate[1] = '3';
                                possiblem.add("H" + ordinate[1] + "");
                                ordinate[1] = '4';
                                possiblem.add("H" + ordinate[1] + "");
                                possiblem.add("G3");
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
                                possiblem.add("B4");
                            }
                            break;
                    case "A4": {
                                ordinate[1] = '5';
                                possiblem.add("A" + ordinate[1] + "");
                                possiblem.add("B5");
                            }
                            break;
                    case "A5": {
                                ordinate[1] = '6';
                                possiblem.add("A" + ordinate[1] + "");
                                possiblem.add("B6");
                            }
                            break;
                    case "A6": {
                                ordinate[1] = '7';
                                possiblem.add("A" + ordinate[1] + "");
                                possiblem.add("B7");
                            }
                            break;
                    case "A7": {
                                ordinate[1] = '8';
                                possiblem.add("A" + ordinate[1] + "");
                                possiblem.add("B8");
                            }
                            break;
                    case "B3": {
                                ordinate[1] = '4';
                                possiblem.add("B" + ordinate[1] + "");
                                possiblem.add("A4");
                                possiblem.add("C4");
                            }
                            break;
                    case "B4": {
                                ordinate[1] = '5';
                                possiblem.add("B" + ordinate[1] + "");
                                possiblem.add("A5");
                                possiblem.add("C5");
                            }
                            break;
                    case "B5": {
                                ordinate[1] = '6';
                                possiblem.add("B" + ordinate[1] + "");
                                possiblem.add("A6");
                                possiblem.add("C6");
                            }
                            break;
                    case "B6": {
                                ordinate[1] = '7';
                                possiblem.add("B" + ordinate[1] + "");
                                possiblem.add("A7");
                                possiblem.add("C7");
                            }
                            break;
                    case "B7": {
                                ordinate[1] = '8';
                                possiblem.add("B" + ordinate[1] + "");
                                possiblem.add("A8");
                                possiblem.add("C8");
                            }
                            break;
                    case "C3": {
                                ordinate[1] = '4';
                                possiblem.add("C" + ordinate[1] + "");
                                possiblem.add("B4");
                                possiblem.add("D4");
                            }
                            break;
                    case "C4": {
                                ordinate[1] = '5';
                                possiblem.add("C" + ordinate[1] + "");
                                possiblem.add("B5");
                                possiblem.add("D5");
                            }
                            break;
                    case "C5": {
                                ordinate[1] = '6';
                                possiblem.add("C" + ordinate[1] + "");
                                possiblem.add("B6");
                                possiblem.add("D6");
                            }
                            break;
                    case "C6": {
                                ordinate[1] = '7';
                                possiblem.add("C" + ordinate[1] + "");
                                possiblem.add("B7");
                                possiblem.add("D7");
                            }
                            break;
                    case "C7": {
                                ordinate[1] = '8';
                                possiblem.add("C" + ordinate[1] + "");
                                possiblem.add("B8");
                                possiblem.add("D8");
                            }
                            break;
                    case "D3": {
                                ordinate[1] = '4';
                                possiblem.add("D" + ordinate[1] + "");
                                possiblem.add("C4");
                                possiblem.add("E4");
                            }
                            break;
                    case "D4": {
                                ordinate[1] = '5';
                                possiblem.add("D" + ordinate[1] + "");
                                possiblem.add("C5");
                                possiblem.add("E5");
                            }
                            break;
                    case "D5": {
                                ordinate[1] = '6';
                                possiblem.add("D" + ordinate[1] + "");
                                possiblem.add("C6");
                                possiblem.add("E6");
                            }
                            break;
                    case "D6": {
                                ordinate[1] = '7';
                                possiblem.add("D" + ordinate[1] + "");
                                possiblem.add("C7");
                                possiblem.add("E7");
                            }
                            break;
                    case "D7": {
                                ordinate[1] = '8';
                                possiblem.add("D" + ordinate[1] + "");
                                possiblem.add("C8");
                                possiblem.add("E8");
                            }
                            break;
                    case "E3": {
                                ordinate[1] = '4';
                                possiblem.add("E" + ordinate[1] + "");
                                possiblem.add("D4");
                                possiblem.add("F4");
                            }
                            break;
                    case "E4": {
                                ordinate[1] = '5';
                                possiblem.add("E" + ordinate[1] + "");
                                possiblem.add("D5");
                                possiblem.add("F5");
                            }
                            break;
                    case "E5": {
                                ordinate[1] = '6';
                                possiblem.add("E" + ordinate[1] + "");
                                possiblem.add("D6");
                                possiblem.add("F6");
                            }
                            break;
                    case "E6": {
                                ordinate[1] = '7';
                                possiblem.add("E" + ordinate[1] + "");
                                possiblem.add("D7");
                                possiblem.add("F7");
                            }
                            break;
                    case "E7": {
                                ordinate[1] = '8';
                                possiblem.add("E" + ordinate[1] + "");
                                possiblem.add("D8");
                                possiblem.add("F8");
                            }
                            break;
                    case "F3": {
                                ordinate[1] = '4';
                                possiblem.add("F" + ordinate[1] + "");
                                possiblem.add("E4");
                                possiblem.add("G4");
                            }
                            break;
                    case "F4": {
                                ordinate[1] = '5';
                                possiblem.add("F" + ordinate[1] + "");
                                possiblem.add("E5");
                                possiblem.add("G5");
                            }
                            break;
                    case "F5": {
                                ordinate[1] = '6';
                                possiblem.add("F" + ordinate[1] + "");
                                possiblem.add("E6");
                                possiblem.add("G6");
                            }
                            break;
                    case "F6": {
                                ordinate[1] = '7';
                                possiblem.add("F" + ordinate[1] + "");
                                possiblem.add("E7");
                                possiblem.add("G7");
                            }
                            break;
                    case "F7": {
                                ordinate[1] = '8';
                                possiblem.add("F" + ordinate[1] + "");
                                possiblem.add("E8");
                                possiblem.add("G8");
                            }
                            break;
                    case "G3": {
                                ordinate[1] = '4';
                                possiblem.add("G" + ordinate[1] + "");
                                possiblem.add("F4");
                                possiblem.add("H4");
                            }
                            break;
                    case "G4": {
                                ordinate[1] = '5';
                                possiblem.add("G" + ordinate[1] + "");
                                possiblem.add("F5");
                                possiblem.add("H5");
                            }
                            break;
                    case "G5": {
                                ordinate[1] = '6';
                                possiblem.add("G" + ordinate[1] + "");
                                possiblem.add("F6");
                                possiblem.add("H6");
                            }
                            break;
                    case "G6": {
                                ordinate[1] = '7';
                                possiblem.add("G" + ordinate[1] + "");
                                possiblem.add("F7");
                                possiblem.add("H7");
                            }
                            break;
                    case "G7": {
                                ordinate[1] = '8';
                                possiblem.add("G" + ordinate[1] + "");
                                possiblem.add("F8");
                                possiblem.add("H8");
                            }
                            break;
                    case "H3": {
                                ordinate[1] = '4';
                                possiblem.add("H" + ordinate[1] + "");
                                possiblem.add("G4");
                            }
                            break;
                    case "H4": {
                                ordinate[1] = '5';
                                possiblem.add("H" + ordinate[1] + "");
                                possiblem.add("G5");
                            }
                            break;
                    case "H5": {
                                ordinate[1] = '6';
                                possiblem.add("H" + ordinate[1] + "");
                                possiblem.add("G6");
                            }
                            break;
                    case "H6": {
                                ordinate[1] = '7';
                                possiblem.add("H" + ordinate[1] + "");
                                possiblem.add("G7");
                            }
                            break;
                    case "H7": {
                                ordinate[1] = '8';
                                possiblem.add("H" + ordinate[1] + "");
                                possiblem.add("G8");
                            }
                            break;
                }
            }
        }
        else if(race.equals("black"))
        {
            if(moves == 0)
            {
                switch(location)
                {
                    case "A7": {
                                ordinate[1] = '6';
                                possiblem.add("A" + ordinate[1] + "");
                                ordinate[1] = '5';
                                possiblem.add("A" + ordinate[1] + "");
                                possiblem.add("B6");
                            }
                            break;
                    case "B7": {
                                ordinate[1] = '6';
                                possiblem.add("B" + ordinate[1] + "");
                                ordinate[1] = '5';
                                possiblem.add("B" + ordinate[1] + "");
                                possiblem.add("A6");
                                possiblem.add("C6");
                            }
                            break;
                    case "C7": {
                                ordinate[1] = '6';
                                possiblem.add("C" + ordinate[1] + "");
                                ordinate[1] = '5';
                                possiblem.add("C" + ordinate[1] + "");
                                possiblem.add("B6");
                                possiblem.add("D6");
                            }
                            break;
                    case "D7": {
                                ordinate[1] = '6';
                                possiblem.add("D" + ordinate[1] + "");
                                ordinate[1] = '5';
                                possiblem.add("D" + ordinate[1] + "");
                                possiblem.add("C6");
                                possiblem.add("E6");
                            }
                            break;
                    case "E7": {
                                ordinate[1] = '6';
                                possiblem.add("E" + ordinate[1] + "");
                                ordinate[1] = '5';
                                possiblem.add("E" + ordinate[1] + "");
                                possiblem.add("D6");
                                possiblem.add("F6");
                            }
                            break;
                    case "F7": {
                                ordinate[1] = '6';
                                possiblem.add("F" + ordinate[1] + "");
                                ordinate[1] = '5';
                                possiblem.add("F" + ordinate[1] + "");
                                possiblem.add("E6");
                                possiblem.add("G6");
                            }
                            break;
                    case "G7": {
                                ordinate[1] = '6';
                                possiblem.add("G" + ordinate[1] + "");
                                ordinate[1] = '5';
                                possiblem.add("G" + ordinate[1] + "");
                                possiblem.add("F6");
                                possiblem.add("H6");
                            }
                            break;
                    case "H7": {
                                ordinate[1] = '6';
                                possiblem.add("H" + ordinate[1] + "");
                                ordinate[1] = '5';
                                possiblem.add("H" + ordinate[1] + "");
                                possiblem.add("G6");
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
                                possiblem.add("B5");
                            }
                            break;
                    case "A5": {
                                ordinate[1] = '4';
                                possiblem.add("A" + ordinate[1] + "");
                                possiblem.add("B4");
                            }
                            break;
                    case "A4": {
                                ordinate[1] = '3';
                                possiblem.add("A" + ordinate[1] + "");
                                possiblem.add("B3");
                            }
                            break;
                    case "A3": {
                                ordinate[1] = '2';
                                possiblem.add("A" + ordinate[1] + "");
                                possiblem.add("B2");
                            }
                            break;
                    case "A2": {
                                ordinate[1] = '1';
                                possiblem.add("A" + ordinate[1] + "");
                                possiblem.add("B1");
                            }
                            break;
                    case "B6": {
                                ordinate[1] = '5';
                                possiblem.add("B" + ordinate[1] + "");
                                possiblem.add("A5");
                                possiblem.add("C5");
                            }
                            break;
                    case "B5": {
                                ordinate[1] = '4';
                                possiblem.add("B" + ordinate[1] + "");
                                possiblem.add("A4");
                                possiblem.add("C4");
                            }
                            break;
                    case "B4": {
                                ordinate[1] = '3';
                                possiblem.add("B" + ordinate[1] + "");
                                possiblem.add("A3");
                                possiblem.add("C3");
                            }
                            break;
                    case "B3": {
                                ordinate[1] = '2';
                                possiblem.add("B" + ordinate[1] + "");
                                possiblem.add("A2");
                                possiblem.add("C2");
                            }
                            break;
                    case "B2": {
                                ordinate[1] = '1';
                                possiblem.add("B" + ordinate[1] + "");
                                possiblem.add("A1");
                                possiblem.add("C1");
                            }
                            break;
                    case "C6": {
                                ordinate[1] = '5';
                                possiblem.add("C" + ordinate[1] + "");
                                possiblem.add("B5");
                                possiblem.add("D5");
                            }
                            break;
                    case "C5": {
                                ordinate[1] = '4';
                                possiblem.add("C" + ordinate[1] + "");
                                possiblem.add("B4");
                                possiblem.add("D4");
                            }
                            break;
                    case "C4": {
                                ordinate[1] = '3';
                                possiblem.add("C" + ordinate[1] + "");
                                possiblem.add("B3");
                                possiblem.add("D3");
                            }
                            break;
                    case "C3": {
                                ordinate[1] = '2';
                                possiblem.add("C" + ordinate[1] + "");
                                possiblem.add("B2");
                                possiblem.add("D2");
                            }
                            break;
                    case "C2": {
                                ordinate[1] = '1';
                                possiblem.add("C" + ordinate[1] + "");
                                possiblem.add("B1");
                                possiblem.add("D1");
                            }
                            break;
                    case "D6": {
                                ordinate[1] = '5';
                                possiblem.add("D" + ordinate[1] + "");
                                possiblem.add("C5");
                                possiblem.add("E5");
                            }
                            break;
                    case "D5": {
                                ordinate[1] = '4';
                                possiblem.add("D" + ordinate[1] + "");
                                possiblem.add("C4");
                                possiblem.add("E4");
                            }
                            break;
                    case "D4": {
                                ordinate[1] = '3';
                                possiblem.add("D" + ordinate[1] + "");
                                possiblem.add("C3");
                                possiblem.add("E3");
                            }
                            break;
                    case "D3": {
                                ordinate[1] = '2';
                                possiblem.add("D" + ordinate[1] + "");
                                possiblem.add("C2");
                                possiblem.add("E2");
                            }
                            break;
                    case "D2": {
                                ordinate[1] = '1';
                                possiblem.add("D" + ordinate[1] + "");
                                possiblem.add("C1");
                                possiblem.add("E1");
                            }
                            break;
                    case "E6": {
                                ordinate[1] = '5';
                                possiblem.add("E" + ordinate[1] + "");
                                possiblem.add("D5");
                                possiblem.add("F5");
                            }
                            break;
                    case "E5": {
                                ordinate[1] = '4';
                                possiblem.add("E" + ordinate[1] + "");
                                possiblem.add("D4");
                                possiblem.add("F4");
                            }
                            break;
                    case "E4": {
                                ordinate[1] = '3';
                                possiblem.add("E" + ordinate[1] + "");
                                possiblem.add("D3");
                                possiblem.add("F3");
                            }
                            break;
                    case "E3": {
                                ordinate[1] = '2';
                                possiblem.add("E" + ordinate[1] + "");
                                possiblem.add("D2");
                                possiblem.add("F2");
                            }
                            break;
                    case "E2": {
                                ordinate[1] = '1';
                                possiblem.add("E" + ordinate[1] + "");
                                possiblem.add("D1");
                                possiblem.add("F1");
                            }
                            break;
                    case "F6": {
                                ordinate[1] = '5';
                                possiblem.add("F" + ordinate[1] + "");
                                possiblem.add("E5");
                                possiblem.add("G5");
                            }
                            break;
                    case "F5": {
                                ordinate[1] = '4';
                                possiblem.add("F" + ordinate[1] + "");
                                possiblem.add("E4");
                                possiblem.add("G4");
                            }
                            break;
                    case "F4": {
                                ordinate[1] = '3';
                                possiblem.add("F" + ordinate[1] + "");
                                possiblem.add("E3");
                                possiblem.add("G3");
                            }
                            break;
                    case "F3": {
                                ordinate[1] = '2';
                                possiblem.add("F" + ordinate[1] + "");
                                possiblem.add("E2");
                                possiblem.add("G2");
                            }
                            break;
                    case "F2": {
                                ordinate[1] = '1';
                                possiblem.add("F" + ordinate[1] + "");
                                possiblem.add("E1");
                                possiblem.add("G1");
                            }
                            break;
                    case "G6": {
                                ordinate[1] = '5';
                                possiblem.add("G" + ordinate[1] + "");
                                possiblem.add("F5");
                                possiblem.add("H5");
                            }
                            break;
                    case "G5": {
                                ordinate[1] = '4';
                                possiblem.add("G" + ordinate[1] + "");
                                possiblem.add("F4");
                                possiblem.add("H4");
                            }
                            break;
                    case "G4": {
                                ordinate[1] = '3';
                                possiblem.add("G" + ordinate[1] + "");
                                possiblem.add("F3");
                                possiblem.add("H3");
                            }
                            break;
                    case "G3": {
                                ordinate[1] = '2';
                                possiblem.add("G" + ordinate[1] + "");
                                possiblem.add("F2");
                                possiblem.add("H2");
                            }
                            break;
                    case "G2": {
                                ordinate[1] = '1';
                                possiblem.add("G" + ordinate[1] + "");
                                possiblem.add("F1");
                                possiblem.add("H1");
                            }
                            break;
                    case "H6": {
                                ordinate[1] = '5';
                                possiblem.add("H" + ordinate[1] + "");
                                possiblem.add("G5");
                            }
                            break;
                    case "H5": {
                                ordinate[1] = '4';
                                possiblem.add("H" + ordinate[1] + "");
                                possiblem.add("G4");
                            }
                            break;
                    case "H4": {
                                ordinate[1] = '3';
                                possiblem.add("H" + ordinate[1] + "");
                                possiblem.add("G3");
                            }
                            break;
                    case "H3": {
                                ordinate[1] = '2';
                                possiblem.add("H" + ordinate[1] + "");
                                possiblem.add("G2");
                            }
                            break;
                    case "H2": {
                                ordinate[1] = '1';
                                possiblem.add("H" + ordinate[1] + "");
                                possiblem.add("G1");
                            }
                            break;
                }
            }
        }

        return possiblem;
    }
} 