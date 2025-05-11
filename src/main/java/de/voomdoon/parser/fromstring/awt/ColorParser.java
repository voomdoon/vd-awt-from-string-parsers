package de.voomdoon.parser.fromstring.awt;

import java.awt.Color;
import java.text.ParseException;
import java.util.NoSuchElementException;

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

		if (split.length == 3) {
			return new Color(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
		} else if (split.length == 1) {
			try {
				return (Color) Color.class.getField(string).get(null);
			} catch (NoSuchFieldException e) {
				throw new NoSuchElementException("No Color constant named '" + string + "'");
			} catch (IllegalArgumentException | IllegalAccessException | SecurityException e) {
				throw new RuntimeException(
						"Unexpected error while parsing Color from '" + string + "': " + e.getMessage(), e);
			}
		} else {
			// TODO implement parse
			throw new UnsupportedOperationException("Method 'parse' not implemented for '" + string + "'!");
		}
	}
}
