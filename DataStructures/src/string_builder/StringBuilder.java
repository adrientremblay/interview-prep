package string_builder;

import array.DynamicArray;

public class StringBuilder {
    private DynamicArray<String> strings;

    /**
     * Default constructor.
     */
    public StringBuilder() {
        this.strings = new DynamicArray<String>();
    }

    /**
     * Adds a string to the String Builder.
     * @param s
     */
    public void append(String s) {
        strings.append(s);
    }

    /**
     * Converts the StringBuilder to a String.
     * @return the String equivalent of this object
     */
    @Override
    public String toString() {
        return String.join("", strings);
    }
}
