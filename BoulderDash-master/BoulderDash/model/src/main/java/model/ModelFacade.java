package model;

import java.sql.SQLException;

import model.dao.ExampleDAO;

/**
 * <h1>The Class ExampleDAO.</h1>
 *
 * @author Group 5 Arras
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
    public String[] getAllExamples(int nbr, String exemple) throws SQLException {
        return ExampleDAO.getAllExamples(nbr,exemple);
    }



}
