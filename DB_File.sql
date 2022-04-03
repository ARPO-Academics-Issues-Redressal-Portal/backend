-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: arpo-db
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `announcement`
--

DROP TABLE IF EXISTS `announcement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `announcement` (
  `uuid` int NOT NULL AUTO_INCREMENT,
  `Heading` varchar(200) NOT NULL,
  `Description` varchar(1000) NOT NULL,
  `Sender` int NOT NULL,
  `Course` varchar(45) NOT NULL,
  `date_time` varchar(45) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=1000010 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `announcement`
--

LOCK TABLES `announcement` WRITE;
/*!40000 ALTER TABLE `announcement` DISABLE KEYS */;
INSERT INTO `announcement` VALUES (1000000,'Announcement_1','This is first announcement',456,'CS253A','2022-03-24 18:46:49'),(1000002,'sample_heading','sample_description',100,'sample_course','2022-03-24T07:25:28.962+00:00'),(1000003,'sample_heading','sample_description',100,'sample_course','2022-03-24T07:25:28.962+00:00'),(1000005,'sample_heading','sample_description',123,'sample_course','2022-03-24T07:25:28.962+00:00'),(1000007,'sample_heading','sample_description',100,'sample_course','2022-03-24T07:25:28.962+00:00'),(1000008,'sample_heading','sample_description',0,'sample_course','2022-03-24T07:25:28.962+00:00'),(1000009,'sample_heading','sample_description',0,'sample_course','2022-03-24T07:25:28.962+00:00');
/*!40000 ALTER TABLE `announcement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_role`
--

DROP TABLE IF EXISTS `course_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_role` (
  `uuid` int NOT NULL AUTO_INCREMENT,
  `course` varchar(45) DEFAULT NULL,
  `profile_id` int NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=2000020 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_role`
--

LOCK TABLES `course_role` WRITE;
/*!40000 ALTER TABLE `course_role` DISABLE KEYS */;
INSERT INTO `course_role` VALUES (2000000,'CS253A',123,'Student'),(2000001,'CS220A',123,'Student'),(2000002,'CS220A',234,'Student'),(2000003,'CS253A',345,'Student'),(2000004,'CS253A',456,'Instructor'),(2000005,'CS220A',567,'Instructor'),(2000006,'CS253A',678,'TA'),(2000007,NULL,789,'Admin'),(2000010,'sample_course',123,'sample_role'),(2000011,'sample_course',456,'sample_role'),(2000012,'sample_course',456,'sample_role'),(2000015,'sample_course',456,'sample_role'),(2000016,'sample_course',456,'sample_role'),(2000017,'CS253A',112,'Student'),(2000018,'CS253A',117,'Student'),(2000019,NULL,456,'sample_role');
/*!40000 ALTER TABLE `course_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forum`
--

DROP TABLE IF EXISTS `forum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `forum` (
  `uuid` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `profile_id` int NOT NULL,
  `description` varchar(2000) NOT NULL,
  `likes` int NOT NULL,
  `course` varchar(45) NOT NULL,
  `receiver_email_id` varchar(45) NOT NULL,
  `post_anonymous` tinyint NOT NULL,
  `date_time` timestamp NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=3000005 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forum`
--

LOCK TABLES `forum` WRITE;
/*!40000 ALTER TABLE `forum` DISABLE KEYS */;
INSERT INTO `forum` VALUES (3000000,'First Forum',123,'This is a forum',10,'CS253A','isaha@iitk.ac.in',1,'2022-03-24 13:19:34'),(3000001,'this is a new private query',123,'added just now',0,'CS253A','isaha@iitk.ac.in',1,'2022-03-24 01:55:29'),(3000002,'this is a new private query',123,'added just now',0,'CS253A','isaha@iitk.ac.in',1,'2022-03-24 01:55:29'),(3000003,'this is a new private query',123,'added just now',0,'CS253A','isaha@iitk.ac.in',1,'2022-03-24 01:55:29'),(3000004,'this is a new private query',123,'added just now',0,'CS115A','isaha@iitk.ac.in',1,'2022-03-24 01:55:29');
/*!40000 ALTER TABLE `forum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forum_response`
--

DROP TABLE IF EXISTS `forum_response`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `forum_response` (
  `uuid` int NOT NULL AUTO_INCREMENT,
  `forum_uuid` int NOT NULL,
  `responder_email_id` varchar(45) NOT NULL,
  `response_text` varchar(1000) NOT NULL,
  `course` varchar(45) NOT NULL,
  `likes` int NOT NULL,
  `post_anonymous` tinyint NOT NULL,
  `date_time` timestamp NOT NULL,
  `receiver_email_id` varchar(45) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=4000002 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forum_response`
--

LOCK TABLES `forum_response` WRITE;
/*!40000 ALTER TABLE `forum_response` DISABLE KEYS */;
INSERT INTO `forum_response` VALUES (4000000,3000000,'isaha@iitk.ac.in','This is a reply to the forum','CS253A',10,0,'2022-03-24 13:23:00','akshan@iitk.ac.in'),(4000001,3000000,'isaha@iitk.ac.in','added just now','CS253A',0,0,'2022-03-24 01:55:29','akshan@iitk.ac.in');
/*!40000 ALTER TABLE `forum_response` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notification` (
  `uuid` int NOT NULL AUTO_INCREMENT,
  `heading` varchar(100) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `receiver_email_id` varchar(45) NOT NULL,
  `date_time` timestamp NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=5000001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
INSERT INTO `notification` VALUES (5000000,'Dummy notification','This is notification to you','akshan@iitk.ac.in','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `other_query`
--

DROP TABLE IF EXISTS `other_query`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `other_query` (
  `uuid` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `profile_id` int NOT NULL,
  `description` varchar(1000) NOT NULL,
  `status` varchar(1) NOT NULL,
  `receiver_email_id` varchar(45) NOT NULL,
  `date_time` timestamp NOT NULL,
  `category` varchar(45) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=6000003 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `other_query`
--

LOCK TABLES `other_query` WRITE;
/*!40000 ALTER TABLE `other_query` DISABLE KEYS */;
INSERT INTO `other_query` VALUES (6000000,'Other query test',123,'This is an other query','U','isaha@iitk.ac.in','2022-03-24 13:28:08','Course Acceptance'),(6000001,'query.title',453,'query.description','U','query.receiver_email_id','2022-03-24 01:55:29','Uncategorized'),(6000002,'subject',123,'desciption','W','admin@iitk.ac.in','2022-04-03 09:30:54','Uncategorized');
/*!40000 ALTER TABLE `other_query` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `other_query_response`
--

DROP TABLE IF EXISTS `other_query_response`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `other_query_response` (
  `uuid` int NOT NULL AUTO_INCREMENT,
  `query_uuid` int NOT NULL,
  `receiver_email_id` varchar(45) NOT NULL,
  `responder_email_id` varchar(45) NOT NULL,
  `date_time` timestamp NOT NULL,
  `response_text` varchar(45) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=7000001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `other_query_response`
--

LOCK TABLES `other_query_response` WRITE;
/*!40000 ALTER TABLE `other_query_response` DISABLE KEYS */;
INSERT INTO `other_query_response` VALUES (7000000,6000000,'akshan@iitk.ac.in','isaha@iitk.ac.in','2022-03-24 13:29:41','This is the acceptance rate');
/*!40000 ALTER TABLE `other_query_response` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `private_query`
--

DROP TABLE IF EXISTS `private_query`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `private_query` (
  `uuid` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `profile_id` int NOT NULL,
  `description` varchar(1000) NOT NULL,
  `course` varchar(45) NOT NULL,
  `status` varchar(1) NOT NULL,
  `receiver_email_id` varchar(45) NOT NULL,
  `date_time` timestamp NOT NULL,
  `category` varchar(45) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=8000007 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `private_query`
--

LOCK TABLES `private_query` WRITE;
/*!40000 ALTER TABLE `private_query` DISABLE KEYS */;
INSERT INTO `private_query` VALUES (8000000,'Private query test',123,'This is a private query','CS253A','R','isaha@iitk.ac.in','2022-03-24 13:32:26','Logistics'),(8000001,'this is a new private query',123,'added just now','CS253A','R','isaha@iitk.ac.in','2022-03-24 01:55:29','Temp'),(8000002,'[object Undefined]',123,'[object Undefined]','[object Undefined]','W','test_email','2022-03-31 05:31:40','test_category'),(8000003,'new being added',123,'added just now','CS253A','W','isaha@iitk.ac.in','2022-03-24 01:55:29','Temp'),(8000004,'[object Undefined]',123,'[object Undefined]','[object Undefined]','W','test_email','2022-03-31 05:35:44','test_category'),(8000005,'finally working',123,'test subject','CS253A','W','test_email','2022-03-31 05:38:27','test_category'),(8000006,'akshan ki dash ki ',123,'jaai hooo','CS253A','W','test_email','2022-03-31 05:44:04','test_category');
/*!40000 ALTER TABLE `private_query` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `private_query_response`
--

DROP TABLE IF EXISTS `private_query_response`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `private_query_response` (
  `uuid` int NOT NULL AUTO_INCREMENT,
  `query_uuid` int NOT NULL,
  `receiver_email_id` varchar(45) NOT NULL,
  `responder_email_id` varchar(45) NOT NULL,
  `course` varchar(45) NOT NULL,
  `date_time` timestamp NOT NULL,
  `response_text` varchar(1000) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=9000001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `private_query_response`
--

LOCK TABLES `private_query_response` WRITE;
/*!40000 ALTER TABLE `private_query_response` DISABLE KEYS */;
INSERT INTO `private_query_response` VALUES (9000000,8000000,'akshan@iitk.ac.in','isaha@iitk.ac.in','CS253A','2022-03-24 13:33:56','These are the details');
/*!40000 ALTER TABLE `private_query_response` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profile`
--

DROP TABLE IF EXISTS `profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profile` (
  `uuid` int NOT NULL AUTO_INCREMENT,
  `login_id` varchar(45) NOT NULL,
  `profile_id` int NOT NULL,
  `password` varchar(45) NOT NULL,
  `phone_no` varchar(45) NOT NULL,
  `email_id` varchar(45) NOT NULL,
  `name` varchar(100) NOT NULL,
  `department` varchar(45) DEFAULT NULL,
  `roll_number` varchar(10) DEFAULT NULL,
  `is_admin` int DEFAULT NULL,
  `Is_ts` int DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=10000013 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile`
--

LOCK TABLES `profile` WRITE;
/*!40000 ALTER TABLE `profile` DISABLE KEYS */;
INSERT INTO `profile` VALUES (10000000,'einstein',345,'einstein','5555','einstein@iitk.ac.in','Albert','PHY','1919',NULL,NULL),(10000001,'urbic',567,'urbi','7878','urbic@iitk.ac.in','Dr. Urbi','CSE',NULL,NULL,NULL),(10000002,'akshan',123,'ak@shan','1111','akshan@iitk.ac.in','Akshan','ME-CSE','180061',NULL,NULL),(10000003,'shatroopa',678,'100rupa','7235','shatroopa@iitk.ac.in','Shatroopa','CSE','1678890',NULL,NULL),(10000004,'admin1',789,'admin1','5050','admin@iitk.ac.in','Admin',NULL,NULL,1,NULL),(10000005,'arya',234,'@ry@','0000','arya@iitk.ac.in','Aryabhatta','MTH','0123456789',NULL,NULL),(10000006,'isaha',456,'sahai','6343','isaha@iitk.ac.in','Dr. Indranil','CSE',NULL,NULL,NULL),(10000007,'ts1',111,'ts1','9000','ts1@iitk.ac.in','TS',NULL,NULL,NULL,1),(10000008,'rlak',315,'rlak','9899374333','rlak@iitk.ac.in','Lakshay','BSBE','180378',0,0),(10000009,'ayushs',112,'AyushS','983478888','ayushs@iitk.ac.in','ayush sharma','phy','118978',0,0),(10000010,'',123,'AyushS','','','','','',0,0),(10000011,'',123,'','','','','','',0,0),(10000012,'',123,'','','','','','',0,0);
/*!40000 ALTER TABLE `profile` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-03 23:51:12
