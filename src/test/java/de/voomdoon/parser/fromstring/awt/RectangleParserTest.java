package de.voomdoon.parser.fromstring.awt;

import static org.assertj.core.api.Assertions.assertThat;

import java.awt.Rectangle;

import org.junit.jupiter.api.Test;

import de.voomdoon.parser.fromstring.FromStringParsers;
import de.voomdoon.parser.fromstring.awt.RectangleParser;
import de.voomdoon.testing.tests.TestBase;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
class RectangleParserTest extends TestBase {

	/**
	 * @since 0.1.0
	 */
	private RectangleParser parser = new RectangleParser();

	/**
	 * @since 0.1.0
	 */
	@Test
	void test() throws Exception {
		logTestStart();

		String string = "1,2,3,4";

		Rectangle actual = parser.parse(string);

		assertThat(actual).isEqualTo(new Rectangle(1, 2, 3, 4));
	}

	/**
	 * @since 0.1.0
	 */
	@Test
	void testGetResultClass() throws Exception {
		logTestStart();

		assertThat(new RectangleParser().getResultClass()).isEqualTo(Rectangle.class);
	}

	/**
	 * @since 0.1.0
	 */
	@Test
	void testIntegration() throws Exception {
		logTestStart();

		Rectangle actual = FromStringParsers.DEFAULT.parse(Rectangle.class, "1,2,3,4");

		assertThat(actual).isEqualTo(new Rectangle(1, 2, 3, 4));
	}
}
