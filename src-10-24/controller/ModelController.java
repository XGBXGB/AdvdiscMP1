/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.ArrayList;

import model.Model;
import model.Observer;
import model.Subject;
import model.graphic_objects.GraphicObject;

/**
 *
 * @author Christian Gabriel
 */
public class ModelController implements Subject{
    private Model Model;
    private static ModelController instance = null;
    private ArrayList<Observer> observerList;
    
    public ModelController(){
        Model = new Model();
        observerList = new ArrayList();
    }
    
    public static ModelController getInstance(){
        if(instance == null)
            instance = new ModelController();
        return instance;
    }
    
    public void setShape(GraphicObject s){
        Model.setShape(s);
    }
    
    public GraphicObject getShape(GraphicObject s){
        return Model.getShape();
    }
    
    public void rotateShape(float angle, double centerX, double centerY, boolean clockwise){
        Model.rotateShape(angle, centerX, centerY, clockwise);
        notifyObservers();
    }
    
    public void translateShape(double x, double y){
        Model.translateShape(x, y);
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
