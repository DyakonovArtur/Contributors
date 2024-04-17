package com.example.contributors;
import java.util.List;


public class Contributor {
    private String login;
    private int contributions;

    @Override
    public String toString() {
        return login + "\n";
    }
}
