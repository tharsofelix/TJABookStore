package com.uva.aularest.domain.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.uva.aularest.domain.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

	List<Produto> findByNomeContaining(String nome);

	List<Produto> findByCategoria(Integer categoria);

}
