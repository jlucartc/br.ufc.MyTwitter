package eventListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GUI.MyTwitterCadastro;

public class VoltarListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		((MyTwitterCadastro)(((JButton)e.getSource()).getTopLevelAncestor())).getScreenManager().login();
		
	}

	
}
