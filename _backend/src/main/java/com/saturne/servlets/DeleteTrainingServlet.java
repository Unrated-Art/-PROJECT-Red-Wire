package com.saturne.servlets;

import com.saturne.services.ServiceCatalogue;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteTrainingServlet
 */
@WebServlet("/DeleteTrainingServlet")
public class DeleteTrainingServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public DeleteTrainingServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    System.out.println("Hello from doPost() de DeleteTrainingServlet");

    long id = Long.parseLong(request.getParameter("id"));
    ServiceCatalogue sc = new ServiceCatalogue();
    sc.deleteTraining(id);
  }
}
