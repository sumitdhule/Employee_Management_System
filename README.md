# 👨‍💼 Employee Management System(Adv Java)  

A **console-based Employee Management System** built using **Core Java, JDBC, and Oracle Database**.  
This project helps manage employee records like adding, viewing, updating, and deleting employee details in a database.  

---

## ✨ Features  
- ➕ Add new employees  
- 📋 View all employee details  
- 🔍 Search employee by ID  
- ✏️ Update employee details  
- ❌ Delete employee record  
- 💾 Data stored securely in **Oracle Database**  

---

## 🛠️ Technologies Used  
- **Programming Language:** Java (Core Java)  
- **Database:** Oracle Database  
- **Database Connectivity:** JDBC (Oracle Thin Driver)  
- **IDE:** Eclipse   
- **Version Control:** Git & GitHub  

---

## 📂 Project Structure  
```
EmployeeManagementSystem/
│-- src/
│   ├── Main.java
│   ├── Employee.java
│   ├── EmployeeDAO.java
│   ├── DBConnection.java
│-- README.md
```

---

## ⚙️ Setup & Installation  

### 1. Clone the repository  
```bash
git clone https://github.com/sumitdhule/EmployeeManagementSystem.git
cd EmployeeManagementSystem
```

### 2. Create Oracle Database Table  
```sql
CREATE TABLE employees (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR2(100),
    department VARCHAR2(100),
    salary NUMBER(10,2)
);
```

### 3. Configure DBConnection.java  
Update your Oracle connection details in `DBConnection.java`:  
```java
String url = "jdbc:oracle:thin:@localhost:1521:xe";  // Adjust XE or ORCL as per your DB
String username = "system";
String password = "tiger";  
```

### 4. Add Oracle JDBC Driver  
- Download **ojdbc11.jar** (or version matching your Oracle DB).  
- Add it to your project’s classpath.  

### 5. Compile and Run  
```bash
javac Main.java
java Main
```

---

## 🎯 Future Enhancements  
- Add GUI (Java Swing / JavaFX)  
- Add authentication (Admin/User login)  
- Export employee data to Excel/PDF  
- Deploy as a web application  

---

## 📌 Author  
👤 **Sumit Dhule**  
📍 Hyderabad, India  
💼 Aspiring Java Engineer  
📷 Hobby: Capturing the best moments  
