package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyTwitterPainelToolbar extends JPanel{

	private JButton inicio;
	private JButton perfil;
	private JButton logout;
	private JPanel menu;
	private JTextField campoBusca;
	private JButton buscar;
	private JPanel pesquisa;

	public MyTwitterPainelToolbar(){
		
		this.inicio = new JButton("Home");
		this.perfil = new JButton("Perfil");
		this.logout = new JButton("Sair");
		this.menu = new JPanel();
		this.campoBusca = new JTextField("Pesquisar");
		this.buscar = new JButton("Ir");
		this.pesquisa = new JPanel();
		
		this.setMaximumSize(new Dimension(1200,70));
		this.inicio.setMinimumSize(new Dimension(100,30));
		this.inicio.setMaximumSize(new Dimension(100,30));
		this.perfil.setMinimumSize(new Dimension(100,30));
		this.perfil.setMaximumSize(new Dimension(100,30));
		this.logout.setMinimumSize(new Dimension(100,30));
		this.logout.setMaximumSize(new Dimension(100,30));
		this.menu.setMaximumSize(new Dimension(300,30));
		this.menu.setMinimumSize(new Dimension(300,30));
		this.campoBusca.setMinimumSize(new Dimension(250,30));
		this.campoBusca.setMaximumSize(new Dimension(250,30));
		this.buscar.setMinimumSize(new Dimension(50,30));
		this.buscar.setMaximumSize(new Dimension(50,30));
		this.pesquisa.setMaximumSize(new Dimension(300,30));
		this.pesquisa.setMinimumSize(new Dimension(300,30));
		
		this.setLayout(new GridLayout(1,4));
		this.menu.setLayout(new FlowLayout());
		this.pesquisa.setLayout(new FlowLayout());
		
		this.menu.add(this.inicio);
		this.menu.add(this.perfil);
		this.menu.add(this.logout);
		this.menu.setBackground(Color.RED);
		this.pesquisa.add(this.campoBusca);
		this.pesquisa.add(this.buscar);
		this.pesquisa.setBackground(Color.BLUE);
		
		
		this.campoBusca.setAlignmentY(Component.CENTER_ALIGNMENT);
		this.buscar.setAlignmentY(Component.CENTER_ALIGNMENT);
		this.inicio.setAlignmentY(Component.CENTER_ALIGNMENT);
		this.perfil.setAlignmentY(Component.CENTER_ALIGNMENT);
		this.logout.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		this.setBackground(Color.WHITE);
		this.add(this.menu,BorderLayout.EAST);
		this.add(Box.createRigidArea(new Dimension(300,30)));
		this.add(Box.createRigidArea(new Dimension(300,30)));
		this.add(this.pesquisa,BorderLayout.WEST);
		
		this.menu.setAlignmentY(Component.CENTER_ALIGNMENT);
		this.pesquisa.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		
		
	}
	
}
