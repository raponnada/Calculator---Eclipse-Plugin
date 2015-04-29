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
 *  Operation class that implements the inverse operation
 */

public class Inverse extends UnaryOperation {
    public Inverse ( ) {
        symbol = "1/x";
    }

    public Value executeUnary(Value value) {
    	BigDecimal result = null;
    	BigDecimal value1= ((DecimalValue)value).value;
       try {
            result = one.divide(value1, SCALE, BigDecimal.ROUND_UP);
        } catch (ArithmeticException e) {
            // in case of divide by zero,
            // report the error and leave the current value  \
            System.err.println("Arithmetic Error");
            return value;
        }
        return new DecimalValue(result);
    }
}