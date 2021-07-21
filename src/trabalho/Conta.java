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
public class Conta {
    private int numero;
    private int saldo;
    private Cliente cliente;
    public Conta(int numero, int saldo, Cliente cliente) {
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
    }
    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }
    /**
     * @return the saldo
     */
    public int getSaldo() {
        return saldo;
    }
    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }
    public void imprimeSaldo(){
        System.out.println(String.format("Saldo do cliente:R$%2f", (float)saldo/100));
    }
}
