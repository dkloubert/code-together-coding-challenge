package dkloubert.code.together.coding.challenge

@Suppress("FunctionNaming")
fun getLucky(text: String, iterations: Int): Int = transform(convert(text), iterations)

private tailrec fun transform(value: Int, iterations: Int): Int =
    if (iterations == 0) value
    else transform(sumOfDigits(value), iterations - 1)

private fun convert(text: String) =
    text.toCharArray().joinToString(separator = "") { it.alphabetPosition() }.toIntOrNull() ?: 0

private fun sumOfDigits(value: Int) = value.toString().sumOf { it.digitToInt() }

private const val ALPHABET_CODE_OFFSET = 96

private fun Char.alphabetPosition() = (this.lowercaseChar().code - ALPHABET_CODE_OFFSET).toString()