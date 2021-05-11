package by.htp.hl.bean;

public class Book {
	private int id;
	private String author;
	private String title;
	private int year;
	private String type;
	private boolean baby;
	
	public Book () {}

	public Book(int id, String author, String title, int year, String type, boolean baby) {
		this.id = id;
		this.author = author;
		this.title = title;
		this.year = year;
		this.type = type;
		this.baby = baby;
	}
	
	public Book(int id, String author, String title, int year, String type) {
		this.id = id;
		this.author = author;
		this.title = title;
		this.year = year;
		this.type = type;
		
	}

	public Book(int id, String author, String title) {
		this.id = id;
		this.author = author;
		this.title = title;
	}

	public Book(String author, String title) {
		this.author = author;
		this.title = title;
	}

	public Book(String author, String title, int year) {
		this.author = author;
		this.title = title;
		this.year = year;
	}

	public Book(String author, String title, int year, String type) {
		this.author = author;
		this.title = title;
		this.year = year;
		this.type = type;
	}
	public Book(String author, String title, int year, String type, boolean baby) {
		this.author = author;
		this.title = title;
		this.year = year;
		this.type = type;
		this.baby = baby;
	}

	public int getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public String getType() {
		return type;
	}

	public boolean isBaby() {
		return baby;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setBaby(boolean baby) {
		this.baby = baby;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + (baby ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (baby != other.baby)
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return /*getClass().getName() +*/ " id: " + id + ", автор: " + author + ", название: " + title + ", "
				+ "год выхода: " + year + ", тип: " + type + "";
	}

}
