package dkloubert.code.together.coding.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ChallengeTests {
    companion object {
        @JvmStatic
        @Suppress("UnusedPrivateMember")
        private fun testCaseProvider(): Stream<Arguments> = Stream.of(
            Arguments.of("", 1, 0),
            Arguments.of("a", 1, 1),
            Arguments.of("b", 1, 2),
            Arguments.of("z", 1, 8),
            Arguments.of("abc", 1, 6),
            Arguments.of("iiii", 1, 36),
            Arguments.of("xyz", 1, 21),
            Arguments.of("z", 2, 8),
            Arguments.of("iiii", 2, 9),
            Arguments.of("xyz", 2, 3),
            Arguments.of("lise", 1, 27),
            Arguments.of("lise", 2, 9),
            Arguments.of("lise", 3, 9),
        )
    }

    @ParameterizedTest
    @MethodSource("testCaseProvider")
    fun test(text: String, iterations: Int, result: Int) {
        assertThat(getLucky(text, iterations)).isEqualTo(result)
    }
}