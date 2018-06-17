package GUI.componentesHome;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import classes.Tweet;

@SuppressWarnings("serial")
public class MyTwitterTimeline extends JPanel{

	private Vector<Tweet> tweets;
	private JPanel conteudo;
	
	public MyTwitterTimeline(Vector<Tweet> tweets){
	
		this.tweets = tweets;
		this.carregarTweets();
		
	}
	
	public void setTweets(Vector<Tweet> tweets){
		
		this.tweets = tweets;
		
	}
	
	/*public void setResultados(Vector<Perfil> resultados ){
		
		this.resultados = resultados;
		
	}*/
	
	public void carregarTweets(){
		
		this.removeAll();
		
		this.conteudo = new JPanel();
	
		this.conteudo.setLayout(new BoxLayout(this.conteudo,BoxLayout.PAGE_AXIS));
		this.setLayout(new GridLayout(0,1));
		//this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.conteudo.setPreferredSize(new Dimension(600,700));
		this.setMaximumSize(new Dimension(600,600));
		this.conteudo.setBackground(Color.blue);
		
		if(this.tweets.size() == 0){
			
			JLabel aviso = new JLabel("Não há tweets");
			aviso.setFont(new Font("Arial",Font.BOLD,20));
			aviso.setHorizontalTextPosition(SwingConstants.CENTER);
			aviso.setHorizontalAlignment(SwingConstants.CENTER);
			aviso.setVerticalAlignment(SwingConstants.CENTER);
			aviso.setMaximumSize(new Dimension(600,100));
			aviso.setMinimumSize(new Dimension(600,100));
			//aviso.setBorder(BorderFactory.createLineBorder(Color.black));
			this.conteudo.add(aviso);
			this.conteudo.add(Box.createRigidArea(new Dimension(600,500)));
			this.conteudo.setBackground(Color.WHITE);
			this.conteudo.setAlignmentX(TOP_ALIGNMENT);
			this.conteudo.setAlignmentY(CENTER_ALIGNMENT);
			//this.setAlignmentX(TOP_ALIGNMENT);
			//this.setAlignmentY(CENTER_ALIGNMENT);
			this.add(this.conteudo);
			//this.setBorder(BorderFactory.createLineBorder(Color.black));
			
		}else{
			
			Iterator<Tweet> iterator = this.tweets.iterator();
			
			while(iterator.hasNext()) {
				
				Tweet tweet = iterator.next();
				this.conteudo.add(new MyTwitterTimelineItem(tweet.getUsuario(),tweet.getMensagem()));
				
			}
			
			JScrollPane scroll = new JScrollPane(this.conteudo);
			scroll.setMaximumSize(new Dimension(600,600));
			//scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			this.add(scroll);
			this.setAlignmentX(TOP_ALIGNMENT);
			this.setAlignmentY(CENTER_ALIGNMENT);
			
		}
		
	}
	
	/*public void carregarResultadosPesquisa(){
		
		this.removeAll();
		
		this.conteudo = new JPanel();
	
		this.conteudo.setLayout(new BoxLayout(this.conteudo,BoxLayout.PAGE_AXIS));
		this.setLayout(new GridLayout(0,1));
		//this.conteudo.setPreferredSize(new Dimension(600,this.tweets.size()));
		this.setMaximumSize(new Dimension(600,700));
		this.conteudo.setBackground(Color.blue);
		
		if(this.resultados.size() == 0){
			
			this.conteudo.add(Box.createRigidArea(new Dimension(600,700)));
			this.conteudo.setBackground(Color.WHITE);
			
			this.add(this.conteudo);
			
		}else{
			
			Iterator<Perfil> iterator = this.resultados.iterator();
			
			while(iterator.hasNext()) {
				
				Perfil perfil = iterator.next();
				this.conteudo.add(new MyTwitterResultadosPesquisa(perfil.getUsuario(),perfil.getMensagem()));
				
			}
			
			JScrollPane scroll = new JScrollPane(this.conteudo);
			scroll.setMaximumSize(new Dimension(600,700));
			//scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			this.add(scroll);
			
		}
		
	}*/
}
