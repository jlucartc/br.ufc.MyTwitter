package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyTwitterPainelStatus extends JPanel{

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
	
	public MyTwitterPainelStatus(String usuario, int seguidores, int seguidos, int tweets){
		
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
		
		this.setMaximumSize(new Dimension(300,500));
		this.setMinimumSize(new Dimension(300,500));
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		this.usuarioLabel.setMaximumSize(new Dimension(100,30));
		this.usuarioLabel.setMinimumSize(new Dimension(100,30));
		this.seguidoresLabel.setMaximumSize(new Dimension(100,30));
		this.seguidoresLabel.setMinimumSize(new Dimension(100,30));
		this.seguidosLabel.setMaximumSize(new Dimension(100,30));
		this.seguidosLabel.setMinimumSize(new Dimension(100,30));
		this.tweetsLabel.setMaximumSize(new Dimension(100,30));
		this.tweetsLabel.setMinimumSize(new Dimension(100,30));
		this.seguidoresQuantidadeLabel.setMaximumSize(new Dimension(100,30));
		this.seguidoresQuantidadeLabel.setMinimumSize(new Dimension(100,30));
		this.seguidosQuantidadeLabel.setMinimumSize(new Dimension(100,30));
		this.seguidosQuantidadeLabel.setMaximumSize(new Dimension(100,30));
		this.tweetsQuantidadeLabel.setMaximumSize(new Dimension(100,30));
		this.tweetsQuantidadeLabel.setMinimumSize(new Dimension(100,30));
		
		this.usuarioLabelPanel.setLayout(new FlowLayout());
		this.statusLabelsPanel.setLayout(new FlowLayout());
		this.statusQuantidadesPanel.setLayout(new FlowLayout());
		this.usuarioLabelPanel.setMaximumSize(new Dimension(300,200));
		this.usuarioLabelPanel.setMinimumSize(new Dimension(300,200));
		this.statusLabelsPanel.setMaximumSize(new Dimension(300,150));
		this.statusLabelsPanel.setMinimumSize(new Dimension(300,150));
		this.statusQuantidadesPanel.setMinimumSize(new Dimension(300,150));
		this.statusQuantidadesPanel.setMaximumSize(new Dimension(300,150));
		
		this.usuarioLabelPanel.add(this.usuarioLabel);
		this.usuarioLabelPanel.setBackground(Color.CYAN);
		this.statusLabelsPanel.add(this.seguidoresLabel);
		this.statusLabelsPanel.add(this.seguidosLabel);
		this.statusLabelsPanel.add(this.tweetsLabel);
		this.statusQuantidadesPanel.add(this.seguidoresQuantidadeLabel);
		this.statusQuantidadesPanel.add(this.seguidosQuantidadeLabel);
		this.statusQuantidadesPanel.add(this.tweetsQuantidadeLabel);
		
		this.add(this.usuarioLabelPanel);
		this.add(this.statusLabelsPanel);
		this.add(this.statusQuantidadesPanel);
	}
	
}
