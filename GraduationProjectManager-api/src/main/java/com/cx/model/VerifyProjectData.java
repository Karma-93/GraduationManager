package com.cx.model;

import lombok.Data;

/**
 * 需要确认选题的信息
 */
@Data
public class VerifyProjectData {
    String userName;
    String studentId;
    String className;
    String tel;
    String projectName;
    Integer projectId;
    String userId;
    Integer projectState;
}
