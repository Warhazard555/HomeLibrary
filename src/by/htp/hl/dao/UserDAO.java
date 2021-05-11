package by.htp.hl.dao;

import by.htp.hl.bean.User;

public interface UserDAO {
	String signIn(String login, String password) throws DAOException;

}
