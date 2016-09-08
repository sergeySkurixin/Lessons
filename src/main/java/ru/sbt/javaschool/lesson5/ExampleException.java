package ru.sbt.javaschool.lesson5;

/**
 * Created by скурихин on 18.08.2016.
 */
public class ExampleException {
    public static void main(String[] args) {
        try{
            int j = 5;
            int i = 0;
            System.out.println("result"+j/i);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {

        }

        int i = new ExampleException().Example();
        System.out.println(i);


//        try(FileInputStream inputStream = new FileInputStream("C:/asdf")){
//
//        }catch (Exception ex){
//
//        }
    }

    public int Example(){
        try{

            throw new Exception();
        }catch (Exception e){
            return 0;
        }finally {
            return 1;
        }
    }


}
