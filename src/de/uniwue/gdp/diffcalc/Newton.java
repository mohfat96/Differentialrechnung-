package de.uniwue.gdp.diffcalc;

import java.util.ArrayList;
import java.util.Collection;

import de.uniwue.gdp.diffcalc.base.*;

public class Newton {

	public double zero(Function function, double x0){
		    int Counter = 0;
		    while (function.evaluate(x0)!= 0 & Math.abs(function.evaluate(x0)) > Math.pow(10, -9) & Counter < Math.pow(2, 16) ){
		  	
				
		    	x0 = new Sum(new Identity() , new Product(new Factor(-1 , function) , new Reciprocal(function.derive())) ).evaluate(x0);
		    	Counter++;
		    	
		    }
		    
		    return x0;
	
	}
	public double intersection(Function f, Function g, double x0){
		
    	
    	
    	return zero(new Sum(g , new Factor(-1 , f)), x0);

		

}
	
	public static void main (String args[]){
		Examples examples = new Examples();
		Newton newton = new Newton();
		
		System.out.println(newton.zero(examples.example3(), -1));
		
	}
	
}
