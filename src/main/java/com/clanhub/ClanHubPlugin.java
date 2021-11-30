package com.clanhub;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ImageUtil;

import java.awt.image.BufferedImage;
import java.io.IOException;

@Slf4j
@PluginDescriptor(
		name = "Clan Hub",
		description = "A plugin used to keep track of clan events/announcements",
		tags = {"clan", "pass", "event"}
)
public class ClanHubPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ClanHubConfig config;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ClanHubOverlay overlay;

	@Inject
	private SkillIconManager skillIconManager;

	@Inject
	private ClientToolbar clientToolbar;
	private ClanHubPanel panel;
	private NavigationButton uiNavigationButton;

	static final String CONFIG_GROUP = "clanhub";

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		startClanPanel();
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		clientToolbar.removeNavigation(uiNavigationButton);
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event) throws IOException {
		if (event.getGroup().equals(CONFIG_GROUP))
		{
			panel.removeAll();
			clientToolbar.removeNavigation(uiNavigationButton);
			startClanPanel();
		}
	}

	private void startClanPanel()
	{
		if (!config.sheetId().equals("") && !config.apiKey().equals(""))
		{
			final BufferedImage icon = ImageUtil.loadImageResource(getClass(), "icon.png");
			panel = injector.getInstance(ClanHubPanel.class);
			panel.init(config, 0);
			uiNavigationButton = NavigationButton.builder()
					.tooltip("Clan Hub")
					.icon(icon)
					.priority(7)
					.panel(panel)
					.build();
			clientToolbar.addNavigation(uiNavigationButton);
		}
	}

	@Provides
    ClanHubConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ClanHubConfig.class);
	}
}
