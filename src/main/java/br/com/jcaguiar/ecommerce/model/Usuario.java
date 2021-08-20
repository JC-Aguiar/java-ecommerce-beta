package br.com.jcaguiar.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
@Entity(name = "usuario")
public class Usuario extends EntidadeData<Integer> implements UserDetails {

	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Perfil perfil;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Cliente cliente;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Carrinho carrinho;
	
	private static final long serialVersionUID = 1L; //?
	@Column(unique=true, nullable=false) //se tiver com problemas na persistência, remover/pesquisar
	private String email;
	private String senha;
	private boolean empresa;
	private String foto;
	
	
	
	@Override
	public List<Perfil> getAuthorities() {
		return null;
	}
	
	@Override
	public String getPassword() {
		return this.senha;
	}
	
	@Override
	public String getUsername() {
		return this.email;
	}
	
	//MÉTODO NÃO DESENVOLVIDO: CONTA NÃO EXPIRTADA
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	//MÉTODO NÃO DESENVOLVIDO: CONTA NÃO BLOQUEADA
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	//MÉTODO NÃO DESENVOLVIDO: CREDENCIAIS ATUAIS EXPIRADAS
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
		
	@Override
	public boolean isEnabled() {
		return this.ativo;
	}

}
