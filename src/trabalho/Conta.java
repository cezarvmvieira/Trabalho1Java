/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

/**Classe para objetos do tipo Conta, onde serão contidos os dados de cada conta
 * e métodos para acesso a estes dados.
 *
 * @author Cezar Vinícius Mendes Vieira e João Vitor Robiatti Amorim
 */
public class Conta {
    private int numero;
    private int saldo;
    private Cliente cliente;
   /**Método construtor
    * 
    * @param numero int - número da conta
    * @param saldo int - saldo da conta
    * @param cliente Cliente - cliente proprietário da conta
    */
    public Conta(int numero, int saldo, Cliente cliente) {
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
    }
    /** Método que deve retornar o número da conta
     * @return int - número da conta
     */
    public int getNumero() {
        return numero;
    }
    /**Método que deve retornar o valor do saldo
     * @return int - valor do saldo
     */
    public int getSaldo() {
        return saldo;
    }
    /**Método que altera o valor do saldo 
     * @param saldo int - valor do saldo 
     */
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    /**Método que altera o cliente proprietário da conta
     * @return Cliente - cliente proprietário
     */
    public Cliente getCliente() {
        return cliente;
    }
    /**Método que imprime o saldo da conta
     * 
     */
    public void imprimeSaldo(){
        System.out.println(String.format("Saldo do cliente:R$%.02f", (float)saldo/100));
    }
}