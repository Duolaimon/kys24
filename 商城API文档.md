# 商城API文档



- ### `GET`   	`/shop/commodities`	展示所有商品的信息

  使用位置：	商城页面商品信息

##### Responses

###### 	Example Value:

```
[
  {
    "commodityID": 1,
    "commodityBrand": 1231,
    "commodityVariety": 3213,
    "commodityName": "饺子",
    "commodityPrice": 100,
    "commodityPicture": "/home/user/picture/a1b2c3d4_1_1a2b3c4d.jpg"
  },
  {
    "commodityID": 2,
    "commodityBrand": 3123,
    "commodityVariety": 432,
    "commodityName": "鸭脖子",
    "commodityPrice": 100,
    "commodityPicture": null
  }
]
```

- ### `GET`	`/shop/varieties/{varietyId}`	展示指定种类的商品

  使用位置：	筛选种类商品

##### Parameter

​	Name				Description

​	**varietyId**			**种类id号**

##### Responses

###### 	Example Value:

不存在：				[ ]

存在：

```
[
  {
    "commodityID": 1,
    "commodityBrand": 1231,
    "commodityVariety": 3213,
    "commodityName": "饺子",
    "commodityPrice": 100,
    "commodityPicture": null
  }
]
```



- ### `GET`	`/shop/brands/{brandId}`	展示指定品牌的商品

  使用位置：	筛选品牌商品

##### Parameter

​	Name				Description

​	**brandId**				**品牌id号**

##### Responses

###### 	Example Value:

不存在：				[ ]

存在：

```
[
  {
    "commodityID": 10,
    "commodityBrand": 3230,
    "commodityVariety": 4141,
    "commodityName": "猪蹄",
    "commodityPrice": 30,
    "commodityPicture": ""
  }
]
```

- ### `GET`	`/shop/commodities/{commodityId}`	展示指定id号的商品	

  使用位置：	商品单页

##### Parameter

​	Name				Description

​	**commodityId**		**商品id号**

##### Responses

###### 	Example Value:

不存在：				[ ]

存在：

```
{
  "commodityId": 10,
  "commodityName": "猪蹄",
  "commodityBrand": 3230,
  "commodityVariety": 4141,
  "commodityDepict": "标签",
  "commodityPrice": 30,
  "commodityAmount": 200,
  "commodityLeavenum": 80,
  "commodityStandard": 15,
  "operator": 13,
  "createTime": 1493688745000,
  "updateTime": 1493688741000,
  "commodityPicture": ""
}
```



### `POST`	`/shop/search`	关键字查找商品

​	使用位置：	商城搜索

##### Parameter

​	表单属性名			Description

​	**searchKey			关键字**

##### Responses

###### 	Example Value:	searchKey = "子"

不存在：				[ ]

存在：

```
[
  {
    "commodityID": 1,
    "commodityBrand": 1231,
    "commodityVariety": 3213,
    "commodityName": "饺子",
    "commodityPrice": 100,
    "commodityPicture": null
  },
  {
    "commodityID": 2,
    "commodityBrand": 3123,
    "commodityVariety": 432,
    "commodityName": "鸭脖子",
    "commodityPrice": 100,
    "commodityPicture": null
  }
]
```