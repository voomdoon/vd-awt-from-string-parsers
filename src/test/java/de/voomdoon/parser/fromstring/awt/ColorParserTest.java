package de.voomdoon.parser.fromstring.awt;

import static org.assertj.core.api.Assertions.assertThat;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import de.voomdoon.parser.fromstring.FromStringParsers;
import de.voomdoon.testing.tests.TestBase;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
class ColorParserTest extends TestBase {

	/**
	 * @since 0.1.0
	 */
	private ColorParser parser = new ColorParser();

	/**
	 * @since 0.1.0
	 */
	@Test
	void test_integer_RGB() throws Exception {
		logTestStart();

		String string = "1,2,3";

		Color actual = parser.parse(string);

		assertThat(actual).isEqualTo(new Color(1, 2, 3));
	}

	/**
	 * @since 0.1.0
	 */
	@Test
	void testGetResultClass() throws Exception {
		logTestStart();

		assertThat(new ColorParser().getResultClass()).isEqualTo(Color.class);
	}

	/**
	 * @since 0.1.0
	 */
	@Test
	void testIntegration() throws Exception {
		logTestStart();

		Color actual = FromStringParsers.DEFAULT.parse(Color.class, "1,2,3");

		assertThat(actual).isEqualTo(new Color(1, 2, 3));
	}
}
