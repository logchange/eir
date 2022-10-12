package dev.logchange.eir.format;

import dev.logchange.eir.format.general.GeneralReport;

public interface ReportReader {

    boolean canRead(ReportType reportType, String reportContent);
    GeneralReport read(String reportContent) throws Exception;
}
