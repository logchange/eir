package dev.logchange.eir.format;

import dev.logchange.eir.domain.report.GeneralReport;
import dev.logchange.eir.domain.report.ReportFile;

public interface ReportReader {

    boolean canRead(ReportType reportType, ReportFile reportFile);
    GeneralReport read(String reportContent);
}
