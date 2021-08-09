/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

/** Interface que contém os métodos de comportamento e nome
 *
 * @author Cezar Vinícius Mendes Vieira e João Vitor Robiatti Amorim
 */
public interface MenuItem {
        
    /**
     * Método que deve ser sobrescrito com o comportamento esperado para este item caso invocado.
     */
    public abstract void comportamento();
    
    /**
     * Método a ser sobrescrito que deve retornar o nome deste item de menu para ser mostrado no Menu.
     * @return nome como String.
     */
    public abstract String nome();
}

