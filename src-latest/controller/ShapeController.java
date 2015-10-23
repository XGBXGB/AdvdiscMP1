/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.ArrayList;

import model.Observer;
import model.Subject;
import model.graphic_objects.GraphicObject;
import model.graphic_objects.Parabola;


/**
 *
 * @author Christian Gabriel
 */
public class ShapeController implements Subject{
    private GraphicObject Shape;
    private static ShapeController instance = null;
    private ArrayList<Observer> observerList;
    
    public ShapeController(){
        observerList = new ArrayList();
    }
    
    public void addPoints(double x, double y){
        Shape.addPoint(x, y);
        notifyObservers();
    }
    
    public static ShapeController getInstance(){
        if(instance == null)
            instance = new ShapeController();
        return instance;
    }
    
    public void setShape(GraphicObject s){
        Shape = s;
        notifyObservers();
    }
    
    public GraphicObject getShape(){
        return Shape;
    }
    
    public void rotateShape(float angle, double centerX, double centerY, boolean clockwise){
        Shape.rotateShape(angle, centerX, centerY, clockwise);
        notifyObservers();
    }
    
    public void translateShape(double x, double y){
        Shape.translateShape(x, y);
        notifyObservers();
    }
    
    public void scaleShape(double x, double y){
    	Shape.scaleShape(x, y);
    	notifyObservers();
    }
    
    @Override
    public void registerObserver(Observer o) {
        o.update();
        observerList.add(o);
    }

    @Override
    public void unRegisterObserver(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObservers() {//clears graph and repaints from Model
        for(Observer o: observerList){
            o.update();
        }
    }
    
}
