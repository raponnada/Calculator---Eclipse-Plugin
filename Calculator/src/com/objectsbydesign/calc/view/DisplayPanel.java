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
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.util.Observable;
import java.util.Observer;

/**
 * Class to display the entries and the results of the calculator.
 */

public class DisplayPanel implements Observer {

    private Text displayField;
    private MemoryStatus memoryStatus;

    private static final int MAXDIGITS = 16;


    public DisplayPanel(Shell shell) {
    	
    	memoryStatus = new MemoryStatus(shell);
    	Font font = new Font(shell.getDisplay(), "Monospaced", 18, SWT.BOLD);
    	displayField = new Text(shell, SWT.SINGLE|SWT.BORDER |SWT.RIGHT);
    	displayField.setText("0");
        displayField.setTextLimit(MAXDIGITS);
        displayField.setFont(font);
        displayField.setEditable(false);
        
        GridData gData = new GridData();
		gData.horizontalSpan = 3;
		gData.horizontalAlignment = GridData.FILL;
		displayField.setLayoutData(gData);
    }

    public MemoryStatus getMemoryStatus ( ) {
        return memoryStatus;
    }

    public void setDisplay(String text){
    	displayField.setText(text);
    }

    public void update(Observable observable, Object object) {
    	setDisplay((String) object);
        
    }
}