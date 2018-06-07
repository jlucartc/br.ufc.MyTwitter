package GUI;

import totalcross.ui.MainWindow;

public class Main {

	public static void main(String[] args) {
		try {
	
			MyTwitterLogin login = new MyTwitterLogin();
			MyTwitterCadastro janela = new MyTwitterCadastro();
			MyTwitterHome home = new MyTwitterHome();
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
