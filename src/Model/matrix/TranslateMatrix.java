/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.matrix;

/**
 *
 * @author Christian Gabriel
 */
public class TranslateMatrix extends Matrix{
    
    public TranslateMatrix(){
        super(3,3);
    }
    
    public void setTranslateValues(double x, double y){
        super.makeIdentity();
        data[0][2]=x;
        data[1][2]=y;
    }
}
