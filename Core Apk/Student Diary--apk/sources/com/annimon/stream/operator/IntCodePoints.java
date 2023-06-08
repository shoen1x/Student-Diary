package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;
import java.util.NoSuchElementException;

public class IntCodePoints extends PrimitiveIterator.OfInt {
    private final CharSequence charSequence;
    private int current = 0;
    private final boolean isString;
    private int length = -1;

    public IntCodePoints(CharSequence charSequence2) {
        this.charSequence = charSequence2;
        this.isString = charSequence2 instanceof String;
    }

    public boolean hasNext() {
        return this.current < ensureLength();
    }

    public int nextInt() {
        int i;
        int length2 = ensureLength();
        int i2 = this.current;
        if (i2 < length2) {
            CharSequence charSequence2 = this.charSequence;
            this.current = i2 + 1;
            char nextChar = charSequence2.charAt(i2);
            if (Character.isHighSurrogate(nextChar) && (i = this.current) < length2) {
                char currentChar = this.charSequence.charAt(i);
                if (Character.isLowSurrogate(currentChar)) {
                    this.current++;
                    return Character.toCodePoint(nextChar, currentChar);
                }
            }
            return nextChar;
        }
        throw new NoSuchElementException();
    }

    private int ensureLength() {
        if (!this.isString) {
            return this.charSequence.length();
        }
        if (this.length == -1) {
            this.length = this.charSequence.length();
        }
        return this.length;
    }
}
