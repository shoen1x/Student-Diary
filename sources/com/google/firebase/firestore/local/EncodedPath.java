package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class EncodedPath {
    private static final char ENCODED_ESCAPE = '\u0011';
    private static final char ENCODED_NUL = '\u0010';
    private static final char ENCODED_SEPARATOR = '\u0001';
    private static final char ESCAPE = '\u0001';

    EncodedPath() {
    }

    static <B extends BasePath<B>> String encode(B path) {
        StringBuilder result = new StringBuilder();
        int length = path.length();
        for (int i = 0; i < length; i++) {
            if (result.length() > 0) {
                encodeSeparator(result);
            }
            encodeSegment(path.getSegment(i), result);
        }
        encodeSeparator(result);
        return result.toString();
    }

    private static void encodeSegment(String segment, StringBuilder result) {
        int length = segment.length();
        for (int i = 0; i < length; i++) {
            char c = segment.charAt(i);
            if (c == 0) {
                result.append(1);
                result.append(ENCODED_NUL);
            } else if (c != 1) {
                result.append(c);
            } else {
                result.append(1);
                result.append(ENCODED_ESCAPE);
            }
        }
    }

    private static void encodeSeparator(StringBuilder result) {
        result.append(1);
        result.append(1);
    }

    static ResourcePath decodeResourcePath(String path) {
        return ResourcePath.fromSegments(decode(path));
    }

    static FieldPath decodeFieldPath(String path) {
        return FieldPath.fromSegments(decode(path));
    }

    private static List<String> decode(String path) {
        String segment;
        int length = path.length();
        Assert.hardAssert(length >= 2, "Invalid path \"%s\"", path);
        if (length == 2) {
            Assert.hardAssert(path.charAt(0) == 1 && path.charAt(1) == 1, "Non-empty path \"%s\" had length 2", path);
            return Collections.emptyList();
        }
        int lastReasonableEscapeIndex = path.length() - 2;
        List<String> segments = new ArrayList<>();
        StringBuilder segmentBuilder = new StringBuilder();
        int start = 0;
        while (start < length) {
            int end = path.indexOf(1, start);
            if (end < 0 || end > lastReasonableEscapeIndex) {
                throw new IllegalArgumentException("Invalid encoded resource path: \"" + path + "\"");
            }
            char next = path.charAt(end + 1);
            if (next == 1) {
                String currentPiece = path.substring(start, end);
                if (segmentBuilder.length() == 0) {
                    segment = currentPiece;
                } else {
                    segmentBuilder.append(currentPiece);
                    segment = segmentBuilder.toString();
                    segmentBuilder.setLength(0);
                }
                segments.add(segment);
            } else if (next == 16) {
                segmentBuilder.append(path.substring(start, end));
                segmentBuilder.append(0);
            } else if (next == 17) {
                segmentBuilder.append(path.substring(start, end + 1));
            } else {
                throw new IllegalArgumentException("Invalid encoded resource path: \"" + path + "\"");
            }
            start = end + 2;
        }
        return segments;
    }

    static String prefixSuccessor(String path) {
        StringBuilder result = new StringBuilder(path);
        boolean z = true;
        int pos = result.length() - 1;
        char c = result.charAt(pos);
        if (c != 1) {
            z = false;
        }
        Assert.hardAssert(z, "successor may only operate on paths generated by encode", new Object[0]);
        result.setCharAt(pos, (char) (c + 1));
        return result.toString();
    }
}
