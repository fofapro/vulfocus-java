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
  <artifactId>vulfocus-java</artifactId>
  <version>0.0.2</version>
</dependency>
```

### Gradle Groovy DSL

```
implementation 'com.r4v3zn.vulfocus:vulfocus-java:0.0.2'
```

### Gradle Kotlin DSL

```
implementation("com.r4v3zn.vulfocus:vulfocus-java:0.0.2")
```

### Scala SBT

```
libraryDependencies += "com.r4v3zn.vulfocus" % "vulfocus-java" % "0.0.2"
```

### Apache Ivy

```
<dependency org="com.r4v3zn.vulfocus" name="vulfocus-java" rev="0.0.2" />
```

### Groovy Grape

```
@Grapes(
  @Grab(group='com.r4v3zn.vulfocus', module='vulfocus-java', version='0.0.2')
)
```

###  Leiningen

```
[com.r4v3zn.vulfocus/vulfocus-java "0.0.2"]
```

### Apache Buildr

```
'com.r4v3zn.vulfocus:vulfocus-java:jar:0.0.2'
```

### Maven Central Badge

```
[![Maven Central](https://img.shields.io/maven-central/v/com.r4v3zn.vulfocus/vulfocus-java.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.r4v3zn.vulfocus%22%20AND%20a:%22vulfocus-java%22)
```

### PURL

```
pkg:maven/com.r4v3zn.vulfocus/vulfocus-java@0.0.2
```

### Bazel

```
maven_jar(
    name = "vulfocus-java",
    artifact = "com.r4v3zn.vulfocus:vulfocus-java:0.0.2",
    sha1 = "32e595e8cd0f7879fd0246d82f747b789cc21af0",
)
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

### Start

#### Code

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

#### Response

```
ImageEntity{imageName='vulfocus/webmin-cve_2020_35606:latest', imageVulName='Webmin 命令执行漏洞 （CVE-2020-35606）', imageDesc='Webmin是Webmin社区的一套基于Web的用于类Unix操作系统中的系统管理工具。
Webmin 1.962版本及之前版本存在安全漏洞，该漏洞允许执行任意命令。任何被授权使用Package Updates模块的用户都可以使用根权限通过包含和的向量执行任意命令。
账户密码：root:password'}

HostEntity{host='118.193.36.37:54240', port='{"10000": "54240"}'}
```

### Stop

#### Code

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

#### Response

```
ImageEntity{imageName='vulfocus/webmin-cve_2020_35606:latest', imageVulName='Webmin 命令执行漏洞 （CVE-2020-35606）', imageDesc='Webmin是Webmin社区的一套基于Web的用于类Unix操作系统中的系统管理工具。
Webmin 1.962版本及之前版本存在安全漏洞，该漏洞允许执行任意命令。任何被授权使用Package Updates模块的用户都可以使用根权限通过包含和的向量执行任意命令。
账户密码：root:password'}

停止成功
```

### Delete

#### Code

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

#### Response

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
