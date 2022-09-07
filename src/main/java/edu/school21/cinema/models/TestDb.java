package edu.school21.cinema.models;

import edu.school21.cinema.config.DBConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

public class TestDb{

    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
//        jdbcTemplate.execute("insert into users (first_name, last_name, phone_number, password) VALUES\n" +
//                "    (\n" +
//                "        '2',\n" +
//                "        '2',\n" +
//                "        '+88005553535',\n" +
//                "        'q1'\n" +
//                "    );");
        Users user = jdbcTemplate.queryForObject("select * from users where id = ?", new UserMapper(), 2);
        System.out.println(user.toString());
    }
}