package dev.logchange.eir.application.report;

import dev.logchange.eir.domain.report.GeneralReport;
import dev.logchange.eir.domain.report.GenerateReportUseCase;
import dev.logchange.eir.domain.report.ReportFile;
import dev.logchange.eir.report.ReportType;
import dev.logchange.eir.report.ReportsReader;
import dev.logchange.eir.shared.FileNotSupportedException;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;

@Slf4j
@Singleton
@RequiredArgsConstructor
public class GenerateReportService implements GenerateReportUseCase {

    private final ReportsReader reader;

    @Override
    public void handle(GenerateReportCommand command) {

        List<GeneralReport> reports = command.files().stream()
                .map(this::readFile)
                .map(this::parseFile)
                .toList();


    }

    private GeneralReport parseFile(ReportFile reportFile) {
        try {
            return reader.parse(ReportType.UNKNOWN, reportFile);
        } catch (FileNotSupportedException e){
            log.info("File not supported: " + e.getMessage());
            return new GeneralReport(Collections.emptyList());
        }
    }

    private ReportFile readFile(File file) {
        try {
            return new ReportFile(file.getName(), Files.readString(file.toPath(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            String msg = "Could not read file: " + file.getName() + " because of: " + e.getMessage();
            log.error(msg);
            throw new RuntimeException(e);
        }
    }
}
