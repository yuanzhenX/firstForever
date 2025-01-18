package com.scst;

import com.scst.controller.StudentScoreController;
import com.scst.entity.Course;
import com.scst.entity.StudentScore;
import com.scst.vo.StudentScoreVO;
import com.scst.service.StudentScoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
@SpringBootTest
class StudentSystemApplicationTests {
    @Autowired
    private StudentScoreController studentScoreController;

    @Test
    void testByPage() {
        studentScoreController.getAll(0L,5L,new StudentScoreVO());
    }
    @Test
    void test1() {
        studentScoreController.getById(12);
    }
    @Test
    void test2() throws IOException {
        StudentScore studentScore = new StudentScore();
        studentScore.setSId(20220003);
        studentScore.setCId(10110002);
        studentScore.setScore(60.0);
        studentScoreController.save(studentScore);
    }
    @Test
    void test3() {
        studentScoreController.delete(8);
    }
    @Test
    void test4() throws IOException {
        StudentScore studentScore = new StudentScore();
        studentScore.setSId(20220009);
        studentScore.setCId(10110007);
        studentScore.setScore(50.0);
        studentScoreController.update(studentScore);
    }

}
