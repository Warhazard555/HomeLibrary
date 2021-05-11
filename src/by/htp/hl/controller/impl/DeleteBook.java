package by.htp.hl.controller.impl;

import by.htp.hl.controller.Command;
import by.htp.hl.service.LibraryService;
import by.htp.hl.service.ServiceException;
import by.htp.hl.service.ServiceProvider;

public class DeleteBook implements Command {
	private final String delimeter = "/";

	@Override
	public String execute(String request) {
		String response = null;
		String[] param = null;
		String[] mas = new String[3];

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		LibraryService libraryService = serviceProvider.getBookService();

		try {		
			param = request.split(delimeter);
			if (!param[1].equals("null") || !param[2].equals("null") || !param[3].equals("null")) {
				mas[0] = param[1];
				mas[1] = param[2];
				mas[2] = param[3];		
			}
			libraryService.deleteBook(mas);
			System.out.println("Книга удалена");
		} catch (ServiceException e) {
			response = "Книга не удалена";
		} 

		return response;
	}

}
