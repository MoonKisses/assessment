/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  wangyifan
 * Created: 15/07/2020
 */

CREATE TABLE BOOK(

bookID int,
title varchar(50),
authorName varchar(50),
publisherName varchar(50),
PRIMARY KEY(bookID));


INSERT INTO BOOK (bookID, title, authorName, publisherName)
VALUES
(0001, 'The Shadow Rising', 'Robert Jordan', 'Little Brown Book Group'),
(0002, 'Stranger in a Strange Land', 'Robert A. Heinlein', 'Hodder & Stoughton General Division'),
(0003, 'Leaves Of Grass', 'Walt Whitman', 'Pan Macmillan'),
(0004, 'The Terminal List', 'Jack Carr', 'Simon & Schuster'),
(0005, 'Normal People', 'Sally Rooney', 'Pan Macmillan'),
(0006, 'The Treadstone Resurrection ', 'Robert Ludlum', 'Text Publishing'),
(0007, 'Twas the Nightshift Before Christmas', 'Adam Kay', 'Picador'),
(0008, 'Jonathon Fairfax Must Be Destroyed', 'Christopher Shevlin', 'Picador'),
(0009, 'Nonstop Nonsense', 'Margaret Mahy', 'Audible Studios'),
(0010, 'The Worst Teachers', 'David Walliams', 'HarperCollinsChildrensBooks'),
(0011, 'Dying To Be Me', 'Anita Moorjani', 'Hay House Inc'),
(0012, 'The Book of Five Rings', 'Miyamoto Musashi', 'Merchant Books'),
(0013, 'The Silent Wife', 'Karin Slaughter', 'HarperCollins'),
(0014, 'A Gentleman in Moscow', 'Towles Amor', 'CornerStone'),
(0015, 'Acid For The Children', 'Flea', 'CornerStone'),
(0016, 'The Safe Place', 'Anna Downes', 'Affirm Press'),
(0017, 'The Lost Flowers of Alice Hart', 'Holly Ringland', 'HarperCollins'),
(0018, 'The Eyes of Darkness', 'Dean Koontz', 'Headline Publishing Group'),
(0019, 'The Stockmen', 'Rachael Treasure', 'Penguin Books AU'),
(0020, 'A Room Made of Leaves', 'Kate Grenville', 'Text Publishing');



SELECT * FROM BOOK;

