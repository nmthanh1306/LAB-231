USE [master]
GO

IF EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'P0004_Digital_News')
BEGIN
	ALTER DATABASE [P0004_Digital_News] SET OFFLINE WITH ROLLBACK IMMEDIATE;
	ALTER DATABASE [P0004_Digital_News] SET ONLINE;
	DROP DATABASE [P0004_Digital_News];
END

CREATE DATABASE [P0004_Digital_News]
GO

USE [P0004_Digital_News]
GO

CREATE TABLE Article
(
	id INT PRIMARY KEY,
	title NVARCHAR(100) NOT NULL,
	image VARCHAR(255) NOT NULL,
	content NVARCHAR(MAX) NOT NULL,
	publish_date DATETIME NOT NULL,
	author NVARCHAR(50) NOT NULL, 
)

INSERT INTO Article VALUES(1, N'Making security feeds smarter via machine learning',
						'i1.jpg',
						N'In today age of survedance, with cameras even in our homes, security professionals need to montor an ever-increasing number of screens. In 2014 alone, 245 milion video survellance cameras were instaled globaby, 
						according o an IHS report. tis increasingly clear thatthe watchmen are having ‘rouble watching. This fs where Singapore-based Vi Dimensions hopes to help, by Kenttying ancmabes {to alert human operators that a second lock is needed 
						|Whie the securty industry is akready familar wth rule-based analytes, there is sta gap, according to
                        its cofounder and chief executive offcer Raymond Looi Video analytes has been in the market forthe
                        last 10 years, but the way they have been doing isnot very effcent, using rule-based analytics. This
                        requies you to know what you are looking for and then spect rule, when most do not know what to
                        look out fr he says, in a conversation with Digtal News Asia (DNA) in Singapore recent. We fet that
                        ‘there was a g2pin the industry in how they apphed automation to cameras 4 and wih the prolferation of
                        ‘survellance cameras and vast amounts of data being generated, we fe that ths was an area in which
                        ‘we cout diferente oursetves, he adds',
						'2016-04-12 02:28:00',
						'Benjamin Cher')
INSERT INTO Article VALUES(2,N'Gaza conflict intensifies with rocket barrages and air strikes',
						'Gaza_conflict.jpg',
						N'Palestinian militants fired more rockets into Israel commercial heartland on Thursday as Israel kept up a punishing bombing campaign in the Gaza Strip and massed tanks and troops on the enclave border.
						Four days of cross-border fighting showed no sign of abating, and Israeli Prime Minister Benjamin Netanyahu said the campaign "will take more time". Israeli officials said Gaza ruling Hamas group must be dealt a strong deterring blow before any ceasefire.
						Violence has also spread to mixed communities of Jews and Arabs in Israel, a new front in the long conflict. Synagogues were attacked and fighting broke out on the streets of some towns, prompting Israel president to warn of civil war.
						At least 103 people have been killed in Gaza, including 27 children, over the past four days, Palestinian medical officials said. On Thursday alone, 49 Palestinians were killed in the enclave, the highest single-day figure since Monday.
						Seven people have been killed in Israel: a soldier patrolling the Gaza border, five Israeli civilians, including two children, and an Indian worker, Israeli authorities said.
						Worried that the region worst hostilities in years could spiral out of control, the United States was sending in an envoy, Hady Amr. Truce efforts by Egypt, Qatar and the United Nations had yet to deliver a sign of progress. read more
						U.S. President Joe Biden called on Thursday for a de-escalation of the violence, saying he wanted to see a significant reduction in rocket attacks.
						Militants fired rocket salvoes at Tel Aviv and surrounding towns with the Iron Dome anti-missile system intercepting many of them. Communities near the Gaza border and the southern desert city of Beersheba were also targeted.
						Five Israelis were wounded by a rocket that hit a building near Tel Aviv on Thursday.',
						'2021-05-14 08:40:00',
						'Nidal Al-mughrabiJeffrey Heller')
INSERT INTO Article VALUES(3,N'Tesla crash victim lauded "full self-driving" in videos on Tiktok 1',
						'tesla.jpg',
						N'A Tesla car driver killed in a recent accident in California praised the automaker''s "full self-driving" features, and posted videos on his apparent Tiktok account, in which he appeared to drive with his hands off the wheel.
						On May 5, a Tesla Model 3 crashed into an overturned truck on a highway in Fontana, killing the Tesla driver and injuring the truck driver and a motorist who had stopped to help him.
						The Associated Press news agency cited police as saying a preliminary investigation had determined the Tesla''s driver assistant system Autopilot was engaged prior to the crash.
						But in a correction issued late on Friday, police said, "There has not been a final determination made as to what driving mode the Tesla was in."
						Two videos of a man driving with his hands off the wheel were posted on the alleged Tiktok account of the victim, 35-year-old Steven Hendrickson of Running Springs in California.
						"What would do I do without my full self-driving Tesla after a long day at work," said a message on one. "Coming home from LA after work, thank god, self-drive," said a comment on another video, adding, "Best car ever!"
						Tesla dubbed its driver assistant features "Autopilot" or "Full Self-driving," which experts say could mislead consumers into believing the car can drive by itself.
						On its website, Tesla said its Autopilot feature does not make the vehicle autonomous, however.
						On his Facebook account, Hendrickson was shooting a video while driving on autopilot, saying, "Don''t worry. I am on autopilot."
						Family members were not available for comment and Tesla, which has disbanded its public relations teams, was not immediately available for comment.
						Tesla Club-SoCal, a group of Tesla owners in Southern California, said on social media that he was an active member who "loved his Tesla." He is survived by his wife and two children, it added.
						The National Highway Traffic Safety Administration has been investigating more than two dozen crashes of Tesla vehicles, including the Fontana crash and a high-profile one in Texas last month that killed two men.
						Since 2016 at least three Tesla vehicles operating on Autopilot have been in fatal crashes, two involving a Tesla car driving beneath a semi-truck in Florida.
						The U.S. transport safety board said Tesla autopilot system failed to properly detect a truck as it crossed the car''s path, contributing to the accidents also caused by a lack of driver attention and an adequate driver monitoring system.',
						'2021-05-17 01:02:00',
						'Digital News Asia')
INSERT INTO Article VALUES(4,N'Garmin launches Approach S12 golfing smartwatch',
						'Garmin-Approach-S12.jpg',
						N'GARMIN Malaysia has announced a new addition to its Approach series of GPS golf products.
						The Approach S12 smartwatch claims to be equipped with 42,000 preloaded courses, on top of promising “exemplary” battery life and connectivity to Garmin’s club tracking sensor, it said in a statement.
						The smartwatch also works with Garmin’s golf app, which allows users to more easily upload screenshots and review their performance stats, it added.
						On the design front, the Approach S12 features interchangeable quick-release bands. It introduces a round watch design with a 1.3-inch sunlight-readable, high-resolution display, which can be configured with a new "Big Numbers" display mode to make it easier to read yardage numbers during golfing sessions.
						When paired with the Garmin Golf app on a compatible smartphone, the Approach S12 wirelessly updates a player’s most frequently played golf courses for up-to-date course information. Garmin claims that the battery lasts up to 30 hours in GPS mode.
						“With the new Approach S12, Garmin has brought the best of our technology to the forefront,” said Scoppen Lin, director of Garmin Asia. “The smartwatch is designed to assist new golfers to efficiently improve their game while staying connected within the golfing community”.
						The Approach S12 uses its built-in high sensitivity GPS that zeroes in on a player’s location, allow them to gain precise yardages to the front, middle, and back of the green, hazards, doglegs, layups and more, Garmin claimed.
						Golfers can also pair the smartwatch with the optional Approach CT10 club sensors for automatic club tracking to see how far players hit each club, it added.
						The Approach S12 GPS golf watch comes in Black, Granite Blue and White. It is available now at a retail pricing of US$225 (RM930) on Lazada, Shopee, AECO e-store and at all Garmin branded stores, including authorised resellers and MST Golf.',
						'2021-05-16 01:08:00',
						'Reuters')
INSERT INTO Article VALUES(5,N'Aiming for reinvention, Apple eyes ad growth after privacy changes',
						'Apple.jpg',
						N'Apple is taking steps to boost its advertising business as the iPhone maker implements new privacy rules, updates that marketers have criticized for interfering with their ability to reach target audiences, according to several press reports.
						The company will give marketers more data about ad performance on in-app ads bought through Apple instead of through third parties. The difference could give the company an advantage in drawing more advertisers to its platform if it decides to expand the business, The Wall Street Journal reported, citing ad executives familiar with the matter.
						The plan also may help to fuel criticism that Apple will use recent changes to its app privacy rules to its benefit in ad sales. Apple last month introduced its App Tracking Transparency (ATT) feature in an update of software that runs devices including the iPhone. The feature asks customers to consent to share identifiers that help with ad targeting, but surveys have shown that many people won''t opt into having their online activities tracked. Without behavorial targeting, marketers face the possibility of wasting their ad spending.
						"The efficiency that has been built up over 15 years is literally back to the beginning," said Brian Bowman, chief executive of Consumer Acquisition, an agency that specializes in marketing apps on social media. "It is a fundamental change that will disrupt advertising creatively, and the impact will be felt substantially by small- and medium-size businesses." Bowman further detailed his criticism of Apple in a blog post.
						Apple has defended the changes to its privacy rules multiple times amid the growing chorus of criticism. The company denied it was giving an advantage to its own products and claimed data restrictions on ads bought through third-party platforms were necessary to protect consumer privacy, according to a spokesperson cited by the Journal.
						With Apple''s latest ad offering, marketers who buy ads through third-party platforms to target consumers who have opted out of tracking will receive aggregate data about their campaigns after three days, the newspaper reported. Advertisers who buy ad space through Apple will see reports on results almost in real time, including more detailed information about how their ads performed, allowing those advertisers to adjust campaigns quickly.',
						'2021-05-13 02:03:00',
						'Robert Williams')
INSERT INTO Article VALUES(6,N'My test',
						'i1.jpg',
						N'asdddddddsaddddddddddddddddddddd  m asmdksadmlas sladasdsaldas  stem failed to properly detect a truck as it crossed the car''s path, contributing to the accidents also caused by a lack of driver attention and an adequate driver monitoring system.',
						'2021-05-16 09:49:00',
						'Minh Thanh')
INSERT INTO Article VALUES(7,N'test 4',
						'i1.jpg',
						N'asdddddddsaddddddddddddddddddddd  m asmdksadmlas sladasdsaldas  stem failed to properly detect a truck as it crossed the car''s path, contributing to the accidents also caused by a lack of driver attention and an adequate driver monitoring system.',
						'2021-05-12 09:49:00',
						'Minh Thanh')
INSERT INTO Article VALUES(8, N'Making security feeds smarter via machine learning',
						'i1.jpg',
						N'In today age of survedance, with cameras even in our homes, security professionals need to montor an ever-increasing number of screens. In 2014 alone, 245 milion video survellance cameras were instaled globaby, 
						according o an IHS report. tis increasingly clear thatthe watchmen are having ‘rouble watching. This fs where Singapore-based Vi Dimensions hopes to help, by Kenttying ancmabes {to alert human operators that a second lock is needed 
						|Whie the securty industry is akready familar wth rule-based analytes, there is sta gap, according to
                        its cofounder and chief executive offcer Raymond Looi Video analytes has been in the market forthe
                        last 10 years, but the way they have been doing isnot very effcent, using rule-based analytics. This
                        requies you to know what you are looking for and then spect rule, when most do not know what to
                        look out fr he says, in a conversation with Digtal News Asia (DNA) in Singapore recent. We fet that
                        ‘there was a g2pin the industry in how they apphed automation to cameras 4 and wih the prolferation of
                        ‘survellance cameras and vast amounts of data being generated, we fe that ths was an area in which
                        ‘we cout diferente oursetves, he adds',
						'2021-05-20 02:28:00',
						'Benjamin Cher')
