package com.Inazuma.learn.controller;

import com.Inazuma.learn.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @RequestMapping(
//            value = "/users",                             // value is same as path: both use for end points
            method = RequestMethod.GET,
            params = {"version=1", "role"},
            headers = {"X-API-VERSION", "X-API-v2"},        // if we set headers, then it should be in request, else 404 error.
            consumes = "application/json"                   /*MediaType.MULTIPART_FORM_DATA_VALUE*/,
            produces = "application/json"
    )
    public void getProductDetail(
            @RequestParam int version,
            @RequestHeader(value = "X-API-VERSION" , required = false, defaultValue = "X-API-VERSION=0") int apiv1,
            @RequestHeader("X-API-v2") int apiv2,
            @RequestParam Map<String, String> queryParams,
            @RequestHeader Map<String, String> allheaders
    ){
        System.out.println(version);
        System.out.println(apiv1);
        System.out.println(apiv2);
        System.out.println(queryParams);
        System.out.println(allheaders);
//        System.out.println("Hello world");
    }



    @GetMapping(value = "/{productID}/reviews/{reviewID}" )
    public void getMyProduct(@PathVariable int productID, @PathVariable int reviewID) {
        System.out.println(productID + "    "+ reviewID);
    }

    @GetMapping(path = {"/order", "/members"}, params = "type=admin")
    public void multiplePath(){
        System.out.println("Has type param");
        System.out.println("Multiple path method called");
    }

    @PostMapping("/{myid}/version/{versionid}")
    public void addProduct(@RequestBody Product product, @PathVariable int myid, @PathVariable int versionid){
        System.out.println(myid);
        System.out.println(versionid);
        System.out.println(product);
        System.out.println(product.getProductIngredients());
        Map<String, String> otherDetails = product.getOtherDetails();
        otherDetails.forEach((key,value)->{
            System.out.println(key+ " -> "+ value);
        });

    }


    @GetMapping("/get")
    public void get(){
        System.out.println("Get method");
    }
    @PostMapping("/post")
    public void post(){
        System.out.println("Post method");
    }
    @PutMapping("/put")
    public void put(){
        System.out.println("put method");
    }

//    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(){
        System.out.println("delete method");
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PatchMapping("/patch")
    public void patch(){
        System.out.println("Patch method");
    }



}
