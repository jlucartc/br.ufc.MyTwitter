package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import classes.Perfil;
import classes.Tweet;

public class MyTwitterHome extends JFrame{

	private MyTwitterPainelToolbar toolbar;
	private MyTwitterPainelStatus status;
	private JPanel conteudoPanel;
	private JPanel timelinePanel;
	private JPanel statusPanel;
	private MyTwitterTweetBox tweetBox;
	private MyTwitterPainelTimeline timeline;
	private MyTwitterPainelResultadosPesquisa painelResultadosPesquisa;
	private Vector<Perfil> resultadosPesquisa;
	private Perfil perfil;

	public MyTwitterHome(Perfil perfil) {
		
		this.perfil = perfil;
		this.resultadosPesquisa = new Vector<Perfil>();
		this.carregarTimeline();

	}

	public void carregarTimeline(){
		
		this.getContentPane().removeAll();
		
		this.tweetBox = new MyTwitterTweetBox();
		
		this.statusPanel = new JPanel();
		this.statusPanel.setLayout(new BoxLayout(this.statusPanel,BoxLayout.PAGE_AXIS));
		
		this.timelinePanel = new JPanel();
		
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
		this.status.setBackground(Color.BLACK);
		
		this.conteudoPanel = new JPanel();
		this.setMaximumSize(new Dimension(1200,700));
		this.setMinimumSize(new Dimension(1200,700));
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));

		this.statusPanel.setMaximumSize(new Dimension(300,700));
		this.statusPanel.setMinimumSize(new Dimension(300,700));
		this.statusPanel.setPreferredSize(new Dimension(300,700));
		this.statusPanel.add(this.status);
		
		this.timelinePanel.setMaximumSize(new Dimension(600,700));
		this.timelinePanel.setMinimumSize(new Dimension(600,700));
		this.timelinePanel.setPreferredSize(new Dimension(600,700));
		this.timelinePanel.setLayout(new BoxLayout(this.timelinePanel,BoxLayout.Y_AXIS));
		this.timelinePanel.add(this.tweetBox);
		this.timelinePanel.add(this.timeline);
		
		this.conteudoPanel.setMaximumSize(new Dimension(1200,700));
		this.conteudoPanel.setMinimumSize(new Dimension(1200,700));
		this.conteudoPanel.setLayout(new BoxLayout(this.conteudoPanel,BoxLayout.X_AXIS));
		this.conteudoPanel.add(this.statusPanel);
		//this.conteudoPanel.add(Box.createRigidArea(new Dimension(20,700)));
		this.conteudoPanel.add(this.timelinePanel);
		this.conteudoPanel.setBackground(Color.GREEN);
		this.toolbar = new MyTwitterPainelToolbar();
		this.toolbar.setBackground(Color.gray);
		
		this.add(this.toolbar);
		this.add(this.conteudoPanel);
		
		this.setVisible(true);
		this.repaint();

	}

	public void carregarResultadosPesquisa(){
		
		this.getContentPane().removeAll();

		this.statusPanel = new JPanel();
		this.statusPanel.setLayout(new BoxLayout(this.statusPanel,BoxLayout.PAGE_AXIS));
		
		Vector<Tweet> vetor = new Vector();

		JScrollPane scroll = new JScrollPane();
		JPanel painel = new JPanel();
		
		this.statusPanel.setMaximumSize(new Dimension(300,700));
		this.statusPanel.setMinimumSize(new Dimension(300,700));
		this.statusPanel.setPreferredSize(new Dimension(300,700));
		this.statusPanel.add(this.status);

		this.painelResultadosPesquisa = new MyTwitterPainelResultadosPesquisa(this.resultadosPesquisa);
		this.painelResultadosPesquisa.setAlignmentY(TOP_ALIGNMENT);
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
		this.conteudoPanel.add(this.statusPanel);
		this.conteudoPanel.add(this.painelResultadosPesquisa);
		this.conteudoPanel.setBackground(Color.GREEN);
		this.toolbar = new MyTwitterPainelToolbar();

		this.add(this.toolbar);
		this.add(this.conteudoPanel);
		
	}

	
}
