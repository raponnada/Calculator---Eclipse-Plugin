package com.objectsbydesign.calc.main;


import com.objectsbydesign.calc.model.Command;
import com.objectsbydesign.calc.model.IStack;

import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

public class CalcArch extends AbstractMyxSimpleBrick
{
    public static final IMyxName msg_Command = MyxUtils.createName("com.objectsbydesign.calc.model.Command");
    public static final IMyxName msg_IStack = MyxUtils.createName("com.objectsbydesign.calc.model.IStack");

    public Object[] OUT_Command;
    public IStack OUT_IStack;

	private ICalculatorImp _imp;

    public CalcArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected ICalculatorImp getImplementation(){
        try{
			return new CalcImp();    
        } catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public void init(){
        _imp.init();
    }
    
    public void begin(){
        //OUT_Command = (Command) MyxUtils.getFirstRequiredServiceObject(this,msg_Command);
    	OUT_Command = (Object[]) MyxUtils.getRequiredServiceObjects(this,msg_Command);
    	String s1 = OUT_Command.toString();
    	if(s1.contains("OperationCommand")){
    		Object[] O = (Object[]) OUT_Command[0];
    		OUT_Command[0]=OUT_Command[1];
    		OUT_Command[1]=O;
    	}
    	System.out.println(OUT_Command[0]);
    	System.out.println(OUT_Command[1]);
        if (OUT_Command == null){
 			System.err.println("Error: Interface com.objectsbydesign.calc.model.Command returned null");
			return;       
        }
        OUT_IStack = (IStack) MyxUtils.getFirstRequiredServiceObject(this,msg_IStack);
        if (OUT_IStack == null){
 			System.err.println("Error: Interface com.objectsbydesign.calc.model.IStack returned null");
			return;       
        }
        _imp.begin();
    }
    
    public void end(){
        _imp.end();
    }
    
    public void destroy(){
        _imp.destroy();
    }
    
	public Object getServiceObject(IMyxName arg0) {
		return null;
	}
}