/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papprojjpa;

import br.com.euemais3.dao.FilmeDAO;
import br.com.euemais3.dao.TipoContaDAO;
import br.com.euemais3.dao.UsuarioDAO;
import br.com.euemais3.model.Filme;
import br.com.euemais3.model.TipoConta;
import br.com.euemais3.model.Usuario;
import java.util.Date;

/**
 *
 * @author Flavio
 */
public class PAPProjJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            TipoContaDAO daoTipoContaDAO = new TipoContaDAO();
            UsuarioDAO daoUsuario = new UsuarioDAO();
            FilmeDAO daoFilme = new FilmeDAO();
            
            TipoConta tipoConta = new TipoConta(null, "ADM-000", "Conta de administração");
            Usuario usuario = new Usuario(null, "User1", "user", "1", new Date("10/10/2010"), tipoConta);
            Filme filme = new Filme(null, "Gravidade", "Otomar no cu", new Date("10/06/2013"), "Dirigid puta que pariu", "Não sei", new Date("01/01/01"), "Ação", "sadsd", "EUA", "English", "Colorido", "Dolby");
            
            tipoConta = daoTipoContaDAO.salvar(tipoConta);
            usuario = daoUsuario.salvar(usuario);            
            filme = daoFilme.salvar(filme);

            
            System.out.println("ID do tipo de conta salvo: " + tipoConta.getId());
            System.out.println("ID do usuario salvo: " + usuario.getId());
            System.out.println("ID do filme salvo: " + filme.getId());
            

            

            /*
             * PARA FAZER - Teste a consulta, alteração 
             * e exclusão do livro.
             */
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
