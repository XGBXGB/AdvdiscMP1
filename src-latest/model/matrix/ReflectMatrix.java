package model.matrix;


public class ReflectMatrix extends Matrix{

	 public ReflectMatrix(){
	        super(3,3);
	    }
	    
	    public void setScalingFactor(double scalingFactorX, double scalingFactorY)
	    {
	    	
	    	super.makeIdentity();
	    	data[0][0] = scalingFactorX;
	    	data[1][1] = scalingFactorY;
	    	
	    }
	
}
