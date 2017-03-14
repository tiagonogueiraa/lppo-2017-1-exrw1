package br.cesjf.lppo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//http://localhost:8080/lppo-2017-1-exrw1/lista.html
@WebServlet(name = "ListaRegistrosServlet", urlPatterns = {"/lista.html"})
public class ListaRegistrosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Contato> contatos = new ArrayList<>();

        try {
            //Pegar os dados do banco
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1", "usuario", "senha");
            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery("SELECT * FROM contato");
            while(resultado.next()){
                Contato contatoAtual = new Contato();
                contatoAtual.setId(resultado.getLong("id"));
                contatoAtual.setNome(resultado.getString("nome"));
                contatoAtual.setSobrenome(resultado.getString("sobrenome"));
                contatoAtual.setTelefone(resultado.getString("telefone"));
                contatos.add(contatoAtual);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaRegistrosServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaRegistrosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("pessoas", contatos);
        request.getRequestDispatcher("WEB-INF/lista-registros.jsp").forward(request, response);
    }

}
