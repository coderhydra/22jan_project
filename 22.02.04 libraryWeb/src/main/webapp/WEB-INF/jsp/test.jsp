<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>API 연습</title>
</head>

<body>
    <h1>내 사이트임 ㅎㅇ</h1>
    <input id="bookName" value="" type="text">
    <button id="search">검색</button>

    <p></p>
    <script src="https://code.jquery.com/jquery-3.4.1.js"
        integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
    <script>
        $(document).ready(function () {
            $("#search").click(function () {
                $.ajax({
                    method: "GET",
                    url: "https://dapi.kakao.com/v3/search/book?target=title",
                    data: { query: $("#bookName").val() },
                    headers: { Authorization: "KakaoAK ae13d16aba1a135ed753614e2b93283e" }
                })
                    .done(function (msg) {
                        console.log(msg.documents[0].title);
                        console.log(msg.documents[0].thumbnail);
                        $("p").append("<strong>" + msg.documents[0].title + "</strong>");
                        $("p").append("<img src='" + msg.documents[0].thumbnail + "'/>");
                    });
            });
        });
    </script>
</body>

</html>