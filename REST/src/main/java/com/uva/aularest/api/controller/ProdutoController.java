package com.uva.aularest.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uva.aularest.domain.model.Produto;
import com.uva.aularest.domain.repository.ProdutoRepository;

@RestController
public class ProdutoController {
	
 @Autowired
 private ProdutoRepository produtoRepository;
	
 @GetMapping("/produtos")
 public List<Produto> listar() {
  return produtoRepository.findAll();
 } 
 
 @CrossOrigin
 @RequestMapping(value = "/produtos/filter", method = RequestMethod.GET)	
 public List<Produto> listarPorNome(@RequestParam(name = "nome", required = false) String nome) {

 	return produtoRepository.findByNomeContaining(nome);
 }
 
 @CrossOrigin
 @RequestMapping(value = "/produtos/categoria", method = RequestMethod.GET)	
 public List<Produto> listarPorCategoria(@RequestParam(name = "categoria", required = false) Integer categoria) {
	 return produtoRepository.findByCategoria(categoria);
 }
 
 @CrossOrigin
 @GetMapping("/produtos/{produtoId}")
 public ResponseEntity<Produto> consultar (@PathVariable Integer produtoId) {
  Optional<Produto> produto = produtoRepository.findById(produtoId);
  
  if (produto.isPresent()) {
   return ResponseEntity.ok(produto.get());
  
  }
  
  return ResponseEntity.notFound().build();
 } 

 @CrossOrigin
 @PostMapping("/produtos")
 @ResponseStatus(HttpStatus.CREATED)
 public Produto incluir(@RequestBody Produto produto) {
  return produtoRepository.save(produto);
 }

 @CrossOrigin
 @PutMapping("/produtos/{produtoId}")
 public ResponseEntity<Produto> alterar (@PathVariable Integer produtoId, @RequestBody Produto produto) {
  if(!produtoRepository.existsById(produtoId)) {
   return ResponseEntity.notFound().build();
   
  }
  
  produto.setCodigo(produtoId);
  produto = produtoRepository.save(produto);
  return ResponseEntity.ok(produto);
 }
	
 @CrossOrigin
 @DeleteMapping("/produtos/{produtoId}")
 public ResponseEntity<Produto> excluir (@PathVariable Integer produtoId) {
  if(!produtoRepository.existsById(produtoId)) {
   return ResponseEntity.notFound().build();
   
  }
  
  produtoRepository.deleteById(produtoId);
  return ResponseEntity.noContent().build();
  
 }
	
}