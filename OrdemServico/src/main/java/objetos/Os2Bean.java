package objetos;

import exeption.ErroSistema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Joedson
 */


//@ManagedBean(name = "nomesBean" )
// o tempo em que a pagina vai ficar execultando (demorou mais do que o tempo informado, vai volta para o inicio)
@SessionScoped
@ManagedBean
public class Os2Bean{
   
    
    
    private Os2 os2 = new Os2();
    
    
    private List<Os2> os2s = new ArrayList<>();
    
    public void adcionar() {
        
//        if(isBucar() == false){
//            MudarParaBucar();
//            return;
//        }


            System.out.println("os2.getPlaca() ===========> "+os2.getPlaca());
            System.out.println("os2.getKm() ===========> "+os2.getKm());

        
        // chama o metodo salvar da classe os2Controller 
        Os2Controller os2Controller = new Os2Controller(); 
        try {
            
            os2Controller.salvar(this.os2);
////////            getOs2s().add(getOs2());
//////////        // pega informações da lista
////////        for (Os2 os21 : getOs2s()) {
////////       System.out.println("================> getCodigo      : "+ os21.getCodigo()+" | "+
////////                                             "getDataemissao: "+ os21.getDataemissao()+" | "+
////////                                             "getHoraemissao: "+ os21.getHoraemissao()+" | "+
////////                                             "getKm         : "+ os21.getKm()+" | "+
////////                                             "getPlaca      : "+ os21.getPlaca()
////////                          );
////////        }
            setOs2(new Os2()); // zerando variaveis
            adicionarMensagem("Ordem de Serviço"," Salva Com Sucesso !", FacesMessage.SEVERITY_INFO);
            
            listar();
        } catch (ErroSistema e) {
            adicionarMensagem(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        
    }
    
    public void listar(){
        System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        try {
        // chama o metodo salvar da classe os2Controller 
        Os2Controller os2Controller = new Os2Controller(); 
        this.setOs2s(os2Controller.listar()); 
        
////////        // pega informações da lista
////////        for (Os2 os21 : getOs2s()) {
////////        System.out.println(os21.getCodigo()+" | "+os21.getPlaca());
////////        }             
//        // pega informações da lista
//        for (Os2 os21 : getOs2s()) {
//        System.out.println(os21.getAno()+" | "+os21.getCor()+" | "+os21.getFabricante()+" | "+os21.getModelo());
//        }            
          adicionarMensagem("Ordem de Serviço ","na Tabela a Baixo !", FacesMessage.SEVERITY_INFO);   
        } catch (ErroSistema e) {
             adicionarMensagem(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
    
    
////    public void linhaSelecionada(){
////        try {
////        // chama o metodo salvar da classe os2Controller 
////        Os2Controller os2Controller = new Os2Controller(); 
////        setOs2s(os2Controller.listar()); 
////        // pega informações da lista
////        for (Os2 os21 : getOs2s()) {
////        System.out.println(os21.getCodigo()+" | "+os21.getPlaca());
////        }             
//////        // pega informações da lista
//////        for (Os2 os21 : getOs2s()) {
//////        System.out.println(os21.getAno()+" | "+os21.getCor()+" | "+os21.getFabricante()+" | "+os21.getModelo());
//////        }            
////          adicionarMensagem("Ordem de Serviço ","na Tabela a Baixo !", FacesMessage.SEVERITY_INFO);   
////        } catch (ErroSistema e) {
////             adicionarMensagem(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
////        }
////    }    
    
    
    
    
    // pega da tabela e cola nas fildes
    public void editar(Os2 c){
        os2 = c;
    }

    
    public void deletar(Os2 os2){
        
        // chama o metodo salvar da classe os2Controller 
        Os2Controller os2Controller = new Os2Controller(); 
        os2Controller.remover(os2);
        
    }
    
    
    
        
    public void atualizar(){
        
        System.out.println("OBJETO: "+this.os2.getCodigo());
        System.out.println("OBJETO: "+this.os2.getPlaca());
        
        try {
            
        Os2Controller os2Controller = new Os2Controller(); 
        os2Controller.atualizar(this.os2);
        
            adicionarMensagem("Ok ! ","Ordem de Serviço Cancelada Com Sucesso !", FacesMessage.SEVERITY_INFO);
            
         } catch (ErroSistema e) {
            adicionarMensagem(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }

    }
    
    
    
    
	public String deleteAction(Os2 os2) {
	    
            
                this.deletar(this.os2);
            
		this.os2s.remove(this.os2);
		return null;
                        
	}    
    
        
    
    
    public void onRowSelect(SelectEvent event){
        
        
////        try{
////        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
////        }catch(IOException iOException){
////            iOException.printStackTrace();
////        }
        
        
    }
    
    
    
    
    public void novo(){
        // quanto clicar em novo, limpar variaveis/objetos
    }
    
    
    public void adicionarMensagem(String sumario,String detalhe,FacesMessage.Severity tipoErro){
        FacesContext contex = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(tipoErro, sumario,detalhe);
        contex.addMessage(null, message);
    }
    

    /**
     * @return the os2
     */
    public Os2 getOs2() {
        return os2;
    }

    /**
     * @param os2 the os2 to set
     */
    public void setOs2(Os2 os2) {
        this.os2 = os2;
    }

    /**
     * @return the os2s
     */
    public List<Os2> getOs2s() {
        return os2s;
    }

    /**
     * @param os2s the os2s to set
     */
    public void setOs2s(List<Os2> os2s) {
        this.os2s = os2s;
    }
    
    
    
}
