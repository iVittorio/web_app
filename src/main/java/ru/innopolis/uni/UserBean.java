package ru.innopolis.uni;

/**
 * Created by i.viktor on 20/11/2016.
 */
public class UserBean {
    private final String login;
    private final String name;
    private final String family;
    private final String email;
    private final String role;

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    private UserBean(Builder builder) {
        this.login = builder.login;
        this.name = builder.firstName;
        this.family = builder.lastName;
        this.email = builder.email;
        this.role = builder.role;
    }

    public static class Builder {
        private final String login;
        private String firstName = "";
        private String lastName = "";
        private String email = "";
        private String role = "student";

        public Builder(String login) {
            this.login = login;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public UserBean build() {
            return new UserBean(this);
        }
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
