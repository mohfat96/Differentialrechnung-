package de.uniwue.gdp.diffcalc.base;

import java.util.ArrayList;
import java.util.Collection;

import de.uniwue.gdp.diffcalc.Function;

public class Tangent implements Function{

	@Override
	public double evaluate(double x) {
		// TODO Auto-generated method stub
		return Math.tan(x);
	}

	@Override
	public Function derive() {
		// TODO Auto-generated method stub
		
		
		 return new Reciprocal(new Composition(new Power(2), new Cosine())); 
	
	}

}
