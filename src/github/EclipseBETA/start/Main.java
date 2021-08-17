package github.EclipseBETA.start;

import org.bukkit.plugin.java.JavaPlugin;

import github.EclipseBETA.start.utils.DiscordWebhook;

public class Main extends JavaPlugin {
	
	public static Main plugin;
	public String webhookURL = "put webhook";
	
	@Override
	public void onEnable() {
		DiscordWebhook webhook = new DiscordWebhook(webhookURL);
		webhook.addEmbed(new DiscordWebhook.EmbedObject()
				.setDescription(":white_check_mark: **Server Started**"));
		try {
			webhook.execute();
		}
		catch(java.io.IOException e) {
			getLogger().severe(e.getStackTrace().toString());
		}
	}
	
	@Override
	public void onDisable() {
		DiscordWebhook webhook = new DiscordWebhook(webhookURL);
		webhook.addEmbed(new DiscordWebhook.EmbedObject()
				.setDescription(":x: **Server Ended**"));
		try {
			webhook.execute();
		}
		catch(java.io.IOException e) {
			getLogger().severe(e.getStackTrace().toString());
		}
	}
	
}
