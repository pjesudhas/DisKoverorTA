package controllers;

/**
 * Created by praveen on 14/10/14.
 */

import com.diskoverorta.entities.*;

import edu.stanford.nlp.ling.CoreLabel;
import model.DataContent;
import play.*;
import play.data.*;
import play.mvc.*;
import views.html.*;
import play.mvc.Result;


import java.util.List;



public class InputData extends Controller
{
    private static final Form<DataContent>productForm = Form.form(DataContent.class);

    public static Result getInput()
    {
        return ok(views.html.input.render(Form.form(DataContent.class)));
    }

    public static Result getTaggedOutput()
    {
        Form<DataContent>boundForm = productForm.bindFromRequest();
        DataContent product = boundForm.get();
        EntityManager ex = new EntityManager();
        String str=ex.getALLDocumentEntitiesINJSON(product.rawInput);
        
        //return ok(String.format("Example : %s", ex.getALLDocumentEntitiesINJSON(product.rawInput)));
        
        //JSON.parse(str);
        
       //str=str.replaceAll("\"", "");
        
        return ok(hello.render(str,product.rawInput));
 
         
      
    }
}
