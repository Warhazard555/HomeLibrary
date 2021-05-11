package by.htp.hl.dao.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import by.htp.hl.bean.User;
import by.htp.hl.dao.DAOException;
import by.htp.hl.dao.UserDAO;

public class FileUserDAO implements UserDAO {
	private final String fileName = "data/DataSourceUsers.txt";
	private final String delimeter = "/";

	@Override
	public String signIn(String login, String password) throws DAOException {
		List<String> user = null;
		boolean exist = false;
		String status = null;

		try {
			user = Files.readAllLines(Paths.get(fileName));
			for (String u : user) {
				String[] users = u.split(delimeter);
				if (login.equals(users[0]) && password.equals(users[1])) {
					exist = true;
					status = users[2];
				}
			}
			if (exist == false) {
				throw new DAOException("Пользователя не существует");
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		return status;

	}

}
