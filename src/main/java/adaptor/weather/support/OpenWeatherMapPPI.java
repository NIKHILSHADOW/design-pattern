package adaptor.weather.support;

import adaptor.weather.external.OpenWeatherMapApi;
import adaptor.weather.external.TemperatureScale;

public class OpenWeatherMapPPI implements WeatherProviderInterface {

    private OpenWeatherMapApi openWeatherMapApi = new OpenWeatherMapApi();
    private TemperatureConversions temperatureConversions = new TemperatureConversions();
    @Override
    public Double getTemperatureIn(TemperatureScale temperatureScale) {
        Double farenheitValue = openWeatherMapApi.fetchTemperature().doubleValue();
        switch (temperatureScale){
            case KELVIN : {
                return temperatureConversions.farenheitToKelvin(farenheitValue);
            }
            case FARENHEIT:{
                return farenheitValue;
            }
            case CELSIUS: {
                return temperatureConversions.farenheitToCelsius(farenheitValue).doubleValue();
            }
        }
        throw new RuntimeException("Not supported type");
    }

    @Override
    public Double rainfallChance() {
        return null;
    }
}
