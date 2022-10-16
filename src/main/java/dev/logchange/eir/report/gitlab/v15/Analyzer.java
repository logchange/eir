
package dev.logchange.eir.report.gitlab.v15;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;


/**
 * Object defining the analyzer used to perform the scan. Analyzers typically delegate to an underlying scanner to run the scan.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "url",
    "vendor",
    "version"
})
@Generated("jsonschema2pojo")
public class Analyzer {

    /**
     * Unique id that identifies the analyzer.
     * (Required)
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Unique id that identifies the analyzer.")
    public String id;
    /**
     * A human readable value that identifies the analyzer, not required to be unique.
     * (Required)
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("A human readable value that identifies the analyzer, not required to be unique.")
    public String name;
    /**
     * A link to more information about the analyzer.
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("A link to more information about the analyzer.")
    public String url;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("vendor")
    public Vendor vendor;
    /**
     * The version of the analyzer.
     * (Required)
     * 
     */
    @JsonProperty("version")
    @JsonPropertyDescription("The version of the analyzer.")
    public String version;
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

}
