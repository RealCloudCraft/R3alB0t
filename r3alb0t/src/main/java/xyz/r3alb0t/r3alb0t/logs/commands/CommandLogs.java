package xyz.r3alb0t.r3alb0t.logs.commands;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

import io.discloader.discloader.client.command.Command;
import io.discloader.discloader.client.command.CommandTree;
import io.discloader.discloader.common.event.message.MessageCreateEvent;
import io.discloader.discloader.core.entity.RichEmbed;
import io.discloader.discloader.util.DLUtil.ChannelType;

public class CommandLogs extends CommandTree {

	private Map<String, Command> subs;

	public CommandLogs() {
		super("logs");
		subs = new HashMap<>();
	}

	public void defaultResponse(MessageCreateEvent e) {

	}

	public Map<String, Command> getSubCommands() {
		return subs;
	}

	public void executeEnable(MessageCreateEvent event, String[] args) {
		if (event.getChannel().getType() != ChannelType.TEXT) {
			RichEmbed embed = new RichEmbed("Enable Logging").setColor(0xff0101).addField("Error", "This command can only be executed in a **GuildTextChannel**").setTimestamp(OffsetDateTime.now(ZoneId.systemDefault()));
			event.getChannel().sendEmbed(embed);
			return;
		}
	}
}