package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/GeneracionExcelServlet")
    public class GeneracionExcelServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Indicamos el tipo de respuesta al navegador
        //Respondemos con un archivo de este tipo en este caso Excel
        response.setContentType("application/vnd.ms-excel");
        
        //Este es un ejemplo de que se puede responder tambien con un Excel y no solo con mas
        //contenido de tipo HTML
        /*Para un uso mas profesional de excel se puede usar poi.apache.org */
        response.setHeader("Content-Disposition", "attachment;filename=excelEjemplo.xls");
        
        //Esto es para que siempre que demos clic en el link se genere informacion nueva
        //Esta es una instruccion para que el navegador no guarde cache, ya que por default el 
        //navegador guarda cache
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        
        //Para que se este actualizando inmediatamente
        response.setDateHeader("Expires", -1);
        
        
        //Desplegamos informacion al cliente
        PrintWriter salida = response.getWriter();
        salida.println("\tValores");
        salida.println("\t1");
        salida.println("\t2");
        salida.println("Total\t=SUMA(B2+B3)");
        salida.close();
    }
}