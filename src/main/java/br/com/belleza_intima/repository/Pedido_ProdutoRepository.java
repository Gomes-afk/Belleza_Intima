package br.com.belleza_intima.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.belleza_intima.entity.Pedido_ProdutoEntity;

@Repository
public interface Pedido_ProdutoRepository extends JpaRepository<Pedido_ProdutoEntity, Long> {

}
