/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

import exeption.ErroSistema;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Joedson
 */
public class Os2Controller {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    
    public Os2Controller(){
        
        emf = Persistence.createEntityManagerFactory("os2");
        em = emf.createEntityManager();
    }

    public void salvar (Os2 os2) throws ErroSistema{
        
//        System.out.println("teste 02 - > Cliente: "+     os2.getCliente());
//        System.out.println("teste 02 - > Tecnico: "+     os2.getTecnico());
//        System.out.println("teste 03 - > Tipo: "+        os2.getTipo());        
//        
//        os2.setCliente  (os2.getCliente() .substring(0, os2.getCliente()  .indexOf("-")));
//        os2.setTecnico  (os2.getTecnico() .substring(0, os2.getTecnico()  .indexOf("-")));
//        os2.setTipo     (os2.getTipo()    .substring(0, os2.getTipo()     .indexOf("-")));
//        
//        System.out.println("teste 01 - > Cliente: "+     os2.getCliente());
//        System.out.println("teste 01 - > Tecnico: "+     os2.getTecnico());
//        System.out.println("teste 01 - > Tipo: "+        os2.getTipo());
        
        try{
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date data = formato.parse(os2.getDataemissao());
            os2.setDataemissao(new SimpleDateFormat("yyyy-MM-dd").format(data));
            System.out.println("Dataemissao: "+        os2.getDataemissao());    
        }catch(ParseException e){
            System.out.println("e: "+e);
        }
        em.getTransaction().begin();
        em.merge(os2);
        em.getTransaction().commit();
        emf.close();
        
        }
    
    
        // atualizar pelo Codigo da OS
        public void atualizar (Os2 os2) throws ErroSistema{
            
            System.out.println("os2.getCodigo(): "+os2.getCodigo());
            
        em.getTransaction().begin();
        Query q = em.createNativeQuery("update os2 set status = 'CANCELADA' where  codigo='"+os2.getCodigo()+"'");
        q.executeUpdate();
        em.getTransaction().commit();
        emf.close();
        
        }
        
        public void remover (Os2 os2){
        em.getTransaction().begin();
        Query q = em.createNativeQuery("delete from os2 where  codigo = '"+os2.getCodigo()+"'");
        q.executeUpdate();
        em.getTransaction().commit();
        emf.close();
    }    
        
        
    public List<Os2> listar() throws ErroSistema{
        em.getTransaction().begin();
        
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        
        // Query q = em.createQuery("select os2 from Os2 os2 WHERE os2.codigo = (select MAX(os2.codigo) from Os2 os2)");
        Query q = em.createQuery("select os2 from Os2 os2");
        
        List<Os2> lista = q.getResultList();
        em.getTransaction().commit();
        emf.close();
        return lista;
    }

    
    
}
