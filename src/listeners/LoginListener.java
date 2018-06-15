package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GUI.MyTwitterLogin;
import GUI.MyTwitterScreenManager;
import classes.Perfil;

public class LoginListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		MyTwitterScreenManager screenManager = ((MyTwitterLogin)((JButton)e.getSource()).getTopLevelAncestor()).getScreenManager();
		String usuario = ((MyTwitterLogin)((JButton)e.getSource()).getTopLevelAncestor()).getUsuario();
		Perfil perfil = screenManager.getRepositorio().buscar(usuario);

		if(perfil != null){
			
			screenManager.home(usuario);
			
		}
		
	}

}
