package com.future.web;

import com.future.pojo.User;
import com.future.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private final UserService service = new UserService();

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置request字符集，解决中文乱码问题
        request.setCharacterEncoding("utf-8");
        //1.获取用户对象
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //获取验证码
        String checkCode = request.getParameter("checkCode");
        //从session中获取程序生成的验证码
        HttpSession session = request.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");


        if ("".equals(username)) {
            if ("".equals(password)) {
                request.setAttribute("register_msg", "请输入用户名和密码");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            } else {
                request.setAttribute("register_msg", "请输入用户名");
                request.setAttribute("password", password);
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
        } else {
            if ("".equals(password)) {
                request.setAttribute("register_msg", "请输入密码");
                request.setAttribute("username", username);
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            } else {
                //1.创建对应的对象
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                //2.调用service层的方法
                boolean flag = service.register(user);
                // 判断是否注册成功
                if (flag) {
                    // 注册成功，跳转到登录界面
                    request.setAttribute("register_msg", "注册成功，请登录");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                } else {
                    // 注册失败，刷新注册界面
                    request.setAttribute("register_msg", "注册失败，用户名已存在");
                    request.getRequestDispatcher("/register.jsp").forward(request, response);
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
