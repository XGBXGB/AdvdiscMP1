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
public class MatrixFactory {
    public Matrix getMatrix(String type){
        if(type.equalsIgnoreCase("ROTATE"))
            return new RotateMatrix();
        else if(type.equalsIgnoreCase("TRANSLATE"))
            return new TranslateMatrix();
        else if(type.equalsIgnoreCase("POINT"))
            return new R3Matrix();
        else if(type.equalsIgnoreCase("SHEAR"))
        	return new ShearMatrix(); 
        else if(type.equalsIgnoreCase("SCALE"))
        	return new ScaleMatrix();
        return null;
    }
}
