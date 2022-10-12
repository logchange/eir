package dev.logchange.eir.format.gitlab;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.logchange.eir.format.ReportReader;
import dev.logchange.eir.format.ReportType;
import dev.logchange.eir.format.general.GeneralReport;
import dev.logchange.eir.format.general.Severity;
import dev.logchange.eir.format.general.Vulnerability;
import dev.logchange.eir.format.gitlab.v15.sast.SastReport;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Singleton
@RequiredArgsConstructor
public class GitLabSastReportReader implements ReportReader {

    private final ObjectMapper objectMapper;

    @Override
    public boolean canRead(ReportType reportType, String reportContent) {
        if(ReportType.GITLAB_SAST.equals(reportType)){
            return true;
        }
        if(ReportType.UNKNOWN.equals(reportType)){
            return canRead(reportContent);
        }
        return false;
    }

    private boolean canRead(String reportContent) {
        //TODO f.e. try to read and check if its not null?
        return false;
    }

    @Override
    public GeneralReport read(String reportContent) throws Exception {
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
