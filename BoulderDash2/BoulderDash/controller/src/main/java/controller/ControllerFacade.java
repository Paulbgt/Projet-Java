package controller;

import java.sql.SQLException;

import model.IModel;
import view.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController {

    /** The view. */
    private final IView  view;

    /** The model. */
    private final IModel model;

    
    
    
    String[][] tbl = new String[40][30];
    
    
    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
    }
    
    

    /**
     * Start.
     * @return 
     *
     * @throws SQLException
     *             the SQL exception
     */
    public String[][] start(String exemple) throws SQLException {

        String[] examples = new String[41];
		for(int x=2; x<42; x++){examples = this.getModel().getAllExamples(x,exemple);
		for(int y=0; y<30; y++){tbl[x-2][y]=examples[y];}
		}

		
        return tbl;
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    public IView getView() {
        return this.view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }
}
