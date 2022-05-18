package com.future.web;

import com.future.pojo.User;
import com.future.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private final UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        //调用对应的Service进行查询
        User user = service.login(username, password);
        //判断
        if (user.getUsername() != null) {
            if (user.getPassword() != null) {
                //判断用户是否勾选“记住我”
                //这样写判断形式的好处是能够有效防止空指针异常
                if ("1".equals(remember)) {
                    //1、发送cookie
                    //创建对应的Cookie对象
                    Cookie c_username = new Cookie("username", username);
                    Cookie c_password = new Cookie("password", password);
                    //设置Cookie的存活时间，这里就以存活时间为一天为例
                    c_username.setMaxAge(60 * 60 * 24);
                    c_password.setMaxAge(60 * 60 * 24);
                    //2、发送Cookie
                    response.addCookie(c_username);
                    response.addCookie(c_password);
                }
                //登录成功直接重定向就行
                //将登录成功后的额对象的信息转存到session中
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                //为什么是重定向？因为两次请求之间没有任何数要共享，所以只需要重定向就行
                //这里不能用转发，因为转发只能在同一个request中从servlet到jsp中，而现在需要从一个servlet到另一个servlet，需要用另一个servlet中。
                response.sendRedirect("/selectAllServlet");
            } else {
                //将登录失败信息存储到request中
                request.setAttribute("login_msg", "请输入密码");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else {
            //将登录失败信息存储到request中
            request.setAttribute("login_msg", "请输入用户名");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
