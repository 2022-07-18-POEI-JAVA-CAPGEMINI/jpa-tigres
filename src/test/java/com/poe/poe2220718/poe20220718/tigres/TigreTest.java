package com.poe.poe2220718.poe20220718.tigres;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;



public class TigreTest {

//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
    @BeforeEach
    public void setUp() {
         TigreDAO.deleteAll();
    }

    
//    @Test
//    public void testCreateTigre() {
//        Tigre newTigre = new Tigre("Tigrou", 5, "France", true);
//        TigreDAO.create(newTigre);
//    }
//    
    @Test
    public void testCreateTigre() {
        
        Tigre newTigre = new Tigre("Tigrou", 5, "France", true);
        TigreDAO.create(newTigre);
    }
    
    @Test
    public void testFindById() {
        
        // Creation Tigre dans la BD
        Tigre newTigre = new Tigre("Tigrou", 5, "France", true);
        TigreDAO.create(newTigre);
        Long id = newTigre.getId();
         
        // Chercher Tigre dans la BD
        Tigre databaseTigre = TigreDAO.findById(id);
        System.out.println(databaseTigre);
        assertNotNull(databaseTigre);
    }
    
    @Test
    public void testFindAll() {
        // Creation Tigre dans la BD
        Tigre newTigre = new Tigre("Tigrou", 5, "France", true);
        TigreDAO.create(newTigre);
        
        List<Tigre> tigres = TigreDAO.findAll();
        assertTrue(tigres.size() > 0);
        for(Tigre tigre : tigres){
            System.out.println(tigre);
        }
    }
    
    @Test
    public void testFindAllByNom() {
        
        // Creation Tigre dans la BD
        TigreDAO.create(new Tigre("Tigrou", 4, "France", true));
        TigreDAO.create(new Tigre("Tigrou", 5, "France", true));
        TigreDAO.create(new Tigre("Woods", 9, "USA", true));
        TigreDAO.create(new Tigre("Sherkan", 9, "USA", true));
        
        
        List<Tigre> tigres = TigreDAO.findAllByName("Tigrou");
        for(Tigre tigre : tigres){
            System.out.println(tigre);
        }
        
        assertEquals(2, tigres.size());
    }
    
    
    @Test
    public void testDeleteById() {
        
         // Creation Tigre dans la BD
        Tigre newTigre = new Tigre("Tigrou", 5, "France", true);
        TigreDAO.create(newTigre);
        Long id = newTigre.getId();
        
        List<Tigre> tigres = TigreDAO.findAll();
        
        // affichage
        for(Tigre tigre : tigres){
            System.out.println(tigre);
        }
        
        int nombreTigres = tigres.size();
        
        // suppression
        TigreDAO.deleteById(id);        
        
        tigres = TigreDAO.findAll();
                
        // affichage
        for(Tigre tigre : tigres){
            System.out.println(tigre);
        }
        
        // assertion
        assertEquals(nombreTigres-1, tigres.size());
        
        //assertion
        assertNull(TigreDAO.findById(id));
    }
    
    
    
    @Test
    public void testDeleteAll() {
        
          // Creation Tigre dans la BD
        TigreDAO.create(new Tigre("Tigrou", 4, "France", true));
        TigreDAO.create(new Tigre("Tigrou", 5, "France", true));
        TigreDAO.create(new Tigre("Woods", 9, "USA", true));
        TigreDAO.create(new Tigre("Sherkan", 9, "USA", true));
        
        TigreDAO.deleteAll();
        
        assertEquals(0, TigreDAO.findAll().size());   
    }
}
