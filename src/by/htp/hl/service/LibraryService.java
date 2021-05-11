package by.htp.hl.service;

import java.util.ArrayList;
import java.util.TreeSet;

import by.htp.hl.bean.Book;
import by.htp.hl.dao.DAOException;

public interface LibraryService {
	void addBook(Book book) throws ServiceException;
	void deleteBook(String[] mas) throws ServiceException;
	ArrayList<Book> findBook (String[] mas) throws ServiceException;
	ArrayList<Book> findBookBaby (String[] mas) throws ServiceException;
	ArrayList<Book> ArrayAllBookBaby () throws ServiceException;
	ArrayList<Book> ArrayAllBook() throws ServiceException;
	TreeSet<String> SetAllType() throws ServiceException;

}
