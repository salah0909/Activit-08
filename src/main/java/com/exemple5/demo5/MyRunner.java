package com.exemple5.demo5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public abstract class MyRunner implements CommandLineRunner {
	@Autowired
	JdbcTemplate jdbctemplate;
	public static void main (String [] args) {
		SpringApplication.run(MyRunner.class, args);}
	@Override
	public void run( String... args) throws Exception {
		jdbctemplate.queryForObject("Select id,compte_creation,compte_maj,date_creation,date_maj,nom_arabe,nom_latin,nom_tamazight FROM wilaya",null,
				(rs, rowNum)-> new wilaya (rs.getString(1),rs.getBoolean(2),rs.getInt(3),rs.getInt(4),
						rs.getInt(5),rs.getTimestamp(6),rs.getTimestamp(7),rs.getString(8),
						rs.getString(9),rs.getString(10) ));
	}
	

}
