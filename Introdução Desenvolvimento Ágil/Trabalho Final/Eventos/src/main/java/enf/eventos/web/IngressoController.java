package enf.eventos.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import enf.eventos.domain.CompradorDesconto;
import enf.eventos.domain.Ingresso;
import enf.eventos.service.IngressoService;

@RestController
@RequestMapping("/ingressos")
public class IngressoController {

	@Autowired
	IngressoService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Ingresso>> listar(){
		return new ResponseEntity<>(service.listar(), HttpStatus.OK);
	}	
	
	@RequestMapping(method = RequestMethod.GET, value="/buscar/{id}")
	public ResponseEntity<Ingresso> buscarPorId(@PathVariable long id) {
		Ingresso ingresso = service.buscarPorId(id);
		if (ingresso != null) {
			return new ResponseEntity<>(ingresso, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/buscar")
	public ResponseEntity<List<Ingresso>> buscarPorTipo(@RequestParam String tipo) {
		List<Ingresso> ingressos = service.buscarPorTipo(tipo);
		if (!ingressos.isEmpty()) {
			return new ResponseEntity(ingressos, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/calcular/{idIngresso}/{comprador}")
	public ResponseEntity<Ingresso> calcularIngressoComDesconto(@PathVariable long idIngresso, @PathVariable CompradorDesconto comprador) {
		Ingresso ingresso = service.buscarPorId(idIngresso);
		if (ingresso != null) {
			ingresso.setValorIngresso(service.calcularValorComDesconto(ingresso, comprador));
			return new ResponseEntity(ingresso, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
}
