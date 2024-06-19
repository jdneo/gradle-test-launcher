package com.example.project;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

class NestedTests {
    @Nested
    class NestedClassA {
        @Test
        public void test() { }

    }

    @Nested
    class NestedClassB {
        @Test
        void test() { }

        @Nested
        class ADeeperClass {
            @Test
            void test() {
                assertTrue(false);
            }
        }
    }
}
