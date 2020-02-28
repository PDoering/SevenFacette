package de.p7s1.qa.sevenfacette.veritas.verification

import de.p7s1.qa.sevenfacette.veritas.Verify
import de.p7s1.qa.sevenfacette.veritas.all
import de.p7s1.qa.sevenfacette.veritas.verification.utils.expected
import de.p7s1.qa.sevenfacette.veritas.verification.utils.show

/**
 * Asserts the iterable contains the expected element, using `in`.
 * @see [doesNotContain]
 */
fun Verify<Iterable<*>>.contains(element: Any?) = given { actual ->
    if (element in actual) return
    expected("to contain:${show(element)} but was:${show(actual)}")
}

/**
 * Asserts the iterable does not contain the expected element, using `!in`.
 * @see [contains]
 */
fun Verify<Iterable<*>>.doesNotContain(element: Any?) = given { actual ->
    if (element !in actual) return
    expected("to not contain:${show(element)} but was:${show(actual)}")
}

/**
 * Asserts the collection does not contain any of the expected elements.
 * @see [containsAll]
 */
fun Verify<Iterable<*>>.containsNone(vararg elements: Any?) = given { actual ->
    val notExpected = elements.filter { it in actual }
    if (notExpected.isEmpty()) {
        return
    }
    expected("to contain none of:${show(elements)} but was:${show(actual)}\n elements not expected:${show(notExpected)}")
}

/**
 * Asserts the collection contains all the expected elements, in any order. The collection may also
 * contain additional elements.
 * @see [containsNone]
 * @see [containsExactly]
 * @see [containsOnly]
 */
fun Verify<Iterable<*>>.containsAll(vararg elements: Any?) = given { actual ->
    val notFound = elements.filterNot { it in actual }
    if (notFound.isEmpty()) {
        return
    }
    expected("to contain all:${show(elements)} but was:${show(actual)}\n elements not found:${show(notFound)}")
}

/**
 * Asserts the collection contains only the expected elements, in any order.
 * @see [containsNone]
 * @see [containsExactly]
 * @see [containsAll]
 */
fun Verify<Iterable<*>>.containsOnly(vararg elements: Any?) = given { actual ->
    val notInActual = elements.filterNot { it in actual }
    val notInExpected = actual.filterNot { it in elements }
    if (notInExpected.isEmpty() && notInActual.isEmpty()) {
        return
    }
    expected(StringBuilder("to contain only:${show(elements)} but was:${show(actual)}").apply {
        if (notInActual.isNotEmpty()) {
            append("\n elements not found:${show(notInActual)}")
        }
        if (notInExpected.isNotEmpty()) {
            append("\n extra elements found:${show(notInExpected)}")
        }
    }.toString())
}

/**
 * Asserts on each item in the iterable. The given lambda will be run for each item.
 *
 * ```
 * assertThat(listOf("one", "two")).each {
 *   it.hasLength(3)
 * }
 * ```
 */
fun <E> Verify<Iterable<E>>.each(f: (Verify<E>) -> Unit) = given { actual ->
    all {
        actual.forEachIndexed { index, item ->
            f(verifyThat(item, name = "${name ?: ""}${show(index, "[]")}"))
        }
    }
}

/**
 * Extracts a value of from each item in the iterable, allowing you to assert on a list of those values.
 *
 * ```
 * assertThat(people)
 *   .extracting(Person::name)
 *   .contains("Sue", "Bob")
 * ```
 */
fun <E, R> Verify<Iterable<E>>.extracting(f1: (E) -> R): Verify<List<R>> = transform { actual ->
    actual.map(f1)
}

/**
 * Extracts two values of from each item in the iterable, allowing you to assert on a list of paris of those values.
 *
 * ```
 * assertThat(people)
 *   .extracting(Person::name, Person::age)
 *   .contains("Sue" to 20, "Bob" to 22)
 * ```
 */
fun <E, R1, R2> Verify<Iterable<E>>.extracting(f1: (E) -> R1, f2: (E) -> R2): Verify<List<Pair<R1, R2>>> =
        transform { actual ->
            actual.map { f1(it) to f2(it) }
        }

/**
 * Extracts three values from each item in the iterable, allowing you to assert on a list of triples of those values.
 *
 * ```
 * assertThat(people)
 *   .extracting(Person::name, Person::age, Person::address)
 *   .contains(Triple("Sue", 20, "123 Street"), Triple("Bob", 22, "456 Street")
 * ```
 */
fun <E, R1, R2, R3> Verify<Iterable<E>>.extracting(
        f1: (E) -> R1,
        f2: (E) -> R2,
        f3: (E) -> R3
): Verify<List<Triple<R1, R2, R3>>> = transform { actual ->
    actual.map { Triple(f1(it), f2(it), f3(it)) }
}

/**
 * Asserts on each item in the iterable, passing if none of the items pass.
 * The given lambda will be run for each item.
 *
 * ```
 * assertThat(listOf("one", "two")).none {
 *   it.hasLength(2)
 * }
 * ```
 */
fun <E> Verify<Iterable<E>>.none(f: (Verify<E>) -> Unit) = given { actual ->
    if (actual.count() > 0) {
        all(message = "expected none to pass",
                body = { each { item -> f(item) } },
                failIf = { it.isEmpty() })
    }
}

/**
 * Asserts on each item in the iterable, passing if at least `times` items pass.
 * The given lambda will be run for each item.
 *
 * ```
 * assert(listOf(-1, 1, 2)).atLeast(2) { it.isPositive() }
 * ```
 */
fun <E, T : Iterable<E>> Verify<T>.atLeast(times: Int, f: (Verify<E>) -> Unit) {
    var count = 0
    all(message = "expected to pass at least $times times",
            body = { each { item -> count++; f(item) } },
            failIf = { count - it.size < times })
}

/**
 * Asserts on each item in the iterable, passing if at most `times` items pass.
 * The given lambda will be run for each item.
 *
 * ```
 * assert(listOf(-2, -1, 1)).atMost(2) { it.isPositive() }
 * ```
 */
fun <E, T : Iterable<E>> Verify<T>.atMost(times: Int, f: (Verify<E>) -> Unit) {
    var count = 0
    all(message = "expected to pass at most $times times",
            body = { each { item -> count++; f(item) } },
            failIf = { count - it.size > times })
}

/**
 * Asserts on each item in the iterable, passing if exactly `times` items pass.
 * The given lambda will be run for each item.
 *
 * ```
 * assert(listOf(-1, 1, 2)).exactly(2) { it.isPositive() }
 * ```
 */
fun <E, T : Iterable<E>> Verify<T>.exactly(times: Int, f: (Verify<E>) -> Unit) {
    var count = 0
    all(message = "expected to pass exactly $times times",
            body = { each { item -> count++; f(item) } },
            failIf = { count - it.size != times })
}

/**
 * Asserts on each item in the iterable, passing if any of the items pass.
 * The given lambda will be run for each item.
 *
 * ```
 * assert(listOf(-1, -2, 1)).any { it.isPositive() }
 * ```
 */
fun <E, T : Iterable<E>> Verify<T>.any(f: (Verify<E>) -> Unit) {
    var count = 0
    all(message = "expected any item to pass",
            body = { each { item -> count++; f(item) } },
            failIf = { count == 0 || it.size == count })
}

/**
 * Asserts the iterable is empty.
 * @see [isNotEmpty]
 * @see [isNullOrEmpty]
 */
fun Verify<Iterable<*>>.isEmpty() = given { actual ->
    if (actual.none()) return
    expected("to be empty but was:${show(actual)}")
}

/**
 * Asserts the iterable is not empty.
 * @see [isEmpty]
 */
fun Verify<Iterable<*>>.isNotEmpty() = given { actual ->
    if (actual.any()) return
    expected("to not be empty")
}