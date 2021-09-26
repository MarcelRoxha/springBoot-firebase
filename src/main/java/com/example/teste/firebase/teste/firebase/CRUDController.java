package com.example.teste.firebase.teste.firebase;


import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CRUDController {

    public CRUDService crudService;

    public CRUDController(CRUDService crudService){
        this.crudService = crudService;
    }

    @PostMapping("/create")
    public String createCRUD(@RequestBody CRUD crud) throws InterruptedException, Exception{

        return crudService.createCRUD(crud);
    }

    @GetMapping("/get")
    public CRUD getCRUD(@RequestParam String document_id) throws InterruptedException, Exception{

        return crudService.getCRUD(document_id);
    }

    @PutMapping("/update")
    public String updateCRUD(@RequestBody CRUD crud) throws InterruptedException, Exception{

        return crudService.updateCRUD(crud);
    }

    @PutMapping("/delete")
    public String deleteCRUD(@RequestParam String document_id) throws InterruptedException, Exception{

        return crudService.deleteCRUD(document_id);
    }

    @GetMapping("/teste")
    public ResponseEntity<String> testeGetEndpoint(){return ResponseEntity.ok("Teste Get End point is working");}



}
