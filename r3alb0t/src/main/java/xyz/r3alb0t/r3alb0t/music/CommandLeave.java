package xyz.r3alb0t.r3alb0t.music;

import io.discloader.discloader.client.command.Command;
import io.discloader.discloader.client.render.util.Resource;
import io.discloader.discloader.common.event.message.MessageCreateEvent;
import io.discloader.discloader.common.registry.EntityRegistry;
import io.discloader.discloader.entity.guild.IGuild;
import io.discloader.discloader.entity.voice.VoiceConnect;

/**
 * @author Perry Berman
 */
public class CommandLeave extends Command {

	public CommandLeave() {
		setTextureName("r3alb0t:eject");
		setUnlocalizedName("leave");
	}

	public Resource getResourceLocation() {
		return new Resource("r3alb0t", "texture/command/Eject.png");
	}

	@Override
	public void execute(MessageCreateEvent e) {
		IGuild guild = e.getMessage().getGuild();
		if (guild != null) {
			VoiceConnect connection = EntityRegistry.getVoiceConnectionByGuild(guild);
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

}
