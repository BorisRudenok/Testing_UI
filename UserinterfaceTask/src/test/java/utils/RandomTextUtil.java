package utils;


public class RandomTextUtil {
    public String generatingLowerLetters(int lowerLetters) {
        PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder()
                .useLower(true)
                .build();
        return passwordGenerator.generate(lowerLetters);
    }


    public String generatingUpperLettersAndDigits(int upperLettersAndDigits) {
        PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder()
                .useUpper(true)
                .useDigits(true)
                .build();
        return passwordGenerator.generate(upperLettersAndDigits);
    }
}
