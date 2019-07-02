package de.uniwue.gdp.diffcalc.base;

import java.util.ArrayList;
import java.util.Collection;

import de.uniwue.gdp.diffcalc.Function;

public class Sum implements Function {

	Collection<Function> Summands;
	private Function summand1;
	private Function summand2;
	
	
	@Override
	public double evaluate(double x) {
		
		double res = summand1.evaluate(x) + summand2.evaluate(x);
		
		return res;
	}

	@Override
	public Function derive() {
		// TODO Auto-generated method stub
		
		
		
		
		return  new Sum(summand1.derive() , summand2.derive());
	}

	
	public Sum(Function summand1, Function summand2){
		
		this.summand1 = summand1;
		this.summand2 = summand2;
	}
	

	
}
