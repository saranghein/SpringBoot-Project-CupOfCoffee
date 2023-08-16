# CupofCoffee백엔드

## ERD 다이어그램

![erd](https://github.com/likelion-a-cup-of-coffee/back/assets/98319061/64e95c9c-6936-43f9-8eac-7cf11d56434f)


## API

+ postman, MySQL Workbench, Docker(mysql) 사용
+ websocket-stomp는 postman에서 지원하지 않아 **apic** (구글확장프로그램)이용

| GET                        | 설명                                |
|----------------------------|-----------------------------------|
| `/posts`                   | 모든 post(게시글)의 내용 불러옴              |
| `/posts/{id}`              | 해당 id(post_id)의 post(게시글)내용 불러옴   |
| `/posts/{id}/comments`     | 해당 id(post_id)의 comments(댓글)들 불러옴 |
| `/users`                   | 모든 user(사용자)목록 불러옴                |
| `/users/{id}`              | 해당 id(user_id)의 정보 불러옴            |
| `/chat/rooms`              | 모든 채팅방 정보 불러옴                     |
| `/chat/room/{roomId}` | 해당 roomId를 가지고 있는 채팅방 정보 불러옴      |
| `/chat/room/enter/{roomId}` | 해당 roomId를 가지고 있는 채팅방 입장          |

| POST                              | 설명                                       |
|-----------------------------------|------------------------------------------|
| `/posts/{username}/write`         | username이 post(게시글)추가                    |
| `/posts/{username}/{id}/comments` | 해당 username과 id(post_id)의 comments(댓글)추가 |
| `/users`                          | user(사용자)추가                              |
| `/chat/room?name={name}`          | name이름을 가지는 채팅방 생성(roomId 자동생성)          |

| PUT                      | 설명                                      |
|--------------------------|-----------------------------------------|
| `/posts/{id}/{username}` | 해당username이 id(post_id)의 post(게시글)내용 수정 |

| DELETE        | 설명                           |
|---------------|------------------------------|
| `/posts/{id}` | 해당 id(post_id)의 post(게시글) 삭제 |
| `/users/{id}` | 해당 id(user_id)의 user(사용자) 삭제 |

---

+ webSocket-Stomp은 테스트시 http://localhost:8080/ws-stomp 로 연결

|subsciber|설명|
|---|---|
|`/sub/chat/room/{roomId}`|POST에서 생성한 roomId로 입장|

| publisher           | 설명                                            |
|---------------------|-----------------------------------------------|
| `/pub/chat/message` | JSON형태로  message를 보냄( ENTER:입장, TALK: 채팅 입력시) |
```json
{
  "type": "ENTER",
  "roomId": "ENTER or TALK할 roomId",
  "sender": "유저이름",
  "message": "메시지"
}
```

![subscriber](https://github.com/likelion-a-cup-of-coffee/back/assets/98319061/9e2518b9-146d-48a0-8a63-0b0e447ae051)
![publisher](https://github.com/likelion-a-cup-of-coffee/back/assets/98319061/ab31aedf-08cd-4e68-b0b2-e35c5d44b18c)