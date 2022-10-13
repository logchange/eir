package dev.logchange.eir;

import dev.logchange.eir.format.ReportsReader;
import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.logging.LogLevel;
import io.micronaut.logging.LoggingSystem;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Command(name = "eir",
        description = "It is a tool to collect and report system vulnerabilities ",
        mixinStandardHelpOptions = true)
public class EirCommand implements Runnable {

    @Option(names = {"-v", "--verbose"}, description = "Provides more debug information and logs.")
    boolean verbose;

    @Option(names = {"-p", "--path"}, defaultValue = ".", description = "Working directory, where eir tries to detect reports")
    String path;

    @Inject
    LoggingSystem loggingSystem;

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(EirCommand.class, args);
    }

    public void run() {
        if (verbose) {
            loggingSystem.setLogLevel("dev.logchange.eir",  LogLevel.DEBUG);
            log.debug("Verbose is active!");
        }

        File workingDir = getWorkingDir();
        List<File> files = getFilesInDir(workingDir);


    }

    /**
     * Returns: The returning list of files is not sorted.
     */
    private List<File> getFilesInDir(File workingDir) {
        File[] files = workingDir.listFiles();

        log.debug("Files available in directory: " + path);

        if (files == null) {
            return Collections.emptyList();
        }

        return Arrays.stream(files).filter(File::isFile)
                .peek(file -> log.debug(file.getName()))
                .collect(Collectors.toList());
    }

    private File getWorkingDir() {
        File workingDir = new File(path);
        if (!workingDir.exists()) {
            String msg = "Path pass to eir: " + path + " does not exists!";
            log.error(msg);
            throw new IllegalArgumentException(msg);
        }

        if (!workingDir.isDirectory()) {
            String msg = "Path pass to eir: " + path + " is not a directory!";
            log.error(msg);
            throw new IllegalArgumentException(msg);
        }

        return workingDir;
    }

}
