package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BodyMassIndexTest {
    @Test
    public void classify_bmiUnder16_SeverelyUnderweight(){
        String expected = "Severely Underweight";
        String result = BodyMassIndex.classify(15.9);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void classify_bmi16_Underweight(){
        String expected = "Underweight";
        String result = BodyMassIndex.classify(16);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void classify_bmi18Dot5_HealthyWeight(){
        String result = BodyMassIndex.classify(18.5);

        Assertions.assertEquals("Healthy Weight", result);
    }

    @Test
    public void classify_bmi25_Overweight(){
        String result = BodyMassIndex.classify(25);

        Assertions.assertEquals("Overweight", result);
    }

    @Test
    public void classify_bmi30_Obese(){
        String result = BodyMassIndex.classify(30);

        Assertions.assertEquals("Obese", result);
    }

}
