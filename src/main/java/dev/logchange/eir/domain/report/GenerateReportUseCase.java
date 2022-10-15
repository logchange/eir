package dev.logchange.eir.domain.report;

import java.io.File;
import java.util.List;

public interface GenerateReportUseCase {

    void handle(GenerateReportCommand command);

    record GenerateReportCommand(List<File> files) {
    }
}
