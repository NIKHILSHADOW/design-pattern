package adaptor.weather;

import adaptor.weather.external.AccuWeatherApi;
import adaptor.weather.external.Temperature;
import adaptor.weather.external.TemperatureScale;
import adaptor.weather.support.AccuWeatherPPI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Test;

public class AccuweatherTest {
    AccuWeatherPPI accuWeatherPPI;
    @BeforeEach
    public void getInstance(){
        accuWeatherPPI = new AccuWeatherPPI();
    }

    @Test
    public void getTemperatureTest(){
        Double celsiusValue = accuWeatherPPI.getTemperatureIn(TemperatureScale.CELSIUS);
        Assertions.assertNotNull(celsiusValue);
    }

    @Test
    public void getTemperatureTest2(){
        Assertions.assertThrows(RuntimeException.class , () -> accuWeatherPPI.getTemperatureIn(TemperatureScale.RANKINE));
    }
}
