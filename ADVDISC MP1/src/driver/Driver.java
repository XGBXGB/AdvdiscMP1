/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

import java.util.ArrayList;

import view.Grid;


/**
 *
 * @author Christian Gabriel
 */
public class Driver {
    public static void main(String[] args) {
        Grid xz = new Grid("Title",500,500,20,20);
        xz.drawLine(1, 1, 2, 1);
        //xz.rotateLine(5, 2, 1, 2, 90);
        xz.translateLine(1, 1, 2, 1, 1, 2);
    }
    
    
}
