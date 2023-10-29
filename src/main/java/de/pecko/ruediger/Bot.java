package de.pecko.ruediger;

import java.util.Collections;

import de.pecko.ruediger.commands.ListSoundsCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class Bot extends ListenerAdapter {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("You have to provide a token as first argument!");
			System.exit(1);
		}

		JDA jda = JDABuilder.createLight(args[0], Collections.emptyList()).addEventListeners(new Bot(), new ListSoundsCommand()).build();

		jda.updateCommands().addCommands(Commands.slash("ping", "Calculate ping of the bot"),
				Commands.slash("listsounds", "Lists all available sounds")).queue();
	}

	@Override
	public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
		// make sure we handle the right command
		switch (event.getName()) {
		case "ping":
			long time = System.currentTimeMillis();
			event.reply("Pong!").setEphemeral(true) // reply or acknowledge
					.flatMap(v -> event.getHook().editOriginalFormat("Pong: %d ms", System.currentTimeMillis() - time) // then
																														// edit
																														// original
					).queue(); // Queue both reply and edit
			break;
		}
	}
}
