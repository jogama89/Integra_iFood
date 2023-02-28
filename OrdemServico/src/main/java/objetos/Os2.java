/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Joedson
 */

@Entity
@Table(name = "os2")
public class Os2 implements Serializable {
    
    /*
    data 
    hora
    tipo
    cliente
    tecnico responsavel
    placa
    Km
    */
    
    
    
    public Os2(){
    }
        
    public Os2(
    String dataemissao,
    String horaemissao,
    String status,
    String cliente ,
    String tipo ,
    String tecnico ,
    String placa ,
    String km,
    String placaOS
    ){
    this.dataemissao=dataemissao;
    this.horaemissao=horaemissao;
    this.status=status;
    this.cliente =cliente;
    this.tipo =tipo;
    this.tecnico =tecnico;
    this.placa =placa;
    this.km =    km    ;
    this.placaOS =    placaOS    ;
    }
    
    
    
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
    
//    @Column
//    private String dataemissao = "2020-08-10";             // Date do dia
    @Column
    private String dataemissao = (new SimpleDateFormat("dd/MM/yyyy").format(new Date()));            // Date do dia    
//    @Column
//    private String horaemissao = "16:58:48";               // time do dia
    @Column
    private String horaemissao = (new SimpleDateFormat("HH:mm:ss").format(new Date()));           // time do dia    
    
    @Column
    private String status = "ABERTA";                  // int padrao aberto
    @Column
    private String cliente = "1";                 // int vai ter que escolher ou cadastrar
    @Column
    private String tipo = "1";                    // int vai buscar o que ja esta cadastrado e mostrar para o usuario esoclher
    @Column
    private String tecnico = "1";                // int vai buscar o que ja esta cadastrado e mostrar para o usuario esoclher
    @Column
    private String placa ="";
    @Column
    private String km = "";
    
    private String placaOS = "";

    
    /**
     * @return the dataemissao
     */
    public String getDataemissao() {
        return dataemissao;
    }

    /**
     * @param dataemissao the dataemissao to set
     */
    public void setDataemissao(String dataemissao) {
        this.dataemissao = dataemissao;
    }

    /**
     * @return the horaemissao
     */
    public String getHoraemissao() {
        return horaemissao;
    }

    /**
     * @param horaemissao the horaemissao to set
     */
    public void setHoraemissao(String horaemissao) {
        this.horaemissao = horaemissao;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the tecnico
     */
    public String getTecnico() {
        return tecnico;
    }

    /**
     * @param tecnico the tecnico to set
     */
    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa      = placa;
    }
    
    /**
     * @return the km
     */
    public String getKm() {
        return km;
    }

    /**
     * @param km the km to set
     */
    public void setKm(String km) {
        this.km = km;
    }

    /**
     * @return the placaOS
     */
    public String getPlacaOS() {
        return placaOS;
    }

    /**
     * @param placaOS the placaOS to set
     */
    public void setPlacaOS(String placaOS) {
        this.placaOS = placaOS;
    }


    

    

    
    
    
}
