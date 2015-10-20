/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.matrix;


/**
 *
 * @author Christian Gabriel
 */
public class Matrix {
    protected final int M;   // number of rows
    protected final int N;   // number of columns
    protected  double[][] data;
    
    //initializes MxN matrix of 0's
    public Matrix(int M, int N) {
        this.M = M;
        this.N = N;
        data = new double[M][N];
    }
    
    public Matrix(Matrix m){
        this.M = m.M;
        this.N = m.N;
        this.data = m.data;
    }
    
    //initializes the matrix to an identity matrix
    public void makeIdentity() {
        for (int i = 0; i < N; i++){
            this.data[i][i] = 1;
        }
    }
    
    public double[][] times(Matrix B) {
        Matrix A = this;
        if (A.N != B.M) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C;
        C = new Matrix(A.M,B.N);
        for (int i = 0; i < C.M; i++)
            for (int j = 0; j < C.N; j++){
                for (int k = 0; k < A.N; k++){
                    C.data[i][j] += (A.data[i][k] * B.data[k][j]);
                }
            }
        
        return C.data;
    }
    
    public void setData(double[][] data){
        this.data = data;
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
