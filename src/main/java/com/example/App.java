package com.example;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import method.AdminFunction;
import models.Admin;

public class App 
{
    public static void main( String[] args ) throws IOException, ParseException
    {   
        ArrayList<Admin> arrayList= new ArrayList<>();
        AdminFunction adminFunction = new AdminFunction(arrayList);
        adminFunction.adminTerminal();
        
    }
}
