/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import java.util.ArrayList;
import Model.Grid;

/**
 *
 * @author Christian Gabriel
 */
public class Driver {
    public static void main(String[] args) {
        Grid xz = new Grid("Title",500,500,20,20);
        xz.drawLine(0, 0, 10, 0);
        xz.rotateLine(0, 0, 10, 0, 45);
    }
    
    
}
