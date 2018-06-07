package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MyTwitterLogin extends JFrame{

	private JLabel logo;
	private JPanel logoPanel;
	private JTextField usuario;
	private JButton confirmar;
	private JButton cadastrar;
	
	public MyTwitterLogin() {
		
		this.logo = new JLabel("MyTwitter");
		this.logoPanel = new JPanel();
		this.usuario = new JTextField("Usuario: ");
		this.confirmar = new JButton("Ir");
		this.cadastrar = new JButton("Cadastre-se");
		
		this.setMinimumSize(new Dimension(400,1200));
		this.logoPanel.setMaximumSize(new Dimension(300,200));
		this.logoPanel.setLayout(new BoxLayout(this.logoPanel,BoxLayout.Y_AXIS));
		this.logoPanel.setBackground(Color.CYAN);
		this.logo.setMaximumSize(new Dimension(300, 200));
		this.logo.setHorizontalAlignment(SwingConstants.CENTER);
		this.logo.setFont(new Font("Arial",Font.PLAIN,32));
		this.logo.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.usuario.setMaximumSize(new Dimension(300,30));
		this.usuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.confirmar.setMaximumSize(new Dimension(100,30));
		this.confirmar.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.cadastrar.setMaximumSize(new Dimension(300,30));
		this.cadastrar.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		
		this.logoPanel.add(this.logo);
		
		this.add(this.logoPanel);
		this.add(Box.createRigidArea(new Dimension(0,50)));
		this.add(this.usuario);
		this.add(Box.createRigidArea(new Dimension(0,50)));
		this.add(this.confirmar);
		this.add(Box.createRigidArea(new Dimension(0,100)));
		this.add(this.cadastrar);
		
		this.setVisible(true);
		
	}


}
