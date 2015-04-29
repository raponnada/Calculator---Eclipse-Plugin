/**
    Object-Oriented Calculator

    Copyright (C) 1999-2002, Objects by Design, Inc. All Rights Reserved.

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation. A copy of the license may be found at
    http://www.objectsbydesign.com/projects/gpl.txt
 */

package com.extn.calc.model;

import java.math.BigDecimal;

import com.objectsbydesign.calc.model.DecimalValue;
import com.objectsbydesign.calc.model.Value;


/**
 * Operation sub-class that implements division
 */

public class Divide extends BinaryOperation {

    public Divide() {
        precedence = LOW;
        symbol = "/";
    }

    public Value executeBinary(Value value1, Value value2) {
       
       BigDecimal val1= ((DecimalValue)value1).value;
	   BigDecimal val2= ((DecimalValue)value2).value;
	   
	   BigDecimal result = null;
	   
	   try {
		   result=val1.divide(val2,SCALE, BigDecimal.ROUND_UP);
       } catch (ArithmeticException e) {
           // in case of divide by zero,
           // report the error and leave the current value  \
           System.err.println("Arithmetic Error");
           return value1;
       }
	   
       return new DecimalValue(result);
       
    }
}