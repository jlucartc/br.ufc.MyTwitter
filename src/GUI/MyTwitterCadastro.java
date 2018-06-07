package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MyTwitterCadastro extends JFrame{

	private JLabel logo;
	private JTextField usuario;
	private JButton cadastrar;
	private JButton voltar;
	private JPanel botoes;
	private JPanel logoPanel;
	
	public MyTwitterCadastro() {
		
		this.logo = new JLabel("MyTwitter");
		this.logoPanel = new JPanel();
		this.usuario = new JTextField("Digite seu usuário: ");
		this.cadastrar = new JButton("Cadastrar");
		this.voltar = new JButton("Voltar");
		this.botoes = new JPanel();	
		
		this.setMinimumSize(new Dimension(400,1200));
		//this.logoPanel.setMaximumSize(new Dimension(300,200));
		//this.logoPanel.setBackground(Color.CYAN);
		//this.logoPanel.setLayout(new BoxLayout(this.logoPanel,BoxLayout.Y_AXIS));
		//this.logo.setMaximumSize(new Dimension(300, 200));
		//this.logo.setHorizontalAlignment(SwingConstants.CENTER);
		//this.logo.setFont(new Font("Arial",Font.PLAIN,32));
		//this.logo.setAlignmentX(Component.CENTER_ALIGNMENT);
		//this.logo.setVerticalTextPosition(SwingConstants.BOTTOM);
		this.usuario.setMaximumSize(new Dimension(300,30));
		this.usuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.cadastrar.setMaximumSize(new Dimension(100,30));
		this.cadastrar.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.voltar.setMaximumSize(new Dimension(100,30));
		this.voltar.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		this.botoes.setLayout(new FlowLayout());
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		
		//this.logoPanel.add(this.logo);
		this.botoes.add(this.cadastrar);
		this.botoes.add(this.voltar);
		this.botoes.setMaximumSize(new Dimension(300,30));
		this.botoes.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//this.add(this.logoPanel);
		this.add(Box.createRigidArea(new Dimension(0,50)));
		this.add(this.usuario);
		this.add(Box.createRigidArea(new Dimension(0,100)));
		this.add(this.botoes);
		
		this.setVisible(true);
		
	}
}
