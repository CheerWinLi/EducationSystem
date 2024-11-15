package com.school.entity.bo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author :Lictory
 * @date : 2024/05/08
 */

@Data
@Accessors(chain = true)
public class LoginBo {
    private String username;
    private String password;
}
