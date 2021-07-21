/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

/**
 *
 * @author ceeza
 */
public class Cliente {
    private String cpf;
    private String nome;
    /**
     * 
     * @param cpf
     * @param nome 
     */
    public Cliente(String cpf,String nome){
        this.cpf=cpf;
        this.nome=nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }
}
