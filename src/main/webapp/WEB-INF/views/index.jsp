<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Title</title>
    <style>
        .input-div {
            width: 80%;
            margin: 20px auto;
        }
        .input-div form {
            display: flex;
            align-items: center;
        }
        .input-div input {
            width: 100%;
            padding: 5px;
        }
        .input-div button {
            padding: 5px 10px;
        }

        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }

        th {
            background-color: #f4f4f4;
            font-size: 15px;
            color: red;
        }

        td {
            font-size: 10px;
            color: black;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<script type="text/javascript">
    $(document).ready(function () {
        $.ajax({
            url: "/users",
            type: "GET",
            dataType: "json",
            success: function (data) {
                let html = "";
                $.each(data, function (i, v) {
                    html += `<tr>
                                 <td>\${v.userId}</td>
                                 <td>\${v.userName}</td>
                                 <td>\${v.createdAt}</td>
                                 <td>\${v.modifiedAt}</td>
                             </tr>`;
                });
                $("#user-table-body").html(html); // 테이블에 데이터 삽입
            },
            error: function (xhr, status, error) {
                console.error("API 호출 실패:", error);
            }
        })
    })
</script>
<div class="input-div">
    <form action="<c:url value="/books/search"/>" method="get">
        <label>
            <input type="text" name="query" style="width: 80%;">
        </label>
        <button type="submit">검색</button>
    </form>
</div>
<div>
    <table id="user-table">
        <thead>
        <tr>
            <th>ID</th>
            <th>이름</th>
            <th>생성일</th>
            <th>수정일</th>
        </tr>
        </thead>
        <tbody id="user-table-body">
        </tbody>
    </table>
</div>
</body>