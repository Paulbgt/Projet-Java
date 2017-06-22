package model.dao;

import java.sql.CallableStatement;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * <h1>The Class ExampleDAO.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class ExampleDAO extends AbstractDAO {

    /** The sql all examples. */
    private  static String sqlAllExamples   = "{call findAllExamples()}";



	


	/** The name column index. */
    private static int    nameColumnIndex  = 2;


    /**
     * Gets the all examples.
     *
     * @return the all examples
     * @throws SQLException
     *             the SQL exception
     */
    public static  String[] getAllExamples(final int nbr, final String exemple) throws SQLException {
    	
    	sqlAllExamples = "{call findAllExamples"+exemple+"()}";
    	nameColumnIndex=nbr;
    	int x=0;
        final String[] examples = new String[40];
        final CallableStatement callStatement = prepareCall(sqlAllExamples);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();

            for (boolean isResultLeft = result.first(); isResultLeft; isResultLeft = result.next()) {
                examples[x]=result.getString(nameColumnIndex);
                x++;
            }
            result.close();
        }
        return examples;
    }
    

}
