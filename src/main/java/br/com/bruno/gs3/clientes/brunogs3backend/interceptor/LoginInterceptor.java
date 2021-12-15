package br.com.bruno.gs3.clientes.brunogs3backend.interceptor;

import br.com.bruno.gs3.clientes.brunogs3backend.enums.TipoTransacaoEnum;
import br.com.bruno.gs3.clientes.brunogs3backend.service.impl.HistoricoService;
import br.com.bruno.gs3.clientes.brunogs3backend.service.impl.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private HistoricoService historicoService;

    @Autowired
    private UsuarioService usuarioService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        try {
//            if (handler instanceof HandlerMethod) {
//                HandlerMethod handlerMethod = (HandlerMethod) handler;
//                if(handlerMethod.getMethod().getName().equals("login")) {
//                    String login = request.getParameter("user");
//                    String senha = request.getParameter("pass");
//                    historicoService.gravaHistorico(login, TipoTransacaoEnum.LOGIN);
//                    usuarioService.getByUserPass(login, senha);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {


    }
}
