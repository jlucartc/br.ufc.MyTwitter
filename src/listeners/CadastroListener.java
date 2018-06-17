package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GUI.MyTwitterLogin;
import GUI.MyTwitterScreenManager;
import GUI.interfaces.MyTwitterView;
import GUI.interfaces.MyTwitterViewManager;

public class CadastroListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		MyTwitterViewManager viewManager = ((MyTwitterLogin)(((JButton)e.getSource()).getTopLevelAncestor())).getViewManager(); 
		
		if(viewManager instanceof MyTwitterScreenManager){
			
			MyTwitterView view = (((MyTwitterScreenManager) viewManager).getMyTwitterCadastro());
			
			viewManager.ativarView(view.getClass());
			
		}
		
	}

}
