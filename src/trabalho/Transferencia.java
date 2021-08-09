/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

/**Classe para objetos do tipo Transferencia, onde serão contidos os dados das
 * contas envolvidas na transferência e os métodos
 *
 * @author Cezar Vinícius Mendes Vieira e João Vitor Robiatti Amorim
 */
public class Transferencia {
    private int valor;
    private Conta origem;
    private Conta destino;
    /**Método construtor
     * 
     * @param valor int - valor da transferência
     * @param origem Conta - referência da conta de origem 
     * @param destino Conta - referência da conta de destino
     */
    public Transferencia(int valor, Conta origem, Conta destino) {
        this.valor = valor;
        this.origem = origem;
        this.destino = destino;
    }

    /**Método que deve retornar o valor da transferência
     * @return int - valor da transferência 
     */
    public int getValor() {
        return valor;
    }

    /**Método que retorna a conta de origem 
     * @return Conta - conta de origem
     */
    public Conta getOrigem() {
        return origem;
    }

    /**Método que retorna a conta de destino
     * @return Conta - conta de destino 
     */
    public Conta getDestino() {
        return destino;
    }
    
}
