package by.htp.hl.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

import by.htp.hl.bean.Book;
import by.htp.hl.dao.BookDAO;
import by.htp.hl.dao.DAOException;

public class FileBookDAO implements BookDAO {
	private final String fileName = "data/DataSourceBooks.txt";
	private final String delimeter = "/";
	private static BufferedReader reader = null;
	private static FileWriter writer = null;
	private static BufferedWriter bufferedWriter = null;

	@Override
	public void addBook(Book book) throws DAOException {
		int id = BookId();
		String baby = String.valueOf(book.isBaby());
		String newBook = "\n" + id + "/" + book.getAuthor() + "/" + book.getTitle() + "/" + book.getYear() + "/"
				+ book.getType() + "/" + baby;
		try {
			writer = new FileWriter(fileName, true);
			bufferedWriter = new BufferedWriter(writer);
			bufferedWriter.write(newBook);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	private int BookId() throws DAOException {
		int id = 0;

		try {
			reader = new BufferedReader(new FileReader(fileName));
			String temp = null;
			String str = null;
			while ((str = reader.readLine()) != null) {
				if (!str.equals("")) {
					temp = str;
				}

				String[] line = temp.split(delimeter);
				id = Integer.parseInt(line[0]) + 1;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public void deleteBookId(String fieldId) throws DAOException {
		File sourceFile = new File("data/DataSourceBooks.txt");
		File outputFile = new File("data/Temp.txt");

		try {
			bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
			reader = new BufferedReader(new FileReader(sourceFile));
		} catch (IOException e) {

			e.printStackTrace();
		}

		String line = null;
		String[] line2 = null;
		try {

			while ((line = reader.readLine()) != null) {
				line2 = line.split(delimeter);
				if (!line2[0].equals(fieldId)) {
					bufferedWriter.write(line);
					bufferedWriter.newLine();
				}

			}
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				reader.close();
				bufferedWriter.close();
				sourceFile.delete();
				outputFile.renameTo(sourceFile);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

	@Override
	public void deleteBookTitle(String fieldTitle) throws DAOException {
		File sourceFile = new File("data/DataSourceBooks.txt");
		File outputFile = new File("data/Temp.txt");

		try {
			bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
			reader = new BufferedReader(new FileReader(sourceFile));
		} catch (IOException e) {

			e.printStackTrace();
		}

		String line = null;
		String[] line2 = null;
		try {

			while ((line = reader.readLine()) != null) {
				line2 = line.split(delimeter);
				if (!line2[2].equals(fieldTitle)) {
					bufferedWriter.write(line);
					bufferedWriter.newLine();
				}

			}
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				reader.close();
				bufferedWriter.close();
				sourceFile.delete();
				outputFile.renameTo(sourceFile);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

	@Override
	public void deleteBookAuthor(String fieldAuthor) throws DAOException {
		File sourceFile = new File("data/DataSourceBooks.txt");
		File outputFile = new File("data/Temp.txt");

		try {
			bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
			reader = new BufferedReader(new FileReader(sourceFile));
		} catch (IOException e) {

			e.printStackTrace();
		}

		String line = null;
		String[] line2 = null;
		try {

			while ((line = reader.readLine()) != null) {
				line2 = line.split(delimeter);
				if (!line2[1].equals(fieldAuthor)) {
					bufferedWriter.write(line);
					bufferedWriter.newLine();
				}

			}
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				reader.close();
				bufferedWriter.close();
				sourceFile.delete();
				outputFile.renameTo(sourceFile);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

	@Override
	public ArrayList<Book> ArrayAllBook() throws DAOException {
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

				lineBook = new Book((Integer.parseInt(line2[0])), line2[1], line2[2], Integer.parseInt(line2[3]),
						line2[4]);
				books.add(lineBook);

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
	public ArrayList<Book> ArrayAllBookBaby() throws DAOException {
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
				if (line2[5].equals("false")) {
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
	public TreeSet<String> SetAllType() throws DAOException {
		TreeSet<String> types = new TreeSet<String>();
		

		try {
			reader = new BufferedReader(new FileReader(fileName));
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		String line = null;
		String[] line2 = null;
		String typeBook;

		try {

			while ((line = reader.readLine()) != null) {
				line2 = line.split(delimeter);
					typeBook = line2[4];
					types.add(typeBook);
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

		return types;
	}



}
