package com.example;
import org.junit.*;



import static org.junit.Assert.*;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public class EstadoTest {

@Test
public void md5Test() throws IOException, ParseException {
    Problema problema = new Problema("src/main/java/com/example/p0.json");
    Estado e = problema.getInitState();
    assertNotNull(e.md5());
    assertNotNull(e.toString());
}


    
}
