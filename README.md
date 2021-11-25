# vulfocus-java



[![GitHub (pre-)release](https://img.shields.io/github/release/fofapro/vulfocus-java/all.svg)](https://github.com/fofapro/vulfocus-java/releases) [![stars](https://img.shields.io/github/stars/fofapro/vulfocus-java.svg)](https://github.com/fofapro/vulfocus-java/stargazers) [![license](https://img.shields.io/github/license/fofapro/vulfocus-java.svg)](https://github.com/fofapro/vulfocus-java/blob/master/LICENSE)

[Chinese document](https://github.com/fofapro/vulfocus-java/blob/master/README_zh.md)

## Vulfocus API


[`Vulfocus API`](https://fofapro.github.io/vulfocus/#/VULFOCUSAPI) is the `RESUFul API` interface provided by [`Vulfocus`](http://vulfocus.io/) for development, allowing Developers integrate [`Vulfocus`](http://vulfocus.io) in their own projects.

## Vulfocus SDK

The `Java` version of `SDK` written based on the [`Vulfocus API`](https://fofapro.github.io/vulfocus/#/VULFOCUSAPI) makes it easy for `Java` developers to quickly integrate [`Vulfocus`](http://vulfocus.io/)  into their projects.

## Add dependency

### Apache Maven

```
<dependency>
  <groupId>com.r4v3zn.vulfocus</groupId>
  <artifactId>vulfocus-core</artifactId>
  <version>0.0.2</version>
</dependency>
```

## USE

|field|description|
| ---- | ---- |
|`addr`|[`Vulfocus`](http://vulfocus.io/) URL|
|`username`|User login [`Vulfocus`](http://vulfocus.io/) userbox `username`|
|`licence`|Please go to the [`personal center`](http://vulfocus.fofa.so/#/profile/index) to view `API licence`|

### Pull Images

#### Code

```java
public static void main(String[] args) throws Exception {
  String username = "";
  String license = "";
  VulfocusClinet vulfocusClinet = new VulfocusClinet(username, license);
  List<ImageEntity> imageEntityList = vulfocusClinet.imageList();
  System.out.println(imageEntityList);
}
```

#### Response

```
[ImageEntity{imageName='vulfocus/webmin-cve_2020_35606:latest', imageVulName='Webmin 命令执行漏洞 （CVE-2020-35606）', imageDesc='Webmin是Webmin社区的一套基于Web的用于类Unix操作系统中的系统管理工具。
Webmin 1.962版本及之前版本存在安全漏洞，该漏洞允许执行任意命令。任何被授权使用Package Updates模块的用户都可以使用根权限通过包含和的向量执行任意命令。
账户密码：root:password'}]
```

## Start

### Code

```java
public static void main(String[] args) throws Exception {
  String username = "";
  String license = "";
  VulfocusClinet vulfocusClinet = new VulfocusClinet(username, license);
  List<ImageEntity> imageEntityList = vulfocusClinet.imageList();
  ImageEntity imageEntity = imageEntityList.get(0);
  System.out.println(imageEntity);
  System.out.println(vulfocusClinet.start(imageEntity.getImageName()));
}
```


### Response

```
ImageEntity{imageName='vulfocus/webmin-cve_2020_35606:latest', imageVulName='Webmin 命令执行漏洞 （CVE-2020-35606）', imageDesc='Webmin是Webmin社区的一套基于Web的用于类Unix操作系统中的系统管理工具。
Webmin 1.962版本及之前版本存在安全漏洞，该漏洞允许执行任意命令。任何被授权使用Package Updates模块的用户都可以使用根权限通过包含和的向量执行任意命令。
账户密码：root:password'}

HostEntity{host='118.193.36.37:54240', port='{"10000": "54240"}'}
```

## Stop

### Code

```java
public static void main(String[] args) throws Exception {
  String username = "";
  String license = "";
  VulfocusClinet vulfocusClinet = new VulfocusClinet(username, license);
  List<ImageEntity> imageEntityList = vulfocusClinet.imageList();
  ImageEntity imageEntity = imageEntityList.get(0);
  System.out.println(imageEntity);
  System.out.println(vulfocusClinet.stop(imageEntity.getImageName()));
}
```

### Response

```
ImageEntity{imageName='vulfocus/webmin-cve_2020_35606:latest', imageVulName='Webmin 命令执行漏洞 （CVE-2020-35606）', imageDesc='Webmin是Webmin社区的一套基于Web的用于类Unix操作系统中的系统管理工具。
Webmin 1.962版本及之前版本存在安全漏洞，该漏洞允许执行任意命令。任何被授权使用Package Updates模块的用户都可以使用根权限通过包含和的向量执行任意命令。
账户密码：root:password'}

停止成功
```

## Delete

### Code

```java
public static void main(String[] args) throws Exception {
  String username = "";
  String license = "";
  VulfocusClinet vulfocusClinet = new VulfocusClinet(username, license);
  List<ImageEntity> imageEntityList = vulfocusClinet.imageList();
  ImageEntity imageEntity = imageEntityList.get(0);
  System.out.println(imageEntity);
  System.out.println(vulfocusClinet.delete(imageEntity.getImageName()));
}
```

### Response

```
ImageEntity{imageName='vulfocus/webmin-cve_2020_35606:latest', imageVulName='Webmin 命令执行漏洞 （CVE-2020-35606）', imageDesc='Webmin是Webmin社区的一套基于Web的用于类Unix操作系统中的系统管理工具。
Webmin 1.962版本及之前版本存在安全漏洞，该漏洞允许执行任意命令。任何被授权使用Package Updates模块的用户都可以使用根权限通过包含和的向量执行任意命令。
账户密码：root:password'}

删除成功
```

## Update Log

2021-11-26

```
Release
```
