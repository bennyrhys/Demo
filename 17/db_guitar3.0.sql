/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 100214
 Source Host           : localhost:3366
 Source Schema         : db_guitar

 Target Server Type    : MySQL
 Target Server Version : 100214
 File Encoding         : 65001

 Date: 16/09/2018 11:37:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_administrator
-- ----------------------------
DROP TABLE IF EXISTS `tb_administrator`;
CREATE TABLE `tb_administrator`  (
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_administrator
-- ----------------------------
INSERT INTO `tb_administrator` VALUES ('EasyGuitar', 'glp');
INSERT INTO `tb_administrator` VALUES ('grx', 'EasyGuitar');
INSERT INTO `tb_administrator` VALUES ('lyj', 'EasyGuitar');
INSERT INTO `tb_administrator` VALUES ('pqq', 'EasyGuitar');

-- ----------------------------
-- Table structure for tb_cdetails
-- ----------------------------
DROP TABLE IF EXISTS `tb_cdetails`;
CREATE TABLE `tb_cdetails`  (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `c_id` int(100) DEFAULT NULL,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `c_id`(`c_id`) USING BTREE,
  CONSTRAINT `tb_cdetails_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `tb_comment` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 177 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_cdetails
-- ----------------------------
INSERT INTO `tb_cdetails` VALUES (86, 92, '会有薛之谦的《我好像在哪见过你》么', '2018-09-11 20:56:07', '88888888');
INSERT INTO `tb_cdetails` VALUES (87, 92, '好听~~~，大伟老师，能否出一首《perfect》ED sheeran的，已经沉迷了，不胜感激~~~', '2018-09-11 20:56:24', '88888888');
INSERT INTO `tb_cdetails` VALUES (88, 92, '希望老师编一个我们不该这样的 张赫宣唱的吉他谱谢谢', '2018-09-11 20:56:44', '88888888');
INSERT INTO `tb_cdetails` VALUES (89, 92, '希望大伟老师能够出一个林宥嘉的说谎', '2018-09-11 20:57:01', '88888888');
INSERT INTO `tb_cdetails` VALUES (90, 92, '我真是不知道怎么说了，好多朋友求英文歌，尤其是断眉的歌，我真的很怀疑你们能唱吗？这种R&B唱时都是飘着的感觉，很不好唱的。', '2018-09-11 20:57:19', '88888888');
INSERT INTO `tb_cdetails` VALUES (91, 92, '稍安勿躁，过几天会出谱', '2018-09-11 20:57:35', '88888888');
INSERT INTO `tb_cdetails` VALUES (92, 92, '要是能出一首That girl就好了，这个暑假追我的女神~', '2018-09-11 20:57:49', '88888888');
INSERT INTO `tb_cdetails` VALUES (93, 92, '呵呵，听着是不是很好听？蓝调能不好听吗？但是我告诉和弦难的一笔。弹起来几乎不能再分心唱，玩毛', '2018-09-11 20:58:07', '88888888');
INSERT INTO `tb_cdetails` VALUES (94, 100, '150字内哦！！！', '2018-09-11 20:58:46', '88888888');
INSERT INTO `tb_cdetails` VALUES (95, 100, '真是太专业了。', '2018-09-11 20:59:16', '88888888');
INSERT INTO `tb_cdetails` VALUES (96, 100, '会有薛之谦的《我好像在哪见过你》么  ', '2018-09-11 20:59:22', '88888888');
INSERT INTO `tb_cdetails` VALUES (97, 100, '这个暑假追我的女神~  呵呵，听着是不是很好听？蓝调能不好听吗？但是我告诉和弦难的一笔。弹起来几乎不能再分心唱，玩毛  好听，就练这个了', '2018-09-11 20:59:30', '88888888');
INSERT INTO `tb_cdetails` VALUES (98, 100, '会有薛之谦的《我好像在哪见过你》么  好听~~~，老师，能否出一首《perfect》ED sheeran的，已经沉迷了，不胜感激~~~  希望大伟老师编一个我们不该这样的 张赫宣唱的吉他谱谢谢  希望老师能够出一个林宥嘉的说谎  我真是不知道怎么说了，好多朋友求英文歌，尤其是断眉的歌，我真的', '2018-09-11 20:59:51', '88888888');
INSERT INTO `tb_cdetails` VALUES (99, 105, '说真的 我想求一首80还有后', '2018-09-11 21:04:09', '88888888');
INSERT INTO `tb_cdetails` VALUES (100, 105, '真是太专业了。', '2018-09-11 21:04:19', '88888888');
INSERT INTO `tb_cdetails` VALUES (101, 105, '这个暑假追我的女神~  呵呵，听着是不是很好听？蓝调能不好听吗？但是我告诉和弦难的一笔。弹起来几乎不能再分心唱，玩毛  好听，就练这个了', '2018-09-11 21:04:27', '88888888');
INSERT INTO `tb_cdetails` VALUES (102, 105, '会有薛之谦的《我好像在哪见过你》么  ', '2018-09-11 21:04:38', '88888888');
INSERT INTO `tb_cdetails` VALUES (103, 105, '那歌好听但是不好唱，我自己扒了原版的，我的天，公公呛都吼出来了。还跑调。。放弃了，都多年过去了。现在还有人要。。。。呵呵，你要是能唱了我教你', '2018-09-11 21:04:50', '88888888');
INSERT INTO `tb_cdetails` VALUES (104, 105, '求女生版', '2018-09-11 21:05:05', '88888888');
INSERT INTO `tb_cdetails` VALUES (105, 111, '最近抖音上很火的，猫的房东的<云烟成雨》求出', '2018-09-11 21:10:45', '88888888');
INSERT INTO `tb_cdetails` VALUES (106, 111, '老师求出薛之谦的《哑巴》', '2018-09-11 21:10:57', '88888888');
INSERT INTO `tb_cdetails` VALUES (107, 111, '小丽唱得就是好！百听不厌！', '2018-09-11 21:11:07', '88888888');
INSERT INTO `tb_cdetails` VALUES (108, 111, '我不要五颜六色的小丽，我要最初小姐姐的样子。', '2018-09-11 21:11:24', '88888888');
INSERT INTO `tb_cdetails` VALUES (109, 115, '买辣椒也用券 《起风了》吉他弹唱', '2018-09-11 21:16:29', '88888888');
INSERT INTO `tb_cdetails` VALUES (110, 115, '真是太专业了。', '2018-09-11 21:16:37', '88888888');
INSERT INTO `tb_cdetails` VALUES (111, 115, '会有薛之谦的《我好像在哪见过你》么  ', '2018-09-11 21:16:45', '88888888');
INSERT INTO `tb_cdetails` VALUES (112, 118, '鼓的伴奏能不能给一个啊', '2018-09-11 21:20:36', '88888888');
INSERT INTO `tb_cdetails` VALUES (113, 118, '喜欢，就是感觉不太一样', '2018-09-11 21:20:46', '88888888');
INSERT INTO `tb_cdetails` VALUES (114, 118, '吉他表现的不太明显，架子鼓和人声更突出！！！', '2018-09-11 21:20:54', '88888888');
INSERT INTO `tb_cdetails` VALUES (115, 118, '老师的谱，从不怀疑，但是买了之后再看视频，感觉被骗了，哈哈', '2018-09-11 21:21:03', '88888888');
INSERT INTO `tb_cdetails` VALUES (116, 118, '编得非常的好。', '2018-09-11 21:21:11', '88888888');
INSERT INTO `tb_cdetails` VALUES (117, 118, '老师，能编一下Bob Dylan的《Like a rolling stone》吗？', '2018-09-11 21:21:24', '88888888');
INSERT INTO `tb_cdetails` VALUES (118, 118, '老师！能研究一下，so far away吗？', '2018-09-11 21:21:33', '88888888');
INSERT INTO `tb_cdetails` VALUES (119, 125, '老师，吉他谱跟歌词有点对不上，歌词比谱子慢了一小节，希望尽快处理一下喔', '2018-09-11 21:26:01', '88888888');
INSERT INTO `tb_cdetails` VALUES (120, 125, '《前任3:再见前任》插曲《体面》于文文 吉他弹唱', '2018-09-11 21:26:10', '88888888');
INSERT INTO `tb_cdetails` VALUES (121, 127, 'EasyGuitar中了抖音的毒了', '2018-09-11 23:15:10', '15834518689');
INSERT INTO `tb_cdetails` VALUES (122, 127, 'EasyGuitar，出一首李荣浩的新歌《年少有为》吧，巨好听', '2018-09-11 23:15:33', '15834518689');
INSERT INTO `tb_cdetails` VALUES (123, 127, '老师，出一首李荣浩的新歌《年少有为》吧，巨好听的', '2018-09-11 23:15:46', '15834518689');
INSERT INTO `tb_cdetails` VALUES (124, 127, '求谱啊老师', '2018-09-11 23:15:57', '15834518689');
INSERT INTO `tb_cdetails` VALUES (125, 127, '棒', '2018-09-11 23:16:05', '15834518689');
INSERT INTO `tb_cdetails` VALUES (126, 132, '几年在网上看的话，还是大伟吉他出的谱子最好，简单易按，韵律优美。', '2018-09-11 23:18:50', '15834518689');
INSERT INTO `tb_cdetails` VALUES (127, 132, '提几个小希望：', '2018-09-11 23:19:00', '15834518689');
INSERT INTO `tb_cdetails` VALUES (128, 132, '希望谱子排版能尽量紧凑一些，其实内容并不多如果能在两页做完的话，看着谱子完全就可以弹唱，不需要翻页了。', '2018-09-11 23:19:13', '15834518689');
INSERT INTO `tb_cdetails` VALUES (129, 132, '还有虽然横板的电脑比较方便看，可是还是打印出来更好用。希望以后改版竖版。', '2018-09-11 23:19:24', '15834518689');
INSERT INTO `tb_cdetails` VALUES (130, 132, '视频为啥不能播放啊，买了能看吗', '2018-09-11 23:19:34', '15834518689');
INSERT INTO `tb_cdetails` VALUES (131, 132, '跪求山阴路的夏天', '2018-09-11 23:19:42', '15834518689');
INSERT INTO `tb_cdetails` VALUES (132, 132, '这首歌没什么技巧， 最多的难点也是和弦按法。完全没必要出教学。 觉得难的同学认真把这几个和弦转换练会了， 这首歌便不攻自破了。', '2018-09-11 23:19:57', '15834518689');
INSERT INTO `tb_cdetails` VALUES (133, 132, '虽然结尾戛然而止，估计是不好跟前面的扫弦匹配吧，没有前面的扫弦又会少了很多感染力，老师也算是折中一下吧', '2018-09-11 23:20:16', '15834518689');
INSERT INTO `tb_cdetails` VALUES (134, 132, '跨度好大。。。弄不来', '2018-09-11 23:20:28', '15834518689');
INSERT INTO `tb_cdetails` VALUES (135, 141, '听一遍就知道一定要学了，什么时候出教程啊！ 每次前奏间奏都要摸索好久', '2018-09-11 23:23:00', '15834518689');
INSERT INTO `tb_cdetails` VALUES (136, 141, '辛苦了老师了。练曲子', '2018-09-11 23:23:18', '15834518689');
INSERT INTO `tb_cdetails` VALUES (137, 141, '谱子终于来了 练琴练琴', '2018-09-11 23:23:31', '15834518689');
INSERT INTO `tb_cdetails` VALUES (138, 141, '老师辛苦了 只希望更换谱的时间不需要太长', '2018-09-11 23:23:42', '15834518689');
INSERT INTO `tb_cdetails` VALUES (139, 145, '说真的 我想求一首80还有后', '2018-09-12 18:28:48', '456789');
INSERT INTO `tb_cdetails` VALUES (140, 145, '那歌好听但是不好唱，我自己扒了原版的，我的天，公公呛都吼出来了。还跑调。。放弃了，都多年过去了。现在还有人要。。。。呵呵，你要是能唱了我教你', '2018-09-12 18:29:16', '456789');
INSERT INTO `tb_cdetails` VALUES (141, 145, '非常感谢老师的辛苦制作。', '2018-09-12 18:29:36', '456789');
INSERT INTO `tb_cdetails` VALUES (142, 148, '中了抖音的毒了', '2018-09-12 22:59:14', '165');
INSERT INTO `tb_cdetails` VALUES (143, 148, '出一首李荣浩的新歌《年少有为》吧，巨好听', '2018-09-12 22:59:29', '165');
INSERT INTO `tb_cdetails` VALUES (144, 148, '求谱啊老师', '2018-09-12 22:59:55', '165');
INSERT INTO `tb_cdetails` VALUES (145, 151, '老师求出薛之谦的《哑巴》', '2018-09-12 23:01:19', '165');
INSERT INTO `tb_cdetails` VALUES (146, 151, '最近抖音上很火的，猫的房东的<云烟成雨》求出', '2018-09-12 23:01:32', '165');
INSERT INTO `tb_cdetails` VALUES (147, 151, '小丽唱得就是好！百听不厌！', '2018-09-12 23:01:46', '165');
INSERT INTO `tb_cdetails` VALUES (148, 151, '我不要五颜六色的小丽，我要最初小丽的样子。', '2018-09-12 23:01:58', '165');
INSERT INTO `tb_cdetails` VALUES (149, 155, '老师，吉他谱跟歌词有点对不上，歌词比谱子慢了一小节，希望尽快处理一下喔', '2018-09-12 23:06:52', '1647944662');
INSERT INTO `tb_cdetails` VALUES (150, 156, '鼓的伴奏能不能给一个啊', '2018-09-12 23:18:07', '88888888');
INSERT INTO `tb_cdetails` VALUES (151, 156, '编得非常的好。', '2018-09-12 23:18:24', '88888888');
INSERT INTO `tb_cdetails` VALUES (152, 158, '我真是不知道怎么说了，好多朋友求英文歌，尤其是断眉的歌，我真的很怀疑你们能唱吗？这种R&B唱时都是飘着的感觉，很不好唱的。', '2018-09-12 23:20:04', '88888888');
INSERT INTO `tb_cdetails` VALUES (153, 158, '好听，就练这个了', '2018-09-12 23:20:16', '88888888');
INSERT INTO `tb_cdetails` VALUES (154, 158, '呵呵，听着是不是很好听？蓝调能不好听吗？但是我告诉和弦难的一笔。弹起来几乎不能再分心唱，玩毛', '2018-09-12 23:20:31', '88888888');
INSERT INTO `tb_cdetails` VALUES (155, 161, '老师能做一下陈鸿宇新版行歌的谱子吗万分感谢!!', '2018-09-12 23:26:39', '462879');
INSERT INTO `tb_cdetails` VALUES (156, 161, '老师，Bm和弦第一遍与第二遍右手不一样，望改正', '2018-09-12 23:26:51', '462879');
INSERT INTO `tb_cdetails` VALUES (157, 163, '666', '2018-09-12 23:34:19', '462879');
INSERT INTO `tb_cdetails` VALUES (158, 163, '很棒', '2018-09-12 23:34:28', '462879');
INSERT INTO `tb_cdetails` VALUES (159, 163, '期待了好久的说', '2018-09-12 23:34:42', '462879');
INSERT INTO `tb_cdetails` VALUES (160, 166, '说真的 我想求一首80还有后', '2018-09-12 23:44:14', '165');
INSERT INTO `tb_cdetails` VALUES (161, 166, '非常感谢老师的辛苦制作。', '2018-09-12 23:44:19', '165');
INSERT INTO `tb_cdetails` VALUES (162, 168, '那歌好听但是不好唱，我自己扒了原版的，我的天，公公呛都吼出来了。还跑调。。放弃了，都多年过去了。现在还有人要。。。。呵呵，你要是能唱了我教你', '2018-09-12 23:46:27', '165');
INSERT INTO `tb_cdetails` VALUES (163, 169, '非常感谢老师的辛苦制作。', '2018-09-12 23:48:10', '165');
INSERT INTO `tb_cdetails` VALUES (164, 169, '666', '2018-09-12 23:48:15', '165');
INSERT INTO `tb_cdetails` VALUES (165, 169, '好极了', '2018-09-12 23:48:21', '165');
INSERT INTO `tb_cdetails` VALUES (166, 172, '好极了', '2018-09-12 23:51:58', '165');
INSERT INTO `tb_cdetails` VALUES (167, 172, '说真的 我想求一首80还有后', '2018-09-12 23:52:03', '165');
INSERT INTO `tb_cdetails` VALUES (168, 174, '下 下下上 下 下下上', '2018-09-12 23:55:51', '17393163600');
INSERT INTO `tb_cdetails` VALUES (169, 174, '第二小节 6弦弹的是3品，谱子上怎么是1品啊，后面歌词 总是被感动，被 这个字忘记打了啊 还有个副歌第一次唱的 是冬雪是你 里面打成风雪是你了啊。', '2018-09-12 23:56:04', '17393163600');
INSERT INTO `tb_cdetails` VALUES (170, 174, '，看的不是太懂，谁能说一下，谢谢了', '2018-09-12 23:56:14', '17393163600');
INSERT INTO `tb_cdetails` VALUES (171, 177, '1.希望谱子排版能尽量紧凑一些，其实内容并不多如果能在两页做完的话，看着谱子完全就可以弹唱，不需要翻页了。', '2018-09-13 00:01:12', '17393163600');
INSERT INTO `tb_cdetails` VALUES (172, 177, '说真的 我想求一首80还有后', '2018-09-13 00:01:15', '17393163600');
INSERT INTO `tb_cdetails` VALUES (173, 177, '好极了', '2018-09-13 00:01:20', '17393163600');
INSERT INTO `tb_cdetails` VALUES (174, 180, '跪求山阴路的夏天', '2018-09-13 00:01:45', '17393163600');
INSERT INTO `tb_cdetails` VALUES (175, 180, '跨度好大。。。弄不来', '2018-09-13 00:02:08', '17393163600');
INSERT INTO `tb_cdetails` VALUES (176, 180, '我只是进来表白shawn老师的，希望老师出视频教唱歌啊', '2018-09-13 00:02:28', '17393163600');

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment`  (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `user_id` int(100) DEFAULT NULL,
  `opus_id` int(100) DEFAULT NULL,
  `topus_id` int(100) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `opus_id`(`opus_id`) USING BTREE,
  INDEX `topus_id`(`topus_id`) USING BTREE,
  CONSTRAINT `tb_comment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tb_comment_ibfk_2` FOREIGN KEY (`opus_id`) REFERENCES `tb_opus` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tb_comment_ibfk_3` FOREIGN KEY (`topus_id`) REFERENCES `tb_to` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 183 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_comment
-- ----------------------------
INSERT INTO `tb_comment` VALUES (92, 11, NULL, 16);
INSERT INTO `tb_comment` VALUES (93, 11, NULL, 16);
INSERT INTO `tb_comment` VALUES (94, 11, NULL, 16);
INSERT INTO `tb_comment` VALUES (95, 11, NULL, 16);
INSERT INTO `tb_comment` VALUES (96, 11, NULL, 16);
INSERT INTO `tb_comment` VALUES (97, 11, NULL, 16);
INSERT INTO `tb_comment` VALUES (98, 11, NULL, 16);
INSERT INTO `tb_comment` VALUES (99, 11, NULL, 16);
INSERT INTO `tb_comment` VALUES (100, 11, NULL, 15);
INSERT INTO `tb_comment` VALUES (101, 11, NULL, 15);
INSERT INTO `tb_comment` VALUES (102, 11, NULL, 15);
INSERT INTO `tb_comment` VALUES (103, 11, NULL, 15);
INSERT INTO `tb_comment` VALUES (104, 11, NULL, 15);
INSERT INTO `tb_comment` VALUES (105, 11, NULL, 17);
INSERT INTO `tb_comment` VALUES (106, 11, NULL, 17);
INSERT INTO `tb_comment` VALUES (107, 11, NULL, 17);
INSERT INTO `tb_comment` VALUES (108, 11, NULL, 17);
INSERT INTO `tb_comment` VALUES (109, 11, NULL, 17);
INSERT INTO `tb_comment` VALUES (110, 11, NULL, 17);
INSERT INTO `tb_comment` VALUES (111, 11, NULL, 18);
INSERT INTO `tb_comment` VALUES (112, 11, NULL, 18);
INSERT INTO `tb_comment` VALUES (113, 11, NULL, 18);
INSERT INTO `tb_comment` VALUES (114, 11, NULL, 18);
INSERT INTO `tb_comment` VALUES (115, 11, NULL, 19);
INSERT INTO `tb_comment` VALUES (116, 11, NULL, 19);
INSERT INTO `tb_comment` VALUES (117, 11, NULL, 19);
INSERT INTO `tb_comment` VALUES (118, 11, NULL, 20);
INSERT INTO `tb_comment` VALUES (119, 11, NULL, 20);
INSERT INTO `tb_comment` VALUES (120, 11, NULL, 20);
INSERT INTO `tb_comment` VALUES (121, 11, NULL, 20);
INSERT INTO `tb_comment` VALUES (122, 11, NULL, 20);
INSERT INTO `tb_comment` VALUES (123, 11, NULL, 20);
INSERT INTO `tb_comment` VALUES (124, 11, NULL, 20);
INSERT INTO `tb_comment` VALUES (125, 11, NULL, 21);
INSERT INTO `tb_comment` VALUES (126, 11, NULL, 21);
INSERT INTO `tb_comment` VALUES (127, 12, NULL, 24);
INSERT INTO `tb_comment` VALUES (128, 12, NULL, 24);
INSERT INTO `tb_comment` VALUES (129, 12, NULL, 24);
INSERT INTO `tb_comment` VALUES (130, 12, NULL, 24);
INSERT INTO `tb_comment` VALUES (131, 12, NULL, 24);
INSERT INTO `tb_comment` VALUES (132, 12, NULL, 25);
INSERT INTO `tb_comment` VALUES (133, 12, NULL, 25);
INSERT INTO `tb_comment` VALUES (134, 12, NULL, 25);
INSERT INTO `tb_comment` VALUES (135, 12, NULL, 25);
INSERT INTO `tb_comment` VALUES (136, 12, NULL, 25);
INSERT INTO `tb_comment` VALUES (137, 12, NULL, 25);
INSERT INTO `tb_comment` VALUES (138, 12, NULL, 25);
INSERT INTO `tb_comment` VALUES (139, 12, NULL, 25);
INSERT INTO `tb_comment` VALUES (140, 12, NULL, 25);
INSERT INTO `tb_comment` VALUES (141, 12, NULL, 26);
INSERT INTO `tb_comment` VALUES (142, 12, NULL, 26);
INSERT INTO `tb_comment` VALUES (143, 12, NULL, 26);
INSERT INTO `tb_comment` VALUES (144, 12, NULL, 26);
INSERT INTO `tb_comment` VALUES (145, 18, 2, NULL);
INSERT INTO `tb_comment` VALUES (146, 18, 2, NULL);
INSERT INTO `tb_comment` VALUES (147, 18, 2, NULL);
INSERT INTO `tb_comment` VALUES (148, 19, 3, NULL);
INSERT INTO `tb_comment` VALUES (149, 19, 3, NULL);
INSERT INTO `tb_comment` VALUES (150, 19, 3, NULL);
INSERT INTO `tb_comment` VALUES (151, 19, 4, NULL);
INSERT INTO `tb_comment` VALUES (152, 19, 4, NULL);
INSERT INTO `tb_comment` VALUES (153, 19, 4, NULL);
INSERT INTO `tb_comment` VALUES (154, 19, 4, NULL);
INSERT INTO `tb_comment` VALUES (155, 10, 5, NULL);
INSERT INTO `tb_comment` VALUES (156, 11, 6, NULL);
INSERT INTO `tb_comment` VALUES (157, 11, 6, NULL);
INSERT INTO `tb_comment` VALUES (158, 11, 7, NULL);
INSERT INTO `tb_comment` VALUES (159, 11, 7, NULL);
INSERT INTO `tb_comment` VALUES (160, 11, 7, NULL);
INSERT INTO `tb_comment` VALUES (161, 16, 8, NULL);
INSERT INTO `tb_comment` VALUES (162, 16, 8, NULL);
INSERT INTO `tb_comment` VALUES (163, 16, 9, NULL);
INSERT INTO `tb_comment` VALUES (164, 16, 9, NULL);
INSERT INTO `tb_comment` VALUES (165, 16, 9, NULL);
INSERT INTO `tb_comment` VALUES (166, 19, 10, NULL);
INSERT INTO `tb_comment` VALUES (167, 19, 10, NULL);
INSERT INTO `tb_comment` VALUES (168, 19, 11, NULL);
INSERT INTO `tb_comment` VALUES (169, 19, 12, NULL);
INSERT INTO `tb_comment` VALUES (170, 19, 12, NULL);
INSERT INTO `tb_comment` VALUES (171, 19, 12, NULL);
INSERT INTO `tb_comment` VALUES (172, 19, 13, NULL);
INSERT INTO `tb_comment` VALUES (173, 19, 13, NULL);
INSERT INTO `tb_comment` VALUES (174, 13, 14, NULL);
INSERT INTO `tb_comment` VALUES (175, 13, 14, NULL);
INSERT INTO `tb_comment` VALUES (176, 13, 14, NULL);
INSERT INTO `tb_comment` VALUES (177, 13, 15, NULL);
INSERT INTO `tb_comment` VALUES (178, 13, 15, NULL);
INSERT INTO `tb_comment` VALUES (179, 13, 15, NULL);
INSERT INTO `tb_comment` VALUES (180, 13, 16, NULL);
INSERT INTO `tb_comment` VALUES (181, 13, 16, NULL);
INSERT INTO `tb_comment` VALUES (182, 13, 16, NULL);

-- ----------------------------
-- Table structure for tb_opus
-- ----------------------------
DROP TABLE IF EXISTS `tb_opus`;
CREATE TABLE `tb_opus`  (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '��Ʒ����',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '��Ʒ���',
  `video` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '��Ƶ��ַ',
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '��Ʒ����',
  `qupustate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '����״̬',
  `singer` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'ԭ������',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_opus
-- ----------------------------
INSERT INTO `tb_opus` VALUES (2, '空空如也', '快乐风男', 'upload/opus/opus/imgs/renran_kongkongruye_guitar.jpg', 'http://player.youku.com/embed/XMzQ3NDcxNzExMg==', '任然/胡66', '', '吉他弹唱');
INSERT INTO `tb_opus` VALUES (3, '陷阱', '快乐风男', 'upload/opus/opus/imgs/wangbeiche_xianjing_guitar.jpg', 'http://player.youku.com/embed/XMzc1NTA2ODQ4NA==', '王北车', '', '民谣');
INSERT INTO `tb_opus` VALUES (4, '红昭愿', '毛阿敏', 'upload/opus/opus/imgs/yinqueshiting_hongzhaoyuan_guitar.jpg', 'http://player.youku.com/embed/XMzUzNDUzMTAwNA==', '梨花', '', '民谣');
INSERT INTO `tb_opus` VALUES (5, '体面', '花前月下', 'upload/opus/opus/imgs/yuwenwen_timian_guitar.jpg', 'http://player.youku.com/embed/XMzM0MzA5NTgwOA==', '于文文', '', '流行');
INSERT INTO `tb_opus` VALUES (6, 'ThatGuil', '钻石王老五', 'upload/opus/opus/imgs/Olly-Murs_thay-girl_guitar.jpg', 'http://player.youku.com/embed/XMzcxMDA5NjA0NA==', 'Only_murs', '', '流行');
INSERT INTO `tb_opus` VALUES (7, '可能否', '钻石王老五', 'upload/opus/opus/imgs/muxiaoya_kenengfou_guitar.jpg', 'http://player.youku.com/embed/XMzY5Mjk2NDQyOA==', '沐小雅', '', '流行');
INSERT INTO `tb_opus` VALUES (8, '理想三旬', '木兮', 'upload/opus/opus/imgs/chenhongyu_lixiangsanxun_guitar.jpg', 'http://player.youku.com/embed/XMTU2MTA2MTAzMg==', '陈鸿宇', '', '民谣');
INSERT INTO `tb_opus` VALUES (9, '起风了', '木兮', 'upload/opus/opus/imgs/mailajiaoyeyongjuan_qifengle_guitar.jpg', 'http://player.youku.com/embed/XMzU5NTg4ODYxMg==', '大伟', '', '民谣');
INSERT INTO `tb_opus` VALUES (10, '另一个自己', '音狂', 'upload/opus/opus/imgs/lingyigeziji.jpg', 'http://player.youku.com/embed/XMzQ3NDcxNzExMg==', '何炅', '', '流行');
INSERT INTO `tb_opus` VALUES (11, '别', '音狂', 'upload/opus/opus/imgs/bie.jpg', 'http://player.youku.com/embed/XMzc1NTA2ODQ4NA==', '任然', '', '吉他弹唱');
INSERT INTO `tb_opus` VALUES (12, '记忆中的我', '音狂', 'upload/opus/opus/imgs/jiyizhongdewo.jpg', 'http://player.youku.com/embed/XMzQ3NDcxNzExMg==', '马飞', '', '民谣');
INSERT INTO `tb_opus` VALUES (13, '冷风里', '音狂', 'upload/opus/opus/imgs/lengfengli.jpg', 'http://player.youku.com/embed/XMzc1NTA2ODQ4NA==', '谢霆锋', '', '流行');
INSERT INTO `tb_opus` VALUES (14, '往后余生', '流苏', 'upload/opus/opus/imgs/maliang_wanghouyusheng_guitar.jpg', 'http://player.youku.com/embed/XMzYzNTc3NjA5Ng==', '马良', '', '流行');
INSERT INTO `tb_opus` VALUES (15, '我不是药神', '流苏', 'upload/opus/opus/imgs/zhangjiezhangbichen_zhiyaopingfan_guitar1.jpg', 'http://player.youku.com/embed/XMzcyMzIwODcwMA==', '张杰/张碧晨', '', '流行');
INSERT INTO `tb_opus` VALUES (16, '消愁', '流苏', 'upload/opus/opus/imgs/maobuyi_xiaochou_guitar.jpg', 'http://player.youku.com/embed/XMjk3MDU2MzU0MA==', '毛不易', '', '流行');

-- ----------------------------
-- Table structure for tb_qupu
-- ----------------------------
DROP TABLE IF EXISTS `tb_qupu`;
CREATE TABLE `tb_qupu`  (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `to_id` int(100) DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `opusid`(`to_id`) USING BTREE,
  CONSTRAINT `opusid` FOREIGN KEY (`to_id`) REFERENCES `tb_to` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 60 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_qupu
-- ----------------------------
INSERT INTO `tb_qupu` VALUES (27, 15, 'upload/teacher/tab_chenhongyu_lixiangsanxun_1.gif');
INSERT INTO `tb_qupu` VALUES (28, 15, 'upload/teacher/tab_chenhongyu_lixiangsanxun_2.gif');
INSERT INTO `tb_qupu` VALUES (29, 16, 'upload/teacher/tab_muxiaoya_kenengfou_1.gif');
INSERT INTO `tb_qupu` VALUES (30, 16, 'upload/teacher/tab_muxiaoya_kenengfou_2.gif');
INSERT INTO `tb_qupu` VALUES (31, 16, 'upload/teacher/tab_muxiaoya_kenengfou_3.gif');
INSERT INTO `tb_qupu` VALUES (32, 16, 'upload/teacher/tab_muxiaoya_kenengfou_4.gif');
INSERT INTO `tb_qupu` VALUES (33, 17, 'upload/teacher/tab_renran_kongkongruye_1.gif');
INSERT INTO `tb_qupu` VALUES (34, 17, 'upload/teacher/tab_renran_kongkongruye_2.gif');
INSERT INTO `tb_qupu` VALUES (35, 17, 'upload/teacher/tab_renran_kongkongruye_3.gif');
INSERT INTO `tb_qupu` VALUES (36, 17, 'upload/teacher/tab_renran_kongkongruye_4.gif');
INSERT INTO `tb_qupu` VALUES (37, 18, 'upload/teacher/tab_yinqueshiting_hongzhaoyuan_1.gif');
INSERT INTO `tb_qupu` VALUES (38, 18, 'upload/teacher/tab_yinqueshiting_hongzhaoyuan_2.gif');
INSERT INTO `tb_qupu` VALUES (39, 19, 'upload/teacher/tab_mailajiaoyeyongquan_qifengle_1.gif');
INSERT INTO `tb_qupu` VALUES (40, 19, 'upload/teacher/tab_mailajiaoyeyongquan_qifengle_2.gif');
INSERT INTO `tb_qupu` VALUES (41, 19, 'upload/teacher/tab_mailajiaoyeyongquan_qifengle_3.gif');
INSERT INTO `tb_qupu` VALUES (42, 19, 'upload/teacher/tab_mailajiaoyeyongquan_qifengle_4.gif');
INSERT INTO `tb_qupu` VALUES (43, 19, 'upload/teacher/tab_mailajiaoyeyongquan_qifengle_5.gif');
INSERT INTO `tb_qupu` VALUES (44, 20, 'upload/teacher/fufei_Olly-Murs_That-girl_guitar.gif');
INSERT INTO `tb_qupu` VALUES (46, 21, 'upload/teacher/fufei_yuwenwen_timian_nvshengban_guitar.gif');
INSERT INTO `tb_qupu` VALUES (47, 22, 'upload/teacher/tab_maliang_wanghouyusheng_1.gif');
INSERT INTO `tb_qupu` VALUES (48, 22, 'upload/teacher/tab_maliang_wanghouyusheng_2.gif');
INSERT INTO `tb_qupu` VALUES (49, 22, 'upload/teacher/tab_maliang_wanghouyusheng_3.gif');
INSERT INTO `tb_qupu` VALUES (50, 23, 'upload/teacher/fufei_zhangjiezhangbichen_zhiyaopingfan.gif');
INSERT INTO `tb_qupu` VALUES (51, 24, 'upload/teacher/tab_wangbeiche_xianjing_1.gif');
INSERT INTO `tb_qupu` VALUES (52, 24, 'upload/teacher/tab_wangbeiche_xianjing_2.gif');
INSERT INTO `tb_qupu` VALUES (53, 24, 'upload/teacher/tab_wangbeiche_xianjing_3.gif');
INSERT INTO `tb_qupu` VALUES (54, 24, 'upload/teacher/tab_wangbeiche_xianjing_4.gif');
INSERT INTO `tb_qupu` VALUES (55, 25, 'upload/teacher/fufei_maobuyi_xiaochou_guitar.gif');
INSERT INTO `tb_qupu` VALUES (56, 26, 'upload/teacher/tab_fangdongdemao_yunyanchengyu_1.gif');
INSERT INTO `tb_qupu` VALUES (57, 26, 'upload/teacher/tab_fangdongdemao_yunyanchengyu_2.gif');
INSERT INTO `tb_qupu` VALUES (58, 26, 'upload/teacher/tab_fangdongdemao_yunyanchengyu_3.gif');
INSERT INTO `tb_qupu` VALUES (59, 26, 'upload/teacher/tab_fangdongdemao_yunyanchengyu_4.gif');

-- ----------------------------
-- Table structure for tb_teacher
-- ----------------------------
DROP TABLE IF EXISTS `tb_teacher`;
CREATE TABLE `tb_teacher`  (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '教师名',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '教师头像',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_teacher
-- ----------------------------
INSERT INTO `tb_teacher` VALUES (1, '周杰伦', 'upload/user/touxiang22.jpg');
INSERT INTO `tb_teacher` VALUES (2, '汪峰', 'upload/user/touxiang24.jpg');
INSERT INTO `tb_teacher` VALUES (3, '大伟', 'upload/user/touxiang18.jpg');
INSERT INTO `tb_teacher` VALUES (4, '张惠妹', 'upload/user/touxiang25.jpg');
INSERT INTO `tb_teacher` VALUES (5, '姚明', 'upload/user/6257d8b8-e5a7-488a-a0ac-44f17c00d42b.jpg');

-- ----------------------------
-- Table structure for tb_to
-- ----------------------------
DROP TABLE IF EXISTS `tb_to`;
CREATE TABLE `tb_to`  (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '教学名称',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '教师名称',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '教学图片',
  `video` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '教学视频',
  `singer` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '原唱歌手',
  `state` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '分类',
  `cnumber` int(50) DEFAULT NULL COMMENT '评论量',
  `lnumber` int(56) DEFAULT NULL COMMENT '收藏量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_to
-- ----------------------------
INSERT INTO `tb_to` VALUES (15, '理想三旬', '郭瑞新', 'upload/opus/to/imgs/chenhongyu_lixiangsanxun_guitar.jpg', 'http://player.youku.com/embed/XMTU2MTA2MTAzMg?_time=0', '陈宏宇', '民谣', 0, 0);
INSERT INTO `tb_to` VALUES (16, '《可能否》吉他弹唱', '郭瑞新', 'upload/opus/to/imgs/muxiaoya_kenengfou_guitar.jpg', 'http://player.youku.com/embed/XMzY5Mjk2NDQyOA==', '木小雅', '民谣', 0, 0);
INSERT INTO `tb_to` VALUES (17, '《空空如也》男声版 吉他弹唱', '郭瑞新', 'upload/opus/to/imgs/renran_kongkongruye_guitar.jpg', 'http://player.youku.com/embed/XMzQ3NDcxNzExMg==', '任然/胡66', '流行', 0, 0);
INSERT INTO `tb_to` VALUES (18, '红昭愿', '郭瑞新', 'upload/opus/to/imgs/yinqueshiting_hongzhaoyuan_guitar.jpg', 'http://player.youku.com/embed/XMzUzNDUzMTAwNA==', '音阙诗听', '流行', 0, 0);
INSERT INTO `tb_to` VALUES (19, '起风了', '潘勤强', 'upload/opus/to/imgs/mailajiaoyeyongjuan_qifengle_guitar.jpg', 'http://player.youku.com/embed/XMzU5NTg4ODYxMg==', '买辣椒也用券', '民谣', 0, 0);
INSERT INTO `tb_to` VALUES (20, 'ThatGril', '潘勤强', 'upload/opus/to/imgs/Olly-Murs_thay-girl_guitar.jpg', 'http://player.youku.com/embed/XMzcxMDA5NjA0NA==', 'olly murs', '流行', 0, 0);
INSERT INTO `tb_to` VALUES (21, '《前任3:再见前任》插曲《体面》', '郭瑞新', 'upload/opus/to/imgs/yuwenwen_timian_guitar.jpg', 'http://player.youku.com/embed/XMzM0MzA5NTgwOA==', '于文文', '流行', 0, 0);
INSERT INTO `tb_to` VALUES (22, '《往后余生》吉他弹唱', '郭瑞新', 'upload/opus/to/imgs/maliang_wanghouyusheng_guitar.jpg', 'http://player.youku.com/embed/XMzYzNTc3NjA5Ng==', '马良', '民谣', 0, 0);
INSERT INTO `tb_to` VALUES (23, '《我不是药神》', '李跃捷', 'upload/opus/to/imgs/zhangjiezhangbichen_zhiyaopingfan_guitar1.jpg', 'http://player.youku.com/embed/XMzcyMzIwODcwMA==', '张杰/张碧晨', '流行', 0, 0);
INSERT INTO `tb_to` VALUES (24, ' 陷阱', '李跃捷', 'upload/opus/to/imgs/wangbeiche_xianjing_guitar.jpg', 'http://player.youku.com/embed/XMzc1NTA2ODQ4NA==', '王北车', '民谣', 0, 0);
INSERT INTO `tb_to` VALUES (25, '消愁', '郭瑞新', 'upload/opus/to/imgs/maobuyi_xiaochou_guitar.jpg', 'http://player.youku.com/embed/XMjk3MDU2MzU0MA==', '毛不易', '民谣', 0, 0);
INSERT INTO `tb_to` VALUES (26, '云烟成雨', '潘勤强', 'upload/opus/to/imgs/fangdongdemao_yunyanchengyu_guitar.jpg', 'http://player.youku.com/embed/XMzY3NjY1NTUyMA==', '房东的猫', '民谣', 0, 0);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '�˺���',
  `nickname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '�ǳ�',
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '����',
  `age` int(30) DEFAULT NULL COMMENT '����',
  `gender` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '�Ա�',
  `mail` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '����',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'ͷ��',
  `intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '���',
  `addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '��ַ',
  `weibo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '΢��',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (10, '1647944662', '灵动的吉他手', '999', 18, '不知', '1647944662@qq.com', 'upload/user/touxiang08.jpg', '大爷钱多', '东莞', '无');
INSERT INTO `tb_user` VALUES (11, '88888888', '小钻风', '999', 48, '男', 'bennyrhys@163.com', 'upload/user/touxiang36.jpg', '“瘾君子”', '西北师大——兰天公寓2#731', '没有');
INSERT INTO `tb_user` VALUES (12, '6987', 'Bennyrhys', 'Guoruixin.0719', 20, '男', 'bennyrhys@163.com', 'upload/user/LOGO.png', '我不是归人，睹梦游天的“瘾君子”', '西北师大——兰天公寓2#731', '没有');
INSERT INTO `tb_user` VALUES (13, '17393163600', '流苏', '17393163600', 17, '女', '17393163600@qq.com', 'upload/user/t0113e2db51d4c6fd6b.jpg', '长得美', '兰天公寓', '没有');
INSERT INTO `tb_user` VALUES (16, '462879', '木兮', '462879', 45, '男', '15834518689@qq.com', 'upload/user/bki-20130522121229-2745238.jpg', '长得帅', '兰天公寓', '没有');
INSERT INTO `tb_user` VALUES (17, '15834518687', '灵儿', '15834518687', 18, '女', '15834518687@163.com', 'upload/user/B78109694.jpg', '长得美', '兰天公寓', '没有');
INSERT INTO `tb_user` VALUES (18, '456789', '快乐风男', '1230', 19, '男', '9687@163.com', 'upload/user/touxiang09.jpg', '只要e的够快，队友的问号就点不到自己', '水挂庄', '无');
INSERT INTO `tb_user` VALUES (19, '165', '音狂', '444', 64, '不知', '1647944662@qq.com', 'upload/user/708116649.jpg', '人生如戏', '蓝天公寓', '无');

SET FOREIGN_KEY_CHECKS = 1;
