/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.Color;
import java.util.ArrayList;

import model.Observer;
import model.Subject;
import model.graphic_objects.GraphicObject;
import model.graphic_objects.Parabola;


/**
 *
 * @author Christian Gabriel
 */
public class GraphicObjectController implements Subject{
    private GraphicObject orgObject,transObject;
    private static GraphicObjectController instance = null;
    private ArrayList<Observer> observerList;
    private String result = "";
    
    public GraphicObjectController(){
        observerList = new ArrayList<Observer>();
    }
    
    public static GraphicObjectController getInstance(){
        if(instance == null)
            instance = new GraphicObjectController();
        return instance;
    }
   
    public void addPoints(double x, double y){
        orgObject.addPoint(x, y);
        notifyObservers();
    }
    
    public void setOriginalObject(GraphicObject o){
    	orgObject = o;
    	orgObject.setColor(Color.BLUE);
    	notifyObservers();
    }
    
    public void setTransformedObject(GraphicObject o){
    	transObject = o;
    	transObject.setColor(Color.GREEN);
    	notifyObservers();
    }
    
    public void reflect(boolean isXAxis) {
		transObject.reflect(isXAxis);
    	notifyObservers();
	}
    
    public void revertToOriginal() {
    	setTransformedObject(orgObject.clone());
    	notifyObservers();
    }
    
    
    public GraphicObject getOriginalObject(){
        return orgObject;
    }
    
    public GraphicObject getTransformedObject(){
        return transObject;
    }
    
    public void rotateShape(float angle, double centerX, double centerY, boolean clockwise){
       	transObject.rotateShape(angle, centerX, centerY, clockwise);
        notifyObservers();
    }
    
    public void translateShape(double x, double y){
        transObject.translateShape(x, y);
        notifyObservers();
    }
    
    public void scaleShape(double x, double y){
    	transObject.scaleShape(x, y);
    	notifyObservers();
    }
    
    public String getMatrixLog(){
    	String s = "";
    	if(orgObject != null && transObject != null){
    		s = " BEFORE: \n";
        	s += orgObject.printMatrix();
        	s += " ------------------------------------------------------------\n";
        	s += " AFTER: \n";
        	s += transObject.printMatrix();
        	return s;
    	}
    	return s;
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
	public void shearShape(boolean isXAxis, double x) {
		// TODO Auto-generated method stub
		transObject.shear(isXAxis, x);
		notifyObservers();
	}
    
}
