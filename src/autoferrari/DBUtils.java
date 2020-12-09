package autoferrari;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.*;

public class DBUtils {
    private static String     driverClassName = "org.postgresql.Driver" ;
    private static String     url = "jdbc:postgresql://dblabs.it.teithe.gr:5432/it185269" ;
    private static Connection conn = null;
    private static String     username = "it185269";
    private static String     passwd = "dr6976064831";
    
    public static void dbConnect() throws SQLException, ClassNotFoundException{
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your driver?");
            e.printStackTrace();
            throw e;
        }
        
        System.out.println("Postgres Driver Registered!");
        
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console " + e);
            e.printStackTrace();
            throw e;
        }
    }
    
    public static void dbDisconnect() throws SQLException {
        try {
            if (conn != null && !conn.isClosed())
                conn.close();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static ResultSet dbExecuteQueryClients() throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        ResultSet resultSet = null;
        CachedRowSetImpl crs = null;
        try {
            dbConnect();
            System.out.println("Select statement: clients \n");
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery("SELECT id,name,surname,phone from clients");
            crs = new CachedRowSetImpl();
            crs.populate(resultSet);
        } catch (SQLException e) {
            System.out.println("Problem occured at executeQuery operation: " + e);
            throw e;
        } finally {
            if (resultSet != null)
                resultSet.close();
            if (stmt != null)
                stmt.close();
            dbDisconnect();
        }
        return crs;
    }
    
    public static ResultSet dbExecuteQueryCars() throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        ResultSet resultSet = null;
        //CachedRowSetImpl crs = null;
        try {
            dbConnect();
            System.out.println("Select statement: cars \n");
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery("SELECT constructor,model,release_date,availability,color,cubism,fuel,price "
                    + "from cars");
            //crs = new CachedRowSetImpl();
            //crs.populate(resultSet);
        } catch (SQLException e) {
            System.out.println("Problem occured at executeQuery operation: " + e);
            throw e;
        } finally {
            //if (resultSet != null)
            //    resultSet.close();
            if (stmt != null)
                stmt.close();
            dbDisconnect();
        }
        return resultSet;
    }
    
    public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        ResultSet resultSet = null;
        CachedRowSetImpl crs = null;
        try {
            dbConnect();
            System.out.println("Select statement: " + queryStmt + "\n");
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(queryStmt);
            crs = new CachedRowSetImpl();
            crs.populate(resultSet);
        } catch (SQLException e) {
            System.out.println("Problem occured at executeQuery operation: " + e);
            throw e;
        } finally {
            if (resultSet != null)
                resultSet.close();
            if (stmt != null)
                stmt.close();
            dbDisconnect();
        }
        return crs;
    }
    
    public static ResultSet dbSearchByConstr(String constr) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        CachedRowSetImpl crs = null;
        try {
            dbConnect();
            System.out.println("Select statement: " + constr + "\n");
            stmt = conn.prepareStatement("SELECT constructor,model,release_date,availability,color,cubism,fuel,price "
                    + "from cars where constructor=?");
            stmt.setString(1, constr);
            resultSet = stmt.executeQuery();
            crs = new CachedRowSetImpl();
            crs.populate(resultSet);
        } catch (SQLException e) {
            System.out.println("Problem occured at executeQuery operation: " + e);
            throw e;
        } finally {
            if (resultSet != null)
                resultSet.close();
            if (stmt != null)
                stmt.close();
            dbDisconnect();
        }
        return crs;
    }
    
    public static ResultSet dbSearchByModel(String model) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        CachedRowSetImpl crs = null;
        try {
            dbConnect();
            System.out.println("Select statement: " + model + "\n");
            stmt = conn.prepareStatement("SELECT constructor,model,release_date,availability,color,cubism,fuel,price "
                    + "from cars where model=?");
            stmt.setString(1, model);
            resultSet = stmt.executeQuery();
            crs = new CachedRowSetImpl();
            crs.populate(resultSet);
        } catch (SQLException e) {
            System.out.println("Problem occured at executeQuery operation: " + e);
            throw e;
        } finally {
            if (resultSet != null)
                resultSet.close();
            if (stmt != null)
                stmt.close();
            dbDisconnect();
        }
        return crs;
    }
    
    
    public static void dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        try {
            dbConnect();
            stmt = conn.createStatement();
            stmt.executeQuery(sqlStmt);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeUpdate operation: " + e);
            throw e;
        } finally {
            if (stmt != null)
                stmt.close();
            dbDisconnect();
        }
    }
}
