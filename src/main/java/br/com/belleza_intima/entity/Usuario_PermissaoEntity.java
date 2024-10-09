package br.com.belleza_intima.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario_permissao" , schema = "belleza_intima")
public class Usuario_PermissaoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long idUsuario;
	
	@Column(name = "id_permissao")
	private Long idPermissao;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdPermissao() {
		return idPermissao;
	}

	public void setIdPermissao(Long idPermissao) {
		this.idPermissao = idPermissao;
	}
	
	
}
