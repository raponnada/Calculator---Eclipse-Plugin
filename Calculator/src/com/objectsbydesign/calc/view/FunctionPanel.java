/**
    Object-Oriented Calculator

    Copyright (C) 1999-2002, Objects by Design, Inc. All Rights Reserved.

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation. A copy of the license may be found at
    http://www.objectsbydesign.com/projects/gpl.txt
 */

/**
 * Panel to hold the function buttons
 */
package com.objectsbydesign.calc.view;

import org.eclipse.swt.widgets.Shell;

public class FunctionPanel extends KeyPanel {

    public FunctionPanel(Calculator calculator,Shell shell) {
        super(calculator);
        
        addKey("C", "Clear", shell);
        addKey("SQR", "Square", shell);
        addKey("SQRT", "SquareRoot", shell);
        addKey("1/X", "Inverse", shell);

        addKey("MR", "MemoryRecall", shell);
        addKey("MC", "MemoryClear",  shell);
        addKey("M-", "MemoryMinus",  shell);
        addKey("M+", "MemoryPlus",  shell);
    }
}