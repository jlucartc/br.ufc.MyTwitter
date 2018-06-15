package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

public class PlaceholderListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		
		JTextField campo = ((JTextField)e.getSource());
		
		if((campo.getText().equals("Digite seu cpf: ")) || (campo.getText().equals("Digite seu usuário: ") || (campo.getText().equals("Usuario: ")))){
			
			campo.setText("");
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
