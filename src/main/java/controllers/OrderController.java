package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Order;
import services.SaleService;

/**
 *
 * @author Vitor
 */
@WebServlet(name = "OrderController", urlPatterns = {"/Checkout", "/checkout"})
public class OrderController extends HttpServlet {
    
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            RequestDispatcher rd = request.getRequestDispatcher("/views/checkout/index.jsp");
            rd.forward(request,response);
        }
    }
     
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*request.setAttribute("sales", SaleService.getAll());
        String action = request.getParameter("action");
        if(action.equals("remove")) {
            int id = Integer.parseInt(request.getParameter("id"));
            SaleService.remove(id);
        }*/
        processRequest(request, response);
    }
    
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        if(action.equals("create")) {
            /*Order sale = new Order();
            sale.setValorTotal(Double.parseDouble(request.getParameter("valorTotal")));
            sale.setQtdProdutos(Integer.parseInt(request.getParameter("QtdProdutos")));
            sale.setMetodoPag(Integer.parseInt(request.getParameter("MetodoPag")));
            sale.setCliente(request.getParameter("valorvenda"));
            
            SaleService.insert(sale);*/
        } else if (action.equals("remove")){
            int id = Integer.parseInt(request.getParameter("id"));
            
            SaleService.remove(id);
        }
        processRequest(request, response);       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
