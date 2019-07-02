package de.uniwue.gdp.diffcalc.base;

import de.uniwue.gdp.diffcalc.Function;

public class Constant implements Function {

	double value = 0;
	
	public double evaluate(double x){
		return value;
	}
	
	public Function derive(){
		return new Constant(0) ;
		
	}
	
	public Constant (double value){
		this.value = value;
	}
	
	public String toString(){
		
		return "" + value;
		
	}
}
