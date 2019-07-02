package de.uniwue.gdp.diffcalc.base;

import de.uniwue.gdp.diffcalc.Function;

public class Cosine implements Function  {

	@Override
	public double evaluate(double x) {
		// TODO Auto-generated method stub
		return Math.cos(x);
	}

	@Override
	public Function derive() {
		// TODO Auto-generated method stub
		return new Factor(-1,new Sine());
	}

	

	}

