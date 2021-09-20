package br.com.jcaguiar.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.esotericsoftware.kryo.NotNull;

public class ProdutoPOST_ID extends MasterPOST {
	
	@NotEmpty @NotNull List<Integer> id = new ArrayList<>();
	
	public void addId(int id) {
		this.id.add(id);
	}

}
