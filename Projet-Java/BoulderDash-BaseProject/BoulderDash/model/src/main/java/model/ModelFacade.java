package model;

import java.sql.SQLException;

import model.dao.ExampleDAO;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ModelFacade implements IModel {

    /**
     * Instantiates a new model facade.
     */
    public ModelFacade() {
        super();
    }


    /*
     * (non-Javadoc)
     * @see model.IModel#getAllExamples()
     */
    @Override
    public String[] getAllExamples(int nbr) throws SQLException {
        return ExampleDAO.getAllExamples(nbr);
    }



}
