
## 기능목록
### 일정 생성
### 일정 조회
- **전체 일정 조회**
- **선택 일정 조회 **
### 일정 수정
### 일정 삭제
      
# API 명세서

## 일정 생성
- **Method**: POST
- **URL**: /api/schedule
- **RequestBody**: { "title":"제목", "content":"내용", "writer":"작성자명", "password":"비밀번호" }
- **ResponseBody**: { "id": 1, "title": "제목", "content": "내용", "writer": "작성자명", "createdAt": "YYYY-MM-DD hh:mm:ss", "updatedAt": "YYYY-MM-DD hh:mm:ss" }

## 전체 조회
- **Method**: GET
- **URL**: /api/schedule
- **RequestBody**: { "writer": "작성자명", "updatedAt": "YYYY-MM-DD hh:mm:ss" }
- **ResponseBody**: { "id": 1, "title": "제목", "content": "내용", "writer": "작성자명", "createdAt": "YYYY-MM-DD hh:mm:ss", "updatedAt": "YYYY-MM-DD hh:mm:ss" }

## 선택 조회
- **Method**: GET
- **URL**: /api/schedule/{id}
- **ResponseBody**: { "id": 1, "title": "제목", "content": "내용", "writer": "작성자명", "createdAt": "YYYY-MM-DD hh:mm:ss", "updatedAt": "YYYY-MM-DD hh:mm:ss" }

## 일정 수정
- **Method**: PUT
- **URL**: /api/schedule/{id}
- **RequestBody**: { "title": "제목", "writer": "작성자명", "password":"비밀번호" }
- **ResponseBody**: { "id": 1, "title": "제목", "content": "내용", "writer": "작성자명", "createdAt": "YYYY-MM-DD hh:mm:ss", "updatedAt": "YYYY-MM-DD hh:mm:ss" }

## 일정 삭제
- **Method**: DELETE
- **URL**: /api/schedule/{id}
- **RequestBody**:  { "password": "비밀번호" }

## ERD

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FciklJF%2FbtsJT88cgU5%2FKPIZFIKat9Vw9GKHKLqgJK%2Fimg.png)
