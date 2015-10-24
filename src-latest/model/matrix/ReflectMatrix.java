package model.matrix;

public class ReflectMatrix extends Matrix{
	public ReflectMatrix() {
		super(3, 3);
	}
	
	public void reflect(boolean isXAxis) {
		super.makeIdentity();
		if(isXAxis) {
			data[1][1] = -data[1][1];
		} else {
			data[0][0] = -data[0][0];
		}
	}
}
