package by.htp.hl.service.impl;

import java.util.ArrayList;
import java.util.TreeSet;

import by.htp.hl.bean.Book;
import by.htp.hl.dao.BookDAO;
import by.htp.hl.dao.DAOException;
import by.htp.hl.dao.DAOProvider;
import by.htp.hl.dao.FindBookDAO;
import by.htp.hl.dao.UserDAO;
import by.htp.hl.service.LibraryService;
import by.htp.hl.service.ServiceException;

public class LibraryServiceImpl implements LibraryService {

	@Override
	public void addBook(Book book) throws ServiceException {
		if (book == null) {
			throw new ServiceException("Книга не может быть добавлена. Поля не заполнены");
		}

		DAOProvider provider = DAOProvider.getInstance();
		BookDAO bookDAO = provider.getBookDAO();

		try {
			bookDAO.addBook(book);
		} catch (DAOException e) {

			throw new ServiceException("Ошибка операции");
		}

	}

	@Override
	public void deleteBook(String[] mas) throws ServiceException {
		String fieldTitle = null;
		String fieldId = null;
		String fieldAuthor = null;
		if (!mas[0].equals("null") && Integer.parseInt(mas[0]) < 0) {
			throw new ServiceException("Id задан некорректно");
		}
		if (mas[0].equals("null") && mas[1].equals("null") && mas[2].equals("null")) {
			throw new ServiceException("Поля не заполнены");
		}

		DAOProvider provider = DAOProvider.getInstance();
		BookDAO bookDAO = provider.getBookDAO();

		try {
			if (!mas[0].equals("null") && mas[1].equals("null") && mas[2].equals("null")) {
				fieldId = mas[0];
				bookDAO.deleteBookId(fieldId);
			}
			if (mas[0].equals("null") && !mas[1].equals("null") && mas[2].equals("null")) {
				fieldAuthor = mas[1];
				bookDAO.deleteBookAuthor(fieldAuthor);
			}
			if (mas[0].equals("null") && mas[1].equals("null") && !mas[2].equals("null")) {
				fieldTitle = mas[2];
				bookDAO.deleteBookTitle(fieldTitle);
			}

		} catch (DAOException e) {

			throw new ServiceException("Ошибка операции");
		}

	}

	@Override
	public ArrayList<Book> ArrayAllBookBaby() throws ServiceException {
		ArrayList<Book> books = null;

		DAOProvider provider = DAOProvider.getInstance();
		BookDAO bookDAO = provider.getBookDAO();

		try {
			books = bookDAO.ArrayAllBookBaby();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return books;

	}

	@Override
	public ArrayList<Book> ArrayAllBook() throws ServiceException {
		ArrayList<Book> books = null;

		DAOProvider provider = DAOProvider.getInstance();
		BookDAO bookDAO = provider.getBookDAO();

		try {
			books = bookDAO.ArrayAllBook();
		} catch (DAOException e) {

			throw new ServiceException(e);
		}
		return books;

	}

	@Override
	public ArrayList<Book> findBook(String[] mas) throws ServiceException {
		String fieldTitle = null;
		String fieldId = null;
		String fieldAuthor = null;
		String fieldType = null;
		ArrayList<Book> books = null;
		if (!mas[0].equals("null") && Integer.parseInt(mas[0]) < 0) {
			throw new ServiceException("Id задан некорректно");
		}
		if (mas[0].equals("null") && mas[1].equals("null") && mas[2].equals("null") && mas[3].equals("null")) {
			throw new ServiceException("Поля не заполнены");
		}

		DAOProvider provider = DAOProvider.getInstance();
		FindBookDAO findBookDAO = provider.getFindBookDAO();

		try {
			if (!mas[0].equals("null") && mas[1].equals("null") && mas[2].equals("null") && mas[3].equals("null")) {
				fieldId = mas[0];
				books = findBookDAO.findId(fieldId);
			}
			if (mas[0].equals("null") && !mas[1].equals("null") && mas[2].equals("null") && mas[3].equals("null")) {
				fieldAuthor = mas[1];
				books = findBookDAO.findAuthor(fieldAuthor);
			}
			if (mas[0].equals("null") && mas[1].equals("null") && !mas[2].equals("null") && mas[3].equals("null")) {
				fieldTitle = mas[2];
				books = findBookDAO.findTitle(fieldTitle);
			}
			if (mas[0].equals("null") && mas[1].equals("null") && mas[2].equals("null") && !mas[3].equals("null")) {
				fieldType = mas[3];
				books = findBookDAO.findType(fieldType);
			}

		} catch (DAOException e) {

			throw new ServiceException("Ошибка операции");
		}

		return books;
	}

	@Override
	public ArrayList<Book> findBookBaby(String[] mas) throws ServiceException {
		String fieldTitle = null;
		String fieldId = null;
		String fieldAuthor = null;
		String fieldType = null;
		ArrayList<Book> books = null;
		if (!mas[0].equals("null") && Integer.parseInt(mas[0]) < 0) {
			throw new ServiceException("Id задан некорректно");
		}
		if (mas[0].equals("null") && mas[1].equals("null") && mas[2].equals("null") && mas[3].equals("null")) {
			throw new ServiceException("Поля не заполнены");
		}

		DAOProvider provider = DAOProvider.getInstance();
		FindBookDAO findBookDAO = provider.getFindBookDAO();

		try {
			if (!mas[0].equals("null") && mas[1].equals("null") && mas[2].equals("null") && mas[3].equals("null")) {
				fieldId = mas[0];
				books = findBookDAO.findIdBaby(fieldId);
			}
			if (mas[0].equals("null") && !mas[1].equals("null") && mas[2].equals("null") && mas[3].equals("null")) {
				fieldAuthor = mas[1];
				books = findBookDAO.findAuthorBaby(fieldAuthor);
			}
			if (mas[0].equals("null") && mas[1].equals("null") && !mas[2].equals("null") && mas[3].equals("null")) {
				fieldTitle = mas[2];
				books = findBookDAO.findTitleBaby(fieldTitle);
			}
			if (mas[0].equals("null") && mas[1].equals("null") && mas[2].equals("null") && !mas[3].equals("null")) {
				fieldType = mas[3];
				books = findBookDAO.findTypeBaby(fieldType);
			}

		} catch (DAOException e) {

			throw new ServiceException("Ошибка операции");
		}

		return books;

	}

	@Override
	public TreeSet<String> SetAllType() throws ServiceException {
		TreeSet<String> types = null;
		
		DAOProvider provider = DAOProvider.getInstance();
		BookDAO bookDAO = provider.getBookDAO();
		
		try {
			types = bookDAO.SetAllType();
		} catch (DAOException e) {
			e.printStackTrace();
		}
			
		return types;
	}

}
