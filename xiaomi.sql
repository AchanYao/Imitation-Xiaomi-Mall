/*
 Navicat Premium Data Transfer

 Source Server         : MyConncetion
 Source Server Type    : MariaDB
 Source Server Version : 100312
 Source Host           : localhost:3306
 Source Schema         : xiaomi

 Target Server Type    : MariaDB
 Target Server Version : 100312
 File Encoding         : 65001

 Date: 08/01/2020 10:56:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` bigint(20) NOT NULL,
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `modify_time` bigint(20) NOT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_detail_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `address_ibfk_1`(`user_detail_id`) USING BTREE,
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`user_detail_id`) REFERENCES `user_detail` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cart_items
-- ----------------------------
DROP TABLE IF EXISTS `cart_items`;
CREATE TABLE `cart_items`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` bigint(20) NOT NULL,
  `modify_time` bigint(20) NOT NULL,
  `cart_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `item_number` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `cart_id`(`cart_id`) USING BTREE,
  INDEX `item_id`(`item_id`) USING BTREE,
  CONSTRAINT `cart_items_ibfk_1` FOREIGN KEY (`cart_id`) REFERENCES `shopping_cart` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cart_items_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `items` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 110 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart_items
-- ----------------------------
INSERT INTO `cart_items` VALUES (107, 1578125795115, 1578384235265, 1, 188, 3);

-- ----------------------------
-- Table structure for item_type
-- ----------------------------
DROP TABLE IF EXISTS `item_type`;
CREATE TABLE `item_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name_zh` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` bigint(20) NOT NULL,
  `modify_time` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of item_type
-- ----------------------------
INSERT INTO `item_type` VALUES (1, 'xm mobile', '小米手机', 0, 0);
INSERT INTO `item_type` VALUES (2, 'appliances', '家电', 0, 0);
INSERT INTO `item_type` VALUES (3, 'hm mobile', '红米手机', 0, 0);
INSERT INTO `item_type` VALUES (5, 'tv', '电视', 0, 0);
INSERT INTO `item_type` VALUES (6, 'notebook', '笔记本', 0, 0);
INSERT INTO `item_type` VALUES (7, 'router', '路由器', 0, 0);
INSERT INTO `item_type` VALUES (8, 'IntelligentHardware', '智能硬件', 0, 0);
INSERT INTO `item_type` VALUES (10, '', '', 1578231513538, 1578231513538);

-- ----------------------------
-- Table structure for items
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` bigint(20) NOT NULL,
  `modify_time` bigint(20) NOT NULL,
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品描述',
  `price` decimal(30, 2) NOT NULL COMMENT '商品价格',
  `stock_quantity` int(10) NOT NULL COMMENT '库存数量',
  `pic_url` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品图片',
  `product_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `type_id` int(11) NOT NULL COMMENT '商品类型',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `type_id`(`type_id`) USING BTREE,
  CONSTRAINT `items_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `item_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 193 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of items
-- ----------------------------
INSERT INTO `items` VALUES (175, 1578059781435, 1578059781435, '120Hz高帧率流速屏 / 索尼6400万前后六摄 / 6.67\'\'小孔径全面屏 / 最高可选8GB+256GB大存储 / 高通骁龙730G处理器 / 3D四曲面玻璃机身 / 4500mAh+27W快充 / 多功能NFC', 2599.00, 500, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/be92bc4baa572bf467fc9e881fd4be2a.png?thumb=1&w=200&h=138&f=webp&q=90', '小米CC9 Pro', 1);
INSERT INTO `items` VALUES (176, 1578059781654, 1578059781654, '5G双卡全网通超高速网络 / 骁龙855Plus旗舰处理器 / 40W有线闪充+30W无线闪充+10W无线反充，4000mAh长续航 / 4800万全焦段三摄 / 超振感横向线性马达 / VC液冷散热 / 高色准三星AMOLED屏幕 / 多功能NFC / 赠送小米云服务1TB云存储', 3699.00, 500, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/41c566d825a3ae3b5751a78d4c7cffdb.png?thumb=1&w=200&h=138&f=webp&q=90', '小米9 Pro 5G', 1);
INSERT INTO `items` VALUES (177, 1578059781709, 1578059781709, '「火爆热卖中，6GB+128GB购机赠10000mAh充电宝」前置3200万自拍 / 索尼4800万超广角三摄 / 多色炫彩轻薄机身 / 6.39英寸三星 AMOLED水滴屏 /4030mAh大电量 / 骁龙710处理器 / 屏幕指纹 / NFC功能 / 红外遥控功能 / Game Turbo2.0游戏加速', 1699.00, 500, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/f515ab05232ed14ccd78ec67e024495a.png?thumb=1&w=200&h=138', '小米CC9', 1);
INSERT INTO `items` VALUES (178, 1578059781771, 1578059781771, '前置3200万自拍 / 索尼4800万超广角三摄 / 4030mAh大电量 / 3D全曲面玻璃机身，浪漫满分的全新配色 / 6.088英寸三星 AMOLED水滴屏 /第七代屏幕指纹 / 首发骁龙665处理器 / 全新Mimoji萌拍 / 红外遥控功能', 1099.00, 500, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/df9b3e7a562e02a33eb069b3f0119815.png?thumb=1&w=200&h=138', '小米CC9e', 1);
INSERT INTO `items` VALUES (179, 1578059781807, 1578059781807, '100%美图相机，前置3200万，自拍美得更自然 / 索尼4800万超广角三摄，拍风景、建筑、多人合影，画面更震撼 / 美图经典人像，不修图也好看 / AI弱光人像，暗光环境也能拍出水光肌 / 全身美型，变美不变形 / 4030mAh大电量，足够尽兴玩一天 / 美图定制仙女配色、轻薄机身 / 6.39英寸三星 AMOLED水滴屏 / 骁龙710处理器 / 第七代屏幕指纹解锁 / 支持NFC和红外遥控', 1999.00, 500, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/b02f50c9dd2e01c139a06a12502755ef.png?thumb=1&w=200&h=138', '小米CC9 美图定制版', 1);
INSERT INTO `items` VALUES (180, 1578059781837, 1578059781837, 'DxOMark拍照108分 / 磁动力滑盖全面屏 / 四曲面陶瓷机身 / 骁龙845旗舰处理器 / 包装盒内附赠10W无线充电器', 2599.00, 500, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/3b5e5829fdf92d54c167f4681531b535.png?thumb=1&w=200&h=138', '小米MIX 3', 1);
INSERT INTO `items` VALUES (181, 1578059781886, 1578059781886, '「购机赠耳机；享小米/花呗6期免息；+1元得50G云空间月卡；延保享7折优惠」120Hz高帧率流速屏 / 索尼6400万前后六摄 / 6.67\'\'小孔径全面屏 / 最高可选8GB+256GB大存储 / 高通骁龙730G处理器 / 3D四曲面玻璃机身 / 4500mAh+27W快充 / 多功能NFC', 1699.00, 500, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/cff2977b8aab1e43b94b2f00083f4ae1.jpg?thumb=1&w=200&h=138&f=webp&q=90', 'Redmi K30', 3);
INSERT INTO `items` VALUES (182, 1578059781914, 1578059781914, '「0元预约中，1月7日首卖，敬请期待」双模5G / 三路并发 / 高通骁龙765G / 7nm 5G低功耗处理器 / 120Hz高帧率流速屏 / 6.67\'\'小孔径全面屏 / 索尼6400万前后六摄 / 最高可选8GB+256GB大存储 / 4500mAh+30W快充 / 3D四曲面玻璃机身 / 多功能NFC', 2599.00, 500, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/742a328bdaa242aea89ec2a9c8661013.jpg?thumb=1&w=200&h=138&f=webp&q=90', 'Redmi K30 5G', 3);
INSERT INTO `items` VALUES (183, 1578059781940, 1578059781940, '「3GB+32GB直降100元，到手价仅599元，加1元得50G云空间月卡」5000mAh大电量 / 最高可选4GB+64GB版本 / 支持18W快充 / Type-C充电接口 / 6.22水滴全面屏 / AI人脸解锁 / 骁龙八核处理器 / 超大音量 / 支持无线FM收音机', 599.00, 500, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/398311b2e6f47ac324ba0421a0ac1b80.png?thumb=1&w=200&h=138&f=webp&q=90', 'Redmi 8A', 3);
INSERT INTO `items` VALUES (184, 1578059781969, 1578059781969, '「火爆热卖中，4GB+64GB首次闪降100元，到手价899元」4800万全场景四摄 / 前置1300万美颜相机 / 骁龙665处理器 / 4000mAh超长续航 / 标配18W快充 / 超线性扬声器 / 90%高屏占比 / 康宁大猩猩保护玻璃 / 6.3英寸水滴全面屏', 899.00, 500, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/dacd6a3d8440b7a038e9778702bd6db6.png?thumb=1&w=200&h=138&f=webp&q=90', 'Redmi Note 8', 3);
INSERT INTO `items` VALUES (185, 1578059782005, 1578059782005, '「12GB+512GB到手价仅2799元。最高享6期免息，每期低至467元。加1元得50G云空间月卡；延保享7折优惠」高通骁龙855 Plus处理器 / 最高可选12GB+512GB大内存 / 索尼4800万超广角三摄 / 前置2000万升降式相机 / 6.39\"AMOLED极界全面屏 / 3D四曲面玻璃机身 / 4000mAh超长续航 / 标配27W充电器 / 8层石墨立体散热 / 第七代屏下指纹解锁 / 多功能NFC / 双频GPS导航', 2799.00, 500, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/c1937ecb7e9b8e1aee11d6936e19d53c.png?thumb=1&w=200&h=138&f=webp&q=90', 'Redmi K20 Pro 尊享版', 3);
INSERT INTO `items` VALUES (186, 1578059782034, 1578059782034, '「火爆热卖中，6GB+64GB闪降100元，到手价1199元起，+30元得黑鲨游戏手柄套装，延保享7折优惠」6400万旗舰级全场景四摄 / 前置2000万 AI美颜相机 / G90T专业游戏芯片，液冷散热 / 6.53英寸水滴全面屏 / 4500mAh大电量 / 标配18W快充 / 康宁大猩猩保护玻璃 / 多功能NFC / 红外遥控功能 / Game Turbo2.0游戏加速', 1199.00, 500, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/8ee0af37bbd2f5a83c799e87dd791037.png?thumb=1&w=200&h=138&f=webp&q=90', 'Redmi Note 8 Pro', 3);
INSERT INTO `items` VALUES (187, 1578059782158, 1578059782158, 'Redmi 红米电视 70英寸 R70A', 2999.00, 500, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/6917267948c54c647d2009a98637aac6.jpg?thumb=1&w=200&h=138&f=webp&q=90', 'Redmi 红米电视 70英寸 R70A', 5);
INSERT INTO `items` VALUES (188, 1578059782189, 1578059782189, 'RedmiBook 13', 4499.00, 500, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/6abc701fb3cf48f2c7a3fd5ef053529a.jpg?thumb=1&w=200&h=138&f=webp&q=90', 'RedmiBook 13', 6);
INSERT INTO `items` VALUES (189, 1578059782226, 1578059782226, '米家互联网空调C1', 2599.00, 500, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/03dc85cd792904ddc8027b2d781beed8.png?thumb=1&w=200&h=138&f=webp&q=90', '米家互联网空调C1', 2);
INSERT INTO `items` VALUES (190, 1578059782256, 1578059782256, 'Redmi路由器AC2100', 169.00, 500, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/aa1e0a4860cf40d34e1192d86691c82c.png?thumb=1&w=200&h=138&f=webp&q=90', 'Redmi路由器AC2100', 7);
INSERT INTO `items` VALUES (191, 1578059782280, 1578059782280, '小米米家智能摄像机云台版', 169.00, 500, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/2a500be4264c692899b25d86c16403f7.jpg?thumb=1&w=200&h=138', '小米米家智能摄像机云台版', 8);
INSERT INTO `items` VALUES (192, 1578231513500, 1578231513500, '测试商品应该是无价之宝；测试商品应该独一无二；测试商品应该很炫丽；测试商品应该很智能；', 9223372036854776000.00, 1, 'https://images.alphacoders.com/113/thumb-1920-11391.jpg', '测试商品', 8);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `modify_time` bigint(20) NULL DEFAULT NULL,
  `create_time` bigint(20) NULL DEFAULT NULL,
  `address_id` int(11) NOT NULL,
  `user_detail_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_detail_id`(`user_detail_id`) USING BTREE,
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`user_detail_id`) REFERENCES `user_detail` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_items
-- ----------------------------
DROP TABLE IF EXISTS `order_items`;
CREATE TABLE `order_items`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` bigint(20) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `modify_time` bigint(20) NULL DEFAULT NULL,
  `order_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `item_number` int(11) NOT NULL COMMENT '商品数量',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_items_ibfk_1`(`order_id`) USING BTREE,
  INDEX `item_id`(`item_id`) USING BTREE,
  CONSTRAINT `order_items_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `order_items_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `items` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name_zh` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'ROLE_user', '用户');
INSERT INTO `role` VALUES (2, 'ROLE_admin', '管理员');

-- ----------------------------
-- Table structure for shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` bigint(20) NULL DEFAULT NULL,
  `modify_time` bigint(20) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `shopping_cart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------
INSERT INTO `shopping_cart` VALUES (1, 1578099208761, 1578099208761, 13);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` bigint(20) NOT NULL,
  `modify_time` bigint(20) NOT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `enable` int(1) NOT NULL DEFAULT 1 COMMENT '1可用',
  `locked` int(1) NOT NULL DEFAULT 0 COMMENT '1被锁定',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (13, 1578099208522, 1578099208522, '$2a$10$Kp8Xg2C0Vqd0AV23uv5qneKMIy4RC5GV2UFvEeMmRBe/vuUMl2oKG', 'yyx', 1, 0);
INSERT INTO `user` VALUES (14, 1578099208522, 1578099208522, '$2a$10$Kp8Xg2C0Vqd0AV23uv5qneKMIy4RC5GV2UFvEeMmRBe/vuUMl2oKG', 'admin', 1, 0);

-- ----------------------------
-- Table structure for user_detail
-- ----------------------------
DROP TABLE IF EXISTS `user_detail`;
CREATE TABLE `user_detail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` bigint(20) NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `modify_time` bigint(20) NOT NULL,
  `score` int(10) NOT NULL COMMENT '用户积分',
  `real_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '真实姓名',
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `user_detail_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_detail
-- ----------------------------
INSERT INTO `user_detail` VALUES (4, 1578099208555, '', 1578099208555, 0, '', 13);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 13, 1);
INSERT INTO `user_role` VALUES (2, 14, 2);

SET FOREIGN_KEY_CHECKS = 1;
