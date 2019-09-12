package com.zzpage.visitant.core;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharacterEscapes;

public class HTMLCharacterEscapes extends CharacterEscapes {

    private static final long serialVersionUID = -1303452064067869109L;
    private final int[] asciiEscapes;

    public HTMLCharacterEscapes() {
        // start with set of characters known to require escaping (double-quote, backslash etc)
        int[] esc = CharacterEscapes.standardAsciiEscapesForJSON();
        // and force escaping of a few others:
        esc['<'] = CharacterEscapes.ESCAPE_STANDARD;
        esc['>'] = CharacterEscapes.ESCAPE_STANDARD;
        esc['&'] = CharacterEscapes.ESCAPE_STANDARD;
        esc['\''] = CharacterEscapes.ESCAPE_STANDARD;
        asciiEscapes = esc;
    }

    @Override
    public int[] getEscapeCodesForAscii() {
        return asciiEscapes;
    }

    @Override
    public SerializableString getEscapeSequence(int ch) {
        return null;
    }

}
