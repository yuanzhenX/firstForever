package com.scst.entity;

import lombok.Data;

@Data
public class StudentScore {
    private Integer id;
    private Double score;
    private Integer cId;
    private Integer sId;

    @Override
    public String toString() {
        return "StudentScore{" + "id=" + id + ", score='" + score + '\'' + ", cId=" + cId + ", sId=" + sId + '}';
    }
}
