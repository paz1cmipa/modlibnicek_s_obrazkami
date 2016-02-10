
package InterfacesMysqlobjectOther;

import Entity.PravdyViery;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


public class MysqlPravdyViery implements PravdyVieryDao{

    private JdbcTemplate jdbcTemplate;
   
    
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    
    public MysqlPravdyViery(){
     	MysqlDataSource dataSource = new MysqlDataSource();
        
        dataSource.setUrl("jdbc:mysql://localhost/modlibnicek");
	dataSource.setUser("paz1cuser");
	dataSource.setPassword("simon.123");
	jdbcTemplate = new JdbcTemplate(dataSource);
        
          this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate);
	
    }
    
    
  
    
    @Override
    public void pridat(PravdyViery pravdy) {
        Map<String, Object> pridatHodnoty = new HashMap<String, Object>();
        pridatHodnoty.put("id", pravdy.getID());
        pridatHodnoty.put("nazov", pravdy.getNazov());
        pridatHodnoty.put("obsah", pravdy.getObsah());
  
        
        String sql = "INSERT INTO PravdyViery VALUES(:id, :nazov, :obsah)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(pridatHodnoty), keyHolder);
        int id = keyHolder.getKey().intValue();
        pravdy.setID(id);
        
      
    }

    @Override
    public void odstranit(PravdyViery pravdy) {
        String sql="Delete from PravdyViery where ID= ?";
        jdbcTemplate.update(sql,pravdy.getID());

        
    }

    @Override
    public List<PravdyViery> dajVsetky() {
        String sql = "Select * from PravdyViery";
        BeanPropertyRowMapper<PravdyViery> mapper = BeanPropertyRowMapper.newInstance(PravdyViery.class);
        return jdbcTemplate.query(sql, mapper);

    }

    @Override
    public void upravit(PravdyViery pravdy) {
        String sql= "Update PravdyViery Set nazov=?, obsah=? where ID= ? ";
        jdbcTemplate.update(sql,pravdy.getNazov(),pravdy.getObsah(),pravdy.getID());
        
    }

    @Override
    public List<PravdyViery> hladat(String s) {
        String sql = "Select * from PravdyViery where nazov like '%"+s+"%'";
        BeanPropertyRowMapper<PravdyViery> mapper = BeanPropertyRowMapper.newInstance(PravdyViery.class);
        return jdbcTemplate.query(sql, mapper);


    }
    
    
    
    
    
}
