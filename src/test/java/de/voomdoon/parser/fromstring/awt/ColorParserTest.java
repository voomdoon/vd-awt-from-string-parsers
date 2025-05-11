package de.voomdoon.parser.fromstring.awt;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.awt.Color;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import de.voomdoon.parser.fromstring.FromStringParsers;
import de.voomdoon.testing.tests.TestBase;

/**
 * Tests for {@link ColorParser}.
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
	void test_error_fiveArrayElements() throws Exception {
		logTestStart();

		assertThatThrownBy(() -> parser.parse("1,2,3,4,5")).isInstanceOf(IllegalArgumentException.class);
	}

	/**
	 * @since 0.1.0
	 */
	@Test
	void test_error_nameNotFoundResultsInNoSuchElementException() throws Exception {
		logTestStart();

		assertThatThrownBy(() -> parser.parse("SOME_COLOR")).isInstanceOf(NoSuchElementException.class)
				.hasMessageContaining("SOME_COLOR");
	}

	/**
	 * @since 0.1.0
	 */
	@Test
	void test_error_twoArrayElements() throws Exception {
		logTestStart();

		assertThatThrownBy(() -> parser.parse("1,2")).isInstanceOf(IllegalArgumentException.class);
	}

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
	void test_integer_RGBA() throws Exception {
		logTestStart();

		String string = "1,2,3,4";

		Color actual = parser.parse(string);

		assertThat(actual).isEqualTo(new Color(1, 2, 3, 4));
	}

	/**
	 * @since 0.1.0
	 */
	@Test
	void test_name() throws Exception {
		logTestStart();

		Color actual = parser.parse("RED");

		assertThat(actual).isEqualTo(Color.RED);
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

		Color actual = FromStringParsers.DEFAULT.parse("1,2,3", Color.class);

		assertThat(actual).isEqualTo(new Color(1, 2, 3));
	}
}
