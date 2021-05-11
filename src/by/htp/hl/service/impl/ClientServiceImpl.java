package by.htp.hl.service.impl;

import by.htp.hl.dao.DAOException;
import by.htp.hl.dao.DAOProvider;
import by.htp.hl.dao.UserDAO;
import by.htp.hl.service.ClientService;
import by.htp.hl.service.ServiceException;

public class ClientServiceImpl implements ClientService {

	@Override
	public String signIn(String login, String password) throws ServiceException {
		String status = null;

		if (login.isEmpty() || login == null) {
			throw new ServiceException("Логин введен некорректно");
		}
		if (password.isEmpty() || password == null) {
			throw new ServiceException("Пароль введен некорректно");
		}
		DAOProvider provider = DAOProvider.getInstance();
		UserDAO user = provider.getUserDAO();
		try {
			status = user.signIn(login, password);
		} catch (DAOException e) {

			throw new ServiceException("Ошибка авторизации");
		}
		return status;

	}

}
