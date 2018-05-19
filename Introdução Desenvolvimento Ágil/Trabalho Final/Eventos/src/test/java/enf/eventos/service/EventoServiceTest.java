package enf.eventos.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import enf.eventos.domain.Evento;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventoServiceTest {
	
	@Autowired
	private EventoService service;

	@Test
	@Transactional
	public void testeCriacaoEvento() {

		//Given
		//DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date data = Date.from(LocalDate.of(2018, 1, 2).atStartOfDay(ZoneId.systemDefault()).toInstant());
		String nomeEvento = "Queen";
		Evento evento = new Evento();
		evento.setName(nomeEvento);
		evento.setDate(data);
		
		//When
		Evento eventoCriado = service.criarEvento(evento);
		
		//Then
		assertThat(eventoCriado.getDate()).isEqualTo(evento.getDate());
		assertThat(eventoCriado.getName()).isEqualTo(evento.getName());
		assertThat(eventoCriado.getId()).isNotNull();
		
	}

}
