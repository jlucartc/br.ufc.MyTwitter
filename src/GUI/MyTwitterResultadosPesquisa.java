package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import classes.Perfil;

public class MyTwitterResultadosPesquisa extends JPanel{

	private Vector<Perfil> perfis;
	private JPanel conteudo;
	
	MyTwitterResultadosPesquisa(Vector<Perfil> perfis){
		
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
			
			this.conteudo.add(label);
			this.conteudo.add(Box.createRigidArea(new Dimension(600,500)));
			
			
		}
		
	}
	
}
