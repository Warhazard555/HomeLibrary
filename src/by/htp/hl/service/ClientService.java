package by.htp.hl.service;

import by.htp.hl.bean.User;

public interface ClientService {
	String signIn(String login, String password) throws ServiceException;
}
