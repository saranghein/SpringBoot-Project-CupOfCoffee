<<<<<<< HEAD
# CupofCoffee백엔드

## ERD 다이어그램
+ **수정예정**
  ![Copy of 해커톤](https://github.com/likelion-a-cup-of-coffee/back/assets/98319061/e80c7a29-c2c1-4a6b-a152-7a10226a228f)


## API

+ postman, MySQL Workbench, Docker(mysql) 사용
+ 커피챗 관련 api 및 추가적인 api 추가 예정

| GET                    | 설명                                |
|------------------------|-----------------------------------|
| `/posts`               | 모든 post(게시글)의 내용 불러옴              |
| `/posts/{id}`          | 해당 id(post_id)의 post(게시글)내용 불러옴   |
| `/posts/comments`      | 모든 comments(댓글)들 불러옴              |
| `/posts/{id}/comments` | 해당 id(post_id)의 comments(댓글)들 불러옴 |
| `/users`               | 모든 user(사용자)목록 불러옴                |
| `/users/{id}`          | 해당 id(user_id)의 정보 불러옴            |

| POST                              | 설명                        |
|-----------------------------------|---------------------------|
| `/posts`                          | post(게시글)추가               |
| `/posts/{username}/{id}/comments` | 해당 username과 id(post_id)의 comments(댓글)추가 |
| `/users`                          | user(사용자)추가               |

| PUT           | 설명                             |
|---------------|--------------------------------|
| `/posts/{id}` | 해당 id(post_id)의 post(게시글)내용 수정 |

| DELETE        | 설명                           |
|---------------|------------------------------|
| `/posts/{id}` | 해당 id(post_id)의 post(게시글) 삭제 |
| `/users/{id}` | 해당 id(user_id)의 user(사용자) 삭제 |
=======
>>>>>>> 42f29223872c9e5bec1610f32624fbc3750b597b

