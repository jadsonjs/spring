/**
 * 
 */
package hello;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.junit.Assert;
import org.springframework.stereotype.Component;

import io.spring.guides.gs_producing_web_service.Moeda;
import io.spring.guides.gs_producing_web_service.Pais;

/**
 * 
 * https://spring.io/guides/gs/producing-web-service/
 * 
 * @author Jadson Santos - jadson@info.ufrn.br
 *
 */
@Component
public class PaisRepository {

	private static final List<Pais> countries = new ArrayList<Pais>();
	
	@PostConstruct
	public void initData() {
		
		Pais brasil = new Pais();
		brasil.setNome("Brasil");
		brasil.setCapital("Brasília");
		brasil.setMoeda(Moeda.REAL);
		brasil.setPopulacao(46704314);

		countries.add(brasil);

		Pais alemanha = new Pais();
		alemanha.setNome("Alemanha");
		alemanha.setCapital("Berlin");
		alemanha.setMoeda(Moeda.EURO);
		alemanha.setPopulacao(38186860);

		countries.add(alemanha);

		Pais eua = new Pais();
		eua.setNome("United States of America");
		eua.setCapital("London");
		eua.setMoeda(Moeda.DOLAR);
		eua.setPopulacao(63705000);

		countries.add(eua);
	}

	public Pais findCountry(String name) {
		Assert.assertNotNull(name);

		Pais result = null;

		for (Pais country : countries) {
			if (name.equals(country.getNome())) {
				result = country;
			}
		}

		return result;
	}

}
