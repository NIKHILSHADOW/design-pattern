package adaptor.weather.support;

import adaptor.weather.external.Temperature;
import adaptor.weather.external.TemperatureScale;

public interface WeatherProviderInterface {
    public Double getTemperatureIn(TemperatureScale temperatureScale);
    public Double rainfallChance();
}
