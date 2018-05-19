package enf.eventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import enf.eventos.data.IngressoRepository;
import enf.eventos.domain.CompradorDesconto;
import enf.eventos.domain.Ingresso;
import enf.eventos.factory.CalcularDescontoFactory;

@Service
@Transactional
public class IngressoService {

	@Autowired
	IngressoRepository repository;
	
	@Autowired
	CalcularDescontoFactory calcularDescontoFactory; 

	public List<Ingresso> listar() {
		return repository.listar();
	}
	
	public Ingresso buscarPorId(long id){
		return repository.buscarPorId(id);
	}

	public List<Ingresso> buscarPorTipo(String tipo){
		return repository.buscarPorTipo(tipo);
	}
	
	public double calcularValorComDesconto(Ingresso ingresso, CompradorDesconto comprador) {
		return this.calcularDescontoFactory.getStrategy(comprador.getComprador()).calcularValorDesconto(ingresso.getValorIngresso());
	}
	
}
