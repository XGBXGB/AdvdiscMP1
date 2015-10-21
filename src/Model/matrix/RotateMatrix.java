/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.matrix;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 *
 * @author Christian Gabriel
 */
public class RotateMatrix extends Matrix{
    
    public RotateMatrix(){
        super(3,3);
    }
    
    public void makeRotator(float angle, boolean clockwise) {
       if(clockwise)
           angle = -angle;
        
       super.makeIdentity();
       data[0][0] = cos(Math.toRadians(angle));
       data[0][1] = -sin(Math.toRadians(angle));
       data[1][0] = sin(Math.toRadians(angle));
       data[1][1] = cos(Math.toRadians(angle));
    }
}
