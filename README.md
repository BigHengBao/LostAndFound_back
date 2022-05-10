# LostAndFound_back
移动终端开发实践项目service端


**IDEA+JDK8+MYSQL8**

>
>* 项目介绍：
>本项目为生活中失物招领提供线上平台，将失主寻物与得主招领结合，并由后台服务端进行数据整理和统计。
>* 主要模块：
>注册登录，(寻物或招领)启事发布、查看、取消等，此外启事评论、收藏物品，获取天气和定位，联系发布者，修改个人信息等。
>- 技术栈：Android Framework + SpringBoot + Mybatis + MySQL + Redis
>   * 服务端使用SpringBoot框架整合Mybaits，MySQL等开发实现数据的存储和处理，Redis缓存物品信息。
>   * 移动端基于Android平台开发实现，UI部分XML原生开发，Activity,Service,Content Provider三位一体。
>   * 整合Okhttps框架做网络相关信息交互；整合Gson框架实现报文封装和解析。
>   * 整合第三方服务：高德地图SDK获取本机实时地理定位，天气API获取当下地理位置的实时天气等。


