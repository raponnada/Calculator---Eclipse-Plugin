/**
    Object-Oriented Calculator

    Copyright (C) 1999-2002, Objects by Design, Inc. All Rights Reserved.

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation. A copy of the license may be found at
    http://www.objectsbydesign.com/projects/gpl.txt
 */

package com.objectsbydesign.calc.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;

import java.util.HashMap;

public class KeyPanel {

	protected Calculator calculator;
	// protected OperationHandler operationHandler;
	protected HashMap keyMap;
	protected Button button;
	String op;

	public KeyPanel(Calculator calculator) {
		this.calculator = calculator;
		keyMap = new HashMap();
	}

	protected void addKey(String display, String action, Shell shell) {
		
		button = new Button(shell, SWT.PUSH);
		button.setText(display);
		button.setData(action);
		
		GridData gd = new GridData(SWT.FILL, SWT.FILL, false, false);
		gd.widthHint = 60;
		gd.heightHint = 30;
		button.setLayoutData(gd);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String op = (String) (((Button) (e.widget)).getData());
				if (op == "One" || op == "Two" || op == "Three" || op == "Four"
						|| op == "Five" || op == "Six" || op == "Seven"
						|| op == "Eight" || op == "Nine" || op == "Zero"
						|| op == "Decimal") {
					String digit = getKey(op);
					calculator.enterDigit(digit);
				} else {
					calculator.enterOperation(op);
				}

			}
		});
		
		keyMap.put(action, display);
	}

	protected String getKey(String action) {
		return (String) keyMap.get(action);
	}

}
