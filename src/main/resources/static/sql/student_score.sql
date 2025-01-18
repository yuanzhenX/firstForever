-- MySQL dump 10.13  Distrib 9.0.1, for Win64 (x86_64)
--
-- Host: localhost    Database: student_score
-- ------------------------------------------------------
-- Server version	9.0.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_course`
--
#创建数据库
CREATE DATABASE if not exists student_score;
#选择使用数据库
USE student_score;
DROP TABLE IF EXISTS `t_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `course_name` varchar(100) NOT NULL,
  `teacher_name` varchar(100) NOT NULL,
  `credit` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10110010 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_course`
--

LOCK TABLES `t_course` WRITE;
/*!40000 ALTER TABLE `t_course` DISABLE KEYS */;
INSERT INTO `t_course` VALUES (10110002,'大学英语','syl',5),(10110003,'大学物理','hwy',10),(10110004,'C语言','syl',3),(10110005,'java','yh',4),(10110006,'计算机网络','syl',5),(10110007,'计算机组成原理','lh',5),(10110008,'编译原理','syl',4),(10110009,'操作系统','syl',4);
/*!40000 ALTER TABLE `t_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_student`
--

DROP TABLE IF EXISTS `t_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_name` varchar(100) NOT NULL,
  `age` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20220013 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_student`
--

LOCK TABLES `t_student` WRITE;
/*!40000 ALTER TABLE `t_student` DISABLE KEYS */;
INSERT INTO `t_student` VALUES (20220003,'hwy',21),(20220004,'wdk',21),(20220005,'wdy',21),(20220006,'lwy',21),(20220007,'wpy',20),(20220008,'hmy',21),(20220009,'hzb',21),(20220010,'lgy',21),(20220011,'lml',21),(20220012,'lzb',21);
/*!40000 ALTER TABLE `t_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_student_score`
--

DROP TABLE IF EXISTS `t_student_score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_student_score` (
  `id` int NOT NULL AUTO_INCREMENT,
  `score` double NOT NULL,
  `c_id` int NOT NULL,
  `s_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_student_score`
--

LOCK TABLES `t_student_score` WRITE;
/*!40000 ALTER TABLE `t_student_score` DISABLE KEYS */;
INSERT INTO `t_student_score` VALUES (8,60,10110003,20220003),(9,70,10110005,20220003),(10,70,10110006,20220006),(11,90,10110004,20220003),(12,90,10110007,20220009),(13,100,10110008,20220003);
/*!40000 ALTER TABLE `t_student_score` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-11 11:33:32
