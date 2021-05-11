package by.htp.hl.controller.impl;

import java.util.ArrayList;

import by.htp.hl.bean.Book;
import by.htp.hl.controller.Command;
import by.htp.hl.service.LibraryService;
import by.htp.hl.service.ServiceException;
import by.htp.hl.service.ServiceProvider;

public class FindBook implements Command {
	private final String delimeter = "/";

	@Override
	public String execute(String request) {
		ArrayList<Book> books = null;
		String response = null;
		String[] param = null;
		String[] mas = new String[4];

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		LibraryService libraryService = serviceProvider.getBookService();

		try {
			param = request.split(delimeter);
			if (!param[1].equals("null") || !param[2].equals("null") || !param[3].equals("null")
					|| !param[4].equals("null")) {
				mas[0] = param[1];
				mas[1] = param[2];
				mas[2] = param[3];
				mas[3] = param[4];
			}
			if (param[5].equals("true")) {
				books = libraryService.findBook(mas);
			}
			if (param[5].equals("false")) {
				books = libraryService.findBookBaby(mas);
			}
			for (int i = 0; i < books.size(); i++) {
				System.out.println(books.get(i));
			}

		} catch (ServiceException e) {
			response = "Книга не найдена";
		}

		return response;

	}

}
