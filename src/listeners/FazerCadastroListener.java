package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GUI.MyTwitterCadastro;
import GUI.MyTwitterScreenManager;
import GUI.interfaces.MyTwitterView;
import GUI.interfaces.MyTwitterViewManager;

public class FazerCadastroListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		MyTwitterViewManager viewManager = ((MyTwitterView)(((JButton)e.getSource()).getTopLevelAncestor())).getViewManager(); 
		
		if(viewManager instanceof MyTwitterScreenManager){
			
			MyTwitterView view = (((MyTwitterScreenManager) viewManager).getMyTwitterCadastro());
			
			if(view instanceof MyTwitterCadastro){
				
				((MyTwitterCadastro) view).fazerCadastro();
				
			}
			
		}
		
	}

}
