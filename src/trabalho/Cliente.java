/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

/**Classe para objetos do tipo Cliente, onde serão contidos os dados dos clientes
 *e metodos para acesso a estes dados.
 * @author Cezar Vinícius Mendes Vieira e João Vitor Robiatti Amorim
 */
public class Cliente {
    private String cpf;
    private String nome;
    /**Método construtor
     * 
     * @param cpf Str 
     * @param nome 
     */
    public Cliente(String cpf,String nome){
        this.cpf=cpf;
        this.nome=nome;
    }
    /**Método que deve retornar o cpf do cliente
     * 
     * @return String - cpf do cliente
     */
    public String getCpf() {
        return cpf;
    }
    /**Método que deve retornar o nome do cliente
     * 
     * @return String - nome do cliente
     */
    public String getNome() {
        return nome;
    }
}
