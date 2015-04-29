/**
    Object-Oriented Calculator

    Copyright (C) 1999-2002, Objects by Design, Inc. All Rights Reserved.

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation. A copy of the license may be found at
    http://www.objectsbydesign.com/projects/gpl.txt
 */

package com.objectsbydesign.calc.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

/**
 * Parent frame of the calculator, it contains all of the other panels
 */
public class CalculatorFrame {
	int width = 375;
	int height = 300;
	Shell shell;
	Display disply;
	static GridLayout gridLayout;
	static GridData gData;

	// Panel that contains a text field for display
	DisplayPanel display;

	// Panel that contains the memory and function keys
	FunctionPanel function;

	// Panel that contains the + - / * = keys
	OperationPanel operation;

	// Panel that contains the number keys
	NumberPanel key;

	Calculator calculator;

	public CalculatorFrame(Calculator calculator) {

		disply = Display.getCurrent();
		shell = new Shell(disply);
		shell.open();

		shell.setText("Kalikyuleṭar");
		shell.setSize(375, 300);

		gridLayout = new GridLayout(4, true);
		gridLayout.horizontalSpacing = 3;
		gridLayout.verticalSpacing = 3;
		gridLayout.numColumns = 4;
		gridLayout.marginBottom = 4;
		gridLayout.marginTop = 4;
		shell.setLayout(gridLayout);
		display = new DisplayPanel(shell);
		new FunctionPanel(calculator, shell);
		new NumberPanel(calculator, shell);
		new OperationPanel(calculator, shell);

		calculator.addDisplayObserver(display);
		calculator.addMemoryObserver(display.getMemoryStatus());
		shell.addKeyListener(new KeyHandler());
		
		shell.pack();
		center(shell);
		shell.open();
		while (!shell.isDisposed()) {
			if (!disply.readAndDispatch()) {
				disply.sleep();
			}

		}
	}

	// Window Closing enableEvents(AWTEvent.WINDOW_EVENT_MASK);*/
	// show(); requestFocus();

	void center(Shell shell) {

		Rectangle rectangle = shell.getDisplay().getBounds();

		Point points = shell.getSize();

		int nLeft = (rectangle.width - points.x) / 2;
		int nTop = (rectangle.height - points.y) / 2;

		shell.setBounds(nLeft, nTop, points.x, points.y);

	}

	/*
	 * This inner class is a keyboard listener that implements all of the
	 * controls from the keyboard
	 */

	class KeyHandler extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			System.out.println("hjds"+e);
			char key = e.character;
			System.out.println("Key handler"+e.character);
			switch (key) {
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
			case '0':
			case '.':
				String digit = (new Character(key)).toString();
				calculator.enterDigit(digit);
				break;

			case 'c':
				calculator.enterOperation("Clear");
				break;

			case '/':
				calculator.enterOperation("Divide");
				break;

			case '*':
				calculator.enterOperation("Multiply");
				break;

			case '-':
				calculator.enterOperation("Minus");
				break;

			case '+':
				calculator.enterOperation("Plus");
				break;

			case '=':
			case '\n':
				calculator.enterOperation("Equals");
				break;

			}
			
		}
		public void KeyTyped(KeyEvent ev){
			System.out.println("hell"+ev);
			
		}
		public void KeyReleased(KeyEvent et){
			System.out.println("fgsj");
		}

		// public void keyPressed(KeyEvent e) {
		// if (e.character == SWT.KEYPAD_CR)
		// calculator.enterOperation("Equals");
		// }

	}
}