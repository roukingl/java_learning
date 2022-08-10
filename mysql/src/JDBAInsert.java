import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBAInsert {

    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/rui_mysql?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("111111");

        Connection connection = dataSource.getConnection();

        // 用户输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要插入的id: ");
        int id = scanner.nextInt();
        System.out.println("请输入你要插入的姓名: ");
        String name = scanner.next();

        String sql = "insert into staff values ( ? , ? , '121231231', 'sdf')";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setString(2, name);
        System.out.println("statement = " + statement);

        int row = statement.executeUpdate();
        System.out.println("row = " + row);

        statement.close();
        connection.close();
    }
}
