package by.htp.hl.controller.impl;

import java.util.ArrayList;

import by.htp.hl.bean.Book;
import by.htp.hl.controller.Command;
import by.htp.hl.service.LibraryService;
import by.htp.hl.service.ServiceException;
import by.htp.hl.service.ServiceProvider;

public class ArrayAllBook implements Command {
	private final String delimeter = "/";

	@Override
	public String execute(String request) {
		ArrayList<Book> books = null;
		String response = null;
		String[] param = null;
		String baby = null;

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		LibraryService libraryService = serviceProvider.getBookService();

		try {
			param = request.split(delimeter);
			baby = param[1];
			if (baby.equals("false")) {
				books = libraryService.ArrayAllBookBaby();
			}
			if (baby.equals("true")) {
				books = libraryService.ArrayAllBook();
			}
			for (int i = 0; i < books.size(); i++) {
				System.out.println(books.get(i));
			}

		} catch (ServiceException e) {
			response = "Ошибка операции";
		}

		return response;
	}

}
