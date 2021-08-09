/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.util.Scanner;
/**Classe para objetos do tipo Operador
 *
 * @author Cezar Vinícius Mendes Vieira e João Vitor Robiatti Amorim
 */
public class Operador {
    private static Scanner leitor = null;
    private Banco banco;
    /**Método construtor
     * 
     * @param banco Banco - referência de banco
     */
    Operador(Banco banco){
        this.banco=banco;
    }
    /**Método que chama o método listaClientes de Banco
     * 
     */
    public void listaClientes(){
        try{
            this.banco.listaClientes();
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
        
    }
    /**Método que chama o método listaContas de Banco
     * 
     */
    public void listaContas(){
        String cpf;
        try{
            System.out.println("CPF do cliente para consulta:");
            cpf=leitor.next();
            this.banco.listaContas(cpf);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
        
    }
    /**Método que chama o método saldoDoCliente de Banco passando o cpf
     * 
     */
    public void saldoDoCliente(){
        String cpf;
        try{
            System.out.println("CPF do cliente para saldo:");
            cpf=leitor.next();
            this.banco.saldoDoCliente(cpf);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
        
    }
    /**Método que chama o método extratoDoCliente de Banco passando o cpf
     * 
     */
    public void extratoDoCliente(){
        String cpf;
        try{
            System.out.println("CPF do cliente para extrato:");
            cpf=leitor.next();
            this.banco.extratoDoCliente(cpf);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
    /**Método que chama o método realizarTransferencia de Banco passando 
     * numero de origem, destino e valor da transferência
     * 
     */
    public void realizarTransferencia(){
        int numero_dest,numero_ori,valor;
        try{
            System.out.println("Numero - conta de origem:");
            numero_ori=leitor.nextInt();
            System.out.println("Numero - conta de destino:");
            numero_dest=leitor.nextInt();
            if(numero_dest==numero_ori)
                throw new RuntimeException("Origem e destino sao os mesmos nesta transferencia");
            System.out.println("Valor a ser transferido (centavos):");
            valor = leitor.nextInt();
            this.banco.realizarTransferencia(numero_dest,numero_ori,valor);
            System.out.println("Transferencia realizada com sucesso");
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
    /**Método que insere um objeto Scanner em operador
     * 
     * @param leitor Scanner - leitor
     */
    public static void setLeitor(Scanner leitor){
        Operador.leitor = leitor;
    }
    /**Método que retorna o objeto Scanner
     * 
     * @return Scanner - leitor
     */
    public static Scanner getLeitor(){
        return (Operador.leitor);
    }
    /**Método que chama o método mostraValores de Banco
     * 
     */
    public void mostraValores(){
        System.out.println(String.format("Total:R$%.02f", (float) this.banco.mostraValores()/100));
    }
}