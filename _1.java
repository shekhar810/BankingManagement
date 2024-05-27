package com.begining;
import java.sql.*;

public class _1 {
    public static void main(String[] args) throws ClassNotFoundException {

        String url="jdbc:mysql://127.0.0.1:3306/student";
        String username="root";
        String password="shekhar1234@";

        String query1="Insert into employee(id,name,job_title,salary) values (3,'Rocky','Devops',69000);";
        String query="Select * from employee;";
        //String query="delete from employee where id=3;";
       // String query="update employee set job_title = 'DevOps' , salary=97000 where id=7;";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
           // System.out.println("Drivers loaded Successfully!");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con=DriverManager.getConnection(url,username,password);
            Statement stmt=con.createStatement();
            int rows=stmt.executeUpdate(query1);
            if(rows>0){
                System.out.println("Inserted Successfully : "+ rows+" rows affected");
            }else{
                System.out.println("Insertion failed!!");
            }
            ResultSet rs= stmt.executeQuery(query);
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String job_title=rs.getString("job_title");
                double salary=rs.getDouble("salary");
                System.out.println();
                System.out.println("!=============================!");
                System.out.println("ID : "+id);
                System.out.println("Name : "+name);
                System.out.println("Job_title : "+job_title);
                System.out.println("Salary : "+salary);
            }
            rs.close();
            stmt.close();
            con.close();
            System.out.println();
            System.out.println("XXXX XXXXXXXX Connection Close Successfully XXXXXXXXXXX");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
