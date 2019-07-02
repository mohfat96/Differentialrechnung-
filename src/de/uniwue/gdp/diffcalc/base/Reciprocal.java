package de.uniwue.gdp.diffcalc.base;

import java.util.ArrayList;
import java.util.Collection;

import de.uniwue.gdp.diffcalc.Function;

public class Reciprocal implements Function{

	
	Function function;
	
	@Override
	public double evaluate(double x) {
		// TODO Auto-generated method stub
		return 1.0/function.evaluate(x); 
	}

	@Override
	public Function derive() {
		// TODO Auto-generated method stub
	

		Function quadrat = new Product(function , function);
		
		Function fder  = new Product( function.derive() , new Reciprocal(quadrat));
		

		
	return new Product(fder , new Constant(-1));
	}

	
	public Reciprocal(Function function){
		this.function = function;
	}
	
	
	
	
	
}
