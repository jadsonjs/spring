/**
 * 
 */
package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetPaisRequest;
import io.spring.guides.gs_producing_web_service.GetPaisResponse;

/**
 * @author Jadson Santos - jadson@info.ufrn.br
 *
 */
@Endpoint
public class PaisEndpoint {

	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private PaisRepository paisRepository;

	@Autowired
	public PaisEndpoint(PaisRepository paisRepository) {
		this.paisRepository = paisRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPaisRequest")
	@ResponsePayload
	public GetPaisResponse getCountry(@RequestPayload GetPaisRequest request) {
		GetPaisResponse response = new GetPaisResponse();
		response.setPais(paisRepository.findCountry(request.getNome()));
		return response;
	}
}

