package com.begining;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Image_Handling {
    public static void main(String[] args) throws ClassNotFoundException{
        String url="jdbc:mysql://127.0.0.1:3306/student";
        String username="root";
        String password="shekhar1234@";
        String img_path="C:\\Users\\user\\Downloads\\ff.png";
        String query="insert into image_table(image_data) values(?)";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver load Successfully");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection established successfully");

            //How to upload image in java program there byte code is stored in array
            FileInputStream fileInputStream=new FileInputStream(img_path);
            byte[] imageData=new byte[fileInputStream.available()];
            fileInputStream.read(imageData);

            //how to upload that image from java to sql

            PreparedStatement preparedStatement=con.prepareStatement(query);
            preparedStatement.setBytes(1,imageData);

            int affectedrow=preparedStatement.executeUpdate();
            if(affectedrow>0){
                System.out.println("Image inserted successfully");
            }else{
                System.out.println("Image not inserted");
            }





        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
        catch(IOException e){
            throw  new RuntimeException(e);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
