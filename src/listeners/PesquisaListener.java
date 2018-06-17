package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GUI.MyTwitterHome;
import GUI.MyTwitterScreenManager;
import GUI.interfaces.MyTwitterView;
import GUI.interfaces.MyTwitterViewManager;
import servicos.ProcessarPesquisa;

public class PesquisaListener implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		
		MyTwitterView view = ((MyTwitterView)((JButton)e.getSource()).getTopLevelAncestor());
	
		if(MyTwitterHome.class.isAssignableFrom(view.getClass())){
			
			
			String pesquisa = ((MyTwitterHome)view).getToolbar().getPesquisa();
			
			MyTwitterViewManager viewManager = view.getViewManager();
			
			if(MyTwitterScreenManager.class.isAssignableFrom(viewManager.getClass())){
				
				ProcessarPesquisa p = new ProcessarPesquisa(((MyTwitterScreenManager)viewManager).getRepositorio());
				
				((MyTwitterHome)view).setResultadosPesquisa(p.pesquisarPerfis(pesquisa));
				
				((MyTwitterHome)view).carregarResultadosPesquisa();
				
			}
			
		}
		
	}
	
}
