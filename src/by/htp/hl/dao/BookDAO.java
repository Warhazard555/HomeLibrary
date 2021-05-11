package by.htp.hl.dao;

import java.util.ArrayList;
import java.util.TreeSet;

import by.htp.hl.bean.Book;

public interface BookDAO {
	void addBook(Book book) throws DAOException;
	void deleteBookAuthor(String fieldAuthor) throws DAOException;
	void deleteBookTitle(String fieldTitle) throws DAOException;
	void deleteBookId(String fieldId) throws DAOException;
	ArrayList<Book> ArrayAllBook () throws DAOException;
	ArrayList<Book> ArrayAllBookBaby () throws DAOException;
	TreeSet<String> SetAllType () throws DAOException;
	
	

}
