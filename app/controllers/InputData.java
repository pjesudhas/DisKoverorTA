package controllers;

/**
 * Created by praveen on 14/10/14.
 */

import api.ApiManager;
import com.diskoverorta.entities.*;

import edu.stanford.nlp.ling.CoreLabel;
import model.DataContent;
import model.RestInput;
import play.*;
import play.data.*;
import play.mvc.*;
import views.html.*;
import play.mvc.Result;


import java.util.List;



public class InputData extends Controller
{
    private static final Form<DataContent>productForm = Form.form(DataContent.class);
    private static final Form<RestInput>restInput = Form.form(RestInput.class);

    public static Result getInput()
    {
        return ok(views.html.input.render(Form.form(DataContent.class)));
    }

    public static Result getAPIInput()
    {
        Form<RestInput>restData = restInput.bindFromRequest();
        RestInput data = restData.get();
        data.loadData();

        ApiManager api = new ApiManager();
        return ok(api.retrieveTextAnalyticsOutput(data));
    }

    public static Result getTaggedOutput()
    {
        Form<DataContent>boundForm = productForm.bindFromRequest();
        DataContent product = boundForm.get();
        RestInput restIp = new RestInput();
        ApiManager api = new ApiManager();

        restIp.analysisSet.add("All");
        restIp.analysis = "All";
        restIp.inputtext = product.rawInput;
        
        
        
        

        return ok(hello.render(api.retrieveTextAnalyticsOutput(restIp),product.rawInput));
        
        //return ok(hello.render("sdsadsa",product.rawInput));
      
        //return ok(api.retrieveTextAnalyticsOutput(restIp));
    }
}
