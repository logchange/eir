
package dev.logchange.eir.report.gitlab.v15.sast;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;


/**
 * Identifies the vulnerability's location.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "file",
    "start_line",
    "end_line",
    "class",
    "method"
})
@Generated("jsonschema2pojo")
public class Location {

    /**
     * Path to the file where the vulnerability is located.
     * 
     */
    @JsonProperty("file")
    @JsonPropertyDescription("Path to the file where the vulnerability is located.")
    public String file;
    /**
     * The first line of the code affected by the vulnerability.
     * 
     */
    @JsonProperty("start_line")
    @JsonPropertyDescription("The first line of the code affected by the vulnerability.")
    public Double startLine;
    /**
     * The last line of the code affected by the vulnerability.
     * 
     */
    @JsonProperty("end_line")
    @JsonPropertyDescription("The last line of the code affected by the vulnerability.")
    public Double endLine;
    /**
     * Provides the name of the class where the vulnerability is located.
     * 
     */
    @JsonProperty("class")
    @JsonPropertyDescription("Provides the name of the class where the vulnerability is located.")
    public String vclass;
    /**
     * Provides the name of the method where the vulnerability is located.
     * 
     */
    @JsonProperty("method")
    @JsonPropertyDescription("Provides the name of the method where the vulnerability is located.")
    public String method;
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
