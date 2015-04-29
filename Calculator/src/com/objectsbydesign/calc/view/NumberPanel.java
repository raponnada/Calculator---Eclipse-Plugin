/**
    Object-Oriented Calculator

    Copyright (C) 1999-2002, Objects by Design, Inc. All Rights Reserved.

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation. A copy of the license may be found at
    http://www.objectsbydesign.com/projects/gpl.txt
 */

/**
 * Panel containing the number keys and their ActionListeners
 */

package com.objectsbydesign.calc.view;

import org.eclipse.swt.widgets.Shell;

public class NumberPanel extends KeyPanel {

	public NumberPanel(Calculator calculator, Shell shell) {
		super(calculator);

		addKey("6", "Six", shell);
		addKey("7", "Seven", shell);
		addKey("8", "Eight", shell);
		addKey("9", "Nine", shell);
		addKey("2", "Two", shell);
		addKey("3", "Three", shell);
		addKey("4", "Four", shell);
		addKey("5", "Five", shell);
		addKey("0", "Zero", shell);
		addKey("1", "One", shell);

		addKey(".", "Decimal", shell);
		addKey("+/-", "ReverseSign", shell);
	}

}
