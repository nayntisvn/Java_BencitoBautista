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
public class BishopPiece {
    
    int moves;
    String location;
    String race;
    ArrayList<String> possiblem = new ArrayList<>();
    
    public BishopPiece(String race, String loc)
    {
        this.race = race;
        this.location = loc;
    }

    /**
     * @return the 
     */
    public ArrayList<String> movementW() {
        possiblem.clear();
        char[] charA = location.toCharArray();
        
        switch(charA[0]){
            case 'A':   
            {
                switch(charA[1]){
                    case '1':{
                        possiblem.add("B2");
                        possiblem.add("C3");
                        possiblem.add("D4");
                        possiblem.add("E5");
                        possiblem.add("F6");
                        possiblem.add("G7");
                        possiblem.add("H8");
                        break;
                }
                    case '2':{
                        possiblem.add("B3");
                        possiblem.add("C4");
                        possiblem.add("D5");
                        possiblem.add("E6");
                        possiblem.add("F7");
                        possiblem.add("G8");
                        possiblem.add("B1");
                        break;
                }
                    case '3':{
                        possiblem.add("B4");
                        possiblem.add("C5");
                        possiblem.add("D6");
                        possiblem.add("E7");
                        possiblem.add("F8");
                        possiblem.add("B2");
                        possiblem.add("C1");
                        break;
                }
                    case '4':{
                        possiblem.add("B5");
                        possiblem.add("C6");
                        possiblem.add("D7");
                        possiblem.add("E8");
                        possiblem.add("B3");
                        possiblem.add("C2");
                        possiblem.add("D1");
                        break;
                }
                    case '5':{
                        possiblem.add("B6");
                        possiblem.add("C7");
                        possiblem.add("D8");
                        possiblem.add("B4");
                        possiblem.add("C3");
                        possiblem.add("D2");
                        possiblem.add("E1");
                        break;
                }
                    case '6':{
                        possiblem.add("B7");
                        possiblem.add("C8");
                        possiblem.add("B5");
                        possiblem.add("C4");
                        possiblem.add("D3");
                        possiblem.add("E2");
                        possiblem.add("F1");
                        break;
                }
                    case '7':{
                        possiblem.add("B8");
                        possiblem.add("B6");
                        possiblem.add("C5");
                        possiblem.add("D4");
                        possiblem.add("E3");
                        possiblem.add("F2");
                        possiblem.add("G1");
                        break;
                }
                    case '8':{
                        possiblem.add("B7");
                        possiblem.add("C6");
                        possiblem.add("D5");
                        possiblem.add("E4");
                        possiblem.add("F3");
                        possiblem.add("G2");
                        possiblem.add("H1");
                        break;
                }
            }
            }
            case 'B':{
                switch(charA[1]){
                    case '1':{
                        possiblem.add("C2");
                        possiblem.add("D3");
                        possiblem.add("E4");
                        possiblem.add("F5");
                        possiblem.add("G6");
                        possiblem.add("H7");
                        possiblem.add("A2");
                        break;
                }
                    case '2':{
                        possiblem.add("C3");
                        possiblem.add("D4");
                        possiblem.add("E5");
                        possiblem.add("F6");
                        possiblem.add("G7");
                        possiblem.add("H8");
                        possiblem.add("A1");
                        break;
                }
                    case '3':{
                        possiblem.add("C4");
                        possiblem.add("D5");
                        possiblem.add("E6");
                        possiblem.add("F7");
                        possiblem.add("G8");
                        possiblem.add("C2");
                        possiblem.add("D2");
                        possiblem.add("A2");
                        break;
                }
                    case '4':{
                        possiblem.add("C5");
                        possiblem.add("D6");
                        possiblem.add("E7");
                        possiblem.add("F8");
                        possiblem.add("A3");
                        possiblem.add("C3");
                        possiblem.add("D2");
                        possiblem.add("E1");
                        break;
                }
                    case '5':{
                        possiblem.add("C6");
                        possiblem.add("D7");
                        possiblem.add("E8");
                        possiblem.add("C4");
                        possiblem.add("D3");
                        possiblem.add("E2");
                        possiblem.add("F1");
                        possiblem.add("A4");
                        break;
                }
                    case '6':{
                        possiblem.add("C7");
                        possiblem.add("D8");
                        possiblem.add("C5");
                        possiblem.add("D4");
                        possiblem.add("E3");
                        possiblem.add("F2");
                        possiblem.add("G1");
                        possiblem.add("A5");
                        break;
                }
                    case '7':{
                        possiblem.add("C8");
                        possiblem.add("C6");
                        possiblem.add("D5");
                        possiblem.add("E4");
                        possiblem.add("F3");
                        possiblem.add("G2");
                        possiblem.add("H1");
                        possiblem.add("A6");
                        break;
                }
                    case '8':{
                        possiblem.add("C7");
                        possiblem.add("D6");
                        possiblem.add("E5");
                        possiblem.add("F4");
                        possiblem.add("G3");
                        possiblem.add("H2");
                        possiblem.add("A7");
                        break;
                }
            }
            }
            case 'C': {
                switch(charA[1]){
                    case '1':{
                        possiblem.add("D2");
                        possiblem.add("E3");
                        possiblem.add("F4");
                        possiblem.add("G5");
                        possiblem.add("H6");
                        possiblem.add("B2");
                        possiblem.add("A3");
                        break;
                    }
                    case '2':{
                        possiblem.add("D3");
                        possiblem.add("E4");
                        possiblem.add("F5");
                        possiblem.add("G6");
                        possiblem.add("H7");
                        possiblem.add("B1");
                        possiblem.add("D1");
                        possiblem.add("B3");
                        possiblem.add("A4");
                        break;
                    }
                    case '3':{
                        possiblem.add("D4");
                        possiblem.add("E5");
                        possiblem.add("F6");
                        possiblem.add("G7");
                        possiblem.add("H8");
                        possiblem.add("D2");
                        possiblem.add("E1");
                        possiblem.add("B2");
                        possiblem.add("A1");
                        possiblem.add("B4");
                        possiblem.add("A5");
                        break;
                    }
                    case '4':{
                        possiblem.add("D5");
                        possiblem.add("E6");
                        possiblem.add("F7");
                        possiblem.add("G8");
                        possiblem.add("D3");
                        possiblem.add("E2");
                        possiblem.add("F1");
                        possiblem.add("B3");
                        possiblem.add("A2");
                        possiblem.add("B5");
                        possiblem.add("A6");
                        break;
                    }
                    case '5':{
                        possiblem.add("D6");
                        possiblem.add("E7");
                        possiblem.add("F8");
                        possiblem.add("G4");
                        possiblem.add("H3");
                        possiblem.add("D4");
                        possiblem.add("E3");
                        possiblem.add("F2");
                        possiblem.add("G1");
                        possiblem.add("B4");
                        possiblem.add("A3");
                        possiblem.add("B6");
                        possiblem.add("A7");                        
                        break;
                    }
                    case '6':{
                        possiblem.add("D7");
                        possiblem.add("E8");
                        possiblem.add("D5");
                        possiblem.add("E4");
                        possiblem.add("F3");
                        possiblem.add("G2");
                        possiblem.add("H1");
                        possiblem.add("B7");
                        possiblem.add("A8");
                        possiblem.add("B5");
                        possiblem.add("A4");
                        break;
                    }
                    case '7':{
                        possiblem.add("D8");
                        possiblem.add("D6");
                        possiblem.add("E5");
                        possiblem.add("F4");
                        possiblem.add("G3");
                        possiblem.add("H2");
                        possiblem.add("B8");
                        possiblem.add("D8");
                        possiblem.add("B6");
                        possiblem.add("A5");
                        break;
                    }
                    case '8':{
                        possiblem.add("D7");
                        possiblem.add("E6");
                        possiblem.add("F5");
                        possiblem.add("G4");
                        possiblem.add("H3");
                        possiblem.add("B7");
                        possiblem.add("A6");
                        break;
                    }
            }
            }
            case 'D':{
            switch(charA[1]){
                    case '1':{
                        possiblem.add("E2");
                        possiblem.add("F3");
                        possiblem.add("G4");
                        possiblem.add("H5");
                        possiblem.add("C2");
                        possiblem.add("B3");
                        possiblem.add("A4");
                        break;
                    }
                    case '2':{
                        possiblem.add("E3");
                        possiblem.add("F4");
                        possiblem.add("G5");
                        possiblem.add("H6");
                        possiblem.add("C3");
                        possiblem.add("B4");
                        possiblem.add("A5");
                        possiblem.add("C1");
                        possiblem.add("E1");
                        break;
                    }
                    case '3':{
                        possiblem.add("E4");
                        possiblem.add("F5");
                        possiblem.add("G6");
                        possiblem.add("H7");
                        possiblem.add("E2");
                        possiblem.add("F1");
                        possiblem.add("C2");
                        possiblem.add("B1");
                        possiblem.add("C4");
                        possiblem.add("B5");
                        possiblem.add("A6");
                        break;
                    }
                    case '4':{
                        possiblem.add("E5");
                        possiblem.add("F6");
                        possiblem.add("G7");
                        possiblem.add("H8");
                        possiblem.add("E3");
                        possiblem.add("F2");
                        possiblem.add("G1");
                        possiblem.add("C3");
                        possiblem.add("B2");
                        possiblem.add("A1");
                        possiblem.add("C5");
                        possiblem.add("B6");
                        possiblem.add("A7");

                        break;
                    }
                    case '5':{
                        possiblem.add("E6");
                        possiblem.add("F7");
                        possiblem.add("G8");
                        possiblem.add("E4");
                        possiblem.add("F3");
                        possiblem.add("G2");
                        possiblem.add("H1");
                        possiblem.add("C4");
                        possiblem.add("B3");
                        possiblem.add("A2");
                        possiblem.add("C6");
                        possiblem.add("B7");
                        possiblem.add("A8");                        
                        break;
                    }
                    case '6':{
                        possiblem.add("E7");
                        possiblem.add("F8");
                        possiblem.add("E5");
                        possiblem.add("F4");
                        possiblem.add("G3");
                        possiblem.add("H2");
                        possiblem.add("C5");
                        possiblem.add("B4");
                        possiblem.add("A3");
                        possiblem.add("C7");
                        possiblem.add("B8");
                        break;
                    }
                    case '7':{
                        possiblem.add("E8");
                        possiblem.add("E6");
                        possiblem.add("F5");
                        possiblem.add("G4");
                        possiblem.add("H3");
                        possiblem.add("C6");
                        possiblem.add("B5");
                        possiblem.add("A4");
                        possiblem.add("C8");
                        break;
                    }
                    case '8':{
                        possiblem.add("E7");
                        possiblem.add("F6");
                        possiblem.add("G5");
                        possiblem.add("H4");
                        possiblem.add("C7");
                        possiblem.add("B6");
                        possiblem.add("A5");
                        break;
                    }
            }
            }
            case 'E':{
            switch(charA[1]){
                    case '1':{
                        possiblem.add("F2");
                        possiblem.add("G3");
                        possiblem.add("H4");
                        possiblem.add("D2");
                        possiblem.add("C3");
                        possiblem.add("B4");
                        possiblem.add("A5");
                        break;
                    }
                    case '2':{
                        possiblem.add("F3");
                        possiblem.add("G4");
                        possiblem.add("H5");
                        possiblem.add("D3");
                        possiblem.add("C4");
                        possiblem.add("B5");
                        possiblem.add("A6");
                        possiblem.add("F1");
                        possiblem.add("D1");
                        break;
                    }
                    case '3':{
                        possiblem.add("F4");
                        possiblem.add("G5");
                        possiblem.add("H6");
                        possiblem.add("F2");
                        possiblem.add("G1");
                        possiblem.add("D2");
                        possiblem.add("C1");
                        possiblem.add("D4");
                        possiblem.add("C5");
                        possiblem.add("B6");
                        possiblem.add("A7");
                        break;
                    }
                    case '4':{
                        possiblem.add("F5");
                        possiblem.add("G6");
                        possiblem.add("H7");
                        possiblem.add("F3");
                        possiblem.add("G2");
                        possiblem.add("H1");
                        possiblem.add("D3");
                        possiblem.add("C2");
                        possiblem.add("B1");
                        possiblem.add("D5");
                        possiblem.add("C6");
                        possiblem.add("B7");
                        possiblem.add("A8");

                        break;
                    }
                    case '5':{
                        possiblem.add("F6");
                        possiblem.add("G7");
                        possiblem.add("H8");
                        possiblem.add("F4");
                        possiblem.add("G3");
                        possiblem.add("H2");
                        possiblem.add("D6");
                        possiblem.add("C7");
                        possiblem.add("B8");
                        possiblem.add("D4");
                        possiblem.add("C3");
                        possiblem.add("B2");
                        possiblem.add("A1");
                        
                        break;
                    }
                    case '6':{
                        possiblem.add("F7");
                        possiblem.add("G8");
                        possiblem.add("F5");
                        possiblem.add("G4");
                        possiblem.add("H3");
                        possiblem.add("D5");
                        possiblem.add("C4");
                        possiblem.add("B3");
                        possiblem.add("A2");
                        possiblem.add("D7");
                        possiblem.add("C8");
                        break;
                    }
                    case '7':{
                        possiblem.add("F8");
                        possiblem.add("F6");
                        possiblem.add("G5");
                        possiblem.add("H4");
                        possiblem.add("A3");
                        possiblem.add("D6");
                        possiblem.add("C5");
                        possiblem.add("B4");
                        possiblem.add("D8");
                        break;
                    }
                    case '8':{
                        possiblem.add("F7");
                        possiblem.add("G6");
                        possiblem.add("H5");
                        possiblem.add("D7");
                        possiblem.add("C6");
                        possiblem.add("B5");
                        possiblem.add("A4");
                        break;
                    }
            }
            }
            case 'F':{
                switch(charA[1]){
                    case '1':{
                        possiblem.add("G2");
                        possiblem.add("H3");
                        possiblem.add("E2");
                        possiblem.add("D3");
                        possiblem.add("C4");
                        possiblem.add("B5");
                        possiblem.add("A6");
                        break;
                    }
                    case '2':{
                        possiblem.add("G3");
                        possiblem.add("H4");
                        possiblem.add("E3");
                        possiblem.add("D4");
                        possiblem.add("C5");
                        possiblem.add("B6");
                        possiblem.add("A7");
                        possiblem.add("E1");
                        possiblem.add("G1");
                        break;
                    }
                    case '3':{
                        possiblem.add("G4");
                        possiblem.add("H5");
                        possiblem.add("E4");
                        possiblem.add("D5");
                        possiblem.add("C6");
                        possiblem.add("B7");
                        possiblem.add("A8");
                        possiblem.add("E2");
                        possiblem.add("D1");
                        possiblem.add("G2");
                        possiblem.add("H1");
                        break;
                    }
                    case '4':{
                        possiblem.add("G5");
                        possiblem.add("H6");
                        possiblem.add("E5");
                        possiblem.add("D6");
                        possiblem.add("C7");
                        possiblem.add("B8");
                        possiblem.add("E3");
                        possiblem.add("D2");
                        possiblem.add("C1");
                        possiblem.add("G3");
                        possiblem.add("H2");
                        break;
                    }
                    case '5':{
                        possiblem.add("G6");
                        possiblem.add("G7");
                        possiblem.add("E6");
                        possiblem.add("D7");
                        possiblem.add("C8");
                        possiblem.add("E4");
                        possiblem.add("D3");
                        possiblem.add("C2");
                        possiblem.add("B1");
                        possiblem.add("G4");
                        possiblem.add("H3");
                        break;
                    }
                    case '6':{
                        possiblem.add("G7");
                        possiblem.add("H8");
                        possiblem.add("E7");
                        possiblem.add("D8");
                        possiblem.add("G5");
                        possiblem.add("H4");
                        possiblem.add("E5");
                        possiblem.add("D4");
                        possiblem.add("C3");
                        possiblem.add("B2");
                        possiblem.add("A1");
                        break;
                    }
                    case '7':{
                        possiblem.add("G8");
                        possiblem.add("G6");
                        possiblem.add("H5");
                        possiblem.add("E8");
                        possiblem.add("E6");
                        possiblem.add("D5");
                        possiblem.add("C4");
                        possiblem.add("B3");
                        possiblem.add("A2");
                        break;
                    }
                    case '8':{
                        possiblem.add("G7");
                        possiblem.add("H6");
                        possiblem.add("E7");
                        possiblem.add("D6");
                        possiblem.add("C5");
                        possiblem.add("B4");
                        possiblem.add("A3");
                        break;
                    }
            }  
            }
            case 'G':{
                switch(charA[1]){
                    case '1':{
                        possiblem.add("H2");
                        possiblem.add("F2");
                        possiblem.add("E3");
                        possiblem.add("D4");
                        possiblem.add("C5");
                        possiblem.add("B6");
                        possiblem.add("A7");
                        break;
                    }
                    case '2':{
                        possiblem.add("H3");
                        possiblem.add("F3");
                        possiblem.add("E4");
                        possiblem.add("D5");
                        possiblem.add("C6");
                        possiblem.add("B7");
                        possiblem.add("A8");
                        possiblem.add("F1");
                        possiblem.add("H1");
                        break;
                    }
                    case '3':{
                        possiblem.add("H4");
                        possiblem.add("F4");
                        possiblem.add("E5");
                        possiblem.add("D6");
                        possiblem.add("C7");
                        possiblem.add("B8");
                        possiblem.add("F2");
                        possiblem.add("E1");
                        possiblem.add("H2");
                        break;
                    }
                    case '4':{
                        possiblem.add("H5");
                        possiblem.add("F6");
                        possiblem.add("E7");
                        possiblem.add("D8");
                        possiblem.add("H4");
                        possiblem.add("F4");
                        possiblem.add("E3");
                        possiblem.add("D2");
                        possiblem.add("C1");
                        break;
                    }
                    case '5':{
                        possiblem.add("H6");
                        possiblem.add("H4");
                        possiblem.add("F6");
                        possiblem.add("E7");
                        possiblem.add("D8");
                        possiblem.add("F4");
                        possiblem.add("E3");
                        possiblem.add("D2");
                        possiblem.add("C1");
                        break;
                    }
                    case '6':{
                        possiblem.add("H7");
                        possiblem.add("H5");
                        possiblem.add("F7");
                        possiblem.add("G8");
                        possiblem.add("F5");
                        possiblem.add("E4");
                        possiblem.add("D3");
                        possiblem.add("C2");
                        possiblem.add("B1");
                        possiblem.add("E8");
                        break;
                    }
                    case '7':{
                        possiblem.add("H8");
                        possiblem.add("H6");
                        possiblem.add("F6");
                        possiblem.add("E5");
                        possiblem.add("D4");
                        possiblem.add("C3");
                        possiblem.add("B2");
                        possiblem.add("A1");
                        possiblem.add("F8");
                        break;
                    }
                    case '8':{
                        possiblem.add("H7");
                        possiblem.add("F7");
                        possiblem.add("E6");
                        possiblem.add("D5");
                        possiblem.add("C4");
                        possiblem.add("B3");
                        possiblem.add("A2");
                        break;
                    }
            }
            }
            case 'H':{
                switch(charA[1]){
                    case '1':{
                        possiblem.add("G2");
                        possiblem.add("F3");
                        possiblem.add("E4");
                        possiblem.add("D5");
                        possiblem.add("C6");
                        possiblem.add("B7");
                        possiblem.add("A8");
                        break;
                    }
                    case '2':{
                        possiblem.add("G3");
                        possiblem.add("F4");
                        possiblem.add("E5");
                        possiblem.add("D6");
                        possiblem.add("C7");
                        possiblem.add("B8");
                        possiblem.add("G1");
                        break;
                    }
                    case '3':{
                        possiblem.add("G4");
                        possiblem.add("F5");
                        possiblem.add("E6");
                        possiblem.add("D7");
                        possiblem.add("C8");
                        possiblem.add("G2");
                        possiblem.add("F1");
                        break;
                    }
                    case '4':{
                        possiblem.add("G5");
                        possiblem.add("F6");
                        possiblem.add("E7");
                        possiblem.add("D8");
                        possiblem.add("G3");
                        possiblem.add("F2");
                        possiblem.add("E1");
                        break;
                    }
                    case '5':{
                        possiblem.add("G6");
                        possiblem.add("F7");
                        possiblem.add("E8");
                        possiblem.add("G4");
                        possiblem.add("F3");
                        possiblem.add("E2");
                        possiblem.add("D1");
                        break;
                    }
                    case '6':{
                        possiblem.add("G7");
                        possiblem.add("F8");
                        possiblem.add("G5");
                        possiblem.add("F4");
                        possiblem.add("E3");
                        possiblem.add("D2");
                        possiblem.add("C1");
                        break;
                    }
                    case '7':{
                        possiblem.add("G8");
                        possiblem.add("G6");
                        possiblem.add("F5");
                        possiblem.add("E4");
                        possiblem.add("D3");
                        possiblem.add("C2");
                        possiblem.add("B1");
                        break;
                    }
                    case '8':{
                        possiblem.add("G7");
                        possiblem.add("F6");
                        possiblem.add("E5");
                        possiblem.add("D4");
                        possiblem.add("C3");
                        possiblem.add("B2");
                        possiblem.add("A1");
                        break;
                    }
            }
            }
        }
        
        moves++;
        return possiblem;
    }

}
