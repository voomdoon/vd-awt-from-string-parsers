package de.voomdoon.parser.fromstring.awt;

import java.awt.Color;
import java.text.ParseException;

import de.voomdoon.parser.fromstring.FromStringParsers.FromStringParser;

/**
 * DOCME add JavaDoc for
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
	public Color parse(String string) throws ParseException {
		String[] split = string.split(",");

		return new Color(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
	}
}
