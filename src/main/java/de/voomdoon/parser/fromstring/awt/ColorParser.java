package de.voomdoon.parser.fromstring.awt;

import java.awt.Color;
import java.text.ParseException;
import java.util.NoSuchElementException;

import de.voomdoon.parser.fromstring.FromStringParser;

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
	public static final ColorParser DEFAULT = new ColorParser();

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

		if (split.length == 1) {
			return parseColorByName(string);
		} else if (split.length == 3) {
			return parseRGB(split);
		} else if (split.length == 4) {
			return parseRGBA(split);
		} else {
			throw new IllegalArgumentException("Failed to parse Color from '" + string
					+ "': Unexpected amount of elements: Expecting 3 to 4 but found " + split.length + "!");
		}
	}

	/**
	 * @param string
	 *            {@link String}
	 * @return {@link Color}
	 * @since 0.1.0
	 */
	private Color parseColorByName(String string) {
		try {
			return (Color) Color.class.getField(string).get(null);
		} catch (NoSuchFieldException e) {
			throw new NoSuchElementException("No Color constant named '" + string + "'");
		} catch (IllegalArgumentException | IllegalAccessException | SecurityException e) {
			throw new RuntimeException("Unexpected error while parsing Color from '" + string + "': " + e.getMessage(),
					e);
		}
	}

	/**
	 * @param split
	 *            {@link String} array
	 * @return {@link Color}
	 * @since 0.1.0
	 */
	private Color parseRGB(String[] split) {
		return new Color(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
	}

	/**
	 * @param split
	 *            {@link String} array
	 * @return {@link Color}
	 * @since 0.1.0
	 */
	private Color parseRGBA(String[] split) {
		return new Color(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]),
				Integer.parseInt(split[3]));
	}
}
