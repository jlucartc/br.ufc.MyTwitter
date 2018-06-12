package GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyTwitterPainelTimelineTweet extends JPanel{

	private JLabel autorLabel;
	private JLabel mensagemLabel;
	private String autor;
	private String mensagem;
	
	public MyTwitterPainelTimelineTweet(String autor, String mensagem) {
		
		this.autor = autor;
		this.mensagem = mensagem;
		this.autorLabel = new JLabel(this.autor);
		this.mensagemLabel = new JLabel(this.mensagem);
		
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.setMaximumSize(new Dimension(600,100));
		this.setMinimumSize(new Dimension(600,100));
		this.setPreferredSize(new Dimension(600,100));
		this.setBackground(Color.cyan);
		this.setAlignmentX(LEFT_ALIGNMENT);
		
		this.add(this.autorLabel);
		this.add(this.mensagemLabel);
		
	}
	
}
