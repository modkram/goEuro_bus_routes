package com.goeuro.busroute.challenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionResponseDTO {
  @JsonProperty("dep_sid")
  private Integer departmentStation;
  @JsonProperty("arr_sid")
  private Integer arrivalStation;
  @JsonProperty("direct_bus_route")
  private Boolean isConnected;

}
