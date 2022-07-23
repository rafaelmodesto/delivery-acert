package com.deliveryacert.deliveryacertapi.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class Problem {
    private Integer status;
    private String type;
    private String title;
    private String detail;
}
