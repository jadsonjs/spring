package hello.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paises-list")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaisesXMLList {

	@XmlElement(name = "paises")
	List<PaisXML> listaDePaises;

	public PaisesXMLList() {
		super();
	}

	public PaisesXMLList(List<PaisXML> listDePaises) {
		this.listaDePaises = listDePaises;
	}

	public List<PaisXML> getListaDePaises() {
		return listaDePaises;
	}

	public void setListaDePaises(List<PaisXML> listaDePaises) {
		this.listaDePaises = listaDePaises;
	}

	
}
