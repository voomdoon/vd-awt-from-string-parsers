package de.voomdoon.parser.fromstring.awt;

import java.awt.Rectangle;
import java.text.ParseException;

import de.voomdoon.parser.fromstring.FromStringParser;

/**
 * {@link FromStringParser} for {@link Rectangle}.
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
public class RectangleParser implements FromStringParser<Rectangle> {

	/**
	 * Creates a rectangle parser.
	 */
	public RectangleParser() {
	}

	/**
	 * @since 0.1.0
	 */
	@Override
	public Class<Rectangle> getResultClass() {
		return Rectangle.class;
	}

	/**
	 * @since 0.1.0
	 */
	@Override
	public Rectangle parse(String string) throws ParseException {
		String[] split = string.split(",");
		return new Rectangle(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]),
				Integer.parseInt(split[3]));
	}
}
