package xyz.r3alb0t.r3alb0t.common;

import io.discloader.discloader.common.event.DLPreInitEvent;
import io.discloader.discloader.common.event.EventListenerAdapter;
import io.discloader.discloader.common.event.RawEvent;
import io.discloader.discloader.common.event.ReadyEvent;
import xyz.r3alb0t.r3alb0t.R3alB0t;
import xyz.r3alb0t.r3alb0t.logs.LogHandler;

public class EventHandler extends EventListenerAdapter {

	@Override
	public void RawPacket(RawEvent data) {
		if (data.isGateway()) {
			// WebSocketFrame frame = data.getFrame();
			// if (frame.isTextFrame())
			// System.out.println(frame.getPayloadText());
		} else if (data.isREST()) {
			// System.out.println(data.getHttpResponse().getBody());
		}
	}

	@Override
	public void PreInit(DLPreInitEvent e) {
		R3alB0t.logger.info("Registering music commands");
		Commands.registerCommands();
		LogHandler.load();
	}

	@Override
	public void Ready(ReadyEvent event) {
		event.loader.user.setGame("Converting to DiscLoader");
		R3alB0t.logger.info("Ready");
	}

}
