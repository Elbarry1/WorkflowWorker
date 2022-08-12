package by.barry.workflowWorker.controller;

import by.barry.workflowWorker.client.ActivityWorkerClient;
import by.barry.workflowWorker.dto.WeatherResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final ActivityWorkerClient activityWorkerClient;

    @GetMapping("/weather/{city}")
    public WeatherResponseDto getWeather(@PathVariable String city) {
        WeatherResponseDto currentWeatherDto = activityWorkerClient.getCurrentInfo(city);
        return activityWorkerClient.save(city, currentWeatherDto.getTemp());
    }
}
