package javaproject;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sdist
 */
public class RookPiece {
    
    int moves = 0;
    String location = null;
    String race = null;
    ArrayList<String> possiblem = new ArrayList<>();
    
    public RookPiece(String race, String loc) 
    {
        this.race = race;
        this.location = loc;
    }
    
    public ArrayList<String> movementW(){
        possiblem.clear();
        char[] ordinate = {'0','0'};
        
        switch(location){
            case "A1":  {
                            for(int i = 2; i == 8; i++){
                                possiblem.add("A" + i);
                            }
                            break;
                        }
            case "A2":  {
                            for(int i = 3; i == 8; i++){
                                possiblem.add("A" + i);
                            }
                            possiblem.add("A1");
                        }
            case "A3":  {
                            for(int i = 4; i == 8; i++){
                                possiblem.add("A" + i);
                            }
                            for(int i = 1; i == 2; i++){
                                possiblem.add("A" + i);
                            }
                        }
            case "A4":  {
                            for(int i = 5; i == 8; i++){
                                possiblem.add("A" + i);
                            }
                            for(int i = 1; i == 3; i++){
                                possiblem.add("A" + i);
                            }
                        }
            case "A5":  {
                            for(int i = 6; i == 8; i++){
                                possiblem.add("A" + i);
                            }
                            for(int i = 1; i == 4; i++){
                                possiblem.add("A" + i);
                            }
                        }
            case "A6":  {
                            for(int i = 7; i == 8; i++){
                                possiblem.add("A" + i);
                            }
                            for(int i = 1; i == 5; i++){
                                possiblem.add("A" + i);
                            }
                        }
            case "A7":  {
                            possiblem.add("A8");
                            for(int i = 1; i == 6; i++){
                                possiblem.add("A" + i);
                            }
                        }
            case "A8":  {
                            for(int i = 1; i == 7; i++){
                                possiblem.add("A" + i);
                            }
                        }
            case "B1":  {
                            for(int i = 2; i == 8; i++){
                                possiblem.add("B" + i);
                            }
                            break;
                        }
            case "B2":  {
                            for(int i = 3; i == 8; i++){
                                possiblem.add("B" + i);
                            }
                            possiblem.add("B1");
                        }
            case "B3":  {
                            for(int i = 4; i == 8; i++){
                                possiblem.add("B" + i);
                            }
                            for(int i = 1; i == 2; i++){
                                possiblem.add("B" + i);
                            }
                        }
            case "B4":  {
                            for(int i = 5; i == 8; i++){
                                possiblem.add("B" + i);
                            }
                            for(int i = 1; i == 3; i++){
                                possiblem.add("B" + i);
                            }
                        }
            case "B5":  {
                            for(int i = 6; i == 8; i++){
                                possiblem.add("B" + i);
                            }
                            for(int i = 1; i == 4; i++){
                                possiblem.add("B" + i);
                            }
                        }
            case "B6":  {
                            for(int i = 7; i == 8; i++){
                                possiblem.add("B" + i);
                            }
                            for(int i = 1; i == 5; i++){
                                possiblem.add("B" + i);
                            }
                        }
            case "B7":  {
                            possiblem.add("B8");
                            for(int i = 1; i == 6; i++){
                                possiblem.add("B" + i);
                            }
                        }
            case "B8":  {
                            for(int i = 1; i == 7; i++){
                                possiblem.add("B" + i);
                            }
                        }
            case "C1":  {
                            for(int i = 2; i == 8; i++){
                                possiblem.add("C" + i);
                            }
                            break;
                        }
            case "C2":  {
                            for(int i = 3; i == 8; i++){
                                possiblem.add("C" + i);
                            }
                            possiblem.add("C1");
                        }
            case "C3":  {
                            for(int i = 4; i == 8; i++){
                                possiblem.add("C" + i);
                            }
                            for(int i = 1; i == 2; i++){
                                possiblem.add("C" + i);
                            }
                        }
            case "C4":  {
                            for(int i = 5; i == 8; i++){
                                possiblem.add("C" + i);
                            }
                            for(int i = 1; i == 3; i++){
                                possiblem.add("A" + i);
                            }
                        }
            case "C5":  {
                            for(int i = 6; i == 8; i++){
                                possiblem.add("C" + i);
                            }
                            for(int i = 1; i == 4; i++){
                                possiblem.add("C" + i);
                            }
                        }
            case "C6":  {
                            for(int i = 7; i == 8; i++){
                                possiblem.add("A" + i);
                            }
                            for(int i = 1; i == 5; i++){
                                possiblem.add("C" + i);
                            }
                        }
            case "C7":  {
                            possiblem.add("C8");
                            for(int i = 1; i == 6; i++){
                                possiblem.add("C" + i);
                            }
                        }
            case "C8":  {
                            for(int i = 1; i == 7; i++){
                                possiblem.add("C" + i);
                            }
                        }
            case "D1":  {
                            for(int i = 2; i == 8; i++){
                                possiblem.add("D" + i);
                            }
                            break;
                        }
            case "D2":  {
                            for(int i = 3; i == 8; i++){
                                possiblem.add("D" + i);
                            }
                            possiblem.add("D1");
                        }
            case "D3":  {
                            for(int i = 4; i == 8; i++){
                                possiblem.add("D" + i);
                            }
                            for(int i = 1; i == 2; i++){
                                possiblem.add("D" + i);
                            }
                        }
            case "D4":  {
                            for(int i = 5; i == 8; i++){
                                possiblem.add("D" + i);
                            }
                            for(int i = 1; i == 3; i++){
                                possiblem.add("D" + i);
                            }
                        }
            case "D5":  {
                            for(int i = 6; i == 8; i++){
                                possiblem.add("D" + i);
                            }
                            for(int i = 1; i == 4; i++){
                                possiblem.add("D" + i);
                            }
                        }
            case "D6":  {
                            for(int i = 7; i == 8; i++){
                                possiblem.add("D" + i);
                            }
                            for(int i = 1; i == 5; i++){
                                possiblem.add("D" + i);
                            }
                        }
            case "D7":  {
                            possiblem.add("D8");
                            for(int i = 1; i == 6; i++){
                                possiblem.add("D" + i);
                            }
                        }
            case "D8":  {
                            for(int i = 1; i == 7; i++){
                                possiblem.add("D" + i);
                            }
                        }
            case "E1":  {
                            for(int i = 2; i == 8; i++){
                                possiblem.add("E" + i);
                            }
                            break;
                        }
            case "E2":  {
                            for(int i = 3; i == 8; i++){
                                possiblem.add("E" + i);
                            }
                            possiblem.add("E1");
                        }
            case "E3":  {
                            for(int i = 4; i == 8; i++){
                                possiblem.add("E" + i);
                            }
                            for(int i = 1; i == 2; i++){
                                possiblem.add("E" + i);
                            }
                        }
            case "E4":  {
                            for(int i = 5; i == 8; i++){
                                possiblem.add("E" + i);
                            }
                            for(int i = 1; i == 3; i++){
                                possiblem.add("E" + i);
                            }
                        }
            case "E5":  {
                            for(int i = 6; i == 8; i++){
                                possiblem.add("E" + i);
                            }
                            for(int i = 1; i == 4; i++){
                                possiblem.add("E" + i);
                            }
                        }
            case "E6":  {
                            for(int i = 7; i == 8; i++){
                                possiblem.add("E" + i);
                            }
                            for(int i = 1; i == 5; i++){
                                possiblem.add("E" + i);
                            }
                        }
            case "E7":  {
                            possiblem.add("E8");
                            for(int i = 1; i == 6; i++){
                                possiblem.add("E" + i);
                            }
                        }
            case "E8":  {
                            for(int i = 1; i == 7; i++){
                                possiblem.add("E" + i);
                            }
                        }
            case "F1":  {
                            for(int i = 2; i == 8; i++){
                                possiblem.add("F" + i);
                            }
                            break;
                        }
            case "F2":  {
                            for(int i = 3; i == 8; i++){
                                possiblem.add("F" + i);
                            }
                            possiblem.add("F1");
                        }
            case "F3":  {
                            for(int i = 4; i == 8; i++){
                                possiblem.add("F" + i);
                            }
                            for(int i = 1; i == 2; i++){
                                possiblem.add("F" + i);
                            }
                        }
            case "F4":  {
                            for(int i = 5; i == 8; i++){
                                possiblem.add("F" + i);
                            }
                            for(int i = 1; i == 3; i++){
                                possiblem.add("F" + i);
                            }
                        }
            case "F5":  {
                            for(int i = 6; i == 8; i++){
                                possiblem.add("A" + i);
                            }
                            for(int i = 1; i == 4; i++){
                                possiblem.add("A" + i);
                            }
                        }
            case "F6":  {
                            for(int i = 7; i == 8; i++){
                                possiblem.add("F" + i);
                            }
                            for(int i = 1; i == 5; i++){
                                possiblem.add("F" + i);
                            }
                        }
            case "F7":  {
                            possiblem.add("F8");
                            for(int i = 1; i == 6; i++){
                                possiblem.add("F" + i);
                            }
                        }
            case "F8":  {
                            for(int i = 1; i == 7; i++){
                                possiblem.add("F" + i);
                            }
                        }
        }
        
        moves ++;
        return possiblem;
    }
    
}
