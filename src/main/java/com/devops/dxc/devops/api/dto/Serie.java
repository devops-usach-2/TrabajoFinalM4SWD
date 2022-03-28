package com.devops.dxc.devops.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ricardoquiroga on 27-03-22
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Serie {


    @JsonProperty("fecha")
    public String fecha;
    @JsonProperty("valor")
    public Float valor;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();
}
