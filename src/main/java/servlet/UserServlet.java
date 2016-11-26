package servlet;

import util.DB;

import javax.security.auth.message.callback.PrivateKeyCallback;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/11/26.
 */
@WebServlet(urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("isEmailExisted")) {
            isEmailExisted(req, resp);
        }
    }
    private void isEmailExisted(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String email = req.getParameter("email");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection= DB.getConnection();
            String sql="SELECT * FROM ajax_jaon.user WHERE email=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,email);
            resultSet=preparedStatement.executeQuery();
            resp.setContentType("text/html charset=UTF-8");
            Writer writer = resp.getWriter();
            if (resultSet.next()) {
                System.out.println("email existed");
                writer.write("true");
            } else {
                System.out.println("email not exist");
                writer.write("false");
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DB.close(resultSet,preparedStatement,connection);

        }


    }




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
