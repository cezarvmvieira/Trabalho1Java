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
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Classe que gerencia o menu com itens de menu.
 * @author Thiago
 */
public class Menu {
    /**
     * Atributo estático leitor que é usado em todos os itens.
     */
    private static Scanner leitor = null;
    /**
     * Vetor de itens mostrados e invocados por este menu.
     */
    private ArrayList<MenuItem> itens;

    /**
     * Construtor padrão de Menu, inicializa o vetor de itens.
     */
    public Menu() {
        this.itens = new ArrayList<MenuItem>();
    }
    
    /**
     * Setter: Método estático para definir o leitor.
     * @param leitor parâmetro por referência de leitor.
     */
    public static void setLeitor(Scanner leitor){
        Menu.leitor = leitor;
    }
    
     /**
     * Getter: Método estático para receber o leitor.
     * @return referência do leitor.
     */
    public static Scanner getLeitor(){
        return (Menu.leitor);
    }
    
    /**
     * Método para adicionar itens de menu ao vetor de itens.
     * @param menuItem item de menu a ser adicionado.
     */
    void adiciona(MenuItem menuItem){
        this.itens.add(menuItem);
    }           

    /**
     * Método que mostra todos os itens numerados com seus respectivos nomes.
     * @return número escolhido pelo usuário.
     */
    private int mostra(){
        System.out.println("Itens do menu:");

        for (int i= (0); i < this.itens.size(); i++)
        {
            System.out.println("(" + i + ')' + ':' + ' ' + this.itens.get(i).nome());
            // obs: .at() e operador [] são sinônimos.
        }
        System.out.println("Escolha um item pelo número: (ou outro inteiro para sair)");
        int itemIndice = (-1);
        
        if (leitor.hasNextInt()){
            itemIndice = leitor.nextInt();
        }

        return (itemIndice);
    }

    /**
     * Método para ser invocado pelo console para mostrar e executar os comandos do menu.
     * @return true: para operação escolhida e executada, false: para nenhuma opção escolhida.
     */        
    public boolean executa(){
        final int opcao = (this.mostra());

        if ((opcao >= 0) && (opcao < this.itens.size()))
        {
            System.out.println();
            this.itens.get(opcao).comportamento();
            
            return (true);
        }
        else
        {
            return (false);
        }
    }
      
      
}

