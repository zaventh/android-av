/**
 * 
 */
package com.steelthorn.android.av;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeff Mixon
 * 
 */
public class DemoScanDefinitionProvider implements IScanDefinitionProvider
{
	private static String[] droidDreamPackages = new String[] { "advanced.piano", "com.Funny.Face", "com.advanced.SoundManager",
			"com.advanced.scientific.calculator", "com.app.aun", "com.apps.tosd", "com.beauty.leg", "com.bubble", "com.dice.power", "com.dice.power.advanced",
			"com.dodge.game.fallingball", "com.droiddream.advancedtaskkiller1", "com.droiddream.android.afdvancedfm", "com.droiddream.barcodescanner",
			"com.droiddream.basketball", "com.droiddream.blueftp", "com.droiddream.bowlingtime", "com.droiddream.comparator", "com.droiddream.compasslevel",
			"com.droiddream.daltonismo", "com.droiddream.fallingball", "com.droiddream.game.omok", "com.droiddream.glowhockey", "com.droiddream.howtotie",
			"com.droiddream.lovePositions", "com.droiddream.musicbox", "com.droiddream.passwordsafe", "com.droiddream.pewpew", "com.droiddream.sexringtones",
			"com.droiddream.stopwatch", "com.droiddream.system.app.remover", "com.editor.photoenhance", "com.fall.down", "com.fall.soft.down",
			"com.free.chess", "com.free.game.finger", "com.hg.panzerpanic1", "com.hz.game.mrrunner1", "com.magic.spiral", "com.power.SuperSolo",
			"com.power.basketball", "com.power.demo.note", "com.power.magic.StrobeLight", "com.quick.Delete", "com.sex.japaneese.girls", "com.sexsound.hilton",
			"com.sexy.hotgirls", "com.sexy.legs", "com.spider.man", "com.super.mp3ringtone", "hot.goddchen.sexyvideos", "org.droiddream.yellow4",
			"power.nick.ypaint", "power.power.rate", "powerstudio.spiderman", "proscio.app.nick.ypaint", "super.sancron.ringtones.sexysb", "org.super.yellow4",
			"com.droid.publick.hotgirls", "com.super.free.sexringtones", "hot.goddchen.power.sexyvideos" };

	private List<IScanDefinitionGroup> _groups;

	/* (non-Javadoc)
	 * @see com.steelthorn.android.av.IScanDefinitionProvider#getDefinitions()
	 */
	@Override
	public List<IScanDefinitionGroup> getDefinitions()
	{

		if (_groups != null)
			return _groups;

		_groups = new ArrayList<IScanDefinitionGroup>();

		for (int i = 0; i < droidDreamPackages.length; i++)
		{
			List<IScanDefinition> defList = new ArrayList<IScanDefinition>();
			try
			{
				MessageDigest md = MessageDigest.getInstance("SHA-1");
				md.update(droidDreamPackages[i].getBytes());
				DemoDefinition def = new DemoDefinition(droidDreamPackages[i], md.digest());
				defList.add(def);

				DemoDefinitionGroup group = new DemoDefinitionGroup(i, defList);

				_groups.add(group);

			}
			catch (NoSuchAlgorithmException e)
			{
				e.printStackTrace();
			}
		}

		return _groups;
	}

	private static class DemoDefinitionGroup implements IScanDefinitionGroup
	{
		private final int _id;
		private final List<IScanDefinition> _defs;

		public DemoDefinitionGroup(int id, List<IScanDefinition> definitions)
		{
			_id = id;
			_defs = definitions;
		}

		@Override
		public int getDefinitionGroupId()
		{
			return _id;
		}

		@Override
		public byte getDefinitionType()
		{
			return DefinitionType.ANDROID_PACKAGE;
		}

		@Override
		public List<IScanDefinition> getDefinitions()
		{
			return _defs;
		}

	}
}
