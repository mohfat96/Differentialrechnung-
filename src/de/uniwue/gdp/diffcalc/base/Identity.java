package de.uniwue.gdp.diffcalc.base;

import de.uniwue.gdp.diffcalc.Function;

public class Identity implements Function {

	@Override
	public double evaluate(double x) {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public Function derive() {
		// TODO Auto-generated method stub
		return new Constant(1);
	}

public String toString(){
		
		return "x";
		
	}
	
}
