package universe.earth.SettingUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbTestLink {
    public static void main(String[] args) throws SQLException {
        //获取数据库连接
        Connection connection = JdbcUtil.getConnection();
        //执行的sql语句
        String sql = "select * from dynasties";
        //获取预处理对象，并给参数赋值
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            preparedStatement = connection.prepareCall(sql);
        }
        if (preparedStatement != null) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("names"));
            }
        }

        JdbcUtil.closeResource(null, preparedStatement, connection);

    }
}
