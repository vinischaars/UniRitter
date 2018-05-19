package enf.eventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enf.eventos.data.IngressoEventoRepository;
import enf.eventos.domain.IngressoEvento;

@Service
public class IngressoEventoService {

	@Autowired
	IngressoEventoRepository repository;

	public List<IngressoEvento> listarIngressosPorIdDoEvento(int idEvento) {
		return repository.listarIngressosPorIdDoEvento(idEvento);
	}
	
	public List<IngressoEvento> adicionarIngressosEmEventos(IngressoEvento ingressoEvento){				
		return repository.adicionarIngressosEmEventos(ingressoEvento);
	}
	
	public String validarOperacao(IngressoEvento ingressoEvento) {
		
		if (repository.encontrarTipoDeIngressoDuplicado(ingressoEvento.getIngresso().getTipoIngresso(), ingressoEvento.getEvento().getId())) {
			return "Ja existe o mesmo tipo de Ingresso cadastrado para venda neste evento";
		}
		
		if (ingressoEvento.getInicioVenda().after(ingressoEvento.getFinalVenda())) {
			return "A data de inicio de venda deve ser inferior a data de fim";
		}
		
		return "";
	}
}
