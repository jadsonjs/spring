/**
 * 
 */
package hello.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hello.model.Moeda;
import hello.model.PaisXML;
import hello.model.PaisesXMLList;

/**
 * @author Jadson Santos - jadson@info.ufrn.br
 *
 */
@RestController
public class PaisXMLResource {
	
	
	
	public PaisXMLResource() {
		
	}
	
	@RequestMapping(value = "/paisesXML", method = RequestMethod.GET, headers="Accept=application/xml")  
	public PaisesXMLList getCountries(){  
		PaisesXMLList countryList = createCountryList();  
	   return countryList;  
	}  

	
	@RequestMapping(value = "/paisesXML/{nome}", method = RequestMethod.GET)
	public PaisXML getCountryById(@PathVariable String nome) {
		List<PaisXML> listOfCountries = new ArrayList<PaisXML>();
		PaisesXMLList paisesList = createCountryList();
		listOfCountries = paisesList.getListaDePaises();
		
		for (PaisXML country : listOfCountries) {
			if (country.getNome().equals(nome))
				return country;
		}
		return null;
	}
	
	public PaisesXMLList createCountryList() {
		PaisXML p1 = new PaisXML("Brasil", 20000000, "Brasília", Moeda.REAL);
		PaisXML p2 = new PaisXML("Alemanha", 8000000, "Berlin", Moeda.EURO);
		PaisXML p3 = new PaisXML("EUA", 30000000, "Washington", Moeda.DOLAR);

		List<PaisXML> listOfCountries = new ArrayList<PaisXML>();
		listOfCountries.add(p1);
		listOfCountries.add(p2);
		listOfCountries.add(p3);

		return new PaisesXMLList(listOfCountries);
	}

}
