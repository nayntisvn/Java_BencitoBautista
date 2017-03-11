package javaproject;

import com.sun.javafx.image.impl.IntArgb;
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
            }
        }
        else
        {
            switch(location)
            {
                case "A3": {
                            ordinate[0] = 'A';
                            ordinate[1] = '4';
                            possiblem.add(ordinate[0] + ordinate[1] + "");
                            ordinate[0] = 'A';
                            ordinate[1] = '5';
                            possiblem.add(ordinate[0] + ordinate[1] + "");
                        }
                    break;
            }
        }
        
        return possiblem;
    }
    
    public void getpossiblem()
    {
        
        
        
    }
    
    
}
