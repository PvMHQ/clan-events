package com.clanhub;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

import java.awt.*;

@ConfigGroup(ClanHubPlugin.CONFIG_GROUP)
public interface ClanHubConfig extends Config
{
	@ConfigSection(
			name = "Event Password",
			description = "Password info for clan event",
			position = 0
	)
	String eventPassSection = "Event Passphrase";

	@ConfigSection(
			name = "Google Sheets",
			description = "Google Sheet API Config",
			position = 1
	)
	String gSheetsSection = "Google Sheets API";

	@ConfigItem(
			position = 1,
			keyName = "overlay",
			name = "Display the overlay",
			description = "Display the overlay on your game screen",
			section = eventPassSection
	)
	default boolean overlay()
	{
		return false;
	}

	@ConfigItem(
			position = 2,
			keyName = "eventPass",
			name = "Event Password",
			description = "Creates an overlay with the event password time",
			section = eventPassSection
	)
	default String eventPass()
	{
		return "";
	}
	@ConfigItem(
			position = 3,
			keyName = "dtm",
			name = "Include Date & Time",
			description = "Display the date and time",
			section = eventPassSection
	)
	default boolean dtm()
	{
		return true;
	}

	@ConfigItem(
			position = 4,
			keyName = "subPass",
			name = "Bounty/Challenge Password",
			description = "Display the sub passsword.",
			section = eventPassSection
	)
	default String subPass()
	{
		return "";
	}

	@ConfigItem(
			position = 4,
			keyName = "disclaimer",
			name = "Colors MUST be different:",
			description = "The Password color and the Date/Time color must be different",
			section = eventPassSection
	)
	default void disclaimer() {}

	@ConfigItem(
			position = 5,
			keyName = "passColor",
			name = "Password Color",
			description = "Configures the color of the passphrase",
			section = eventPassSection
	)
	default Color passColor()
	{
		return Color.GREEN;
	}

	@ConfigItem(
			position = 10,
			keyName = "timeColor",
			name = "Time Color",
			description = "Configures the color of the date and time",
			section = eventPassSection
	)
	default Color timeColor()
	{
		return Color.WHITE;
	}

	@ConfigItem(
			position = 6,
			keyName = "sheetId",
			name = "Google Sheet ID (Restart plugin)",
			description = "ID of the google sheet to read.  You may need to restart the plugin after you have changed this.",
			section = gSheetsSection
	)
	default String sheetId()
	{
		return "1YMcXxSL3s1NEzsPVMMkPn7EdGNFKENiwqNyDKkJTO80";
	}

	@ConfigItem(
			position = 7,
			keyName = "apiKey",
			name = "Google Sheet API Key",
			description = "Google project API Key (ask your clan for one).  You may need to restart the plugin after you have changed this.",
			section = gSheetsSection
	)
	default String apiKey()
	{
		return "";
	}

	@ConfigItem(
			position = 8,
			keyName = "col1color",
			name = "Column 1 Color",
			description = "Configures the color of the spreadsheet column displayed",
			section = gSheetsSection
	)
	default Color col1color()
	{
		return Color.white;
	}

	@ConfigItem(
			position = 9,
			keyName = "col2color",
			name = "Column 2 Color",
			description = "Configures the color of the spreadsheet column displayed",
			section = gSheetsSection
	)
	default Color col2color()
	{
		return Color.GREEN;
	}
}