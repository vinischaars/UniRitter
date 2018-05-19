package enf.eventos.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import enf.eventos.domain.Ingresso;

@Repository
public class IngressoRepository {

	@Autowired
	NamedParameterJdbcTemplate jdbc;
	
	public List<Ingresso> listar() {

		String sql = "select * from ingresso";

		List<Ingresso> ingressos = jdbc.query(sql, new RowMapper<Ingresso>(){

			@Override
			public Ingresso mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Ingresso(
						rs.getLong("id_ingresso"), 
						rs.getString("tipo_ingresso"), 
						rs.getDouble("valor_ingresso"));
			}
		});

		return ingressos;
	}
	
	public Ingresso buscarPorId(long id){

		String sql = "select * from ingresso where id_ingresso = :id";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		Ingresso ingresso = jdbc.queryForObject(sql, params, new RowMapper<Ingresso>(){

			@Override
			public Ingresso mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Ingresso(
						rs.getLong("id_ingresso"), 
						rs.getString("tipo_ingresso"), 
						rs.getDouble("valor_ingresso"));
			}
		});

		return ingresso;
		
	}

	public List<Ingresso> buscarPorTipo(String tipo){

		String sql = "select * from ingresso where tipo_ingresso = :tipo";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tipo", tipo);

		List<Ingresso> ingressos = jdbc.query(sql, params, new RowMapper<Ingresso>(){

			@Override
			public Ingresso mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Ingresso(
						rs.getLong("id_ingresso"), 
						rs.getString("tipo_ingresso"), 
						rs.getDouble("valor_ingresso"));
			}
		});

		return ingressos;
		
	}
}
