package by.htp.hl.main;

import java.util.Scanner;

import by.htp.hl.controller.Controller;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String console = null;
		Controller controller = new Controller();
		String request = "SIGN_IN/";
		System.out.print("Login -> ");
		request += sc.nextLine();
		System.out.print("Password -> ");
		request += "/";
		request += sc.nextLine();
		request = controller.executeTask(request);

		if (request.equals("admin")) {
			System.out.println("Вам доступны следующие операции: ");
			System.out.println("1:Добавить книгу");
			System.out.println("2:Удалить книгу");
			System.out.println("3:Поиск нужной книги");
			System.out.println("4:Получить список всех книг");
			System.out.println("Введите номер операции ->");
			request = sc.nextLine();
			if (request.equals("1")) {
				request = "ADD_BOOK/";
				System.out.println("Укажите автора ->");
				request += sc.nextLine() + "/";
				System.out.println("Укажите название книги ->");
				request += sc.nextLine() + "/";
				System.out.println("Укажите год выхода ->");
				request += sc.nextLine() + "/";
				System.out.println("Укажите жанр или тип книги ->");
				request += sc.nextLine() + "/";
				System.out.println("Предназначена ли она для детей ->");
				System.out.println("1: Да");
				System.out.println("2: Нет");
				console = sc.nextLine();
				if (console.equals("1")) {
					request += "false";

				} else if (console.equals("2")) {
					request += "true";

				}
				controller.executeTask(request);
			}
			if (request.equals("2")) {
				request = "DELETE_BOOK/";
				System.out.println("Укажите, по какому параметру удалить ->");
				System.out.println("1: По Id");
				System.out.println("2: По автору");
				System.out.println("3: По названию");
				console = sc.nextLine();
				if (console.equals("1")) {
					System.out.println("Укажите ID ->");
					request += sc.nextLine() + "/null/null";
				}
				if (console.equals("2")) {
					System.out.println("Укажите автора книги ->");
					request += "null/" + sc.nextLine() + "/null";
				}
				if (console.equals("3")) {
					System.out.println("Укажите название книги ->");
					request += "null/null/" + sc.nextLine();
				}
				controller.executeTask(request);
			}

			if (request.equals("3")) {
				request = "FIND_BOOK/";
				System.out.println("Укажите, по какому параметру искать ->");
				System.out.println("1: По Id");
				System.out.println("2: По автору");
				System.out.println("3: По названию");
				System.out.println("4: По жанру или типу");
				console = sc.nextLine();
				if (console.equals("1")) {
					System.out.println("Укажите ID ->");
					request += sc.nextLine() + "/null/null/null/true";
				}
				if (console.equals("2")) {
					System.out.println("Укажите автора книги ->");
					request += "null/" + sc.nextLine() + "/null/null/true";
				}
				if (console.equals("3")) {
					System.out.println("Укажите название книги ->");
					request += "null/null/" + sc.nextLine() + "/null/true";
				}
				if (console.equals("4")) {
					console = "SET_ALL_TYPE/";
					System.out.println("Список имеющихся в библиотеке типов и жанров:");
					controller.executeTask(console);
					System.out.println("Введите нужный из списка ->");
					request += "null/null/null/" + sc.nextLine() + "/true";
				}
				controller.executeTask(request);

			}

			if (request.equals("4")) {
				request = "ARRAY_ALL_BOOK/true";
				controller.executeTask(request);
			}

		}
//То же, что и у админа
		if (request.equals("parent")) {
			System.out.println("Вам доступны следующие операции: ");
			System.out.println("1:Добавить книгу");
			System.out.println("2:Поиск нужной книги");
			System.out.println("3:Получить список всех книг");
			System.out.println("Введите номер операции:");
		}

		if (request.equals("child")) {
			System.out.println("Вам доступны следующие операции: ");
			System.out.println("1:Поиск нужной книги");
			System.out.println("2:Получить список всех книг");
			System.out.println("Введите номер операции:");
			request = sc.nextLine();
			if (request.equals("2")) {
				request = "ARRAY_ALL_BOOK/false";
				controller.executeTask(request);
			}
			
			if (request.equals("1")) {
				request = "FIND_BOOK/";
				System.out.println("Укажите, по какому параметру искать ->");
				System.out.println("1: По Id");
				System.out.println("2: По автору");
				System.out.println("3: По названию");
				System.out.println("4: По жанру или типу");
				console = sc.nextLine();
				if (console.equals("1")) {
					System.out.println("Укажите ID ->");
					request += sc.nextLine() + "/null/null/false";
				}
				if (console.equals("2")) {
					System.out.println("Укажите автора книги ->");
					request += "null/" + sc.nextLine() + "/null/false";
				}
				if (console.equals("3")) {
					System.out.println("Укажите название книги ->");
					request += "null/null/" + sc.nextLine() + "/false";
				}
				if (console.equals("4")) {
					console = "SET_ALL_TYPE/";
					System.out.println("Список имеющихся в библиотеке типов и жанров:");
					controller.executeTask(console);
					System.out.println("Введите нужный из списка ->");
					request += "null/null/null/" + sc.nextLine() + "/false";
				}
				controller.executeTask(request);

			}
		}

	}

}
