package by.htp.hl.controller;

import java.util.HashMap;
import java.util.Map;

import by.htp.hl.controller.impl.AddBook;
import by.htp.hl.controller.impl.ArrayAllBook;
import by.htp.hl.controller.impl.DeleteBook;
import by.htp.hl.controller.impl.FindBook;
import by.htp.hl.controller.impl.SetAllType;
import by.htp.hl.controller.impl.SignIn;
import by.htp.hl.controller.impl.WrongRequest;

public final class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();
	
	CommandProvider(){
		repository.put(CommandName.SIGN_IN, new SignIn());
		repository.put(CommandName.ADD_BOOK, new AddBook());
		repository.put(CommandName.DELETE_BOOK, new DeleteBook());
		repository.put(CommandName.FIND_BOOK, new FindBook());
		repository.put(CommandName.ARRAY_ALL_BOOK, new ArrayAllBook());
		repository.put(CommandName.SET_ALL_TYPE, new SetAllType());
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
	}
	
	Command getCommand(String name) {
		CommandName commandName = null;
		Command command = null;
		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		}catch(IllegalArgumentException | NullPointerException e) {
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		return command;
	}

}
