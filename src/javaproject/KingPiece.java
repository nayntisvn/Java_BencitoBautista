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
public class KingPiece {
    
    int moves = 0;
    String location = null;
    String race = null;
    ArrayList<String> possiblem = new ArrayList<>();
    
    public KingPiece(String race, String loc) 
    {
        this.race = race;
        this.location = loc;
    }
    
     public ArrayList<String> movement()
     {
         switch(location)
         {
             case "A1" : 
             {
                 possiblem.add("B1");
                 possiblem.add("B2");
                 possiblem.add("A2");
                 break;
             }
             case "A2" : 
             {
                 possiblem.add("B1");
                 possiblem.add("B2");
                 possiblem.add("B3");
                 possiblem.add("A1");
                 possiblem.add("A3");
                 break;
             }
             case "A3" : 
             {
                 possiblem.add("B2");
                 possiblem.add("B3");
                 possiblem.add("B4");
                 possiblem.add("A2");
                 possiblem.add("A4");
                 break;
             }
             case "A4" : 
             {
                 possiblem.add("B3");
                 possiblem.add("B4");
                 possiblem.add("B5");
                 possiblem.add("A3");
                 possiblem.add("A5");
                 break;
             }
             case "A5" : 
             {
                 possiblem.add("B4");
                 possiblem.add("B5");
                 possiblem.add("B6");
                 possiblem.add("A4");
                 possiblem.add("A6");
                 break;
             }
             case "A6" : 
             {
                 possiblem.add("B5");
                 possiblem.add("B6");
                 possiblem.add("B7");
                 possiblem.add("A7");
                 possiblem.add("A5");
                 break;
             }
             case "A7" : 
             {
                 possiblem.add("B6");
                 possiblem.add("B7");
                 possiblem.add("B8");
                 possiblem.add("A6");
                 possiblem.add("A7");
                 break;
             }
             case "A8" : 
             {
                 possiblem.add("B8");
                 possiblem.add("B7");
                 possiblem.add("A7");
                 break;
             }
             ////// b
             case "B1" : 
             {
                 possiblem.add("B1");
                 possiblem.add("B2");
                 possiblem.add("A2");
                 break;
             }
             case "B2" : 
             {
                 possiblem.add("B1");
                 possiblem.add("B2");
                 possiblem.add("B3");
                 possiblem.add("A1");
                 possiblem.add("A3");
                 break;
             }
             case "B3" : 
             {
                 possiblem.add("B2");
                 possiblem.add("B3");
                 possiblem.add("B4");
                 possiblem.add("A2");
                 possiblem.add("A4");
                 break;
             }
             case "B4" : 
             {
                 possiblem.add("B3");
                 possiblem.add("B4");
                 possiblem.add("B5");
                 possiblem.add("A3");
                 possiblem.add("A5");
                 break;
             }
             case "B5" : 
             {
                 possiblem.add("B4");
                 possiblem.add("B5");
                 possiblem.add("B6");
                 possiblem.add("A4");
                 possiblem.add("A6");
                 break;
             }
             case "B6" : 
             {
                 possiblem.add("B5");
                 possiblem.add("B6");
                 possiblem.add("B7");
                 possiblem.add("A7");
                 possiblem.add("A5");
                 break;
             }
             case "B7" : 
             {
                 possiblem.add("B6");
                 possiblem.add("B7");
                 possiblem.add("B8");
                 possiblem.add("A6");
                 possiblem.add("A7");
                 break;
             }
             case "B8" : 
             {
                 possiblem.add("C");
                 case "A1" : 
             {
                 possiblem.add("B1");
                 possiblem.add("B2");
                 possiblem.add("A2");
                 break;
             }
             case "A2" : 
             {
                 possiblem.add("B1");
                 possiblem.add("B2");
                 possiblem.add("B3");
                 possiblem.add("A1");
                 possiblem.add("A3");
                 break;
             }
             case "A3" : 
             {
                 possiblem.add("B2");
                 possiblem.add("B3");
                 possiblem.add("B4");
                 possiblem.add("A2");
                 possiblem.add("A4");
                 break;
             }
             case "A4" : 
             {
                 possiblem.add("B3");
                 possiblem.add("B4");
                 possiblem.add("B5");
                 possiblem.add("A3");
                 possiblem.add("A5");
                 break;
             }
             case "A5" : 
             {
                 possiblem.add("B4");
                 possiblem.add("B5");
                 possiblem.add("B6");
                 possiblem.add("A4");
                 possiblem.add("A6");
                 break;
             }
             case "A6" : 
             {
                 possiblem.add("B5");
                 possiblem.add("B6");
                 possiblem.add("B7");
                 possiblem.add("A7");
                 possiblem.add("A5");
                 break;
             }
             case "A7" : 
             {
                 possiblem.add("B6");
                 possiblem.add("B7");
                 possiblem.add("B8");
                 possiblem.add("A6");
                 possiblem.add("A7");
                 break;
             }
             case "A8" : 
             {
                 possiblem.add("B8");
                 possiblem.add("B7");
                 possiblem.add("A7");
                 break;
             }
                 break;
             }
             
             
         }
         
         
     }
}
