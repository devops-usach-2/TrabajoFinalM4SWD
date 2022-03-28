package com.devops.dxc.devops.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ricardoquiroga on 27-03-22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UFClientResponse {

    @JsonProperty("version")
    public String version;
    @JsonProperty("autor")
    public String autor;
    @JsonProperty("codigo")
    public String codigo;
    @JsonProperty("nombre")
    public String nombre;
    @JsonProperty("unidad_medida")
    public String unidadMedida;
    @JsonProperty("serie")
    public List<Serie> serie = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

}
