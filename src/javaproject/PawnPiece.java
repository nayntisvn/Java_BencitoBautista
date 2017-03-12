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
                        }
                        break;
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
                    System.out.println("Hey");
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
            }
        }
        
        moves++;
        
        return possiblem;
    }
    
    
}
