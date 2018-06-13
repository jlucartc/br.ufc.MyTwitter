package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyTwitterResultadosPesquisaItem extends JPanel{

	private JLabel usuarioLabel;
	private JLabel seguidoresLabel;
	
	MyTwitterResultadosPesquisaItem(String usuario, int seguidores){
		
		this.usuarioLabel = new JLabel(usuario);
		this.seguidoresLabel = new JLabel(Integer.toString(seguidores)+" seguidores");
		
		this.usuarioLabel.setFont(new Font("Arial",Font.PLAIN,20));
		this.seguidoresLabel.setFont(new Font("Arial",Font.PLAIN,14));
		
		this.setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
		this.setMaximumSize(new Dimension(600,100));
		this.setMinimumSize(new Dimension(600,100));
		this.setPreferredSize(new Dimension(600,100));
		this.setBackground(Color.cyan);
		this.setAlignmentX(LEFT_ALIGNMENT);
		
		this.add(this.usuarioLabel);
		this.add(Box.createRigidArea(new Dimension(20,0)));
		this.add(this.seguidoresLabel);
		
	}
	
}
