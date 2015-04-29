/**
    Object-Oriented Calculator

    Copyright (C) 1999-2002, Objects by Design, Inc. All Rights Reserved.

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation. A copy of the license may be found at
    http://www.objectsbydesign.com/projects/gpl.txt
 */

package com.objectsbydesign.calc.model;


/**
 * Superclass for all of the operation subclasses
 */

public interface OperationI {

    /* The precedence for operations.
     * For example, unary operations have a higher precedence than binary operations.
     */
    static final int HIGHEST = 5;
    static final int HIGH = 4;
    static final int MEDIUM = 3;
    static final int LOW = 2;
    static final int LOWEST = 1;


    public int getPrecedence();

    public boolean getLookahead();

    public String toString();

    public void setString(String s);

    /**
     * The execute method signature which must be implemented for each operation.
     */
    public abstract void execute(Cpu cpu);

	public OperationI findOp(String operation);

}



