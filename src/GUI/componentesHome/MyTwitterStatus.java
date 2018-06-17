package GUI.componentesHome;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyTwitterStatus extends JPanel{

	private JLabel usuarioLabel;
	private JLabel seguidoresLabel;
	private JLabel seguidosLabel;
	private JLabel tweetsLabel;
	private JLabel seguidoresQuantidadeLabel;
	private JLabel seguidosQuantidadeLabel;
	private JLabel tweetsQuantidadeLabel;
	private JPanel usuarioLabelPanel;
	private JPanel statusLabelsPanel;
	private JPanel statusQuantidadesPanel;
	
	public MyTwitterStatus(String usuario, int seguidores, int seguidos, int tweets){
		
		this.usuarioLabel = new JLabel(usuario);
		this.seguidoresLabel = new JLabel("Seguidores");
		this.seguidosLabel = new JLabel("Seguidos");
		this.tweetsLabel = new JLabel("Tweets");
		this.seguidoresQuantidadeLabel = new JLabel(Integer.toString(seguidores));
		this.seguidosQuantidadeLabel = new JLabel(Integer.toString(seguidos));
		this.tweetsQuantidadeLabel = new JLabel(Integer.toString(tweets));
		this.usuarioLabelPanel = new JPanel();
		this.statusLabelsPanel = new JPanel();
		this.statusQuantidadesPanel = new JPanel();
		
		this.setMaximumSize(new Dimension(300,210));
		this.setMinimumSize(new Dimension(300,210));
		this.setPreferredSize(new Dimension(300,210));
		this.setAlignmentY(TOP_ALIGNMENT);
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		this.usuarioLabel.setMaximumSize(new Dimension(100,30));
		this.usuarioLabel.setMinimumSize(new Dimension(100,30));
		this.usuarioLabel.setFont(new Font("Arial",Font.PLAIN,28));
		this.seguidoresLabel.setMaximumSize(new Dimension(100,30));
		this.seguidoresLabel.setMinimumSize(new Dimension(100,30));
		this.seguidoresLabel.setFont(new Font("Arial",Font.BOLD,20));
		this.seguidosLabel.setMaximumSize(new Dimension(100,30));
		this.seguidosLabel.setMinimumSize(new Dimension(100,30));
		this.seguidosLabel.setFont(new Font("Arial",Font.BOLD,20));
		this.tweetsLabel.setMaximumSize(new Dimension(100,30));
		this.tweetsLabel.setMinimumSize(new Dimension(100,30));
		this.tweetsLabel.setFont(new Font("Arial",Font.BOLD,20));
		this.seguidoresQuantidadeLabel.setMaximumSize(new Dimension(100,30));
		this.seguidoresQuantidadeLabel.setMinimumSize(new Dimension(100,30));
		this.seguidoresQuantidadeLabel.setFont(new Font("Arial",Font.PLAIN,16));
		this.seguidosQuantidadeLabel.setMinimumSize(new Dimension(100,30));
		this.seguidosQuantidadeLabel.setMaximumSize(new Dimension(100,30));
		this.seguidosQuantidadeLabel.setFont(new Font("Arial",Font.PLAIN,16));
		this.tweetsQuantidadeLabel.setMaximumSize(new Dimension(100,30));
		this.tweetsQuantidadeLabel.setMinimumSize(new Dimension(100,30));
		this.tweetsQuantidadeLabel.setFont(new Font("Arial",Font.PLAIN,16));
		
		this.usuarioLabelPanel.setLayout(new FlowLayout());
		this.statusLabelsPanel.setLayout(new FlowLayout());
		this.statusQuantidadesPanel.setLayout(new FlowLayout());
		this.usuarioLabelPanel.setMaximumSize(new Dimension(400,100));
		this.usuarioLabelPanel.setMinimumSize(new Dimension(400,100));
		this.statusLabelsPanel.setMaximumSize(new Dimension(400,50));
		this.statusLabelsPanel.setMinimumSize(new Dimension(400,50));
		this.statusQuantidadesPanel.setMinimumSize(new Dimension(400,50));
		this.statusQuantidadesPanel.setMaximumSize(new Dimension(400,50));
		
		this.usuarioLabelPanel.add(this.usuarioLabel);
		//this.usuarioLabelPanel.setBackground(Color.CYAN);
		this.statusLabelsPanel.add(this.seguidoresLabel);
		this.statusLabelsPanel.add(this.seguidosLabel);
		this.statusLabelsPanel.add(this.tweetsLabel);
		this.statusQuantidadesPanel.add(this.seguidoresQuantidadeLabel);
		this.statusQuantidadesPanel.add(this.seguidosQuantidadeLabel);
		this.statusQuantidadesPanel.add(this.tweetsQuantidadeLabel);
		
		this.add(Box.createRigidArea(new Dimension(300,10)));
		this.add(this.usuarioLabelPanel);
		this.add(this.statusLabelsPanel);
		this.add(this.statusQuantidadesPanel);
	}
	
}
