package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;
import java.util.List;

//DB Browser
public class DBStepDefs {
    @Given("user connect to the application database")
    public void user_connect_to_the_application_database() {
        DBUtils.createConnection();
    }
    @Given("user gets the column {string} from table {string}")
    public void user_gets_the_column_from_table(String column, String table) {
        String query = "SELECT "+column+" FROM "+table;
        DBUtils.executeQuery(query);
    }
    @Given("user reads all of the column {string} data")
    public void user_reads_all_of_the_column_data(String column) throws Exception {
        //next() is going to the next row
        DBUtils.getResultset().next();
        //ı am on the 1st column
        //get object(column) -> return the data on that column
        Object column1 = DBUtils.getResultset().getObject(column);
        System.out.println(column1);
        //printing all ssn until there is next element  DBUtils.getResultset().next()
//        while (DBUtils.getResultset().next()){
//            Object currentRowData = DBUtils.getResultset().getObject(column);
//            System.out.println(currentRowData);
//        }
        System.out.println(DBUtils.getRowCount());
    }
    @Then("user close the connection")
    public void user_close_the_connection() {
        DBUtils.closeConnection();
    }
    @Given("verify table {string} and column {string} contains {string}")
    public void verify_table_and_column_contains(String table, String column, String data) {
        String query = "SELECT "+column+" FROM "+table;
        List<Object> allColumnData = DBUtils.getColumnData(query,column);
        System.out.println(allColumnData);
        Assert.assertTrue(allColumnData.contains(data));
        String query01 = "SELECT "+column+" FROM "+table;
        List<Object> abidinData = DBUtils.getColumnData(query01,column);
        System.out.println(abidinData);
    }
    @Given("verify table {string} and column {string}")
    public void verify_table_and_column(String table, String column) {
        String query = "SELECT * FROM "+table;
        List<String> getColumnNames = DBUtils.getColumnNames(query);
        Assert.assertTrue(getColumnNames.contains(column));
    }
}
