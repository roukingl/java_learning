import com.fasterxml.jackson.core.JsonToken;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlogDao {
//            +----------+--------------+------+-----+---------+----------------+
//            | Field    | Type         | Null | Key | Default | Extra          |
//            +----------+--------------+------+-----+---------+----------------+
//            | blogId   | int(11)      | NO   | PRI | NULL    | auto_increment |
//            | title    | varchar(256) | NO   |     | NULL    |                |
//            | content  | text         | NO   |     | NULL    |                |
//            | postTime | datetime     | NO   |     | NULL    |                |
//            | userId   | int(11)      | NO   |     | NULL    |                |
//            +----------+--------------+------+-----+---------+----------------+

    // 插入一篇博客
    public void insert(Blog blog) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // 1.建立连接
            connection = DBUtil.getConnection();
            // 2.构造SQL语句
            String sql = "insert into blog values (null, ?, ?, now(), ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, blog.getTitle());
            statement.setString(2, blog.getContent());
            statement.setInt(3, blog.getUserId());
            // 执行sql语句
            int ret = statement.executeUpdate();
            if (ret != 1) {
                System.out.println("博客插入失败");
            } else {
                System.out.println("博客插入成功");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }

    }

    // 删除一篇博客
    public void delete(int blogId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // 1. 建立连接
            connection = DBUtil.getConnection();
            // 2. 构造sql语句
            String sql = "delete from blog where blogId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, blogId);

            int ret = statement.executeUpdate();
            if (ret != 1) {
                System.out.println("删除博客成功");
            } else {
                System.out.println("删除博客失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    // 查询一篇博客
    public Blog selectOne(int blogId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();

            String sql = "select * from blog where blogId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, blogId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                blog.setContent(resultSet.getString("content"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blog.setUserId(resultSet.getInt("userId"));
                return blog;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }

    // 查询所有博客
    public List<Blog> selectAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Blog> list = null;
        try {
            connection = DBUtil.getConnection();

            String sql = "select * form blog";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                blog.setContent(resultSet.getString("content"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blog.setUserId(resultSet.getInt("userId"));
                list.add(blog);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }
}
