package controllers;

/**
 * Created by praveen on 14/10/14.
 */

import model.DataContent;
import play.*;
import play.data.Form;
import play.mvc.*;

import views.html.*;

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


        return ok(String.format("Example : %s", product.rawInput));
    }
}
