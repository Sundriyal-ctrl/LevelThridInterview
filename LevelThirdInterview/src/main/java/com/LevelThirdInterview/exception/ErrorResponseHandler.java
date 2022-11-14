package com.LevelThirdInterview.exception;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ErrorResponseHandler {
   String message;
   List<String> description =new ArrayList<>();

   public ErrorResponseHandler(String message, List<String> description) {
      this.message = message;
      this.description = description;
   }
}
