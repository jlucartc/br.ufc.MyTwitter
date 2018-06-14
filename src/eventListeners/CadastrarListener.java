package eventListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GUI.MyTwitterLogin;
import GUI.MyTwitterScreenManager;

public class CadastrarListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		MyTwitterScreenManager screenManager = ((MyTwitterLogin)(((JButton)e.getSource()).getTopLevelAncestor())).getScreenManager(); 
		screenManager.cadastro();
	}

}
