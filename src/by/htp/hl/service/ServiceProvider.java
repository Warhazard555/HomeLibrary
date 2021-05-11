package by.htp.hl.service;

import by.htp.hl.service.impl.ClientServiceImpl;
import by.htp.hl.service.impl.LibraryServiceImpl;

public final class ServiceProvider {
	private static final ServiceProvider instance = new ServiceProvider();
	
	private ClientService userService = new ClientServiceImpl();
	private LibraryService bookService = new LibraryServiceImpl();
	
	private ServiceProvider() {}
	
	public static ServiceProvider getInstance() {
		return instance;
	}

	public ClientService getUserService() {
		return userService;
	}

	public LibraryService getBookService() {
		return bookService;
	}

	public void setUserService(ClientService userService) {
		this.userService = userService;
	}

	public void setBookService(LibraryService bookService) {
		this.bookService = bookService;
	}
	


}
