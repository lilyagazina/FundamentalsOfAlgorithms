package org.example;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

import org.example.exception.ElementNotFoundException;
import org.example.exception.InvalidArgumentException;
import org.example.exception.StringListIndexOutOfBoundsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class StringListImplTest {

        private final StringListImpl out = new StringListImpl(5);

        @BeforeEach
        public void fillList() {
            out.add("one");
            out.add("two");
            out.add("three");
            out.add("four");
            out.add("five");
        }

        @AfterEach
        public void clearList() {
            out.clear();
        }

        @Test
        public void simpleAdditionPositiveTest() {
            int size = out.size();
            assertEquals("six", out.add("six"));
            assertEquals(size + 1, out.size());
        }

        // there is no negative scenario for method add(String)

        @Test
        public void indexedAdditionPositiveTest() {
            int size = out.size();
            int index = 1;
            assertEquals("six", out.add(index, "six"));
            assertEquals(index, out.indexOf("six"));
            assertEquals(size + 1, out.size());
        }

        @Test
        public void indexedAdditionNegativeTest() {
            assertThrows(StringListIndexOutOfBoundsException.class, () -> out.add(5, "six"));
        }

        @Test
        public void settingPositiveTest() {
            int size = out.size();
            int index = 1;
            assertEquals("six", out.set(index, "six"));
            assertEquals(index, out.indexOf("six"));
            assertEquals(size, out.size());
        }

        @Test
        public void settingNegativeTest() {
            assertThrows(StringListIndexOutOfBoundsException.class, () -> out.set(5, "six"));
        }

        @Test
        public void removeByValuePositiveTest() {
            int size = out.size();
            assertEquals("one", out.remove("one"));
            assertEquals(size - 1, out.size());
        }

        @Test
        public void removeByValueNegativeTest() {
            assertThrows(ElementNotFoundException.class, ()-> out.remove("six"));
        }

        @Test
        public void removeByIndexPositiveTest() {
            int size = out.size();
            assertEquals("one", out.remove(0));
            assertEquals(size - 1, out.size());
        }

        @Test
        public void removeByIndexNegativeTest() {
            assertThrows(StringListIndexOutOfBoundsException.class, ()-> out.remove(5));
        }

        public static Stream<Arguments> argumentsForContainsPositiveTest() {
            return Stream.of(
                    Arguments.of("one"),
                    Arguments.of("three"),
                    Arguments.of("five")
            );
        }

        @ParameterizedTest
        @MethodSource("argumentsForContainsPositiveTest")
        public void containsPositiveTest(String str) {
            assertTrue(out.contains(str));
        }

        public static Stream<Arguments> argumentsForContainsNegativeTest() {
            return Stream.of(
                    Arguments.of("six"),
                    Arguments.of("seven"),
                    Arguments.of("eight")
            );
        }

        @ParameterizedTest
        @MethodSource("argumentsForContainsNegativeTest")
        public void containsNegativeTest(String str) {
            assertFalse(out.contains(str));
        }

        public static Stream<Arguments> argumentsForIndexOfPositiveTest() {
            return Stream.of(
                    Arguments.of("one", 0),
                    Arguments.of("two", 1),
                    Arguments.of("three", 2),
                    Arguments.of("four", 3),
                    Arguments.of("five", 4)
            );
        }

        @ParameterizedTest
        @MethodSource("argumentsForIndexOfPositiveTest")
        public void indexOfPositiveTest(String str, int index) {
            assertEquals(index, out.indexOf(str));
        }

        public static Stream<Arguments> argumentsForIndexOfNegativeTest() {
            return Stream.of(
                    Arguments.of("six", -1),
                    Arguments.of("Hello, World!", -1)
            );
        }

        @ParameterizedTest
        @MethodSource("argumentsForIndexOfNegativeTest")
        public void indexOfNegativeTest(String str, int index) {
            assertEquals(index, out.indexOf(str));
        }

        public static Stream<Arguments> argumentsForLastIndexOfTest() {
            return Stream.of(
                    Arguments.of("one", 5),
                    Arguments.of("two", 6),
                    Arguments.of("six", -1)
            );
        }

        @ParameterizedTest
        @MethodSource("argumentsForLastIndexOfTest")
        public void lastIndexOfTest(String str, int index) {
            out.add("one");
            out.add("two");
            assertEquals(index, out.lastIndexOf(str));
        }

        public static Stream<Arguments> argumentsForGetPositiveTest() {
            return Stream.of(
                    Arguments.of("one", 0),
                    Arguments.of("two", 1),
                    Arguments.of("three", 2),
                    Arguments.of("four", 3),
                    Arguments.of("five", 4)
            );
        }

        @ParameterizedTest
        @MethodSource("argumentsForGetPositiveTest")
        public void getPositiveTest(String str, int index) {
            assertEquals(str, out.get(index));
        }

        @Test
        public void getNegativeTest() {
            assertThrows(StringListIndexOutOfBoundsException.class, () -> out.get(5));
        }

        @Test
        public void equalsPositiveTest() {
            StringListImpl test = new StringListImpl(5);
            test.add("one");
            test.add("two");
            test.add("three");
            test.add("four");
            test.add("five");
            assertTrue(out.equals(test));
        }

        @Test
        public void equalsNullNegativeTest() {
            assertThrows(InvalidArgumentException.class, () -> out.equals(null));
        }

        @ParameterizedTest
        @MethodSource("argumentForEqualsNegativeTest")
        public void equalsNegativeTest(StringListImpl arg) {
            assertFalse(out.equals(arg));
        }

        @Test
        public void isEmptyPositiveTest() {
            StringListImpl test = new StringListImpl(5);
            assertTrue(test.isEmpty());
        }

        @Test
        public void isEmptyNegativeTest() {
            assertFalse(out.isEmpty());
        }

        @Test
        public void toArrayTest() {
            String[] test = {"one", "two", "three", "four", "five"};
            assertArrayEquals(test, out.toArray());
        }

}