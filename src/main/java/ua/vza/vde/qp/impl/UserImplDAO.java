package ua.vza.vde.qp.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import ua.vza.vde.qp.dao.IUserDAO;
import ua.vza.vde.qp.obj.User;

import javax.sql.DataSource;

/**
 * Created by velenteenko on 25.06.15.
 */
@Component
public class UserImplDAO implements IUserDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplateDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User getUserFioByLogin(String userLogin) {
        User user = new User();
        String sql = "SELECT details FROM users where username=?";
        String retFio = jdbcTemplate.queryForObject(sql,new Object[]{userLogin},String.class);
//        String sdsd = jdbcTemplate.queryForObject(sql, new )
        user.setFio(retFio);

        return user;
    }
}
