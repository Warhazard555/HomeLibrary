package by.htp.hl.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import by.htp.hl.bean.Book;
import by.htp.hl.dao.DAOException;
import by.htp.hl.dao.FindBookDAO;

public class FileFindBookDAO implements FindBookDAO {
	private final String fileName = "data/DataSourceBooks.txt";
	private final String delimeter = "/";
	private static BufferedReader reader = null;

	@Override
	public ArrayList<Book> findId(String id) throws DAOException {
		ArrayList<Book> books = new ArrayList<Book>();

		try {
			reader = new BufferedReader(new FileReader(fileName));
		} catch (IOException e) {

			e.printStackTrace();
		}

		String line = null;
		String[] line2 = null;
		Book lineBook;

		try {

			while ((line = reader.readLine()) != null) {
				line2 = line.split(delimeter);
				if (line2[0].equals(id)) {
					lineBook = new Book((Integer.parseInt(line2[0])), line2[1], line2[2], Integer.parseInt(line2[3]),
							line2[4]);
					books.add(lineBook);
				}

			}
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				reader.close();

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return books;

	}

	@Override
	public ArrayList<Book> findAuthor(String author) throws DAOException {
		ArrayList<Book> books = new ArrayList<Book>();

		try {
			reader = new BufferedReader(new FileReader(fileName));
		} catch (IOException e) {

			e.printStackTrace();
		}

		String line = null;
		String[] line2 = null;
		Book lineBook;

		try {

			while ((line = reader.readLine()) != null) {
				line2 = line.split(delimeter);
				if (line2[1].equals(author)) {
					lineBook = new Book((Integer.parseInt(line2[0])), line2[1], line2[2], Integer.parseInt(line2[3]),
							line2[4]);
					books.add(lineBook);
				}

			}
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				reader.close();

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return books;
	}

	@Override
	public ArrayList<Book> findTitle(String title) throws DAOException {
		ArrayList<Book> books = new ArrayList<Book>();

		try {
			reader = new BufferedReader(new FileReader(fileName));
		} catch (IOException e) {

			e.printStackTrace();
		}

		String line = null;
		String[] line2 = null;
		Book lineBook;

		try {

			while ((line = reader.readLine()) != null) {
				line2 = line.split(delimeter);
				if (line2[2].equals(title)) {
					lineBook = new Book((Integer.parseInt(line2[0])), line2[1], line2[2], Integer.parseInt(line2[3]),
							line2[4]);
					books.add(lineBook);
				}

			}
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				reader.close();

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return books;
	}

	@Override
	public ArrayList<Book> findIdBaby(String id) throws DAOException {
		ArrayList<Book> books = new ArrayList<Book>();

		try {
			reader = new BufferedReader(new FileReader(fileName));
		} catch (IOException e) {

			e.printStackTrace();
		}

		String line = null;
		String[] line2 = null;
		Book lineBook;

		try {

			while ((line = reader.readLine()) != null) {
				line2 = line.split(delimeter);
				if (line2[0].equals(id) && line2[5].equals("false")) {
					lineBook = new Book((Integer.parseInt(line2[0])), line2[1], line2[2], Integer.parseInt(line2[3]),
							line2[4]);
					books.add(lineBook);
				}

			}
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				reader.close();

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return books;

	}

	@Override
	public ArrayList<Book> findAuthorBaby(String author) throws DAOException {
		ArrayList<Book> books = new ArrayList<Book>();

		try {
			reader = new BufferedReader(new FileReader(fileName));
		} catch (IOException e) {

			e.printStackTrace();
		}

		String line = null;
		String[] line2 = null;
		Book lineBook;

		try {

			while ((line = reader.readLine()) != null) {
				line2 = line.split(delimeter);
				if (line2[1].equals(author) && line2[5].equals("false")) {
					lineBook = new Book((Integer.parseInt(line2[0])), line2[1], line2[2], Integer.parseInt(line2[3]),
							line2[4]);
					books.add(lineBook);
				}

			}
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				reader.close();

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return books;
	}

	@Override
	public ArrayList<Book> findTitleBaby(String title) throws DAOException {
		ArrayList<Book> books = new ArrayList<Book>();

		try {
			reader = new BufferedReader(new FileReader(fileName));
		} catch (IOException e) {

			e.printStackTrace();
		}

		String line = null;
		String[] line2 = null;
		Book lineBook;

		try {

			while ((line = reader.readLine()) != null) {
				line2 = line.split(delimeter);
				if (line2[2].equals(title) && line2[5].equals("false")) {
					lineBook = new Book((Integer.parseInt(line2[0])), line2[1], line2[2], Integer.parseInt(line2[3]),
							line2[4]);
					books.add(lineBook);
				}

			}
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				reader.close();

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return books;
	}

	@Override
	public ArrayList<Book> findType(String type) throws DAOException {
		ArrayList<Book> books = new ArrayList<Book>();

		try {
			reader = new BufferedReader(new FileReader(fileName));
		} catch (IOException e) {

			e.printStackTrace();
		}

		String line = null;
		String[] line2 = null;
		Book lineBook;

		try {

			while ((line = reader.readLine()) != null) {
				line2 = line.split(delimeter);
				if (line2[4].equals(type)) {
					lineBook = new Book((Integer.parseInt(line2[0])), line2[1], line2[2], Integer.parseInt(line2[3]),
							line2[4]);
					books.add(lineBook);
				}

			}
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				reader.close();

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return books;

	}

	@Override
	public ArrayList<Book> findTypeBaby(String type) throws DAOException {
		ArrayList<Book> books = new ArrayList<Book>();

		try {
			reader = new BufferedReader(new FileReader(fileName));
		} catch (IOException e) {

			e.printStackTrace();
		}

		String line = null;
		String[] line2 = null;
		Book lineBook;

		try {

			while ((line = reader.readLine()) != null) {
				line2 = line.split(delimeter);
				if (line2[4].equals(type) && line2[5].equals("false")) {
					lineBook = new Book((Integer.parseInt(line2[0])), line2[1], line2[2], Integer.parseInt(line2[3]),
							line2[4]);
					books.add(lineBook);
				}

			}
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				reader.close();

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return books;

	}

}
