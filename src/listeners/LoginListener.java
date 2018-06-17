package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GUI.MyTwitterScreenManager;
import GUI.classesAbstratas.MyTwitterViewLogin;
import GUI.interfaces.MyTwitterView;
import GUI.interfaces.MyTwitterViewManager;

public class LoginListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		MyTwitterViewManager viewManager = ((MyTwitterView)((JButton)e.getSource()).getTopLevelAncestor()).getViewManager();

		if(viewManager instanceof MyTwitterScreenManager){
			
			MyTwitterView view = ((MyTwitterScreenManager) viewManager).getMyTwitterLogin();
			
			if(view instanceof MyTwitterViewLogin){
				
				((MyTwitterViewLogin) view).fazerLogin();
				
			}
			
		}
		
	}

}
