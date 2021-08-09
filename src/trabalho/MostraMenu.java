/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.util.Scanner;
import java.util.ArrayList;
/**Classe "principal" que contém as classes que implementam a interface MenuItem,
 * representando cada item do Menu.
 *
 * @author Cezar Vinícius Mendes Vieira e João Vitor Robiatti Amorim
 */
public class MostraMenu {
    /**Classe que contém a operação "Listar Clientes" 
     * 
     */
    class Lista_Clientes implements MenuItem{
		Operador operador;
                /**Método que chama a operação listaClientes
                 * 
                 */
                @Override
		public void comportamento(){
			operador.listaClientes();
		}
                /**Método que deve retornar o nome do item do menu
                 * 
                 * @return String - nome do item
                 */
		@Override
		public String nome(){
			return ("Listar Clientes");
		}
                /**Método construtor
                 * 
                 * @param operador Operador - referência de operador 
                 */
		Lista_Clientes(Operador operador){
				this.operador=operador;
			}
    }
        /**Classe que contém a operação "Listar Contas" 
         * 
         */
	class Lista_Contas implements MenuItem{
		Operador operador;
                /**Método que chama a operação listaContas
                 * 
                 */
		@Override
		public void comportamento(){
			operador.listaContas();
		}
                /**Método que deve retornar o nome do item do menu
                 * 
                 * @return String - nome do item 
                 */
		@Override
		public String nome(){
			return ("Listar Contas");
		}
		Lista_Contas(Operador operador){
				this.operador=operador;
		}
    }
	/**Classe que contém a operação "Consultar saldo do cliente"
         * 
         */
        class Saldo_Cliente implements MenuItem{
		Operador operador;
                /**Método que chama a operação saldoDoCliente
                 * 
                 */
                @Override
		public void comportamento(){
			operador.saldoDoCliente();
		}
		/**Método que deve retornar o nome do item do menu
                 * 
                 * @return String - nome do item 
                 */
                @Override
                public String nome()
		{
			return ("Consultar saldo do cliente");
		}
		public Saldo_Cliente(Operador operador){
				this.operador=operador;
		}
	}
        /**Classe que contém a operação "Gerar extrato"
         * 
         */
	class Extrato implements MenuItem{
		Operador operador;
                /**Método que chama a operação extratoDoCliente
                 * 
                 */
		@Override
		public void comportamento(){
			operador.extratoDoCliente();
		}
		/**Método que deve retornar o nome do item do menu
                 * 
                 * @return String - nome do item 
                 */
                @Override
                public String nome(){
			return ("Gerar extrato");
		}
		Extrato(Operador operador){
				this.operador=operador;
		}
    }
        /**Classe que contém a operação "Realizar transferencia"
         * 
         */
	class Transferencia_conta implements MenuItem{
		Operador operador;
		/**Método que chama a operação realizarTransferencia
                 * 
                 */
		@Override
                public void comportamento(){
			operador.realizarTransferencia();
		}
		/**Método que deve retornar o nome do item do menu
                 * 
                 * @return String - nome do item 
                 */
                @Override
		public String nome(){
			return ("Realizar transferencia");
		}
		Transferencia_conta(Operador operador){
				this.operador=operador;
		}
    }
        /**Classe que contém a operação "Realizar balanco"
         * 
         */
	class Balanco implements MenuItem{
		Operador operador;
                /**Método que chama a operação mostraValores
                 * 
                 */
                @Override
		public void comportamento(){
			operador.mostraValores();
		}
		/**Método que deve retornar o nome do item do menu
                 * 
                 * @return String - nome do item 
                 */
                @Override
                public String nome(){
			return ("Realizar balanco");
		}
		Balanco(Operador operador){
			this.operador=operador;
		}
	}
    public static void main(String[] args) throws Exception {
        MostraMenu mostra= new MostraMenu();
		ArrayList<Cliente> clientes=new ArrayList<Cliente>();
		ArrayList<Conta> contas=new ArrayList<Conta>();
		ArrayList<Transferencia> transferencias= new ArrayList<Transferencia>();
		Banco banco=new Banco(0,clientes,contas,transferencias);
		Cliente cliente1= new Cliente("11527249832","Cezar");
		Cliente cliente2= new Cliente("87349777833","Joao Vitor");
		Cliente cliente3= new Cliente("49748496899","Jose Maria");
		Cliente cliente4= new Cliente("99403567813","Zeca da Silva");
		Conta conta1=new Conta(1,100000,cliente1);
		Conta conta2=new Conta(2,100000,cliente2);
		Conta conta3=new Conta(3,100000,cliente2);
		Conta conta4=new Conta(4,100000,cliente3);
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
		clientes.add(cliente4);
		contas.add(conta1);
		contas.add(conta2);
		contas.add(conta3);
		contas.add(conta4);
		banco.setBalanco(conta1.getSaldo());
		banco.setBalanco(conta2.getSaldo());
		banco.setBalanco(conta3.getSaldo());
		banco.setBalanco(conta4.getSaldo());
		Operador operador=new Operador(banco);
		mostra.executa(operador);
		

    }

	public void executa(Operador operador) {
    
		Scanner leitor = new Scanner(System.in);
        Menu.setLeitor(leitor);
		Operador.setLeitor(leitor);
        Menu menu1 = new Menu();
        menu1.adiciona(new Lista_Clientes(operador));
		menu1.adiciona(new Lista_Contas(operador));
		menu1.adiciona(new Saldo_Cliente(operador));
		menu1.adiciona(new Extrato(operador));
		menu1.adiciona(new Transferencia_conta(operador));
		menu1.adiciona(new Balanco(operador));
        while (menu1.executa()) {
            // quebra linha para separar.
            System.out.println();
        }
        leitor.close();
    }
}