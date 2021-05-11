package by.htp.hl.controller.impl;

import by.htp.hl.controller.Command;
import by.htp.hl.service.ClientService;
import by.htp.hl.service.ServiceException;
import by.htp.hl.service.ServiceProvider;

public class SignIn implements Command {
	private final String delimeter = "/";

	@Override
	public String execute(String request) {
		String login = null;
		String password = null;
		String response = null;
		String status = null;

		String[] param = null;

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		ClientService clientService = serviceProvider.getUserService();
		
		try {
			param = request.split(delimeter);
			login = param[1];
			password = param[2];
			status = clientService.signIn(login, password);
			System.out.println("Добро пожаловать, " + login +"! Уровень вашего доступа: " + status);
			response = status;
		} catch (ServiceException e) {
			response = "Неверный логин или пароль";
		
	}
		return response;

	}
}
