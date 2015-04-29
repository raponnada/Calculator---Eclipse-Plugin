/**
    Object-Oriented Calculator

    Copyright (C) 1999-2002, Objects by Design, Inc. All Rights Reserved.

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation. A copy of the license may be found at
    http://www.objectsbydesign.com/projects/gpl.txt
 */

package com.objectsbydesign.calc.view;

/**
 * Panel that holds the function buttons.
 */

import org.eclipse.swt.widgets.Shell;

public class OperationPanel extends KeyPanel {

    public OperationPanel(Calculator calculator, Shell shell) {
        super(calculator);
       
        addKey("+", "Plus", shell);
        addKey("/", "Divide", shell);
        addKey("*", "Multiply", shell);
        addKey("-", "Minus", shell);
        addKey("%", "Percent", shell);
        addKey("=", "Equals", shell);
        
    }
}