/**
    Object-Oriented Calculator

    Copyright (C) 1999-2002, Objects by Design, Inc. All Rights Reserved.

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation. A copy of the license may be found at
    http://www.objectsbydesign.com/projects/gpl.txt
 */

package com.extnmem.calc.model;

import com.objectsbydesign.calc.model.Value;


/**
 * Operation sub-class that implements addition to memory
 */

public class MemoryPlus extends MemoryOperation {
    public MemoryPlus () {
        precedence = LOWEST;
        symbol = "M+";
    }

    public void executeMemory() {
        Value value = stack.peek();
        memory.setValue(memory.getValue().add(value));
    }
}


