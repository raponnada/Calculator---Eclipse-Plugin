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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;

import java.util.Observable;
import java.util.Observer;

public class MemoryStatus implements Observer {
	
	private Text memoryField;

	public MemoryStatus(Shell shell) {

		memoryField = new Text(shell, SWT.END|SWT.NO_FOCUS);
		Font font = new Font(shell.getDisplay(), "Helvetica", 12, SWT.NORMAL|SWT.BOLD);
		memoryField.setFont(font);
		memoryField.setEnabled(false);
		memoryField.setEditable(false);
		GridData gmData = new GridData();
		gmData.horizontalAlignment = GridData.HORIZONTAL_ALIGN_END;
		gmData.horizontalSpan = 1;
		memoryField.setLayoutData(gmData);

	}

	public void update(Observable observable, Object object) {
		memoryField.setText((String) object);
	}
}
