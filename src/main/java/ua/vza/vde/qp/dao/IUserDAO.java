package ua.vza.vde.qp.dao;

import ua.vza.vde.qp.obj.User;

/**
 * Created by velenteenko on 25.06.15.
 */
public interface IUserDAO {

    User getUserByName(String userLogin);
}
