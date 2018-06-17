package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GUI.MyTwitterHome;
import GUI.MyTwitterLogin;
import GUI.classesAbstratas.MyTwitterViewHome;
import GUI.interfaces.MyTwitterView;

public class HomeListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		MyTwitterView view = ((MyTwitterView)((JButton)e.getSource()).getTopLevelAncestor());
		
		if(MyTwitterHome.class.isAssignableFrom(view.getClass())){
			
			System.out.println("homeListener");
			((MyTwitterHome)view).carregarTimeline();
			
		}
		
	}

}
