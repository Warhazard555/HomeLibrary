package by.htp.hl.controller.impl;

import java.util.ArrayList;
import java.util.TreeSet;

import by.htp.hl.bean.Book;
import by.htp.hl.controller.Command;
import by.htp.hl.service.LibraryService;
import by.htp.hl.service.ServiceException;
import by.htp.hl.service.ServiceProvider;

public class SetAllType implements Command {
	private final String delimeter = "/";

	@Override
	public String execute(String request) {
		TreeSet <String> books=null;
		String response = null;
		String[] param = null;
		
		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		LibraryService libraryService = serviceProvider.getBookService();
		
		try {		
			books = libraryService.SetAllType();
			for (String s : books) {
				System.out.println(s);
			}			
		} catch (ServiceException e) {
			response = "Библиотека пуста";
			}
		
		return response;
	}

}
