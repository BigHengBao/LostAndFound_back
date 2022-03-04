
/**失物招领 database
   author：hengbao
   date：2022/03/05
**/
-- 1.新建数据库
CREATE DATABASE IF NOT EXISTS lost_found DEFAULT CHARSET utf8 COLLATE utf8_general_ci;


-- 2.1、用户表
CREATE TABLE IF NOT EXISTS `myuser`(
   `user_id` INT UNSIGNED AUTO_INCREMENT,
   `user_account` VARCHAR(10) NOT NULL,
   `user_password` VARCHAR(20) NOT NULL,
   `user_rname` VARCHAR(20) NOT NULL,
   `user_sex` INT NOT NULL,
   `user_phone` VARCHAR(20) NOT NULL,
   `user_address` VARCHAR(50) ,
   `active` INT NOT NULL,
   `user_level` INT NOT NULL,
   `user_image` VARCHAR(200),
   `user_write` VARCHAR(30),
	  PRIMARY KEY (`user_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 2.2、物品表
CREATE TABLE IF NOT EXISTS `goods`(
   `goods_id` INT UNSIGNED AUTO_INCREMENT,
   `goods_name` VARCHAR(30) NOT NULL,
	 `type` VARCHAR(20) NOT NULL,
	 `get_time` TIMESTAMP,
	 `lost_time` TIMESTAMP,
	 `content` VARCHAR(200),
	 `product_image` VARCHAR(200) NOT NULL,
	 PRIMARY KEY (`goods_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 2.3、用户商品表
CREATE TABLE IF NOT EXISTS `myorder`(
   `order_id` INT UNSIGNED AUTO_INCREMENT,
	 `goods_id` INT NOT NULL,
   `user_id` INT NOT NULL,
   `active` INT NOT NULL,
	 `type` INT NOT NULL,
	 PRIMARY KEY (`order_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 2.4、分类表
CREATE TABLE IF NOT EXISTS `goodstype`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `type_name` VARCHAR(30) NOT NULL,
	 `type_num` INT NOT NULL,
	 `type_image` VARCHAR(200),
	 `active` INT NOT NULL,
	  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 2.5、评论表
CREATE TABLE IF NOT EXISTS `mycomment`(
	`comments_id` INT  UNSIGNED AUTO_INCREMENT,
	`goods_id` INT NOT NULL,
	`user_id` INT NOT NULL,
	`content` VARCHAR(200) NOT NULL,
	`addtime` TIMESTAMP NOT NULL,
	`active` INT NOT NULL	,
	 PRIMARY KEY (`comments_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 2.6、用户收藏表
CREATE TABLE IF NOT EXISTS `collection`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `goods_id` INT NOT NULL,
   `user_id` INT NOT NULL,
   `addtime` TIMESTAMP NOT NULL,
	 `active` INT NOT NULL,
	  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 3.1、设置每个表的id从一开始
ALTER  TABLE  myuser auto_increment 1000;
ALTER  TABLE  goods auto_increment 2000; 
ALTER  TABLE  myorder auto_increment 3000; 
ALTER  TABLE  goodstype auto_increment 4000;
ALTER  TABLE  mycomment auto_increment 5000; 
ALTER  TABLE  collection auto_increment 6000;
