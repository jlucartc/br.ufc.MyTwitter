package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GUI.classesAbstratas.MyTwitterViewHome;
import GUI.componentesHome.MyTwitterResultadosPesquisa;
import GUI.componentesHome.MyTwitterStatus;
import GUI.componentesHome.MyTwitterTimeline;
import GUI.componentesHome.MyTwitterToolbar;
import GUI.componentesHome.MyTwitterTweetBox;
import GUI.interfaces.MyTwitterView;
import GUI.interfaces.MyTwitterViewManager;
import classes.Perfil;
import excecoes.PDException;
import excecoes.PIException;
import listeners.TerminarListener;
import myTwitter.MyTwitter;

@SuppressWarnings("serial")
public class MyTwitterHome extends MyTwitterViewHome implements MyTwitterView{

	private MyTwitterToolbar toolbar;
	private MyTwitterStatus status;
	private JPanel conteudoPanel;
	private JPanel timelinePanel;
	private JPanel statusPanel;
	private MyTwitterTweetBox tweetBox;
	private MyTwitterTimeline timeline;
	private MyTwitterResultadosPesquisa painelResultadosPesquisa;
	private Vector<Perfil> resultadosPesquisa;
	private String usuario;
	private MyTwitter mytwitter;
	private MyTwitterViewManager viewManager;
	private JLabel aviso;
	
	public MyTwitterHome(MyTwitterViewManager viewManager,String usuario,MyTwitter myTwitter) {
		
		this.viewManager = viewManager;
		this.usuario = usuario;
		this.resultadosPesquisa = new Vector<Perfil>();
		this.mytwitter = myTwitter;
		//this.carregarTimeline();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void carregarTimeline(){
		
		this.getContentPane().removeAll();
		
		this.aviso = new JLabel();
		
		this.tweetBox = new MyTwitterTweetBox(this.mytwitter,this.usuario);
		
		this.statusPanel = new JPanel();
		this.statusPanel.setLayout(new BoxLayout(this.statusPanel,BoxLayout.PAGE_AXIS));
		
		this.timelinePanel = new JPanel();

		try {
			this.timeline = new MyTwitterTimeline(this.mytwitter.tweets(this.usuario));
			this.timeline.setAlignmentY(TOP_ALIGNMENT);
			this.status = new MyTwitterStatus(this.usuario,this.mytwitter.seguidores(this.usuario).size(),this.mytwitter.seguidos(this.usuario).size(),this.mytwitter.tweets(usuario).size());
		
			this.timelinePanel.setMaximumSize(new Dimension(600,700));
			this.timelinePanel.setMinimumSize(new Dimension(600,700));
			this.timelinePanel.setPreferredSize(new Dimension(600,700));
			this.timelinePanel.setLayout(new BoxLayout(this.timelinePanel,BoxLayout.Y_AXIS));
			this.timelinePanel.add(this.tweetBox);
			this.timelinePanel.add(this.timeline);
			
			this.status.setAlignmentY(TOP_ALIGNMENT);
			//this.status.setBackground(Color.BLACK);
			
			this.conteudoPanel = new JPanel();
			this.setMaximumSize(new Dimension(1200,700));
			this.setMinimumSize(new Dimension(1200,700));
			this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));

			this.statusPanel.setMaximumSize(new Dimension(300,700));
			this.statusPanel.setMinimumSize(new Dimension(300,700));
			this.statusPanel.setPreferredSize(new Dimension(300,700));
			this.statusPanel.add(this.status);
			
			this.conteudoPanel.setMaximumSize(new Dimension(1200,700));
			this.conteudoPanel.setMinimumSize(new Dimension(1200,700));
			this.conteudoPanel.setLayout(new BoxLayout(this.conteudoPanel,BoxLayout.X_AXIS));
			this.conteudoPanel.add(this.statusPanel);
			//this.conteudoPanel.add(Box.createRigidArea(new Dimension(20,700)));
			this.conteudoPanel.add(this.timelinePanel);
			//this.conteudoPanel.setBackground(Color.GREEN);
			this.toolbar = new MyTwitterToolbar();
			//this.toolbar.setBackground(Color.gray);
			
		} catch (PIException e) {
			JOptionPane.showMessageDialog(null,"Perfil Inexistente");
			this.getViewManager().ativarView(MyTwitterLogin.class);
			e.printStackTrace();
		} catch (PDException e) {
			
			this.aviso.setText("Perfil desativado");
			this.aviso.setFont(new Font("Arial",Font.PLAIN,20));
			this.aviso.setAlignmentX(CENTER_ALIGNMENT);
			this.aviso.setMaximumSize(new Dimension(600,100));
			this.aviso.setMinimumSize(new Dimension(600,100));
			this.aviso.setPreferredSize(new Dimension(600,100));
			
			this.conteudoPanel.setMaximumSize(new Dimension(1200,700));
			this.conteudoPanel.setMinimumSize(new Dimension(1200,700));
			this.conteudoPanel.setLayout(new BoxLayout(this.conteudoPanel,BoxLayout.X_AXIS));
			this.conteudoPanel.add(this.aviso);
			//this.conteudoPanel.add(Box.createRigidArea(new Dimension(20,700)));
			this.conteudoPanel.add(this.timelinePanel);
			//this.conteudoPanel.setBackground(Color.GREEN);
			this.toolbar = new MyTwitterToolbar();
			//this.toolbar.setBackground(Color.gray);
			e.printStackTrace();
		}
		
		
		this.add(this.toolbar);
		this.add(this.conteudoPanel);
		
		this.setVisible(true);
		this.repaint();

	}

	public void carregarResultadosPesquisa(){
		
		this.getContentPane().removeAll();
		
		this.painelResultadosPesquisa = new MyTwitterResultadosPesquisa(this.resultadosPesquisa);
		this.painelResultadosPesquisa.setAlignmentY(BOTTOM_ALIGNMENT);
		this.painelResultadosPesquisa.setAlignmentX(CENTER_ALIGNMENT);
	
		try {
			this.status = new MyTwitterStatus(this.usuario,this.mytwitter.seguidores(this.usuario).size(),this.mytwitter.seguidos(this.usuario).size(),this.mytwitter.tweets(usuario).size());
			this.status.setAlignmentY(TOP_ALIGNMENT);
			
			this.statusPanel = new JPanel();
			this.statusPanel.setLayout(new BoxLayout(this.statusPanel,BoxLayout.PAGE_AXIS));
			
			this.statusPanel.setMaximumSize(new Dimension(300,700));
			this.statusPanel.setMinimumSize(new Dimension(300,700));
			this.statusPanel.setPreferredSize(new Dimension(300,700));
			this.statusPanel.setAlignmentY(BOTTOM_ALIGNMENT);
			this.statusPanel.add(this.status);

			this.conteudoPanel = new JPanel();
			this.conteudoPanel.setMaximumSize(new Dimension(1200,700));
			this.conteudoPanel.setMinimumSize(new Dimension(1200,700));
			this.conteudoPanel.setLayout(new BoxLayout(this.conteudoPanel,BoxLayout.X_AXIS));
			this.conteudoPanel.add(this.statusPanel);
			this.conteudoPanel.add(this.painelResultadosPesquisa);
			//this.conteudoPanel.setBackground(Color.BLUE);
		} catch (PIException e) {
			e.printStackTrace();
		} catch (PDException e) {
			this.conteudoPanel = new JPanel();
			this.conteudoPanel.setMaximumSize(new Dimension(1200,700));
			this.conteudoPanel.setMinimumSize(new Dimension(1200,700));
			this.conteudoPanel.setLayout(new BoxLayout(this.conteudoPanel,BoxLayout.X_AXIS));
			this.conteudoPanel.add(Box.createRigidArea(new Dimension(300,700)));
			this.conteudoPanel.add(this.painelResultadosPesquisa);
			//this.conteudoPanel.setBackground(Color.BLUE);
			e.printStackTrace();
		}
		
		this.setMaximumSize(new Dimension(1200,700));
		this.setMinimumSize(new Dimension(1200,700));
		this.setVisible(true);
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));

		this.toolbar = new MyTwitterToolbar();
		this.addWindowListener(new TerminarListener());

		this.add(this.toolbar);
		this.add(this.conteudoPanel);
		
		this.repaint();
		this.setVisible(true);
		
	}
	
	public void setUsuario(String usuario){
		
		this.usuario = usuario;
		
	}

	@Override
	public MyTwitterViewManager getViewManager() {
		
		return this.viewManager;
	
	}

	@Override
	public void mostrar(boolean mostrar) {
		this.setVisible(mostrar);
	}

	@Override
	public void recarregarView() {
		
		this.carregarTimeline();
		
	}

	public MyTwitterToolbar getToolbar(){
		
		return this.toolbar;
		
	}

	public void setResultadosPesquisa(Vector<Perfil> resultados){
		
		this.resultadosPesquisa = resultados;
		
	}
	
	public MyTwitter getMyTwitter(){
		
		return this.mytwitter;
		
	}
	
}
