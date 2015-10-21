package Model.matrix;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class ScaleMatrix extends Matrix{

	 public ScaleMatrix(){
	        super(3,3);
	    }
	    
	    public void setScalingFactor(double scalingFactorX, double scalingFactorY)
	    {
	    	
	    	super.makeIdentity();
	    	data[0][0] = scalingFactorX;
	    	data[1][1] = scalingFactorY;
	    	
	    }
	
}
