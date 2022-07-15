package ru.flawden.springcourse.exception;

public class BadGenreException extends Throwable {

    public BadGenreException() {super();}
    public BadGenreException(String message) {
        super(message);
    }

}
