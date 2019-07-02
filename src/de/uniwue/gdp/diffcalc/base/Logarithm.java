package de.uniwue.gdp.diffcalc.base;

import de.uniwue.gdp.diffcalc.Function;

public class Logarithm implements Function{

	@Override
	public double evaluate(double x) {
		// TODO Auto-generated method stub
		return Math.log(x);
	}

	@Override
	public Function derive() {
		// TODO Auto-generated method stub
		return new Reciprocal(new Identity());
	}

}
