<%@page contentType="text/html; charset=gb2312" language="java" errorPage=""%>
<%@page import="java.sql.*" %>

<% String url="jdbc:mysql://localhost:3306/carproject?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8";
//����һ��ch10�����ݿ�
    String userName="root";
    String password="Zt1102168414";
    Connection conn=null;
    try{ Class.forName("com.mysql.cj.jdbc.Driver"); }
    catch(ClassNotFoundException e)
    { out.println("������������ʱ�����쳣");
        e.printStackTrace();}
    try{ conn=null; conn=DriverManager.getConnection(url,userName,password); }
    catch(SQLException e){ out.println("�������ݿ�Ĺ����г���SQL�쳣");
        e.printStackTrace();
        out.println(e.getMessage());}
    if(conn==null){out.println("�������ݿ�ʧ��");}
    else{out.println("�������ݿ�ɹ�");try{conn.close();}
    catch(SQLException e)
    {out.println("�ر����ݿ�����ʱ����SQL�쳣");}} %>
