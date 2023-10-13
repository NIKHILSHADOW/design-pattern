package adaptor.weather.support;

import adaptor.weather.external.AccuWeatherApi;
import adaptor.weather.external.TemperatureScale;
import org.jetbrains.annotations.NotNull;

public class AccuWeatherPPI implements WeatherProviderInterface{

    private AccuWeatherApi accuWeatherApi = new AccuWeatherApi();
    private TemperatureConversions temperatureConversions = new TemperatureConversions();
    @Override
    public Double getTemperatureIn(@NotNull TemperatureScale temperatureScale) {
        Double celsiusValue =  accuWeatherApi.getTemperature().doubleValue();
        switch (temperatureScale) {
            case CELSIUS : {
                return celsiusValue;
            }
            case KELVIN: {
                return temperatureConversions.celsiusToKelvin(celsiusValue);
            }
            case FARENHEIT: {
                return temperatureConversions.celsiusToFarenheit(celsiusValue);
            }
        }
        throw new RuntimeException("Not supported specified type");
    }

    @Override
    public Double rainfallChance() {
        return null;
    }
}
