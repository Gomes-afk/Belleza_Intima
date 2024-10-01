package br.com.belleza_intima.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.belleza_intima.entity.Usuario_ProdutoEntity;

@Repository
public interface Usuario_ProdutoRepository extends JpaRepository<Usuario_ProdutoEntity, Long> {

}
