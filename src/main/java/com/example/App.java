package com.example;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import method.AdminFunction;
import method.CandidateFunction;
import method.VoterFunction;
import models.Admin;

public class App 
{
    public static void main( String[] args ) throws IOException, ParseException, java.text.ParseException
    {   
        VoterFunction voterFunction= new VoterFunction();
        voterFunction.voterTerminal();
        
    }
}
