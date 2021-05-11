package by.htp.hl.dao;

import java.util.ArrayList;

import by.htp.hl.bean.Book;

public interface FindBookDAO {
	
	ArrayList<Book> findId (String id) throws DAOException;
	ArrayList<Book> findAuthor(String author) throws DAOException;
	ArrayList<Book> findTitle (String title) throws DAOException;
	ArrayList<Book> findIdBaby (String id) throws DAOException;
	ArrayList<Book> findAuthorBaby(String author) throws DAOException;
	ArrayList<Book> findTitleBaby (String title) throws DAOException;
	ArrayList<Book> findType (String type) throws DAOException;
	ArrayList<Book> findTypeBaby (String type) throws DAOException;

}
