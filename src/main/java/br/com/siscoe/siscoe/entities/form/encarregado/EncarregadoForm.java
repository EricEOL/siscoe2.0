package br.com.siscoe.siscoe.entities.form.encarregado;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.siscoe.siscoe.entities.Cia;
import br.com.siscoe.siscoe.entities.Encarregado;

public class EncarregadoForm {
	
	@NotNull @NotEmpty
	private String name;
	
	@NotNull @NotEmpty
	private Cia cia;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Cia getCia() {
		return cia;
	}
	public void setCia(Cia cia) {
		this.cia = cia;
	}
	
	public Encarregado transform() {
		return new Encarregado(name, cia);
	}
}
