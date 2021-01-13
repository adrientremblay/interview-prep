package string_builder;

import static org.junit.jupiter.api.Assertions.*;

class StringBuilderTest {
    private StringBuilder builder;

    @org.junit.jupiter.api.BeforeEach
    void setup() {
       builder = new StringBuilder();
    }

    @org.junit.jupiter.api.Test
    void append() {
        builder.append("hello");
        assertEquals("hello", builder.toString());
    }
}