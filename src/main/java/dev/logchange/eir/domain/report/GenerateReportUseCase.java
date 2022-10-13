package dev.logchange.eir.domain.report;

import lombok.Value;

import java.io.File;
import java.util.List;

public interface GenerateReportUseCase {

    void handle(GenerateReportCommand command);

    @Value(staticConstructor = "of")
    class GenerateReportCommand{
        List<File> files;
    }
}
