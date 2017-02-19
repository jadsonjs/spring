/**
 * 
 */
package hello.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hello.model.Moeda;
import hello.model.Pais;

/**
 * @author Jadson Santos - jadson@info.ufrn.br
 *
 */
@RestController
public class PaisResource {

	private Map<Integer, Pais> paises;
	
	public PaisResource() {
		paises = new HashMap<Integer, Pais>();

		Pais p1 = new Pais("Brasil", 20000000, "Brasília", Moeda.REAL);
		Pais p2 = new Pais("Alemanha", 8000000, "Berlin", Moeda.EURO);
		Pais p3 = new Pais("EUA", 30000000, "Washington", Moeda.DOLAR);

		paises.put(1, p1);
		paises.put(2, p2);
		paises.put(3, p3);
	}

	@RequestMapping(value = "/paises", method = RequestMethod.GET)
	public ResponseEntity<List<Pais>> listar() {
		return new ResponseEntity<List<Pais>>(new ArrayList<Pais>(paises.values()), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/paises/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pais> buscar(@PathVariable("id") Integer id) {
		Pais pais = paises.get(id);
		if (pais == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Pais>(pais, HttpStatus.OK);
	}

	@RequestMapping(value = "/paises/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletar(@PathVariable("id") int id) {
		Pais pais = paises.remove(id);
		if (pais == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
