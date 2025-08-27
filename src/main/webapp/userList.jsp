<%@ page import="java.util.List" %>
<%@ page import="com.task.beans.EmployeeData" %>
<!DOCTYPE html>
<html>
<head>
    <title>User List</title>
    <style>
        body { 
        	font-family: Arial, sans-serif; 
        	margin: 20px; 
        	background-image: url('https://tse2.mm.bing.net/th/id/OIP.Bsy9EBct6U2QgTE6P0HqywHaE7?rs=1&pid=ImgDetMain&o=7&rm=3');
			background-size: cover;
			margin: 0;
        }
        table { 
        	border-collapse: collapse; 
        	width: 70%; 
        	margin: auto; 
        	margin-top: 50px;
        	background: rgba(255, 255, 255, 0); 
			backdrop-filter: blur(8px);
			border: 2px solid rgba(255, 255, 255, 0.3);
        }
        th, td { 
        	border: 1px solid #ccc; 
        	padding: 10px; 
        	text-align: center; 
        }
        th { 
        	background-color: #f2f2f2; 
        }
        h2 { 
        	text-align: center; 
        }
        a { 
        	display: block; 
        	text-align: center; 
        	margin-top: 20px; 
        	text-decoration: none; 
        	color: white;
            font-size: large;
        
        }
    </style>
</head>
<body>
    <h2>User List</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Aadhar Number</th>
        </tr>
        <%
            List<EmployeeData> users = (List<EmployeeData>) request.getAttribute("userList");
            if (users != null) {
                for (EmployeeData u : users) {
        %>
            <tr>
                <td><%= u.getId() %></td>
                <td><%= u.getName() %></td>
                <td><%= u.getAdharNumber() %></td>
            </tr>
        <%
                }
            }
        %>
    </table>
    <a href="index.html">Back</a>
</body>
</html>
