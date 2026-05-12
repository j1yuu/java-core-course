package model;

import java.util.Objects;

public class Contact {
    private String name;
    private String phone;
    private String email;
    private String group;

    private static final int NAME_MIN = 2;
    private static final int NAME_MAX = 50;

    private static final int PHONE_MIN = 2;
    private static final int PHONE_MAX = 50;

    private static final int EMAIL_MIN = 2;
    private static final int EMAIL_MAX = 50;

    public Contact(String name, String phone, String email, String group) {
        validate(name, phone, email);
        
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.group = group == null ? "" : group;
    }

    private void validate(String name, String phone, String email) {
        validateName(name);
        validatePhone(phone);
        validateEmail(email);
    }

    private void validateName(String name) {
        if (name == null || name.trim().length() < NAME_MIN || name.trim().length() > NAME_MAX) {
            throw new IllegalArgumentException("Name must be between " + NAME_MIN + " and " + NAME_MAX + " characters");
        }
    }

    private void validatePhone(String phone) {
        if (phone == null || phone.trim().length() < PHONE_MIN || phone.trim().length() > PHONE_MAX) {
            throw new IllegalArgumentException("Phone must be between " + PHONE_MIN + " and " + PHONE_MAX + " characters");
        }
    }

    private void validateEmail(String email) {
        if (email == null || email.trim().length() < EMAIL_MIN || email.trim().length() > EMAIL_MAX) {
            throw new IllegalArgumentException("Email must be between " + EMAIL_MIN + " and " + EMAIL_MAX + " characters");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email must contain @");
        }
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    public void setEmail(String email) {
        validateEmail(email);
        this.email = email;
    }

    public void setGroup(String group) {
        this.group = group == null ? "" : group;
    }

    @Override
    public String toString() {
        return "Contact{" + "name='" + name + '\'' + ", phone='" + phone + '\'' + ", email='" + email + '\'' + ", group='" + group + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Contact)) {
            return false;
        }
        Contact contact = (Contact) o;
        return phone.equals(contact.phone);
      }

    @Override
    public int hashCode() {
        return Objects.hash(phone);
    }
}
