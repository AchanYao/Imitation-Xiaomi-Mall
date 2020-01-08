# 仿小米商城

## 环境安装

[nodejs](https://nodejs.org/zh-cn/)

[maven](https://maven.apache.org/install.html)

[JDK11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)

## 运行

```bash
mvn clean install -DskipTests

cd admin

mvn spring-boot:run

cd ../web

mvn spring-boot:run

cd ../xiaomi-store-admin-vue

npm install

npm run serve

cd ../xiaomi-store-vue

npm install

npm run serve
```

**注意**：运行前请更改数据库相关属性文件

## 实训日志

### 19/12/30 数据库设计

根据项目需求，该项目相关实体有：用户（普通用户`user`与管理员`admin`），商品`item`，订单`order`，购物车`shopping_cart`，用户详细信息`user_detail`（包括地址`address`）,商品类型`item_type`；
如下表：  

实体名称 | 数据库表
---- | ---
普通用户 | user
管理员 |  admin
商品 | item
订单 | order
购物车 | shopping_cart
用户详细信息 | user_detail
地址 | address
商品类型 | item_type

实体之间的关联关系如下：

- `user` `user_detail` OneToOne
- `user` `shopping_cart` OneToOne
- `user` `order` OneToMany
- `item` `shopping_cart` ManyToOne
- `item` `order` ManyToOne
- `address` `user_detail` ManyToOne
- `address` `order` OneToOne
- `item` `item_type` OneToOne

所以数据库设计为：
![数据库设计](https://i.loli.net/2020/01/05/Fpflbn5rJtvVRwy.png)

### 19/12/31 项目设计

#### 模块

自顶向下分析，顶层模块有用户系统，管理员系统，向下有服务层，数据库读写dao层，Java实体model层，各层次依赖关系为，admin和web依赖service，service依赖dao，dao依赖model，它们都是xiaomi_store的子项目。

#### Java实体关系设计

model层uml类图如下：

![model层uml类图](https://i.loli.net/2020/01/06/Ckmg7Uq6Zox2a8H.png)

各实体间没有关系，但都继承自一个基类，基类存放实体创建时间，修改时间等信息。

### 20/1/2 用户系统实现

#### jpa与mybatis选择

Hibernate是一个ORM框架，而JPA则是一种ORM规范，JPA和Hibernate的关系就像JDBC与JDBC驱动的关系，即JPA制定了ORM 规范，而Hibernate是这些规范的实现（事实上，是先有Hibernate 后有JPA，JPA规范的起草者也是Hibernate 的作者），因此从功能上来说，JPA相当于Hibernate 的一个子集。

jpa使用方便，不需要开发者编写sql代码，通过实体之间的关系自动创建或修改数据库；MyBatis支持定制化SQL、存储过程以及高级映射。MyBatis几乎避免了所有的JDBC代码手动设置参数以及获取结果集。

mybatis灵活，jpa简单，我认为，mybatis更适合长期维护的项目，jpa更适合短期快速开发上线项目。jpa与mybatis都是通过interface来映射Java方法进行数据库操作，可以使用mybatis对jpa接口进行继承重写，迁移也比较方便。所以该实训项目选择jpa。

#### 模型层设计

使用jpa或是mybatis提供的逆向工程并不包含依赖关系，所以我将各实体模型中加入了相应映射对象，来实现数据库映射读写懒加载，拿商品举例，商品代码如下。

```java
/**
 * 商品实体
 */
@Entity
@Table(name = "items")
@Data
@Accessors(chain = true)
public class ItemEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // 商品描述
    @Column(nullable = false, length = 500)
    @NotNull
    @NotBlank
    private String description;
    // 商品价格
    @Column(nullable = false, length = 10)
    private double price;
    // 商品数量
    @Column(nullable = false, length = 10)
    private int stockQuantity;
    // 商品图片
    @Column(nullable = false, length = 150)
    @NotBlank
    @NotNull
    private String picUrl;
    @Column(nullable = false, length = 50)
    @NotBlank
    @NotNull
    private String productName;
    @Column(nullable = false, length = 11)
    private int typeId;
    @Transient
    private ItemTypeEntity itemTypeEntity;
}
```

商品中包含一个商品类型的属性`ItemTypeEntity`，通过`@Transient`注解来使得该属性不参与数据库的读写。

用户角色认证，使用spring-security框架，进行角色假认证，在从数据库读取用户时，直接设置用户权限为user，因为普通用户角色与管理员用户角色基本上不用互通，而商品的查询不需要进行认证，游客也可进行访问。

### 20/1/3 用户客户端实现

客户端采用vue框架，实现商品的查找，购物车的显示，商品加入购物车等操作。

商城主页
![商城主页面](https://i.loli.net/2020/01/06/WLQCaYhw5eIK3SG.png)
商品信息
![商品信息页面](https://i.loli.net/2020/01/06/KSeJtQpERi3HsyG.png)
购物车
![购物车页面](https://i.loli.net/2020/01/06/hdlUtxENCYq1MjZ.png)

### 20/1/4 管理员系统实现

管理员系统中需要新增功能：对用户的禁用与启用，商品的修改和增加。

1. 新建admin实体类
2. 新建AdminRepository接口
3. 新建使用AdminService进行登录的验证
4. 在Controller中增加几个Controller用于管理员的相关操作

### 20/1/5 管理员客户端实现

同样使用vue框架，效果图如下：

面板
![批注 2020-01-06 142921.png](https://i.loli.net/2020/01/06/B1iRWgNFAJ8wCfT.png)
所有用户
![批注 2020-01-06 143021.png](https://i.loli.net/2020/01/06/xm5J3wbgiRBXUYZ.png)
所有商品
![批注 2020-01-06 144248.png](https://i.loli.net/2020/01/06/WCnRY5tEILgSFs2.png)
商品修改
![批注 2020-01-06 144333.png](https://i.loli.net/2020/01/06/fSkM8iPpuDthKe7.png)

### 20/1/6 spring-security鉴权优化

将spring-security功能分别从admin与web模块中提取出来整合到一个新的模块中，修改原实体类中的假认证（用户角色直接指定），转变成从数据库中读取。修改后的Security配置如下：

```java
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/api/order/**", "/api/cart/**").hasRole(UserRole.USER.name)
                .antMatchers("/api/admin/**").hasRole(UserRole.ADMIN.name)
                .antMatchers("/api/user/**").authenticated()
                .and()
                .formLogin().loginProcessingUrl("/api/login").loginPage("/loginPage")
                .usernameParameter("username").passwordParameter("password")
                .successHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    Object principal = authentication.getPrincipal();
                    httpServletResponse.setContentType("application/json;charset=utf-8");
                    PrintWriter writer = httpServletResponse.getWriter();
                    httpServletResponse.setStatus(200);
                    Map<String, Object> map = new HashMap<>(2);
                    map.put("status", 200);
                    map.put("msg", principal);
                    ObjectMapper objectMapper = new ObjectMapper();
                    writer.write(objectMapper.writeValueAsString(map));
                    writer.flush();
                    writer.close();
                })
                .failureHandler((httpServletRequest, httpServletResponse, e) -> {
                    httpServletResponse.setContentType("application/json;charset=utf-8");
                    PrintWriter writer = httpServletResponse.getWriter();
                    httpServletResponse.setStatus(401);
                    Map<String, Object> map = new HashMap<>(2);
                    map.put("status", 401);
                    if (e instanceof LockedException) {
                        map.put("msg", "账户被锁定，登录失败");
                    } else if (e instanceof BadCredentialsException) {
                        map.put("msg", "用户名或密码错误");
                    } else if (e instanceof DisabledException) {
                        map.put("msg", "账户被禁用，登录失败");
                    } else if (e instanceof AccountExpiredException) {
                        map.put("msg", "账户过期，登录失败");
                    } else if (e instanceof CredentialsExpiredException) {
                        map.put("msg", "密码过期，登录失败");
                    } else {
                        map.put("msg", "登录失败");
                    }
                    ObjectMapper objectMapper = new ObjectMapper();
                    writer.write(objectMapper.writeValueAsString(map));
                    writer.flush();
                    writer.close();
                })
                .permitAll()
                .and()
                .logout().logoutUrl("/api/logout").clearAuthentication(true).invalidateHttpSession(true)
                .addLogoutHandler((httpServletRequest, httpServletResponse, authentication) -> {

                })
                .logoutSuccessHandler((httpServletRequest, httpServletResponse, authentication) -> httpServletResponse.sendRedirect("/"))
                .and().csrf().disable();
    }
```

修改数据库，增加用户角色表与用户、角色中间表。修改后的数据库如下：

![image.png](https://i.loli.net/2020/01/07/M53CvQoS8EZushH.png)

### 20/1/9 辅助功能增加

#### api文档生成

向web和admin模块中添加swagger2依赖，修改controller类，增加相关注解与描述即可生成文档。

#### 应用端点监控

Actuator 是 Spring Boot 提供的对应用系统的自省和监控的集成功能，可以查看应用配置的详细信息，例如自动化配置信息、创建的 Spring beans 以及一些环境属性等。

向web中增加actuator依赖，在浏览器地址栏访问`http://localhost:8080/actuator`即可看到如下信息。

![image.png](https://i.loli.net/2020/01/07/BFomjYUC1vlcDOe.png)

在idea环境下也可以看到如下信息：

![image.png](https://i.loli.net/2020/01/07/BEjyoPbzni1qcKF.png)

#### 20/1/8 利用webpack模拟分布式

前端开发打包工具webpack提供了dev-server功能，可以使前端在开发期间完全独立进行运行，而无需部署。dev-server需配置一套转发规则，将满足条件的请求转发到指定host上，而完全解决请求发送问题。

代理规则详细配置如下：

```json
    devServer: {
        // overlay: { // 让浏览器 overlay 同时显示警告和错误
        //   warnings: true,
        //   errors: true
        // },
        // open: false, // 是否打开浏览器
        // host: "localhost",
        // port: "8080", // 代理断就
        // https: false,
        // hotOnly: false, // 热更新
        proxy: {
            "/api": {
                target:
                    "http://localhost:8080", // 目标代理接口地址
                secure: false,
                changeOrigin: true, // 开启代理，在本地创建一个虚拟服务端
                // ws: true, // 是否启用websockets
                pathRewrite: {
                    "^/api": "/api"
                }
            }
        }
    }
```

以上配置是将以`/api`开头的请求转发到:8080端口上。

我们的项目分为用户使用的前台应用与管理员使用的后台应用，而管理员用户有着比普通用户更高的权限，所以普通用户的一些请求操作管理员也应该是可以完成的，但是如果将这些controller再编写一遍不仅工作量加大，而且没达到代码复用的效果。

利用webpack可以将不同请求转发到不同host上，而不影响用户使用。

### 20/1/10 应用监控信息可视化
