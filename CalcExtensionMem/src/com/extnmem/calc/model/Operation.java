package com.extnmem.calc.model;

import java.lang.reflect.Constructor;

import com.objectsbydesign.calc.model.Cpu;
import com.objectsbydesign.calc.model.OperandStack;
import com.objectsbydesign.calc.model.OperationI;

public class Operation implements OperationI {

	
	
	protected int precedence;
    protected boolean lookahead;
    protected String symbol;
    protected Cpu cpu;
    protected OperandStack stack;
    
    public Operation() {
		// TODO Auto-generated constructor stub
	}
    
    public Operation findOp(String operation){
    	String model = "com.extnmem.calc.model";
        Operation op = null;
        Constructor constructor = null;
        try{
    	 Class klass = Class.forName(model+'.'+operation);
         constructor = klass.getDeclaredConstructor(null);
         op = (Operation) constructor.newInstance(null);
        }
        catch (Exception ex) {
            System.out.println(ex.toString());
        }
        
        return op;
    }
    
    public int getPrecedence() {
        return precedence;
    }

    public boolean getLookahead() {
        return lookahead;
    }

    public String toString() {
        return symbol;
    }

    public void setString(String s) {
        symbol = s;
    }
    /**
     * The execute method signature which must be implemented for each operation.
     */
    public void execute(Cpu cpu){}
	
}
