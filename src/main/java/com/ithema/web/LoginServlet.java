package com.ithema.web;

import com.ithema.pojo.User;
import com.ithema.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private final UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //调用对应的Service进行查询
        User user = service.login(username, password);
        //判断
        if (user != null) {
            //登录成功直接重定向就行
            //将登录成功后的额对象的信息转存到session中
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            //为什么是重定向？因为两次请求之间没有任何数要共享，所以只需要重定向就行
            //这里不能用转发，因为转发只能在同一个request中从servlet到jsp中，而现在需要从一个servlet到另一个servlet，需要用另一个servlet中。
            response.sendRedirect("/selectAllServlet");
        } else {
            //将登录失败信息存储到request中
            request.setAttribute("login_msg", "用户名或密码错误");

            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
