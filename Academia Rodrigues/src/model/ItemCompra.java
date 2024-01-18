/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author vinic
 */
public class ItemCompra {
        int id;
        String nome;
        float valorUnitario;
        int quantidade;
        float total;

        public ItemCompra(int id, String nome, float valorUnitario, int quantidade, float total) {
            this.id = id;
            this.nome = nome;
            this.valorUnitario = valorUnitario;
            this.quantidade = quantidade;
            this.total = total;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public float getValorUnitario() {
            return valorUnitario;
        }

        public void setValorUnitario(float valorUnitario) {
            this.valorUnitario = valorUnitario;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }

        public float getTotal() {
            return total;
        }

        public void setTotal(float total) {
            this.total = total;
        }
    }
