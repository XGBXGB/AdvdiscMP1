/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import model.shape.Shape;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Christian Gabriel
 */
public final class Matrix {
    private final int M;   // number of rows
    private final int N;   // number of columns
    private final double[][] data;
    
    //initializes MxN matrix of 0's
    public Matrix(int M, int N) {
        this.M = M;
        this.N = N;
        data = new double[M][N];
    }
    
    //initializes the matrix to an identity matrix
    public void makeIdentity() {
        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                if((i==j))
                    this.data[i][j] = 1;
                else
                    this.data[i][j] = 0;
            }
        }
    }
    
    //initializes this matrix for rotation
    public void makeRotator(float angle) {
       makeIdentity();
       data[0][0] = cos(Math.toRadians(angle));
       System.out.println("Value of cos: "+data[0][0]);
       data[0][1] = -sin(Math.toRadians(angle));
       System.out.println("Value of -sine: "+data[0][1]);
       data[1][0] = sin(Math.toRadians(angle));
       System.out.println("Value of sine: "+data[1][0]);
       data[1][1] = cos(Math.toRadians(angle));
       System.out.println("Value of  cos: "+data[1][1]);
    }
    
    //Move x horizontally, y vertically
    public void makeTranslator(double x, double y){
        makeIdentity();
        data[0][2]=x;
        data[1][2]=y;
    }
    
    public void set3x1(double x, double y){
        if(M==3 && N==1){
            data[0][0]=x;
            data[1][0]=y;
            data[2][0]=1;
        }
    }
    
    public Point getXYW(){
        if(M==3 && N==1)
            return new Point(data[0][0],data[1][0]);
        else
            return null;
    }
    
    
    //performs rotation based on origin (0,0)
    public Shape rotateShape(Shape s, float angle, Point center, boolean clockwise){
        if(clockwise){//angle needs to be negative to rotate clockwise
            angle = -angle;
        }
        makeRotator(angle);
        Iterator<Point> original = s.getPoints();
        ArrayList<Point> newPoints = new ArrayList();
        
        while(original.hasNext()){
            Point p = original.next();
            
            Matrix pointHolder = new Matrix(3,1);//Convert point to matrix
            pointHolder.set3x1(p.getX()-center.getX(), p.getY()-center.getY());//insert point values to matrix
            pointHolder = this.times(pointHolder);//multiplies the 3x1 matrix to the rotator matrix
            
            Matrix translator = new Matrix(3,3);
            translator.makeTranslator(center.getX(), center.getY());
            
            //because we rotated based on (0,0), we bring it back to its original position
            //since the formula is based on rotating around the origin
            pointHolder = translator.times(pointHolder);
            
            //adds the new point
            newPoints.add(pointHolder.getXYW());
            
        }
        s.setPoints(newPoints.iterator());
        return s;
    }
    
    
    
    public Matrix times(Matrix B) {
        Matrix A = this;
        if (A.N != B.M) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(A.M, B.N);
        for (int i = 0; i < C.M; i++)
            for (int j = 0; j < C.N; j++){
                for (int k = 0; k < A.N; k++){
                    C.data[i][j] += (A.data[i][k] * B.data[k][j]);
                }
                
            }
        return C;
    }
    
    public void printValues(){
        System.out.println("START");
        for(int i=0;i<M;i++){
            System.out.printf("[");
            for(int k=0;k<N;k++)
                System.out.printf(" "+data[i][k]+" ");
            System.out.println("]");
        }
        System.out.println("END");
    }
}
