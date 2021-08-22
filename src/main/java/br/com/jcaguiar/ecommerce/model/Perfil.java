package br.com.jcaguiar.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity(name = "perfil")
final public class Perfil extends EntidadeData<Integer> implements GrantedAuthority {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Usuario usuario;
	
	@Enumerated(EnumType.STRING) private PerfilTipo nome;
	
	@Override
	public String getAuthority() {
		return this.nome.toString();
	}
	
	public enum PerfilTipo {
        ADM("ROLE_ADM"), STAFF("ROLE_STAFF"), USER("ROLE_USER");
        private String tipo;

        private PerfilTipo(String tipo) {
            this.tipo = tipo;
        }

        @Override
        public String toString() {
            return this.tipo;
        }
    }

}
