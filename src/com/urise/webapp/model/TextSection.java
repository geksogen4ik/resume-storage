package com.urise.webapp.model;

import java.util.Objects;

/**
 * Created by Sveta on 22.10.2016.
 */
public class TextSection extends Section {
    private static final long serialVersionUID = 1L;
    private final String content;

    public TextSection(String content) {
        Objects.requireNonNull(content, "Content must not be null");
        this.content = content;
    }

    @Override
    public String toString() {
        return content;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextSection that = (TextSection) o;

        return content.equals(that.content);

    }

    @Override
    public int hashCode() {
        return content.hashCode();
    }
}