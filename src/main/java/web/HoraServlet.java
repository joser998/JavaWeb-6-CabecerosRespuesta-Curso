package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/HoraServlet")
public class HoraServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Vamos a responder de esta manera
        response.setContentType("text/html;charset=UTF-8");
        
        //Indicamos que refrescamos cada 1 seg
        response.setHeader("refresh", "1");
        
        //Para obtener la fecha actual
        Date fecha = new Date();
        //Este objeto es para darle formato a nuestro objeto fecha
        SimpleDateFormat formateador = new SimpleDateFormat("'Hora actualizada' HH:mm:ss");
        //Damos formato a nuestro objeto fecha
        String horaConFormato = formateador.format(fecha);
        
        
        //Para mandar a imprimir la hora actualizada
        PrintWriter salida = response.getWriter();
        salida.print("Hora: " +horaConFormato);
        salida.close();
    }
}