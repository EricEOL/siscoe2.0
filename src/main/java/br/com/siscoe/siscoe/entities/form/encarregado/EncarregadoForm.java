package br.com.siscoe.siscoe.entities.form.encarregado;

import br.com.siscoe.siscoe.entities.Cia;
import br.com.siscoe.siscoe.entities.Encarregado;

public class EncarregadoForm {
	private String name;
	private Cia cia;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCia() {
		return cia;
	}
	public void setCia(String cia) {
		this.cia = cia;
	}
	
	public Encarregado transform() {
		return new Encarregado(name, cia);
	}
}
