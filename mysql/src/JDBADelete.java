import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBADelete {
    public static void main(String[] args) throws SQLException {

        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/rui_mysql?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("111111");

        // 连接
        Connection connection = dataSource.getConnection();

        // 用户输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的id");
        int id = scanner.nextInt();

        // 构造语句 编译
        String sql = "delete from staff where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        System.out.println(statement);

        // 执行
        int row = statement.executeUpdate();
        System.out.println("row = " + row);

        // 关闭
        statement.close();
        connection.close();
    }
}






