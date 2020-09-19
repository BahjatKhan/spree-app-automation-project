package com.shiftedtech.spreeTest;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DataDrivenJunit {


    private String email;
    private String password;



   public DataDrivenJunit(String email,String password){
       this.email=email;
       this.password=password;
   }








   //@Parameterized.Parameters(name= "{Index}:Test with ")

}
