package dev.logchange.eir.format.gitlab.sast;

import dev.logchange.eir.format.ReportType;
import dev.logchange.eir.format.ReportsReader;
import dev.logchange.eir.format.general.GeneralReport;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

@MicronautTest
class SastReportIntagrationTest {

    @Inject
    private ReportsReader reader;

    @Test
    void test_semgrep_v15_0_0() throws IOException {
        //given:
        String reportPath = "src/test/resources/dev/logchange/eir/format/gitlab/sast/gl-sast-report_semgrep_v_15_0_0.json";
        String content = Files.readString(Path.of(reportPath), StandardCharsets.UTF_8);

        //when:
        GeneralReport report = reader.parse(ReportType.GITLAB_SAST, content);

        //then:
        Assertions.assertEquals(5, report.getVulnerabilities().size());
    }
}