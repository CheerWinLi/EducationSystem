package com.school.entity.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author :Lictory
 * @date : 2024/05/14
 */

@Data
@Accessors(chain = true)
public class LikeBo {

    @JsonProperty("fieldName")
    String fieldName;

    @JsonProperty("fieldValue")
    String fieldValue;
}
