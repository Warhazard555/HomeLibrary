package by.htp.hl.controller.impl;

import by.htp.hl.controller.Command;

public class WrongRequest implements Command {

	@Override
	public String execute(String request) {
		return "Неверный запрос";
	}

}
