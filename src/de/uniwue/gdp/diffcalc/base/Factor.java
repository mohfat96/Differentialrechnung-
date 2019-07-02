package de.uniwue.gdp.diffcalc.base;

import de.uniwue.gdp.diffcalc.Function;

public class Factor implements Function {

	double factor;
	Function function ;
	@Override
	public double evaluate(double x) {
		// TODO Auto-generated method stub
		return factor * function.evaluate(x) ;
	}

	@Override
	public Function derive() {
		
		return new Factor(factor , function.derive());
	}
	
	
	public Factor(double factor, Function function){
		this.factor = factor;
		this.function = function;
	}
	
	
	public String toString(){
		System.out.println(factor + " *");
	     function.toString();
	return " ";
		}
	
}
