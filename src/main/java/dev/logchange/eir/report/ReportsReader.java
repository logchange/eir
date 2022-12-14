package dev.logchange.eir.report;

import dev.logchange.eir.domain.report.GeneralReport;
import dev.logchange.eir.domain.report.ReportFile;
import dev.logchange.eir.shared.FileNotSupportedException;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Singleton
@RequiredArgsConstructor
public class ReportsReader {

    private final List<ReportReader> readers;

    public GeneralReport parse(ReportType reportType, ReportFile reportFile){
        return readers.stream()
                .filter(reader ->reader.canRead(reportType, reportFile))
                .findFirst()
                .orElseThrow(() -> new FileNotSupportedException(reportFile.fileName()))
                .read(reportFile.content());
    }
}
