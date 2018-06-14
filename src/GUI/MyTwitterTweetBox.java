package GUI;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import excecoes.MFPException;
import excecoes.PDException;
import excecoes.PIException;
import myTwitter.MyTwitter;

public class MyTwitterTweetBox extends JPanel{

	private JButton tweetar;
	private JTextArea tweet;
	private String usuario;
	private MyTwitter mytwitter;
	
	MyTwitterTweetBox(MyTwitter mytwitter,String usuario){
		
		this.usuario = usuario;
		this.mytwitter = mytwitter;
		this.tweet = new JTextArea("Digite uma mensagem com 140 caracteres");
		this.tweetar = new JButton("Publicar");
	
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		this.setMinimumSize(new Dimension(600,100));
		this.setMaximumSize(new Dimension(600,100));
		this.setPreferredSize(new Dimension(600,100));
		
		this.tweet.setAlignmentX(CENTER_ALIGNMENT);
		this.tweetar.setAlignmentX(CENTER_ALIGNMENT);
		
		this.add(this.tweet);
		this.add(this.tweetar);
		
	}
	
	public void tweetar() throws PIException, MFPException, PDException{
		
		this.mytwitter.tweetar(this.usuario,this.tweet.getText());
		
	}
	
}
