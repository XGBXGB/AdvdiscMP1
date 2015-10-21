package model.matrix;

public class ShearMatrix extends Matrix{
	public ShearMatrix() {
		super(3, 3);
	}
	
	public void shear(boolean isXAxis, int units) {
		super.makeIdentity();
		
		if(isXAxis) {
			data[0][1] = units;
			data[1][0] = 0;
		} else {
			data[0][1] = 0;
			data[1][0] = units;
		}
	}
}
