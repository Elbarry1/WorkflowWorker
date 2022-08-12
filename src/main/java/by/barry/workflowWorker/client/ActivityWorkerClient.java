package by.barry.workflowWorker.client;

import by.barry.workflowWorker.dto.WeatherResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ActivityWorkerClient {

    private static final String URL = "http://localhost:8082";

    private final RestTemplate restTemplate;

    public WeatherResponseDto getCurrentInfo(String city) {
        return restTemplate.exchange(URL + "/weather/current/{city}", HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), WeatherResponseDto.class, city)
                .getBody();
    }

    public WeatherResponseDto save(String city, Double temp) {
        return restTemplate.exchange(URL + "/weather/{city}", HttpMethod.POST, new HttpEntity<>(temp, new HttpHeaders()), WeatherResponseDto.class, city)
                .getBody();
    }

}
