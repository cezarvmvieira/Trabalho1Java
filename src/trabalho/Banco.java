/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.util.ArrayList;
import java.util.Scanner;

/**Classe para objetos do tipo Banco, onde serão contidos as Arraylists de 
 * Cliente,Conta e Tranferencia e métodos com as operações do mesmo.
 * 
 * @author Cezar Vinícius Mendes Vieira e João Vitor Robiatti Amorim
 */
public class Banco {
    private int balanco;
    ArrayList<Cliente> clientes;
    ArrayList<Conta> contas;
    ArrayList<Transferencia> transferencias;
    /**Metodo construtor
     * 
     * @param balanco int - valor do balanço
     * @param clientes Arraylist de Cliente - clientes cadastrados
     * @param contas Arraylist de Conta - contas cadastradas
     * @param transferencias  Arraylist de Transferencia - transferencias 
     * realizadas
     */
    Banco(int balanco,ArrayList<Cliente> clientes,ArrayList<Conta> contas,ArrayList<Transferencia> transferencias){
        this.balanco=balanco;
        this.clientes=clientes;
        this.contas=contas;
        this.transferencias=transferencias;
    }
    /** Método para consulta de saldo de um cliente
     * 
     * @param cliente Cliente - referência de cliente a ser consultado o saldo
     */
    void saldoDaConta(Cliente cliente){
        int achou=0;
        for(int i=0;i<contas.size();i++){
            if(contas.get(i).getCliente()==cliente){
                System.out.println("Numero da conta:"+contas.get(i).getNumero());
                contas.get(i).imprimeSaldo();
                System.out.println("-----------------------------");
                achou=1;
            }
        }
        if(achou==0){
            throw new RuntimeException("Nenhuma conta cadastrada para esse cpf.");
        }
    }
    /**Método que pesquisa na base de dados o cliente pelo seu cpf e chama 
     * o método saldo da conta.
     * 
     * @param cpf String - cpf do cliente
     */
    void saldoDoCliente(String cpf){
        int achou=0;
        for(int i=0;i<clientes.size();i++){
            if(clientes.get(i).getCpf().compareTo(cpf)==0){
                this.saldoDaConta(clientes.get(i));
                achou=1;
            }
        }
        if(achou==0){
            throw new RuntimeException("CPF nao cadastrado.");
        }

    } 
    /**Método que calcula o balanço a partir do saldo das contas
     * 
     * @return int - valor do balanço 
     */
    int mostraValores(){
        int total=0;
        for(int i=0;i<contas.size();i++){
            total+=contas.get(i).getSaldo();//contas[i]->getSaldo();
        }
        return total;
    }
    /**Método que lista os clientes
     * 
     */
    void listaClientes(){
        boolean achou= false;
        for(int i=0;i<clientes.size();i++){
            System.out.println("Cliente "+(i+1));//cout<<"Cliente "<<i+1<<endl;
            System.out.println("Nome:"+clientes.get(i).getNome());//cout<<"Nome:"<<clientes[i]->getNome()<<endl;
            achou= true;
        }
        if(!achou){
            throw new RuntimeException("Nenhum cliente cadastrado");
        }
        
    }
    /**Método que lista as contas cadastradas para um determinado cpf
     * 
     * @param cpf String - cpf do cliente
     */
    void listaContas(String cpf){
        //cout<<"Contas do CPF:"<<cpf;
        boolean achou=false;
        for(int i=0;i<contas.size();i++){
            if(contas.get(i).getCliente().getCpf().compareTo(cpf)==0){
                System.out.println("Numero da conta:"+contas.get(i).getNumero());
                achou=true;
            }   
        }
        if(!achou){
            throw new RuntimeException("Nenhuma conta cadastrada para esse cpf.");
        }
    }
    /** Método que atualiza o valor do balanço
     * 
     * @param balanco int - valor do saldo da conta criada
     */
    public void setBalanco(int balanco) {
        this.balanco+= balanco;
    }
    /**Método que gera o extrato do cliente
     * 
     * @param cpf String - cpf do cliente
     */
    public void extratoDoCliente(String cpf){
        listaContas(cpf);
        int conta;
        boolean achou=false;
        Scanner ler=new Scanner(System.in);
        System.out.println("Digite o numero da conta para o extrato:");
        conta=ler.nextInt();
        for(int i=0;i<transferencias.size();i++){
            if(transferencias.get(i).getOrigem().getNumero()==conta){
                achou=true;
                System.out.println("Transferido para:"+transferencias.get(i).getDestino().getNumero());
                System.out.println(String.format("Valor R$:-%.02f",(float) transferencias.get(i).getValor()/100));    
            }
            if(transferencias.get(i).getDestino().getNumero()==conta){
                achou=true;
                System.out.println("Recebido de:"+transferencias.get(i).getOrigem().getNumero());
                System.out.println(String.format("Valor R$:+%.02f",(float) transferencias.get(i).getValor()/100));
            }    
        } 
        if(!achou){
            throw new RuntimeException("Nenhuma transferencia realizada.");
        }
    }
    /**Método que realiza a trânsferencia
     * 
     * @param numero_dest int - número da conta de destino
     * @param numero_ori int - número da conta de origem
     * @param valor int - valor a ser transferido
     */
    public void realizarTransferencia(int numero_dest, int numero_ori,int valor){
       int saldo_fo=0,saldo_fd=0;
       Conta origem= null;
       Conta destino= null;
       for(int i=0;i<contas.size();i++){
           if(contas.get(i).getNumero()==numero_ori){
               origem = contas.get(i);
               break;
           }
       }
       if(origem == null)
          throw new RuntimeException("Conta de origem nao encontrada.");
        for(int i=0;i<contas.size();i++){
           if(contas.get(i).getNumero()==numero_dest){
               destino = contas.get(i);
               break;
           }
       }
       if(destino == null)
            throw new RuntimeException("Conta de destino nao encontrada.");
       if((origem.getSaldo()-valor)<0)
            throw new RuntimeException("Saldo insuficiente para transferencia.");
        saldo_fo = origem.getSaldo()-valor;
        origem.setSaldo(saldo_fo);
        saldo_fd = destino.getSaldo()+valor;
        destino.setSaldo(saldo_fd);
        if(balanco!=mostraValores())
            throw new RuntimeException("Balanco total invalido.");
        transferencias.add(new Transferencia(valor, origem, destino));
    }
}