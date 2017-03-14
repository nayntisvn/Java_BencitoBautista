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
 *///
public class KnightPiece {
    int moves = 0;
    String location = null;
    String race = null;
    ArrayList<String> possiblem = new ArrayList<>();
    
    public KnightPiece(String race, String loc) 
    {
        this.race = race;
        this.location = loc;
    }
    
    public ArrayList<String> movement(){
        possiblem.clear();
        //char[] ordinate = {'0','0'};

        switch(location){
            case "A1":  {
                        possiblem.add("B3");
                        possiblem.add("C2");
                        break;
                        }
            case "A2":  {
                        possiblem.add("B4");
                        possiblem.add("C3");
                        possiblem.add("C1");
                        break;
                        }
            case "A3":  {
                        possiblem.add("B5");
                        possiblem.add("C4");
                        possiblem.add("B1");
                        possiblem.add("C2");
                        break;
                        }
            case "A4":  {
                        possiblem.add("B6");
                        possiblem.add("C5");
                        possiblem.add("B2");
                        possiblem.add("C3");
                        break;
                        }
            case "A5":  {
                        possiblem.add("B7");
                        possiblem.add("C6");
                        possiblem.add("C4");
                        possiblem.add("B3");
                        break;
                        }
            case "A6":  {
                        possiblem.add("B8");
                        possiblem.add("C7");
                        possiblem.add("C5");
                        possiblem.add("B4");
                        break;
                        }
            case "A7":  {
                        possiblem.add("C8");
                        possiblem.add("C6");
                        possiblem.add("B5");
                        break;
                        }
            case "A8":  {
                        possiblem.add("C7");
                        possiblem.add("B6");
                        break;
                        }
            case "B1":  {
                        possiblem.add("C3");
                        possiblem.add("D2");
                        possiblem.add("A3");
                        break;
                        }
            case "B2":  {
                        possiblem.add("C4");
                        possiblem.add("D3");
                        possiblem.add("A4");
                        possiblem.add("D1");
                        break;
                        }
            case "B3":  {
                        possiblem.add("C5");
                        possiblem.add("D4");
                        possiblem.add("A5");
                        possiblem.add("D2");
                        possiblem.add("C1");
                        possiblem.add("A1");
                        break;
                        }
            case "B4":  {
                        possiblem.add("C6");
                        possiblem.add("D5");
                        possiblem.add("A6");
                        possiblem.add("D3");
                        possiblem.add("C2");
                        possiblem.add("A2");
                        break;
                        }
            case "B5":  {
                        possiblem.add("C7");
                        possiblem.add("D6");
                        possiblem.add("A7");
                        possiblem.add("D4");
                        possiblem.add("A3");
                        possiblem.add("C3");
                        break;
                        }
            case "B6":  {
                        possiblem.add("C8");
                        possiblem.add("D7");
                        possiblem.add("A8");
                        possiblem.add("D5");
                        possiblem.add("A4");
                        possiblem.add("C4");
                        break;
                        }
            case "B7":  {
                        possiblem.add("D6");
                        possiblem.add("D8");
                        possiblem.add("A5");
                        possiblem.add("C5");
                        break;
                        }
            case "B8":  {
                        possiblem.add("D7");
                        possiblem.add("C6");
                        possiblem.add("A6");
                        break;
                        }
            case "C1":  {
                        possiblem.add("A2");
                        possiblem.add("E2");
                        possiblem.add("D3");
                        possiblem.add("B3");
                        break;
                        }
            case "C2":  {
                        possiblem.add("A3");
                        possiblem.add("E3");
                        possiblem.add("D4");
                        possiblem.add("B4");
                        possiblem.add("E1");
                        possiblem.add("A1");
                        break;
                        }
            case "C3":  {
                        possiblem.add("A4");
                        possiblem.add("E4");
                        possiblem.add("D5");
                        possiblem.add("B5");
                        possiblem.add("E2");
                        possiblem.add("A2");
                        possiblem.add("D1");
                        possiblem.add("B1");
                        break;
                        }
            case "C4":  {
                        possiblem.add("A5");
                        possiblem.add("E5");
                        possiblem.add("D6");
                        possiblem.add("B6");
                        possiblem.add("E3");
                        possiblem.add("A3");
                        possiblem.add("D2");
                        possiblem.add("B2");
                        break;
                        }
            case "C5":  {
                        possiblem.add("A6");
                        possiblem.add("E6");
                        possiblem.add("D7");
                        possiblem.add("B7");
                        possiblem.add("E4");
                        possiblem.add("A4");
                        possiblem.add("D3");
                        possiblem.add("B3");
                        break;
                        }
            case "C6":  {
                        possiblem.add("A7");
                        possiblem.add("E7");
                        possiblem.add("D8");
                        possiblem.add("B8");
                        possiblem.add("E5");
                        possiblem.add("A5");
                        possiblem.add("D4");
                        possiblem.add("B4");
                        break;
                        }
            case "C7":  {
                        possiblem.add("A8");
                        possiblem.add("E8");
                        possiblem.add("E6");
                        possiblem.add("A6");
                        possiblem.add("D5");
                        possiblem.add("B5");
                        break;
                        }
            case "C8":  {
                        possiblem.add("E7");
                        possiblem.add("A7");
                        possiblem.add("D6");
                        possiblem.add("B6");
                        break;
                        }
            case "D1":  {
                        possiblem.add("B2");
                        possiblem.add("F2");
                        possiblem.add("E3");
                        possiblem.add("C3");
                        break;
                        }
            case "D2":  {
                        possiblem.add("B3");
                        possiblem.add("F3");
                        possiblem.add("E4");
                        possiblem.add("C4");
                        possiblem.add("F1");
                        possiblem.add("B1");
                        break;
                        }
            case "D3":  {
                        possiblem.add("B4");
                        possiblem.add("F4");
                        possiblem.add("E5");
                        possiblem.add("C5");
                        possiblem.add("F2");
                        possiblem.add("B2");
                        possiblem.add("E1");
                        possiblem.add("C1");
                        break;
                        }
            case "D4":  {
                        possiblem.add("B5");
                        possiblem.add("F5");
                        possiblem.add("E6");
                        possiblem.add("C6");
                        possiblem.add("F3");
                        possiblem.add("B3");
                        possiblem.add("E2");
                        possiblem.add("C2");
                        break;
                        }
            case "D5":  {
                        possiblem.add("B6");
                        possiblem.add("F6");
                        possiblem.add("E7");
                        possiblem.add("C7");
                        possiblem.add("F4");
                        possiblem.add("B4");
                        possiblem.add("E3");
                        possiblem.add("C3");
                        break;
                        }
            case "D6":  {
                        possiblem.add("B7");
                        possiblem.add("F7");
                        possiblem.add("C8");
                        possiblem.add("B7");
                        possiblem.add("F7");
                        possiblem.add("F5");
                        possiblem.add("B5");
                        possiblem.add("C4");
                        possiblem.add("E4");
                        break;
                        }
            case "D7":  {
                        possiblem.add("B8");
                        possiblem.add("F8");
                        possiblem.add("F6");
                        possiblem.add("B6");
                        possiblem.add("E5");
                        possiblem.add("C5");
                        break;
                        }
            case "D8":  {
                        possiblem.add("F7");
                        possiblem.add("B7");
                        possiblem.add("E6");
                        possiblem.add("C6");
                        break;
                        }
            case "E1":  {
                        possiblem.add("C2");
                        possiblem.add("G2");
                        possiblem.add("F3");
                        possiblem.add("D3");
                        break;
                        }
            case "E2":  {
                        possiblem.add("C3");
                        possiblem.add("G3");
                        possiblem.add("F4");
                        possiblem.add("D4");
                        possiblem.add("G1");
                        possiblem.add("C1");
                        break;
                        }
            case "E3":  {
                        possiblem.add("C4");
                        possiblem.add("G4");
                        possiblem.add("F5");
                        possiblem.add("D5");
                        possiblem.add("G2");
                        possiblem.add("C2");
                        possiblem.add("F1");
                        possiblem.add("D1");
                        break;
                        }
            case "E4":  {
                        possiblem.add("C5");
                        possiblem.add("G5");
                        possiblem.add("F6");
                        possiblem.add("D6");
                        possiblem.add("G3");
                        possiblem.add("C3");
                        possiblem.add("F2");
                        possiblem.add("D2");
                        break;
                        }
            case "E5":  {
                        possiblem.add("C6");
                        possiblem.add("G6");
                        possiblem.add("F7");
                        possiblem.add("D7");
                        possiblem.add("G4");
                        possiblem.add("C4");
                        possiblem.add("F3");
                        possiblem.add("D3");
                        break;
                        }
            case "E6":  {
                        possiblem.add("C7");
                        possiblem.add("G7");
                        possiblem.add("F8");
                        possiblem.add("D8");
                        possiblem.add("G5");
                        possiblem.add("C5");
                        possiblem.add("D4");
                        possiblem.add("F4");
                        break;
                        }
            case "E7":  {
                        possiblem.add("C8");
                        possiblem.add("G8");
                        possiblem.add("G6");
                        possiblem.add("C6");
                        possiblem.add("F5");
                        possiblem.add("D5");
                        break;
                        }
            case "E8":  {
                        possiblem.add("G7");
                        possiblem.add("C7");
                        possiblem.add("F6");
                        possiblem.add("D6");
                        break;
                        }
            case "F1":  {
                        possiblem.add("D2");
                        possiblem.add("H2");
                        possiblem.add("G3");
                        possiblem.add("E3");
                        break;
                        }
            case "F2":  {
                        possiblem.add("H3");
                        possiblem.add("D3");
                        possiblem.add("G4");
                        possiblem.add("E4");
                        possiblem.add("H1");
                        possiblem.add("D1");
                        break;
                        }
            case "F3":  {
                        possiblem.add("D4");
                        possiblem.add("H4");
                        possiblem.add("G5");
                        possiblem.add("E5");
                        possiblem.add("H2");
                        possiblem.add("D2");
                        possiblem.add("G1");
                        possiblem.add("E1");
                        break;
                        }
            case "F4":  {
                        possiblem.add("D5");
                        possiblem.add("H5");
                        possiblem.add("G6");
                        possiblem.add("E6");
                        possiblem.add("H3");
                        possiblem.add("D3");
                        possiblem.add("G2");
                        possiblem.add("E2");
                        break;
                        }
            case "F5":  {
                        possiblem.add("D6");
                        possiblem.add("H6");
                        possiblem.add("G7");
                        possiblem.add("E7");
                        possiblem.add("H4");
                        possiblem.add("D4");
                        possiblem.add("G3");
                        possiblem.add("E3");
                        break;
                        }
            case "F6":  {
                        possiblem.add("D7");
                        possiblem.add("H7");
                        possiblem.add("G8");
                        possiblem.add("E8");
                        possiblem.add("G4");
                        possiblem.add("D5");
                        possiblem.add("E4");
                        possiblem.add("H5");
                        break;
                        }
            case "F7":  {
                        possiblem.add("D8");
                        possiblem.add("H8");
                        possiblem.add("H6");
                        possiblem.add("D6");
                        possiblem.add("G5");
                        possiblem.add("E5");
                        break;
                        }
            case "F8":  {
                        possiblem.add("H7");
                        possiblem.add("D7");
                        possiblem.add("G6");
                        possiblem.add("E6");
                        break;
                        }
            case "G1":  {
                        possiblem.add("H3");
                        possiblem.add("E2");
                        possiblem.add("F3");
                        break;
                        }
            case "G2":  {
                        possiblem.add("H4");
                        possiblem.add("E3");
                        possiblem.add("F4");
                        possiblem.add("E1");
                        break;
                        }
            case "G3":  {
                        possiblem.add("H5");
                        possiblem.add("E4");
                        possiblem.add("F5");
                        possiblem.add("E2");
                        possiblem.add("H1");
                        possiblem.add("F1");
                        break;
                        }
            case "G4":  {
                        possiblem.add("H6");
                        possiblem.add("E5");
                        possiblem.add("F6");
                        possiblem.add("E3");
                        possiblem.add("H2");
                        possiblem.add("F2");
                        break;
                        }
            case "G5":  {
                        possiblem.add("H7");
                        possiblem.add("E6");
                        possiblem.add("F7");
                        possiblem.add("E4");
                        possiblem.add("F3");
                        possiblem.add("H3");
                        break;
                        }
            case "G6":  {
                        possiblem.add("H8");
                        possiblem.add("E7");
                        possiblem.add("F8");
                        possiblem.add("E5");
                        possiblem.add("F4");
                        possiblem.add("H4");
                        break;
                        }
            case "G7":  {
                        possiblem.add("E6");
                        possiblem.add("E8");
                        possiblem.add("F5");
                        possiblem.add("H5");
                        break;
                        }
            case "G8":  {
                        possiblem.add("E7");
                        possiblem.add("H6");
                        possiblem.add("F6");
                        break;
                        }
            case "H1":  {
                        possiblem.add("G3");
                        possiblem.add("F2");
                        break;
                        }
            case "H2":  {
                        possiblem.add("G4");
                        possiblem.add("F3");
                        possiblem.add("F1");
                        break;
                        }
            case "H3":  {
                        possiblem.add("G5");
                        possiblem.add("F4");
                        possiblem.add("G1");
                        possiblem.add("F2");
                        break;
                        }
            case "H4":  {
                        possiblem.add("G6");
                        possiblem.add("F5");
                        possiblem.add("G2");
                        possiblem.add("F3");
                        break;
                        }
            case "H5":  {
                        possiblem.add("G7");
                        possiblem.add("F6");
                        possiblem.add("F4");
                        possiblem.add("G3");
                        break;
                        }
            case "H6":  {
                        possiblem.add("G8");
                        possiblem.add("F7");
                        possiblem.add("F5");
                        possiblem.add("G4");
                        break;
                        }
            case "H7":  {
                        possiblem.add("F8");
                        possiblem.add("F6");
                        possiblem.add("G5");
                        break;
                        }
            case "H8":  {
                        possiblem.add("F7");
                        possiblem.add("G6");
                        break;
                        }
            }
        return possiblem;
    }
}
