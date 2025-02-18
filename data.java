/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labeler;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.HashMap;
import java.util.*;
import static java.util.Map.entry;
/**
 *
 * @author Reid
 */


public class data {
    int[] pings = {-1, -1};
    String current_location;
    
    public data(int[] p){
        pings = p;
        current_location = "default";
    }
    
    
    private final Map<String, String> map = Map.ofEntries(
        //Exit
        entry("2, 1", "Exit"),
        entry("3, 1", "Exit"),
        entry("4, 1", "Exit"),
        entry("5, 1", "Exit"),
        entry("6, 1", "Exit"),
        entry("7, 1", "Exit"),
        entry("8, 1", "Exit"),
        //Exit or Tractor Bay (11 is not a building exit)
        entry("10, 12", "Exit or Tractor Bay"),
        entry("11, 12", "Exit or Tractor Bay"),
        //Exit or room with 14
        entry("11, 14", "Exit or Tractor Bay"),
        entry("13, 14", "Exit or Tractor Bay"),
        //Second Floor
        entry("15, 17", "Upstairs"),
        entry("16, 17", "Upstairs"),
        //Room 10
        entry("8, 10", "10"),
        entry("9, 10", "10"),
        entry("11, 10", "10"),
        entry("12, 10", "10"),
        //Room 2-5
        entry("1, 2", "2-5"),
        entry("6, 2", "2-5"),
        entry("7, 2", "2-5"),
        entry("8, 2", "2-5"),
        entry("1, 3", "2-5"),
        entry("6, 3", "2-5"),
        entry("7, 3", "2-5"),
        entry("8, 3", "2-5"),
        entry("1, 4", "2-5"),
        entry("6, 4", "2-5"),
        entry("7, 4", "2-5"),
        entry("8, 4", "2-5"),
        entry("1, 5", "2-5"),
        entry("6, 5", "2-5"),
        entry("7, 5", "2-5"),
        entry("8, 5", "2-5"),
        //Room 2-5 or bottom
        entry("3, 2", "2-5 or bottom"),
        entry("4, 2", "2-5 or bottom"),
        entry("2, 3", "2-5 or bottom"),
        entry("4, 3", "2-5 or bottom"),
        entry("2, 4", "2-5 or bottom"),
        entry("3, 4", "2-5 or bottom"),
        entry("2, 5", "2-5 or bottom"),
        entry("3, 5", "2-5 or bottom"),
        entry("4, 5", "2-5 or bottom"),
        //7 and 8 (also 9 and 16) [pretty sure this one needs some work]
        entry("1, 7", "7-8"),
        entry("2, 7", "7-8"),
        entry("3, 7", "7-8"),
        entry("4, 7", "7-8"),
        entry("5, 7", "7-8"),
        entry("6, 7", "7-8"),
        entry("1, 8", "7-8"),
        entry("2, 8", "7-8"),
        entry("3, 8", "7-8"),
        entry("4, 8", "7-8"),
        entry("5, 8", "7-8"),
        entry("6, 8", "7-8"),
        entry("10, 8", "7-8"),
        entry("13, 9", "7-8"),
        entry("13, 16", "7-8"),
        //At this point the documentation becomes uncertain. Combinations are as is, names stop altogether.
        entry("10, 9", ""),
        entry("16, 16", ""),
        entry("17, 16", ""),
        //
        entry("9, 16", ""),
        //entry("13, 16", ""),
        //
        entry("16, 13", ""),
        //
        entry("7, 16", ""),
        //
        entry("17, 15", ""),
        //
        entry("15, 13", ""),
        entry("8, 9", ""),
        //
        entry("13, 15", ""),
        entry("16, 15", ""),
        //
        entry("11, 13", ""),
        entry("14, 13", "")
        //My understanding is that repeat pings are ignored. If I am incorrect on this, uncomment this section
        /**
         * entry("1, 1", "Exit or 1");
         * entry("6, 6", "Exit or 6");
         * entry("11, 11", "Exit or 11");
         * entry("12, 12", "Exit or 12");
         * entry("14, 14", "Exit or 14");
         * entry("2, 2", "2-5 or bottom");
         * entry("3, 3", "2-5 or bottom");
         * entry("4, 4", "2-5 or bottom");
         * entry("5, 5", "2-5 or bottom");
         */
        );
    
    private void setLocation(String s){
        current_location = s;
    }
    public String getLocation(){
        return current_location;
    }
    private void addPing(int p){
        //pings[2] = pings[1];
        pings[1] = pings[0];
        pings[0] = p;
    }
    public void label(){
        String key = pings[0] + ", " + pings[1];
        setLocation(map.get(key));
       
    }
}
