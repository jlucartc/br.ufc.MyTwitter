package eventListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import GUI.MyTwitterCadastro;
import GUI.MyTwitterScreenManager;
import classes.PessoaFisica;
import excecoes.PEException;
import excecoes.UJCException;

public class FazerCadastroListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
	
			MyTwitterCadastro myTwitterCadastro = (MyTwitterCadastro)((JButton)e.getSource()).getTopLevelAncestor();
			
			myTwitterCadastro.fazerCadastro();
	}

}
