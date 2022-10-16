package dev.logchange.eir.report.gitlab;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.logchange.eir.domain.report.ReportFile;
import dev.logchange.eir.report.ReportType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class GitLabSastReportReaderTest {

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private GitLabSastReportReader sut;

    @Test
    void givenFileNameGlSastJson_whenCanRead_thenReturnTrue() {
        //given:
        String fileName = "gl-sast.json";
        ReportFile reportFile = new ReportFile(fileName, "");

        //when:
        boolean result = sut.canRead(ReportType.UNKNOWN, reportFile);

        //then:
        assertTrue(result);
    }

    @Test
    void givenFileNameGlSastReportJson_whenCanRead_thenReturnTrue() {
        //given:
        String fileName = "gl-sast-report.json";
        ReportFile reportFile = new ReportFile(fileName, "");

        //when:
        boolean result = sut.canRead(ReportType.UNKNOWN, reportFile);

        //then:
        assertTrue(result);
    }

    @Test
    void givenFileNameGlSastReportXml_whenCanRead_thenReturnTrue() {
        //given:
        String fileName = "gl-sast-report.xml";
        ReportFile reportFile = new ReportFile(fileName, "");

        //when:
        boolean result = sut.canRead(ReportType.UNKNOWN, reportFile);

        //then:
        assertFalse(result);
    }

    @Test
    void givenFileNameGlSecrestJson_whenCanRead_thenReturnFalse() {
        //given:
        String fileName = "gl-secrets.json";
        ReportFile reportFile = new ReportFile(fileName, "");

        //when:
        boolean result = sut.canRead(ReportType.UNKNOWN, reportFile);

        //then:
        assertFalse(result);
    }
}