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
    
    public ArrayList<String> movement(){
        possiblem.clear();
        char[] ordinate = {'0','0'};
        
        switch(location){
            case "A1":  
            {   
                for(int i = 2; i <= 8; i++){
                    possiblem.add("A" + i);
                }
                for(char a = 'B'; a <= 'H'; a++){
                    possiblem.add(a + "1");
                }
                break;
            }
            case "A2":  
            {
                for(int i = 3; i <= 8; i++){
                    possiblem.add("A" + i);
                }
                possiblem.add("A1");
                for(char a = 'B'; a <= 'H'; a++){
                    possiblem.add(a + "2");
                }
                break;
            }
            case "A3":  
            {
                for(int i = 4; i <= 8; i++){
                    possiblem.add("A" + i);
                }
                for(int i = 1; i <= 2; i++){
                    possiblem.add("A" + i);
                }
                for(char a = 'B'; a <= 'H'; a++){
                    possiblem.add(a + "3");
                }
                break;
            }
            case "A4":  
            {
                for(int i = 5; i <= 8; i++){
                    possiblem.add("A" + i);
                }
                for(int i = 1; i <= 3; i++){
                    possiblem.add("A" + i);
                }
                for(char a = 'B'; a <= 'H'; a++){
                    possiblem.add(a + "4");
                }
                break;
            }
            case "A5":  
            {
                for(int i = 6; i <= 8; i++){
                    possiblem.add("A" + i);
                }
                for(int i = 1; i <= 4; i++){
                    possiblem.add("A" + i);
                }
                for(char a = 'B'; a <= 'H'; a++){
                    possiblem.add(a + "5");
                }
                break;
            }
            case "A6":  
            {
                for(int i = 7; i <= 8; i++){
                    possiblem.add("A" + i);
                }
                for(int i = 1; i <= 5; i++){
                    possiblem.add("A" + i);
                }
                for(char a = 'B'; a <= 'H'; a++){
                    possiblem.add(a + "6");
                }
                break;
            }
            case "A7":  
            {
                possiblem.add("A8");
                for(int i = 1; i <= 6; i++){
                    possiblem.add("A" + i);
                }
                for(char a = 'B'; a <= 'H'; a++){
                    possiblem.add(a + "7");
                }
                break;
            }
            case "A8":  
            {
                for(int i = 1; i <= 7; i++){
                    possiblem.add("A" + i);
                }
                for(char a = 'B'; a <= 'H'; a++){
                    possiblem.add(a + "8");
                }
                break;
            }
            case "B1":  
            {
                for(int i = 2; i <= 8; i++){
                    possiblem.add("B" + i);
                }
                possiblem.add("A1");
                for(char a = 'C'; a <= 'H'; a++){
                    possiblem.add(a + "1");
                }
                break;
            }
            case "B2":  
            {
                //B3 to b8
                for(int i = 3; i <= 8; i++){
                    possiblem.add("B" + i);
                }
                possiblem.add("B1");
                possiblem.add("A2");
                for(char a = 'C'; a <= 'H'; a++){
                    possiblem.add(a + "2");
                }
                break;
            }
            case "B3":  
            {
                //B4 TO B8
                for(int i = 4; i <= 8; i++){
                    possiblem.add("B" + i);
                }
                //B1 TO B2
                for(int i = 1; i <= 2; i++){
                    possiblem.add("B" + i);
                }
                //c3 to h3
                for(char a = 'C'; a <= 'H'; a++){
                    possiblem.add(a + "3");
                }
                possiblem.add("A3");
                break;
            }
            case "B4":  
            {
                //b5 to b8
                for(int i = 5; i <= 8; i++){
                    possiblem.add("B" + i);
                }
                //b1 to b3
                for(int i = 1; i <= 3; i++){
                    possiblem.add("B" + i);
                }
                //c4 to h4
                for(char a = 'C'; a <= 'H'; a++){
                    possiblem.add(a + "4");
                }
                possiblem.add("A4");
                break;
            }
            case "B5":  
            {
                //b6 to b8
                for(int i = 6; i <= 8; i++){
                    possiblem.add("B" + i);
                }
                //b1 to b4
                for(int i = 1; i <= 4; i++){
                    possiblem.add("B" + i);
                }
                //c5 to h5
                for(char a = 'C'; a <= 'H'; a++){
                    possiblem.add(a + "5");
                }
                possiblem.add("A5");
                break;
            }
            case "B6":  
            {
                //b7 to b8
                for(int i = 7; i <= 8; i++){
                    possiblem.add("B" + i);
                }
                //b1 to b5
                for(int i = 1; i <= 5; i++){
                    possiblem.add("B" + i);
                }
                //c6 to h6
                for(char a = 'C'; a <= 'H'; a++){
                    possiblem.add(a + "6");
                }
                possiblem.add("A6");
                break;
            }
            case "B7":  
            {
                possiblem.add("B8");
                //b1 to b6
                for(int i = 1; i <= 6; i++){
                    possiblem.add("B" + i);
                }
                //c7 to h7
                for(char a = 'C'; a <= 'H'; a++){
                    possiblem.add(a + "7");
                }
                possiblem.add("A7");
                break;
            }
            case "B8":  
            {
                //b1 to b7
                for(int i = 1; i <= 7; i++){
                    possiblem.add("B" + i);
                }
                for(char a = 'C'; a <= 'H'; a++){
                    possiblem.add(a + "8");
                }
                possiblem.add("A8");
                break;
            }
            case "C1":  
            {
                //c2 to c8
                for(int i = 2; i <= 8; i++){
                    possiblem.add("C" + i);
                }
                //D1 TO H1
                for(char a = 'D'; a <= 'H'; a++){
                    possiblem.add(a + "1");
                }
                for(char a = 'A'; a <= 'B'; a++){
                    possiblem.add(a + "1");
                }
                break;
            }
            case "C2":  
            {
                for(int i = 3; i <= 8; i++){
                    possiblem.add("C" + i);
                }
                possiblem.add("C1");
                for(char a = 'D'; a <= 'H'; a++){
                    possiblem.add(a + "2");
                }
                for(char a = 'A'; a <= 'B'; a++){
                    possiblem.add(a + "2");
                }
                break;
            }
            case "C3":  
            {
                for(int i = 4; i <= 8; i++){
                    possiblem.add("C" + i);
                }
                for(int i = 1; i <= 2; i++){
                    possiblem.add("C" + i);
                }
                for(char a = 'D'; a <= 'H'; a++){
                    possiblem.add(a + "3");
                }
                for(char a = 'A'; a <= 'B'; a++){
                    possiblem.add(a + "3");
                }
                break;
            }
            case "C4":  
            {
                for(int i = 5; i <= 8; i++){
                    possiblem.add("C" + i);
                }
                for(int i = 1; i <= 3; i++){
                    possiblem.add("A" + i);
                }
                for(char a = 'D'; a <= 'H'; a++){
                    possiblem.add(a + "4");
                }
                for(char a = 'A'; a <= 'B'; a++){
                    possiblem.add(a + "4");
                }
                break;
            }
            case "C5":  
            {
                for(int i = 6; i <= 8; i++){
                    possiblem.add("C" + i);
                }
                for(int i = 1; i <= 4; i++){
                    possiblem.add("C" + i);
                }
                for(char a = 'D'; a <= 'H'; a++){
                    possiblem.add(a + "5");
                }
                for(char a = 'A'; a <= 'B'; a++){
                    possiblem.add(a + "5");
                }
                break;
            }
            case "C6":  
            {
                for(int i = 7; i <= 8; i++){
                    possiblem.add("A" + i);
                }
                for(int i = 1; i <= 5; i++){
                    possiblem.add("C" + i);
                }
                for(char a = 'D'; a <= 'H'; a++){
                    possiblem.add(a + "6");
                }
                for(char a = 'A'; a <= 'B'; a++){
                    possiblem.add(a + "6");
                }
                break;
            }
            case "C7":  
            {
                possiblem.add("C8");
                for(int i = 1; i <= 6; i++){
                    possiblem.add("C" + i);
                }
                for(char a = 'D'; a <= 'H'; a++){
                    possiblem.add(a + "7");
                }
                for(char a = 'A'; a <= 'B'; a++){
                    possiblem.add(a + "7");
                }
                break;
            }
            case "C8":  
            {
                for(int i = 1; i <= 7; i++){
                    possiblem.add("C" + i);
                }
                for(char a = 'D'; a <= 'H'; a++){
                    possiblem.add(a + "8");
                }
                for(char a = 'A'; a <= 'B'; a++){
                    possiblem.add(a + "8");
                }
                break;
            }
            case "D1":  
            {
                for(int i = 2; i <= 8; i++){
                    possiblem.add("D" + i);
                }
                for(char a = 'E'; a <= 'H'; a++){
                    possiblem.add(a + "1");
                }
                for(char a = 'A'; a <= 'C'; a++){
                    possiblem.add(a + "1");
                }
                break;
            }
            case "D2":  
            {
                for(int i = 3; i <= 8; i++){
                    possiblem.add("D" + i);
                }
                possiblem.add("D1");
                for(char a = 'E'; a <= 'H'; a++){
                    possiblem.add(a + "2");
                }
                for(char a = 'A'; a <= 'C'; a++){
                    possiblem.add(a + "2");
                }
                break;
            }
            case "D3":  
            {
                for(int i = 4; i <= 8; i++){
                    possiblem.add("D" + i);
                }
                for(int i = 1; i <= 2; i++){
                    possiblem.add("D" + i);
                }
                for(char a = 'E'; a <= 'H'; a++){
                    possiblem.add(a + "3");
                }
                for(char a = 'A'; a <= 'C'; a++){
                    possiblem.add(a + "3");
                }
                break;
            }
            case "D4":  
            {
                for(int i = 5; i <= 8; i++){
                    possiblem.add("D" + i);
                }
                for(int i = 1; i <= 3; i++){
                    possiblem.add("D" + i);
                }
                for(char a = 'E'; a <= 'H'; a++){
                    possiblem.add(a + "4");
                }
                for(char a = 'A'; a <= 'C'; a++){
                    possiblem.add(a + "4");
                }
                break;
            }
            case "D5":  
            {
                for(int i = 6; i <= 8; i++){
                    possiblem.add("D" + i);
                }
                for(int i = 1; i <= 4; i++){
                    possiblem.add("D" + i);
                }
                for(char a = 'E'; a <= 'H'; a++){
                    possiblem.add(a + "5");
                }
                for(char a = 'A'; a <= 'C'; a++){
                    possiblem.add(a + "5");
                }
                break;
            }
            case "D6":  
            {
                for(int i = 7; i <= 8; i++){
                    possiblem.add("D" + i);
                }
                for(int i = 1; i <= 5; i++){
                    possiblem.add("D" + i);
                }
                for(char a = 'E'; a <= 'H'; a++){
                    possiblem.add(a + "6");
                }
                for(char a = 'A'; a <= 'C'; a++){
                    possiblem.add(a + "6");
                }
                break;
            }
            case "D7":  
            {
                possiblem.add("D8");
                for(int i = 1; i <= 6; i++){
                    possiblem.add("D" + i);
                }
                for(char a = 'E'; a <= 'H'; a++){
                    possiblem.add(a + "7");
                }
                for(char a = 'A'; a <= 'C'; a++){
                    possiblem.add(a + "7");
                }
                break;
            }
            case "D8":  
            {
                for(int i = 1; i <= 7; i++){
                    possiblem.add("D" + i);
                }
                for(char a = 'E'; a <= 'H'; a++){
                    possiblem.add(a + "8");
                }
                for(char a = 'A'; a <= 'C'; a++){
                    possiblem.add(a + "8");
                }
                break;
            }
            case "E1":  
            {
                for(int i = 2; i <= 8; i++){
                    possiblem.add("E" + i);
                }
                for(char a = 'F'; a <= 'H'; a++){
                    possiblem.add(a + "1");
                }
                for(char a = 'A'; a <= 'D'; a++){
                    possiblem.add(a + "1");
                }
                break;
            }
            case "E2":  
            {
                for(int i = 3; i <= 8; i++){
                    possiblem.add("E" + i);
                }
                possiblem.add("E1");
                for(char a = 'F'; a <= 'H'; a++){
                    possiblem.add(a + "2");
                }
                for(char a = 'A'; a <= 'D'; a++){
                    possiblem.add(a + "2");
                }
                break;
            }
            case "E3":  
            {
                for(int i = 4; i <= 8; i++){
                    possiblem.add("E" + i);
                }
                for(int i = 1; i <= 2; i++){
                    possiblem.add("E" + i);
                }
                for(char a = 'F'; a <= 'H'; a++){
                    possiblem.add(a + "3");
                }
                for(char a = 'A'; a <= 'D'; a++){
                    possiblem.add(a + "3");
                }
                break;
            }
            case "E4":  
            {
                for(int i = 5; i <= 8; i++){
                    possiblem.add("E" + i);
                }
                for(int i = 1; i <= 3; i++){
                    possiblem.add("E" + i);
                }
                for(char a = 'F'; a <= 'H'; a++){
                    possiblem.add(a + "4");
                }
                for(char a = 'A'; a <= 'D'; a++){
                    possiblem.add(a + "4");
                }
                break;
            }
            case "E5":  
            {
                for(int i = 6; i <= 8; i++){
                    possiblem.add("E" + i);
                }
                for(int i = 1; i <= 4; i++){
                    possiblem.add("E" + i);
                }
                for(char a = 'F'; a <= 'H'; a++){
                    possiblem.add(a + "5");
                }
                for(char a = 'A'; a <= 'D'; a++){
                    possiblem.add(a + "5");
                }
                break;
            }
            case "E6":  
            {
                for(int i = 7; i <= 8; i++){
                    possiblem.add("E" + i);
                }
                for(int i = 1; i <= 5; i++){
                    possiblem.add("E" + i);
                }
                for(char a = 'F'; a <= 'H'; a++){
                    possiblem.add(a + "6");
                }
                for(char a = 'A'; a <= 'D'; a++){
                    possiblem.add(a + "6");
                }
                break;
            }
            case "E7":  
            {
                possiblem.add("E8");
                for(int i = 1; i <= 6; i++){
                    possiblem.add("E" + i);
                }
                for(char a = 'F'; a <= 'H'; a++){
                    possiblem.add(a + "7");
                }
                for(char a = 'A'; a <= 'D'; a++){
                    possiblem.add(a + "7");
                }
                break;
            }
            case "E8":  
            {
                for(int i = 1; i <= 7; i++){
                    possiblem.add("E" + i);
                }
                for(char a = 'F'; a <= 'H'; a++){
                    possiblem.add(a + "8");
                }
                for(char a = 'A'; a <= 'D'; a++){
                    possiblem.add(a + "8");
                }
                break;
            }
            case "F1":  
            {
                for(int i = 2; i <= 8; i++){
                    possiblem.add("F" + i);
                }
                for(char a = 'G'; a <= 'H'; a++){
                    possiblem.add(a + "1");
                }
                for(char a = 'A'; a <= 'E'; a++){
                    possiblem.add(a + "1");
                }
                break;
            }
            case "F2":  
            {
                for(int i = 3; i <= 8; i++){
                    possiblem.add("F" + i);
                }
                possiblem.add("F1");
                for(char a = 'G'; a <= 'H'; a++){
                    possiblem.add(a + "2");
                }
                for(char a = 'A'; a <= 'E'; a++){
                    possiblem.add(a + "2");
                }
                break;
            }
            case "F3":  
            {
                for(int i = 4; i <= 8; i++){
                    possiblem.add("F" + i);
                }
                for(int i = 1; i <= 2; i++){
                    possiblem.add("F" + i);
                }
                for(char a = 'G'; a <= 'H'; a++){
                    possiblem.add(a + "3");
                }
                for(char a = 'A'; a <= 'E'; a++){
                    possiblem.add(a + "3");
                }
                break;
            }
            case "F4":  
            {
                for(int i = 5; i <= 8; i++){
                    possiblem.add("F" + i);
                }
                for(int i = 1; i <= 3; i++){
                    possiblem.add("F" + i);
                }
                for(char a = 'G'; a <= 'H'; a++){
                    possiblem.add(a + "4");
                }
                for(char a = 'A'; a <= 'E'; a++){
                    possiblem.add(a + "4");
                }
                break;
            }
            case "F5":  
            {
                for(int i = 6; i <= 8; i++){
                    possiblem.add("A" + i);
                }
                for(int i = 1; i <= 4; i++){
                    possiblem.add("A" + i);
                }
                for(char a = 'G'; a <= 'H'; a++){
                    possiblem.add(a + "5");
                }
                for(char a = 'A'; a <= 'E'; a++){
                    possiblem.add(a + "5");
                }
                break;
            }
            case "F6":  
            {
                for(int i = 7; i <= 8; i++){
                    possiblem.add("F" + i);
                }
                for(int i = 1; i <= 5; i++){
                    possiblem.add("F" + i);
                }
                for(char a = 'G'; a <= 'H'; a++){
                    possiblem.add(a + "6");
                }
                for(char a = 'A'; a <= 'E'; a++){
                    possiblem.add(a + "6");
                }
                break;
            }
            case "F7":  
            {
                possiblem.add("F8");
                for(int i = 1; i <= 6; i++){
                    possiblem.add("F" + i);
                }
                for(char a = 'G'; a <= 'H'; a++){
                    possiblem.add(a + "7");
                }
                for(char a = 'A'; a <= 'E'; a++){
                    possiblem.add(a + "7");
                }
                break;
            }
            case "F8":  
            {
                for(int i = 1; i <= 7; i++){
                    possiblem.add("F" + i);
                }
                for(char a = 'G'; a <= 'H'; a++){
                    possiblem.add(a + "8");
                }
                for(char a = 'A'; a <= 'E'; a++){
                    possiblem.add(a + "8");
                }
                break;
            }
            case "G1":  
            {
                for(int i = 2; i <= 8; i++){
                    possiblem.add("G" + i);
                }
                possiblem.add("H1");
                for(char a = 'A'; a <= 'F'; a++){
                    possiblem.add(a + "1");
                }
                break;
            }
            case "G2":  
            {
                for(int i = 3; i <= 8; i++){
                    possiblem.add("G" + i);
                }
                possiblem.add("H2");
                possiblem.add("G1");
                for(char a = 'A'; a <= 'F'; a++){
                    possiblem.add(a + "2");
                }
                break;
            }
            case "G3":  
            {
                for(int i = 4; i <= 8; i++){
                    possiblem.add("G" + i);
                }
                for(int i = 1; i <= 2; i++){
                    possiblem.add("G" + i);
                }
                for(char a = 'A'; a <= 'F'; a++){
                    possiblem.add(a + "3");
                }
                possiblem.add("H3");
                break;
            }
            case "G4":  
            {
                for(int i = 5; i <= 8; i++){
                    possiblem.add("G" + i);
                }
                for(int i = 1; i <= 3; i++){
                    possiblem.add("G" + i);
                }
                for(char a = 'A'; a <= 'F'; a++){
                    possiblem.add(a + "4");
                }
                possiblem.add("H4");
                break;
            }
            case "G5":  
            {
                for(int i = 6; i <= 8; i++){
                    possiblem.add("G" + i);
                }
                for(int i = 1; i <= 4; i++){
                    possiblem.add("G" + i);
                }
                for(char a = 'A'; a <= 'F'; a++){
                    possiblem.add(a + "5");
                }
                possiblem.add("H5");
                break;
            }
            case "G6":  
            {
                for(int i = 7; i <= 8; i++){
                    possiblem.add("G" + i);
                }
                for(int i = 1; i <= 5; i++){
                    possiblem.add("G" + i);
                }
                for(char a = 'A'; a <= 'F'; a++){
                    possiblem.add(a + "6");
                }
                possiblem.add("H6");
                break;
            }
            case "G7":  
            {
                possiblem.add("H7");
                for(int i = 1; i <= 6; i++){
                    possiblem.add("F" + i);
                }
                for(char a = 'A'; a <= 'F'; a++){
                    possiblem.add(a + "7");
                }
                possiblem.add("G8");
                break;
            }
            case "G8":  
            {   
                for(int i = 1; i <= 7; i++){
                    possiblem.add("F" + i);
                }
                possiblem.add("H8");
                for(char a = 'A'; a <= 'F'; a++){
                    possiblem.add(a + "8");
                }
                break;
            }
            case "H1":  
            {
                for(int i = 2; i <= 8; i++){
                    possiblem.add("H" + i);
                }
                for(char a = 'A'; a <= 'G'; a++){
                    possiblem.add(a + "1");
                }
                break;
            }
            case "H2":  
            {
                for(int i = 3; i <= 8; i++){
                    possiblem.add("H" + i);
                }
                possiblem.add("H1");
                for(char a = 'A'; a <= 'G'; a++){
                    possiblem.add(a + "2");
                }
                break;
            }
            case "H3":  
            {
                for(int i = 4; i <= 8; i++){
                    possiblem.add("H" + i);
                }
                for(int i = 1; i <= 2; i++){
                    possiblem.add("H" + i);
                }
                for(char a = 'A'; a <= 'G'; a++){
                    possiblem.add(a + "3");
                }
                break;
            }
            case "H4":  
            {
                for(int i = 5; i <= 8; i++){
                    possiblem.add("H" + i);
                }
                for(int i = 1; i <= 3; i++){
                    possiblem.add("H" + i);
                }
                for(char a = 'A'; a <= 'G'; a++){
                    possiblem.add(a + "4");
                }
                break;
            }
            case "H5":  
            {
                for(int i = 6; i <= 8; i++){
                    possiblem.add("H" + i);
                }
                for(int i = 1; i <= 4; i++){
                    possiblem.add("H" + i);
                }
                for(char a = 'A'; a <= 'G'; a++){
                    possiblem.add(a + "5");
                }
                break;
            }
            case "H6":  
            {
                for(int i = 7; i <= 8; i++){
                    possiblem.add("H" + i);
                }
                for(int i = 1; i <= 5; i++){
                    possiblem.add("H" + i);
                }
                for(char a = 'A'; a <= 'G'; a++){
                    possiblem.add(a + "6");
                }
                break;
            }
            case "H7":  
            {
                for(int i = 1; i <= 6; i++){
                    possiblem.add("H" + i);
                }
                for(char a = 'A'; a <= 'G'; a++){
                    possiblem.add(a + "7");
                }
                possiblem.add("H8");
                break;
            }
            case "H8":  
            {   
                for(int i = 1; i <= 7; i++){
                    possiblem.add("H" + i);
                }
                for(char a = 'A'; a <= 'G'; a++){
                    possiblem.add(a + "8");
                }
                break;
            }
        }
        
        moves ++;
        return possiblem;
    }
    
}
