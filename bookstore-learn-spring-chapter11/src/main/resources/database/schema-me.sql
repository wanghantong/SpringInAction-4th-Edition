CREATE TABLE `spitter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `fullName` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `updateByEmail` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(25) NOT NULL,
  `title` varchar(25) NOT NULL,
  `summary` varchar(100) NOT NULL,
  `createTime` DATETIME NOT NULL,
  `editTime` DATETIME NOT NULL,
  `launchTime` DATETIME NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;