# 商品后台API文档



- ### `GET`   	`/back/commodities`	展示所有商品的信息


##### Responses

###### 	Example Value:

```
[
  {
    "commodityId": 1,
    "commodityName": "饺子",
    "commodityBrand": 1231,
    "commodityVariety": 3213,
    "commodityDepict": "标签",
    "commodityPrice": 100,
    "commodityAmount": 500,
    "commodityLeavenum": 350,
    "commodityStandard": 15,
    "operator": 342123,
    "createTime": 1493486255000,
    "updateTime": 1493572649000,
    "commodityPicture": null
  },
  {
    "commodityId": 2,
    "commodityName": "鸭脖子",
    "commodityBrand": 3123,
    "commodityVariety": 432,
    "commodityDepict": "标签",
    "commodityPrice": 100,
    "commodityAmount": 500,
    "commodityLeavenum": 350,
    "commodityStandard": 15,
    "operator": 32,
    "createTime": 1493481297000,
    "updateTime": 1493481297000,
    "commodityPicture": null
  }
]
```

- ### `POST`	`/back/commodities`	添加一条商品

  使用位置：	添加商品

##### Parameter

###### 	Example Value:

```
{
    "commodityId":11,
    "commodityName":"牛蹄",
    "commodityBrand":3234,
    "commodityVariety":4143,
    "commodityDepict":"标签",
    "commodityPrice":30,
    "commodityAmount":200,
    "commodityLeavenum":80,
    "commodityStandard":15,
    "operator":13
}
```

##### Responses

###### 		Example Value:

- id存在：	

```
{
  "code": 101,
  "message": "插入失败,id已存在",
  "data": null
}
```

- 内部错误：

```
{
  "code": -1,
  "message": "出现未知异常",
  "data": null
}
```

- 成功

```
{
  "code": 100,
  "message": "操作成功",
  "data": {
    "commodityId":11,
    "commodityName":"牛蹄",
    "commodityBrand":3234,
    "commodityVariety":4143,
    "commodityDepict":"标签",
    "commodityPrice":30,
    "commodityAmount":200,
    "commodityLeavenum":80,
    "commodityStandard":15,
    "operator":13
	}
}
```



- ### `PUT`	`/back/commodities`	修改商品


##### Parameter

###### 	Example Value:

```
{
    "commodityId":11,
    "commodityName":"牛蹄",
    "commodityBrand":3234,
    "commodityVariety":4143,
    "commodityDepict":"标签",
    "commodityPrice":30,
    "commodityAmount":200,
    "commodityLeavenum":80,
    "commodityStandard":15,
    "operator":13
}
```

##### Responses

###### 	Example Value:

- id不存在:

```
{
  "code": 102,
  "message": "更新失败,不存在指定id",
  "data": {
    "commodityId": 11,
    "commodityName": "牛蹄子",
    "commodityBrand": 3234,
    "commodityVariety": 4143,
    "commodityDepict": "标签",
    "commodityPrice": 30,
    "commodityAmount": 200,
    "commodityLeavenum": 80,
    "commodityStandard": 15,
    "operator": 13,
    "createTime": 0,
    "updateTime": 0,
    "commodityPicture": null
  }
}
```

- 内部错误：

```
{
  "code": -1,
  "message": "出现未知异常",
  "data": null
}
```
- 成功：


```
{
  "code": 100,
  "message": "操作成功",
  "data": {
    "commodityId": 11,
    "commodityName": "牛蹄子",
    "commodityBrand": 3234,
    "commodityVariety": 4143,
    "commodityDepict": "标签",
    "commodityPrice": 30,
    "commodityAmount": 200,
    "commodityLeavenum": 80,
    "commodityStandard": 15,
    "operator": 13,
    "createTime": 0,
    "updateTime": 0,
    "commodityPicture": null
  }
}
```

- ### `DELETE`		`/back/commodities/{commodityId}`	删除商品	


##### Parameter

​	Name				Description

​	**commodityId**		**商品id号**

##### Responses

###### 	Example Value:

- id不存在：

```
{
  "code": 103,
  "message": "删除失败,不存在指定id",
  "data": null
}
```

- 成功：


```
{
  "code": 100,
  "message": "操作成功",
  "data": {
    "commodityId": 14,
    "commodityName": "牛蹄子",
    "commodityBrand": 3234,
    "commodityVariety": 4143,
    "commodityDepict": "标签",
    "commodityPrice": 30,
    "commodityAmount": 200,
    "commodityLeavenum": 80,
    "commodityStandard": 15,
    "operator": 13,
    "createTime": 1493953731000,
    "updateTime": 1493953731000,
    "commodityPicture": null
  }
}
```



### `POST`	`/back/pictures`	上传商品图片

##### Parameter

​	表单属性名			Description

​	**file					图片属性名**

​	**commodityId**		**商品id**

##### Responses

###### 	Example Value:	

文件大于5M：

```
{
  "code": 112,
  "message": "文件过大,无法上传",
  "data": null
}
```

不存在id：

```
{
  "code": 102,
  "message": "更新失败,不存在指定id",
  "data": null
}
```

成功：

```
{
  "code": 100,
  "message": "操作成功",
  "data": "/home/deity/sh/upload-dir/4d3c2b1a_11.jpg"
}
```