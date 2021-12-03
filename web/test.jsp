<%@page contentType="text/html; charset=gb2312" language="java" errorPage=""%>
<%@page import="java.sql.*" %>

<% String url="jdbc:mysql://localhost:3306/carproject?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8";
//创建一个ch10的数据库
    String userName="root";
    String password="Zt1102168414";
    Connection conn=null;
    try{ Class.forName("com.mysql.cj.jdbc.Driver"); }
    catch(ClassNotFoundException e)
    { out.println("加载驱动器类时出现异常");
        e.printStackTrace();}
    try{ conn=null; conn=DriverManager.getConnection(url,userName,password); }
    catch(SQLException e){ out.println("链接数据库的过程中出现SQL异常");
        e.printStackTrace();
        out.println(e.getMessage());}
    if(conn==null){out.println("链接数据库失败");}
    else{out.println("链接数据库成功");try{conn.close();}
    catch(SQLException e)
    {out.println("关闭数据库连接时出现SQL异常");}} %>
