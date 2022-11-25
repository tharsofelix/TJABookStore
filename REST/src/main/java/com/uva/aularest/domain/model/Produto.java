package com.uva.aularest.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto{
	
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Integer codigo;
	
 @Column(name ="nome")
 private String nome;
 
 @Column(name ="autor")
 private String autor;
 
 @Column(name ="editora")
 private String editora;
 

 @Column(name ="categoria")
 private Integer categoria;
	
 @Column(name ="loja_fisica")
 private String temLojaFisica;
	
 @Column(name ="quantidade")
 private Integer quantidade;
	
 @Column(name ="preco")
 private Float preco;
	
 @Column(name ="data_lancamento")
 private String dataLancamento;
	
 @Column(name ="descricao")
 private String descricao;
	
 public Produto(){
  super();
 }

 public Produto(Integer codigo, String nome, String autor, String editora , Integer categoria, String temLojaFisica, Integer quantidade,
   Float preco, String dataLancamento, String descricao) {
  super();
  this.codigo = codigo;
  this.nome = nome;
  this.autor = autor;
  this.editora = editora;
  this.categoria = categoria;
  this.temLojaFisica = temLojaFisica;
  this.quantidade = quantidade;
  this.preco = preco;
  this.dataLancamento = dataLancamento;
  this.descricao = descricao;
 }

 public Produto(String nome, String autor, String editora, Integer categoria, String temLojaFisica, Integer quantidade, Float preco,
   String dataLancamento, String descricao) {
  super();
  this.nome = nome;
  this.autor = autor;
  this.editora = editora;
  this.categoria = categoria;
  this.temLojaFisica = temLojaFisica;
  this.quantidade = quantidade;
  this.preco = preco;
  this.dataLancamento = dataLancamento;
  this.descricao = descricao;
 }

 public Integer getCodigo() {
  return codigo;
 }

 public void setCodigo(Integer codigo) {
  this.codigo = codigo;
 }

 public String getNome() {
  return nome;
 }

 public void setNome(String nome) {
  this.nome = nome;
 }

 public String getAutor() {
  return autor;
 }

 public void setAutor(String autor) {
  this.autor = autor;
 }
 public String getEditora() {
  return editora;
 }

 public void setEditora(String editora) {
  this.editora = editora;
 }

 public Integer getCategoria() {
  return categoria;
 }

 public void setCategoria(Integer categoria) {
  this.categoria = categoria;
 }

 public String getTemLojaFisica() {
  return temLojaFisica;
 }

 public void setTemLojaFisica(String temLojaFisica) {
  this.temLojaFisica = temLojaFisica;
 }

 public Integer getQuantidade() {
  return quantidade;
 }

 public void setQuantidade(Integer quantidade) {
  this.quantidade = quantidade;
 }

 public Float getPreco() {
  return preco;
 }

 public void setPreco(Float preco) {
  this.preco = preco;
 }

 public String getDataLancamento() {
  return dataLancamento;
 }

 public void setDataLancamento(String dataLancamento) {
  this.dataLancamento = dataLancamento;
 }

 public String getDescricao() {
  return descricao;
 }

 public void setDescricao(String descricao) {
  this.descricao = descricao;
 }

 @Override
 public String toString() {
  return "Produto [codigo=" + codigo + ", nome=" + nome + ", autor=" + autor + ", editora=" + editora + ",  categoria=" + categoria + ", temLojaFisica="
    + temLojaFisica + ", quantidade=" + quantidade + ", preco=" + preco + ", dataLancamento=" + dataLancamento
    + ", descricao=" + descricao + "]";
 }
	
	
}