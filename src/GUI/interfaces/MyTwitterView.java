package GUI.interfaces;

public interface MyTwitterView {

	public abstract MyTwitterViewManager getViewManager();
	
	public abstract void mostrar(boolean mostrar);
	
	public abstract void recarregarView();
	
}
