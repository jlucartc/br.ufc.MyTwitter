package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GUI.MyTwitterHome;
import GUI.MyTwitterLogin;
import GUI.interfaces.MyTwitterView;
import GUI.interfaces.MyTwitterViewManager;

public class SairListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		MyTwitterView view = ((MyTwitterView)((JButton)e.getSource()).getTopLevelAncestor());
		
		if(MyTwitterHome.class.isAssignableFrom(view.getClass())){
			
			view.getViewManager().ativarView(MyTwitterLogin.class);
			
		}
		
	}



}
