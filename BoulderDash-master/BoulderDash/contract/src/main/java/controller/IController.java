package controller;

import java.sql.SQLException;

import model.IModel;
import view.IView;

/**
 * <h1>The Interface IController.</h1>
 * 
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IController {
	
	public String[][] start() throws SQLException;
	public void ControllerFacade(final IView view, final IModel model);

}
