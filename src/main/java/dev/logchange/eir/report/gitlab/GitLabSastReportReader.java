package dev.logchange.eir.report.gitlab;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.logchange.eir.domain.report.GeneralReport;
import dev.logchange.eir.domain.report.ReportFile;
import dev.logchange.eir.domain.report.Severity;
import dev.logchange.eir.domain.report.Vulnerability;
import dev.logchange.eir.report.ReportReader;
import dev.logchange.eir.report.ReportType;
import dev.logchange.eir.report.gitlab.v15.sast.SastReport;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;
import java.util.stream.Collectors;

@Singleton
@RequiredArgsConstructor
public class GitLabSastReportReader implements ReportReader {

    private final ObjectMapper objectMapper;

    @Override
    public boolean canRead(ReportType reportType, ReportFile reportFile) {
        if (ReportType.GITLAB_SAST.equals(reportType)) {
            return true;
        }
        if (ReportType.UNKNOWN.equals(reportType)) {
            return canRead(reportFile);
        }
        return false;
    }

    private boolean canRead(ReportFile reportFile) {
        //TODO check content?
        return reportFile.fileName().matches("^gl-sast.*\\.(json)$");
        //TODO f.e. try to read and check if its not null?
    }

    @SneakyThrows
    @Override
    public GeneralReport read(String reportContent){
        SastReport sastReport = objectMapper.readValue(reportContent, SastReport.class);

        return convert(sastReport);
    }

    private GeneralReport convert(SastReport sastReport) {
        return new GeneralReport(getVulnerabilities(sastReport));
    }

    private List<Vulnerability> getVulnerabilities(SastReport sastReport) {
        return sastReport.vulnerabilities.stream()
                .map(vul -> Vulnerability.builder()
                        .id(vul.id)
                        .severity(Severity.ofName(vul.severity.name()))
                        .build()
                ).collect(Collectors.toList());
    }
}
