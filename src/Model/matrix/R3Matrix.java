/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.matrix;

import Model.Point;

/**
 *
 * @author Christian Gabriel
 */
public class R3Matrix extends Matrix{
    
    public R3Matrix(){
        super(3,1);
    }
    
    public void setPointValues(double x, double y){
        data[0][0] = x;
        data[1][0] = y;
        data[2][0] = 1;
    }
    
    public Point getPoint(){
        return new Point(data[0][0],data[1][0]);
    }
    
}
