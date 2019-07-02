package de.uniwue.gdp.diffcalc.base;

import java.util.ArrayList;
import java.util.Collection;

import de.uniwue.gdp.diffcalc.Function;

public class Composition implements Function{

	private Function outer;
	private Function inner;

	@Override
	public double evaluate(double x) {
		// TODO Auto-generated method stub
		return outer.evaluate(inner.evaluate(x)) ;
	}

	@Override
	public Function derive() {
		// TODO Auto-generated method stub
		
		return new Product(new Composition(outer.derive(),inner) , inner.derive());
	}
	
	public Composition(Function outer, Function inner) {
		
		this.outer = outer;
		this.inner = inner;
		
		
	}
	

}
