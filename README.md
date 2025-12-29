# University Management System

A Java-based University Management System using **Swing** for the GUI and **MySQL** for the database. This project provides separate dashboards for **students** and **faculty**, allowing them to manage and view academic information efficiently.

---
### How it works
The application has a login page for both students and faculty.

Depending on the username and password entered:

Faculty are redirected to the Faculty Dashboard, where they can add students, add faculty, apply for leave, and enter marks.

Students are redirected to the Student Dashboard, where they can view their personal details, marks, and fee information.

The login credentials are stored in the teacher and student tables in the database.
## Features

### Faculty Dashboard
- Add new students
- Add new faculty members
- View student and faculty details
- Apply for leave
- Enter marks for students

### Student Dashboard
- View personal details
- View marks for all semesters
- Check fee structure and payment status

---

## Technologies Used
- Java (JDK 11+)
- Swing (Java GUI)
- MySQL (Database)
- NetBeans IDE
- [RS2XML Library](https://sourceforge.net/projects/finalangelsanddemons/) for displaying database tables in JTable

---

## Database Setup

1. Create the database:

```sql
CREATE DATABASE universitymanagementsystem;
USE universitymanagementsystem;
create table login(username varchar(25),password varchar(25));
CREATE TABLE teacher (username   VARCHAR(50) UNIQUE,password   VARCHAR(50));
CREATE TABLE student (username   VARCHAR(50) UNIQUE,password   VARCHAR(50));
insert into teacher values('teach','123');
insert into student values('student','1234');
create table studentinfo(name varchar(50),fname varchar(50),mname varchar(50),roll varchar(50),dob varchar(50),address varchar(50),phoneno varchar(20),email varchar(50),tenper varchar(5),interper varchar(5),aadhar varchar(30),course varchar(40),branch varchar(40));
create table facultyinfo(name varchar(50),fname varchar(50),mname varchar(50),roll varchar(50),dob varchar(50),address varchar(50),phoneno varchar(20),email varchar(50),tenper varchar(5),interper varchar(5),aadhar varchar(30), qualification varchar(40),department varchar(40),designation varchar(40));
create table leavestudent(rollno varchar(20),sdate varchar(50),stime varchar(30));
create table leavefaculty(empid varchar(20),fdate varchar(50),ftime varchar(30));
create table subject ( roll varchar(50), semester varchar(20), subject1 varchar(50), subject2 varchar(50),  subject3 varchar(50),subject4 varchar(50),subject5 varchar(50));
create table marks ( roll varchar(50),semester varchar(20), marks1 varchar(5), marks2 varchar(5), marks3 varchar(5), marks4 varchar(5),marks5 varchar(50));
CREATE TABLE fee (
    course VARCHAR(50) PRIMARY KEY,
    semfee VARCHAR(20)
);

