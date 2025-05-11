package de.voomdoon.parser.fromstring.awt;

import java.awt.Color;
import java.text.ParseException;

import de.voomdoon.parser.fromstring.FromStringParser;

//TODO unify with de.voomdoon.util.commons.parsing.AwtParsingUtil.parseColor(String)

/**
 * {@link FromStringParser} for {@link Color}.
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
public class ColorParser implements FromStringParser<Color> {

	/**
	 * @since 0.1.0
	 */
	@Override
	public Class<Color> getResultClass() {
		return Color.class;
	}

	/**
	 * @since 0.1.0
	 */
	@Override
	public Color parse(String string) throws ParseException {
		String[] split = string.split(",");

		return new Color(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
	}
}
