package GUI.componentesHome;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import classes.Perfil;

@SuppressWarnings("serial")
public class MyTwitterResultadosPesquisa extends JPanel{

	private Vector<Perfil> perfis;
	private JPanel conteudo;
	
	public MyTwitterResultadosPesquisa(Vector<Perfil> perfis){
		
		this.conteudo = new JPanel();
		
		this.perfis = perfis;
		
		this.conteudo.setLayout(new BoxLayout(this.conteudo,BoxLayout.PAGE_AXIS));
		
		if(this.perfis.size() > 0) {
			
			Iterator<Perfil> i = this.perfis.iterator();
			
			while(i.hasNext()){
				
				Perfil perfil = i.next();
				
				this.conteudo.add(new MyTwitterResultadosPesquisaItem(perfil.getUsuario(),perfil.getSeguidores().size()));
				
			}
			
			
		}else {
			
			JLabel label = new JLabel("Sem resultados");
			label.setFont(new Font("Arial",Font.BOLD,20));
			label.setMaximumSize(new Dimension(600,200));
			label.setMinimumSize(new Dimension(600,200));
			label.setPreferredSize(new Dimension(600,200));
			label.setHorizontalTextPosition(SwingConstants.CENTER);
			label.setAlignmentX(LEFT_ALIGNMENT);
			label.setAlignmentY(TOP_ALIGNMENT);
			//label.setBackground(Color.gray);
			
			this.conteudo.add(label);
			this.conteudo.add(Box.createRigidArea(new Dimension(600,600)));
			//this.conteudo.setBackground(Color.MAGENTA);
			
		}
		this.setMaximumSize(new Dimension(600,600));
		this.setMinimumSize(new Dimension(600,600));
		this.setPreferredSize(new Dimension(600,600));
		JScrollPane scroll = new JScrollPane(this.conteudo);
		scroll.setPreferredSize(new Dimension(600,600));
		
		this.add(conteudo);
		this.setAlignmentY(TOP_ALIGNMENT);
		this.setAlignmentX(CENTER_ALIGNMENT);
		//this.setBackground(Color.CYAN);
		
	}
	
}
