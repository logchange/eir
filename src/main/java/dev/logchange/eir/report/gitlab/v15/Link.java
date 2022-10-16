
package dev.logchange.eir.report.gitlab.v15;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "url"
})
@Generated("jsonschema2pojo")
public class Link {

    /**
     * Name of the vulnerability details link.
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Name of the vulnerability details link.")
    public String name;
    /**
     * URL of the vulnerability details document.
     * (Required)
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("URL of the vulnerability details document.")
    public String url;
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
