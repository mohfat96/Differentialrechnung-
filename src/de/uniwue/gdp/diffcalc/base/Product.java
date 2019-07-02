package de.uniwue.gdp.diffcalc.base;

import java.util.ArrayList;
import java.util.Collection;

import de.uniwue.gdp.diffcalc.Function;

public class Product implements Function{

	private Function factor1;
	private Function factor2;
	
	@Override
	public double evaluate(double x) {
		double res = factor1.evaluate(x) * factor2.evaluate(x);
		return res;
	}

	@Override
	public Function derive() {
		// TODO Auto-generated method stub
		
		return new Sum(new Product(factor1 , factor2.derive()), new Product(factor1.derive() , factor2 ));
	}

	
	public Product(Function factor1, Function factor2){
		this.factor1 = factor1;
		this.factor2 = factor2;
		
	}
	

	
}
