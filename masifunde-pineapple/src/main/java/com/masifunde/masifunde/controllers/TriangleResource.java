package com.masifunde.masifunde.controllers;

import com.masifunde.masifunde.models.Triangle;
import com.masifunde.masifunde.repository.TriangleRepo;
import com.masifunde.masifunde.services.TriangleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="/shapes")
public class TriangleResource {
    @Autowired
    TriangleRepo triangleRepo;

    @Autowired
    TriangleService triangleService;

    @GetMapping
    public List<Triangle> getAll(){
        return triangleRepo.findAll();
    }

    @PostMapping(value = "/add")
    public String postUser(@RequestBody final Triangle triangle){
        triangleRepo.save(triangle);
        //number of rows to be provided by the user
        int rows = triangle.getRowsToPrint();
        //Character to be provided by the user
        String c = triangle.getSymbolToPrint();
        //Output message
        String output = "";
        //the outer loop
        for(int x=0; x<= rows; x++){
            //inner loop for printing space based on number of characters to print vs spaces to replace those characters
            for(int space=rows -x ; space > 1; space--) {
                //print space
                System.out.print(" ");
                output = output + " ";
            }
            //inner loop for printing characters
            for(int j=0; j<=x; j++){
                System.out.print(c + " ");
                output = output + c + " ";

            }
            //print a new line
            System.out.println("");
            output = output + "\n";
        }
        return output;
    }

    @PostMapping(value = "/byName")
    public List<Triangle> getByName(@RequestParam String nameOfShape){
        return triangleRepo.getByNameOfShape(nameOfShape);
    }

    @PostMapping(value = "/bySymbol")
    public List<Triangle> getSymbol(@RequestParam String symbolToPrint){
        return triangleRepo.getBySymbolToPrint(symbolToPrint);
    }

    @PutMapping(value = "/add")
    public ResponseEntity<Triangle> createUpdate(@Valid @RequestBody Triangle triangle){
        return triangleService.saveOrUpdate(triangle);
    }

    @DeleteMapping("/delete/{nameOfShape}")
    public List<Triangle> deleteTriangle(@PathVariable String nameOfShape) {
        Triangle triangle = new Triangle();

        if(!triangleRepo.getByNameOfShape(nameOfShape).isEmpty()){
            List<Triangle> u =triangleRepo.findAll();
            Integer id;

            for(int i=0 ;i<u.size() ; i++)
            {
                String triangleNameOfShape = u.get(i).getNameOfShape();
                System.out.println(triangleNameOfShape +" >>> " + nameOfShape);
                if(nameOfShape.trim().equals(triangleNameOfShape))
                {
                    id=u.get(i).getTriangleId();
                    System.out.println(id);
                    System.out.println(triangleNameOfShape +" is the one");
                    System.out.println("Shape found" + nameOfShape);
                    triangleRepo.deleteById(id);
                }
            }

        }
        else {
            System.out.println("No shape found");
        }
        return triangleRepo.findAll();
    }



}
