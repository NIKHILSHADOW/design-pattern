package adaptor.weather.external;

public class Temperature {
    private Integer value;
    private TemperatureScale temperatureScale;

    public Temperature(Integer value, TemperatureScale temperatureScale){
        this.value = value;
        this.temperatureScale = temperatureScale;
    }
}
