package dev.logchange.eir.format;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.logchange.eir.format.gitlab.v15.sast.SastReport;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Singleton
@RequiredArgsConstructor
public class ReportsReader {

    private final ObjectMapper objectMapper;

    @SneakyThrows
    public SastReport parse(String json){
        return objectMapper.readValue(json, SastReport.class);
    }
}
