USE [master]
GO
IF EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'P0001_OnlineQuiz')
BEGIN
	ALTER DATABASE [P0001_OnlineQuiz] SET OFFLINE WITH ROLLBACK IMMEDIATE;
	ALTER DATABASE [P0001_OnlineQuiz] SET ONLINE;
	DROP DATABASE [P0001_OnlineQuiz];
END

CREATE DATABASE [P0001_OnlineQuiz]
GO

USE [P0001_OnlineQuiz]
GO

CREATE TABLE [dbo].[Quiz](
	[id] INT IDENTITY(1,1) PRIMARY KEY,
	[question] NVARCHAR(max),
	[option1] NVARCHAR(300),
	[option2] NVARCHAR(300),
	[option3] NVARCHAR(300),
	[option4] NVARCHAR(300),
	[answers] NVARCHAR(10),
	[dateCreated] DATETIME ,
	[username] VARCHAR(30)
)
GO
CREATE TABLE [dbo].[Account](
	[username] VARCHAR(30) PRIMARY KEY,
	[password] VARCHAR(30),
	[email] VARCHAR(100),
	[role] INT
)

GO
INSERT INTO Quiz VALUES(N'The name of capital of VietNam after 1975?', N'Sai Gon', N'Ho Chi Minh', N'Ha Noi', N'Ha Tay', 'C', N'2016-04-20', 'admin')
INSERT INTO Quiz VALUES(N'What are access modifiers in Java?', N'Default', N'Private', N'Access', N'Protected', 'ABD', N'2021-06-13', 'admin')
INSERT INTO Quiz VALUES(N'_____ is used to find and fix bugs in the Java programs', N'JVM', N'JRE', N'JDK', N'JDB', 'D', N'2021-04-14', 'admin')
INSERT INTO Quiz VALUES(N'What is the return type of the hashCode() method in the Object class?', N'Object', N'int', N'long', N'void', 'B', N'2020-09-22', 'thanh')
INSERT INTO Quiz VALUES(N'Which package contains the Random class?', N'java.util', N'java.lang', N'java.awt', N'java.io', 'A', N'2020-12-10', 'thanh')
INSERT INTO Quiz VALUES(N'Which keyword is used for accessing the features of a package?', N'package', N'import', N'extends', N'export', 'B', N'2021-02-14', 'admin')

GO
INSERT Account VALUES ('admin', '123', 'admin@fpt.edu.vn', 1)
INSERT Account VALUES ('thanh', '123', 'thanh@fpt.edu.vn', 1)
INSERT Account VALUES ('user', '123', 'user@fpt.edu.vn', 2)