package model;

import java.sql.SQLException;



/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * 
 * 
 * @version 1.0
 */
public interface IModel {


    String[] getAllExamples(int nbr,  String exemple) throws SQLException;
}
