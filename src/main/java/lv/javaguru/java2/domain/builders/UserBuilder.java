package lv.javaguru.java2.domain.builders;

import lv.javaguru.java2.domain.User;

public class UserBuilder {

    private Long userId;
    private String firstName;
    private String lastName;


    private UserBuilder() { }

    public static UserBuilder createUser() {
        return new UserBuilder();
    }

    public User build() {
        User user = new User();
        user.setUserId(userId);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return user;
    }

    public UserBuilder withId(Long userId) {
        this.userId = userId;
        return this;
    }

    public UserBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

}
