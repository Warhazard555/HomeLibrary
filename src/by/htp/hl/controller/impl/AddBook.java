package by.htp.hl.controller.impl;

import by.htp.hl.bean.Book;
import by.htp.hl.controller.Command;
import by.htp.hl.service.LibraryService;
import by.htp.hl.service.ServiceException;
import by.htp.hl.service.ServiceProvider;

public class AddBook implements Command {

	private final String delimeter = "/";
	
	@Override
	public String execute(String request) {
		String response = null;
		String author = null;
		String title = null;
		int year = 0;
		String type = null;
		boolean baby = false;
		String[] param = null;
		Book book = null;
		
		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		LibraryService libraryService = serviceProvider.getBookService();
		
		try {
			param = request.split(delimeter);
			author = param[1];
			title = param[2];
			year =Integer.parseInt(param[3]);
			type = param[4];
			if (param[5].equals("true")) {
				baby = true;
			}
			else if (param[5].equals("false")){
				baby = false;
			}
			book = new Book(author,title,year,type,baby);
			libraryService.addBook(book);
			System.out.println("Книга успешно добавлена в библиотеку");
		} catch (ServiceException e) {
			response = "Книга не была добавлена";
		}
		
		return response;
	}

}
