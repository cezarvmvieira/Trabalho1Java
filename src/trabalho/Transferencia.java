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
public class Transferencia {
    private int valor;
    private Conta origem;
    private Conta destino;

    public Transferencia(int valor, Conta origem, Conta destino) {
        this.valor = valor;
        this.origem = origem;
        this.destino = destino;
    }

    /**
     * @return the valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * @return the origem
     */
    public Conta getOrigem() {
        return origem;
    }

    /**
     * @return the destino
     */
    public Conta getDestino() {
        return destino;
    }
    
}
