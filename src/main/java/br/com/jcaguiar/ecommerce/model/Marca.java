package br.com.jcaguiar.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
@Entity(name = "marca")
final public class Marca implements Entidade<Short> {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	private String nome;
	
//	@ManyToMany(mappedBy = "marca", fetch = FetchType.LAZY)
//	private final List<Produto> produto = new ArrayList<>();
//	
//	public void addProduto(Produto prod) {
//		this.produto.add(prod);
//	}
//	
//	public void addProduto(List<Produto> prod) {
//		this.produto.addAll(prod);
//	}
}
