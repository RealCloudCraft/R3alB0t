package xyz.r3alb0t.r3alb0t.logs.commands;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

import io.discloader.discloader.client.command.Command;
import io.discloader.discloader.client.command.CommandTree;
import io.discloader.discloader.common.event.message.MessageCreateEvent;
import io.discloader.discloader.core.entity.RichEmbed;
import io.discloader.discloader.entity.guild.IGuild;
import io.discloader.discloader.util.DLUtil.ChannelType;
import xyz.r3alb0t.r3alb0t.logs.LogHandler;

public class CommandEnable extends CommandTree {

	private Map<String, Command> subs;

	public CommandEnable() {
		super("enable");
		subs = new HashMap<>();
		setDescription("enables logging for the guild");
	}

	public void defaultResponse(MessageCreateEvent e) {
		if (e.getChannel().getType() != ChannelType.TEXT) {
			RichEmbed embed = new RichEmbed("Enable Logging").setColor(0xff0101).addField("Error", "This command can only be executed in a **GuildTextChannel**").setTimestamp(OffsetDateTime.now(ZoneId.systemDefault()));
			e.getChannel().sendEmbed(embed);
			return;
		}
		IGuild guild = e.getMessage().getGuild();
		if (LogHandler.enabledGuilds.containsKey(guild.getID())) {

		}
	}

	public Map<String, Command> getSubCommands() {
		return subs;
	}
}