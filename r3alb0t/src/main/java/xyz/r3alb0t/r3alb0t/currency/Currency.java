package xyz.r3alb0t.r3alb0t.currency;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import io.discloader.discloader.entity.util.SnowflakeUtil;
import xyz.r3alb0t.r3alb0t.util.DataBase;

/**
 * @author Perry Berman
 *
 */
public class Currency {
	
	private static final List<Long> Guilds = new ArrayList<>();
	
	public static void load() {
		Set<String> guilds = DataBase.getDataBase().smembers("currency.guilds");
		for (String guild : guilds) {
			Guilds.add(SnowflakeUtil.parse(guild));
		}
		
	}
	

	public static String userBal(long guildID, long userID) {
		return String.format("currency.%d:%d", guildID, userID);
	}
	
	public static String userCooldown(long guildID, long userID) {
		return String.format("currency.%d:%d.cooldown", guildID, userID);
	}
	
	public static String rewards(long guildID) {
		return String.format("currency.%d:rewards", guildID);
	}
	
	public static String reward(long guildID, String id) {
		return String.format("currency.%d:rewards.%s", guildID, id);
	}
	
	public static String reward(long guildID, long id) {
		return String.format("currency.%d:rewards.%d", guildID, id);
	}
	
	/**
	 * @return the guilds
	 */
	public static List<Long> getGuilds() {
		return Guilds;
	}
}
