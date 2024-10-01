package br.com.belleza_intima.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.belleza_intima.entity.Usuario_PermissaoEntity;

@Repository
public interface Usuario_PermissaoRepository extends JpaRepository<Usuario_PermissaoEntity, Long> {

}
