package universe.earth.SettingUtil;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ResourceBundle;

public class JdbcUtil {

    private static final Logger logger = Logger.getLogger(JdbcUtil.class);

    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    static {
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
            driver = resourceBundle.getString("driver");
            url = resourceBundle.getString("url");
            user = resourceBundle.getString("user");
            password = resourceBundle.getString("password");
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }
    }

    public static Connection getConnection() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }
        return null;
    }

    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                logger.debug(e.getMessage());
            }
        }
    }

    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                logger.debug(e.getMessage());
            }
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.debug(e.getMessage());
            }
        }
    }

    public static void closeResource(ResultSet resultSet, Statement statement, Connection connection) {
        closeResultSet(resultSet);
        closeStatement(statement);
        closeConnection(connection);
    }
}
