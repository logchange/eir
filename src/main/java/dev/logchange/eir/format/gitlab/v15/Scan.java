
package dev.logchange.eir.format.gitlab.v15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "end_time",
    "messages",
    "analyzer",
    "scanner",
    "start_time",
    "status",
    "type",
    "primary_identifiers"
})
@Generated("jsonschema2pojo")
public class Scan {

    /**
     * ISO8601 UTC value with format yyyy-mm-ddThh:mm:ss, representing when the scan finished.
     * (Required)
     * 
     */
    @JsonProperty("end_time")
    @JsonPropertyDescription("ISO8601 UTC value with format yyyy-mm-ddThh:mm:ss, representing when the scan finished.")
    public String endTime;

    @JsonProperty("messages")
    public List<Message> messages = null;
    /**
     * Object defining the analyzer used to perform the scan. Analyzers typically delegate to an underlying scanner to run the scan.
     * (Required)
     * 
     */
    @JsonProperty("analyzer")
    @JsonPropertyDescription("Object defining the analyzer used to perform the scan. Analyzers typically delegate to an underlying scanner to run the scan.")
    public Analyzer analyzer;
    /**
     * Object defining the scanner used to perform the scan.
     * (Required)
     * 
     */
    @JsonProperty("scanner")
    @JsonPropertyDescription("Object defining the scanner used to perform the scan.")
    public Scanner scanner;
    /**
     * ISO8601 UTC value with format yyyy-mm-ddThh:mm:ss, representing when the scan started.
     * (Required)
     * 
     */
    @JsonProperty("start_time")
    @JsonPropertyDescription("ISO8601 UTC value with format yyyy-mm-ddThh:mm:ss, representing when the scan started.")
    public String startTime;
    /**
     * Result of the scan.
     * (Required)
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("Result of the scan.")
    public Status status;
    /**
     * Type of the scan.
     * (Required)
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Type of the scan.")
    public String type;
    /**
     * An array containing an exhaustive list of primary identifiers for which the analyzer may return results
     * 
     */
    @JsonProperty("primary_identifiers")
    @JsonPropertyDescription("An array containing an exhaustive list of primary identifiers for which the analyzer may return results")
    public List<Identifier> primaryIdentifiers = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    /**
     * Result of the scan.
     * 
     */
    @Generated("jsonschema2pojo")
    public enum Status {

        SUCCESS("success"),
        FAILURE("failure");
        private final String value;
        private final static Map<String, Status> CONSTANTS = new HashMap<String, Status>();

        static {
            for (Status c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Status(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static Status fromValue(String value) {
            Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
