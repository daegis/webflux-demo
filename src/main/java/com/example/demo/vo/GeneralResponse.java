package com.example.demo.vo;

import com.example.demo.domain.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Using IntelliJ IDEA.
 *
 * @author XIANYINGDA at 8/20/2018 3:03 PM
 */
@Data
public class GeneralResponse {
    private List<User> userList;
    private LocalDateTime now;
}
