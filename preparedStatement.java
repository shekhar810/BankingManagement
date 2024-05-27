package com.begining;

import java.sql.*;

public class preparedStatement {
    public static void main(String[] args) throws ClassNotFoundException  {
        String url="jdbc:mysql://127.0.0.1:3306/student";
        String username="root";
        String password="shekhar1234@";
        //String query="select * from employee where name = ? and job_title = ? ";
        String query="Insert into employee(id,name,job_title,salary) values(?, ?, ?, ?)";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con= DriverManager.getConnection(url,username,password);
            //Statement stmt=con.createStatement();
            PreparedStatement preparedStatement =con.prepareStatement(query);
//            preparedStatement.setString(1,"suman");
//            preparedStatement.setString(2,"Tester");
            preparedStatement.setInt(1,8);
            preparedStatement.setString(2,"Krishna");
            preparedStatement.setString(3,"Creator");
            preparedStatement.setDouble(4,93000);
//            ResultSet resultSet=preparedStatement.executeQuery();
//            while(resultSet.next()){
//                int id=resultSet.getInt("id");
//                String name=resultSet.getString("name");
//                String job_title=resultSet.getString("job_title");
//                double salary=resultSet.getDouble("salary");
//                System.out.println("ID : "+id);
//                System.out.println("Name : "+name);
//                System.out.println("Job_title : "+job_title);
//                System.out.println("Salary : "+salary);
//            }
//
//            resultSet.close();
            int rowAffacted=preparedStatement.executeUpdate();
            if(rowAffacted>0){
                System.out.println("Data Inserted Successfully");
            }else{
                System.out.println("Data Insertion Failed!!");
            }
            preparedStatement.close();
            con.close();
            System.out.println();
            System.out.println("Connection closed Successfully");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
