package de.pecko.ruediger.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListSoundsCommandTest {

	private static final List<String> SOUNDNAMES_2000_CHARS = Arrays.asList("bang", "monkey", "whistle", "clap", "pop",
			"click", "thud", "roar", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang",
			"monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle", "clap", "pop",
			"click", "thud", "roar", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang",
			"monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle", "clap", "pop",
			"click", "thud", "roar", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang",
			"monke");

	private static final List<String> SOUNDNAMES_MORE_THAN_2000_CHARS = Arrays.asList("bang", "monkey", "whistle",
			"clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar",
			"bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle", "clap",
			"pop", "click", "thud", "roar", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang",
			"monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle", "clap", "pop",
			"click", "thud", "roar", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang",
			"monkey", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle",
			"clap", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle",
			"clap", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle",
			"clap", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle",
			"clap", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle",
			"clap", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle",
			"clap", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle",
			"clap", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle",
			"clap", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle",
			"clap", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle",
			"clap", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle",
			"clap", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle",
			"clap", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle",
			"clap", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle",
			"clap", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle",
			"clap", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle",
			"clap", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle",
			"clap", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle",
			"clap", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle",
			"clap", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle",
			"clap", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle",
			"clap", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle",
			"clap", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle",
			"clap", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle",
			"clap", "bang", "monkey", "whistle", "clap", "pop", "click", "thud", "roar", "bang", "monkey", "whistle",
			"clap");

	private ListSoundsCommand command;

	@BeforeEach
	private void setUp() {
		command = new ListSoundsCommand();
	}

	@Test
	void splitSoundsShuldCreateTwoMessagesWithMoreThan2000Chars() {
		List<String> messages = command.createMessages(SOUNDNAMES_MORE_THAN_2000_CHARS);
		assertEquals(2, messages.size());
		assertEquals(
				"bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, bang",
				messages.get(0));
		assertEquals(
				"monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap",
				messages.get(1));
	}

	@Test
	void splitSoundsShuldCreateOneMessageWithLessThan2000Chars() {
		List<String> messages = command.createMessages(SOUNDNAMES_2000_CHARS);
		assertEquals(1, messages.size());
		assertEquals(
				"bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monkey, whistle, clap, pop, click, thud, roar, bang, monke",
				messages.get(0));
	}

}
