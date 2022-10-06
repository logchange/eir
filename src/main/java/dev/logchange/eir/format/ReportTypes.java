package dev.logchange.eir.format;

import dev.logchange.eir.format.gitlab.v15.sast.SastReport;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ReportTypes {

    UNKNOWN(null), // This property is used, to autodetect report type
    GITLAB_SAST(SastReport.class); // Always the newest GitLab SAST report

    private final Class<?> reportClass;
}
