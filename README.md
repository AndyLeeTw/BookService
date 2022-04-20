**API 使用方式**
====
- [**API 使用方式**](#api-使用方式)
  - [**列出所有書籍**](#列出所有書籍)
  - [**新增書籍**](#新增書籍)
  - [**修改書籍**](#修改書籍)
  - [**刪除書籍**](#刪除書籍)

**列出所有書籍**
----
    回傳所有書籍資料
* **URL**
    
    /books
* **Method:**
    
    `GET`
*  **URL 參數**
    
    無
* **資料參數**
    
    無
* **成功回傳:**
    * **Code:** 200 <br />
    **Content:**
        ````
        {
            "message": null,
            "books": [
                {
                    "isbn": "978-62670-9936-0",
                    "name": "123",
                    "author": "aaa",
                    "translator": null,
                    "publisher": "bbb",
                    "publishDate": "2020-01-01",
                    "price": 1.0
                }
            ]
        }
* **失敗回傳:**
    * **Code:** 400 <br />
    **Content:**
        ````
        {
            "message": "error message",
            "books": null
        }

* **呼叫範例:**
    ````javascript
    $.ajax({
        url: "/books",
        dataType: "json",
        type : "GET",
        success : function(r) {
            console.log(r);
        }
    });
**新增書籍**
----
    新增書籍資料
* **URL**
    
    /books/:isbn
* **Method:**
    
    `POST`
*  **URL 參數**
    
    無
* **資料參數**

        {
            "name": "string",
            "author": "string",
            "translator": "string", (選填)
            "publishDate": "yyyy-MM-dd",
            "price": "double",
        }
* **成功回傳:**
    * **Code:** 201 <br/>
    **Content:**
        
            {
                "message": null,
                "books": {
                    "isbn": "978-62670-9936-0",
                    "name": "123",
                    "author": "aaa",
                    "translator": null,
                    "publisher": "bbb",
                    "publishDate": "2020-01-01",
                    "price": 1.0
                }
            }
* **失敗回傳:**
    * **Code:** 400 <br/>
    **Content:**

            {
                "message": "error message",
                "book": null
            }

* **呼叫範例:**

    ````javascript
    $.ajax({
        url: "/books",
        dataType: "json",
        type : "POST",
        data : {
            "isbn": "978-62670-9936-0",
            "name": "123",
            "author": "aaa",
            "translator": null,
            "publisher": "bbb",
            "publishDate": "2020-01-01",
            "price": 1.0
        },
        success : function(r) {
            console.log(r);
        }
    });
**修改書籍**
----
    修改書籍資料
* **URL**
    
    /books/:isbn
* **Method:**
    
    `PUT`
*  **URL 參數**
    
    無
* **資料參數**

        {
            "isbn": "string",
            "name": "string",
            "author": "string",
            "translator": "string", (選填)
            "publishDate": "yyyy-MM-dd",
            "price": "double",
        }
* **成功回傳:**
    * **Code:** 201 <br/>
    **Content:**
        
            {
                "message": null,
                "book": {
                    "isbn": "978-62670-9936-0",
                    "name": "123",
                    "author": "aaa",
                    "translator": null,
                    "publisher": "bbb",
                    "publishDate": "2020-01-01",
                    "price": 1.0
                }
            }
* **失敗回傳:**
    * **Code:** 400 <br/>
    **Content:**

            {
                "message": "error message",
                "book": null
            }

* **呼叫範例:**

    ````javascript
    $.ajax({
        url: "/users/978-62670-9936-0",
        dataType: "json",
        type : "PUT",
        data : {
            "name": "123",
            "author": "aaa",
            "translator": null,
            "publisher": "bbb",
            "publishDate": "2020-01-01",
            "price": 1.0
        },
        success : function(r) {
            console.log(r);
        }
    });
**刪除書籍**
----
    刪除書籍資料
* **URL**
    
    /books/:isbn
* **Method:**
    
    `DELETE`
*  **URL 參數**
    
    無
* **資料參數**
    
    無
* **成功回傳:**
    * **Code:** 204 <br/>
* **失敗回傳:**
    * **Code:** 400 <br/>
    **Content:**

            {
                "message": "error message",
                "book": null
            }

* **呼叫範例:**

    ````javascript
    $.ajax({
        url: "/users/978-62670-9936-0",
        dataType: "json",
        type : "DELETE",
        success : function(r) {
            console.log(r);
        }
    });
