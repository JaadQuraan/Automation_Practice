package test.practice;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerPractice {
    @Test
    public void java_faker(){

        Faker faker = new Faker();
        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("202-###-####"));
        System.out.println("faker.letterify(\"?????\") = " + faker.letterify("?????"));
        System.out.println("faker.address().fullAddress() = " + faker.address().fullAddress());
        System.out.println("faker.chuckNorris() = " + faker.chuckNorris().fact().replace("Chuck Norris","Jaad"));
        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard());

    }
}
