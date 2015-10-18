/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.ArrayList;
import model.Model;
import model.Observer;
import model.Point;
import model.Subject;
import model.shape.Shape;

/**
 *
 * @author Christian Gabriel
 */
public class ModelController implements Subject{
    private Model model;
    private static ModelController instance = null;
    private ArrayList<Observer> observerList;
    
    public ModelController(){
        model = new Model();
        observerList = new ArrayList();
    }
    
    public static ModelController getInstance(){
        if(instance == null)
            instance = new ModelController();
        return instance;
    }
    
    public void setShape(Shape s){
        model.setShape(s);
    }
    
    public Shape getShape(Shape s){
        return model.getShape();
    }
    
    public void rotateShape(float angle, double centerX, double centerY, boolean clockwise){
        model.rotateShape(angle, centerX, centerY, clockwise);
        notifyObservers();
    }
    
    public void translateShape(double x, double y){
        model.translateShape(x, y);
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
    public void notifyObservers() {//clears graph and repaints from model
        for(Observer o: observerList){
            o.update();
        }
    }
    
}
