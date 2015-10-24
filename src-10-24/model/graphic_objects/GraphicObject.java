/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.graphic_objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;

import model.Point;
import model.matrix.Matrix;
import model.matrix.MatrixFactory;
import model.matrix.R3Matrix;
import model.matrix.ReflectMatrix;
import model.matrix.RotateMatrix;
import model.matrix.ScaleMatrix;
import model.matrix.ShearMatrix;
import model.matrix.TranslateMatrix;

/**
 *
 * @author Christian Gabriel
 */
public abstract class GraphicObject implements Cloneable {
	protected ArrayList<Point> points;
	protected Color c;
	
	public void addPoint(double x, double y) {
		points.add(new Point(x, y));
	}
	
	public void setColor(Color c){
		this.c = c;
	}
	
	public Color getColor(){
		return this.c;
	}
	
	public abstract GraphicObject clone();
	public Iterator<Point> getPoints() {
		return points.iterator();
	}

	public void setPoints(Iterator<Point> points) {
		this.points.clear();
		while (points.hasNext()) {
			Point p = points.next();
			this.points.add(p);
		}
	}

	public abstract void draw(Graphics2D g);
	
	public void reflect(boolean isXAxis) {

		MatrixFactory matrixFactory = new MatrixFactory();
		Matrix reflector = matrixFactory.getMatrix("REFLECT");
		Matrix pointHolder = matrixFactory.getMatrix("POINT");
		((ReflectMatrix) reflector).reflect(isXAxis);
//		reflector.printValues();
		for (int i = 0; i < points.size(); i++) {
			Point p = points.get(i);
			((R3Matrix) pointHolder).setPointValues(p.getX(), p.getY());
			pointHolder.setData(reflector.times(pointHolder));
			points.set(i, ((R3Matrix) pointHolder).getPoint());
		}
	}

	public void rotateShape(float angle, double centerX, double centerY, boolean clockwise) {
		Point center = new Point(centerX, centerY);
		MatrixFactory matrixFactory = new MatrixFactory();
		Matrix rotator = matrixFactory.getMatrix("ROTATE");
		Matrix translator = matrixFactory.getMatrix("TRANSLATE");
		Matrix pointHolder = matrixFactory.getMatrix("POINT");
		((RotateMatrix) rotator).makeRotator(angle, clockwise);
		for (int i = 0; i < points.size(); i++) {
			Point p = points.get(i);

			// Convert point to matrix
			((R3Matrix) pointHolder).setPointValues(p.getX(), p.getY());// insert
																		// point
																		// values
																		// to
																		// matrix

			// translate point near origin
			((TranslateMatrix) translator).setTranslateValues(-center.getX(), -center.getY());
			pointHolder.setData(translator.times(pointHolder));

			pointHolder.setData(rotator.times(pointHolder));// multiplies the
															// 3x1 matrix to the
															// rotator matrix

			// because we rotated based on (0,0), we bring it back to its
			// original position by translating
			((TranslateMatrix) translator).setTranslateValues(center.getX(), center.getY());
			pointHolder.setData(translator.times(pointHolder));

			points.set(i, ((R3Matrix) pointHolder).getPoint());
		}
	}

	public void shear(boolean isXAxis, double x) {
		MatrixFactory matrixFactory = new MatrixFactory();
		Matrix pointHolder = matrixFactory.getMatrix("POINT");
		Matrix translator = matrixFactory.getMatrix("TRANSLATE");
		Matrix shearer = matrixFactory.getMatrix("SHEAR");
		((ShearMatrix) shearer).shear(isXAxis, x);

		double nearest = distanceToAxis(isXAxis);
		for (int i = 0; i < points.size(); i++) {
			Point p = points.get(i);
			// Convert point to matrix
			((R3Matrix) pointHolder).setPointValues(p.getX(), p.getY());
			
			double X = ((R3Matrix) pointHolder).getPoint().getX();
			double Y = ((R3Matrix) pointHolder).getPoint().getY();

			// Translate near X or Y axis
			if (isXAxis) {
				if (X < 0) {
					((TranslateMatrix) translator).setTranslateValues(0, nearest);
				} else {
					((TranslateMatrix) translator).setTranslateValues(0, -nearest);
				}
			} else {
				if (Y < 0) {
					((TranslateMatrix) translator).setTranslateValues(nearest, 0);
				} else {
					((TranslateMatrix) translator).setTranslateValues(-nearest, 0);
				}
			}
			pointHolder.setData(translator.times(pointHolder));

			// Shear x units
			pointHolder.setData(shearer.times(pointHolder));

			// Translate back to original position
			if (isXAxis) {
				if (X < 0) {
					((TranslateMatrix) translator).setTranslateValues(0, -nearest);
				} else {
					((TranslateMatrix) translator).setTranslateValues(0, nearest);
				}
			} else {
				if (Y < 0) {
					((TranslateMatrix) translator).setTranslateValues(-nearest, 0);
				} else {
					((TranslateMatrix) translator).setTranslateValues(nearest, 0);
				}
			}
			pointHolder.setData(translator.times(pointHolder));

			points.set(i, ((R3Matrix) pointHolder).getPoint());
		}
	}

	private double distanceToAxis(boolean isXAxis) {
		Point p = points.get(0);

		for (int i = 0; i < points.size(); i++) {
			Point p1 = points.get(i);

			if (isXAxis) {
				double x = p.getX();
				double x1 = p1.getX();
				if (x < 0) {
					x = -x;
				}
				if (x1 < 0) {
					x1 = -x1;
				}
				if (x1 < x) {
					p = p1;
				}
			} else {
				double y = p.getX();
				double y1 = p1.getX();
				if (y < 0) {
					y = -y;
				}
				if (y1 < 0) {
					y1 = -y1;
				}
				if (y1 < y) {
					p = p1;
				}
			}
		}
		if (isXAxis)
			return p.getY();
		return p.getX();
	}

	public void translateShape(double x, double y) {

		 MatrixFactory matrixFactory = new MatrixFactory();
		 Matrix translator = matrixFactory.getMatrix("TRANSLATE"); 
		 Matrix pointHolder = matrixFactory.getMatrix("POINT"); ((TranslateMatrix)
		 translator).setTranslateValues(x, y);
		 
		 for (int i = 0; i < points.size(); i++) { 
			 Point p = points.get(i);
			 ((R3Matrix) pointHolder).setPointValues(p.getX(), p.getY());
			 pointHolder.setData(translator.times(pointHolder)); 
			 points.set(i,((R3Matrix) pointHolder).getPoint()); 
		}
		 
	}

	public void scaleShape(double scalingFactorX, double scalingFactorY) {
		MatrixFactory matrixFactory = new MatrixFactory();
		Matrix scalor = matrixFactory.getMatrix("SCALE");
		Matrix pointHolder = matrixFactory.getMatrix("POINT");
		((ScaleMatrix) scalor).setScalingFactor(scalingFactorX, scalingFactorY);

		
		for (int i = 0; i < points.size(); i++) {
			Point p = points.get(i);
			if (p.getX() != 0 && p.getY() != 0)
				((R3Matrix) pointHolder).setPointValues(p.getX(), p.getY());
			else if (p.getX() == 0 && p.getY() == 0)
				((R3Matrix) pointHolder).setPointValues(1, 1);
			else if (p.getX() == 0)
				((R3Matrix) pointHolder).setPointValues(1, p.getY());
			else if (p.getY() == 0)
				((R3Matrix) pointHolder).setPointValues(p.getX(), 1);

			pointHolder.setData(scalor.times(pointHolder));
			points.set(i, ((R3Matrix) pointHolder).getPoint());
		}
	}
	
	public String printMatrix(){
		String result = "";
		int ascii = 65;
		for(Point p: points){	
			result += String.format("%1s %c = "," ", ascii);
			result += String.format("[%-1s %.3f %.3f %1s]\n"," ",p.getX(),p.getY(), " ");
			ascii++;
		}
		return result;
	}
}
