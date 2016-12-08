drop table if exists article_category;
drop table if exists article_categories;
drop table if exists category;
drop table if exists article_tags;
drop table if exists article;

-- 需要修改映射配置和字段类型
CREATE TABLE `article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `categories` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `editTime` datetime DEFAULT NULL,
  `launchTime` datetime DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `tags` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `author_intro` varchar(255) DEFAULT NULL,
  `binding` varchar(20) DEFAULT NULL,
  `catalog` varchar(1500) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `isbn` varchar(20) DEFAULT NULL,
  `largeImage` varchar(255) DEFAULT NULL,
  `mediumImage` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `origin_title` varchar(255) DEFAULT NULL,
  `pages` smallint(6) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `pubDate` datetime DEFAULT NULL,
  `secondPrice` double DEFAULT NULL,
  `smallImage` varchar(255) DEFAULT NULL,
  `summay` varchar(255) DEFAULT NULL,
  `translater` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;