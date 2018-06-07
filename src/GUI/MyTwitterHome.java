package GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyTwitterHome extends JFrame{

	private MyTwitterPainelToolbar toolbar;
	private MyTwitterPainelStatus status;
	private JPanel conteudoPanel;
	
	public MyTwitterHome(){
		
		this.status = new MyTwitterPainelStatus("Usuário",5,5,10);
		
		this.conteudoPanel = new JPanel();
		this.setMaximumSize(new Dimension(1200,1200));
		this.setMinimumSize(new Dimension(1200,1200));
		this.setVisible(true);
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		
		this.conteudoPanel.setMaximumSize(new Dimension(1200,1100));
		this.conteudoPanel.setMinimumSize(new Dimension(1200,1100));
		this.conteudoPanel.setLayout(new BoxLayout(this.conteudoPanel,BoxLayout.Y_AXIS));
		this.conteudoPanel.add(this.status);
		this.conteudoPanel.setBackground(Color.GREEN);
		this.toolbar = new MyTwitterPainelToolbar();
		
		this.add(this.toolbar);
		this.add(this.conteudoPanel);
		
		this.setVisible(true);
		
	}
	
}
