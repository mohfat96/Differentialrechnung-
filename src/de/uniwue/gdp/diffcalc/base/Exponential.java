package de.uniwue.gdp.diffcalc.base;

import de.uniwue.gdp.diffcalc.Function;

public class Exponential implements Function{

	@Override
	public double evaluate(double x) {
		// TODO Auto-generated method stub
		return Math.exp(x);
	}

	@Override
	public Function derive() {
		// TODO Auto-generated method stub
		return new Exponential();
	}

}
