package adaptor.weather.support;

public class TemperatureConversions {
    public Double kelvinToCelsius(Double kelvinTemperature){
        return kelvinTemperature - 273.15;
    }

    public Double celsiusToKelvin(Double celsiusTemperature){
        return celsiusTemperature + 273.15;
    }

    public Double farenheitToKelvin(Double farenheitTemperature){
        return celsiusToKelvin(farenheitToCelsius(farenheitTemperature));
    }

    public Double kelvinToFarenheit(Double kelvinTemperature){
        return celsiusToFarenheit(kelvinToCelsius(kelvinTemperature));
    }

    public Double farenheitToCelsius(Double farenheitTemperature){
        return (farenheitTemperature - 32)*5/9;
    }

    public Double celsiusToFarenheit(Double celsiusTemperature){
        return (celsiusTemperature)*9/5 + 32;
    }
}
