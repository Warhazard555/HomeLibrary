package by.htp.hl.dao;

import by.htp.hl.dao.impl.FileBookDAO;
import by.htp.hl.dao.impl.FileFindBookDAO;
import by.htp.hl.dao.impl.FileUserDAO;

public final class DAOProvider {
	private static final DAOProvider instance = new DAOProvider();
	
	private UserDAO userDAO = new FileUserDAO();
	private BookDAO bookDAO = new FileBookDAO();
	private FindBookDAO findBookDAO = new FileFindBookDAO();
	
	private DAOProvider() {
	}

	public static DAOProvider getInstance() {
		return instance;
	}
	
	public FindBookDAO getFindBookDAO() {
		return findBookDAO;
	}

	public void setFindBookDAO(FindBookDAO findBookDAO) {
		this.findBookDAO = findBookDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

}
