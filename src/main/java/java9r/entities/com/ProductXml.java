package java9r.entities.com;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "player")
public class ProductXml {
	String name;
	String text;
	
	@XmlElement
	public String getName() {
		return name;
	}
	@XmlElement
	public String getText() {
		return text;
	}
	
	public ProductXml(String name, String text) {
		super();
		this.name = name;
		this.text = text;
	}
	public ProductXml() {
		super();
	}
	
	

}
