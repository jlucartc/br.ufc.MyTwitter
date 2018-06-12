package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import classes.Tweet;

public class MyTwitterHome extends JFrame{

	private MyTwitterPainelToolbar toolbar;
	private MyTwitterPainelStatus status;
	private JPanel conteudoPanel;
	private MyTwitterPainelTimeline timeline;
	
	public MyTwitterHome(){
		Vector<Tweet> vetor = new Vector();
		
		for(int i = 0; i < 20; i++){
			
			Tweet tweet = new Tweet();
			tweet.setMensagem("Mensagem "+Integer.toString(i));
			tweet.setUsuario("Usuário "+Integer.toString(i));
			vetor.add(tweet);
			
		}
		
		JScrollPane scroll = new JScrollPane();
		JPanel painel = new JPanel();
		
		this.timeline = new MyTwitterPainelTimeline(vetor);
		this.timeline.setAlignmentY(TOP_ALIGNMENT);
		this.status = new MyTwitterPainelStatus("Usuário",5,5,10);
		this.status.setAlignmentY(TOP_ALIGNMENT);
		
		this.conteudoPanel = new JPanel();
		this.setMaximumSize(new Dimension(1200,700));
		this.setMinimumSize(new Dimension(1200,700));
		this.setVisible(true);
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		
		this.conteudoPanel.setMaximumSize(new Dimension(1200,700));
		this.conteudoPanel.setMinimumSize(new Dimension(1200,700));
		this.conteudoPanel.setLayout(new BoxLayout(this.conteudoPanel,BoxLayout.X_AXIS));
		this.conteudoPanel.add(this.status);
		this.conteudoPanel.add(this.timeline);
		this.conteudoPanel.setBackground(Color.GREEN);
		this.toolbar = new MyTwitterPainelToolbar();
		
		this.add(this.toolbar);
		this.add(this.conteudoPanel);
		
		
		this.setVisible(true);
		
	}
	
}
