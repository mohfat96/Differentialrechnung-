package de.uniwue.gdp.diffcalc.base;

import de.uniwue.gdp.diffcalc.Function;

public class Power implements Function {

	double exponent;
	
	
	 public double evaluate(double x) {
		// TODO Auto-generated method stub
		return Math.pow(x, exponent);
	} 

	@Override
	public Function derive() {
		// TODO Auto-generated method stub
		Power Pow = new Power(exponent-1);
		return new Factor(exponent,Pow);
	}
	
public Power(double exponent){
		this.exponent = exponent;
	}
}
