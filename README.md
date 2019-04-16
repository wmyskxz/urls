# 一、需求分析

## 1）什么是短连接？
就是把普通网址，转换成比较短的网址，比如：http://t.cn/RlB2PdD 这种，在微博这些限制字数的应用里，好处不言而喻。短、字符少、美观、便于发布、传播。

## 2）基本要求
1. 输入⻓链，可以生成短链
 2. 访问短链，跳转到⻓链
 3. 支持访问计数
 4. 支持自定义短链，可以指定字符串作为短链的key

## 3）编写代码之前的一些前置问题
**Q1：Demo项目的是实际运行环境？**
A：因为考虑到这是一个Demo项目，所以并不会存在多么巨大的使用和访问量，那么就考虑使用**单机环境**，最多考虑对于最近常使用的一些长链和短链之间的转换加一个缓存

**Q2：长链与短链的对应关系？**
A：从设计上的对应关系上来说，一对一的关系显然是更加倾向于完美的，如果一个长链总能生成一个唯一的短链，而一个短链总能正确的还原成原本正确的长链，这样的对应关系并且能够保存在数据库中，那么显然是完美的。但是查资料（https://www.zhihu.com/question/29270034，@iammutex）发现这样的对应关系理论上不太可行，不太可行的点在于**短地址的变化不太可能涵盖所有可能存在的长链接地址**。并且另一方面是因为：**就算不能是一一对应的关系，即一个长链拥有不同的短链接，在真正访问时，又有什么关系呢？**

**Q3：怎么统计访问数**
A：这里指的应该是短链访问数，可以简单的在数据库增加一个访问数的字段，每一次访问短链则把相应的访问数+1

**Q4：怎么自定义短链？**
A：首先，为了短链格式的统一，肯定不能允许用户自定义任意长度的短链，而是应该允许用户自定义系统默认长度的短链；然后在与长链与短链绑定之前，应该查询数据库or缓存中是否存在用户自定义的短链，如果存在则应该提示用户，不存在则创建。其次，我们可以多增加一个type字段用来标注该条短链是用户自定义的(custom)还是系统自动创建的(system)，这样有利于统计信息。

**Q5：转化原理？**
A：上网查到有两种算法，一种是使用自增id来达到永不重复的目的，但是对于要求统一短链格式的系统来说，需要对自增id进行进一步的处理，并且还不好处理，所以对于我们这样的一个小项目，我们可以直接对原地址进行Md5加密(网上有详细的算法，这里就不细说了)，然后再判断是否碰撞，碰撞则再重新生成就好了..

## 4）需求分析：
1. 查了一些资料，

# 二、原型设计

参考

# 三、数据库设计
根据项目需求，表可以简单的设计成：

```MySQL
CREATE TABLE `tbl_link` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `long_url` varchar(255) NOT NULL COMMENT '长链接url',
  `short_url` varchar(255) NOT NULL COMMENT '短链接url',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `type` varchar(10) NOT NULL DEFAULT 'system' COMMENT '标注创建者,system为系统默认创建,custom为用户自定义',
  `visit_size` int(11) NOT NULL DEFAULT '0' COMMENT '访问量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

根据以往的经验，使用MyBatis的话，可以把`create_time`的默认值设置为`CURRENT_TIMESTAMP`，把`update_time`的默认值设置为`CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP`，这样就可以直接使用MyBatis逆向生成之后的带Selective的方法自动维护这两个字段的值

# 四、后台搭建

