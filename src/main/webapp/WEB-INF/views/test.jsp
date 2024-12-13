<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        h1 {
            width: 80%;
            margin: 20px auto;
            border-bottom: 1px cadetblue solid;
            text-align: center;
        }

        .book-info-area {
            display: flex;
            flex-wrap: wrap; /* 카드가 여러 줄로 배치되도록 설정 */
            gap: 20px;
            justify-content: center;
            width: 90%;
            margin: 20px auto;
        }
        .book-card {
            display: flex;
            flex-direction: column;
            align-items: center;
            background: #ffffff;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            width: 250px;
            padding: 15px;
            margin: 10px;
            /*height: 500px;*/
            max-height: 500px;
            text-align: center;
            transition: transform 0.2s ease-in-out, box-shadow 0.2s ease-in-out, max-height 0.2s ease-in-out;
        }
        .book-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 8px 12px rgba(0, 0, 0, 0.2);
            max-height: 1000px;
        }
        .book-card img {
            max-width: 100%;
            height: auto;
            border-radius: 4px;
        }
        .book-title {
            font-size: 16px;
            font-weight: bold;
            color: #34495e;
            margin: 10px 0;
        }
        .book-author {
            font-size: 14px;
            color: #7f8c8d;
            margin: 5px 0;
        }
        .book-description {
            flex-grow: 1;
            font-size: 12px;
            color: #95a5a6;
            margin-top: 10px;
            max-height: 100px;
            overflow: hidden; /* 텍스트가 넘치면 숨김 처리 */
            text-overflow: ellipsis;
            word-break: break-all;
            margin-bottom: 10px;
            transition: max-height 0.2s ease-in-out;
        }
        .book-description:hover {
            max-height: 500px;
        }
        .book-link {
            text-align: center;
            font-size: 14px;
            color: #3498db;
            text-decoration: none;
            margin-top: auto;
        }
        .book-link:hover {
            text-decoration: underline;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<h1>S E A R C H</h1>
<div class="book-info-area">
    <script>
        let books = ${search}.items;

        let html = "";
        $.each(books, function (i, v) {
            html += `
                <div class="book-card">
                    <img src="\${v.image}" alt="Book Image">
                    <p class="book-title">\${v.title}</p>
                    <p class="book-author">\${v.author}</p>
                    <p class="book-description">\${v.description}</p>
                    <a href="\${v.link}" class="book-link" target="_blank">View Details</a>
                </div>`;
        })

        $(".book-info-area").append(html);
    </script>
</div>
</body>
</html>