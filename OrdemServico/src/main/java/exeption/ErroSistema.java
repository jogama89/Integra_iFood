/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exeption;

/**
 *
 * @author Joedson
 */
public class ErroSistema extends Exception{

    public ErroSistema(String message) {
        super(message);
    }
    
    public ErroSistema(String message, Throwable causa) {
        super(message,causa);
    }
    
    
}
