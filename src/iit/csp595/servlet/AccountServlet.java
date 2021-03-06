package iit.csp595.servlet;

import iit.csp595.bean.GenericPageBean;
import iit.csp595.domain.object.Order;
import iit.csp595.service.OrderService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccountServlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    long productId = ServletUtils.toLong(request.getParameter("id"), -1);
    int nextPage = ServletUtils.toInt(request.getParameter("p"), 1);
    int sortTypeId = ServletUtils.toInt(request.getParameter("s"));

    GenericPageBean<Order> bean = new OrderService(productId, nextPage, sortTypeId).createBean();

    request.setAttribute("bean", bean);
    request.getRequestDispatcher("/WEB-INF/template.jsp").forward(request, response);

  }
}
