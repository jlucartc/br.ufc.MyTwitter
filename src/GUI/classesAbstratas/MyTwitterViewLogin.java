package GUI.classesAbstratas;

import javax.swing.JFrame;

import GUI.interfaces.MyTwitterView;

public abstract class MyTwitterViewLogin extends JFrame implements MyTwitterView{

	/**
	 * 
	 */
	private static final long serialVersionUID = 753837382976507412L;

	public void fazerLogin(){}
	
	public String getUsuario(){ return null; }
}
