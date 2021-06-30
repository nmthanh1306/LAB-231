USE [master]
GO

IF EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'P0017_Photographer')
BEGIN
	ALTER DATABASE P0017_Photographer SET OFFLINE WITH ROLLBACK IMMEDIATE;
	ALTER DATABASE P0017_Photographer SET ONLINE;
	DROP DATABASE P0017_Photographer;
END


CREATE DATABASE [P0017_Photographer]
GO

USE [P0017_Photographer]
GO

CREATE TABLE [Photographer](
	[name] NVARCHAR(100),
	[address] NVARCHAR(100),
	[city] NVARCHAR(30),
	[country] NVARCHAR(30),
	[tel] INT,
	[email] NVARCHAR(50),
	[aboutMe] NVARCHAR(max),
	[map] NVARCHAR(max),
	[feature_Image] NVARCHAR(50),
	[title_Feature_Image] NVARCHAR(100),
)
GO

CREATE TABLE [Gallery](
	[id] INT PRIMARY KEY,
	[gallery_title] NVARCHAR(50),
	[content] NVARCHAR(255),
	[main_image] NVARCHAR(50),
)
GO

CREATE TABLE [Image](
	id INT IDENTITY(1,1),
	gid INT FOREIGN KEY REFERENCES Gallery(id),
	image_Path NVARCHAR(50),
	content NVARCHAR(100)
)

CREATE TABLE [View](
	numberOfViews INT,
)

CREATE TABLE [Share](
	[icon] NVARCHAR(50),
	[social_network] NVARCHAR(50),
	[url] NVARCHAR(max)
)

-- Insert to table  [Photographer]
INSERT INTO [Photographer] VALUES (N'Nguyen Minh Thanh', N'FPT University', N'Ha Noi', N'Viet Nam', 0985563540, N'thanhnmhe141011@fpt.edu.vn',
							N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, 
                            sed diam nonummy nibh euismod tincidunt ut laoreet dolore 
                            magna aliquam erat volutpat. Ut wisi enim ad minim veniam,
                            quis nostrud exerci tation ullamcorper suscipit lobortis 
                            nisl ut aliquip ex ea commodo consequat. Duis autem vel eum 
                            iriure dolor in hendrerit in vulputate velit esse molestie consequat,
                            vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan 
                            et iusto odio dignissim qui blandit praesent luptatum zzril delenit
                            augue duis dolore te feugait nulla facilisi. Nam liber tempor cum 
                            soluta nobis eleifend option congue nihil imperdiet doming id quod mazim',

							N'https://www.google.com/maps/embed?pb=!1m18!1m12!
                            1m3!1d1190.2070503935163!2d105.52647870195256!3d21.
                            012773956347107!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.
                            1!3m3!1m2!1s0x31345b465a4e65fb%3A0xaae6040cfabe8fe!
                            2zVHLGsOG7nW5nIMSQ4bqhaSBI4buNYyBGUFQ!5e0!3m2!1svi!2s
                            !4v1622357653694!5m2!1svi!2s',
							N'main.jpg',N'Lorem ipsum dolor sit amet')

-- Insert to table  [Gallery]
INSERT INTO [Gallery] VALUES (1, N'Gallery 1', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
												sed diam nonummy nibh euismod tincidunt ut laoreet dolore
												magna aliquam erat volutpat. Ut wisi enim ad minim veniam,
											    quis nostrud exerci tation', N'main-gallery1.jpg')
INSERT INTO [Gallery] VALUES (2, N'Gallery 2', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
												sed diam nonummy nibh euismod tincidunt ut laoreet dolore
												magna aliquam erat volutpat. Ut wisi enim ad minim veniam,
											    quis nostrud exerci tation', N'main-gallery2.jpg')
INSERT INTO [Gallery] VALUES (3, N'Gallery 3', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
												sed diam nonummy nibh euismod tincidunt ut laoreet dolore
												magna aliquam erat volutpat. Ut wisi enim ad minim veniam,
											    quis nostrud exerci tation', N'main-gallery3.jpg')
INSERT INTO [Gallery] VALUES (4, N'Gallery 4', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
												sed diam nonummy nibh euismod tincidunt ut laoreet dolore
												magna aliquam erat volutpat. Ut wisi enim ad minim veniam,
											    quis nostrud exerci tation', N'i9.jpg')

-- Insert to table  [Image] 

INSERT INTO [Image] VALUES (1, N'main-gallery1.jpg', N'This is image content...')
INSERT INTO [Image] VALUES (1, N'i1.jpg', N'This is image content...')
INSERT INTO [Image] VALUES (1, N'i2.jpg', N'This is image content...')
INSERT INTO [Image] VALUES (1, N'i4.jpg', N'This is image content...')
INSERT INTO [Image] VALUES (1, N'i3.jpg', N'This is image content...')
INSERT INTO [Image] VALUES (1, N'i10.jpg', N'This is image content...')
INSERT INTO [Image] VALUES (1, N'main-gallery3.jpg', N'This is image content...')
INSERT INTO [Image] VALUES (1, N'i9.jpg', N'This is image content...')

INSERT INTO [Image] VALUES (2, N'main-gallery2.jpg', N'This is image content...')
INSERT INTO [Image] VALUES (2, N'i10.jpg', N'This is image content...')
INSERT INTO [Image] VALUES (2, N'main.jpg', N'This is image content...')
INSERT INTO [Image] VALUES (2, N'i9.jpg', N'This is image content...')
INSERT INTO [Image] VALUES (2, N'main-gallery3.jpg', N'This is image content...')
INSERT INTO [Image] VALUES (2, N'main-gallery1.jpg', N'This is image content...')
INSERT INTO [Image] VALUES (2, N'i4.jpg', N'This is image content...')
INSERT INTO [Image] VALUES (2, N'i3.jpg', N'This is image content...')
INSERT INTO [Image] VALUES (2, N'i2.jpg', N'This is image content...')
INSERT INTO [Image] VALUES (2, N'i1.jpg', N'This is image content...')
INSERT INTO [Image] VALUES (2, N'main.jpg', N'This is image content...')
INSERT INTO [Image] VALUES (2, N'i10.jpg', N'This is image content...')
INSERT INTO [Image] VALUES (2, N'i3.jpg', N'This is image content...')

INSERT INTO [Image] VALUES (3, N'main-gallery3.jpg', N'This is image content...')
INSERT INTO [Image] VALUES (3, N'i3.jpg', N'This is image content...')
INSERT INTO [Image] VALUES (3, N'i10.jpg', N'This is image content...')
INSERT INTO [Image] VALUES (3, N'i1.jpg', N'This is image content...')
INSERT INTO [Image] VALUES (3, N'i2.jpg', N'This is image content...')
INSERT INTO [Image] VALUES (3, N'i9.jpg', N'This is image content...')

INSERT INTO [Image] VALUES (4, N'i9.jpg', N'This is image content...')
INSERT INTO [Image] VALUES (4, N'main-gallery2.jpg', N'This is image content...')
INSERT INTO [Image] VALUES (4, N'i10.jpg', N'This is image content...')

-- Insert into table view
INSERT INTO [View] VALUES(899)

-- insert into table share
INSERT [dbo].[Share] ([icon], [social_network], [url]) VALUES (N'face.png', N'Facebook', N'https://www.facebook.com/sharer/sharer.php?u=http%3A%2F%2Fus-123photo.simplesite.com%2F')
INSERT [dbo].[Share] ([icon], [social_network], [url]) VALUES (N'twitter.png', N'Twitter', N'https://twitter.com/')


