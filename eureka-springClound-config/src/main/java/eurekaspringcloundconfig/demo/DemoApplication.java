package eurekaspringcloundconfig.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * spring clound config配置中心
 * 1 导入pom
 * 2 yml配置，连接哪个git仓库
 * 3 加入注解
 * 4 在相应的githup上建立相应的仓库，并复制其ssh地址
 * 5 在本地新建文件夹并clone仓库地址，可能出现
 * Please make sure you have the correct access rights and the repository exists错误
 * 此时需要1. 删除 .ssh 文件夹【C:\Users\(本地用户名)\.ssh】 中的 known_hosts(直接删除即可)
 * 在下载好的Git中的bin目录下（一般是 C:\Program Files\Git\bin）打开bash.exe输入命令ssh-keygen -t rsa -C "username" (注：username为你git上的用户名)，如果执行成功。返回：
 *
 *        Generating public/private rsa key pair.
 *        Enter file in which to save the key (/Users/username/.ssh/id_rsa): //这里的username是电脑上的用户名，这个地址也是文件的存储地址，然后按回车，
 *
 * 如果以前有存储地址会返回/Users/your username/.ssh/id_rsa already exists.Overwrite (y/n)?直接输入y回车。
 *
 * 如果以前没有储存地址就会出现Enter passphrase(empty for no passphrase);也直接回车，
 *
 * 两种情况回车后都会出现 Enter same passphrase again 然后接着回车会显示
 *
 * The key's randomart image is:
 * +---[RSA 2048]----+
 * |    .          . |
 * | . = .       .  o|
 * |o o * .     . ...|
 * |E oo o   .   o.. |
 * | B .  o S . ...  |
 * |. o    o .o..    |
 * | .       o**.    |
 * |        .B=+%.   |
 * |         +*BoBo  |
 * +----[SHA256]-----+，这说明SSH key就已经生成了。文件目录就是：username/.ssh/id_rsa.pub.
 *
 * 3. 然后找到系统自动在.ssh文件夹下生成两个文件，id_rsa和id_rsa.pub，用记事本打开id_rsa.pub将全部的内容复制。
 *
 * 4. 打开https://github.com/，登陆账户，进入设置（Settings）找到
 * 5 将key复制进行
 * 6 git add .加入本地仓库
 * 7 git commit -m "注释"
 * 8 git push
 * 9 启动应用，访问相应链接，如http://localhost:8085/application-dev.yml或http://localhost:8085/master/application-dev.yml,
 * 浏览器将会出现相应的配置数据
 */
@SpringBootApplication
@EnableConfigServer
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
