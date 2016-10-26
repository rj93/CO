package io.richard.sa.cooling;

public class DefaultCoolingRatio implements CoolingRatio {
	
	private double a;
	
	public DefaultCoolingRatio(){
		a = 0.9;
	}
	
	public DefaultCoolingRatio(double a) {
		if (a <= 0 || a > 1)
			throw new IllegalArgumentException();
		this.a = a;
	}
	
	@Override
	public double cool(double temperate) {
		return a * temperate;
	}

}
