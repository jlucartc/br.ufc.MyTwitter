package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GUI.MyTwitterCadastro;
import GUI.MyTwitterLogin;
import GUI.interfaces.MyTwitterView;

public class VoltarListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		MyTwitterView view = ((MyTwitterView)((JButton)e.getSource()).getTopLevelAncestor());

		if(MyTwitterCadastro.class.isAssignableFrom(view.getClass())){
			
			view.getViewManager().ativarView(MyTwitterLogin.class);
			
			
		}
		
	}

	
}
