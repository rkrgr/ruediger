package de.pecko.ruediger.commands;

import java.util.LinkedList;
import java.util.List;

import de.pecko.ruediger.S3Connection;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ListSoundsCommand extends ListenerAdapter {

	private static final int MESSAGE_LENGTH = 2000;
	private static final String SEPERATOR = ", ";

	@Override
	public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
		if (event.getName().equals("listsounds")) {
			event.deferReply().queue();
			
			S3Connection s3 = new S3Connection();
			List<String> soundnames = s3.listBucketObjects("ruediger", "sounds/");

			createMessages(soundnames).stream().forEach(soundname -> event.getHook().sendMessage(soundname).queue());
		}
	}

	List<String> createMessages(List<String> soundnames) {
		LinkedList<String> messages = new LinkedList<String>();

		List<String> soundnamesLeft = List.copyOf(soundnames);
		while (!soundnamesLeft.isEmpty()) {
			List<String> soundnamesForMessage = getFirstSoundnamesWithMaxLength(soundnamesLeft);
			messages.add(String.join(", ", soundnamesForMessage));
			soundnamesLeft = soundnamesLeft.subList(soundnamesForMessage.size(), soundnamesLeft.size());
		}

		return messages;
	}

	private List<String> getFirstSoundnamesWithMaxLength(List<String> soundnames) {
		int sum = 0;
		int i = -1;

		for (String soundname : soundnames) {
			sum += SEPERATOR.length() + soundname.length();
			if (sum - SEPERATOR.length() > MESSAGE_LENGTH) {
				break;
			}
			i++;
		}

		return soundnames.subList(0, i + 1);
	}

}
