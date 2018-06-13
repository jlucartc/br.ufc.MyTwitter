package GUI;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MyTwitterTweetBox extends JPanel{

	private JButton tweetar;
	private JTextArea tweet;
	
	MyTwitterTweetBox(){
		
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
	
	public String getMensagem(){
		
		return this.tweet.getText();
		
	}
	
}
