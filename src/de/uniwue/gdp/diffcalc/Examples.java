package de.uniwue.gdp.diffcalc;
import de.uniwue.gdp.diffcalc.base.*;

public class Examples {
	
	public Function example1(){

	Function x3 = new Power(3);
	Function neg2X = new Factor(-2 , new Identity());
	Function two = new Constant(2);
	
	
	return new Sum(new Sum(x3 , neg2X) , two);
	
	
	}
	public Function example2(){
		
		
		
		Function esin   = new Composition(new Exponential(), new Factor(-1, new Sine()));
		Function negX = new Factor(  -1 ,new Identity());
		Function two  = new Constant(2);
		
		Function negXesin = new Product(negX, esin);
		
		return new Sum(two , negXesin);
		 
	}
	public Function example3(){
		
		Function cos2x = new Composition(new Power(2), new Cosine());
		Function onedevx = new Reciprocal(new Identity());
		Function one = new Constant(1);
		
		return new Sum(new Sum (cos2x , onedevx) , one);
		
	}
	

}
