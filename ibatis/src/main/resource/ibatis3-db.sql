-- ----------------------------
-- Table structure for student
-- ----------------------------
CREATE TABLE 'student'(
	'id' int(3)auto_increment,
	'name' varchar(10),
	'age' int(2),
)ENGINE=InnoDB DEFAULT CHARSET=utf-8;

insert into student values(001,'Nancy',20);