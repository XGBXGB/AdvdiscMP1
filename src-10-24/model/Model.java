/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import model.graphic_objects.GraphicObject;

/**
 *
 * @author Christian Gabriel
 */
public class Model {
    private GraphicObject currShape=null;
    
    public void setShape(GraphicObject s){
        currShape = s;
    }
    
    public GraphicObject getShape(){
        return currShape;
    }
    
    public void rotateShape(float angle, double centerX, double centerY, boolean clockwise){
        currShape.rotateShape(angle, centerX, centerY, clockwise);
    }
    
    public void translateShape(double x, double y){
        currShape.translateShape(x, y);
    }
}
