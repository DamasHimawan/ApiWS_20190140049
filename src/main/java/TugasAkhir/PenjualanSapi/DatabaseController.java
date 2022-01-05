/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasAkhir.PenjualanSapi;

import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author HP
 */

@RestController
@RequestMapping(value = "/Sapi")

/**
 *
 * @author GF63-9SC
 */
@Controller
public class DatabaseController {
    @Autowired
    RepositorySapi repositorySapi;
            
    @PostMapping(value = "/addSapi")
    public Sapi addSapi(@RequestBody Sapi Param)
    {
        repositorySapi.save(Param);
        return Param;
    }
    
    @GetMapping(value = "/allSapi")
    public List<Sapi> allSapi()
    {
        return repositorySapi.findAll();
    }
    
    @PutMapping(value = "/updateSapi")
    public Sapi updateSapi(@RequestBody Sapi Param)
    {
       return repositorySapi.save(Param);
    }
    
    @DeleteMapping(value = "/hapusSapi")
    public List<Sapi> hapusSapi(@RequestParam int id)
    {
        repositorySapi.deleteById(id);
        List<Sapi> Sapilist = repositorySapi.findAll();
        return Sapilist;
    }
}
