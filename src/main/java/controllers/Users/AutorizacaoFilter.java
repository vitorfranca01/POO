/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Users;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.UserService;

/**
 *
 * @author Beto
 */
@WebFilter(filterName = "AutorizacaoFilter",
	urlPatterns = {"/protegido/*"},
	servletNames = {"HomeController", "ProductManagerController"})
public class AutorizacaoFilter implements Filter{
    
    @Override
  public void doFilter(ServletRequest request,
	  ServletResponse response, FilterChain chain)
	  throws IOException, ServletException {
      
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;

    HttpSession sessao = httpRequest.getSession();

    if (!UserService.isLogged(sessao)) {
      httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
      return;
    }

    User usuario = UserService.findById((int) sessao.getAttribute("UserId"));
    
    if (verificarPermissao(usuario, httpRequest, httpResponse)) {
      // Significa que usuario tem permissao de acesso
      chain.doFilter(request, response);
    } else {
      // Usuario nao tem permissao - mostra tela de erro
      httpResponse.sendRedirect(httpRequest.getContextPath() + "/erro-nao-autorizado.jsp");
    }

  }

  @Override
  public void destroy() {
  }

  @Override
  public void init(FilterConfig filterConfig) {

  }

  private boolean verificarPermissao(User usuario,
	  HttpServletRequest request,
	  HttpServletResponse response) {

    String paginaAcessada = request.getRequestURI();
    String pagina = paginaAcessada.replace(request.getContextPath(), "");

    if (pagina.startsWith("/home")) {
        return true;
    } else if (usuario.getGroup() == 1 || usuario.getGroup() == 2) {
        return true;
    }
    return false;
  }
}
