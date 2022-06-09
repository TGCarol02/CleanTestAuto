package utils;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class User {

    String firstName, lastName, email;
    String password, passwordConfirmation;

    public User(){
        Faker fakeDataGeneration = new Faker();
        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("es-MX"), new RandomService());
        this.firstName = fakeDataGeneration.name().firstName();
        this.lastName = fakeDataGeneration.name().lastName();
        this.email = fakeValuesService.bothify("????##@test.com");
        this.password = fakeValuesService.regexify("[a-z1-9]{10}");
        this.passwordConfirmation = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return String.format("%s\n%s\n%s\n%s",
                firstName,
                lastName,
                email,
                password);
    }
}
