package by.itclass.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class User {
    private int id;
    private final String name;
    private final String email;
    private final String login;
    private final char[] password;
}
