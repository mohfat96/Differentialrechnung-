package de.uniwue.gdp.diffcalc;

public interface Function {

	double evaluate(double x);
	Function derive();
	
}
