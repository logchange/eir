package dev.logchange.eir.format;

import dev.logchange.eir.format.general.GeneralReport;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;

@Singleton
@RequiredArgsConstructor
public class ReportsReader {

    private final List<ReportReader> readers;

    @SneakyThrows
    public GeneralReport parse(ReportType reportType, String reportContent){
        return readers.stream()
                .filter(reader ->reader.canRead(reportType, reportContent))
                .findFirst().orElseThrow().read(reportContent);
    }
}
